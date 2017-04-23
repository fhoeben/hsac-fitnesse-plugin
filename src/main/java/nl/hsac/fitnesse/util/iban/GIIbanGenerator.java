package nl.hsac.fitnesse.util.iban;

public class GIIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     *
     * @return random IBAN.
     */

    public String generateIban(String bankCode) {

        String countryCode = "GI";
        int accountLength = 15;
        String accountCodeType = "N";
        int bankCodeLength = 4;
        String bankCodeType = "A";

        bankCode = getBankCode(bankCode, BANK_CODE_LIST, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    //TODO get a list of gibraltar codes
    public final static String[] BANK_CODE_LIST = {
            "NWBK" //placeholder code
    };

}