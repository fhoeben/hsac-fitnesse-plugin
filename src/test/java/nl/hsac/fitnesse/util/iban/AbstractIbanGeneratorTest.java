package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Base class for IBAN generator tests.
 */
public abstract class AbstractIbanGeneratorTest {
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    protected IbanGenerator generator = createGenerator();

    protected abstract IbanGenerator createGenerator();

    protected abstract String getCountryCode();

    protected abstract String[] getPossibleBankCodes();

    protected abstract String createRandomNewBankCode();

    protected abstract int getExpectedLength();

    /**
     * Tests generation without parameters.
     */
    @Test
    public void testNoParam() {
        String countryCode = getCountryCode();

        for (int i = 0; i < 100; i++) {
            String result = generator.generateIban(countryCode, "");
            assertEquals("Got: " + result, getExpectedLength(), result.length());
            assertTrue("Got: " + result, result.startsWith(countryCode));
            assertResultContainsOneOfThePossibleBankCode(result);
        }
    }

    protected void assertResultContainsOneOfThePossibleBankCode(String result) {
        boolean found = false;
        for (String possibleCode : getPossibleBankCodes()) {
            if (result.contains(possibleCode)) {
                found = true;
                break;
            }
        }
        assertTrue("Got: " + result, found);
    }

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        String countryCode = getCountryCode();

        for (int i = 0; i < 100; i++) {
            String bankCode = RANDOM_UTIL.randomElement(getPossibleBankCodes());
            String result = generator.generateIban(countryCode, bankCode);
            checkResultForCountryAndBankCode(countryCode, bankCode, result);
        }
    }

    /**
     * Tests generation using fictional bank code.
     */
    @Test
    public void testGenerateNewBank() {
        for (int i = 0; i < 100; i++) {
            String bankCode = createRandomNewBankCode();
            String result = generator.generateIban(getCountryCode(), bankCode);
            checkResultForCountryAndBankCode(getCountryCode(), bankCode, result);
        }
    }

    protected void checkResultForCountryAndBankCode(String countryCode, String bankCode, String result) {
        assertEquals("Got: " + result, getExpectedLength(), result.length());
        assertTrue("Got: " + result, result.startsWith(countryCode));
        assertTrue("Got: " + result, result.contains(bankCode));
    }
}
