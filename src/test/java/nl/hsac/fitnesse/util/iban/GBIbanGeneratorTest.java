package nl.hsac.fitnesse.util.iban;

/**
 * Tests GB Iban generator.
 */
public class GBIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new GBIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "GB";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return GBIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringAlfaOnly(4);
    }

    @Override
    protected int getExpectedLength() {
        return 22;
    }
}
