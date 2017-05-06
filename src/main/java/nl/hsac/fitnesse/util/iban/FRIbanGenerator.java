package nl.hsac.fitnesse.util.iban;

public class FRIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     *
     * @param bankCode bank code to (blank for random).
     * @return random IBAN.
     */
    public String generateIban(String bankCode) {

        String countryCode = "FR";
        int accountLength = 11;
        String accountCodeType = "M";
        int bankCodeLength = 5;
        String bankCodeType = "N";

        String codeGuichet = getRandomStringNumeric(5);

        bankCode = getBankCode(bankCode, BANK_CODE_LIST, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String accountEncoded = encodeAccount(account);

        String accountControl = bankCode + codeGuichet + accountEncoded + "00";
        accountControl = getAccountControlNumberUsingMod97(accountControl);


        account = codeGuichet + account + accountControl;
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    private String getAccountControlNumberUsingMod97(String accountControl) {
        int accountControlNumber = 97 - mod97(accountControl);
        accountControl = Integer.toString(accountControlNumber);
        if (accountControl.length() == 1) {
            accountControl = "0" + accountControl;
        }
        return accountControl;
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

    //TODO Get a list of Frech bank codes, these are random codes found on the net
    public final static String[] BANK_CODE_LIST = {
            "20041",
            "30001",
            "30047",
            "30003"
    };

}