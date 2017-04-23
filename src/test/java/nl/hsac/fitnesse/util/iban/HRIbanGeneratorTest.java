package nl.hsac.fitnesse.util.iban;

/**
 * Tests HR Iban generator.
 */
public class HRIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new HRIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "HR";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return HRIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(7);
    }

    @Override
    protected int getExpectedLength() {
        return 21;
    }
}
