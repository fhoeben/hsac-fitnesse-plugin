package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests DK Iban generator.
 */
public class DKIbanGeneratorTest {
    private final DKIbanGenerator generator = new DKIbanGenerator();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Tests generation without parameters.
     */
    @Test
    public void testNoParam() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateDKIban("");
            assertEquals("Got: " + result, 18, result.length());
            assertTrue("Got: " + result, result.startsWith("DK"));
        }
    }

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String bankCode = RANDOM_UTIL.randomElement(generator.bankCodeList);
            String result = generator.generateDKIban(bankCode);
            assertEquals("Got: " + result, 18, result.length());
        }
    }
}
