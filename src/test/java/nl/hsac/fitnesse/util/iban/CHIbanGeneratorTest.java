package nl.hsac.fitnesse.util.iban;

/**
 * Tests CH Iban generator.
 */
public class CHIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new CHIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "CH";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return CHIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(5);
    }

    @Override
    protected int getExpectedLength() {
        return 21;
    }
}
