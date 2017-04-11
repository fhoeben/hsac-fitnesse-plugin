package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests CH Iban generator.
 */
public class CHIbanTest {
    private final CHIban generator = new CHIban();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Tests generation without parameters.
     */
    @Test
    public void testNoParam() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateCHIban("", "");
            assertEquals("Got: " + result, 21, result.length());
            assertTrue("Got: " + result, result.charAt(0)=='C' && result.charAt(1)=='H');
        }
    }

    /**
     * Tests generation without bankCode.
     */
    @Test
    public void testNoBankCode() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateCHIban("CH", "");
            assertEquals("Got: " + result, 21, result.length());
        }
    }

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String bic = RANDOM_UTIL.randomElement(generator.CHBankCodes);
            String result = generator.generateCHIban("CH", bic);
            assertEquals("Got: " + result, 21, result.length());
        }
    }

    /**
     * Tests error code on unknown bank code.
     */
    @Test
    public void testErrorBankCode() {
        exception.expect(IllegalArgumentException.class);
        String bic = "666";
        String result = generator.generateCHIban("", bic);

    }

}
