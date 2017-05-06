package nl.hsac.fitnesse.util.iban;

/**
 * Tests LUIbanGenerator.
 */
public class LUIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new LUIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "LU";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return LUIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(3);
    }

    @Override
    protected int getExpectedLength() {
        return 20;
    }
}
