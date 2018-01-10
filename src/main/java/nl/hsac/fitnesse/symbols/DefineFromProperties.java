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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
                File f = new File(param);
                if (f.exists()) {
                    if (f.isFile() && f.canRead()) {
                        processPropertiesFile(current, parser, f);
                    } else {
                        current.putProperty(ERROR, "Unable to read: " + f.getAbsolutePath());
                    }
                } else {
                    current.putProperty(ERROR, f.getAbsolutePath() + " does not exist");
                }
            }
        }
        return result;
    }

    private void processPropertiesFile(Symbol current, Parser parser, File f) {
        Properties props = new Properties();
        try (InputStreamReader iS = new InputStreamReader(new FileInputStream(f), UTF8)) {
            props.load(iS);
            for (String variableName : props.stringPropertyNames()) {
                String variableValue = props.getProperty(variableName);
                parser.getPage().putVariable(variableName, variableValue);

                Symbol row = new Symbol(SymbolType.SymbolList);
                row.add(variableName).add(variableValue);
                current.add(row);
            }
        } catch (IOException e) {
            current.putProperty(ERROR, e.toString());
        }
    }

    @Override
    public String toTarget(Translator translator, Symbol symbol) {
        String result = "Please supply filename of .properties file, between parentheses";
        String file = symbol.getProperty(FILE_NAME, null);
        if (file == null) {
            result = createSpanWithError(result);
        } else {
            File f = new File(file);
            String error = symbol.getProperty(ERROR, null);
            if (error != null) {
                result = createSpanWithError(error);
            } else {
                result = toTarget(f, translator, symbol);
            }
        }
        return result;
    }

    private String toTarget(File propertiesFile, Translator translator, Symbol symbol) {
        HtmlTag table = new HtmlTag("table");
        addMetaClass(table);
        createHeaderRow(propertiesFile, table);
        for (Symbol child : symbol.getChildren()) {
            createPropertyRow(translator, child, table);
        }
        return table.html();
    }

    private void createHeaderRow(File propertiesFile, HtmlTag table) {
        HtmlTag headerRow = addRow(table);
        HtmlTag headingCell = new HtmlTag("td");
        headingCell.addAttribute("colspan", "2");
        headingCell.add(new HtmlText("variables defined"));
        HtmlTag span = new HtmlTag("span");
        span.add(new HtmlText("(by " + propertiesFile.getAbsolutePath() + ")"));
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
