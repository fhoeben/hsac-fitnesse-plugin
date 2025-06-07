package nl.hsac.fitnesse.symbols;

import fitnesse.html.HtmlTag;
import fitnesse.wikitext.parser.Matcher;
import fitnesse.wikitext.parser.Maybe;
import fitnesse.wikitext.parser.Parser;
import fitnesse.wikitext.parser.Rule;
import fitnesse.wikitext.parser.ScanString;
import fitnesse.wikitext.parser.Symbol;
import fitnesse.wikitext.parser.SymbolType;
import fitnesse.wikitext.parser.Translation;
import fitnesse.wikitext.parser.Translator;

import java.util.Optional;

/**
 * Defines a variable value that will only be used if there is no system property with the same name.
 */
public class DefineDefault extends SymbolType implements Rule, Translation {
    public DefineDefault() {
        super("DefineDefault");
        wikiMatcher(new Matcher().startLineOrCell().string("!defineDefault"));
        wikiRule(this);
        htmlTranslation(this);
    }

    @Override
    public Maybe<Symbol> parse(Symbol current, Parser parser) {
        if (!parser.isMoveNext(SymbolType.Whitespace)) return Symbol.nothing;

        Maybe<String> name = parser.parseToAsString(SymbolType.Whitespace);
        if (name.isNothing()) return Symbol.nothing;
        String variableName = name.getValue();
        if (!ScanString.isVariableName(variableName)) return Symbol.nothing;

        String variableValue = System.getProperty(variableName);

        // remove definition in wiki page
        Symbol next = parser.moveNext(1);
        Maybe<String> valueString = (next.isType(SymbolType.Text))
                ? copyVariableValue(parser, next)
                : parseVariableValue(parser, next);

        if (variableValue == null) {
            if (valueString.isNothing()) return Symbol.nothing;

            variableValue = valueString.getValue();
        } else {
            if (variableValue.startsWith("\"")
                    && variableValue.endsWith("\"")) {
                variableValue = variableValue.substring(1, variableValue.length() - 1);
            }
        }

        parser.getPage().putVariable(variableName, variableValue);
        return new Maybe<Symbol>(current.add(variableName).add(variableValue));
    }

    private Maybe<String> copyVariableValue(Parser parser, Symbol next) {
        String fromVariableName = next.getContent();
        if (!ScanString.isVariableName(fromVariableName)) return Maybe.noString;
        Optional<String> copiedValue = parser.getVariableSource().findVariable(fromVariableName);
        return copiedValue.map(Maybe::new).orElseGet(() -> Maybe.nothingBecause("variable not present"));
    }

    private Maybe<String> parseVariableValue(Parser parser, Symbol next) {
        SymbolType nextType = next.getType();

        // for backward compatibility: !define x<eof> is valid
        if (nextType == SymbolType.Empty) return new Maybe<>("");

        if (nextType == SymbolType.OpenBrace) return parser.parseToAsString(SymbolType.CloseBrace);
        if (nextType == SymbolType.OpenBracket) return parser.parseToAsString(SymbolType.CloseBracket);
        if (nextType == SymbolType.OpenParenthesis) return parser.parseToAsString(SymbolType.CloseParenthesis);

        return Maybe.noString;
    }

    @Override
    public String toTarget(Translator translator, Symbol symbol) {
        HtmlTag result = new HtmlTag("span", "variable defined: "
                + translator.translate(symbol.childAt(0))
                + "="
                + translator.translate(symbol.childAt(1)));
        result.addAttribute("class", "meta");
        return result.html();
    }
}
