package nl.hsac.fitnesse.util.iban;

public class HRIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     *
     * @param bankCode bank code to (blank for random).
     * @return random IBAN.
     */
    public String generateIban(String bankCode) {

        String countryCode = "HR";
        int accountLength = 10;
        String accountCodeType = "N";
        int bankCodeLength = 7;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, BANK_CODE_LIST, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    //TODO get a list of Croatian codes
    public final static String[] BANK_CODE_LIST = {
            "1001005", //placeholder code
    };

}