package nl.hsac.fitnesse.util.iban;

/**
 * Tests AT Iban generator.
 */
public class ATIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new ATIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "AT";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return ATIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(5);
    }

    @Override
    protected int getExpectedLength() {
        return 20;
    }
}
