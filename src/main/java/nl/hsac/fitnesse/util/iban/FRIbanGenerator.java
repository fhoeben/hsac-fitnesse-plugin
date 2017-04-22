package nl.hsac.fitnesse.util.iban;

public class FRIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     *
     * @return random IBAN.
     */

    public String generateIban(String bankCode) {

        String countryCode = "FR";
        int accountLength = 11;
        String accountCodeType = "M";
        int bankCodeLength = 5;
        String bankCodeType = "N";

        String codeGuichet = getRandomStringNumeric(5);

        bankCode = getBankCode(bankCode, bankCodeList, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String accountEncoded = encodeAccount(account);
        String accountControl = bankCode + codeGuichet + accountEncoded + "00";
        account = codeGuichet + account + Integer.toString(mod97(accountControl));
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    private String encodeAccount(String account) {

        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digit = "012345678912345678912345678923456789";

        char[] letters = account.toCharArray();
        String result = "";
        for (int j = 0; j < letters.length; j++)
            for (int i = 0; i < chars.length(); i++)
                if (letters[j] == chars.charAt(i)) {
                    result = result + digit.charAt(i);
                }
        return result;
    }

    public String[] bankCodeList = {};
}