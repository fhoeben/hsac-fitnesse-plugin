package nl.hsac.fitnesse.util.iban;

/**
 * Tests CY Iban generator.
 */
public class CYIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new CYIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "CY";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return CYIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(8);
    }

    @Override
    protected int getExpectedLength() {
        return 28;
    }
}
