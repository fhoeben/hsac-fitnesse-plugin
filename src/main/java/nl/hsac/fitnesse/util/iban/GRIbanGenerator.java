package nl.hsac.fitnesse.util.iban;

public class GRIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     *
     * @param bankCode bank code to (blank for random).
     * @return random IBAN.
     */
    public String generateIban(String bankCode) {

        String countryCode = "GR";
        int accountLength = 16;
        String accountCodeType = "M";
        int bankCodeLength = 7;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, BANK_CODE_LIST, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    //TODO get a list of greek codes
    public final static String[] BANK_CODE_LIST = {
            "0110125", //placeholder code
            "0140714", //placeholder code
            "0140101", //placeholder code
            "0260520" //placeholder code
    };
}