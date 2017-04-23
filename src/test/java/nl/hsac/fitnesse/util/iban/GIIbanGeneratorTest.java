package nl.hsac.fitnesse.util.iban;

/**
 * Tests GI Iban generator.
 */
public class GIIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new GIIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "GI";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return GIIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringAlfaOnly(4);
    }

    @Override
    protected int getExpectedLength() {
        return 23;
    }
}
