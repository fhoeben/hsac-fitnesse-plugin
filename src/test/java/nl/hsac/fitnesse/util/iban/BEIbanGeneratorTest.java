package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests BEIbanGenerator.
 */
public class BEIbanGeneratorTest {
    private final BEIbanGenerator generator = new BEIbanGenerator();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    /**
     * Tests generation without parameters.
     */
    @Test
    public void testNoParam() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateBEIban("");
            assertEquals("Got: " + result, 16, result.length());
            assertTrue("Got: " + result, result.startsWith("BE"));

        }
    }

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String bankCode = RANDOM_UTIL.randomElement(generator.bankCodeList);
            String result = generator.generateBEIban(bankCode);
            assertEquals("Got: " + result, 16, result.length());
        }
    }

}
