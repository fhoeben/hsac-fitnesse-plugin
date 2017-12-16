package nl.hsac.fitnesse.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

/**
 * Tests RandomPostalCodeGenerator.
 * The postal codes are checked on length only to validate teh switch
 * testing the correctness would be testing the Generex library
 * (for which the testing code is here: https://github.com/mifmif/Generex )
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
        for (int i = 0; i < 100; i++) {
            testCountryCodeToTwoLengths("BR", 8, 9);
        }
    }

    @Test
    public void testRandomPostalCanada() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToTwoLengths("CA", 6, 7);
        }
    }

    @Test
    public void testRandomPostalCodeDenmark() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToLength("DK", 4);
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
    public void testRandomPostalCodeSpain() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToLength("ES", 5);
        }
    }

    @Test
    public void testRandomPostalCodeUnitedStates() {
        for (int i = 0; i < 100; i++) {
            testCountryCodeToTwoLengths("US", 5, 10);
        }
    }

    private void testCountryCodeToLength(String countryCode, int length) {
        String result = postalCode.getRandomPostalCodeString(countryCode);
        assertTrue("Got: " + result, resultEqualsLength(result, length));
    }

    private void testCountryCodeToTwoLengths(String countryCode, int length1, int length2) {
        String result = postalCode.getRandomPostalCodeString(countryCode);
        assertTrue("Got: " + result, resultEqualsLength(result, length1) | resultEqualsLength(result, length2));
    }
}