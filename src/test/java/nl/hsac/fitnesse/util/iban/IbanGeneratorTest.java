package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

/**
 * Tests IbanUtil.
 */
public class IbanGeneratorTest {
    private final IbanGenerator ibanGenerator = new IbanGenerator();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();
    private final NLIbanGenerator generator = new NLIbanGenerator();

    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String result = ibanGenerator.generateIban("", "");
            assertTrue("Got: " + result, result.length() > 15);
        }
    }

    /**
     * Tests generation with only country code given.
     */
    @Test
    public void testCountry() {
        for (int i = 0; i < 100; i++) {
            String result = ibanGenerator.generateIban("DE", "");
            assertEquals("Got: " + result, 22, result.length());
            assertTrue("Got: " + result, result.startsWith("DE"));
        }
    }

    /**
     * Tests generation with country code and bank code.
     */
    @Test
    public void testCountryBank() {
        for (int i = 0; i < 100; i++) {
            String bankCode = RANDOM_UTIL.randomElement(generator.BANK_CODE_LIST);
            String result = ibanGenerator.generateIban("NL", bankCode);
            assertEquals("Got: " + result, 18, result.length());
        }
    }

    /**
     * Tests error code on unknown country code.
     */
    @Test
    public void testErrorCountryCode() {
        assertThrows(IllegalArgumentException.class, () -> ibanGenerator.generateIban("ZZ", ""));
    }

    /**
     * Tests letters to numbers.
     */
    @Test
    public void testLettersToNumbers() {
        testLettersToNumbersCall("ABNA", "10112310");
        testLettersToNumbersCall("AB", "1011");
        testLettersToNumbersCall("ZZ", "3535");
        testLettersToNumbersCall("pp", "2525");
        testLettersToNumbersCall("As", "1028");
        testLettersToNumbersCall("nL", "2321");
        testLettersToNumbersCall("73", "73");
    }

    /**
     * Tests country specific generation.
     */
    @Test
    public void testAllCountryCodes() {
        countrySelectTest("NL", 18);
        countrySelectTest("DE", 22);
        countrySelectTest("BE", 16);
        countrySelectTest("CH", 21);
        countrySelectTest("LU", 20);
        countrySelectTest("DK", 18);
        countrySelectTest("AT", 20);
    }

    /**
     * Tests country specific generation.
     */
    @Test
    public void testPaddingWithStartingZeros() {
        testPadWithStartingZeros("BankCode", 10);
        testPadWithStartingZeros("BankCode", 8);
        testPadWithStartingZeros("BankCode", 100);
        testPadWithStartingZeros("", 10);
    }

    /**
     * Tests error code on desired length smaller than string to be padded
     */
    @Test
    public void testErrorPaddingWithZeros() {
        assertThrows(IllegalArgumentException.class, () -> ibanGenerator.padWithStartingZeros("ZZ", 1));
    }

    private void testPadWithStartingZeros(String string, int desiredLength) {
        String result = ibanGenerator.padWithStartingZeros(string, desiredLength);
        assertEquals("Got" + result, result.length(), desiredLength);
    }

    private void testLettersToNumbersCall(String letters, String result) {
        String numbers = ibanGenerator.stringToNumbersIso13616(letters);
        assertEquals("Got: " + numbers, result, numbers);
    }

    private void countrySelectTest(String countryCode, int expectedIbanLength) {
        String result = ibanGenerator.generateIban(countryCode, "");
        assertEquals("Got: " + result, expectedIbanLength, result.length());
        assertTrue("Got: " + result, result.startsWith(countryCode));
    }
}

