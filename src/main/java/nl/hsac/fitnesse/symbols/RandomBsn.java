package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Matcher;
import fitnesse.wikitext.parser.Symbol;
import fitnesse.wikitext.parser.SymbolType;
import fitnesse.wikitext.parser.Translation;
import fitnesse.wikitext.parser.Translator;
import nl.hsac.fitnesse.util.BsnUtil;

/**
 * Symbol that creates a random BSN for use in tests.
 * Usage: !randomBSN
 *
 * To be able to use it, please ensure the class name is added to the list of SymbolTypes in
 * plugins.properties
 */
public class RandomBsn extends SymbolType implements Translation {
    private static final BsnUtil BSN_UTIL = new BsnUtil();

    public RandomBsn() {
        super("RandomBSN");
        wikiMatcher(new Matcher().string("!randomBSN"));
        htmlTranslation(this);
    }

    public String toTarget(Translator translator, Symbol symbol) {
        return BSN_UTIL.generateBsn();
    }
}
