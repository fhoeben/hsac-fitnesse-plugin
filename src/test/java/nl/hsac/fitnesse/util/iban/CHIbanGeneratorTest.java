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
public class CHIbanGeneratorTest {
    private final CHIbanGenerator generator = new CHIbanGenerator();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Tests generation without parameters.
     */
    @Test
    public void testNoParam() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateCHIban("");
            assertEquals("Got: " + result, 21, result.length());
            assertTrue("Got: " + result, result.startsWith("CH"));
        }
    }

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String bankCode = RANDOM_UTIL.randomElement(generator.bankCodeList);
            String result = generator.generateCHIban(bankCode);
            assertEquals("Got: " + result, 21, result.length());
        }
    }
}
