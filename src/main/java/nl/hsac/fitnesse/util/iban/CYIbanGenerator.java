package nl.hsac.fitnesse.util.iban;

/**
 * Created by Koen on 20-4-2017.
 */
public class CYIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     *
     * @return random Austrian IBAN.
     */

    public String generateIban(String bankCode) {

        String countryCode = "CY";
        int accountLength = 16;
        String accountCodeType = "N";
        int bankCodeLength = 8;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, bankCodeList, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    public String[] bankCodeList = {};
}