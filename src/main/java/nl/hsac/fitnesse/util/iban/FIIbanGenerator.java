package nl.hsac.fitnesse.util.iban;

public class FIIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     * Finland has a very complex system to create a check digit as the last digitt
     * Similar to Germany, we choose to ignore this now.
     * Bankcode is including branch code
     *
     * @return random IBAN.
     */

    public String generateIban(String bankCode) {

        String countryCode = "FI";
        int accountLength = 8;
        String accountCodeType = "N";
        int bankCodeLength = 6;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, bankCodeList, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    public String[] bankCodeList = {};
}