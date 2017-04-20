package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Tests LUIbanGenerator.
 */
public class LUIbanGeneratorTest {
    private final LUIbanGenerator generator = new LUIbanGenerator();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    /**
     * Tests generation without parameters.
     */
    @Test
    public void testNoParam() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateLUIban("");
            assertEquals("Got: " + result, 20, result.length());
        }
    }

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String bankCode = RANDOM_UTIL.randomElement(generator.bankCodeList);
            String result = generator.generateLUIban(bankCode);
            assertEquals("Got: " + result, 20, result.length());
        }
    }
}
