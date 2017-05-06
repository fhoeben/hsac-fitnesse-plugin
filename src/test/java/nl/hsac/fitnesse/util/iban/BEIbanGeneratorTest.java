package nl.hsac.fitnesse.util.iban;

/**
 * Tests BEIbanGenerator.
 */
public class BEIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new BEIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "BE";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return BEIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(3);
    }

    @Override
    protected int getExpectedLength() {
        return 16;
    }
}
