package nl.hsac.fitnesse.util.iban;

/**
 * Tests EE Iban generator.
 */
public class EEIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new EEIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "EE";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return EEIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringNumeric(2);
    }

    @Override
    protected int getExpectedLength() {
        return 20;
    }
}
