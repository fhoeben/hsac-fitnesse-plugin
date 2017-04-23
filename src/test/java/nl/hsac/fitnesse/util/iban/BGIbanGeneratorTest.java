package nl.hsac.fitnesse.util.iban;

/**
 * Tests BG Iban generator.
 */
public class BGIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new BGIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "BG";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return BGIbanGenerator.BANK_CODE_LIST;
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
