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
    ATIbanGenerator generator = new ATIbanGenerator();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    /**
     * Tests generation without parameters.
     * Check length
     */
    @Test
    public void testNoParamLengthTest() {
        LengthTest("", 20);
    }

    /**
     * Tests generation without parameters.
     * Check countrycode prefix
     */
    @Test
    public void testNoParamPrefixTest() {
        prefixTest("", "AT");
    }

    /**
     * Tests generation using a random bankcode from the bankcode list.
     */
    @Test
    public void testGenerate() {
        String bankCode = RANDOM_UTIL.randomElement(generator.bankCodeList);
        includingBankcodeTest(bankCode, 20);
    }

    private void includingBankcodeTest(String bankCode, int length) {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateIban(bankCode);
            assertEquals("Got: " + result, length, result.length());
        }
    }

    private void LengthTest(String bankcode, int length) {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateIban(bankcode);
            assertEquals("Got: " + result, length, result.length());
        }
    }

    private void prefixTest(String bankcode, String prefix) {
        for (int i = 0; i < 100; i++) {
            String result = generator.generateIban(bankcode);
            assertTrue("Got: " + result, result.startsWith(prefix));
        }
    }
}
