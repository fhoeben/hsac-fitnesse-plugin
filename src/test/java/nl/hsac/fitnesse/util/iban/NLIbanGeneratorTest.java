package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Tests BsnUtil.
 */
public class NLIbanGeneratorTest {
    private final NLIbanGenerator generator = new NLIbanGenerator();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    /**
     * Tests generation without parameters.
     */
    @Test
    public void testNoParam() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateNLIban("");
            assertEquals("Got: " + result, 18, result.length());
            assertTrue("Got: " + result, result.startsWith("NL"));
        }
    }

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String bankCode = RANDOM_UTIL.randomElement(generator.bankCodeList);
            String result = generator.generateNLIban(bankCode);
            assertEquals("Got: " + result, 18, result.length());
        }
    }

    /**
     * Tests generation using fictional bank code.
     */
    @Test
    public void testGenerateNewBank() {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateNLIban(generator.getRandomStringAlfaNumeric(4));
            assertEquals("Got: " + result, 18, result.length());
        }
    }
}
