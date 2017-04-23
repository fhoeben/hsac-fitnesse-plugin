package nl.hsac.fitnesse.util.iban;

/**
 * Tests FI Iban generator.
 */
public class FIIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new FIIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "FI";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return FIIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(3);
    }

    @Override
    protected int getExpectedLength() {
        return 18;
    }
}
