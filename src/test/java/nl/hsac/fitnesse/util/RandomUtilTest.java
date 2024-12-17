package nl.hsac.fitnesse.util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

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
     * Tests random selection of an element from an array.
     */
    @Test
    public void TestRandomElementString() {
        for (int i = 0; i < 100; i++) {
            String[] ElementTest = {"Element1", "Element2", "Element3"};
            String result = util.randomElement(ElementTest);
            assertTrue("Got: " + result, Arrays.asList(ElementTest).contains(result));
        }
    }

    /**
     * Tests the splitting of an integer into two integers of random siz
     * The sum of the two generated integers is the original integer.
     */
    @Test
    public void testRandomSplit() {
        for (int i = 0; i < 1000; i++) {
            int orignalInt = util.random(100) + 2;
            int[] result = util.getRandomSplit(orignalInt);
            assertTrue("Got: " + orignalInt + " , " + result[0] + " , " + result[1], orignalInt == result[0] + result[1]);
        }
    }

    /**
     * Tests error message if input value is less than 2.
     */
    @Test
    public void testSplitLengthException() {
        assertThrows(IllegalArgumentException.class, () -> util.getRandomSplit(1));
    }
}
