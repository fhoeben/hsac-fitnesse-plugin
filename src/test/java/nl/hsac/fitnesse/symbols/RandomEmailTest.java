package nl.hsac.fitnesse.symbols;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * These tests are to check the working of the RandomEmail wikiword
 */
public class RandomEmailTest {
    private final RandomString stringLengthGenerator = new RandomString();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testLength() {
        checkGeneratedLength("50", "", 50);
    }

    @Test
    public void testLengthWithPrefix() {
        checkGeneratedLength("50", "prefix", 44);
    }

    @Test
    public void testNoParameters() {
        for (int i = 0; i < 1000; i++) {
            int result = stringLengthGenerator.getStringLength(null, "");
            assertTrue("Actual value:" + result, result < 100);
        }
    }

    @Test
    public void testRange() {
        checkGeneratedLengthRange("10,60", "", 10, 60);
    }

    @Test
    public void testRangeIncludesMax() {
        checkGeneratedLengthRange("10,10", "", 10, 10);
    }

    @Test
    public void testRangeCanIncludeZero() {
        checkGeneratedLengthRange("0,5", "", 0, 5);
    }

    @Test
    public void testRangeWithParameter() {
        checkGeneratedLengthRange("10,20", "vspgh", 5, 15);
    }

    @Test
    public void testprefixTooLongMinLength() {
        checkGeneratedLengthException("5", "verylongprefix");
    }

    @Test
    public void testprefixTooLongMinMaxLength() {
        checkGeneratedLengthException("3,10", "verylongprefix");
    }

    @Test
    public void testNegativeValue() {
        checkGeneratedLengthException("-5", "");
    }

    @Test
    public void testZeroParameterNoRange() {
        checkGeneratedLengthException("0", "");
    }

    @Test
    public void testRandomSameLengthAsPrefix() {
        checkGeneratedLengthException("2", "ab");
    }

    @Test
    public void testRandomRangeSameLengthAsPrefix() {
        checkGeneratedLengthException("2,2", "ab");
    }

    @Test
    public void testNegativeValueMinMax() {
        checkGeneratedLengthException("-5,4", "");
    }

    @Test
    public void testMinValueBigger() {
        checkGeneratedLengthException("10,7", "");
    }

    /**
     * To test using none or a single value for length, in the latter case also with or without prefix
     */
    private void checkGeneratedLength(String lengthParam, String prefix, int expectedmaxValue) {
        for (int i = 0; i < 1000; i++) {
            int result = stringLengthGenerator.getStringLength(lengthParam, prefix);
            assertEquals("Actual value:" + result, expectedmaxValue, result);
        }
    }

    /**
     * to test for the exceptions
     */
    private void checkGeneratedLengthException(String lengthParam, String prefix) {
        exception.expect(IllegalArgumentException.class);
        stringLengthGenerator.getStringLength(lengthParam, prefix);
    }

    /**
     * Test using a range, with or without a prefix
     */
    private void checkGeneratedLengthRange(String lengthParam, String prefix, int expectedminValue, int expectedmaxValue) {
        for (int i = 0; i < 1000; i++) {
            int result = stringLengthGenerator.getStringLength(lengthParam, prefix);
            assertTrue("Actual value:" + result, result >= expectedminValue);
            assertTrue("Actual value:" + result, result <= expectedmaxValue);

        }
    }
}
