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
    private static final String MIN_MAX_LENGTH = "Length";
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
        Maybe<Symbol> result = storeParenthesisContent(current, parser, MIN_MAX_LENGTH);
        if (!result.isNothing()) {
            result = storeParenthesisContent(current, parser, CHARACTERS);
            if (!result.isNothing()) {
                result = storeParenthesisContent(current, parser, PREFIX);
            }
        }
        return result;
    }

    public String toTarget(Translator translator, Symbol symbol) {
        String param = symbol.findProperty(MIN_MAX_LENGTH, null);
        String permitted = symbol.findProperty(CHARACTERS, DEFAULT_CHARS);
        String prefix = symbol.findProperty(PREFIX, "");
        int length = getStringLength(param, prefix);
        return prefix + RANDOM_UTIL.randomString(permitted, length);
    }

    int getStringLength(String param, String prefix) {
        int length;

        if (param == null) {
            length = RANDOM_UTIL.random(100);
        } else {
            String[] values = param.split(","); //any values after the first two are ignored

            int minimalLength = parseInt(values[0]);
            if (minimalLength < 0) {
                throw new IllegalArgumentException("You cannot use a negative value here, we cannot make a string of negative length");
            }

            //Handle the prefix input parameter
            int prefixLength = prefix.length();
            if (prefixLength > minimalLength) {
                throw new IllegalArgumentException("The prefix is longer than the requested (minimal) string length");
            }

            int maximalLength = minimalLength;
            if (values.length > 1) {
                maximalLength = parseInt(values[1]);
            }
            if (minimalLength == prefixLength && maximalLength == prefixLength) {
                throw new IllegalArgumentException("The requested length is same as prefix length, you don't need a random value");
            }
            length = getRandomLength(minimalLength, maximalLength) - prefixLength;
        }

        return length;
    }

    private int getRandomLength(int minimalLength, int maximalLength) {
        if (maximalLength < minimalLength) {
            throw new IllegalArgumentException("Ensure the Max value is higher then the Min value");
        }
        int randomRange = maximalLength - minimalLength + 1;
        int randomLength = RANDOM_UTIL.random(randomRange) + minimalLength;
        return randomLength;
    }
}

