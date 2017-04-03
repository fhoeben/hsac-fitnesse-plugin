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
        return randomEmail(maxLength, domain);
    }

    public String randomEmail(String inputLength, String domain) {

        int maxLength;
        if (inputLength == null) {
            maxLength = 100;
        } else {
            maxLength = parseInt(inputLength);
        }

        if (maxLength < MIN_EMAIL_LENGTH) {
            throw new IllegalArgumentException("An email address has a minimal length of " + MIN_EMAIL_LENGTH + " characters");
        }

        if (domain.length() > 0) { //meaning a domain is given
            if (domain.length() < 5) {
                throw new IllegalArgumentException("A domainname consists of at least 5 characters");
            }
            return getRandomLocalAddress(getEmailRandomPartLength(inputLength, domain)) + "@" + domain;
        } else { //meaning no domain is given
            int emailRandomLength = maxLength - MIN_EMAIL_LENGTH;
            emailRandomLength = RANDOM_UTIL.random(emailRandomLength) + MIN_EMAIL_LENGTH;
            int[] randomSplit = RANDOM_UTIL.getRandomSplit(emailRandomLength - 5); //minimal top level domain length
            String localAddress = getRandomLocalAddress(randomSplit[0]);
            String randomDomain = RandomDomain.generateFullDomain(RANDOM_DOMAIN, randomSplit[1] + 4);//removing one character that will be the @
            return localAddress + "@" + randomDomain;
        }

    }

    //This method returns the maximal length of the randomized string, based on the max length and domain length
    public int getEmailRandomPartLength(String maxLength, String domain) {
        int emailRandomLength;
        int maxlength = parseInt(maxLength);
        int domainLength = domain.length();

        if (maxlength < 0) {
            throw new IllegalArgumentException("You cannot use a negative value here, we cannot make a string of negative length");
        }

        if (domainLength + 1 >= maxlength) {  //the +2 is to ensure the @ in the address IS counted towards minimal length
            throw new IllegalArgumentException("The domain with @ is the same size or longer than the requested (maximal) string length");
        }

        emailRandomLength = RANDOM_UTIL.random(maxlength - domainLength - 1) + 1; //-1 for @, +1 for minimal emaillength

        return emailRandomLength;
    }

    public static String getRandomLocalAddress(int localAddressLength) {
        String permitted = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "1234567890!#$%&'*+-/=?^_`{|}~.";
        if (localAddressLength == 0) {
            throw new IllegalArgumentException("Zero is a bad length for a local email address");

        }
        return RANDOM_UTIL.randomString(permitted, localAddressLength);
    }

}

