package nl.hsac.fitnesse.util.iban;

public class GRIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     *
     * @return random IBAN.
     */

    public String generateIban(String bankCode) {

        String countryCode = "GR";
        int accountLength = 16;
        String accountCodeType = "M";
        int bankCodeLength = 7;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, bankCodeList, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    public String[] bankCodeList = {};
}