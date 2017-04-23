package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;


/**
 * To select a country and parse the iban request to the proper class
 */
public class IbanGenerator {
    protected final static RandomUtil RANDOM_UTIL = new RandomUtil();

    public String generateIban(String country, String bankCode) {
        if (country.equals("")) {
            country = RANDOM_UTIL.randomElement(COUNTRY_CODES);
        }


        switch (country) {
            case "AT":
                return new ATIbanGenerator().generateIban(bankCode);
            case "BE":
                return new BEIbanGenerator().generateIban(bankCode);
            case "BG":
                return new BGIbanGenerator().generateIban(bankCode);
            case "CH":
                return new CHIbanGenerator().generateIban(bankCode);
            case "CY":
                return new CYIbanGenerator().generateIban(bankCode);
            case "CZ":
                return new CZIbanGenerator().generateIban(bankCode);
            case "DE":
                return new DEIbanGenerator().generateIban(bankCode);
            case "DK":
                return new DKIbanGenerator().generateIban(bankCode);
            case "EE":
                return new EEIbanGenerator().generateIban(bankCode);
            case "ES":
                return new ESIbanGenerator().generateIban(bankCode);
            case "FI":
                return new FIIbanGenerator().generateIban(bankCode);
            case "FR":
                return new FRIbanGenerator().generateIban(bankCode);
            case "GB":
                return new GBIbanGenerator().generateIban(bankCode);
            case "GI":
                return new GIIbanGenerator().generateIban(bankCode);
            case "GR":
                return new GRIbanGenerator().generateIban(bankCode);
            case "HR":
                return new HRIbanGenerator().generateIban(bankCode);
            case "LU":
                return new LUIbanGenerator().generateIban(bankCode);
            case "NL":
                return new NLIbanGenerator().generateIban(bankCode);
            default:
                throw new IllegalArgumentException("The given country code " + country + " is not (yet) implemented");
        }
    }

    final static String[] COUNTRY_CODES = {
            "AT",     //Austria
            "BE",   //Belgium
            "BG",   //Bulgaria
            "CH",   //Switzerland
            "CY",   //Cyprus
            "CZ",   //Czech Republic
            "DE",   //Germany
            "DK",   //Denmark
            "EE",   //Estonia
            "ES",   //Spain
            "FI",   //Finland
            "FR",   //France
            "GB",   //United Kingdom
            "GI",   //Gibraltar
            "GR",   //Greece
            "HR",   //Croatia
//            "HU",   //Hungary
//            "IE",   //Ireland
//            "IS",   //Iceland
//            "IT",   //Italy
//            "LI",   //Liechtenstein
//            "LT",   //Lithuania
            "LU",   //Luxembourg
//            "LV",   //Latvia
//            "MC",   //Monaco
//            "MT",   //Malta
            "NL",   //Netherlands
//            "NO",   //Norway
//            "PL",   //Poland
//            "PT",   //Portugal
//            "RO",   //Romania
//            "SE",   //Sweden
//            "SI",   //Slovenia
//            "SK",   //Slovakia
//            "SM",   //San Marino

    };

    /**
     * Convert a capital letter into digits: A -> 10 ... Z -> 35 (ISO 13616).
     *
     * @param str
     * @return
     */
    String stringToNumbersIso13616(String str) {
        char[] letters = str.toUpperCase().toCharArray();
        String result = "";
        String capitals = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int j = 0; j < letters.length; j++)
            for (int i = 0; i < capitals.length(); i++)
                if (letters[j] == capitals.charAt(i)) {
                    result = result + Integer.toString(i);
                }
        return result;
    }

    /**
     * Calculate the control number using the mod97 method
     *
     * @param modString
     * @return
     */
    protected static int mod97(String modString) {
        String part = "";
        int modPart;

        for (int i = 0; i < modString.length(); i++) {
            if (part.length() < 9)
                part = part + modString.charAt(i);
            else {
                modPart = (int) Long.parseLong(part) % 97;
                part = Integer.toString(modPart) + modString.charAt(i);
            }
        }
        return (int) Long.parseLong(part) % 97;
    }

    /**
     * To supply a bankcode based on the bankcode properties and availability of a list
     * It does not check if the bankcode supplied is found in a bankcode list as this might be a new or undocumented bank
     *
     * @param bankCode
     * @param bankCodesArray
     * @param bankCodeLength
     * @param bankCodeType
     * @return
     */
    protected String getBankCode(String bankCode, String[] bankCodesArray, int bankCodeLength, String bankCodeType) {
        if (bankCode.length() == 0) {
            if (bankCodesArray.length > 0) {
                return padWithStartingZeros(RANDOM_UTIL.randomElement(bankCodesArray), bankCodeLength);
            } else if (bankCodeType.equals("N")) {
                return getRandomStringNumeric(bankCodeLength);
            } else if (bankCodeType.equals("A")) {
                return getRandomStringAlfaOnly(bankCodeLength);
            } else {
                return getRandomStringAlfaNumeric(bankCodeLength);
            }
        } else if (bankCode.length() < bankCodeLength) {
            return padWithStartingZeros(bankCode, bankCodeLength);
        } else if (bankCode.length() > bankCodeLength) {
            throw new IllegalArgumentException("The supplied bankcode is longer than the Iban specification allows for");
        } else {
            return bankCode;
        }
    }

    /**
     * method for padding a bankcode or other String with zero's to meet a desired length
     */
    String padWithStartingZeros(String toBePadded, int requiredLength) {
        if (toBePadded.length() > requiredLength) {
            throw new IllegalArgumentException("The string to be padded is longer than the requested length");
        }

        while (requiredLength > toBePadded.length()) {
            toBePadded = "0" + toBePadded;
        }

        return toBePadded;
    }


    /**
     * @param length
     * @return
     */
    String getRandomStringNumeric(int length) {
        String permittedAccountDigits = "0123456789";
        return RANDOM_UTIL.randomString(permittedAccountDigits, length);
    }

    /**
     * @param length
     * @return
     */
    String getRandomStringAlfaOnly(int length) {
        String permittedAccountDigits = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return RANDOM_UTIL.randomString(permittedAccountDigits, length);
    }

    /**
     * @param length
     * @return
     */
    String getRandomStringAlfaNumeric(int length) {
        String permittedAccountDigits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return RANDOM_UTIL.randomString(permittedAccountDigits, length);
    }

    /**
     * @param accountLength
     * @param accountCodeType
     * @return
     */
    protected String getAccount(int accountLength, String accountCodeType) {
        String accountNumber;
        if (accountCodeType.equals("N")) {
            accountNumber = getRandomStringNumeric(accountLength);
        } else {
            accountNumber = getRandomStringAlfaNumeric(accountLength);
        }
        return accountNumber;
    }

    /**
     * @param bankCode
     * @param account
     * @param countryCode
     * @return
     */
    protected String getControlNumber(String bankCode, String account, String countryCode) {
        String baseIbanStr = stringToNumbersIso13616(bankCode + account + countryCode) + "00";
        String controlNr = String.valueOf(98 - mod97(baseIbanStr));

        if (controlNr.length() == 1) {
            controlNr = "0" + controlNr;
        }

        return controlNr;
    }
}
