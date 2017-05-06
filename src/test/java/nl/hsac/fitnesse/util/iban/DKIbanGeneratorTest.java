package nl.hsac.fitnesse.util.iban;

/**
 * Tests DK Iban generator.
 */
public class DKIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new DKIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "DK";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return DKIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(4);
    }

    @Override
    protected int getExpectedLength() {
        return 18;
    }
}
