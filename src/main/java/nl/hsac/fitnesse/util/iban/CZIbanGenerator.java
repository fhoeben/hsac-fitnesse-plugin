package nl.hsac.fitnesse.util.iban;

public class CZIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     *
     * @return random IBAN.
     */

    public String generateIban(String bankCode) {

        String countryCode = "CZ";
        int accountLength = 16;
        String accountCodeType = "N";
        int bankCodeLength = 4;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, BANK_CODE_LIST, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    public final static String[] BANK_CODE_LIST = {
            "0100",    //Komerční banka, a.s.
            "0300",    //Československá obchodní banka, a.s.
            "0600",    //GE Money Bank, a.s.
            "0710",    //Czech National Bank
            "0800",    //Česká spořitelna, a.s.
            "2010",    //Fio, družstevní záložna
            "2020",    //Bank of Tokyo-Mitsubishi UFJ (Holland) N.V. Prague Branch, organizační složka
            "2030",    //AKCENTA, spořitelní a úvěrní družstvo
            "2040",    //UNIBON – spořitelní a úvěrní družstvo
            "2050",    //WPB Capital, spořitelní družstvo
            "2060",    //Prague Credit Union, spořitelní družstvo
            "2070",    //Moravský Peněžní Ústav – spořitelní družstvo
            "2100",    //Hypoteční banka, a.s.
            "2200",    //Peněžmí dům, spořitelní družstvo
            "2600",    //Citibank Europe plc, organizační složka
            "2700",    //UniCredit Bank Czech Republic, a.s.
            "3500",    //ING Bank N.V.
            "4000",    //LBBW Bank CZ a.s.
            "4300",    //Českomoravská záruční a rozvojová banka, a.s.
            "5000",    //CALYON S.A. organizační složka
            "5400",    //ABN AMRO Bank N.V.
            "5500",    //Raiffeisenbank a.s.
            "5800",    //J & T Banka, a.s.
            "6000",    //PPF banka a.s.
            "6100",    //Banco Popolare Česká republika, a.s.
            "6200",    //COMMERZBANK AG, pobočka Praha
            "6210",    //BRE Bank S.A., organizační složka podniku
            "6300",    //Fortis Bank SA/NV, pobočka ČR
            "6700",    //Všeobecná úverová banka, a.s., pobočka Praha
            "6800",    //Volksbank CZ, a.s.
            "7910",    //Deutsche Bank AG Filiale Prag
            "7940",    //Waldviertler Sparkasse von 1842
            "7950",    //Raiffeisen stavební spořitelna a.s.
            "7960",    //Českomoravská stavební spořitelna a.s.
            "7970",    //Wüstenrot-stavební spořitelna a.s.
            "7980",    //Wüstenrot hypoteční banka, a.s. se sídlem v Praze
            "7990",    //Modrá pyramida stavební spořitelna, a.s.
            "8030",    //Raiffeisenbank im Stiftland eG pobočka Cheb, odštěpný závod
            "8040",    //Oberbank AG pobočka Česká republika
            "8090",    //Česká exportní banka, a.s.
            "8150",    //HSBC Bank plc - pobočka Praha
            "8200",    //PRIVAT BANK AG der Raiffeisenlandesbank Oberösterreich
            "8210",    //STRB Straumur-Burdaras Investment Bank hf - organizačnísložka
    };
}