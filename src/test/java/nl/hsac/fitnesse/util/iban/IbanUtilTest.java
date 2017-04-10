package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.assertEquals;

/**
 * Tests BsnUtil.
 */
public class IbanUtilTest {
    private final IbanUtil ibanGenerator = new IbanUtil();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Tests random generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 100; i++) {
            String result = ibanGenerator.generateIban("", "");
            assertEquals("Got: " + result, 18, result.length());
        }
    }

    /**
     * Tests generation with only country code given.
     */
    @Test
    public void testCountry() {
        for (int i = 0; i < 100; i++) {
            String result = ibanGenerator.generateIban("NL", "");
            assertEquals("Got: " + result, 18, result.length());
        }
    }

    /**
     * Tests generation with country code and bank code.
     */
    @Test
    public void testCountryBank() {
        for (int i = 0; i < 100; i++) {
            String bic = RANDOM_UTIL.randomElement(NLIban.NlBankCodes.values()).toString();
            String result = ibanGenerator.generateIban("NL", bic);
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
            String result = ibanGenerator.generateIban("ZZ", bic);

    }

    /**
     * Tests error code on unknown bank code.
     */
    @Test
    public void testErrorBankCode() {
            exception.expect(IllegalArgumentException.class);
            String bic = "ZZZZ";
            String result = ibanGenerator.generateIban("NL", bic);

    }
}
