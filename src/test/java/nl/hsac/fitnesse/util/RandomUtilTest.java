package nl.hsac.fitnesse.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests RandomUtil.
 */
public class RandomUtilTest {
    private final RandomUtil util = new RandomUtil();

    /**
     * Tests int generation.
     */
    @Test
    public void testIntGenerate() {
        for (int i = 0; i < 1000; i++) {
            int result = util.random(10);
            assertTrue("Got: " + result, result < 10);
        }
    }

    /**
     * Tests int generation.
     * todo: write test
     */
    @Test
    public void TestRandomElement() {
        for (int i = 0; i < 1000; i++) {
            int result = util.random(10);
            assertTrue("Got: " + result, result < 10);
        }
    }

    /**
     * Tests int generation.
     * todo: write test
     */
    @Test
    public void testRandomSplit() {
        for (int i = 0; i < 1000; i++) {
            int result = util.random(10);
            assertTrue("Got: " + result, result < 10);
        }
    }
}
