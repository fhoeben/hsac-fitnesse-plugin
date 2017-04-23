package nl.hsac.fitnesse.util.iban;

/**
 * Tests CZ Iban generator.
 */
public class CZIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new CZIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "CZ";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return CZIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(4);
    }

    @Override
    protected int getExpectedLength() {
        return 24;
    }
}
