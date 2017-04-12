package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;

/**
 * Generates a Belgium IBAN.
 */

public class BEIban {
    private RandomUtil randomUtil = new RandomUtil();
    private IbanUtil ibanUtil = new IbanUtil();

    /**
     * Generates random number to create IBAN.
     *
     * @return random Belgian IBAN.
     */

    public String generateBEIban(String country, String bankCode) {

        if (country.equals("")) {
            country = "BE";
        }

        bankCode = ibanUtil.getBankCode(bankCode, BEBankCodes);

        String permittedAccountDigits = "0123456789";
        String accountNumber = randomUtil.randomString(permittedAccountDigits, 7);

        String accountInclBank = bankCode + accountNumber;
        String accountControlNumber = String.valueOf(IbanUtil.mod97(accountInclBank));
        if (accountControlNumber.length() == 1) {
            accountControlNumber = "0" + accountControlNumber;
        }

        String baseIbanStr = bankCode + accountNumber + accountControlNumber + ibanUtil.stringToNumbersIso13616(country) + "00";
        String controlNr = String.valueOf(98 - IbanUtil.mod97(baseIbanStr));
        if (controlNr.length() == 1) {
            controlNr = "0" + controlNr;
        }

        return country + controlNr + bankCode + accountNumber + accountControlNumber;

    }


    /**
     * Array of Belgian Bank codes
     */

    public String[] BEBankCodes = {
            "111",   //ABK Bank
            "509",   //ABN AMRO Bank N.V.
            "639",   //ABN AMRO Bank N.V.
            "674",   //ABN AMRO Bank N.V.
            "719",   //ABN AMRO Bank N.V.
            "722",   //ABN AMRO Bank N.V.
            "960",   //ABN AMRO Bank N.V.
            "973",   //Argenta Spaarbank (ASPA)
            "980",   //Argenta Spaarbank (ASPA)
            "561",   //Arkéa Direct Bank (nom commercial / commerciële naam: Keytrade Bank)
            "651",   //Arkéa Direct Bank (nom commercial / commerciële naam: Keytrade Bank)
            "843",   //Arkéa Direct Bank (nom commercial / commerciële naam: Keytrade Bank)
            "909",   //Arkéa Direct Bank (nom commercial / commerciële naam: Keytrade Bank)
            "524",   //Attijariwafa bank Europe
            "546",   //Attijariwafa bank Europe
            "709",   //AXA Bank Europe
            "774",   //AXA Bank Europe
            "816",   //AXA Bank Europe
            "963",   //AXA Bank Europe
            "975",   //AXA Bank Europe
            "643",   //Banca Monte Paschi Belgio
            "642",   //Banco Bilbao Vizcaya Argentaria
            "177",   //Banco Santander
            "150",   //Bancontact - Mister Cash NV/SA
            "676",   //Bank Degroof Petercam
            "845",   //Bank Degroof Petercam
            "645",   //Bank J. Van Breda & C°
            "132",   //Bank Nagelmackers
            "636",   //Bank Nagelmackers
            "647",   //Bank Nagelmackers
            "872",   //Bank Nagelmackers
            "874",   //Bank Nagelmackers
            "879",   //Bank Nagelmackers
            "686",   //Bank of Amerika Merrill Lynch International Ltd
            "183",   //Bank of Baroda
            "605",   //Bank of China (Luxembourg) S.A., Brussels Branch
            "541",   //BANK OF INDIA
            "940",   //Banque Centrale de Compensation (Clearnet)
            "664",   //Banque Chaabi du Maroc
            "171",   //Banque CPH
            "126",   //Banque CPH
            "823",   //Banque de Luxembourg
            "583",   //Banque Degroof Luxembourg
            "968",   //Banque Eni
            "588",   //Banque Transatlantique Belgium
            "099",   //BELFIUS BANK
            "560",   //BELFIUS BANK
            "569",   //BELFIUS BANK
            "625",   //BELFIUS BANK
            "638",   //BELFIUS BANK
            "657",   //BELFIUS BANK
            "672",   //BELFIUS BANK
            "680",   //BELFIUS BANK
            "683",   //BELFIUS BANK
            "799",   //BELFIUS BANK
            "839",   //BELFIUS BANK
            "110",   //Beobank
            "114",   //Beobank
            "124",   //Beobank
            "127",   //Beobank
            "129",   //Beobank
            "131",   //Beobank
            "134",   //Beobank
            "601",   //Beobank
            "959",   //Beobank
            "587",   //BinckBank
            "663",   //BMCE Euro Services
            "049",   //BNP Paribas Fortis
            "137",   //BNP Paribas Fortis
            "149",   //BNP Paribas Fortis
            "214",   //BNP Paribas Fortis
            "298",   //BNP Paribas Fortis
            "508",   //BNP Paribas Securities Services
            "679",   //bpost
            "873",   //bpost
            "984",   //bpost
            "989",   //bpost
            "999",   //Bpost
            "000",   //bpost bank
            "299",   //bpost bank
            "988",   //bpost bank
            "675",   //Byblos Bank Europe
            "941",   //C A Indosuez Wealth (Europe)
            "817",   //CACEIS Bank Belgian Branch
            "649",   //Caisse d'Epargne Nord France Europe
            "199",   //CBC Banque et Assurances
            "729",   //CBC Banque et Assurances
            "732",   //CBC Banque et Assurances
            "742",   //CBC Banque et Assurances
            "906",   //Centrale Kredietverlening (C.K.V.)
            "908",   //Centrale Kredietverlening (C.K.V.)
            "579",   //Citibank Europe Plc - Belgium Branch
            "943",   //CNH Financial Services SAS
            "670",   //CNH Industrial Capital EUROPE
            "179",   //Commerzbank
            "677",   //Compagnie de Banque Privée Quilvest
            "173",   //Coöperatieve Rabobank U.A.
            "696",   //Crédit Agricole Corporate & Investment Bank
            "535",   //CREDIT EUROPE BANK NV
            "586",   //Crédit Foncier de France
            "108",   //Crelan
            "853",   //Crelan
            "860",   //Crelan
            "863",   //Crelan
            "866",   //Crelan
            "678",   //Delen Private Bank
            "501",   //Demir-Halk Bank (Nederland) (DHB)
            "613",   //Deutsche Bank AG
            "694",   //Deutsche Bank AG
            "826",   //Deutsche Bank AG
            "507",   //Dierickx, Leys & Cie Effectenbank
            "840",   //Edmond de Rothschild (Europe)
            "609",   //Elavon Financial Services Designated Activity Company
            "913",   //EPBF
            "687",   //Euroclear Bank
            "671",   //Europabank
            "521",   //F. van Lanschot Bankiers
            "525",   //F. van Lanschot Bankiers
            "517",   //FCE Bank
            "914",   //FX4BIZ
            "916",   //GOLD COMMODITIES FOREX (G.C.F.)
            "658",   //Habib Bank
            "912",   //Hi - Media Porte Monnaie Electronique
            "538",   //Hoist Finance
            "949",   //HSBC Bank
            "584",   //ICICI Bank UK Limited
            "607",   //Industrial and Commercial Bank of China (Europe)
            "824",   //ING Bank
            "399",   //ING België
            "622",   //ING België
            "631",   //ING België
            "911",   //Ingenico Financial Solutions
            "944",   //J.P. Morgan Europe Ltd .
            "945",   //J.P. Morgan International Bank Limited
            "549",   //JP Morgan Chase Bank
            "499",   //KBC Bank
            "727",   //KBC Bank
            "731",   //KBC Bank
            "741",   //KBC Bank
            "749",   //KBC Bank
            "868",   //KBC Bank
            "640",   //KBC Bank N.V. Business Center Diamant
            "548",   //Lombard Odier (Europe)
            "876",   //MeDirect Bank S.A.
            "581",   //Mizuho Bank Europe N.V. Brussels Branch
            "500",   //Moneytrans Payment Services
            "693",   //MUFG Bank (Europe)
            "101",   //Nationale Bank van België
            "698",   //Natixis Bank
            "512",   //NIBC BANK
            "915",   //Oonex
            "858",   //PSA Finance
            "514",   //Puilaetco Dewaay Private Bankers
            "942",   //Puilaetco Dewaay Private Bankers
            "969",   //Puilaetco Dewaay Private Bankers
            "844",   //Rabobank.be
            "927",   //RBC Investor Services Bank
            "585",   //Rothschild & Cie Banque GCV
            "176",   //Santander Benelux
            "594",   //Santander Benelux
            "530",   //Shizuoka Bank (Europe)
            "688",   //Société Générale (Paris)
            "513",   //Société Générale Private Banking
            "668",   //State Bank of India
            "189",   //Sumitomo Mitsui Banking Corporation (SMBC)
            "175",   //Systèmes Technologiques d'Echange et de Traitement - STET
            "519",   //The Bank of New York Mellon
            "515",   //The Bank of New York Mellon NV/SA
            "721",   //The Royal Bank of Scotland Plc, Belgium branch
            "724",   //The Royal Bank of Scotland Plc, Belgium branch
            "523",   //Triodos Bank
            "102",   //Uitwisselingscentrum en Verrekening (U.C.V.)
            "540",   //Union Bank of India
            "522",   //United Taiwan Bank
            "510",   //VAN DE PUT & CO Privaatbankiers
            "899",   //Volksdepositokas Spaarbank (VDK Spaarbank)
            "666",   //WORLDLINE NV
            "669",   //WORLDLINE NV

    };
}
