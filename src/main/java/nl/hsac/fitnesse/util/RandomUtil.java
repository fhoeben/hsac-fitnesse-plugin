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

    /**
     * Picks and returns a random value from the supplied array.
     *
     * @param elements the array from which a value will be picked.
     * @return random element from the array of values.
     */
    public <T> T randomElement(T[] elements){
        return elements[random(elements.length)];
    }


    /**
     * Creates a random split in an integer, resulting in two integers.
     * These two integers added together will result in the original input
     *
     * @param fullValue integer that needs to be split.
     * @return array with two integers.
     */
    public int[] getRandomSplit(int fullValue) {
        int firstValue = random(fullValue - 1); //minus one so the secondValue will never become 0
        int secondValue = fullValue - firstValue;
        int split[] = {firstValue, secondValue};
        return split;
    }

}
