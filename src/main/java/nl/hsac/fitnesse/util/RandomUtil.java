package nl.hsac.fitnesse.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Helper for random values.
 */
public class RandomUtil {
    private Random random = new SecureRandom();

    /**
     * Generates random number below a certain value.
     *
     * @param max max (non-inclusive) value for returned number.
     * @return random number
     */
    public int random(int max) {
        return random.nextInt(max);
    }

    /**
     * Creates a random string consisting only of supplied characters.
     *
     * @param permitted string consisting of permitted characters.
     * @param length    length of string to create.
     * @return random string.
     */
    public String randomString(String permitted, int length) {
        StringBuilder result = new StringBuilder(length);
        int maxIndex = permitted.length();
        for (int i = 0; i < length; i++) {
            int index = random(maxIndex);
            char value = permitted.charAt(index);
            result.append(value);
        }
        return result.toString();
    }


    public <T> T randomElement(T[] elements){
        return elements[random(elements.length)];
    }

}
