package nl.hsac.fitnesse.util;

import com.mifmif.common.regex.Generex;

public class RandomPostalCodeGenerator {

    public String getRandomPostalCodeString(String countryCode) {
        String result;
        switch (countryCode) {
            case "AU":
                result = randomRegexString("\\d{4}");
                break;
            case "BE":
                result = randomRegexString("[1-9]\\d{3}");
                break;
            case "BR":
                result = randomRegexString("\\d{5}-?\\d{3}");
                break;
            case "CA":
                result = randomRegexString("[A-Z]\\d[A-Z][ -]?\\d[A-Z]\\d");
                break;
            case "CH":
                result = randomRegexString("[1-9]\\d{3}");
                break;
            case "DE":
                result = randomRegexString("\\d{5}");
                break;
            case "DK":
                result = randomRegexString("[1-24-9]\\d{3}|3[0-8]\\d{2}");
                break;
            case "ES":
                result = randomRegexString("(0[1-9]|[1-4]\\d|5[0-2])\\d{3}");
                break;
            case "GL":
                result = randomRegexString("39\\d{2}");
                break;
            case "FR":
                result = randomRegexString("([0-8]\\d|9[0-8])\\d{3}");
                break;
            case "IT":
                result = randomRegexString("\\d{5}");
                break;
            case "NL":
                result = randomRegexString("[1-9]\\d{3}([A-EGHJ-NPRTVWXZ][A-EGHJ-NPRSTVWXZ]|S[BCEGHJ-NPRTVWXZ])");
                break;
            case "NO":
                result = randomRegexString("\\d{4}");
                break;
            case "UK":
                result = randomRegexString("([A-Z]{1,2}\\d{1,2}[A-Z]?)(\\d[A-Z]{2})");
                break;
            case "US":
                result = randomRegexString("(\\d{5})(-\\d{4})?");
                break;
            default:
                result = "This country code is not available for random postal code generation";
        }
        return result;
    }

    private String randomRegexString(String regex) {
        Generex generex = new Generex(regex);
        return generex.random();
    }


}

