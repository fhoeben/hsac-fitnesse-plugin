package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;


/**
 * To select a country and parse the iban request to the proper class
 */
public class IbanGenerator {
    private final RandomUtil RANDOM_UTIL = new RandomUtil();

    public String generateIban(String country, String bankCode) {
        String iban;
        if (country.equals("")) {
            country = RANDOM_UTIL.randomElement(countryCodes);
        }

        switch (country) {
            case "BE":
                BEIbanGenerator beIbanGenerator = new BEIbanGenerator();
                iban = beIbanGenerator.generateBEIban(country, bankCode);
                return iban;
            case "CH":
                CHIbanGenerator chIbanGenerator = new CHIbanGenerator();
                iban = chIbanGenerator.generateCHIban(country, bankCode);
                return iban;
            case "DE":
                DEIbanGenerator deIbanGenerator = new DEIbanGenerator();
                iban = deIbanGenerator.generateDEIban(country, bankCode);
                return iban;
            case "NL":
                NLIbanGenerator nlIbanGenerator = new NLIbanGenerator();
                iban = nlIbanGenerator.generateNLIban(country, bankCode);
                return iban;
            case "LU":
                LUIbanGenerator luIbanGenerator = new LUIbanGenerator();
                iban = luIbanGenerator.generateLUIban(country, bankCode);
                return iban;
            case "DK":
                DKIbanGenerator dkIbanGenerator = new DKIbanGenerator();
                iban = dkIbanGenerator.generateDKIban(country, bankCode);
                return iban;
            case "AT":
                ATIbanGenerator atIbanGenerator = new ATIbanGenerator();
                iban = atIbanGenerator.generateATIban(bankCode);
                return iban;
            default:
                throw new IllegalArgumentException("This country code is unknown");
        }
    }

    private String[] countryCodes = {
            "NL",   //Netherlands
            "BE",   //Belgium
            "DE",   //Denmark
            "CH",   //Switzerland
            "LU",   //Luxembourg
            "DK",   //Denmark
            "BG",   //Bulgaria
            "HR",   //Croatia
            "CY",   //Cyprus
            "CZ",   //Czech Republic
            "EE",   //Estonia
            "FI",   //Finland
            "FR",   //France
            "GI",   //Gibraltar
            "GR",   //Greece
            "HU",   //Hungary
            "IS",   //Iceland
            "IE",   //Ireland
            "IT",   //Italy
            "LV",   //Latvia
            "LI",   //Liechtenstein
            "LT",   //Lithuania
            "MT",   //Malta
            "MC",   //Monaco
            "NO",   //Norway
            "PL",   //Poland
            "PT",   //Portugal
            "RO",   //Romania
            "SM",   //San Marino
            "SK",   //Slovakia
            "SI",   //Slovenia
            "ES",   //Spain
            "SE",   //Sweden
            "GB",   //United Kingdom
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

    //Validator to check if the requested bank is listed in the supplied array
    //If the string is empty, select a random bank
    //Else check if the bankcode exists in the supplied array and make sure it has the right length
    //If the string does not exist, throw an exception
    public String getBankCode(String bankCode, String[] bankCodesArray, int length, String bankCodeType) {
        if (bankCode.equals("")) {
            bankCode = padWithStartingZeros(RANDOM_UTIL.randomElement(bankCodesArray), length);

        } else {
            boolean bankCodeValid = false;
            for (String c : bankCodesArray) {
                if (c == bankCode) {
                    bankCodeValid = true;
                    bankCode = padWithStartingZeros(bankCode, length);
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


    public String getRandomStringNumeric(int length) {
        String permittedAccountDigits = "0123456789";
        return RANDOM_UTIL.randomString(permittedAccountDigits, length);
    }

    public String getRandomStringAlfaNumeric(int length) {
        String permittedAccountDigits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return RANDOM_UTIL.randomString(permittedAccountDigits, length);
    }







}
