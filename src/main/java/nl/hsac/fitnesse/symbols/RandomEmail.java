package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.*;
import nl.hsac.fitnesse.util.RandomDomain;
import nl.hsac.fitnesse.util.RandomUtil;

/**
 * Generates random email adress consisting of the maximum length and domain supplied.
 * A random generated domain will always consist of two characters, disregarding the handful of single letter domains in excistence.
 * Usage: !randomEmail [(maxlength) [(domain)]]
 * The usage of parentheses around the parameters is because I could not get it to work otherwise. :-)
 */
public class RandomEmail extends SymbolBase implements Rule, Translation {
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();
    private static final RandomDomain RANDOM_DOMAIN = new RandomDomain();
    private static final String MAX_LENGTH = "Length";
    private static final String DOMAIN = "Domainname";
    private static final int MIN_EMAIL_LENGTH = 7;

    public RandomEmail() {
        super("RandomEmail");
        wikiMatcher(new Matcher().string("!randomEmail"));
        wikiRule(this);
        htmlTranslation(this);
    }

    public Maybe<Symbol> parse(Symbol current, Parser parser) {
        Maybe<Symbol> result = storeParenthesisContent(current, parser, MAX_LENGTH);
        if (!result.isNothing()) {
            result = storeParenthesisContent(current, parser, DOMAIN);
        }
        return result;
    }


    public String toTarget(Translator translator, Symbol symbol) {
        String maxLength = symbol.getProperty(MAX_LENGTH, null);
        String domain = symbol.getProperty(DOMAIN, "");

        if (parseInt(maxLength) < MIN_EMAIL_LENGTH) {
            throw new IllegalArgumentException("An email address has a minimal length of " + MIN_EMAIL_LENGTH + " characters");
        }

        if (domain.length() > 0) { //meaning a domain is given
            return getRandomLocalAddress(getEmailRandomPartLength(maxLength, domain)) + "@" + domain;
        } else { //meaning no domain is given
            int[] randomSplit = RANDOM_UTIL.getRandomSplit(parseInt(MAX_LENGTH) - 5);//the @ will be taken from the second value before a random domain is made
            String localAddress = getRandomLocalAddress(randomSplit[0]);
            String randomDomain = RANDOM_DOMAIN.generateFullDomain(randomSplit[1] - 1);//removing one character that will be the @
            return localAddress + "@" + randomDomain;
        }
    }

    //This method returns the maximal length of the randomized string, based on the max length and domain length
    private int getEmailRandomPartLength(String maxLength, String domain) {
        int emailRandomLength;

        if (maxLength == null) {
            emailRandomLength = RANDOM_UTIL.random(93) + MIN_EMAIL_LENGTH; //adding minLength here as the minimal length of an email address is 7 characters
        } else {
            int maxlength = parseInt(maxLength);
            int domainLength = domain.length();

            if (maxlength < 0) {
                throw new IllegalArgumentException("You cannot use a negative value here, we cannot make a string of negative length");
            }

            if (domainLength >= maxlength + 2) {  //the +2 is to ensure the @ and one random character in the address are counted towards minimal
                throw new IllegalArgumentException("The domain with @ is the same size or longer than the requested (maximal) string length");
            }

            emailRandomLength = RANDOM_UTIL.random(maxlength - domainLength);

        }

        return emailRandomLength;
    }

    private static String getRandomLocalAddress(int localAddressLength) {
        String permitted = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "1234567890!#$%&'*+-/=?^_`{|}~.";
        return RANDOM_UTIL.randomString(permitted, localAddressLength);
    }

}

