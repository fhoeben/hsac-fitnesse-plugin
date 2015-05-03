package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Matcher;
import fitnesse.wikitext.parser.Maybe;
import fitnesse.wikitext.parser.Parser;
import fitnesse.wikitext.parser.Rule;
import fitnesse.wikitext.parser.Symbol;
import fitnesse.wikitext.parser.Translation;
import fitnesse.wikitext.parser.Translator;
import nl.hsac.fitnesse.util.RandomUtil;

/**
 * Generates random string consisting of the supplied characters.
 * Usage: !randomString [(length) [(characters) [(prefix)]]]
 * The usage of parentheses around the parameters is because I could not get it to work otherwise. :-)
 */
public class RandomString extends SymbolBase implements Rule, Translation {
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();
    private static final String CHARACTERS = "Characters";
    private static final String LENGTH = "Length";
    private static final String PREFIX = "Prefix";
    private static final String DEFAULT_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
                                                + "-=_+[]{};':|\\,./<>ëïä?!@#$%^&*§±`~€Ω≈ç√∫~≤≥åß∂ƒ©˙∆˚¬…æ«πø¥†®´∑œ£¢∞§¶";

    public RandomString() {
        super("RandomString");
        wikiMatcher(new Matcher().string("!randomString"));
        wikiRule(this);
        htmlTranslation(this);
    }

    public Maybe<Symbol> parse(Symbol current, Parser parser) {
        Maybe<Symbol> result = storeParenthesisContent(current, parser, LENGTH);
        if (!result.isNothing()) {
            result = storeParenthesisContent(current, parser, CHARACTERS);
            if (!result.isNothing()) {
                result = storeParenthesisContent(current, parser, PREFIX);
            }
        }
        return result;
    }

    public String toTarget(Translator translator, Symbol symbol) {
        String permitted = symbol.getProperty(CHARACTERS, DEFAULT_CHARS);
        int length = getProperty(symbol, LENGTH, -1);
        String prefix = symbol.getProperty(PREFIX, "");
        length = length - prefix.length();
        if (length < 1) {
            length = RANDOM_UTIL.random(100);
        }
        return prefix + RANDOM_UTIL.randomString(permitted, length);
    }
}
