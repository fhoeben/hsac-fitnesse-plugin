package nl.hsac.fitnesse.util.iban;

/**
 * Sample of what IbanGenerator for country XX looks like.
 */
public class XXIbanGeneratorExample extends IbanGenerator {

    /**
     * @param bankCode bank code to (blank for random).
     * @return random XX IBAN.
     */
    public String generateIban(String bankCode) {
        String countryCode = "XX";
        int accountLength = 11;
        String accountCodeType = "N";
        int bankCodeLength = 5;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, BANK_CODE_LIST, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;
    }

    public final static String[] BANK_CODE_LIST = {};
}