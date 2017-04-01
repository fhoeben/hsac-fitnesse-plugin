package nl.hsac.fitnesse.util;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Tests RandomUtil.
 */
public class RandomDomainTest {
    private final RandomDomain domain = new RandomDomain();

    /**
     * Tests tld randomization.
     * todo: write test
     */
    @Test
    public void testRandomTld() {
        for (int i = 0; i < 1000; i++) {
            String result = domain.getRandomTld();
            assertTrue("Got: " + result, result < 10);
        }
    }


    /**
     * Tests domain generation.
     * todo: write test
     */
    @Test
    public void testGetRandomDomain() {
        for (int i = 0; i < 1000; i++) {
            int result = util.random(10);
            assertTrue("Got: " + result, result < 10);
        }

    }


    /**
     * Tests top and second level domain construction.
     * todo: write test
     */
    @Test
    public void testGenerateFullDomain() {
        for (int i = 0; i < 1000; i++) {
            int result = util.random(10);
            assertTrue("Got: " + result, result < 10);
        }

    }


    /**
     * Tests length restriction.
     * todo: write test
     */
    @Test
    public void testGenerateFullDomainDomainLength() {
        for (int i = 0; i < 1000; i++) {
            int result = util.random(10);
            assertTrue("Got: " + result, result < 10);
        }

    }
}
