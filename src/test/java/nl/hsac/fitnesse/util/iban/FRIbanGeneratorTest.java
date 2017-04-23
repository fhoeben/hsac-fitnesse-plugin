package nl.hsac.fitnesse.util.iban;

/**
 * Tests FR Iban generator.
 */
public class FRIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new FRIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "FR";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return FRIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(5);
    }

    @Override
    protected int getExpectedLength() {
        return 27;
    }
}
