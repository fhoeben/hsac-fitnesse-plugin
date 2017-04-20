package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;


/**
 * To select a country and parse the iban request to the proper class
 */
public class IbanGenerator {
    private final RandomUtil RANDOM_UTIL = new RandomUtil();

    public String generateIban(String country, String bankCode) {
        if (country.equals("")) {
            country = RANDOM_UTIL.randomElement(countryCodes);
        }


        switch (country) {
            case "BE":
                return new BEIbanGenerator().generateBEIban(bankCode);
            case "CH":
                return new CHIbanGenerator().generateCHIban(bankCode);
            case "DE":
                return new DEIbanGenerator().generateDEIban(bankCode);
            case "DK":
                return new DKIbanGenerator().generateDKIban(bankCode);
            case "LU":
                return new LUIbanGenerator().generateLUIban(bankCode);
            case "NL":
                return new NLIbanGenerator().generateNLIban(bankCode);
            case "AT":
                return new ATIbanGenerator().generateATIban(bankCode);
            default:
                throw new IllegalArgumentException("The given country code " + country + " is not (yet) implemented");
        }
    }

    String[] countryCodes = {
            "AT",     //Austria
            "BE",   //Belgium
//            "BG",   //Bulgaria
            "CH",   //Switzerland
//            "CY",   //Cyprus
//            "CZ",   //Czech Republic
            "DE",   //Germany
            "DK",   //Denmark
//            "EE",   //Estonia
//            "ES",   //Spain
//            "FI",   //Finland
//            "FR",   //France
//            "GB",   //United Kingdom
//            "GI",   //Gibraltar
//            "GR",   //Greece
//            "HR",   //Croatia
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
    public String stringToNumbersIso13616(String str) {
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
    public static int mod97(String modString) {
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
    public String getBankCode(String bankCode, String[] bankCodesArray, int bankCodeLength, String bankCodeType) {
        if (bankCode.length() == 0) {
            if (bankCodesArray.length > 0) {
                return padWithStartingZeros(RANDOM_UTIL.randomElement(bankCodesArray), bankCodeLength);
            } else if (bankCodeType.equals("N")) {
                return getRandomStringNumeric(bankCodeLength);
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
    public String padWithStartingZeros(String toBePadded, int requiredLength) {
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
    public String getRandomStringNumeric(int length) {
        String permittedAccountDigits = "0123456789";
        return RANDOM_UTIL.randomString(permittedAccountDigits, length);
    }

    /**
     * @param length
     * @return
     */
    public String getRandomStringAlfaNumeric(int length) {
        String permittedAccountDigits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return RANDOM_UTIL.randomString(permittedAccountDigits, length);
    }

    /**
     * @param accountLength
     * @param accountCodeType
     * @return
     */
    public String getAccount(int accountLength, String accountCodeType) {
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
    public String getControlNumber(String bankCode, String account, String countryCode) {
        String baseIbanStr = stringToNumbersIso13616(bankCode + account + countryCode) + "00";
        String controlNr = String.valueOf(98 - IbanGenerator.mod97(baseIbanStr));

        if (controlNr.length() == 1) {
            controlNr = "0" + controlNr;
        }

        return controlNr;
    }


}
