package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Tests BEIban.
 */
public class BEIbanTest {
    private final BEIban generator = new BEIban();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Tests generation without parameters.
     */
    @Test
    public void testNoParam() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateBEIban("", "");
            assertEquals("Got: " + result, 16, result.length());
        }
    }

    /**
     * Tests generation without bankCode.
     */
    @Test
    public void testNoBankCode() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateBEIban("BE", "");
            assertEquals("Got: " + result, 16, result.length());
        }
    }

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String bic = RANDOM_UTIL.randomElement(generator.BEBankCodes);
            String result = generator.generateBEIban("BE", bic);
            assertEquals("Got: " + result, 16, result.length());
        }
    }

    /**
     * Tests error code on unknown bank code.
     */
    @Test
    public void testErrorBankCode() {
        exception.expect(IllegalArgumentException.class);
        String bic = "654";
        String result = generator.generateBEIban("", bic);

    }

}
