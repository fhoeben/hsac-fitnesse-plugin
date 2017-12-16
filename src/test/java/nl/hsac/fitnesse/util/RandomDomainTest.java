package nl.hsac.fitnesse.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests RandomUtil.
 */
public class RandomDomainTest {
    private final RandomDomain domain = new RandomDomain();
    private final RandomUtil random = new RandomUtil();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Tests tld randomization.
     */
    @Test
    public void testRandomTld() {
        for (int i = 0; i < 5000; i++) {
            String result = domain.getRandomTld();
            boolean resultExists = false;

            for (RandomDomain.tlds tlds : RandomDomain.tlds.values()) {
                if (tlds.name().equalsIgnoreCase(result)) {
                    resultExists = true;
                    break;
                }
            }
            assertTrue("Got: " + result + " on test " + i, resultExists);
        }
    }

    /**
     * Tests domain generation.
     */
    @Test
    public void testGetRandomDomain() {
        for (int i = 0; i < 1000; i++) {
            int length = random.random(100) + 1; //considering a randomizer will generate non-inclusive from 0
            String result = domain.getRandomSecondLevelDomain(length);
            assertTrue("Got: " + result + " on test " + i, result.length() <= 100);
            assertTrue("Got: " + result + " on regex test " + i, result.matches("[-.abcdefghijklmnopqrstuvwxyz1234567890]+"));
            assertFalse("Got: " + result + " test " + i, result.startsWith("."));
            assertFalse("Got: " + result + " test " + i, result.contains(".."));
            assertFalse("Got: " + result + " test " + i, result.endsWith("."));
        }
    }

    /**
     * Tests top and second level domain construction.
     */
    @Test
    public void testGenerateFullDomain() {
        for (int i = 0; i < 1000; i++) {
            int length = random.random(95) + 5; //5 to use as minimal length for a hostname in email
            String result = RandomDomain.generateFullDomain(domain, length);
            assertTrue("Got: " + result + " on test " + i, result.length() <= 100);
            assertTrue("Got: " + result + " on regex test " + i, result.matches("[-.a-z0-9]+" + "." + "[A-Z]+"));
            assertFalse("Got: " + result + " on regex test " + i, result.matches("(\\.)\\1+"));
            assertFalse("Got: " + result + " on regex test " + i, result.matches("^[.]"));

        }
    }

    /**
     * Tests error message if requested domain length is less than 5.
     */
    @Test
    public void testDomainLengthException() {
        exception.expect(IllegalArgumentException.class);
        RandomDomain.generateFullDomain(domain, 4);
        RandomDomain.generateFullDomain(domain, 3);
        RandomDomain.generateFullDomain(domain, 2);
        RandomDomain.generateFullDomain(domain, 1);
        RandomDomain.generateFullDomain(domain, -1);
    }

}