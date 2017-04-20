package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;

/**
 * Helpers for IBAN.
 */
public class NLIbanGenerator {
    private RandomUtil randomUtil = new RandomUtil();
    private IbanGenerator ibanGenerator = new IbanGenerator();

    /**
     * Generates random number to create IBAN.
     * BBAN gen based on: http://testnummers.nl/bank.js
     * @return random IBAN.
     */

    public String generateNLIban(String country, String bankCode) {

        if (country.equals("")) {
            country = "NL";
        }
        bankCode = ibanGenerator.getBankCode(bankCode, NlBankCodes);

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

        String baseIbanStr = ibanGenerator.stringToNumbersIso13616(bankCode.toUpperCase()) + bban + ibanGenerator.stringToNumbersIso13616(country.toUpperCase()) + "00";
        String controlNr = String.valueOf(98 - IbanGenerator.mod97(baseIbanStr));
        if (controlNr.length() == 1) {
            controlNr = "0" + controlNr;
        }
        return country.toUpperCase() + controlNr + bankCode.toUpperCase() + bban;

    }

    /**
     * Enum of Dutch BIC codes
     */

    public String[] NlBankCodes = {
        "ABNA", // ABN AMRO BANK
        "FTSB", // ABN AMRO BANK (ex FORTIS BANK)
        "AEGO", // AEGON BANK
        "ANAA", // ALLIANZ NEDERLAND ASSET MANAGEMENT
        "ANDL", // ANADOLUBANK
        "ARBN", // ACHMEA BANK
        "ARSN", // ARGENTA SPAARBANK
        "ARTE", // GE ARTESIA BANK
        "ASNB", // ASN BANK
        "ASRB", // ASR BANK
        "ATBA", // AMSTERDAM TRADE BANK
        "BBRU", // ING BELGIE, BREDA
        "BCDM", // BANQUE CHAABI DU MAROC
        "BCIT", // INTESA SANPAOLO
        "BICK", // BINCKBANK
        "BKCH", // BANK OF CHINA
        "BKMG", // BANK MENDES GANS
        "BLGW", // BLG WONEN
        "BMEU", // BMCE EUROSERVICES
        "BNGH", // BANK NEDERLANDSE GEMEENTEN
        "BNPA", // BNP PARIBAS
        "BOFA", // BANK OF AMERICA
        "BOFS", // BANK OF SCOTLAND, AMSTERDAM
        "BOTK", // BANK OF TOKYO-MITSUBISHI UFJ
        "CHAS", // JPMORGAN CHASE
        "CITC", // CITCO BANK
        "CITI", // CITIBANK INTERNATIONAL
        "COBA", // COMMERZBANK
        "DEUT", // DEUTSCHE BANK (bij alle SEPA transacties)
        "DHBN", // DEMIR-HALK BANK
        "DLBK", // DELTA LLOYD BANK
        "DNIB", // NIBC BANK
        "FBHL", // CREDIT EUROPE BANK
        "FLOR", // DE NEDERLANDSCHE BANK
        "FRBK", // FRIESLAND BANK
        "FRGH", // FGH BANK
        "FVLB", // F. VAN LANSCHOT BANKIERS
        "GILL", // THEODOOR GILISSEN
        "HAND", // SVENSKA HANDELSBANKEN
        "HHBA", // HOF HOORNEMAN BANKIERS
        "HSBC", // HSBC BANK
        "ICBK", // INDUSTRIAL & COMMERCIAL BANK OF CHINA
        "INGB", // ING BANK
        "INSI", // INSINGER DE BEAUFORT
        "ISBK", // ISBANK
        "KABA", // YAPI KREDI BANK
        "KASA", // KAS BANK
        "KNAB", // KNAB
        "KOEX", // KOREA EXCHANGE BANK
        "KRED", // KBC BANK
        "LOCY", // LOMBARD ODIER DARIER HENTSCH & CIE
        "LOYD", // LLOYDS TSB BANK
        "LPLN", // LEASEPLAN CORPORATION
        "MHCB", // MIZUHO CORPORATE BANK
        "NNBA", // NATIONALE-NEDERLANDEN BANK
        "NWAB", // NEDERLANDSE WATERSCHAPSBANK
        "OVBN", // LEVOB BANK
        "RABO", // RABOBANK
        "RBOS", // ROYAL BANK OF SCOTLAND
        "RBRB", // REGIOBANK
        "SNSB", // SNS BANK
        "SOGE", // SOCIETE GENERALE
        "STAL", // STAALBANKIERS
        "TEBU", // THE ECONOMY BANK
        "TRIO", // TRIODOS BANK
        "UBSW", // UBS BANK
        "UGBI", // GARANTIBANK INTERNATIONAL
        "VOWA", // VOLKSWAGEN BANK
        "ZWLB"  // ZWITSERLEVENBANK
    };
}
