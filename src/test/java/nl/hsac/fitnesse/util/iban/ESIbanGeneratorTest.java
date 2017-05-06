package nl.hsac.fitnesse.util.iban;

/**
 * Tests ES Iban generator.
 */
public class ESIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new ESIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "ES";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return ESIbanGenerator.BANK_CODE_LIST;
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
