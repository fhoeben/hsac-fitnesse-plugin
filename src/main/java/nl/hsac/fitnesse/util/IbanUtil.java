package nl.hsac.fitnesse.util;

import java.math.BigDecimal;

/**
 * Helpers for BSNs.
 */
public class IbanUtil {
    private RandomUtil randomUtil = new RandomUtil();
    private static int LETTER_OFFSET = 9;


    /**
     * Generates random number to create IBAN.
     * BBAN gen based on: http://testnummers.nl/bank.js
     * @return random IBAN.
     */

    public String generateIban(String country, String bankCode) {
        String bban = "";
        int Nr10 = 0;
        int Nr9 = randomUtil.random(3);
        int Nr8 = randomUtil.random(10);
        int Nr7 = randomUtil.random(10);
        int Nr6 = randomUtil.random(10);
        int Nr5 = randomUtil.random(10);
        int Nr4 = randomUtil.random(10);
        int Nr3 = randomUtil.random(10);
        int Nr2 = randomUtil.random(10);
        int Nr1;

        double tmpNr = 9 * Nr9 + 8 * Nr8 + 7 * Nr7 + 6 * Nr6 + 5 * Nr5 + 4 * Nr4 + 3 * Nr3 + 2 * Nr2;
        Nr1 = (int) (Math.ceil(tmpNr / 11) * 11 - tmpNr);

        if (Nr1 > 9) {
            if (Nr2 > 0) {
                Nr2 -= 1;
                Nr1 = 8;
            } else {
                Nr2 += 1;
                Nr1 = 1;
            }
        }
        bban += Nr10;
        bban += Nr9;
        bban += Nr8;
        bban += Nr7;
        bban += Nr6;
        bban += Nr5;
        bban += Nr4;
        bban += Nr3;
        bban += Nr2;
        bban += Nr1;

        String baseIbanStr = lettersToNumbers(bankCode) + bban + lettersToNumbers(country) + "00";
        String controlNr = String.valueOf(98 - mod97(baseIbanStr));
        if (controlNr.length() == 1) {
            controlNr = "0" + controlNr;
        }
        return country.toUpperCase() + controlNr + bankCode.toUpperCase() + bban;

    }

    private int mod97(String modString) {
        String part = "";
        int modPart;

        for (int i = 0; i < modString.length(); i++){
            if (part.length() < 9)
                part = part + modString.charAt(i);
            else {
                modPart = (int)Long.parseLong(part)%97;
                part = Integer.toString(modPart) + modString.charAt(i);
            }
        }
        return (int)Long.parseLong(part)%97;
    }

    private String lettersToNumbers(String str) {
        str = str.toLowerCase();
        String result = "";
        char[] ch  = str.toCharArray();
        for(char c : ch)
        {
            int charCode = (int)c;
            int startCode = 96;
            if(charCode<=122 & charCode>=97) {
                int charNumber = (charCode - startCode) + LETTER_OFFSET;
                result += charNumber;
            }
        }
        return result;
    }

}
