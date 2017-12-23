package nl.hsac.fitnesse.util;

import java.util.Random;

public class RandomPostalCodeGenerator {
    RandomUtil random = new RandomUtil();

    private String getRandomStringNumbers(int length) {
        return random.randomString("1234567890", length);
    }

    private String getRandomStringLetters(int length) {
        return random.randomString("ABCDEFGHIJKLMNOPQRSTUVWXYZ", length);
    }

    public String getRandomPostalCodeString(String countryCode) {
        String result;
        switch (countryCode) {
            case "AU":
                result = getRandomStringNumbers(4);
                break;
            case "BE":
                result = random.randomString("123456789", 1) + getRandomStringNumbers(3);
                break;
            case "BR":
                result = getRandomStringNumbers(5) +
                        pickOne("", "-") +
                        getRandomStringNumbers(3);
                break;
            case "CA":
                result = getRandomStringLetters(1) +
                        getRandomStringNumbers(1) +
                        getRandomStringLetters(1) +
                        pickOne("-", " ") +
                        getRandomStringNumbers(1) +
                        getRandomStringLetters(1) +
                        getRandomStringNumbers(1);
                break;
            case "CH":
                result = random.randomString("123456789", 1) + getRandomStringNumbers(3);
                break;
            case "DE":
                result = getRandomStringNumbers(5);
                break;
            case "GL":
                result = "39" + getRandomStringNumbers(2);
                break;
            case "FR":
                result = getRandomStringNumbers(5);
                break;
            case "IT":
                result = getRandomStringNumbers(5);
                break;
            case "NL":
                result = random.randomString("123456789", 1) +
                        getRandomStringNumbers(3) +
                        getRandomStringLetters(2);
                break;
            case "NO":
                result = getRandomStringNumbers(4);
                break;
            case "US":
                String result1 = getRandomStringNumbers(5);
                String result2 = getRandomStringNumbers(5) + "-" + getRandomStringNumbers(4);
                result = pickOne(result1, result2);
                break;
            default:
                result = "This country code is not available for random postal code generation";
        }
        return result;
    }

    private String pickOne(String result1, String result2) {
        if (Math.random() < 0.5) {
            return result1;
        }
        return result2;
    }
}

