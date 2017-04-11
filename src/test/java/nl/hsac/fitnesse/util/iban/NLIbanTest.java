package nl.hsac.fitnesse.util.iban;
import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Tests BsnUtil.
 */
public class NLIbanTest {
    private final NLIban generator = new NLIban();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Tests generation without parameters.
     */
    @Test
    public void testNoParam() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateNLIban("", "");
            assertEquals("Got: " + result, 18, result.length());
            assertTrue("Got: " + result, result.charAt(0)=='N' && result.charAt(1)=='L');
        }
    }



    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String bic = RANDOM_UTIL.randomElement(generator.NlBankCodes);
            String result = generator.generateNLIban("NL", bic);
            assertEquals("Got: " + result, 18, result.length());
        }
    }

    /**
     * Tests generation without bankCode.
     */
    @Test
    public void testNoBankCode() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateNLIban("NL", "");
            assertEquals("Got: " + result, 18, result.length());
        }
    }

    /**
     * Tests error code on unknown bank code.
     */
    @Test
    public void testErrorBankCode() {
        exception.expect(IllegalArgumentException.class);
        generator.generateNLIban("", "ZZZZ");
    }


}
