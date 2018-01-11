package nl.hsac.fitnesse.symbols;

import fitnesse.html.HtmlTag;
import fitnesse.html.HtmlText;
import fitnesse.wikitext.parser.Matcher;
import fitnesse.wikitext.parser.Maybe;
import fitnesse.wikitext.parser.Parser;
import fitnesse.wikitext.parser.Rule;
import fitnesse.wikitext.parser.Symbol;
import fitnesse.wikitext.parser.SymbolType;
import fitnesse.wikitext.parser.Translation;
import fitnesse.wikitext.parser.Translator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Symbol to define wiki variables based on a .properties file.
 * When unable to find the file no variables will be defined.
 */
public class DefineFromProperties extends SymbolBase implements Rule, Translation {
    private static final Charset UTF8 = Charset.forName("utf-8");

    private static final String FILE_NAME = "FileName";
    private static final String ERROR = "PropertyFileReadError";

    public DefineFromProperties() {
        super("DefineFromProperties");
        wikiMatcher(new Matcher().startLineOrCell().string("!defineFromProperties"));
        wikiRule(this);
        htmlTranslation(this);
    }

    @Override
    public Maybe<Symbol> parse(Symbol current, Parser parser) {
        Maybe<Symbol> result = storeParenthesisContent(current, parser, FILE_NAME);
        if (!result.isNothing()) {
            String param = current.getProperty(FILE_NAME, null);
            if (param != null) {
                try {
                    URL url = resolveParamToURL(param);
                    current.putProperty(FILE_NAME, url.toString());
                    processPropertiesFile(current, parser, url);
                } catch (IllegalArgumentException|IOException e) {
                    current.putProperty(ERROR, e.toString());
                }
            }
        }
        return result;
    }

    private URL resolveParamToURL(String param) {
        URL url;
        File f = new File(param);
        if (f.exists()) {
            if (f.isFile() && f.canRead()) {
                try {
                    url = f.toURI().toURL();
                } catch (MalformedURLException e) {
                    throw new IllegalArgumentException(e);
                }
            } else {
                throw new IllegalArgumentException("Unable to read: " + f.getAbsolutePath());
            }
        } else {
            URL classPathFile = getClass().getClassLoader().getResource(param);
            if (classPathFile == null) {
                try {
                    url = new URL(param);
                } catch (MalformedURLException e) {
                    throw new IllegalArgumentException(f.getAbsolutePath() + " does not exist, and no resource on classpath: " + param);
                }
            } else {
                url = classPathFile;
            }
        }
        return url;
    }

    private void processPropertiesFile(Symbol current, Parser parser, URL url) throws IOException {
        Properties props = new Properties();
        try (Reader iS = new BufferedReader(new InputStreamReader(url.openStream(), UTF8))) {
            props.load(iS);
            for (String variableName : props.stringPropertyNames()) {
                String variableValue = props.getProperty(variableName);
                parser.getPage().putVariable(variableName, variableValue);

                Symbol row = new Symbol(SymbolType.SymbolList);
                row.add(variableName).add(variableValue);
                current.add(row);
            }
        }
    }

    @Override
    public String toTarget(Translator translator, Symbol symbol) {
        String result = "Please supply filename of .properties file (either local file or on classpath), between parentheses";
        String file = symbol.getProperty(FILE_NAME, null);
        if (file == null) {
            result = createSpanWithError(result);
        } else {
            String error = symbol.getProperty(ERROR, null);
            if (error != null) {
                result = createSpanWithError(error);
            } else {
                result = toTarget(file, translator, symbol);
            }
        }
        return result;
    }

    private String toTarget(String propertiesFileUrl, Translator translator, Symbol symbol) {
        HtmlTag table = new HtmlTag("table");
        addMetaClass(table);
        createHeaderRow(propertiesFileUrl, table);
        for (Symbol child : symbol.getChildren()) {
            createPropertyRow(translator, child, table);
        }
        return table.html();
    }

    private void createHeaderRow(String propertiesFileUrl, HtmlTag table) {
        HtmlTag headerRow = addRow(table);
        HtmlTag headingCell = new HtmlTag("td");
        headingCell.addAttribute("colspan", "2");
        headingCell.add(new HtmlText("variables defined"));
        HtmlTag span = new HtmlTag("span");
        span.add(new HtmlText("(by " + propertiesFileUrl + ")"));
        headingCell.add(span);
        headerRow.add(headingCell);
    }

    private void createPropertyRow(Translator translator, Symbol child, HtmlTag table) {
        HtmlTag row = addRow(table);
        HtmlTag nameCell = new HtmlTag("th", translate(translator, child.childAt(0)));
        row.add(nameCell);
        HtmlTag valueCell = new HtmlTag("td", translate(translator, child.childAt(1)));
        row.add(valueCell);
    }

    private String translate(Translator translator, Symbol child) {
        return translator.translate(child);
    }

    private HtmlTag addRow(HtmlTag table) {
        HtmlTag row = new HtmlTag("tr");
        table.add(row);
        return row;
    }

    private String createSpanWithError(String resultMsg) {
        HtmlTag result = new HtmlTag("span", resultMsg);
        addMetaClass(result);
        return result.html();
    }

    private void addMetaClass(HtmlTag table) {
        table.addAttribute("class", "meta");
    }
}
