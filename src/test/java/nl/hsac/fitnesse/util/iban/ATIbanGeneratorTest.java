package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests AT Iban generator.
 */
public class ATIbanGeneratorTest {
    private final ATIbanGenerator generator = new ATIbanGenerator();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Tests generation without parameters.
     */
    @Test
    public void testNoParam() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateATIban("", "");
            assertEquals("Got: " + result, 20, result.length());
            assertTrue("Got: " + result, result.charAt(0)=='A' && result.charAt(1)=='T');
        }
    }

    /**
     * Tests generation without bankCode.
     */
    @Test
    public void testNoBankCode() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateATIban("AT", "");
            assertEquals("Got: " + result, 20, result.length());
        }
    }

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String bic = RANDOM_UTIL.randomElement(generator.bankCodeList);
            String result = generator.generateATIban("AT", bic);
            assertEquals("Got: " + result, 20, result.length());
        }
    }

    /**
     * Tests error code on unknown bank code.
     */
    @Test
    public void testErrorBankCode() {
        exception.expect(IllegalArgumentException.class);
        generator.generateATIban("", "666");
    }

}
