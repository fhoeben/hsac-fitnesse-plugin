package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.*;
import nl.hsac.fitnesse.util.RandomUtil;

/**
 * Generates random email adress consisting of the maximum length and domain supplied.
 * A random generated domain will always consist of two characters, disregarding the handful of single letter domains in excistence.
 * Usage: !randomEmail [(maxlength) [(domain)]]
 * The usage of parentheses around the parameters is because I could not get it to work otherwise. :-)
 */
public class RandomEmail extends SymbolBase implements Rule, Translation {
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();
    private static final String MAX_LENGTH = "Length";
    private static final String DOMAIN = "Domainname";

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
        //int length = getEmailRandomPartLength(maxLength, domain);
        //String localPart = getRandomLocalPart(length);
        //return localPart + "@" + domain;
    }

    private int getEmailRandomPartLength(String maxLength, String domain) {
        int emailRandomLength;
        int emailMinLength = 7;

        if (maxLength == null) {
            emailRandomLength = RANDOM_UTIL.random(93) + emailMinLength; //adding minLength here as the minimal length of an email address is 7 characters
        } else {
            int maxlength = parseInt(maxLength);
            int domainLength = domain.length();

            if (maxlength < 0) {
                throw new IllegalArgumentException("You cannot use a negative value here, we cannot make a string of negative length");
            }

            if (maxlength < emailMinLength) {
                throw new IllegalArgumentException("An email address has a minimal length of " + emailMinLength + " characters");
            }

            if (domainLength >= maxlength +2) {  //the +2 is to ensure the @ and one random character in the address are counted towards minimal
                throw new IllegalArgumentException("The domain with @ is the same size or longer than the requested (maximal) string length");
            }

            emailRandomLength = RANDOM_UTIL.random(maxlength-domainLength);

        }

        return emailRandomLength;
    }


    private int getRandomEmail(String emailMaxLength, String domain) {

        //first determine what length your emailaddress should get

        //Step 1: remove the minimal domain name plus @ sign (6 characters) from the max length
        // the remaining characters will be randomly divided to make the local-address and the domain name
        int randomLength = maxlength - 6;

        //Step 2: When a domain is set, move to step 3
        // If not so, make a random split in the random length allocating both parts some length
        if (domainLength == 0) {

        }
        int localAddressLength = RANDOM_UTIL.random(randomLength);
        int randomDomainLength = randomLength - localAddressLength;


        emailMaxLength = getRandomLength(maxlength, maximalLength) - domainLength;

    }


    private static String getRandomLocalPart(int length) {
        String permitted = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "1234567890!#$%&'*+-/=?^_`{|}~.";
        return RANDOM_UTIL.randomString(permitted, length);
    }

}

