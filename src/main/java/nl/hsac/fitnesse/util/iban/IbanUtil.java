package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;


/**
 * To select a country and parse the iban request to the proper class
 */
public class IbanUtil {
    private final RandomUtil RANDOM_UTIL = new RandomUtil();
    private String iban = "";

    public String generateIban(String country, String bankCode) {

        if (country.equals("")) {
            country = RANDOM_UTIL.randomElement(countryCodes);
        }

        switch (country) {
            case "NL":
                NLIban nlIban = new NLIban();
                iban = nlIban.generateNLIban(country, bankCode);
                return iban;
            default:
                throw new IllegalArgumentException("This country code is unknown");
        }
    }


    private String[] countryCodes = {
            "NL"
    };

}
