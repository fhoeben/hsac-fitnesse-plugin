package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;

public class GBIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     *
     * @return random IBAN.
     */

    public String generateIban(String bankCode) {

        RandomUtil randomUtil = new RandomUtil();

        if (bankCode.length() == 0) {
            bankCode = randomUtil.randomString("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 4);
        }

        String countryCode = "GB";
        int accountLength = 14;
        String accountCodeType = "N";
        int bankCodeLength = 4;
        String bankCodeType = "A";

        bankCode = getBankCode(bankCode, bankCodeList, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    public String[] bankCodeList = {};
}