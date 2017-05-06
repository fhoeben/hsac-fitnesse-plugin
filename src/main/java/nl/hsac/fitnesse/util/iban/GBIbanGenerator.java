package nl.hsac.fitnesse.util.iban;

public class GBIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     * Formally the UK has no check outside the bank and swift code, in practise each bank has it's own checksum
     * As with other country implementations that are not uniform, it is ignored here (and by the IBAN specifications)
     *
     * @param bankCode bank code to (blank for random).
     * @return random IBAN.
     */
    public String generateIban(String bankCode) {

        String countryCode = "GB";
        int accountLength = 14;
        String accountCodeType = "N";
        int bankCodeLength = 4;
        String bankCodeType = "A";

        bankCode = getBankCode(bankCode, BANK_CODE_LIST, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    //TODO get a list of the UK banks here
    public final static String[] BANK_CODE_LIST = {
            "HSBC",
            "NWBK"
    };

}