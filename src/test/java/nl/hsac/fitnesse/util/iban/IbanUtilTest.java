package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests BsnUtil.
 */
public class IbanUtilTest {
    private final IbanUtil ibanUtil = new IbanUtil();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Tests random generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String result = ibanUtil.generateIban("", "");
            assertTrue("Got: " + result, result.length() > 15);
        }
    }

    /**
     * Tests generation with only country code given.
     */
    @Test
    public void testCountry() {
        for (int i = 0; i < 100; i++) {
            String result = ibanUtil.generateIban("DE", "");
            assertEquals("Got: " + result, 22, result.length());
        }
    }

    /**
     * Tests generation with country code and bank code.
     */
    @Test
    public void testCountryBank() {
        for (int i = 0; i < 100; i++) {
            String bic = RANDOM_UTIL.randomElement(NLIban.NlBankCodes.values()).toString();
            String result = ibanUtil.generateIban("NL", bic);
            assertEquals("Got: " + result, 18, result.length());
        }
    }

    /**
     * Tests error code on unknown country code.
     */
    @Test
    public void testErrorCountryCode() {
            exception.expect(IllegalArgumentException.class);
            String bic = RANDOM_UTIL.randomElement(NLIban.NlBankCodes.values()).toString();
            String result = ibanUtil.generateIban("ZZ", bic);

    }

    /**
     * Tests letters to numbers.
     */
    @Test
    public void testLettersToNumbers() {
        testLettersToNumbersCall("AA", "1010");
        testLettersToNumbersCall("AB", "1011");
        testLettersToNumbersCall("ZZ", "3535");
        testLettersToNumbersCall("pp", "2525");
        testLettersToNumbersCall("As", "1028");
        testLettersToNumbersCall("nL", "2321");
    }

    private void testLettersToNumbersCall(String letters, String result) {
        String numbers = ibanUtil.lettersToNumbers(letters);
        assertEquals("Got: " + numbers, result, numbers);
    }




}

