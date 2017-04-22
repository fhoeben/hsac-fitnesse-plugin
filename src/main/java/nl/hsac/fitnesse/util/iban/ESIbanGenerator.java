package nl.hsac.fitnesse.util.iban;

public class ESIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     * see https://docs.oracle.com/cd/E18727_01/doc.121/e13483/T359831T498954.htm
     * for explanation on the checksum calculations
     *
     * @return random IBAN.
     */

    public String generateIban(String bankCode) {

        String countryCode = "ES";
        int accountLength = 10;
        String accountCodeType = "N";
        int bankCodeLength = 8;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, bankCodeList, bankCodeLength, bankCodeType);
        String checkDigit1 = checkDigit1(bankCode);
        String account = getAccount(accountLength, accountCodeType);
        String checkDigit2 = checkDigit2(account);
        account = checkDigit1 + checkDigit2 + account;
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    public String checkDigit1(String bankcode) {
        int n1 = bankcode.charAt(0) * 4;
        int n2 = bankcode.charAt(1) * 8;
        int n3 = bankcode.charAt(2) * 5;
        int n4 = bankcode.charAt(3) * 10;
        int n5 = bankcode.charAt(4) * 9;
        int n6 = bankcode.charAt(5) * 7;
        int n7 = bankcode.charAt(6) * 3;
        int n8 = bankcode.charAt(7) * 6;

        int controlNumber = 11 - (n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8) % 11;
        if (controlNumber == 10) {
            controlNumber = 1;
        }

        return Integer.toString(controlNumber);
    }

    public String checkDigit2(String account) {
        int n1 = account.charAt(0) * 1;
        int n2 = account.charAt(1) * 2;
        int n3 = account.charAt(2) * 4;
        int n4 = account.charAt(3) * 8;
        int n5 = account.charAt(4) * 5;
        int n6 = account.charAt(5) * 10;
        int n7 = account.charAt(6) * 9;
        int n8 = account.charAt(7) * 7;
        int n9 = account.charAt(7) * 3;
        int n10 = account.charAt(7) * 6;

        int controlNumber = 11 - (n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10) % 11;
        if (controlNumber == 10) {
            controlNumber = 1;
        }

        return Integer.toString(controlNumber);

    }

    public String[] bankCodeList = {};
}