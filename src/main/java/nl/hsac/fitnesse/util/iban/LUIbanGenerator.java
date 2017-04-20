package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;

/**
 * Generates a Luxembourg IBAN.
 */

public class LUIbanGenerator {
    private RandomUtil randomUtil = new RandomUtil();
    private IbanGenerator ibanGenerator = new IbanGenerator();

    /**
     * Generates random number to create IBAN.
     *
     * @return random Luxembourg IBAN.
     */

    public String generateLUIban(String country, String bankCode) {

        if (country.equals("")) {
            country = "LU";
        }

        bankCode = ibanGenerator.getBankCode(bankCode, LUBankCodes);

        String permittedAccountDigits = "0123456789";
        String accountNumber = randomUtil.randomString(permittedAccountDigits, 13);

        String baseIbanStr = bankCode + accountNumber + ibanGenerator.stringToNumbersIso13616(country) + "00";

        String controlNr = String.valueOf(98 - IbanGenerator.mod97(baseIbanStr));
        if (controlNr.length() == 1) {
            controlNr = "0" + controlNr;
        }

        return country + controlNr + bankCode + accountNumber;

    }


    /**
     * Array of Luxembourg Bank codes
     */

    public String[] LUBankCodes = {
            "001",    //Banque et Caisse d'Epargne de l'Etat, Luxembourg
            "002",    //Banque Internationale à Luxembourg S.A.
            "003",    //BGL BNP Paribas S.A.
            "007",    //CACEIS Bank Luxembourg
            "008",    //Banque de Luxembourg
            "009",    //Banque Raiffeisen
            "010",    //Fortuna Banque s.c.
            "014",    //ING Luxembourg
            "025",    //Banque BCP S.A.
            "032",    //Commerzbank International S.A.
            "034",    //Citibank International Limited, Luxembourg Branch
            "036",    //Deutsche Bank Luxembourg S.A.
            "038",    //Union Bancaire Privée (Europe) S.A.
            "040",    //DekaBank Deutsche Girozentrale Luxembourg S.A.
            "047",    //UniCredit Luxembourg S.A.
            "049",    //BHF-BANK International S.A.
            "051",    //NORD/LB Luxembourg S.A. Covered Bond Bank
            "058",    //M.M.Warburg & CO Luxembourg S.A.
            "061",    //Société Générale Bank & Trust
            "062",    //Hauck & Aufhäuser Privatbankiers KGaA, Niederlassung Luxemburg
            "064",    //Skandinaviska Enskilda Banken S.A.
            "067",    //J.P. Morgan Bank Luxembourg S.A.
            "070",    //UBS (Luxembourg) S.A.
            "076",    //Credem International (Lux) S.A.
            "077",    //Mitsubishi UFJ Global Custody S.A.
            "078",    //Credit Suisse (Luxembourg) S.A.
            "080",    //SMBC Nikko Bank (Luxembourg) S.A.
            "082",    //East-West United Bank S.A.
            "083",    //Banque Degroof Luxembourg S.A.
            "087",    //Société Européenne de Banque S.A.
            "092",    //Nordea Bank S.A.
            "093",    //Danske Bank International S.A.
            "095",    //BHW Bausparkasse AG, Niederlassung Luxemburg
            "097",    //HSH Nordbank Securities S.A.
            "104",    //Société Nationale de Crédit et d'Investissement
            "107",    //DZ PRIVATBANK S.A.
            "108",    //Wüstenrot Bausparkasse AG, Niederlassung Luxemburg
            "111",    //POST Group
            "116",    //Bank of China Limited Luxembourg Branch
            "117",    //Banque Hapoalim (Suisse) S.A., Succursale de Luxembourg
            "123",    //Crédit Agricole Luxembourg
            "131",    //State Street Bank Luxembourg S.A. (formerly Sanpaolo Bank S.A.)
            "133",    //Banco Bradesco Europa S.A.
            "134",    //Banque de Commerce et de Placements S.A., Luxembourg Branch
            "135",    //DekaBank Deutsche Girozentrale, Succursale de Luxembourg
            "140",    //BEMO Europe - Banque Privée
            "143",    //DNB Luxembourg S.A.
            "144",    //IKB Deutsche Industriebank AG, Filiale Luxemburg
            "146",    //Sumitomo Mitsui Trust Bank (Luxembourg) S.A.
            "147",    //HSBC Private Bank (Luxembourg) S.A.
            "148",    //Banque J. Safra Sarasin (Luxembourg) SA
            "149",    //BNP Paribas, Luxembourg Branch
            "151",    //Eurobank Private Bank Luxembourg S.A.
            "158",    //UniCredit International Bank (Luxembourg) S.A.
            "162",    //The Royal Bank of Scotland Plc, Luxembourg Branch
            "164",    //HSH Nordbank AG, Luxembourg Branch
            "167",    //HSBC Bank Plc, Luxembourg Branch
            "172",    //Edmond de Rothschild (Europe)
            "173",    //Berenberg Bank, Niederlassung Luxemburg
            "177",    //Bankinter Luxembourg S.A.
            "178",    //Brown Brothers Harriman (Luxembourg) S.C.A.
            "181",    //Mizuho Trust & Banking (Luxembourg) S.A.
            "183",    //VP Bank (Luxembourg) SA
            "184",    //Erste Europäische Pfandbrief- und Kommunalkreditbank AG in Luxemburg
            "189",    //Cornèr Banque (Luxembourg) S.A.
            "193",    //Banque Transatlantique Luxembourg S.A.
            "194",    //Catella Bank S.A.
            "197",    //Natixis Bank
            "198",    //Pictet & Cie (Europe) S.A.
            "202",    //State Street Bank Luxembourg S.A.
            "204",    //Nomura Bank (Luxembourg) S.A.
            "213",    //Argentabank Luxembourg S.A.
            "215",    //Crédit Agricole Corporate and Investment Bank, Luxembourg Branch
            "220",    //Bausparkasse Schwäbisch Hall AG, Niederlassung Luxemburg
            "222",    //Bank of China (Luxembourg) S.A.
            "226",    //Banque Hapoalim (Luxembourg) S.A.
            "229",    //Svenska Handelsbanken AB (Publ), Luxembourg Branch
            "259",    //Deutsche Bank AG, Niederlassung Luxemburg
            "264",    //Banque Carnegie Luxembourg S.A.
            "265",    //Deutsche Postbank AG Zweigniederlassung Luxemburg
            "267",    //Sal. Oppenheim jr. & Cie. Luxembourg S.A.
            "269",    //The Bank of New York Mellon (International) Ltd., Luxembourg Branch
            "271",    //Garanti Bank Luxembourg Branch
            "281",    //Freie Internationale Sparkasse S.A.
            "284",    //Banco Popolare Luxembourg S.A.
            "287",    //Europäische Genossenschaftsbank S.A.
            "288",    //Bank Leumi (Luxembourg) S.A.
            "289",    //Clearstream Banking
            "298",    //Banca popolare dell'Emilia Romagna (Europe) International S.A.
            "301",    //UBI Banca International S.A.
            "302",    //Caixa Geral de Depósitos, Succursale de Luxembourg
            "305",    //Delen Private Bank Luxembourg S.A.
            "308",    //Fideuram Bank (Luxembourg) S.A.
            "310",    //The Bank of New York Mellon (Luxembourg) S.A.
            "314",    //Hypo Pfandbrief Bank International S.A.
            "315",    //Erste Europäische Pfandbrief- und Kommunalkreditbank AG in Luxemburg
            "316",    //Industrial and Commercial Bank of China Ltd., Luxembourg Branch
            "317",    //John Deere Bank S.A.
            "318",    //Banque Havilland S.A.
            "320",    //BSI Europe S.A.
            "323",    //Banque Puilaetco Dewaay Luxembourg S.A.
            "324",    //TD Bank International S.A.
            "328",    //BNP Paribas Securities Services, Luxembourg Branch
            "329",    //Frankfurter Volksbank International S.A.
            "336",    //Northern Trust Global Services Limited, Luxembourg Branch
            "338",    //Credit Suisse AG, Luxembourg Branch
            "340",    //The Bank of New York Mellon S.A./N.V., Luxembourg Branch
            "341",    //RBC Investor Services Bank S.A.
            "342",    //Mediobanca International (Luxembourg) S.A.
            "343",    //EFG Bank (Luxembourg) S.A.
            "344",    //Advanzia Bank S.A.
            "347",    //Commerzbank AG, Filiale Luxemburg
            "348",    //Industrial and Commercial Bank of China (Europe) S.A.
            "349",    //Citco Bank Nederland N.V., Luxembourg Branch
            "350",    //Compagnie de Banque Privée Quilvest S.A.
            "351",    //PayPal (Europe) S.à r.l. et Cie, S.C.A.
            "352",    //Dexia LdG Banque S.A.
            "354",    //Banque Öhman S.A.
            "355",    //ABN AMRO Bank (Luxembourg) S.A.
            "358",    //State Street Bank GmbH, Zweigniederlassung Luxemburg
            "359",    //Keytrade Bank Luxembourg S.A.
            "360",    //Andbank Luxembourg
            "361",    //Banque de Patrimoines Privés
            "364",    //Lombard Odier (Europe) S.A.
            "365",    //Novo Banco S.A., Succursale de Luxembourg
            "368",    //Banca March, S.A., Luxembourg Branch
            "369",    //ABLV Bank Luxembourg S.A.
            "374",    //HSBC Bank Plc, Luxembourg Branch
            "375",    //China Construction Bank (Europe) S.A.
            "377",    //China Construction Bank Corporation, Luxembourg Branch
            "379",    //GPB International S.A.
            "381",    //Mirabaud & Cie (Europe) S.A.
            "384",    //RCB Bank Ltd, Luxembourg Branch
            "390",    //Bank of Communications (Luxembourg) S.A.
            "391",    //China Merchants Bank Co., Ltd., Luxembourg Branch
            "705",    //KBL European Private Bankers S.A.
            "806",    //iPay International S.A.
            "999",    //Banque centrale du Luxembourg
    };
}
