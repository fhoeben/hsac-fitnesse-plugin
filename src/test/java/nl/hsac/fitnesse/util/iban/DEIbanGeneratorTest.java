package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests DEIbanGenerator.
 */
public class DEIbanGeneratorTest {
    private final DEIbanGenerator generator = new DEIbanGenerator();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    /**
     * Tests generation without parameters.
     */
    @Test
    public void testNoParam() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateIban("");
            assertEquals("Got: " + result, 22, result.length());
            assertTrue("Got: " + result, result.startsWith("DE"));
        }
    }

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String bankCode = RANDOM_UTIL.randomElement(generator.bankCodeList);
            String result = generator.generateIban(bankCode);
            assertEquals("Got: " + result, 22, result.length());
        }
    }

    /**
     * Tests generation using fictional bank code.
     */
    @Test
    public void testGenerateNewBank() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateIban(generator.getRandomStringNumeric(8));
            assertEquals("Got: " + result, 22, result.length());
        }
    }


}
