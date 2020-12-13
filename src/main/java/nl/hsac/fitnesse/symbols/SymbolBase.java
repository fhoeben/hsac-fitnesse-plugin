package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Maybe;
import fitnesse.wikitext.parser.Parser;
import fitnesse.wikitext.parser.Symbol;
import fitnesse.wikitext.parser.SymbolType;

import java.util.List;

public class SymbolBase extends SymbolType {
    protected SymbolBase(String name) {
        super(name);
    }

    protected Maybe<Symbol> storeParenthesisContent(Symbol current, Parser parser, String key) {
        Maybe<Symbol> result = new Maybe<Symbol>(current);
        List<Symbol> lookAhead = parser.peek(new SymbolType[] { SymbolType.Whitespace, SymbolType.OpenParenthesis });
        if (lookAhead.size() != 0) {
            parser.moveNext(2);
            Maybe<String> format = parser.parseToAsString(SymbolType.CloseParenthesis);
            if (format.isNothing()) {
                result = Symbol.nothing;
            }
            current.putProperty(key, format.getValue());
        }
        return result;
    }

    protected int getProperty(Symbol symbol, String key, int defaultValue) {
        int result = defaultValue;
        String property = symbol.findProperty(key, null);
        if (property != null) {
            result = parseInt(property);
        }
        return result;
    }

    protected int parseInt(String strValue) {
        return Integer.parseInt(strValue.trim());
    }
}
