package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;


/**
 * To select a country and parse the iban request to the proper class
 */
public class IbanUtil {
    private final RandomUtil RANDOM_UTIL = new RandomUtil();


    public String generateIban(String country, String bankCode) {
        String iban;
        if (country.equals("")) {
            country = RANDOM_UTIL.randomElement(countryCodes);
        }

        switch (country) {
            case "BE":
                BEIban beIban = new BEIban();
                iban = beIban.generateBEIban(country, bankCode);
                return iban;
            case "CH":
                CHIban chIban = new CHIban();
                iban = chIban.generateCHIban(country, bankCode);
                return iban;
            case "DE":
                DEIban deIban = new DEIban();
                iban = deIban.generateDEIban(country, bankCode);
                return iban;
            case "NL":
                NLIban nlIban = new NLIban();
                iban = nlIban.generateNLIban(country, bankCode);
                return iban;
            case "LU":
                LUIban luIban = new LUIban();
                iban = luIban.generateLUIban(country, bankCode);
                return iban;
            default:
                throw new IllegalArgumentException("This country code is unknown");
        }
    }

    private String[] countryCodes = {
            "NL",
            "BE",
            "DE",
            "CH",
            "LU"
    };

    // Convert a capital letter into digits: A -> 10 ... Z -> 35 (ISO 13616).
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

    //Calculate the control number using the mod97 method
    public static int mod97(String modString) {
        String part = "";
        int modPart;

        for (int i = 0; i < modString.length(); i++){
            if (part.length() < 9)
                part = part + modString.charAt(i);
            else {
                modPart = (int)Long.parseLong(part)%97;
                part = Integer.toString(modPart) + modString.charAt(i);
            }
        }
        return (int)Long.parseLong(part)%97;
    }

    //Validator if the requested bank is listed in the supplied array
    //If the string is empty, select a random bank
    //If the string does not exist, throw an exception
    public String getBankCode(String bankCode, String[] bankCodesArray) {
        if (bankCode.equals("")) {
            bankCode = RANDOM_UTIL.randomElement(bankCodesArray);
        } else {
            boolean bankCodeValid = false;
            for (String c : bankCodesArray) {
                if (c == bankCode) {
                    bankCodeValid = true;
                    break;
                }
            }
            if (bankCodeValid == false) {
                throw new IllegalArgumentException("This bank code is unknown");
            }
        }
        return bankCode;
    }

    //method for padding a bankcode or other String with zero's to meet a desired length
    public String padWithStartingZeros(String toBePadded, int requiredLength){
        if (toBePadded.length() > requiredLength){
            throw new IllegalArgumentException("The string to be padded is longer than the requested length");
        }

        while(requiredLength>toBePadded.length()){
            toBePadded = "0" + toBePadded;
        }

        return toBePadded;
    }





}
