package nl.hsac.fitnesse.util.iban;

/**
 * Created by Koen on 20-4-2017.
 */
public class BGIbanGenerator extends IbanGenerator {
    /**
     * Generates random number to create IBAN.
     *
     * @return random Bulgarian IBAN.
     */

    public String generateIban(String bankCode) {

        String countryCode = "BG";
        int accountLength = 8;
        String accountCodeType = "A";
        int bankCodeLength = 4;
        String BranchAccountType = getRandomStringNumeric(6);

        bankCode = getBGBankCode(bankCode, bankCodeList, bankCodeLength);
        String account = BranchAccountType + getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;


    }

    public String getBGBankCode(String bankCode, String[] bankCodesArray, int bankCodeLength) {

        if (bankCode.length() == 0) {
            if (bankCodesArray.length > 0) {
                return RANDOM_UTIL.randomElement(bankCodesArray);
            } else {
                return RANDOM_UTIL.randomString("ABCDEFGHIJKLMNOPQRSTUVWXYZ", bankCodeLength);
            }
        } else if (bankCode.length() < bankCodeLength) {
            throw new IllegalArgumentException("The supplied bankcode is shorter than the Iban specification allows for");
        } else if (bankCode.length() > bankCodeLength) {
            throw new IllegalArgumentException("The supplied bankcode is longer than the Iban specification allows for");
        } else {
            return bankCode;
        }

    }

    String[] bankCodeList = {};

}