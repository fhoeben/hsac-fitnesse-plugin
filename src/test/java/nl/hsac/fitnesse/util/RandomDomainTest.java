package nl.hsac.fitnesse.util;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Tests RandomUtil.
 */
public class RandomDomainTest {
    private final RandomDomain domain = new RandomDomain();
    private final RandomUtil random = new RandomUtil();

    /**
     * Tests tld randomization.
     * todo: write test
     */
    @Test
    public void testRandomTld() {
        for (int i = 0; i < 5000; i++) {
            String result = domain.getRandomTld();
            boolean resultExists = false;

            for (RandomDomain.tlds me : RandomDomain.tlds.values()) {
                if (me.name().equalsIgnoreCase(result)) {
                    resultExists = true;
                    break;
                }
            }
            assertTrue("Got: " + result + " on test " + i, resultExists == true);
        }
    }


    /**
     * Tests domain generation.
     */
    @Test
    public void testGetRandomDomain() {
        for (int i = 0; i < 1000; i++) {
            int length = random.random(100) + 1; //considering a randomizer will generate non-inclusive from 0
            String result = domain.getRandomDomain(length);
            assertTrue("Got: " + result + " on test " + i, result.length() <= 100);
        }
    }


    /**
     * Tests top and second level domain construction.
     * todo: write test
     */
    @Test
    public void testGenerateFullDomain() {
        for (int i = 0; i < 1000; i++) {
            int result = 0;
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
            int result = 0;
            assertTrue("Got: " + result, result < 10);
        }

    }
}
