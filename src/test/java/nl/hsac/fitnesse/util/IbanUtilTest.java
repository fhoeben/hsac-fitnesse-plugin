package nl.hsac.fitnesse.util;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests BsnUtil.
 */
public class IbanUtilTest {
    private final IbanUtil generator = new IbanUtil();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String bic = RANDOM_UTIL.randomEnum(NlBankCodes.class).toString();
            String result = generator.generateIban("NL", bic);
            System.out.println(result);
            assertEquals("Got: " + result, 18, result.length());
        }
    }
}
