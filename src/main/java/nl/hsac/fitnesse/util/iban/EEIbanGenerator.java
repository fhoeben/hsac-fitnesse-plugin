package nl.hsac.fitnesse.util.iban;

public class EEIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     *
     * @return random Estonian IBAN.
     */

    public String generateIban(String bankCode) {

        String countryCode = "EE";
        int accountLength = 14;
        String accountCodeType = "N";
        int bankCodeLength = 2;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, bankCodeList, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    public String[] bankCodeList = {};
}