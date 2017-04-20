package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests BEIbanGenerator.
 */
public class DEIbanGeneratorTest {
    private final DEIbanGenerator generator = new DEIbanGenerator();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Tests generation without parameters.
     */
    @Test
    public void testNoParam() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateDEIban("", "");
            assertEquals("Got: " + result, 22, result.length());
            assertTrue("Got: " + result, result.charAt(0)=='D' && result.charAt(1)=='E');
        }
    }

    /**
     * Tests generation without bankCode.
     */
    @Test
    public void testNoBankCode() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateDEIban("DE", "");
            assertEquals("Got: " + result, 22, result.length());
        }
    }

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String bic = RANDOM_UTIL.randomElement(generator.DEBankCodes);
            String result = generator.generateDEIban("DE", bic);
            assertEquals("Got: " + result, 22, result.length());
        }
    }

    /**
     * Tests error code on unknown bank code.
     */
    @Test
    public void testErrorBankCode() {
        exception.expect(IllegalArgumentException.class);
        generator.generateDEIban("", "666");
    }

}
