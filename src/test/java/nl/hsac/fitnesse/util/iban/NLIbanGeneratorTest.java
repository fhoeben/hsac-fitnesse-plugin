package nl.hsac.fitnesse.util.iban;

public class NLIbanGeneratorTest extends AbstractIbanGeneratorTest {
    @Override
    protected IbanGenerator createGenerator() {
        return new NLIbanGenerator();
    }

    @Override
    protected String getCountryCode() {
        return "NL";
    }

    @Override
    protected String[] getPossibleBankCodes() {
        return NLIbanGenerator.BANK_CODE_LIST;
    }

    @Override
    protected String createRandomNewBankCode() {
        return generator.getRandomStringAlfaNumeric(4);
    }

    @Override
    protected int getExpectedLength() {
        return 18;
    }

}
