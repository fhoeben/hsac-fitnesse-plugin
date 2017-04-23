package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;

public class BGIbanGenerator extends IbanGenerator {
    private final RandomUtil RANDOM_UTIL = new RandomUtil();


    /**
     * Generates random number to create IBAN.
     *
     * @return random Bulgarian IBAN.
     */

    public String generateIban(String bankCode) {

        String countryCode = "BG";
        int accountLength = 14;
        String accountCodeType = "N";
        int bankCodeLength = 4;
        String bankCodeType = "A";

        bankCode = getBankCode(bankCode, BANK_CODE_LIST, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }


    public final static String[] BANK_CODE_LIST = {
            "BUIN",   //ALLIANZ BANK BULGARIA AD	SOFIA
            "BSBG",   //BANKSERVICE AD	SOFIA	(T2 INTEROPERABILITY)
            "BSBG",   //BANKSERVICE AD	SOFIA
            "BNPA",   //BNP PARIBAS S.A.-SOFIA BRANCH	SOFIA
            "NASB",   //BULGARIAN DEVELOPMENT BANK (FORMERLY ENCOURAGEMENT BANK)	SOFIA
            "BNBG",   //BULGARIAN NATIONAL BANK	SOFIA
            "BNBG",   //BULGARIAN NATIONAL BANK - BGN	SOFIA
            "BGUS",   //BULGARIAN-AMERICAN CREDIT BANK	SOFIA
            "CECB",   //CENTRAL COOPERATIVE BANK PLC	SOFIA
            "CEDP",   //CENTRAL DEPOSITORY AD	SOFIA
            "BUIB",   //CIBANK JSC	SOFIA
            "CITI",   //CITIBANK EUROPE PLC, BULGARIA BRANCH	SOFIA	(TRADE SERVICES DEPARTMENT)
            "CITI",   //CITIBANK EUROPE PLC, BULGARIA BRANCH	SOFIA
            "BINV",   //COMMERCIAL BANK VICTORIA EAD	SOFIA
            "DEMI",   //D COMMERCE BANK AD	SOFIA
            "STSA",   //DSK BANK (FORMERLY STATE SAVINGS BANK)	SOFIA
            "BPBI",   //EUROBANK BULGARIA AD	SOFIA	(CUSTODY DEPARTMENT)
            "BPBI",   //EUROBANK BULGARIA AD	SOFIA	(INTERNATIONAL SECURITIES DEPOSITORY)
            "BPBI",   //EUROBANK BULGARIA AD	SOFIA
            "EUFC",   //EURO-FINANCE LTD	SOFIA
            "FINV",   //FIRST INVESTMENT BANK AD	SOFIA
            "INGB",   //ING BANK N.V. SOFIA BRANCH	SOFIA
            "INTF",   //INTERCARD FINANCE AD	SOFIA
            "IABG",   //INTERNATIONAL ASSET BANK AD	SOFIA
            "IORT",   //INVESTBANK PLC	SOFIA
            "ISBK",   //ISBANK AG SOFIA BRANCH	SOFIA
            "SOMB",   //MUNICIPAL BANK PLC	SOFIA
            "PIRB",   //PIRAEUS BANK BULGARIA AD	SOFIA
            "PRCB",   //PROCREDIT BANK (BULGARIA) EAD	SOFIA
            "RZBB",   //RAIFFEISENBANK (BULGARIA) EAD	SOFIA
            "TTBB",   //SOCIETE GENERALE EXPRESSBANK	VARNA	(CUSTODY MANAGEMENT)
            "TTBB",   //SOCIETE GENERALE EXPRESSBANK	VARNA
            "TCZB",   //T.C. ZIRAAT BANKASI - SOFIA BRANCH	SOFIA
            "TBIB",   //TBI BANK EAD	SOFIA
            "TEXI",   //TEXIM BANK AD	SOFIA
            "CREX",   //TOKUDA BANK AD	SOFIA
            "UNCR",   //UNICREDIT BULBANK AD	PLOVDIV	(PLOVDIV BRANCH)
            "UNCR",   //UNICREDIT BULBANK AD	SOFIA	(SERDIKA BRANCH)
            "UNCR",   //UNICREDIT BULBANK AD	SOFIA	(VITOSHA BRANCH)
            "UNCR",   //UNICREDIT BULBANK AD	SOFIA
            "UNCR",   //UNICREDIT BULBANK AD	V. TARNOVO	(V. TARNOVO BRANCH)
            "UNCR",   //UNICREDIT BULBANK AD	VARNA
            "UBBS",   //UNITED BULGARIAN BANK	SOFIA	(HEADQUARTER)
    };

}