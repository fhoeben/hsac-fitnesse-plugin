package nl.hsac.fitnesse.symbols;

import nl.hsac.fitnesse.util.RandomUtil;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

/**
 * These tests are to check the working of the RandomEmail wikiword
 */
public class RandomEmailTest {
    private final RandomUtil random = new RandomUtil();
    private final RandomEmail EmailGenerator = new RandomEmail();

    @Test
    public void testLengthNoDomain() {
        testGenerateEmail("50", "", 50);
    }

    @Test
    public void testLengthNoInputParam() {
        testGenerateEmail(null, "", 100);
    }

    @Test
    public void testLengthWithDomain() {
        testGenerateEmail("40", "doma.in", 40);
    }

    @Test
    public void testNegativeValue() {
        checkGeneratedLengthException("-5", "");
    }

    @Test
    public void testNegativeValueWithDomain() {
        checkGeneratedLengthException("-5", "org.org");
    }

    @Test
    public void testSmallLengthNoDomain() {
        checkGeneratedLengthException("6", "");
    }

    @Test
    public void testRandomSameLengthAsDomain() {
        checkGeneratedLengthException("12", "verylong.nl");
    }

    @Test
    public void testEmailLengthToSmall() {
        checkGeneratedLengthException("2", "");
    }

    /**
     * Tests local email address generation.
     */
    @Test
    public void testGetRandomLocalAddress() {
        for (int i = 0; i < 1000; i++) {
            int length = random.random(100) + 1; //zero is not an option
            String result = RandomEmail.getRandomLocalAddress(length);
            assertTrue("Got: " + result + " on test " + i, result.length() <= 100);
            assertTrue("Got: " + result + " on regex test " + i, result.matches("[-a-zA-Z0-9!#$%&'*+/=?^_`{|}~.]+"));
        }
    }

    /**
     * Tests zero exception.
     */
    @Test
    public void testGetRandomLocalAddressZeroException() {
        assertThrows(IllegalArgumentException.class,
                () -> EmailGenerator.getRandomLocalAddress(0));
    }

    /**
     * Tests domain oversize exception.
     */
    @Test
    public void testgetEmailRandomPartLengthDomainSizeException() {
        assertThrows(IllegalArgumentException.class,
                () -> EmailGenerator.getEmailRandomPartLength("9", "test.com"));
    }


    /**
     * Tests length generation for the random part if a domain is given.
     */
    @Test
    public void testgetEmailRandomPartLength() {
        for (int i = 0; i < 1000; i++) {
            String length = Integer.toString(random.random(50) + 8 + 1 + 1); //domain is 8 long, 1 for @, 1 for at least 1 character
            int result = EmailGenerator.getEmailRandomPartLength(length, "test.com");
            assertTrue("Got: " + result + " on test " + i, result <= 50);
        }
    }

    /**
     * Tests small domain exception.
     */
    @Test
    public void testRandomEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> EmailGenerator.randomEmail("10", "n.nl"));
    }

    /**
     * To test using none or a single value for length, in the latter case also with or without domain
     */
    private void testGenerateEmail(String lengthParam, String domain, int ExpectedLength) {
        for (int i = 0; i < 1000; i++) {
            String result = EmailGenerator.randomEmail(lengthParam, domain);
            assertTrue("Actual value:" + result + " on test " + i, result.length() <= ExpectedLength);
        }
    }

    /**
     * to test for the exceptions
     */
    private void checkGeneratedLengthException(String lengthParam, String prefix) {
        assertThrows(IllegalArgumentException.class,
                () -> EmailGenerator.randomEmail(lengthParam, prefix));
    }
}
