package nl.hsac.fitnesse.util;

import org.junit.After;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests BsnUtil.
 */
public class BsnUtilTest {
    private final BsnUtil generator = new BsnUtil();

    @After
    public void resetGenerator() {
        generator.resetExcludedBsns();
    }

    /**
     * Tests basic generation.
     */
    @Test
    public void testGenerate() {
        for (int i = 0; i < 1000; i++) {
            String result = generator.generateBsn();
            assertEquals("Got: " + result, 9, result.length());
            assertTrue("Got: " + result, generator.testBsn(result));
        }
    }

    @Test
    public void ensureNoDuplicates() {
        Set<String> generatedBsns = new HashSet<>();
        for (int i = 0; i < 100_000; i++) {
            String result = generator.generateBsn();
            assertFalse("Duplicated value at loop: " + i, generatedBsns.contains(result));
            generatedBsns.add(result);
        }

        assertEquals(generatedBsns, generator.getBsnsToExclude());
    }

    @Test
    public void resetClears() {
        generator.generateBsn();
        assertFalse(generator.getBsnsToExclude().isEmpty());

        generator.resetExcludedBsns();
        assertTrue(generator.getBsnsToExclude().isEmpty());
    }

    @Test
    public void testAddBsnToExclude() {
        assertFalse(generator.getBsnsToExclude().contains("abc"));
        generator.addBsnToExclude("abc");
        assertTrue(generator.getBsnsToExclude().contains("abc"));
    }
}
