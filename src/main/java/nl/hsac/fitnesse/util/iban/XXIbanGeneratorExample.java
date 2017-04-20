package nl.hsac.fitnesse.util.iban;

/**
 * Created by Koen on 20-4-2017.
 */
public class XXIbanGeneratorExample extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     *
     * @return random Austrian IBAN.
     */

    public String generateIban(String bankCode) {

        String countryCode = "XX";
        int accountLength = 11;
        String accountCodeType = "N";
        int bankCodeLength = 5;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, bankCodeList, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    public String[] bankCodeList = {};
}