package nl.hsac.fitnesse.util.iban;

/**
 * Tests DEIbanGenerator.
 */
public class DEIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new DEIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "DE";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return DEIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(8);
    }

    @Override
    protected int getExpectedLength() {
        return 22;
    }
}
