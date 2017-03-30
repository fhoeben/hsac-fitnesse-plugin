package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.*;
import nl.hsac.fitnesse.util.RandomUtil;

/**
 * Generates random string consisting of the supplied characters.
 * Usage: !randomString [(length) [(characters) [(prefix)]]]
 * The usage of parentheses around the parameters is because I could not get it to work otherwise. :-)
 */
public class RandomEmail extends SymbolBase implements Rule, Translation {
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();
    private static final String MIN_MAX_LENGTH = "Length";
    private static final String DOMAIN = "Domainname";
    private static final String DEFAULT_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "1234567890" +
            "1234567890";

    public RandomEmail() {
        super("RandomString");
        wikiMatcher(new Matcher().string("!randomString"));
        wikiRule(this);
        htmlTranslation(this);
    }

    public Maybe<Symbol> parse(Symbol current, Parser parser) {
        Maybe<Symbol> result = storeParenthesisContent(current, parser, MIN_MAX_LENGTH);
        if (!result.isNothing()) {
            result = storeParenthesisContent(current, parser, DOMAIN);
        }
        return result;
    }


    public String toTarget(Translator translator, Symbol symbol) {
        String param = symbol.getProperty(MIN_MAX_LENGTH, null);
        String domain = symbol.getProperty(DOMAIN, "");
        int length = getEmailLength(param, domain);
        String localPart = getRandomLocalPart(length);
        return localPart + "@" + domain;
    }

    public static String getRandomLocalPart(int length) {
        String permitted = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "1234567890!#$%&'*+-/=?^_`{|}~.";
        return RANDOM_UTIL.randomString(permitted, length);
    }

    private int getEmailLength(String param, String prefix) {
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
            int domainLength = prefix.length();
            if (domainLength >= minimalLength) {
                throw new IllegalArgumentException("The domain is the same size or longer than the requested (minimal) string length");
            }

            int maximalLength = minimalLength;
            if (values.length > 1) {
                maximalLength = parseInt(values[1]);
            }
            length = getRandomLength(minimalLength, maximalLength) - domainLength;
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

