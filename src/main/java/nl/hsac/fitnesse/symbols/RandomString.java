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
        String param = symbol.getProperty(MIN_MAX_LENGTH, null);
        String permitted = symbol.getProperty(CHARACTERS, DEFAULT_CHARS);
        String prefix = symbol.getProperty(PREFIX, "");
        int length = getRandomStringLength(param, prefix);
        return prefix + RANDOM_UTIL.randomString(permitted, length);
    }

    public int getRandomStringLength(String param, String prefix) {
        int randomStringLength;
        int minimalLength;
        int maximalLength;
        int prefixLength;

        //Handle the prefix input parameter
        if (prefix == "") {
            prefixLength = 0;
        } else {
            prefixLength = prefix.length();
        }

        // Handle the length input parameter
        if (param == null) { //if there is no parameter, use the default
            randomStringLength = RANDOM_UTIL.random(100);
        } else if (!param.contains(",")) { //no comma in the parameter, just parse directly to requestedLength
            int requestedLength = parseInt(param);
            if (prefixLength > requestedLength) {
                throw new IllegalArgumentException("The prefix is longer than the requested string length");
            }
            int randomBase = parseInt(param) - prefixLength;
            randomStringLength = RANDOM_UTIL.random(randomBase);
        } else { // if there is a comma, there must be range
            String[] values = param.split(","); //any values after the first two are ignored
            minimalLength = parseInt(values[0]);
            maximalLength = parseInt(values[1]);

            if (minimalLength < 0) {
                throw new IllegalArgumentException("You cannot use a negative value here, nobody wants a negative string");
            }
            if (maximalLength < minimalLength) {
                throw new IllegalArgumentException("Ensure the Max value is higher then the Min value");
            }
            if (prefixLength > minimalLength) {
                throw new IllegalArgumentException("The prefix is longer than the requested minimal string length");
            }

            int randomBase = maximalLength - minimalLength;
            int randomValue = RANDOM_UTIL.random(randomBase);
            randomStringLength = randomValue + minimalLength - prefixLength;

        }
        return randomStringLength;
    }
}
