package nl.hsac.fitnesse.util.iban;

/**
 * Tests GR Iban generator.
 */
public class GRIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new GRIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "GR";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return GRIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(7);
    }

    @Override
    protected int getExpectedLength() {
        return 27;
    }
}
