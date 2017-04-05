package nl.hsac.fitnesse.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Helper for random values.
 */
public class RandomUtil {
    private static Random random = new SecureRandom();

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
     * Return a random value from a given enum
     * @param clazz The enum class to get a value from
     * @return a randomly selected value from the enum
     */
    public <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
