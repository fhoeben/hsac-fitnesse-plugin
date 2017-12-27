package nl.hsac.fitnesse.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

/**
 * Tests RandomPostalCodeGenerator.
 * The postal codes are checked on length only to validate the switch
 */
public class RandomPostalCodeGeneratorTest {
    private final RandomPostalCodeGenerator postalCode = new RandomPostalCodeGenerator();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private boolean resultEqualsLength(String result, int length) {
        return result.length() == length;
    }

    @Test
    public void testRandomPostalCodeAustralia() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToLength("AU", 4);
        }
    }

    @Test
    public void testRandomPostalCodeBelgium() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToLength("BE", 4);
        }
    }

    @Test
    public void testRandomPostalCodeBrazil() {
        checkCodeLengths("BR", 8, 9);
    }

    @Test
    public void testRandomPostalCanada() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToLength("CA", 7);
        }
    }

    @Test
    public void testRandomPostalCodeFrance() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToLength("FR", 5);
        }
    }

    @Test
    public void testRandomPostalCodeGermany() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToLength("DE", 5);
        }
    }

    @Test
    public void testRandomPostalCodeGreenland() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToLength("GL", 4);
        }
    }

    @Test
    public void testRandomPostalCodeItaly() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToLength("IT", 5);
        }
    }

    @Test
    public void testRandomPostalCodeNetherlands() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToLength("NL", 6);
        }
    }

    @Test
    public void testRandomPostalCodeNorway() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToLength("NO", 4);
        }
    }

    @Test
    public void testRandomPostalCodeUnitedStates() {
        checkCodeLengths("US", 5, 10);
    }

    private void testCountryCodeToLength(String countryCode, int length) {
        String result = postalCode.getRandomPostalCodeString(countryCode);
        assertTrue("Got: " + result, resultEqualsLength(result, length));
    }

    private void checkCodeLengths(String countryCode, int length1, int length2) {
        int length1Count = 0;
        int length2Count = 0;
        for (int i = 0; i < 100; i++) {
            int length = testCountryCodeToTwoLengths(countryCode, length1, length2);
            if (length == length1) {
                length1Count++;
            } else {
                length2Count++;
            }
        }
        assertTrue(countryCode + ": too few length1 codes: " + length1Count, length1Count > 30);
        assertTrue(countryCode + ": too few length2 codes: " + length2Count, length2Count > 30);
    }

    private int testCountryCodeToTwoLengths(String countryCode, int length1, int length2) {
        String result = postalCode.getRandomPostalCodeString(countryCode);
        boolean hasLength1 = resultEqualsLength(result, length1);
        boolean hasLength2 = resultEqualsLength(result, length2);
        assertTrue("Got: " + result, hasLength1 || hasLength2);
        return hasLength1 ? length1 : length2;
    }
}