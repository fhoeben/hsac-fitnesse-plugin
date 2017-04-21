package nl.hsac.fitnesse.util.iban;

/**
 * Generates a German IBAN.
 */

public class DEIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create German IBAN.
     *
     * @return random German IBAN.
     */
    public String generateIban(String bankCode) {

        String countryCode = "DE";
        int accountLength = 10;
        String accountCodeType = "N";
        int bankCodeLength = 8;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, BANK_CODE_LIST, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    public final static String[] BANK_CODE_LIST = {
            "10000000",    //Bundesbank
            "10010010",    //Postbank
            "10010111",    //SEB
            "10010424",    //Aareal Bank
            "10011001",    //N26 Bank
            "10019610",    //Dexia Kommunalbank Deutschland
            "10020200",    //BHF-BANK
            "10020500",    //Bank für Sozialwirtschaft
            "10020510",    //Bank für Sozialwirtschaft
            "10020520",    //Bank für Sozialwirtschaft
            "10020890",    //UniCredit Bank - HypoVereinsbank
            "10030200",    //Berlin Hyp
            "10030400",    //ABK Allgemeine Beamten Bank
            "10030500",    //Bankhaus Löbbecke
            "10030600",    //North Channel Bank
            "10030700",    //Eurocity Bank
            "10031000",    //EIS Einlagensicherungsbank
            "10033300",    //Santander Consumer Bank
            "10040000",    //Commerzbank, Filiale Berlin 1
            "10040005",    //Commerzbank, Filiale Berlin 3
            "10040010",    //Commerzbank, CC SP
            "10040048",    //Commerzbank GF-B48
            "10040060",    //Commerzbank Gf 160
            "10040061",    //Commerzbank Gf 161
            "10040062",    //Commerzbank CC
            "10040063",    //Commerzbank CC
            "10040085",    //Commerzbank, Gf Web-K
            "10045050",    //Commerzbank Service-BZ
            "10050000",    //Landesbank Berlin - Berliner Sparkasse
            "10050005",    //Landesbank Berlin - E 1 -
            "10050006",    //Landesbank Berlin - E 2 -
            "10050007",    //Landesbank Berlin - E 3 -
            "10050008",    //Landesbank Berlin - E 4 -
            "10050020",    //LBB S-Kreditpartner, Berlin
            "10050500",    //LBS Ost Berlin
            "10050999",    //DekaBank Berlin
            "10060198",    //Pax-Bank
            "10061006",    //Bank für Kirche und Diakonie - KD-Bank Gf Sonder-BLZ
            "10070000",    //Deutsche Bank Fil Berlin
            "10070024",    //Deutsche Bank Privat und Geschäftskunden F 700
            "10070100",    //Deutsche Bank Fil Berlin II
            "10070124",    //Deutsche Bank Privat und Geschäftskd Berlin II
            "10070848",    //Berliner Bank Niederlassung der Deutsche Bank PGK
            "10077777",    //norisbank
            "10080000",    //Commerzbank vormals Dresdner Bank Filiale Berlin I
            "10080005",    //Commerzbank vormals Dresdner Bank Zw A
            "10080006",    //Commerzbank vormals Dresdner Bank Zw B
            "10080055",    //Commerzbank vormals Dresdner Bank Zw 55
            "10080057",    //Commerzbank vormals Dresdner Bank Gf ZW 57
            "10080085",    //Commerzbank vormals Dresdner Bank Gf PCC DCC-ITGK 3
            "10080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 4
            "10080087",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 5
            "10080088",    //Commerzbank vormals Dresdner Bank IBLZ
            "10080089",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 6
            "10080900",    //Commerzbank vormals Dresdner Bank Filiale Berlin III
            "10089260",    //Commerzbank vormals Dresdner Bank ITGK
            "10089999",    //Commerzbank vormals Dresdner Bank ITGK 2
            "10090000",    //Berliner Volksbank
            "10090300",    //Bank für Schiffahrt (BFS) Fil d Ostfr VB Leer
            "10090603",    //apoBank
            "10090900",    //PSD Bank Berlin-Brandenburg
            "10110300",    //Privatbank Berlin von 1929
            "10110400",    //Investitionsbank Berlin
            "10110600",    //quirin bank
            "10120100",    //Weberbank
            "10120600",    //Santander Consumer Bank
            "10120800",    //VON ESSEN Bank
            "10130600",    //Isbank Fil Berlin
            "10130800",    //BIW Bank
            "10220500",    //Bank of Scotland Ndl Berlin
            "10220600",    //Sydbank Filiale Berlin
            "10310600",    //Tradegate Wertpapierhandelsbank Berlin
            "11010100",    //solarisBank
            "12016836",    //KfW Kreditanstalt für Wiederaufbau
            "12030000",    //Deutsche Kreditbank Berlin
            "12030900",    //Merck Finck Privatbankiers
            "12040000",    //Commerzbank Filiale Berlin 2
            "12050555",    //NLB FinanzIT
            "12060000",    //DZ BANK
            "12070000",    //Deutsche Bank Ld Brandenburg
            "12070024",    //Deutsche Bank Privat und Geschäftskunden
            "12070070",    //Deutsche Bank (Gf intern)
            "12070088",    //Deutsche Bank (Gf intern)
            "12080000",    //Commerzbank vormals Dresdner Bank Filiale Berlin II
            "12090640",    //apoBank
            "12096597",    //Sparda-Bank Berlin
            "13000000",    //Bundesbank
            "13010111",    //SEB
            "13040000",    //Commerzbank
            "13050000",    //Ostseesparkasse Rostock
            "13051042",    //Sparkasse Vorpommern auf Rügen
            "13061008",    //Volksbank Wolgast
            "13061028",    //Volksbank Raiffeisenbank ehem VB Greifswald
            "13061078",    //Volks- und Raiffeisenbank
            "13061088",    //Raiffeisenbank Wismar -alt-
            "13061128",    //Raiffeisenbank
            "13070000",    //Deutsche Bank
            "13070024",    //Deutsche Bank Privat und Geschäftskunden
            "13080000",    //Commerzbank vormals Dresdner Bank
            "13090000",    //Rostocker Volks- und Raiffeisenbank
            "13091054",    //Pommersche Volksbank
            "13091084",    //Volksbank Wismar -alt-
            "14040000",    //Commerzbank
            "14051000",    //Sparkasse Mecklenburg-Nordwest
            "14051362",    //Sparkasse Parchim-Lübz
            "14051462",    //Sparkasse Schwerin -alt-
            "14052000",    //Sparkasse Mecklenburg-Schwerin
            "14061308",    //Volks- und Raiffeisenbank
            "14061438",    //Raiffeisen-Volksbank -alt-
            "14080000",    //Commerzbank vormals Dresdner Bank
            "14080011",    //Commerzbank vormals Dresdner Bank Zw W
            "14091464",    //VR-Bank
            "15000000",    //Bundesbank
            "15040068",    //Commerzbank
            "15050100",    //Müritz-Sparkasse
            "15050200",    //Sparkasse Neubrandenburg-Demmin
            "15050400",    //Sparkasse Uecker-Randow
            "15050500",    //Sparkasse Vorpommern
            "15051732",    //Sparkasse Mecklenburg-Strelitz
            "15061618",    //Raiffeisenbank Mecklenburger Seenplatte
            "15061638",    //Volksbank Raiffeisenbank
            "15061698",    //Raiffeisenbank Malchin
            "15080000",    //Commerzbank vormals Dresdner Bank
            "15091674",    //Volksbank Demmin
            "15091704",    //VR-Bank Uckermark-Randow
            "16010111",    //SEB
            "16010300",    //Investitionsbank des Landes Brandenburg
            "16020086",    //UniCredit Bank - HypoVereinsbank
            "16040000",    //Commerzbank
            "16050000",    //Mittelbrandenburgische Sparkasse in Potsdam
            "16050101",    //Sparkasse Prignitz
            "16050202",    //Sparkasse Ostprignitz-Ruppin
            "16050500",    //LBS Ostdeutsche Landesbausparkasse
            "16060122",    //Volks- und Raiffeisenbank Prignitz
            "16061938",    //Raiffeisenbank Ostprignitz-Ruppin
            "16062008",    //VR-Bank Fläming
            "16062073",    //Brandenburger Bank
            "16080000",    //Commerzbank vormals Dresdner Bank
            "16091994",    //Volksbank Rathenow
            "17020086",    //UniCredit Bank - HypoVereinsbank
            "17040000",    //Commerzbank
            "17052000",    //Sparkasse Barnim
            "17052302",    //Stadtsparkasse Schwedt
            "17054040",    //Sparkasse Märkisch-Oderland
            "17055050",    //Sparkasse Oder-Spree
            "17056060",    //Sparkasse Uckermark
            "17062428",    //Raiffeisenbank-Volksbank Oder-Spree
            "17080000",    //Commerzbank vormals Dresdner Bank
            "17092404",    //VR Bank Fürstenwalde Seelow Wriezen
            "18020086",    //UniCredit Bank - HypoVereinsbank
            "18040000",    //Commerzbank
            "18050000",    //Sparkasse Spree-Neiße
            "18051000",    //Sparkasse Elbe-Elster
            "18055000",    //Sparkasse Niederlausitz
            "18062678",    //VR Bank Lausitz
            "18062758",    //VR Bank Forst -alt-
            "18080000",    //Commerzbank vormals Dresdner Bank
            "18092684",    //Spreewaldbank
            "18092744",    //Volksbank Spree-Neiße
            "20000000",    //Bundesbank
            "20010020",    //Postbank (Giro)
            "20010111",    //SEB
            "20010424",    //Aareal Bank
            "20020200",    //SEB Merchant Bank Hamburg
            "20020500",    //Jyske Bank Fil Hamburg
            "20020900",    //Signal Iduna Bauspar
            "20030000",    //UniCredit Bank - HypoVereinsbank
            "20030133",    //Varengold Bank
            "20030300",    //DONNER & REUSCHEL
            "20030400",    //Marcard, Stein & Co Bankiers
            "20030600",    //Sydbank Fil Hamburg
            "20030700",    //Merck Finck Privatbankiers
            "20040000",    //Commerzbank
            "20040005",    //Commerzbank, Filiale Hamburg 2
            "20040020",    //Commerzbank, CC SP
            "20040040",    //Commerzbank GF RME
            "20040048",    //Commerzbank GF-H48
            "20040050",    //Commerzbank GF COC
            "20040060",    //Commerzbank Gf 260
            "20040061",    //Commerzbank Gf 261
            "20040062",    //Commerzbank CC
            "20040063",    //Commerzbank CC
            "20041111",    //comdirect bank
            "20041133",    //comdirect bank
            "20041144",    //comdirect bank
            "20041155",    //comdirect bank
            "20050000",    //HSH Nordbank Hamburg
            "20050550",    //Hamburger Sparkasse
            "20060000",    //DZ BANK
            "20069111",    //Norderstedter Bank
            "20069125",    //Kaltenkirchener Bank
            "20069130",    //Raiffeisenbank
            "20069144",    //Raiffeisenbank
            "20069177",    //Raiffeisenbank Südstormarn Mölln
            "20069232",    //Raiffeisenbank
            "20069641",    //Raiffeisenbank Owschlag
            "20069780",    //Volksbank Ahlerstedt
            "20069782",    //Volksbank Geest
            "20069786",    //Volksbank Kehdingen Zndl. der Ostfriesischen Volksbank
            "20069800",    //Spar- und Kreditbank
            "20069812",    //Volksbank Fredenbeck
            "20069815",    //Volksbank
            "20069861",    //Raiffeisenbank
            "20069882",    //Raiffeisenbank Travemünde -alt-
            "20069965",    //Volksbank Winsener Marsch
            "20069989",    //Volksbank Wulfsen
            "20070000",    //Deutsche Bank
            "20070024",    //Deutsche Bank Privat und Geschäftskunden
            "20080000",    //Commerzbank vormals Dresdner Bank
            "20080055",    //Commerzbank vormals Dresdner Bank Zw 55
            "20080057",    //Commerzbank vormals Dresdner Bank Gf ZW 57
            "20080085",    //Commerzbank vormals Dresdner Bank Gf PCC DCC-ITGK 2
            "20080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 3
            "20080087",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 4
            "20080088",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 5
            "20080089",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 6
            "20080091",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 7
            "20080092",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 8
            "20080093",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 9
            "20080094",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 10
            "20080095",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 11
            "20089200",    //Commerzbank vormals Dresdner Bank ITGK
            "20090400",    //Deutsche Genossenschafts-Hypothekenbank
            "20090500",    //Augsburger Aktienbank (netbank)
            "20090602",    //apoBank
            "20090700",    //Edekabank
            "20090745",    //EBANK Gf Cash
            "20090900",    //PSD Bank Nord
            "20110022",    //Postbank (Spar)
            "20110700",    //Bank of Tokyo-Mitsubishi UFJ, The -
            "20110800",    //Bank of China Fil Hamburg
            "20120000",    //Joh. Berenberg, Gossler & Co
            "20120100",    //M.M.Warburg & CO
            "20120200",    //BHF-BANK
            "20120400",    //Deutscher Ring Bausparkasse
            "20120600",    //Goyer & Göppel
            "20120700",    //Hanseatic Bank
            "20130400",    //GRENKE BANK
            "20130600",    //Barclaycard Barclays Bank
            "20133300",    //Santander Consumer Bank
            "20190003",    //Hamburger Volksbank
            "20190109",    //Volksbank Stormarn
            "20190206",    //Volksbank Hamburg Ost-West -alt-
            "20190301",    //Vierländer Volksbank
            "20190800",    //MKB Mittelstandskreditbank
            "20210200",    //Bank Melli Iran
            "20210300",    //Bank Saderat Iran
            "20220100",    //DNB Bank ASA - Filiale Deutschland
            "20220400",    //Warburg, M.M. - Hypothekenbank
            "20220800",    //SAXO PAYMENTS
            "20230300",    //Schröder, Otto M. - Bank
            "20230600",    //Isbank Fil Hamburg
            "20230800",    //Max Heinr. Sutor
            "20310300",    //Europäisch-Iranische Handelsbank
            "20320500",    //Danske Bank
            "20690500",    //Sparda-Bank Hamburg
            "20730001",    //UniCredit Bank - HVB Settlement EAC01
            "20730002",    //UniCredit Bank - HVB Settlement EAC02
            "20730003",    //UniCredit Bank - HVB Settlement EAC03
            "20730004",    //UniCredit Bank - HVB Settlement EAC04
            "20730005",    //UniCredit Bank - HVB Settlement EAC05
            "20730006",    //UniCredit Bank - HVB Settlement EAC06
            "20730007",    //UniCredit Bank - HVB Settlement EAC07
            "20730008",    //UniCredit Bank - HVB Settlement EAC08
            "20730009",    //UniCredit Bank - HVB Settlement EAC09
            "20730010",    //UniCredit Bank - HVB Settlement EAC10
            "20730011",    //UniCredit Bank - HVB Settlement EAC11
            "20730012",    //UniCredit Bank - HVB Settlement EAC12
            "20730013",    //UniCredit Bank - HVB Settlement EAC13
            "20730014",    //UniCredit Bank - HVB Settlement EAC14
            "20730015",    //UniCredit Bank - HVB Settlement EAC15
            "20730016",    //UniCredit Bank - HVB Settlement EAC16
            "20730017",    //UniCredit Bank - HVB Settlement EAC17
            "20730018",    //UniCredit Bank - HVB Settlement EAC18
            "20730019",    //UniCredit Bank - HVB Settlement EAC19
            "20730020",    //UniCredit Bank - HVB Settlement EAC20
            "20730021",    //UniCredit Bank - HVB Settlement EAC21
            "20730022",    //UniCredit Bank - HVB Settlement EAC22
            "20730023",    //UniCredit Bank - HVB Settlement EAC23
            "20730024",    //UniCredit Bank - HVB Settlement EAC24
            "20730025",    //UniCredit Bank - HVB Settlement EAC25
            "20730026",    //UniCredit Bank - HVB Settlement EAC26
            "20730027",    //UniCredit Bank - HVB Settlement EAC27
            "20730028",    //UniCredit Bank - HVB Settlement EAC28
            "20730029",    //UniCredit Bank - HVB Settlement EAC29
            "20730030",    //UniCredit Bank - HVB Settlement EAC30
            "20730031",    //UniCredit Bank - HVB Settlement EAC31
            "20730032",    //UniCredit Bank - HVB Settlement EAC32
            "20730033",    //UniCredit Bank - HVB Settlement EAC33
            "20730034",    //UniCredit Bank - HVB Settlement EAC34
            "20730035",    //UniCredit Bank - HVB Settlement EAC35
            "20730036",    //UniCredit Bank - HVB Settlement EAC36
            "20730037",    //UniCredit Bank - HVB Settlement EAC37
            "20730038",    //UniCredit Bank - HVB Settlement EAC38
            "20730039",    //UniCredit Bank - HVB Settlement EAC39
            "20730040",    //UniCredit Bank - HVB Settlement EAC40
            "20750000",    //Sparkasse Harburg-Buxtehude
            "21000000",    //Bundesbank eh Kiel
            "21010111",    //SEB
            "21020600",    //Sydbank Filiale Kiel
            "21040010",    //Commerzbank
            "21042076",    //Commerzbank
            "21050000",    //HSH Nordbank Hamburg, Kiel
            "21050170",    //Förde Sparkasse
            "21051275",    //Bordesholmer Sparkasse
            "21051580",    //Sparkasse Kreis Plön -alt-
            "21052090",    //Sparkasse Eckernförde -alt-
            "21070020",    //Deutsche Bank
            "21070024",    //Deutsche Bank Privat und Geschäftskunden
            "21080050",    //Commerzbank vormals Dresdner Bank
            "21089201",    //Commerzbank vormals Dresdner Bank ITGK
            "21090007",    //Kieler Volksbank
            "21090619",    //apoBank
            "21090900",    //PSD Bank Kiel
            "21092023",    //Eckernförder Bank Volksbank-Raiffeisenbank
            "21210111",    //SEB
            "21240040",    //Commerzbank
            "21241540",    //Commerzbank
            "21261089",    //Raiffeisenbank -alt-
            "21261227",    //Raiffbk Kl-Kummerfeld -alt-
            "21270020",    //Deutsche Bank
            "21270024",    //Deutsche Bank Privat und Geschäftskunden
            "21280002",    //Commerzbank vormals Dresdner Bank
            "21290016",    //VR Bank Neumünster
            "21340010",    //Commerzbank
            "21352240",    //Sparkasse Holstein
            "21390008",    //VR Bank Ostholstein Nord-Plön
            "21392218",    //Volksbank Eutin Raiffeisenbank
            "21440045",    //Commerzbank
            "21450000",    //Sparkasse Mittelholstein Rendsburg
            "21451205",    //Sparkasse Büdelsdorf -alt-
            "21452030",    //Sparkasse Hohenwestedt -alt-
            "21463603",    //Volksbank-Raiffeisenbank im Kreis Rendsburg
            "21464671",    //Raiffeisenbank
            "21480003",    //Commerzbank vormals Dresdner Bank
            "21510600",    //Sydbank Filiale Flensburg
            "21520100",    //Union-Bank Flensburg
            "21540060",    //Commerzbank
            "21565316",    //Raiffeisenbank
            "21570011",    //Deutsche Bank
            "21570024",    //Deutsche Bank Privat und Geschäftskunden
            "21580000",    //Commerzbank vormals Dresdner Bank
            "21661719",    //VR Bank Flensburg-Schleswig
            "21690020",    //Schleswiger Volksbank, Volksbank Raiffeisenbank
            "21740043",    //Commerzbank
            "21741674",    //Commerzbank
            "21741825",    //Commerzbank
            "21750000",    //Nord-Ostsee Sparkasse
            "21751230",    //Spar- und Leihkasse zu Bredstedt -alt-
            "21762550",    //Husumer Volksbank
            "21763542",    //VR Bank
            "21770011",    //Deutsche Bank
            "21770024",    //Deutsche Bank Privat und Geschäftskunden
            "21791805",    //Sylter Bank
            "21791906",    //Föhr-Amrumer Bank
            "21840078",    //Commerzbank
            "21841328",    //Commerzbank
            "21852310",    //Sparkasse Hennstedt-Wesselburen
            "21860418",    //Raiffeisenbank Heide
            "21890022",    //Dithmarscher Volks- und Raiffeisenbank
            "22140028",    //Commerzbank
            "22141028",    //Commerzbank
            "22141428",    //Commerzbank
            "22141628",    //Commerzbank
            "22150000",    //Sparkasse Elmshorn
            "22151730",    //Stadtsparkasse Wedel
            "22163114",    //Raiffeisenbank Elbmarsch
            "22180000",    //Commerzbank vormals Dresdner Bank
            "22181400",    //Commerzbank vormals Dresdner Bank
            "22190030",    //Volksbank Elmshorn -alt-
            "22191405",    //Volksbank Pinneberg-Elmshorn
            "22240073",    //Commerzbank
            "22250020",    //Sparkasse Westholstein
            "22280000",    //Commerzbank vormals Dresdner Bank
            "22290031",    //Volksbank Raiffeisenbank Itzehoe
            "23000000",    //Bundesbank eh Lübeck
            "23010111",    //SEB
            "23040022",    //Commerzbank
            "23050000",    //HSH Nordbank Hamburg
            "23050101",    //Sparkasse zu Lübeck
            "23051030",    //Sparkasse Südholstein
            "23052750",    //Kreissparkasse Herzogtum Lauenburg
            "23061220",    //Raiffeisenbank Leezen
            "23062124",    //Raiffeisenbank
            "23063129",    //Raiffeisenbank
            "23064107",    //Raiffeisenbank
            "23070700",    //Deutsche Bank Privat und Geschäftskunden
            "23070710",    //Deutsche Bank
            "23080040",    //Commerzbank vormals Dresdner Bank
            "23089201",    //Commerzbank vormals Dresdner Bank ITGK
            "23090142",    //Volksbank Lübeck
            "23092620",    //apoBank
            "24040000",    //Commerzbank
            "24050110",    //Sparkasse Lüneburg
            "24060300",    //Volksbank Lüneburger Heide
            "24061392",    //Volksbank Bleckede-Dahlenburg -alt-
            "24070024",    //Deutsche Bank Privat und Geschäftskunden
            "24070075",    //Deutsche Bank
            "24080000",    //Commerzbank vormals Dresdner Bank
            "24090041",    //Volksbank Lüneburg -alt-
            "24121000",    //Ritterschaftliches Kreditinstitut Stade
            "24140041",    //Commerzbank
            "24150001",    //Stadtsparkasse Cuxhaven
            "24151005",    //Sparkasse Stade-Altes Land
            "24151116",    //Kreissparkasse Stade
            "24151235",    //Sparkasse Rotenburg-Bremervörde
            "24161594",    //Zevener Volksbank
            "24162898",    //Spar- u Darlehnskasse Börde Lamstedt-Hechthausen
            "24180000",    //Commerzbank vormals Dresdner Bank
            "24180001",    //Commerzbank vormals Dresdner Bank
            "24191015",    //Volksbank Stade-Cuxhaven
            "25000000",    //Bundesbank
            "25010030",    //Postbank
            "25010111",    //SEB
            "25010424",    //Aareal Bank
            "25010600",    //Deutsche Hypothekenbank
            "25010900",    //Calenberger Kreditverein
            "25020200",    //BHF-BANK
            "25020600",    //Santander Consumer Bank
            "25040060",    //Commerzbank CC
            "25040061",    //Commerzbank CC
            "25040066",    //Commerzbank
            "25050000",    //Norddeutsche Landesbank Girozentrale
            "25050055",    //ZVA Norddeutsche Landesbank SH
            "25050180",    //Sparkasse Hannover
            "25050299",    //Sparkasse Hannover -alt-
            "25055500",    //LBS-Norddeutsche Landesbausparkasse
            "25060000",    //DZ BANK
            "25060180",    //Bankhaus Hallbaum
            "25069168",    //Volks- und Raiffeisenbank Leinebergland
            "25069262",    //Raiffeisen-Volksbank Neustadt
            "25069270",    //Volksbank Aller-Oker
            "25069370",    //Volksbank Vechelde-Wendeburg -alt-
            "25069503",    //Volksbank Diepholz-Barnstorf
            "25070024",    //Deutsche Bank Privat und Geschäftskunden
            "25070066",    //Deutsche Bank
            "25070070",    //Deutsche Bank
            "25070077",    //Deutsche Bank
            "25070084",    //Deutsche Bank
            "25070086",    //Deutsche Bank
            "25080020",    //Commerzbank vormals Dresdner Bank
            "25080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 2
            "25089220",    //Commerzbank vormals Dresdner Bank ITGK
            "25090300",    //Bank für Schiffahrt (BFS) Fil d Ostfr VB Leer
            "25090500",    //Sparda-Bank Hannover
            "25090608",    //apoBank
            "25090900",    //PSD Bank
            "25120510",    //Bank für Sozialwirtschaft
            "25151270",    //Stadtsparkasse Barsinghausen
            "25151371",    //Stadtsparkasse Burgdorf
            "25152375",    //Kreissparkasse Fallingbostel in Walsrode
            "25152490",    //Stadtsparkasse Wunstorf
            "25190001",    //Hannoversche Volksbank
            "25190088",    //Hannoversche Volksbank GS nur für GAA
            "25193331",    //Volksbank
            "25250001",    //Kreissparkasse Peine
            "25260010",    //Volksbank Peine
            "25410111",    //SEB
            "25410200",    //BHW Bausparkasse
            "25440047",    //Commerzbank
            "25450001",    //Stadtsparkasse Hameln -alt-
            "25450110",    //Sparkasse Hameln-Weserbergland
            "25451345",    //Stadtsparkasse Bad Pyrmont
            "25462160",    //Volksbank Hameln-Stadthagen
            "25462680",    //Volksbank im Wesertal
            "25470024",    //Deutsche Bank Privat und Geschäftskunden
            "25470073",    //Deutsche Bank
            "25471024",    //Deutsche Bank Privat und Geschäftskunden
            "25471073",    //Deutsche Bank
            "25480021",    //Commerzbank vormals Dresdner Bank
            "25491273",    //Volksbank Aerzen -alt-
            "25491744",    //Volksbank Bad Münder
            "25541426",    //Commerzbank
            "25551480",    //Sparkasse Schaumburg
            "25591413",    //Volksbank in Schaumburg
            "25621327",    //Oldenburgische Landesbank AG
            "25641302",    //Commerzbank
            "25650106",    //Sparkasse Nienburg
            "25651325",    //Kreissparkasse Grafschaft Diepholz
            "25662540",    //Volksbank
            "25663584",    //Volksbank Aller-Weser
            "25690009",    //Volksbank Nienburg
            "25691633",    //Volksbank Sulingen
            "25740061",    //Commerzbank
            "25750001",    //Sparkasse Celle
            "25761894",    //Volksbank Wittingen-Klötze
            "25770024",    //Deutsche Bank Privat und Geschäftskunden
            "25770069",    //Deutsche Bank
            "25780022",    //Commerzbank vormals Dresdner Bank
            "25791516",    //Volksbank Hankensbüttel-Wahrenholz
            "25791635",    //Volksbank Südheide
            "25840048",    //Commerzbank
            "25841403",    //Commerzbank
            "25841708",    //Commerzbank
            "25850110",    //Sparkasse Uelzen Lüchow-Dannenberg
            "25851335",    //Sparkasse Uelzen Lüchow-Dannenberg -alt-
            "25851660",    //Kreissparkasse Soltau
            "25861395",    //Volksbank Dannenberg -alt-
            "25861990",    //Volksbank Clenze-Hitzacker
            "25862292",    //Volksbank Uelzen-Salzwedel
            "25863489",    //Volksbank Osterburg-Lüchow-Dannenberg
            "25891483",    //Volksbank Osterburg-Lüchow-Dannenberg -alt-
            "25891636",    //Volksbank Lüneburger Heide -alt-
            "25910111",    //SEB
            "25940033",    //Commerzbank
            "25950001",    //Stadtsparkasse Hildesheim -alt-
            "25950130",    //Sparkasse Hildesheim
            "25970024",    //Deutsche Bank Privat und Geschäftskunden
            "25970074",    //Deutsche Bank
            "25971024",    //Deutsche Bank Privat und Geschäftskunden
            "25971071",    //Deutsche Bank
            "25980027",    //Commerzbank vormals Dresdner Bank
            "25990011",    //Volksbank Hildesheim
            "25991528",    //Volksbank Hildesheimer Börde
            "26000000",    //Bundesbank
            "26010111",    //SEB
            "26040030",    //Commerzbank
            "26050001",    //Sparkasse Göttingen
            "26051260",    //Sparkasse Duderstadt
            "26051450",    //Kreis- und Stadtsparkasse Münden
            "26061291",    //Volksbank Mitte
            "26061556",    //Volksbank
            "26062433",    //VR-Bank in Südniedersachsen
            "26070024",    //Deutsche Bank Privat und Geschäftskunden
            "26070072",    //Deutsche Bank
            "26080024",    //Commerzbank vormals Dresdner Bank
            "26090050",    //Volksbank Göttingen
            "26240039",    //Commerzbank
            "26250001",    //Kreis-Sparkasse Northeim
            "26251425",    //Sparkasse Einbeck
            "26261396",    //Volksbank Dassel -alt-
            "26261492",    //Volksbank Einbeck
            "26261693",    //Volksbank Solling
            "26271424",    //Deutsche Bank Privat und Geschäftskunden
            "26271471",    //Deutsche Bank
            "26280020",    //Commerzbank vormals Dresdner Bank
            "26281420",    //Commerzbank vormals Dresdner Bank
            "26340056",    //Commerzbank
            "26341072",    //Commerzbank
            "26350001",    //Stadtsparkasse Osterode
            "26351015",    //Sparkasse Osterode am Harz
            "26351445",    //Stadtsparkasse Bad Sachsa
            "26500000",    //Bundesbank
            "26510111",    //SEB
            "26520017",    //Oldenburgische Landesbank AG
            "26521703",    //Oldenburgische Landesbank AG
            "26522319",    //Oldenburgische Landesbank AG
            "26540070",    //Commerzbank
            "26550105",    //Sparkasse Osnabrück
            "26551540",    //Kreissparkasse Bersenbrück
            "26552286",    //Kreissparkasse Melle
            "26560625",    //apoBank
            "26562490",    //Volksbank Bad Laer-Borgloh-Hilter-Melle
            "26562694",    //Volksbank Wittlage -alt-
            "26563960",    //Volksbank Bramgau-Wittlage
            "26565928",    //Volksbank GMHütte-Hagen-Bissendorf
            "26566939",    //Volksbank Osnabrücker Nordland
            "26567943",    //VR-Bank im Altkreis Bersenbrück
            "26570024",    //Deutsche Bank Privat und Geschäftskunden
            "26570090",    //Deutsche Bank
            "26580070",    //Commerzbank vormals Dresdner Bank
            "26589210",    //Commerzbank vormals Dresdner Bank ITGK
            "26590025",    //Volksbank Osnabrück
            "26620010",    //Oldenburgische Landesbank AG
            "26621413",    //Oldenburgische Landesbank AG
            "26640049",    //Commerzbank
            "26650001",    //Sparkasse Emsland
            "26660060",    //Volksbank Lingen
            "26661380",    //Volksbank Haselünne
            "26661494",    //Emsländische Volksbank Meppen
            "26661912",    //Volksbank Süd-Emsland -alt-
            "26662932",    //Volksbank
            "26691213",    //Volksbank Haren Fil d Ostfriesischen VB
            "26720028",    //Oldenburgische Landesbank AG
            "26740044",    //Commerzbank
            "26750001",    //Kreissparkasse Grafschaft Bentheim zu Nordhorn
            "26760005",    //Raiffeisen- und Volksbank Nordhorn -alt-
            "26770024",    //Deutsche Bank Privat und Geschäftskunden
            "26770095",    //Deutsche Bank
            "26840032",    //Commerzbank
            "26850001",    //Sparkasse Goslar/Harz
            "26851410",    //Kreissparkasse Clausthal-Zellerfeld
            "26851620",    //Sparkasse Salzgitter
            "26870024",    //Deutsche Bank Privat und Geschäftskunden
            "26870032",    //Deutsche Bank
            "26880063",    //Commerzbank vormals Dresdner Bank
            "26890019",    //Volksbank Nordharz
            "26891484",    //Volksbank im Harz
            "26941053",    //Commerzbank Wolfsburg
            "26951311",    //Sparkasse Gifhorn-Wolfsburg
            "26971024",    //Deutsche Bank Privat und Geschäftskunden
            "26971038",    //Deutsche Bank
            "26981062",    //Commerzbank vormals Dresdner Bank
            "26989221",    //Commerzbank vormals Dresdner Bank ITGK
            "26991066",    //Volksbank Braunschweig Wolfsburg
            "27010111",    //SEB
            "27010200",    //VON ESSEN Bank
            "27020000",    //Volkswagen Bank
            "27020001",    //Audi Bank Zndl d Volkswagen Bank
            "27020003",    //Skoda Bank
            "27020004",    //AutoEuropa Bank
            "27020800",    //Seat Bank Zndl d Volkswagen Bank
            "27032500",    //Bankhaus C. L. Seeliger
            "27040080",    //Commerzbank
            "27062290",    //Volksbank Börßum-Hornburg
            "27070024",    //Deutsche Bank Privat und Geschäftskunden
            "27070030",    //Deutsche Bank
            "27070031",    //Deutsche Bank
            "27070034",    //Deutsche Bank
            "27070041",    //Deutsche Bank
            "27070042",    //Deutsche Bank
            "27070043",    //Deutsche Bank
            "27070079",    //Deutsche Bank
            "27072524",    //Deutsche Bank Privat und Geschäftskunden
            "27072537",    //Deutsche Bank
            "27072724",    //Deutsche Bank Privat und Geschäftskunden
            "27072736",    //Deutsche Bank
            "27080060",    //Commerzbank vormals Dresdner Bank
            "27089221",    //Commerzbank vormals Dresdner Bank ITGK
            "27090618",    //apoBank
            "27090900",    //PSD Bank
            "27092555",    //Volksbank
            "27131300",    //Bankhaus Rautenschlein
            "27190082",    //Volksbank Helmstedt -alt-
            "27240004",    //Commerzbank
            "27290087",    //Volksbank Weserbergland
            "27893215",    //Vereinigte Volksbank -alt-
            "27893359",    //Volksbank Braunlage
            "27893760",    //Volksbank
            "28000000",    //Bundesbank
            "28010111",    //SEB
            "28020050",    //Oldenburgische Landesbank AG
            "28021002",    //Oldenburgische Landesbank AG
            "28021301",    //Oldenburgische Landesbank AG
            "28021504",    //Oldenburgische Landesbank AG
            "28021623",    //Oldenburgische Landesbank AG
            "28021705",    //Oldenburgische Landesbank AG
            "28021906",    //Oldenburgische Landesbank AG
            "28022015",    //Oldenburgische Landesbank AG
            "28022412",    //Oldenburgische Landesbank AG
            "28022511",    //Oldenburgische Landesbank AG
            "28022620",    //Oldenburgische Landesbank AG
            "28022822",    //Oldenburgische Landesbank AG
            "28023224",    //Oldenburgische Landesbank AG
            "28023325",    //Oldenburgische Landesbank AG
            "28030300",    //Oldenburgische Landesbank (vormals W. Fortmann & Söhne)
            "28040046",    //Commerzbank
            "28042865",    //Commerzbank
            "28050100",    //Landessparkasse zu Oldenburg
            "28060228",    //Raiffeisenbank Oldenburg
            "28061410",    //Raiffeisenbank Wesermarsch-Süd
            "28061501",    //Volksbank Cloppenburg
            "28061679",    //Volksbank Dammer Berge
            "28061822",    //Volksbank Oldenburg
            "28062165",    //Raiffeisenbank Rastede
            "28062249",    //Vereinigte Volksbank
            "28062560",    //Volksbank Lohne-Mühlen
            "28062740",    //Volksbank Bookholzberg-Lemwerder -alt-
            "28062913",    //Volksbank Bösel
            "28063253",    //Volksbank Westerstede
            "28063526",    //Volksbank Essen-Cappeln
            "28063607",    //Volksbank Bakum
            "28064179",    //Volksbank Vechta
            "28064241",    //Raiffeisen-Volksbank Varel-Nordenham
            "28065061",    //Volksbank Löningen
            "28065108",    //VR-Bank Dinklage-Steinfeld
            "28065286",    //Raiffeisenbank Scharrel
            "28066103",    //Volksbank Visbek
            "28066214",    //Volksbank Wildeshauser Geest
            "28066620",    //Spar- und Darlehnskasse Friesoythe
            "28067068",    //Volksbank Neuenkirchen-Vörden
            "28067170",    //Volksbank Delmenhorst Schierbrok
            "28067257",    //Volksbank Lastrup
            "28068218",    //Raiffeisenbank Butjadingen-Abbehausen
            "28069052",    //Raiffeisenbank Strücklingen-Idafehn
            "28069092",    //VR Bank Oldenburg Land West
            "28069109",    //Volksbank Emstek
            "28069128",    //Raiffeisenbank Garrel
            "28069138",    //VR Bank Oldenburg Land West
            "28069293",    //Volksbank Obergrafschaft -alt-
            "28069381",    //Hümmlinger Volksbank
            "28069706",    //Volksbank Nordhümmling
            "28069755",    //Raiffeisenbank Oldersum
            "28069773",    //Raiffeisenbank Wiesedermeer-Wiesede-Marcardsm
            "28069878",    //Raiffeisenbank Emsland-Mitte
            "28069926",    //Volksbank Niedergrafschaft
            "28069930",    //Volksbank Langen-Gersten -alt-
            "28069935",    //Raiffeisenbank Lorup
            "28069956",    //Grafschafter Volksbank
            "28069991",    //Volksbank Emstal
            "28069994",    //Volksbank Süd-Emsland
            "28070024",    //Deutsche Bank Privat und Geschäftskunden
            "28070057",    //Deutsche Bank
            "28090633",    //apoBank
            "28220026",    //Oldenburgische Landesbank AG
            "28222208",    //Oldenburgische Landesbank AG
            "28222621",    //Oldenburgische Landesbank AG
            "28240023",    //Commerzbank
            "28250110",    //Sparkasse Wilhelmshaven
            "28252760",    //Kreissparkasse Wittmund
            "28262254",    //Volksbank Jever
            "28262673",    //Raiffeisen-Volksbank Varel-Nordenham
            "28270024",    //Deutsche Bank Privat und Geschäftskunden
            "28270056",    //Deutsche Bank
            "28280012",    //Commerzbank vormals Dresdner Bank
            "28290063",    //Volksbank Wilhelmshaven
            "28291551",    //Volksbank Esens
            "28320014",    //Oldenburgische Landesbank AG
            "28321816",    //Oldenburgische Landesbank AG
            "28350000",    //Sparkasse Aurich-Norden
            "28361592",    //Raiffeisen-Volksbank Fresena
            "28420007",    //Oldenburgische Landesbank AG
            "28421030",    //Oldenburgische Landesbank AG
            "28440037",    //Commerzbank
            "28450000",    //Sparkasse Emden
            "28470024",    //Deutsche Bank Privat und Geschäftskunden
            "28470091",    //Deutsche Bank
            "28520009",    //Oldenburgische Landesbank AG
            "28521518",    //Oldenburgische Landesbank AG
            "28540034",    //Commerzbank
            "28550000",    //Sparkasse LeerWittmund
            "28562297",    //Raiffeisen-Volksbank
            "28562716",    //Raiffeisenbank Flachsmeer
            "28562863",    //Raiffeisenbank Moormerland
            "28563749",    //Raiffeisenbank
            "28570024",    //Deutsche Bank Privat und Geschäftskunden
            "28570092",    //Deutsche Bank
            "28590075",    //Ostfriesische Volksbank Leer
            "28591579",    //Volksbank Papenburg Fil d. Ostfries. VB Leer
            "28591654",    //Volksbank Westrhauderfehn
            "29000000",    //Bundesbank eh Bremen
            "29010111",    //SEB
            "29010400",    //Deutsche Schiffsbank
            "29020000",    //Bankhaus Neelmeyer
            "29020100",    //Bremer Kreditbank
            "29020200",    //Greensill Bank
            "29030400",    //Bankhaus Carl F. Plump & CO
            "29040060",    //Commerzbank CC
            "29040061",    //Commerzbank CC
            "29040090",    //Commerzbank
            "29050000",    //Bremer Landesbank
            "29050101",    //Sparkasse Bremen
            "29070024",    //Deutsche Bank Privat und Geschäftskunden
            "29070050",    //Deutsche Bank
            "29070051",    //Deutsche Bank
            "29070052",    //Deutsche Bank
            "29070058",    //Deutsche Bank
            "29070059",    //Deutsche Bank
            "29080010",    //Commerzbank vormals Bremer Bank (Dresdner Bank)
            "29089210",    //Commerzbank vormals Bremer Bank (Dresdner Bank) ITGK
            "29090605",    //apoBank
            "29090900",    //PSD Bank Nord
            "29121731",    //Oldenburgische Landesbank AG
            "29151700",    //Kreissparkasse Syke
            "29152300",    //Kreissparkasse Osterholz
            "29152550",    //Zweckverbandssparkasse Scheeßel
            "29152670",    //Kreissparkasse Verden
            "29162394",    //Volksbank
            "29162453",    //Volksbank Schwanewede
            "29162697",    //Volksbank Aller-Weser
            "29165545",    //Volksbank Oyten
            "29165681",    //Volksbank Sottrum
            "29166568",    //Volksbank
            "29167624",    //Volksbank Syke
            "29172624",    //Deutsche Bank Privat und Geschäftskunden
            "29172655",    //Deutsche Bank
            "29190024",    //Bremische Volksbank
            "29190330",    //Volksbank Bremen-Nord
            "29210111",    //SEB
            "29240024",    //Commerzbank
            "29250000",    //Weser-Elbe Sparkasse
            "29250150",    //Kreissparkasse Wesermünde-Hadeln -alt-
            "29262722",    //Volksbank Geeste-Nord
            "29265747",    //Volksbank Bremerhaven-Cuxland
            "29280011",    //Commerzbank vormals Dresdner Bank
            "29290034",    //Volksbank Bremerhaven-Wesermünde -alt-
            "30000000",    //Bundesbank
            "30010111",    //SEB
            "30010400",    //IKB Deutsche Industriebank
            "30010444",    //IKB Privatkunden - IKB Deutsche Industriebank
            "30010700",    //The Bank of Tokyo-Mitsubishi UFJ
            "30019000",    //ipagoo - German Branch
            "30020500",    //BHF-BANK
            "30020700",    //Mizuho Bank Filiale Düsseldorf
            "30020900",    //TARGOBANK
            "30022000",    //NRW.BANK
            "30025500",    //Portigon
            "30030100",    //S Broker Wiesbaden
            "30030500",    //Bank11direkt
            "30030600",    //ETRIS Bank
            "30030880",    //HSBC Trinkaus & Burkhardt
            "30030889",    //HSBC Trinkaus VAC
            "30030900",    //Merck Finck Privatbankiers
            "30040000",    //Commerzbank
            "30040005",    //Commerzbank, Filiale Düsseldorf 2
            "30040048",    //Commerzbank GF-D48
            "30040060",    //Commerzbank Gf 660
            "30040061",    //Commerzbank Gf 661
            "30040062",    //Commerzbank CC
            "30040063",    //Commerzbank CC
            "30050000",    //Landesbank Hessen-Thüringen Girozentrale NL. Düsseldorf
            "30050110",    //Stadtsparkasse Düsseldorf
            "30060010",    //DZ BANK
            "30060601",    //apoBank
            "30060992",    //PSD Bank Rhein-Ruhr
            "30070010",    //Deutsche Bank
            "30070024",    //Deutsche Bank Privat und Geschäftskunden
            "30080000",    //Commerzbank vormals Dresdner Bank
            "30080005",    //Commerzbank vormals Dresdner Bank Zw 05
            "30080022",    //Commerzbank vormals Dresdner Bank Ztv 22
            "30080038",    //Commerzbank vormals Dresdner Bank Zw 38
            "30080041",    //Commerzbank vormals Dresdner Bank Zw 41
            "30080053",    //Commerzbank vormals Dresdner Bank Zw 53
            "30080055",    //Commerzbank vormals Dresdner Bank Zw 55
            "30080057",    //Commerzbank vormals Dresdner Bank Gf ZW 57
            "30080061",    //Commerzbank vormals Dresdner Bank Zw 61
            "30080074",    //Commerzbank vormals Dresdner Bank Zw 74
            "30080080",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 3
            "30080081",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 4
            "30080082",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 5
            "30080083",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 6
            "30080084",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 7
            "30080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 8
            "30080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 9
            "30080087",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 10
            "30080088",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 11
            "30080089",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 12
            "30080095",    //Commerzbank vormals Dresdner Bank Zw 95
            "30089300",    //Commerzbank vormals Dresdner Bank ITGK I
            "30089302",    //Commerzbank vormals Dresdner Bank ITGK II
            "30110300",    //Sumitomo Mitsui Banking Corporation
            "30120500",    //Bremer Kreditbank
            "30130100",    //Demir-Halk Bank (Nederland)
            "30130200",    //GarantiBank International
            "30130600",    //Isbank Fil Düsseldorf
            "30130800",    //Düsseldorfer Hypothekenbank
            "30150001",    //Helaba Düsseldorf Gf Verrechnung FI-Dus
            "30150200",    //Kreissparkasse Düsseldorf
            "30160213",    //Volksbank Düsseldorf Neuss
            "30220190",    //UniCredit Bank - HypoVereinsbank
            "30330800",    //BIW Bank für Investments und Wertpapiere
            "30351220",    //Stadt-Sparkasse Haan
            "30520000",    //RCI Banque Niederlassung Deutschland
            "30520037",    //RCI Banque Direkt
            "30524400",    //KBC Bank Ndl Deutschland
            "30530000",    //Bankhaus Werhahn
            "30530500",    //Bank11 für Privatkunden und Handel, Neuss
            "30550000",    //Sparkasse Neuss
            "30551240",    //Stadtsparkasse Kaarst-Büttgen -alt-
            "30560090",    //Volksbank Neuss -alt-
            "30560548",    //VR Bank
            "31010111",    //SEB
            "31010833",    //Santander Consumer Bank
            "31040015",    //Commerzbank
            "31040060",    //Commerzbank CC
            "31040061",    //Commerzbank CC
            "31050000",    //Stadtsparkasse Mönchengladbach
            "31060181",    //Gladbacher Bank von 1922
            "31060517",    //Volksbank Mönchengladbach
            "31062154",    //Volksbank Brüggen-Nettetal
            "31062553",    //Volksbank Schwalmtal
            "31070001",    //Deutsche Bank
            "31070024",    //Deutsche Bank Privat und Geschäftskunden
            "31080015",    //Commerzbank vormals Dresdner Bank
            "31080061",    //Commerzbank vormals Dresdner Bank Zw 61
            "31251220",    //Kreissparkasse Heinsberg in Erkelenz
            "31261282",    //Volksbank Erkelenz
            "31263359",    //Raiffeisenbank Erkelenz
            "31460290",    //Volksbank Viersen
            "31470004",    //Deutsche Bank
            "31470024",    //Deutsche Bank Privat und Geschäftskunden
            "32040024",    //Commerzbank
            "32050000",    //Sparkasse Krefeld
            "32051996",    //Sparkasse der Stadt Straelen
            "32060362",    //Volksbank Krefeld
            "32061384",    //Volksbank an der Niers
            "32061414",    //Volksbank Kempen-Grefrath
            "32070024",    //Deutsche Bank Privat und Geschäftskunden
            "32070080",    //Deutsche Bank
            "32080010",    //Commerzbank vormals Dresdner Bank
            "32250050",    //Verbandssparkasse Goch
            "32440023",    //Commerzbank
            "32450000",    //Sparkasse Kleve
            "32460422",    //Volksbank Kleverland
            "32470024",    //Deutsche Bank Privat und Geschäftskunden
            "32470077",    //Deutsche Bank
            "33010111",    //SEB
            "33020000",    //akf bank
            "33020190",    //UniCredit Bank - HypoVereinsbank
            "33030000",    //GEFA BANK
            "33040001",    //Commerzbank
            "33040310",    //Commerzbank Zw 117
            "33050000",    //Stadtsparkasse Wuppertal
            "33060098",    //Credit- und Volksbank Wuppertal
            "33060592",    //Sparda-Bank West
            "33060616",    //apoBank
            "33070024",    //Deutsche Bank Privat und Geschäftskunden
            "33070090",    //Deutsche Bank
            "33080001",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "33080030",    //Commerzbank vormals Dresdner Bank
            "33080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 2
            "33080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 3
            "33080087",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 4
            "33080088",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 5
            "33440035",    //Commerzbank
            "33450000",    //Sparkasse Hilden-Ratingen-Velbert
            "33451220",    //Sparkasse Heiligenhaus -alt-
            "34040049",    //Commerzbank
            "34050000",    //Stadtsparkasse Remscheid
            "34051350",    //Sparkasse Radevormwald-Hückeswagen
            "34051570",    //Stadtsparkasse Wermelskirchen
            "34060094",    //Volksbank Remscheid-Solingen Remscheid-Lennep
            "34070024",    //Deutsche Bank Privat und Geschäftskunden
            "34070093",    //Deutsche Bank
            "34080031",    //Commerzbank vormals Dresdner Bank
            "34240050",    //Commerzbank
            "34250000",    //Stadt-Sparkasse Solingen
            "34270024",    //Deutsche Bank Privat und Geschäftskunden
            "34270094",    //Deutsche Bank
            "34280032",    //Commerzbank vormals Dresdner Bank
            "35010111",    //SEB
            "35040038",    //Commerzbank
            "35040085",    //Commerzbank, Gf Web-K
            "35050000",    //Sparkasse Duisburg
            "35060190",    //Bank für Kirche und Diakonie - KD-Bank
            "35060386",    //Volksbank Rhein-Ruhr
            "35060632",    //apoBank
            "35070024",    //Deutsche Bank Privat und Geschäftskunden
            "35070030",    //Deutsche Bank
            "35080070",    //Commerzbank vormals Dresdner Bank
            "35080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "35080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 2
            "35080087",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 3
            "35080088",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 4
            "35080089",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 5
            "35090300",    //Bank für Schiffahrt (BFS) Fil d Ostfr VB Leer
            "35211012",    //SEB
            "35251000",    //Sparkasse Dinslaken-Voerde-Hünxe -alt-
            "35261248",    //Volksbank Dinslaken
            "35450000",    //Sparkasse am Niederrhein
            "35451460",    //Sparkasse Neukirchen-Vluyn -alt-
            "35451775",    //Sparkasse Rheinberg -alt-
            "35461106",    //Volksbank Niederrhein
            "35640064",    //Commerzbank
            "35650000",    //Niederrheinische Sparkasse RheinLippe
            "35660599",    //Volksbank Rhein-Lippe
            "35850000",    //Stadtsparkasse Emmerich-Rees -alt-
            "35860245",    //Volksbank Emmerich-Rees
            "36000000",    //Bundesbank
            "36010043",    //Postbank
            "36010111",    //SEB
            "36010200",    //VON ESSEN Bank
            "36010424",    //Aareal Bank
            "36010600",    //NIBC Bank Deutschland
            "36010699",    //NIBC Bank Deutschland Asset Backed Securities
            "36020030",    //National-Bank Essen
            "36020186",    //UniCredit Bank - HypoVereinsbank
            "36033300",    //Santander Consumer Bank
            "36036000",    //VALOVIS Bank
            "36040039",    //Commerzbank
            "36040060",    //Commerzbank CC
            "36040061",    //Commerzbank CC
            "36040085",    //Commerzbank, Gf Web-K
            "36050105",    //Sparkasse Essen
            "36060192",    //Pax-Bank
            "36060295",    //Bank im Bistum Essen
            "36060488",    //GENO BANK ESSEN
            "36060591",    //Sparda-Bank West
            "36060610",    //apoBank
            "36070024",    //Deutsche Bank Privat und Geschäftskunden
            "36070050",    //Deutsche Bank
            "36080080",    //Commerzbank vormals Dresdner Bank
            "36080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK  2
            "36089321",    //Commerzbank vormals Dresdner Bank ITGK
            "36210111",    //SEB
            "36240045",    //Commerzbank
            "36250000",    //Sparkasse Mülheim an der Ruhr
            "36270024",    //Deutsche Bank Privat und Geschäftskunden
            "36270048",    //Deutsche Bank
            "36280071",    //Commerzbank vormals Dresdner Bank
            "36540046",    //Commerzbank
            "36550000",    //Stadtsparkasse Oberhausen
            "36570024",    //Deutsche Bank Privat und Geschäftskunden
            "36570049",    //Deutsche Bank
            "36580072",    //Commerzbank vormals Dresdner Bank
            "37000000",    //Bundesbank
            "37010050",    //Postbank
            "37010111",    //SEB
            "37010600",    //BNP Paribas Niederlassung Deutschland
            "37010699",    //BNP Paribas Niederlassung Deutschland
            "37011000",    //Deutsche Postbank Easytrade
            "37013030",    //Deutsche Post Zahlungsdienste
            "37020090",    //UniCredit Bank - HypoVereinsbank
            "37020200",    //AXA Bank
            "37020400",    //TOYOTA Kreditbank
            "37020500",    //Bank für Sozialwirtschaft
            "37020600",    //Santander Consumer Bank MG
            "37020900",    //Ford Bank Ndl. der FCE Bank
            "37021100",    //Mazda Bank Niederlassung der FCE Bank
            "37021300",    //Jaguar Financial Services Ndl der FCE Bank
            "37021400",    //Land Rover Financial Services Ndl der FCE Bank
            "37030200",    //Oppenheim, Sal - jr & Cie
            "37030700",    //abcbank
            "37030800",    //Isbank Fil Köln
            "37040037",    //Commerzbank, CC SP
            "37040044",    //Commerzbank
            "37040048",    //Commerzbank GF-K48
            "37040060",    //Commerzbank CC
            "37040061",    //Commerzbank CC
            "37050198",    //Sparkasse KölnBonn
            "37050299",    //Kreissparkasse Köln
            "37060120",    //Pax-Bank Gf MHD
            "37060193",    //Pax-Bank
            "37060590",    //Sparda-Bank West
            "37060615",    //apoBank
            "37060993",    //PSD Bank Köln
            "37062124",    //Bensberger Bank
            "37062365",    //Raiffeisenbank Frechen-Hürth
            "37062600",    //VR Bank Bergisch Gladbach
            "37063367",    //Raiffeisenbank Fischenich-Kendenich
            "37069101",    //Spar- und Darlehnskasse Aegidienberg
            "37069103",    //Raiffeisenbank Aldenhoven
            "37069125",    //Raiffeisenbank Kürten-Odenthal
            "37069153",    //Spar- und Darlehnskasse Brachelen -alt-
            "37069164",    //Volksbank Meerbusch
            "37069252",    //Volksbank Erft
            "37069302",    //Raiffeisenbank
            "37069303",    //Volksbank Gemünd-Kall -alt-
            "37069306",    //Raiffeisenbank Grevenbroich
            "37069322",    //Raiffeisenbank Gymnich
            "37069330",    //Volksbank Haaren
            "37069331",    //Raiffeisenbank von 1895 Zw Horrem -alt-
            "37069342",    //Volksbank Heimbach
            "37069354",    //Raiffeisenbank Selfkant Zw -alt-
            "37069355",    //Spar- und Darlehnskasse Hoengen
            "37069381",    //VR-Bank Rur-Wurm
            "37069401",    //Raiffeisenbank Junkersdorf
            "37069405",    //Raiffeisenbank Kaarst
            "37069412",    //Volksbank Heinsberg
            "37069427",    //Volksbank Dünnwald-Holweide
            "37069429",    //Volksbank Köln-Nord
            "37069472",    //Raiffeisenbk Erftstadt -alt-
            "37069520",    //VR-Bank Rhein-Sieg
            "37069521",    //Raiffeisenbank Rhein-Berg -alt-
            "37069524",    //Raiffeisenbank Much-Ruppichteroth
            "37069577",    //Raiffeisenbank Odenthal -alt-
            "37069627",    //Raiffeisenbank Voreifel
            "37069639",    //Rosbacher Raiffeisenbank
            "37069642",    //Raiffeisenbank
            "37069707",    //Raiffeisenbank Sankt Augustin
            "37069720",    //VR-Bank Nordeifel
            "37069805",    //Volksbank Wachtberg
            "37069833",    //Raiffeisenbk Wesseling -alt-
            "37069840",    //Volksbank Wipperfürth-Lindlar
            "37069991",    //Brühler Bank
            "37070000",    //Deutsche Bank - Kontoservice für Kunden Sal. Oppenheim
            "37070024",    //Deutsche Bank Privat und Geschäftskunden
            "37070060",    //Deutsche Bank
            "37080040",    //Commerzbank vormals Dresdner Bank
            "37080085",    //Commerzbank vormals Dresdner Bank Gf PCC DCC-ITGK 1
            "37080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 4
            "37080087",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 5
            "37080088",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 6
            "37080089",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 7
            "37080090",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 8
            "37080091",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 9
            "37080092",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 10
            "37080093",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 11
            "37080094",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 12
            "37080095",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 13
            "37080096",    //Commerzbank vormals Dresdner Bank Zw 96
            "37080097",    //Commerzbank vormals Dresdner Bank Zw 97
            "37080098",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 14
            "37080099",    //Commerzbank vormals Dresdner Bank Zw 99
            "37089340",    //Commerzbank vormals Dresdner Bank ITGK I
            "37089342",    //Commerzbank vormals Dresdner Bank ITGK II
            "37160087",    //Kölner Bank
            "37161289",    //VR-Bank Rhein-Erft
            "37540050",    //Commerzbank
            "37551020",    //Stadt-Sparkasse Leichlingen
            "37551440",    //Sparkasse Leverkusen
            "37551780",    //Stadt-Sparkasse Langenfeld
            "37560092",    //Volksbank Rhein-Wupper
            "37570024",    //Deutsche Bank Privat und Geschäftskunden
            "37570064",    //Deutsche Bank
            "38010053",    //Postbank Zentrale
            "38010111",    //SEB
            "38010700",    //DSL Bank
            "38010900",    //KfW Ndl Bonn
            "38010999",    //KfW Ausbildungsförderung Bonn
            "38011000",    //VÖB-ZVD Processing
            "38011001",    //VÖB-ZVD Processing
            "38011002",    //VÖB-ZVD Processing
            "38011003",    //VÖB-ZVD Processing
            "38011004",    //VÖB-ZVD Processing
            "38011005",    //VÖB-ZVD Processing
            "38011006",    //VÖB-ZVD Processing
            "38011007",    //VÖB-ZVD Processing
            "38011008",    //VÖB-ZVD Processing
            "38020090",    //UniCredit Bank - HypoVereinsbank
            "38040007",    //Commerzbank
            "38050000",    //Sparkasse Bonn -alt-
            "38051290",    //Stadtsparkasse Bad Honnef
            "38060186",    //Volksbank Bonn Rhein-Sieg
            "38070024",    //Deutsche Bank Privat und Geschäftskunden
            "38070059",    //Deutsche Bank
            "38070724",    //Deutsche Bank Privat und Geschäftskunden F 950
            "38077724",    //Deutsche Bank Privat und Geschäftskunden F 950
            "38080055",    //Commerzbank vormals Dresdner Bank
            "38160220",    //VR-Bank Bonn
            "38250110",    //Kreissparkasse Euskirchen
            "38260082",    //Volksbank Euskirchen
            "38440016",    //Commerzbank
            "38450000",    //Sparkasse Gummersbach-Bergneustadt
            "38452490",    //Sparkasse der Homburgischen Gemeinden
            "38462135",    //Volksbank Oberberg
            "38470024",    //Deutsche Bank Privat und Geschäftskunden
            "38470091",    //Deutsche Bank
            "38621500",    //Steyler Bank
            "38650000",    //Kreissparkasse Siegburg
            "38651390",    //Sparkasse Hennef
            "39010111",    //SEB
            "39020000",    //Aachener Bausparkasse
            "39040013",    //Commerzbank
            "39050000",    //Sparkasse Aachen
            "39060180",    //Aachener Bank
            "39060630",    //apoBank
            "39061981",    //Heinsberger Volksbank -alt-
            "39070020",    //Deutsche Bank
            "39070024",    //Deutsche Bank Privat und Geschäftskunden
            "39080005",    //Commerzbank vormals Dresdner Bank
            "39080098",    //Commerzbank vormals Dresdner Bank Zw 98
            "39080099",    //Commerzbank vormals Dresdner Bank Zw 99
            "39160191",    //Pax-Bank
            "39161490",    //Volksbank Aachen Süd
            "39162980",    //VR-Bank
            "39362254",    //Raiffeisen-Bank Eschweiler
            "39540052",    //Commerzbank
            "39550110",    //Sparkasse Düren
            "39560201",    //Volksbank Düren
            "39570024",    //Deutsche Bank Privat und Geschäftskunden
            "39570061",    //Deutsche Bank
            "39580041",    //Commerzbank vormals Dresdner Bank
            "40010111",    //SEB
            "40022000",    //NRW.BANK
            "40030000",    //Münsterländische Bank Thie & Co
            "40040028",    //Commerzbank
            "40050000",    //Landesbank Hessen-Thüringen Girozentrale NL. Düsseldorf
            "40050150",    //Sparkasse Münsterland Ost
            "40055555",    //LBS Westdeutsche Landesbausparkasse
            "40060000",    //DZ BANK
            "40060265",    //DKM Darlehnskasse Münster
            "40060300",    //WL BANK Westfälische Landschaft Bodenkreditbank
            "40060560",    //Sparda-Bank Münster
            "40060614",    //apoBank
            "40061238",    //Volksbank Greven
            "40069226",    //Volksbank Lette-Darup-Rorup
            "40069266",    //Volksbank Marsberg
            "40069283",    //Volksbank Schlangen
            "40069348",    //Volksbank Medebach -alt-
            "40069362",    //Volksbank
            "40069363",    //Volksbank Schermbeck
            "40069371",    //Volksbank Thülen
            "40069408",    //Volksbank Baumberge
            "40069462",    //Volksbank Sprakel -alt-
            "40069477",    //Volksbank Wulfen -alt-
            "40069546",    //Volksbank Senden
            "40069600",    //Volksbank Amelsbüren
            "40069601",    //Volksbank Ascheberg-Herbern
            "40069606",    //Volksbank Erle
            "40069622",    //Volksbank Seppenrade
            "40069709",    //Volksbank Lembeck-Rhade
            "40069716",    //Volksbank Südkirchen-Capelle-Nordkirchen
            "40070024",    //Deutsche Bank Privat und Geschäftskunden
            "40070080",    //Deutsche Bank
            "40080040",    //Commerzbank vormals Dresdner Bank
            "40080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "40090900",    //PSD Bank Westfalen-Lippe
            "40150001",    //Helaba Düsseldorf Gf Verrechnung FI-Münster
            "40153768",    //Verbundsparkasse Emsdetten Ochtrup
            "40154006",    //Sparkasse Gronau
            "40154476",    //Stadtsparkasse Lengerich
            "40154530",    //Sparkasse Westmünsterland
            "40154702",    //Stadtsparkasse Stadtlohn
            "40160050",    //Vereinigte Volksbank Münster
            "40163720",    //Volksbank Nordmünsterland -alt-
            "40164024",    //Volksbank Gronau-Ahaus
            "40164256",    //Volksbank Laer-Horstmar-Leer
            "40164352",    //Volksbank Nottuln
            "40164528",    //Volksbank Lüdinghausen-Olfen
            "40164618",    //Volksbank
            "40164901",    //Volksbank Gescher
            "40165366",    //Volksbank Selm-Bork
            "40166439",    //Volksbank Lengerich/Lotte -alt-
            "40166800",    //Volksbank Buldern -alt-
            "40340030",    //Commerzbank
            "40350005",    //Stadtsparkasse Rheine
            "40351060",    //Kreissparkasse Steinfurt
            "40351220",    //Sparkasse Steinfurt -alt-
            "40361627",    //Volksbank Westerkappeln-Wersen
            "40361906",    //VR-Bank Kreis Steinfurt
            "40363433",    //Volksbank Hörstel -alt-
            "40370024",    //Deutsche Bank Privat und Geschäftskunden
            "40370079",    //Deutsche Bank
            "41010111",    //SEB
            "41040018",    //Commerzbank
            "41041000",    //ZTB der Commerzbank
            "41050095",    //Sparkasse Hamm
            "41051605",    //Stadtsparkasse Werne -alt-
            "41051845",    //Sparkasse Bergkamen-Bönen
            "41060120",    //Volksbank Hamm -alt-
            "41061011",    //Spar- und Darlehnskasse Bockum-Hövel
            "41061903",    //BAG Bankaktiengesellschaft
            "41062215",    //Volksbank Bönen
            "41070024",    //Deutsche Bank Privat und Geschäftskunden
            "41070049",    //Deutsche Bank
            "41240048",    //Commerzbank
            "41250035",    //Sparkasse Beckum-Wadersloh
            "41260006",    //Volksbank Beckum -alt-
            "41261324",    //Volksbank Enniger-Ostenfelde-Westkirchen
            "41261419",    //Volksbank Oelde-Ennigerloh-Neubeckum -alt-
            "41262501",    //Volksbank
            "41262621",    //Vereinigte Volksbank Telgte -alt-
            "41280043",    //Commerzbank vormals Dresdner Bank
            "41440018",    //Commerzbank
            "41450075",    //Sparkasse Soest
            "41451750",    //Sparkasse Werl
            "41460116",    //Volksbank Hellweg
            "41462295",    //Volksbank Wickede (Ruhr)
            "41650001",    //Sparkasse Lippstadt
            "41651770",    //Sparkasse Hochsauerland
            "41651815",    //Sparkasse Erwitte-Anröchte
            "41651965",    //Sparkasse Geseke
            "41652560",    //Sparkasse Warstein-Rüthen -alt-
            "41660124",    //Volksbank Beckum-Lippstadt
            "41661206",    //Volksbank Anröchte
            "41661504",    //Volksbank Benninghausen -alt-
            "41661719",    //Volksbank Brilon -alt-
            "41662465",    //Volksbank Störmede
            "41662557",    //Volksbank Warstein-Belecke -alt-
            "41663335",    //Volksbank Hörste
            "41670024",    //Deutsche Bank Privat und Geschäftskunden
            "41670027",    //Deutsche Bank
            "41670028",    //Deutsche Bank
            "41670029",    //Deutsche Bank
            "41670030",    //Deutsche Bank
            "42010111",    //SEB
            "42030600",    //Isbank Fil Gelsenkirchen
            "42040040",    //Commerzbank
            "42050001",    //Sparkasse Gelsenkirchen
            "42070024",    //Deutsche Bank Privat und Geschäftskunden
            "42070062",    //Deutsche Bank
            "42080082",    //Commerzbank vormals Dresdner Bank
            "42260001",    //Volksbank Ruhr Mitte
            "42450040",    //Stadtsparkasse Gladbeck
            "42451220",    //Sparkasse Bottrop
            "42461435",    //Volksbank Kirchhellen
            "42610112",    //SEB
            "42640048",    //Commerzbank
            "42650150",    //Sparkasse Vest Recklinghausen
            "42651315",    //Stadtsparkasse Haltern am See
            "42661008",    //Volksbank Marl-Recklinghausen
            "42661330",    //Volksbank Haltern
            "42661717",    //Volksbank Waltrop
            "42662320",    //Volksbank Dorsten
            "42680081",    //Commerzbank vormals Dresdner Bank
            "42840005",    //Commerzbank
            "42850035",    //Stadtsparkasse Bocholt
            "42860003",    //Volksbank Bocholt
            "42861239",    //Spar- und Darlehnskasse
            "42861387",    //VR-Bank Westmünsterland
            "42861515",    //Volksbank Gemen
            "42861608",    //Volksbank Heiden
            "42861814",    //Volksbank Rhede
            "42862451",    //Volksbank Raesfeld
            "42870024",    //Deutsche Bank Privat und Geschäftskunden
            "42870077",    //Deutsche Bank
            "43000000",    //Bundesbank
            "43010111",    //SEB
            "43040036",    //Commerzbank
            "43050001",    //Sparkasse Bochum
            "43051040",    //Sparkasse Hattingen
            "43060129",    //Volksbank Bochum Witten
            "43060967",    //GLS Gemeinschaftsbank
            "43070024",    //Deutsche Bank Privat und Geschäftskunden
            "43070061",    //Deutsche Bank
            "43080083",    //Commerzbank vormals Dresdner Bank
            "43250030",    //Herner Sparkasse
            "44000000",    //Bundesbank
            "44010046",    //Postbank
            "44010111",    //SEB
            "44020090",    //UniCredit Bank - HypoVereinsbank
            "44040037",    //Commerzbank
            "44040060",    //Commerzbank CC
            "44040061",    //Commerzbank CC
            "44040085",    //Commerzbank, Gf Web-K
            "44050000",    //Landesbank Hessen-Thüringen Girozentrale NL. Düsseldorf
            "44050199",    //Sparkasse Dortmund
            "44060122",    //Volksbank Dortmund-Nordwest
            "44060604",    //apoBank
            "44064406",    //Bank für Kirche und Diakonie - KD-Bank Gf Sonder-BLZ
            "44070024",    //Deutsche Bank Privat und Geschäftskunden
            "44070050",    //Deutsche Bank
            "44080050",    //Commerzbank vormals Dresdner Bank
            "44080055",    //Commerzbank vormals Dresdner Bank Zw 55
            "44080057",    //Commerzbank vormals Dresdner Bank Gf ZW 57
            "44080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 2
            "44089320",    //Commerzbank vormals Dresdner Bank ITGK
            "44090920",    //PSD Bank Dortmund -alt-
            "44152370",    //Sparkasse an der Lippe
            "44152490",    //Stadtsparkasse Schwerte
            "44160014",    //Dortmunder Volksbank
            "44340037",    //Commerzbank
            "44350060",    //Sparkasse UnnaKamen
            "44351380",    //Sparkasse Kamen -alt-
            "44351740",    //Sparkasse Fröndenberg
            "44361342",    //Volksbank Kamen-Werne
            "44540022",    //Commerzbank
            "44550045",    //Sparkasse der Stadt Iserlohn
            "44551210",    //Sparkasse Märkisches Sauerland Hemer-Menden
            "44570004",    //Deutsche Bank
            "44570024",    //Deutsche Bank Privat und Geschäftskunden
            "44580070",    //Commerzbank vormals Dresdner Bank
            "44580085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "44750065",    //Sparkasse Menden -alt-
            "44761312",    //Mendener Bank
            "44761534",    //Volksbank im Märkischen Kreis
            "45000000",    //Bundesbank
            "45040042",    //Commerzbank
            "45050001",    //Sparkasse HagenHerdecke
            "45051485",    //Stadtsparkasse Herdecke
            "45060009",    //Märkische Bank
            "45061524",    //Volksbank Hohenlimburg
            "45070002",    //Deutsche Bank
            "45070024",    //Deutsche Bank Privat und Geschäftskunden
            "45080060",    //Commerzbank vormals Dresdner Bank
            "45240056",    //Commerzbank
            "45250035",    //Sparkasse Witten
            "45251480",    //Stadtsparkasse Wetter
            "45251515",    //Stadtsparkasse Sprockhövel
            "45260041",    //Volksbank Witten -alt-
            "45260475",    //Spar- u Kreditbank d Bundes Fr ev Gemeinden
            "45261547",    //Volksbank Sprockhövel
            "45450050",    //Stadtsparkasse Gevelsberg
            "45451060",    //Sparkasse Ennepetal-Breckerfeld
            "45451555",    //Städtische Sparkasse zu Schwelm
            "45660029",    //Volksbank Altena -alt-
            "45840026",    //Commerzbank
            "45841031",    //Commerzbank
            "45850005",    //Sparkasse Lüdenscheid
            "45851020",    //Vereinigte Sparkasse im Märkischen Kreis
            "45851665",    //Sparkasse Kierspe-Meinerzhagen
            "45860033",    //Volksbank Lüdenscheid -alt-
            "45861434",    //Volksbank Kierspe
            "45861617",    //Volksbank Meinerzhagen -alt-
            "46010111",    //SEB
            "46040033",    //Commerzbank
            "46050001",    //Sparkasse Siegen
            "46051240",    //Sparkasse Burbach-Neunkirchen
            "46051733",    //Stadtsparkasse Freudenberg -alt-
            "46051875",    //Stadtsparkasse Hilchenbach
            "46052855",    //Stadtsparkasse Schmallenberg
            "46053480",    //Sparkasse Wittgenstein
            "46060040",    //Volksbank Siegerland
            "46061724",    //VR-Bank Freudenberg-Niederfischbach
            "46062817",    //Volksbank Bigge-Lenne
            "46063405",    //Volksbank Wittgenstein
            "46070024",    //Deutsche Bank Privat und Geschäftskunden
            "46070090",    //Deutsche Bank
            "46080010",    //Commerzbank vormals Dresdner Bank
            "46240016",    //Commerzbank
            "46250049",    //Sparkasse Olpe-Drolshagen-Wenden
            "46251590",    //Sparkasse Finnentrop
            "46251630",    //Sparkasse Attendorn-Lennestadt-Kirchhundem
            "46260023",    //Volksbank Olpe -alt-
            "46261607",    //Volksbank Grevenbrück -alt
            "46261822",    //Volksbank Olpe-Wenden-Drolshagen
            "46262456",    //Volksbank Bigge-Lenne -alt-
            "46441003",    //Commerzbank
            "46451012",    //Sparkasse Meschede
            "46451250",    //Sparkasse Bestwig -alt-
            "46461126",    //Volksbank Sauerland -alt-
            "46462271",    //Spar- und Darlehnskasse Oeventrop
            "46464453",    //Volksbank Reiste-Eslohe
            "46640018",    //Commerzbank
            "46650005",    //Sparkasse Arnsberg-Sundern
            "46660022",    //Volksbank Sauerland
            "46670007",    //Deutsche Bank
            "46670024",    //Deutsche Bank Privat und Geschäftskunden
            "47000000",    //Deutsche Bundesbank Filiale Dortmund (Bargeldzentrum)
            "47240047",    //Commerzbank
            "47250101",    //Sparkasse Paderborn -alt-
            "47251550",    //Sparkasse Höxter
            "47251740",    //Stadtsparkasse Delbrück
            "47260121",    //Volksbank Paderborn-Höxter-Detmold
            "47260234",    //Volksbank Elsen-Wewer-Borchen
            "47260307",    //Bank für Kirche und Caritas
            "47261429",    //Volksbank Haaren -alt-
            "47261603",    //Volksbank Brilon-Büren-Salzkotten
            "47262626",    //Volksbank Westenholz
            "47262703",    //Volksbank Delbrück-Hövelhof
            "47263472",    //Volksbank Westerloh-Westerwiehe -alt-
            "47264367",    //Vereinigte Volksbank
            "47265383",    //Volksbank Wewelsburg-Ahden
            "47267216",    //Volksbank Borgentreich -alt-
            "47270024",    //Deutsche Bank Privat und Geschäftskunden
            "47270029",    //Deutsche Bank
            "47460028",    //Volksbank Warburger Land -alt-
            "47640051",    //Commerzbank
            "47650130",    //Sparkasse Paderborn-Detmold
            "47651225",    //Stadtsparkasse Blomberg
            "47670023",    //Deutsche Bank
            "47670024",    //Deutsche Bank Privat und Geschäftskunden
            "47691200",    //Volksbank Ostlippe
            "47840065",    //Commerzbank
            "47840080",    //Commerzbank Zw 80
            "47850065",    //Sparkasse Gütersloh
            "47852760",    //Sparkasse Rietberg -alt-
            "47853355",    //Stadtsparkasse Versmold
            "47853520",    //Kreissparkasse Wiedenbrück
            "47860125",    //Volksbank Bielefeld-Gütersloh
            "47861317",    //Volksbank im Ostmünsterland
            "47861518",    //Volksbank Harsewinkel -alt-
            "47861806",    //Volksbank Kaunitz
            "47862261",    //Volksbank Marienfeld -alt-
            "47862447",    //Volksbank Rietberg
            "47863373",    //Volksbank Versmold
            "47880031",    //Commerzbank vormals Dresdner Bank
            "48000000",    //Bundesbank
            "48010111",    //SEB
            "48020086",    //UniCredit Bank - HypoVereinsbank
            "48020151",    //Bankhaus Lampe
            "48021900",    //Bankverein Werther Zw Ndl der VB Paderborn-Höxter-Detmold
            "48040035",    //Commerzbank
            "48040060",    //Commerzbank CC
            "48040061",    //Commerzbank CC
            "48050161",    //Sparkasse Bielefeld
            "48051580",    //Kreissparkasse Halle
            "48060036",    //Bielefelder Volksbank -alt-
            "48062051",    //Volksbank Halle/Westf
            "48062466",    //Spar-u Darlehnskasse Schloß Holte-Stukenbrock -alt-
            "48070020",    //Deutsche Bank
            "48070024",    //Deutsche Bank Privat und Geschäftskunden
            "48070040",    //Deutsche Bank
            "48070042",    //Deutsche Bank
            "48070043",    //Deutsche Bank
            "48070044",    //Deutsche Bank
            "48070045",    //Deutsche Bank
            "48070050",    //Deutsche Bank
            "48070052",    //Deutsche Bank
            "48080020",    //Commerzbank vormals Dresdner Bank
            "48089350",    //Commerzbank vormals Dresdner Bank ITGK
            "48250110",    //Sparkasse Lemgo
            "48262248",    //Volksbank Nordlippe -alt-
            "48291490",    //Volksbank Bad Salzuflen
            "49040043",    //Commerzbank
            "49050101",    //Sparkasse Minden-Lübbecke
            "49051065",    //Stadtsparkasse Rahden
            "49051285",    //Stadtsparkasse Bad Oeynhausen
            "49051990",    //Stadtsparkasse Porta Westfalica
            "49060127",    //Volksbank Mindener Land
            "49060392",    //Volksbank Minden
            "49061298",    //Volksbank Bad Oeynhausen -alt-
            "49061470",    //Volksbank Stemweder Berg -alt-
            "49061510",    //Volksbank Eisbergen -alt-
            "49070024",    //Deutsche Bank Privat und Geschäftskunden
            "49070028",    //Deutsche Bank
            "49080025",    //Commerzbank vormals Dresdner Bank
            "49092650",    //Volksbank Lübbecker Land
            "49240096",    //Commerzbank
            "49262364",    //Volksbank Schnathorst
            "49440043",    //Commerzbank
            "49450120",    //Sparkasse Herford
            "49461323",    //Volksbank Enger-Spenge -alt-
            "49490070",    //Volksbank Bad Oeynhausen-Herford
            "50000000",    //Bundesbank
            "50010060",    //Postbank
            "50010111",    //SEB
            "50010200",    //AKBANK
            "50010424",    //Aareal Bank
            "50010517",    //ING-DiBa
            "50010700",    //Degussa Bank
            "50010900",    //Bank of America
            "50010910",    //Bank of America, Filiale Frankfurt
            "50012800",    //ALTE LEIPZIGER Bauspar
            "50020000",    //Sberbank Europe Zndl Deutschland
            "50020200",    //BHF-BANK
            "50020300",    //Bremer Kreditbank
            "50020400",    //KfW Kreditanstalt für Wiederaufbau Frankfurt
            "50020500",    //Landwirtschaftliche Rentenbank
            "50020700",    //Credit Europe Bank Ndl. Deutschland
            "50020800",    //Intesa Sanpaolo Frankfurt
            "50021000",    //ING Bank
            "50021100",    //FIL Fondsbank
            "50021120",    //FIL Fondsbank
            "50023400",    //Bank of Beirut Ndl Frankfurt
            "50025000",    //Opel Bank
            "50030000",    //PSA Bank Deutschland
            "50030010",    //PSA Bank Deutschland
            "50030100",    //HKB Bank Frankfurt
            "50030500",    //BNP PARIBAS Securities Services
            "50030600",    //Deutsche WertpapierService Bank
            "50030700",    //DenizBank (Wien) Zw Frankfurt
            "50031000",    //Triodos Bank Deutschland
            "50033300",    //Santander Consumer Bank
            "50038800",    //Agricultural Bank of China, Frankfurt Branch
            "50040000",    //Commerzbank
            "50040005",    //Commerzbank, Filiale Frankfurt 2
            "50040033",    //Commerzbank Gf BRS
            "50040038",    //Commerzbank, MBP
            "50040040",    //Commerzbank Gf ZRK
            "50040048",    //Commerzbank GF-F48
            "50040050",    //Commerzbank, CC SP
            "50040051",    //Commerzbank Center Dresdner Bank Frankfurt
            "50040052",    //Commerzbank Service - BZ Frankfurt
            "50040060",    //Commerzbank Gf 460
            "50040061",    //Commerzbank Gf 461
            "50040062",    //Commerzbank CC
            "50040063",    //Commerzbank CC
            "50040075",    //Commerzbank Gf ZCM
            "50040084",    //Commerzbank, GF Web-K CMTS2
            "50040085",    //Commerzbank, Gf Web-K
            "50040086",    //Commerzbank, GF Web-K CMTS
            "50040087",    //Commerzbank, Gf Web-K CMTS3
            "50040088",    //Commerzbank, INT 1
            "50040099",    //Commerzbank INT
            "50042500",    //Commerzbank Zw 425 - keine Auslandsbanken
            "50044444",    //Commerzbank Vermögensverwaltung
            "50047010",    //Commerzbank Service - BZ
            "50050000",    //Landesbank Hessen-Thür Girozentrale
            "50050201",    //Frankfurter Sparkasse
            "50050222",    //Frankfurter Sparkasse GF 1822direkt
            "50050999",    //DekaBank Frankfurt
            "50060000",    //DZ Bank
            "50060400",    //DZ BANK
            "50060411",    //First Cash DZ BANK Frankfurt
            "50060412",    //DZ BANK Gf vK
            "50060413",    //DZ BANK Gf VK 2
            "50060414",    //DZ BANK für Bausparkasse Schwäbisch Hall
            "50060415",    //DZ BANK für Bausparkasse Schwäbisch Hall
            "50060474",    //DZ BANK, Deutsche Zentral-Genossenschaftsbank
            "50061741",    //Raiffeisenbank Oberursel
            "50069126",    //VR Bank Alzey-Land-Schwabenheim
            "50069146",    //Volksbank Grebenhain
            "50069187",    //Volksbank Egelsbach -alt-
            "50069241",    //Raiffeisenkasse Erbes-Büdesheim und Umgebung
            "50069345",    //Raiffeisenbank
            "50069455",    //Hüttenberger Bank
            "50069477",    //Raiffeisenbank Kirtorf
            "50069693",    //Raiffeisenbank Bad Homburg Ndl d FrankfurterVB
            "50069842",    //Raiffeisen Volksbank
            "50069976",    //Volksbank Wißmar
            "50070010",    //Deutsche Bank Filiale
            "50070024",    //Deutsche Bank Privat und Geschäftskunden
            "50073019",    //Deutsche Bank
            "50073024",    //Deutsche Bank Privat und Geschäftskunden
            "50073081",    //Deutsche Bank Europe
            "50080000",    //Commerzbank vormals Dresdner Bank
            "50080015",    //Commerzbank vormals Dresdner Bank Zw 15
            "50080025",    //Commerzbank vormals Dresdner Bank Zw 25
            "50080035",    //Commerzbank vormals Dresdner Bank Zw 35
            "50080055",    //Commerzbank vormals Dresdner Bank Zw 55
            "50080057",    //Commerzbank vormals Dresdner Bank Gf ZW 57
            "50080060",    //Commerzbank vormals Dresdner Bank Gf DrKW
            "50080061",    //Commerzbank vormals Dresdner Bank Gf DrKWSL
            "50080077",    //Commerzbank, GF Wüstenrot BSPK
            "50080079",    //Commerzbank vormals Dresdner Bank ESOP
            "50080080",    //Commerzbank vormals Dresdner Bank Bs 80
            "50080082",    //Commerzbank vormals Dresdner Bank Gf AVB
            "50080086",    //Commerzbank vormals Dresdner Bank ITGK 3
            "50080087",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 4
            "50080088",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 5
            "50080089",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 6
            "50080091",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 7
            "50080092",    //Commerzbank vormals Dresdner Bank Finance and Controlling
            "50080099",    //Commerzbank vormals Dresdner Bank Zw 99
            "50080300",    //Commerzbank vormals Dresdner Bank Private Banking Inland
            "50083007",    //Commerzbank vormals Dresdner Bank
            "50083838",    //Commerzbank vormals Dresdner Bank in Frankfurt MBP
            "50089400",    //Commerzbank vormals Dresdner Bank ITGK
            "50090200",    //VR DISKONTBANK
            "50090500",    //Sparda-Bank Hessen
            "50090607",    //apoBank
            "50090900",    //PSD Bank Hessen-Thüringen
            "50092100",    //Spar- u Kreditbank ev-freikirchl Gemeinden
            "50092200",    //Volksbank Main-Taunus -alt-
            "50092900",    //Volksbank Usinger Land Ndl d Frankfurter VB
            "50093000",    //Rüsselsheimer Volksbank
            "50093010",    //Rüsselsheimer Volksbank GAA
            "50093400",    //Volksbank Kelsterbach Ndl d Frankfurter VB
            "50110200",    //Industrial and Commercial Bank of China
            "50110300",    //DVB Bank
            "50110400",    //AKA Ausfuhrkredit GmbH
            "50110500",    //NATIXIS Zweigniederlassung Deutschland
            "50110636",    //Standard Chartered Bank Germany Branch
            "50110700",    //Frankfurter Bankgesellschaft (Deutschland)
            "50110800",    //J.P. Morgan
            "50110801",    //J.P. Morgan, Internal Reference
            "50110855",    //J.P. Morgan
            "50110900",    //Bank of America N.A. Military Bank
            "50120000",    //MAINFIRST BANK
            "50120100",    //ICICI Bank UK, Germany Branch
            "50120383",    //Bethmann Bank
            "50120500",    //Credit Suisse (Deutschland)
            "50120600",    //Bank of Communications Frankfurt branch
            "50120900",    //VakifBank International Wien Zndl Frankfurt
            "50123400",    //VTB Bank (Austria), Zndl
            "50127000",    //PKO Bank Polski Niederlassung Deutschland
            "50130000",    //National Bank of Pakistan Zndl Frankfurt
            "50130200",    //Oppenheim, Sal - jr & Cie
            "50130400",    //Merck Finck Privatbankiers
            "50130600",    //UBS Europe
            "50131000",    //Vietnam Joint Stock Commercial Bank for Industry and Trade
            "50190000",    //Frankfurter Volksbank
            "50190300",    //Volksbank Höchst a.M., ZwNdl. der Frankfurter VB -alt-
            "50190400",    //Volksbank Griesheim
            "50210111",    //SEB TZN Clearing
            "50210112",    //SEB TZN MB Frankfurt
            "50210130",    //SEB TZN MB Ffm.
            "50210131",    //SEB TZN MB Ffm.
            "50210132",    //SEB TZN MB Ffm.
            "50210133",    //SEB TZN MB Ffm.
            "50210134",    //SEB TZN MB Ffm.
            "50210135",    //SEB TZN MB Ffm.
            "50210136",    //SEB TZN MB Ffm.
            "50210137",    //SEB TZN MB Ffm.
            "50210138",    //SEB TZN MB Ffm.
            "50210139",    //SEB TZN MB Ffm.
            "50210140",    //SEB TZN MB Ffm.
            "50210141",    //SEB TZN MB Ffm.
            "50210142",    //SEB TZN MB Ffm.
            "50210143",    //SEB TZN MB Ffm.
            "50210144",    //SEB TZN MB Ffm.
            "50210145",    //SEB TZN MB Ffm.
            "50210146",    //SEB TZN MB Ffm.
            "50210147",    //SEB TZN MB Ffm.
            "50210148",    //SEB TZN MB Ffm.
            "50210149",    //SEB TZN MB Ffm.
            "50210150",    //SEB TZN MB Ffm.
            "50210151",    //SEB TZN MB Ffm.
            "50210152",    //SEB TZN MB Ffm.
            "50210153",    //SEB TZN MB Ffm.
            "50210154",    //SEB TZN MB Ffm.
            "50210155",    //SEB TZN MB Ffm.
            "50210156",    //SEB TZN MB Ffm.
            "50210157",    //SEB TZN MB Ffm.
            "50210158",    //SEB TZN MB Ffm.
            "50210159",    //SEB TZN MB Ffm.
            "50210160",    //SEB TZN MB Frankfurt
            "50210161",    //SEB TZN MB Frankfurt
            "50210162",    //SEB TZN MB Frankfurt
            "50210163",    //SEB TZN MB Frankfurt
            "50210164",    //SEB TZN MB Frankfurt
            "50210165",    //SEB TZN MB Frankfurt
            "50210166",    //SEB TZN MB Frankfurt
            "50210167",    //SEB TZN MB Frankfurt
            "50210168",    //SEB TZN MB Frankfurt
            "50210169",    //SEB TZN MB Frankfurt
            "50210170",    //SEB TZN MB Frankfurt
            "50210171",    //SEB TZN MB Frankfurt
            "50210172",    //SEB TZN MB Frankfurt
            "50210173",    //SEB TZN MB Frankfurt
            "50210174",    //SEB TZN MB Frankfurt
            "50210175",    //SEB TZN MB Frankfurt
            "50210176",    //SEB TZN MB Frankfurt
            "50210177",    //SEB TZN MB Frankfurt
            "50210178",    //SEB TZN MB Frankfurt
            "50210179",    //SEB TZN MB Frankfurt
            "50210180",    //SEB TZN MB Frankfurt
            "50210181",    //SEB TZN MB Frankfurt
            "50210182",    //SEB TZN MB Frankfurt
            "50210183",    //SEB TZN MB Frankfurt
            "50210184",    //SEB TZN MB Frankfurt
            "50210185",    //SEB TZN MB Frankfurt
            "50210186",    //SEB TZN MB Frankfurt
            "50210187",    //SEB TZN MB Frankfurt
            "50210188",    //SEB TZN MB Frankfurt
            "50210189",    //SEB TZN MB Frankfurt
            "50210200",    //Rabobank International Frankfurt Branch
            "50210212",    //RaboDirect
            "50210295",    //Rabobank International Frankfurt Branch
            "50210300",    //Commerzbank (ehem. Hypothekenbank Frankfurt)
            "50210600",    //equinet Bank
            "50210800",    //ProCredit Bank, Frankfurt am Main
            "50210900",    //Citigroup Global Markets Deutschland
            "50220085",    //UBS Europe
            "50220500",    //Bank of Scotland
            "50220900",    //Hauck & Aufhäuser Privatbankiers
            "50230000",    //ABC International Bank Frankfurt am Main
            "50230100",    //Morgan Stanley Bank Internaional
            "50230300",    //FCB Firmen-Credit Bank
            "50230400",    //The Royal Bank of Scotland Niederlassung Frankfurt
            "50230600",    //Isbank
            "50230700",    //Metzler, B. - seel Sohn & Co
            "50230800",    //Ikano Bank
            "50230888",    //Ikano Bank
            "50234500",    //KT Bank
            "50250200",    //Deutsche Leasing Finance
            "50310400",    //Barclays Bank Frankfurt
            "50310455",    //Reiseschecks - Barclays Bank Frankfurt
            "50310900",    //China Construction Bank Ndl Frankfurt
            "50320000",    //VTB Bank (Deutschland)
            "50320191",    //UniCredit Bank - HypoVereinsbank
            "50320500",    //Banco Santander Filiale Frankfurt
            "50320600",    //Attijariwafa bank Europa ZNdl. Frankfurt
            "50320900",    //Pictet & Cie (Europe) Ndl Deutschland
            "50324000",    //ABN AMRO Bank, Frankfurt Branch
            "50324040",    //ABN AMRO Bank, MoneYou
            "50330000",    //State Bank of India
            "50330200",    //MHB-Bank
            "50330300",    //The Bank of New York Mellon
            "50330500",    //BANQUE CHAABI DU MAROC Agentur Frankfurt Ndl. Deutschland
            "50330600",    //Bank Sepah-Iran
            "50334400",    //The Bank of New York Mellon NL Frankfurt
            "50400000",    //Bundesbank Zentrale
            "50510111",    //SEB
            "50510120",    //SEB TZN MB Ffm
            "50510121",    //SEB TZN MB Ffm
            "50510122",    //SEB TZN MB Ffm
            "50510123",    //SEB TZN MB Ffm
            "50510124",    //SEB TZN MB Ffm
            "50510125",    //SEB TZN MB Ffm
            "50510126",    //SEB TZN MB Ffm
            "50510127",    //SEB TZN MB Ffm
            "50510128",    //SEB TZN MB Ffm
            "50510129",    //SEB TZN MB Ffm
            "50510130",    //SEB TZN MB Ffm
            "50510131",    //SEB TZN MB Ffm
            "50510132",    //SEB TZN MB Ffm
            "50510133",    //SEB TZN MB Ffm
            "50510134",    //SEB TZN MB Ffm
            "50510135",    //SEB TZN MB Ffm
            "50510136",    //SEB TZN MB Ffm
            "50510137",    //SEB TZN MB Ffm
            "50510138",    //SEB TZN MB Ffm
            "50510139",    //SEB TZN MB Ffm
            "50510140",    //SEB TZN MB Ffm
            "50510141",    //SEB TZN MB Ffm
            "50510142",    //SEB TZN MB Ffm
            "50510143",    //SEB TZN MB Ffm
            "50510144",    //SEB TZN MB Ffm
            "50510145",    //SEB TZN MB Ffm
            "50510146",    //SEB TZN MB Ffm
            "50510147",    //SEB TZN MB Ffm
            "50510148",    //SEB TZN MB Ffm
            "50510149",    //SEB TZN MB Ffm
            "50510150",    //SEB TZN MB Ffm
            "50510151",    //SEB TZN MB Ffm
            "50510152",    //SEB TZN MB Ffm
            "50510153",    //SEB TZN MB Ffm
            "50510154",    //SEB TZN MB Ffm
            "50510155",    //SEB TZN MB Ffm
            "50510156",    //SEB TZN MB Ffm
            "50510157",    //SEB TZN MB Ffm
            "50510158",    //SEB TZN MB Ffm
            "50510159",    //SEB TZN MB Ffm
            "50510160",    //SEB TZN MB Ffm
            "50510161",    //SEB TZN MB Ffm
            "50510162",    //SEB TZN MB Ffm
            "50510163",    //SEB TZN MB Ffm
            "50510164",    //SEB TZN MB Ffm
            "50510165",    //SEB TZN MB Ffm
            "50510166",    //SEB TZN MB Ffm
            "50510167",    //SEB TZN MB Ffm
            "50510168",    //SEB TZN MB Ffm
            "50510169",    //SEB TZN MB Ffm
            "50510170",    //SEB TZN MB Ffm
            "50510171",    //SEB TZN MB Ffm
            "50510172",    //SEB TZN MB Ffm
            "50510173",    //SEB TZN MB Ffm
            "50510174",    //SEB TZN MB Ffm
            "50510175",    //SEB TZN MB Ffm
            "50510176",    //SEB TZN MB Ffm
            "50510177",    //SEB TZN MB Ffm
            "50510178",    //SEB TZN MB Ffm
            "50510179",    //SEB TZN MB Ffm
            "50510180",    //SEB TZN MB Ffm
            "50520190",    //UniCredit Bank - HypoVereinsbank
            "50522222",    //FIDOR Bank Zndl Frankfurt am Main
            "50530000",    //Cronbank
            "50540028",    //Commerzbank
            "50550020",    //Städtische Sparkasse Offenbach a.M.
            "50560102",    //Raiffeisenbank Offenbach/M.-Bieber
            "50561315",    //Vereinigte Volksbank Maingau
            "50570018",    //Deutsche Bank
            "50570024",    //Deutsche Bank Privat und Geschäftskunden
            "50580005",    //Commerzbank vormals Dresdner Bank
            "50580085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "50590000",    //Offenbacher Volksbank -alt-
            "50592200",    //Volksbank Dreieich
            "50640015",    //Commerzbank
            "50650023",    //SPARKASSE HANAU
            "50652124",    //Sparkasse Langen-Seligenstadt
            "50661639",    //VR Bank Main-Kinzig-Büdingen
            "50661816",    //Volksbank Heldenbergen Ndl d Frankfurter VB
            "50662299",    //Raiffeisenbank Bruchköbel -alt-
            "50662669",    //Raiffeisenbank Maintal Ndl d Frankfurter VB
            "50663699",    //Raiffeisenbank
            "50670009",    //Deutsche Bank
            "50670024",    //Deutsche Bank Privat und Geschäftskunden
            "50680002",    //Commerzbank vormals Dresdner Bank
            "50680085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "50690000",    //Volksbank Raiffeisenbank Hanau Ndl d Frankf VB
            "50691300",    //DZB BANK
            "50692100",    //Volksbank Seligenstadt
            "50740048",    //Commerzbank
            "50750094",    //Kreissparkasse Gelnhausen
            "50761333",    //Volksbank -alt-
            "50761613",    //Volksbank Büdingen -alt-
            "50763319",    //Raiffeisenbank Vogelsberg -alt-
            "50780006",    //Commerzbank vormals Dresdner Bank
            "50790000",    //VR Bank Bad Orb-Gelnhausen
            "50793300",    //Birsteiner Volksbank -alt-
            "50794300",    //VR Bank Wächtersbach/Bad Soden-Salmünster -alt
            "50810900",    //Deutsche Bausparkasse Badenia (ehem. DBS Bausparkasse)
            "50820292",    //UniCredit Bank - HypoVereinsbank
            "50835800",    //MCE Bank
            "50840005",    //Commerzbank
            "50850049",    //Landesbank Hessen-Thür Girozentrale
            "50850150",    //Stadt- und Kreis-Sparkasse Darmstadt
            "50851952",    //Sparkasse Odenwaldkreis
            "50852553",    //Kreissparkasse Groß-Gerau
            "50852651",    //Sparkasse Dieburg
            "50861393",    //Spar- und Darlehnskasse Zell -alt-
            "50861501",    //Raiffeisenbank Nördliche Bergstraße
            "50862311",    //Volksbank Gräfenhausen -alt-
            "50862408",    //Vereinigte Volksbank Griesheim-Weiterstadt -alt-
            "50862703",    //Volksbank Gersprenztal-Otzberg
            "50862835",    //Raiffeisenbank Schaafheim
            "50862903",    //Volksbank Mainspitze
            "50863513",    //Vereinigte Volksbank Raiffeisenbank
            "50864322",    //Volksbank Modau
            "50864808",    //Volksbank Seeheim-Jugenheim -alt-
            "50865224",    //VB Mörfelden-Walldorf Ndl d Frankfurter VB
            "50865503",    //Volksbank
            "50870005",    //Deutsche Bank
            "50870024",    //Deutsche Bank Privat und Geschäftskunden
            "50880050",    //Commerzbank vormals Dresdner Bank
            "50880085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "50880086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 2
            "50890000",    //Volksbank Darmstadt - Südhessen
            "50890634",    //apoBank
            "50950068",    //Sparkasse Bensheim
            "50951469",    //Sparkasse Starkenburg
            "50961206",    //Raiffeisenbank Ried
            "50961312",    //Raiffeisenbank Groß-Rohrheim
            "50961592",    //Volksbank Weschnitztal
            "50961685",    //Volksbank Überwald-Gorxheimertal
            "50970004",    //Deutsche Bank
            "50970024",    //Deutsche Bank Privat und Geschäftskunden
            "51010111",    //SEB
            "51010400",    //Aareal Bank
            "51010800",    //Aareal Bank Zw L
            "51020000",    //BHF-BANK
            "51020186",    //UniCredit Bank - HypoVereinsbank
            "51040038",    //Commerzbank
            "51050015",    //Nassauische Sparkasse
            "51051000",    //S Broker Wiesbaden
            "51070021",    //Deutsche Bank
            "51070024",    //Deutsche Bank Privat und Geschäftskunden
            "51080060",    //Commerzbank vormals Dresdner Bank
            "51080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "51080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK2
            "51089410",    //Commerzbank vormals Dresdner Bank ITGK
            "51090000",    //Wiesbadener Volksbank
            "51090636",    //apoBank
            "51091500",    //Rheingauer Volksbank
            "51091700",    //vr bank Untertaunus
            "51091711",    //vr bank Untertaunus
            "51140029",    //Commerzbank
            "51150018",    //Kreissparkasse Limburg
            "51151919",    //Kreissparkasse Weilburg
            "51161606",    //Volksbank Langendernbach
            "51170010",    //Deutsche Bank
            "51170024",    //Deutsche Bank Privat und Geschäftskunden
            "51180041",    //Commerzbank vormals Dresdner Bank
            "51190000",    //Vereinigte Volksbank Limburg -alt-
            "51191200",    //Volksbank Goldner Grund -alt-
            "51191800",    //Volksbank Schupbach
            "51192200",    //Volks- und Raiffeisenbank Weilmünster -alt-
            "51210600",    //BNP Paribas Niederlassung Deutschland
            "51210699",    //BNP Paribas Niederlassung Deutschland
            "51210700",    //NIBC Bank Zndl Frankfurt am Main
            "51210800",    //Societe Generale
            "51210801",    //SOCIETE GENERALE
            "51211000",    //NATIXIS Pfandbriefbank
            "51220200",    //SEB Merchant Banking
            "51220211",    //SEB Frankfurt SAP
            "51220400",    //Bank Saderat Iran
            "51220700",    //ZIRAAT BANK International
            "51220800",    //Banco do Brasil
            "51220900",    //Morgan Stanley Bank
            "51220910",    //Morgan Stanley Bank
            "51230400",    //RBS ( Deutschland ) Frankfurt am Main
            "51230500",    //Standard Chartered Bank Germany Branch, Frankfurt
            "51230502",    //Standard Chartered Bank Germany Branch
            "51230555",    //Ikano Bank
            "51230600",    //Europe ARAB Bank
            "51230800",    //Wirecard Bank
            "51230801",    //Wirecard Bank
            "51230802",    //Wirecard Bank
            "51230805",    //Wirecard Bank
            "51250000",    //Taunus-Sparkasse
            "51300000",    //Bundesbank eh Gießen
            "51310111",    //SEB
            "51340013",    //Commerzbank
            "51343224",    //Commerzbank
            "51350025",    //Sparkasse Gießen
            "51351526",    //Sparkasse Grünberg
            "51352227",    //Sparkasse Laubach-Hungen
            "51361021",    //Volksbank Heuchelheim
            "51370008",    //Deutsche Bank
            "51370024",    //Deutsche Bank Privat und Geschäftskunden
            "51380040",    //Commerzbank vormals Dresdner Bank
            "51380085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "51390000",    //Volksbank Mittelhessen
            "51410600",    //Bank of America Merrill Lynch International Zndl Frankfurt
            "51410700",    //Bank of China
            "51410800",    //OnVista Bank
            "51420200",    //Misr Bank-Europe
            "51420300",    //Bank Julius Bär Europe
            "51420600",    //Svenska Handelsbanken Deutschland
            "51430300",    //Nordea Bank, Niederlassung Frankfurt
            "51430321",    //Nordea Bank Finland
            "51430345",    //Nordea Bank AB, Niederlassung Frankfurt
            "51430400",    //Goldman Sachs
            "51540037",    //Commerzbank
            "51550035",    //Sparkasse Wetzlar
            "51570008",    //Deutsche Bank
            "51570024",    //Deutsche Bank Privat und Geschäftskunden
            "51580044",    //Commerzbank vormals Dresdner Bank
            "51591300",    //Volksbank Brandoberndorf
            "51640043",    //Commerzbank
            "51650045",    //Sparkasse Dillenburg
            "51690000",    //Volksbank Dill
            "51691500",    //Volksbank Herborn-Eschenburg
            "51752267",    //Sparkasse Battenberg
            "51762434",    //VR Bank Biedenkopf-Gladenbach
            "51850079",    //Sparkasse Oberhessen
            "51861325",    //BVB Volksbank Ndl d Frankfurter Volksbank
            "51861403",    //Volksbank Butzbach
            "51861616",    //Landbank Horlofftal
            "51861806",    //Volksbank Ober-Mörlen
            "51961023",    //Volksbank Ulrichstein
            "51961515",    //Spar- und Darlehnskasse Stockhausen
            "51961801",    //Volksbank Feldatal
            "51990000",    //Volksbank Lauterbach-Schlitz
            "52010111",    //SEB
            "52040021",    //Commerzbank
            "52050000",    //Landeskreditkasse Kassel
            "52050353",    //Kasseler Sparkasse
            "52051373",    //Stadtsparkasse Borken (Hessen)
            "52051555",    //Stadtsparkasse Felsberg
            "52051877",    //Stadtsparkasse Grebenstein
            "52052154",    //Kreissparkasse Schwalm-Eder
            "52053458",    //Stadtsparkasse Schwalmstadt
            "52060000",    //DZ BANK
            "52060208",    //Kurhessische Landbank
            "52060400",    //Evangelische Bank Gf
            "52060410",    //Evangelische Bank
            "52061303",    //Raiffeisenbank Borken
            "52062200",    //VR-Bank Chattengau
            "52062601",    //VR-Bank Schwalm-Eder
            "52063369",    //VR-Bank Spangenberg-Morschen
            "52063550",    //Raiffeisenbank
            "52064156",    //Raiffeisenbank
            "52065220",    //Raiffeisenbank -alt-
            "52069013",    //Raiffeisenbank Burghaun
            "52069029",    //Spar-u. Kredit-Bank
            "52069065",    //Raiffeisenbank Langenschwarz -alt-
            "52069103",    //Raiffeisenbank Trendelburg -alt-
            "52069149",    //Raiffeisenbank Volkmarsen
            "52069519",    //Frankenberger Bank Raiffeisenbank
            "52070012",    //Deutsche Bank
            "52070024",    //Deutsche Bank Privat und Geschäftskunden
            "52071212",    //Deutsche Bank
            "52071224",    //Deutsche Bank Privat und Geschäftskunden
            "52080080",    //Commerzbank vormals Dresdner Bank
            "52080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK1
            "52090000",    //Kasseler Bank
            "52090611",    //apoBank
            "52240006",    //Commerzbank
            "52250030",    //Sparkasse Werra-Meißner
            "52260385",    //VR-Bank Werra-Meißner
            "52270012",    //Deutsche Bank
            "52270024",    //Deutsche Bank Privat und Geschäftskunden
            "52350005",    //Sparkasse Waldeck-Frankenberg
            "52360059",    //Waldecker Bank
            "52410300",    //ReiseBank
            "52410310",    //ReiseBank Gf2
            "52410400",    //KEB Hana Bank (Deutschland)
            "52411000",    //Cash Express Gesellschaft f Finanz-u Reisedienstleistungen
            "52411010",    //Cash Express Gesellschaft f.Finanz-u.Reisedienstleistungen
            "52420000",    //Credit Agricole CIB Deutschland
            "52420300",    //SHINHAN BANK EUROPE
            "52420600",    //Piraeus Bank Frankfurt Branch
            "52420700",    //SECB Swiss Euro Clearing Bank
            "52430000",    //Credit Mutuel - BECM - Ndl Deutschland
            "53040012",    //Commerzbank
            "53050180",    //Sparkasse Fulda
            "53051396",    //Kreissparkasse Schlüchtern
            "53060180",    //VR Genossenschaftsbank Fulda
            "53061230",    //VR-Bank NordRhön
            "53061313",    //VR Bank Schlüchtern-Birstein
            "53062035",    //Raiffeisenbank
            "53062350",    //Raiffeisenbank Biebergrund-Petersberg
            "53064023",    //Raiffeisenbank
            "53070007",    //Deutsche Bank
            "53070024",    //Deutsche Bank Privat und Geschäftskunden
            "53080030",    //Commerzbank vormals Dresdner Bank
            "53093200",    //VR Bank HessenLand
            "53093255",    //AgrarBank
            "53240048",    //Commerzbank
            "53250000",    //Sparkasse Bad Hersfeld-Rotenburg
            "53260145",    //Raiffeisenbank Asbach-Sorga
            "53261202",    //Bankverein Bebra -alt-
            "53261342",    //Raiffeisenbank Werratal-Landeck
            "53262073",    //Raiffeisenbank Haunetal -alt-
            "53262455",    //Raiffeisenbank Ronshausen-Marksuhl
            "53270012",    //Deutsche Bank
            "53270024",    //Deutsche Bank Privat und Geschäftskunden
            "53280081",    //Commerzbank vormals Dresdner Bank
            "53290000",    //VR-Bankverein Bad Hersfeld-Rotenburg
            "53340024",    //Commerzbank
            "53350000",    //Sparkasse Marburg-Biedenkopf
            "53361724",    //Raiffeisenbank
            "53370008",    //Deutsche Bank
            "53370024",    //Deutsche Bank Privat und Geschäftskunden
            "53380042",    //Commerzbank vormals Dresdner Bank
            "53381843",    //Commerzbank vormals Dresdner Bank
            "53390635",    //apoBank
            "54020090",    //UniCredit Bank - HypoVereinsbank
            "54030011",    //Service Credit Union Overseas Headquarters
            "54040042",    //Commerzbank
            "54050110",    //Stadtsparkasse Kaiserslautern
            "54050220",    //Kreissparkasse Kaiserslautern
            "54051550",    //Kreissparkasse Kusel
            "54051660",    //Stadtsparkasse Landstuhl -alt-
            "54051990",    //Sparkasse Donnersberg
            "54061650",    //VR-Bank Westpfalz -alt-
            "54062027",    //Raiffeisenbank Donnersberg -alt-
            "54070024",    //Deutsche Bank Privat und Geschäftskunden
            "54070092",    //Deutsche Bank
            "54080021",    //Commerzbank vormals Dresdner Bank
            "54090000",    //Volksbank Kaiserslautern
            "54091700",    //Volksbank Lauterecken
            "54091800",    //VR Bank Nordwestpfalz -alt-
            "54092400",    //Volksbank Glan-Münchweiler
            "54210111",    //SEB
            "54220091",    //UniCredit Bank - HypoVereinsbank
            "54240032",    //Commerzbank
            "54250010",    //Sparkasse Südwestpfalz
            "54261700",    //VR-Bank Südwestpfalz Pirmasens-Zweibrücken
            "54270024",    //Deutsche Bank Privat und Geschäftskunden
            "54270096",    //Deutsche Bank
            "54280023",    //Commerzbank vormals Dresdner Bank
            "54290000",    //VR-Bank Pirmasens -alt-
            "54291200",    //Raiffeisen- u Volksbank Dahn
            "54500000",    //Bundesbank
            "54510067",    //Postbank
            "54520194",    //UniCredit Bank - HypoVereinsbank
            "54540033",    //Commerzbank
            "54550010",    //Sparkasse Vorderpfalz
            "54550120",    //Kreissparkasse Rhein-Pfalz
            "54561310",    //RV Bank Rhein-Haardt
            "54570024",    //Deutsche Bank Privat und Geschäftskunden
            "54570094",    //Deutsche Bank
            "54580020",    //Commerzbank vormals Dresdner Bank
            "54620093",    //UniCredit Bank - HypoVereinsbank
            "54640035",    //Commerzbank
            "54651240",    //Sparkasse Rhein-Haardt
            "54661800",    //Raiffeisenbank Freinsheim
            "54663270",    //Raiffeisenbank Friedelsheim-Rödersheim
            "54670024",    //Deutsche Bank Privat und Geschäftskunden
            "54670095",    //Deutsche Bank
            "54680022",    //Commerzbank vormals Dresdner Bank
            "54690623",    //apoBank
            "54691200",    //VR Bank Mittelhaardt
            "54750010",    //Kreis- und Stadtsparkasse Speyer
            "54790000",    //Volksbank Kur- und Rheinpfalz
            "54850010",    //Sparkasse Südliche Weinstraße in Landau
            "54851440",    //Sparkasse Germersheim-Kandel
            "54861190",    //Raiffeisenbank Oberhaardt-Gäu -alt-
            "54862390",    //Raiffeisenbank
            "54862500",    //VR Bank Südpfalz
            "54891300",    //VR Bank Südliche Weinstraße
            "55000000",    //Bundesbank
            "55010111",    //SEB
            "55010400",    //Aareal Bank GF - BK01 -
            "55010424",    //Aareal Bank
            "55010625",    //Aareal Bank Clearing Wiesbaden
            "55010800",    //Investitions- und Strukturbank RP
            "55020000",    //BHF-BANK
            "55020100",    //Bausparkasse Mainz
            "55020486",    //UniCredit Bank - HypoVereinsbank
            "55020500",    //Bank für Sozialwirtschaft
            "55020555",    //Bank für Sozialwirtschaft
            "55020600",    //Westdeutsche Immobilienbank
            "55020700",    //Süd-West-Kreditbank Finanzierung
            "55030500",    //TARGO Commercial Finance
            "55030533",    //TARGOBANK Direkt
            "55033300",    //Santander Consumer Bank
            "55040022",    //Commerzbank
            "55040060",    //Commerzbank CC
            "55040061",    //Commerzbank CC
            "55050000",    //ZV Landesbank Baden-Württemberg
            "55050120",    //Sparkasse Mainz
            "55060321",    //VR-Bank Mainz -alt-
            "55060417",    //VR-Bank Mainz -alt-
            "55060611",    //Genobank Mainz
            "55060831",    //apoBank
            "55061303",    //Budenheimer Volksbank
            "55061507",    //VR-Bank Mainz -alt-
            "55061907",    //Volksbank Rhein-Selz -alt-
            "55070024",    //Deutsche Bank Privat und Geschäftskunden
            "55070040",    //Deutsche Bank
            "55080044",    //Commerzbank, TF MZ 1
            "55080065",    //Commerzbank vormals Dresdner Bank
            "55080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "55080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 2
            "55080088",    //Commerzbank, TF MZ 2
            "55090500",    //Sparda-Bank Südwest
            "55091200",    //Volksbank Alzey-Worms
            "55150098",    //Clearingkonto LRP-SI
            "55160195",    //Pax-Bank
            "55190000",    //Mainzer Volksbank
            "55190028",    //Mainzer Volksbank -alt-
            "55190050",    //Mainzer Volksbank -alt-
            "55190064",    //Mainzer Volksbank -alt-
            "55190065",    //Mainzer Volksbank -alt-
            "55190068",    //Mainzer Volksbank -alt-
            "55190088",    //Mainzer Volksbank -alt-
            "55190094",    //Mainzer Volksbank -alt-
            "55340041",    //Commerzbank
            "55350010",    //Sparkasse Worms-Alzey-Ried
            "55361202",    //VR Bank
            "55362071",    //Volksbank Bechtheim -alt-
            "55390000",    //Volksbank Worms-Wonnegau -alt-
            "56020086",    //UniCredit Bank - HypoVereinsbank
            "56050180",    //Sparkasse Rhein-Nahe
            "56051790",    //Kreissparkasse Rhein-Hunsrück
            "56061151",    //Raiffeisenbank Kastellaun
            "56061472",    //Volksbank Hunsrück-Nahe
            "56062227",    //Volksbank Rheinböllen
            "56070024",    //Deutsche Bank Privat und Geschäftskunden
            "56070040",    //Deutsche Bank
            "56090000",    //Volksbank Rhein-Nahe-Hunsrück
            "56240050",    //Commerzbank
            "56250030",    //Kreissparkasse Birkenfeld
            "56261735",    //Raiffeisenbank Nahe
            "56270024",    //Deutsche Bank Privat und Geschäftskunden
            "56270044",    //Deutsche Bank
            "56290000",    //Volksbank-Raiffeisenbank Naheland -alt-
            "57000000",    //Bundesbank
            "57010111",    //SEB
            "57020086",    //UniCredit Bank - HypoVereinsbank
            "57020301",    //MKB Mittelrheinische Bank
            "57020500",    //Oyak Anker Bank
            "57020600",    //Debeka Bausparkasse
            "57040044",    //Commerzbank
            "57050120",    //Sparkasse Koblenz
            "57051001",    //Kreissparkasse Westerwald -alt-
            "57051870",    //Kreissparkasse Cochem-Zell -alt-
            "57060000",    //DZ BANK
            "57060612",    //apoBank
            "57062675",    //Raiffeisenbank
            "57064221",    //Volksbank Mülheim-Kärlich
            "57069067",    //Raiffeisenbank Lutzerather Höhe -alt-
            "57069081",    //Raiffeisenbank Moselkrampen
            "57069144",    //Raiffeisenbank Eifeltor
            "57069238",    //Raiffeisenbank Neustadt
            "57069257",    //Raiffeisenbank Untermosel
            "57069315",    //Raiffeisenbank Straßenhaus -alt-
            "57069361",    //Raiffeisenbank Welling
            "57069727",    //Raiffeisenbank Irrel
            "57069806",    //VR-Bank Hunsrück-Mosel
            "57070024",    //Deutsche Bank Privat und Geschäftskunden
            "57070045",    //Deutsche Bank
            "57080070",    //Commerzbank vormals Dresdner Bank
            "57090000",    //Volksbank Koblenz Mittelrhein
            "57090900",    //PSD Bank Koblenz
            "57091000",    //Volksbank Montabaur-Höhr-Grenzhausen
            "57091100",    //Volksbank Höhr-Grenzhausen -alt-
            "57092800",    //Volksbank Rhein-Lahn-Limburg
            "57263015",    //Raiffeisenbank Unterwesterwald
            "57351030",    //Sparkasse Westerwald-Sieg
            "57361476",    //Volksbank Gebhardshain
            "57363243",    //Raiffeisenbank Niederfischbach -alt-
            "57391200",    //Volksbank Daaden
            "57391500",    //Volksbank Hamm, Sieg
            "57391800",    //Westerwald Bank
            "57450120",    //Sparkasse Neuwied
            "57460117",    //Volks- und Raiffeisenbank Neuwied-Linz
            "57461759",    //Raiffeisenbank Mittelrhein -alt-
            "57470024",    //Deutsche Bank Privat und Geschäftskunden
            "57470047",    //Deutsche Bank
            "57650010",    //Kreissparkasse Mayen
            "57661253",    //Raiffeisenbank
            "57662263",    //VR Bank Rhein-Mosel
            "57751310",    //Kreissparkasse Ahrweiler
            "57761591",    //Volksbank RheinAhrEifel
            "57762265",    //Raiffeisenbank Grafschaft-Wachtberg
            "58510111",    //SEB
            "58520086",    //UniCredit Bank - HypoVereinsbank
            "58540035",    //Commerzbank
            "58550130",    //Sparkasse Trier
            "58560103",    //Volksbank Trier
            "58560294",    //Pax-Bank
            "58561250",    //Volksbank Hermeskeil -alt-
            "58561626",    //Volksbank Saarburg -alt-
            "58561771",    //Raiffeisenbank Mehring-Leiwen
            "58564788",    //Volksbank Hochwald-Saarburg -alt-
            "58570024",    //Deutsche Bank Privat und Geschäftskunden
            "58570048",    //Deutsche Bank
            "58580074",    //Commerzbank vormals Dresdner Bank
            "58590900",    //PSD Bank Trier Ndl der PSD Bank Köln
            "58650030",    //Kreissparkasse Bitburg-Prüm
            "58651240",    //Kreissparkasse Vulkaneifel
            "58660101",    //Volksbank Eifel
            "58661901",    //Raiffeisenbank Westeifel
            "58662653",    //Raiffeisenbank östl Südeifel -alt-
            "58668818",    //Raiffeisenbank Neuerburg-Land -alt-
            "58691500",    //Volksbank Eifel Mitte -alt-
            "58751230",    //Sparkasse Mittelmosel-Eifel Mosel Hunsrück
            "58760954",    //Vereinigte Volksbank Raiffeisenbank
            "58761343",    //Raiffeisenbank Zeller Land
            "58771224",    //Deutsche Bank Privat und Geschäftskunden
            "58771242",    //Deutsche Bank
            "59000000",    //Bundesbank
            "59010011",    //ZVC Postbank Gf FK 11
            "59010012",    //ZVC Postbank Gf FK 12
            "59010013",    //ZVC Postbank Gf FK 13
            "59010014",    //ZVC Postbank Gf FK 14
            "59010015",    //ZVC Postbank Gf FK 15
            "59010016",    //ZVC Postbank Gf FK 16
            "59010017",    //ZVC Postbank Gf FK 17
            "59010018",    //ZVC Postbank Gf FK 18
            "59010019",    //ZVC Postbank Gf FK 19
            "59010020",    //ZVC Postbank GF FK 20
            "59010021",    //ZVC Postbank GF FK 21
            "59010022",    //ZVC Postbank GF FK 22
            "59010023",    //ZVC Postbank GF FK 23
            "59010024",    //ZVC Postbank GF FK 24
            "59010025",    //ZVC Postbank GF FK 25
            "59010026",    //ZVC Postbank GF FK 26
            "59010027",    //ZVC Postbank Gf FK 27
            "59010028",    //ZVC Postbank Gf FK 28
            "59010029",    //ZVC Postbank Gf FK 29
            "59010031",    //ZVC Postbank Gf FK 31
            "59010032",    //ZVC Postbank Gf FK 32
            "59010033",    //ZVC Postbank Gf FK 33
            "59010034",    //ZVC Postbank Gf FK 34
            "59010035",    //ZVC Postbank Gf FK 35
            "59010036",    //ZVC Postbank Gf FK 36
            "59010037",    //ZVC Postbank Gf FK 37
            "59010038",    //ZVC Postbank Gf FK 38
            "59010039",    //ZVC Postbank Gf FK 39
            "59010040",    //ZVC Postbank Gf FK 40
            "59010041",    //ZVC Postbank Gf FK 41
            "59010042",    //ZVC Postbank Gf FK 42
            "59010044",    //ZVC Postbank Gf FK 44
            "59010045",    //ZVC Postbank Gf FK 45
            "59010047",    //ZVC Postbank Gf FK 47
            "59010048",    //ZVC Postbank Gf FK 48
            "59010049",    //ZVC Postbank Gf FK 49
            "59010066",    //Postbank
            "59010111",    //SEB
            "59010400",    //Saarl Investitionskreditbank
            "59020090",    //UniCredit Bank - HypoVereinsbank
            "59040000",    //Commerzbank
            "59050000",    //Landesbank Saar
            "59050101",    //Sparkasse Saarbrücken
            "59051090",    //Stadtsparkasse Völklingen
            "59070000",    //Deutsche Bank Saarbruecken
            "59070070",    //Deutsche Bank Privat und Geschäftskunden
            "59080090",    //Commerzbank vormals Dresdner Bank
            "59090626",    //apoBank
            "59090900",    //PSD Bank RheinNeckarSaar
            "59091500",    //Volksbank Sulzbachtal -alt-
            "59091800",    //Volksbank Quierschied -alt-
            "59092000",    //Vereinigte Volksbank Dillingen Dudweiler Sulzbach/Saar
            "59099550",    //Volksbank Nahe-Schaumberg -alt-
            "59190000",    //Bank 1 Saar
            "59190200",    //Volksbank Westliche Saar plus
            "59251020",    //Kreissparkasse St. Wendel
            "59252046",    //Sparkasse Neunkirchen
            "59291000",    //Unsere Volksbank St. Wendeler Land
            "59291200",    //Volks- und Raiffeisenbank Saarpfalz
            "59320087",    //UniCredit Bank - HypoVereinsbank
            "59350110",    //Kreissparkasse Saarlouis
            "59351040",    //Sparkasse Merzig-Wadern
            "59390100",    //Volksbank Saarlouis -alt-
            "59391200",    //Volksbank Überherrn
            "59392000",    //Volksbank Dillingen -alt-
            "59392200",    //Volksbank Untere Saar
            "59393000",    //levoBank
            "59450010",    //Kreissparkasse Saarpfalz
            "59491300",    //VR Bank Saarpfalz -alt-
            "60000000",    //Bundesbank
            "60010070",    //Postbank
            "60010111",    //SEB
            "60010424",    //Aareal Bank
            "60010700",    //Landeskreditbank Baden-Württemberg Förderbank -alt-
            "60020030",    //Baden-Württembergische Bank
            "60020100",    //Schwäbische Bank
            "60020290",    //UniCredit Bank - HypoVereinsbank
            "60020300",    //VON ESSEN Bank
            "60030000",    //Mercedes-Benz Bank
            "60030100",    //Bankhaus Bauer, Stuttgart
            "60030200",    //Bankhaus Ellwanger & Geiger
            "60030600",    //CreditPlus Bank
            "60030666",    //CreditPlus Bank
            "60030700",    //AKTIVBANK
            "60030900",    //Isbank Fil Stuttgart
            "60031000",    //TRUMPF Financial Services
            "60033000",    //Wüstenrot Bausparkasse
            "60035810",    //IBM Deutschland Kreditbank
            "60040060",    //Commerzbank CC
            "60040061",    //Commerzbank CC
            "60040071",    //Commerzbank
            "60050000",    //Landesbank Baden-Württemberg
            "60050009",    //ZV Landesbank Baden-Württemberg ISE
            "60050101",    //Landesbank Baden-Württemberg/Baden-Württembergische Bank
            "60060000",    //DZ BANK
            "60060202",    //DZ PRIVATBANK Ndl. Stuttgart
            "60060396",    //Volksbank am Württemberg
            "60062775",    //Echterdinger Bank
            "60062909",    //Volksbank Strohgäu
            "60069017",    //Raiffeisenbank Dellmensingen -alt-
            "60069066",    //Raiffeisenbank Niedere Alb
            "60069075",    //Raiffeisenbank Bühlertal
            "60069147",    //Raiffeisenbank Sondelfingen
            "60069158",    //Raiffeisenbank Steinheim
            "60069206",    //Raiffeisenbank
            "60069224",    //Genossenschaftsbank Weil im Schönbuch
            "60069235",    //Raiffeisenbank Zndl VB Nordschwarzwald -alt-
            "60069239",    //Bopfinger Bank Sechta-Ries
            "60069242",    //Raiffeisenbank Gruibingen
            "60069245",    //Raiffeisenbank Bühlertal
            "60069251",    //Raiffeisenbank Donau-Iller -alt-
            "60069302",    //Raiffeisenbank Erlenmoos
            "60069303",    //Raiffeisenbank Bad Schussenried
            "60069308",    //Raiffeisenbank -alt-
            "60069315",    //Volksbank Freiberg und Umgebung -alt-
            "60069336",    //Raiffeisenbank Maitis
            "60069343",    //Raiffeisenbank Rißtal -alt-
            "60069346",    //Raiffeisenbank Ehingen-Hochsträß
            "60069350",    //Raiffeisenbank Reute-Gaisbeuren
            "60069355",    //Ehninger Bank
            "60069378",    //Volksbank Dettenhausen
            "60069387",    //Dettinger Bank
            "60069417",    //Raiffeisenbank Kirchheim-Walheim -alt-
            "60069419",    //Uhlbacher Bank -alt-
            "60069420",    //Raiffeisenbank Mittelbiberach -alt-
            "60069431",    //Raiffeisenbank Oberessendorf -alt-
            "60069442",    //Raiffeisenbank Frankenhardt-Stimpfach
            "60069455",    //Raiffeisenbank Vordersteinenberg
            "60069457",    //Raiffeisenbank Ottenbach
            "60069461",    //Raiffeisenbank Rottumtal
            "60069462",    //Winterbacher Bank
            "60069463",    //Raiffeisenbank Geislingen-Rosenfeld
            "60069476",    //Raiffeisenbank Heidenheimer Alb -alt-
            "60069485",    //Raiffeisenbank Oberer Wald -alt-
            "60069505",    //Volksbank Murgtal -alt-
            "60069517",    //Scharnhauser Bank
            "60069527",    //Volksbank Brenztal
            "60069538",    //Löchgauer Bank -alt-
            "60069544",    //Raiffeisenbank Westhausen
            "60069545",    //Nufringer Bank -Raiffeisen-
            "60069553",    //Raiffeisenbank Aichhalden-Hardt-Sulgen
            "60069564",    //Raiffeisenbank Vordere Alb
            "60069595",    //Raiffeisenbank Schrozberg-Rot am See
            "60069639",    //Raiffeisenbank Ingersheim -alt-
            "60069648",    //Raiffeisenbank -alt-
            "60069669",    //Erligheimer Bank -alt-
            "60069673",    //Abtsgmünder Bank -Raiffeisen-
            "60069680",    //Raiffeisenbank Bretzfeld-Neuenstein
            "60069685",    //Raiffeisenbank
            "60069705",    //Raiffeisenbank Schlat -alt-
            "60069706",    //Raiffeisenbank
            "60069710",    //Raiffeisenbank Gammesfeld
            "60069714",    //Raiffeisenbank Kocher-Jagst
            "60069724",    //Raiffeisenbank Heroldstatt -alt-
            "60069727",    //Raiffeisenbank
            "60069738",    //Volksbank Freiberg und Umgebung -alt-
            "60069766",    //Volks- und Raiffeisenbank Boll -alt-
            "60069795",    //Volksbank Freiberg und Umgebung -alt-
            "60069798",    //Raiffeisenbank Horb
            "60069817",    //Raiffeisenbank
            "60069832",    //Raiffeisenbank Urbach
            "60069842",    //Darmsheimer Bank
            "60069858",    //Enztalbank -alt-
            "60069860",    //Federseebank
            "60069876",    //Raiffeisenbank Oberes Gäu Ergenzingen
            "60069896",    //Volksbank Freiberg und Umgebung -alt-
            "60069904",    //VR-Bank Alb -alt-
            "60069905",    //Volksbank Remseck
            "60069911",    //Raiffeisenbank
            "60069926",    //Volksbank Glatten-Wittendorf -alt-
            "60069927",    //Berkheimer Bank
            "60069931",    //Raiffeisenbank
            "60069950",    //Raiffeisenbank Tüngental
            "60069976",    //Raiffeisenbank Böllingertal
            "60069980",    //Raiffeisenbank Maselheim-Äpfingen -alt-
            "60070024",    //Deutsche Bank Privat und Geschäftskunden
            "60070070",    //Deutsche Bank
            "60080000",    //Commerzbank vormals Dresdner Bank
            "60080055",    //Commerzbank vormals Dresdner Bank Zw 55
            "60080057",    //Commerzbank vormals Dresdner Bank Gf Zw 57
            "60080085",    //Commerzbank vormals Dresdner Bank ITGK 2
            "60080086",    //Commerzbank vormals Dresdner Bank Gf PCC-ITGK 3
            "60080087",    //Commerzbank vormals Dresdner Bank, PCC DC-ITGK 4
            "60080088",    //Commerzbank vormals Dresdner Bank, PCC DC-ITGK 5
            "60089450",    //Commerzbank vormals Dresdner Bank ITGK
            "60090100",    //Volksbank Stuttgart
            "60090133",    //Volksbank Stuttgart GAA
            "60090300",    //Volksbank Zuffenhausen m Zndl Stammheimer VB
            "60090609",    //apoBank
            "60090700",    //Südwestbank
            "60090800",    //Sparda-Bank Baden-Württemberg
            "60090900",    //PSD Bank RheinNeckarSaar
            "60120200",    //BHF-BANK
            "60120500",    //Bank für Sozialwirtschaft
            "60130100",    //FFS Bank
            "60133300",    //Santander Consumer Bank
            "60241074",    //Commerzbank
            "60250010",    //Kreissparkasse Waiblingen
            "60261329",    //Fellbacher Bank
            "60261622",    //VR-Bank Weinstadt -alt-
            "60261818",    //Raiffeisenbank Weissacher Tal -alt-
            "60262063",    //Korber Bank -alt-
            "60262693",    //Kerner Volksbank -alt-
            "60270024",    //Deutsche Bank Privat und Geschäftskunden
            "60270073",    //Deutsche Bank
            "60290110",    //Volksbank Rems -alt-
            "60291120",    //Volksbank Backnang
            "60320291",    //UniCredit Bank - HypoVereinsbank
            "60340071",    //Commerzbank Sindelfingen
            "60350130",    //Kreissparkasse Böblingen
            "60361923",    //Raiffeisenbank Weissach
            "60380002",    //Commerzbank vormals Dresdner Bank
            "60390000",    //Vereinigte Volksbank
            "60390300",    //Volksbank Region Leonberg
            "60391310",    //Volksbank Herrenberg-Nagold-Rottenburg
            "60391420",    //Volksbank Magstadt
            "60410600",    //Wüstenrot Bank Pfandbriefbk ehe Wüstenrot Hypo
            "60420000",    //Wüstenrot Bank Pfandbriefbank
            "60420020",    //Wüstenrot Bank Pfandbriefbank
            "60420021",    //Wüstenrot Bank Pfandbriefbank
            "60420186",    //UniCredit Bank - HypoVereinsbank
            "60422000",    //RSB Retail+Service Bank
            "60440073",    //Commerzbank
            "60450050",    //Kreissparkasse Ludwigsburg
            "60460142",    //Volksbank Freiberg und Umgebung -alt-
            "60462808",    //VR-Bank Asperg-Markgröningen
            "60470024",    //Deutsche Bank Privat und Geschäftskunden
            "60470082",    //Deutsche Bank
            "60480008",    //Commerzbank vormals Dresdner Bank
            "60490150",    //Volksbank Ludwigsburg
            "60491430",    //VR-Bank Neckar-Enz
            "60651070",    //Kreissparkasse Calw -alt-
            "60661906",    //Raiffeisenbank Wimsheim-Mönsheim
            "60663084",    //Raiffeisenbank im Kreis Calw
            "60670024",    //Deutsche Bank Privat- und Geschäftskunden
            "60670070",    //Deutsche Bank
            "61030000",    //Bankhaus Gebr. Martin
            "61040014",    //Commerzbank
            "61050000",    //Kreissparkasse Göppingen
            "61060500",    //Volksbank Göppingen
            "61070024",    //Deutsche Bank Privat und Geschäftskunden
            "61070078",    //Deutsche Bank
            "61080006",    //Commerzbank vormals Dresdner Bank
            "61091200",    //Volksbank-Raiffeisenbank Deggingen
            "61120286",    //UniCredit Bank - HypoVereinsbank
            "61140071",    //Commerzbank
            "61150020",    //Kreissparkasse Esslingen-Nürtingen
            "61161696",    //Volksbank Filder
            "61170024",    //Deutsche Bank Privat und Geschäftskunden
            "61170076",    //Deutsche Bank
            "61180004",    //Commerzbank vormals Dresdner Bank
            "61190110",    //Volksbank Esslingen
            "61191310",    //Volksbank Plochingen
            "61240048",    //Commerzbank
            "61261213",    //Raiffeisenbank Teck -alt-
            "61261339",    //VR Bank Hohenneuffen-Teck
            "61262258",    //Genossenschaftsbank Wolfschlugen -alt-
            "61262345",    //Bernhauser Bank
            "61281007",    //Commerzbank vormals Dresdner Bank
            "61290120",    //Volksbank Kirchheim-Nürtingen
            "61340079",    //Commerzbank
            "61361722",    //Raiffeisenbank Rosenstein
            "61361975",    //Raiffeisenbank Mutlangen
            "61370024",    //Deutsche Bank Privat und Geschäftskunden
            "61370086",    //Deutsche Bank
            "61390140",    //Volksbank Schwäbisch Gmünd
            "61391410",    //Volksbank Welzheim
            "61420086",    //UniCredit Bank - HypoVereinsbank
            "61440086",    //Commerzbank
            "61450050",    //Kreissparkasse Ostalb
            "61480001",    //Commerzbank vormals Dresdner Bank
            "61490150",    //VR-Bank Aalen
            "61491010",    //VR-Bank Ellwangen
            "62020000",    //Hoerner-Bank
            "62020100",    //FCA Bank Deutschland
            "62040060",    //Commerzbank
            "62050000",    //Kreissparkasse Heilbronn
            "62061991",    //Volksbank Sulmtal
            "62062215",    //Volksbank Beilstein-Ilsfeld-Abstatt
            "62062643",    //Volksbank Flein-Talheim
            "62063263",    //VBU Volksbank im Unterland
            "62070024",    //Deutsche Bank Privat und Geschäftskunden
            "62070081",    //Deutsche Bank
            "62080012",    //Commerzbank vormals Dresdner Bank
            "62090100",    //Volksbank Heilbronn
            "62091400",    //Volksbank Brackenheim-Güglingen -alt-
            "62091600",    //Volksbank Möckmühl-Neuenstadt
            "62091800",    //Volksbank Hohenlohe
            "62220000",    //Bausparkasse Schwäbisch Hall
            "62240048",    //Commerzbank
            "62250030",    //Sparkasse Schwäbisch Hall-Crailsheim
            "62251550",    //Sparkasse Hohenlohekreis
            "62280012",    //Commerzbank vormals Dresdner Bank
            "62290110",    //VR Bank Schwäbisch Hall-Crailsheim
            "62291020",    //Crailsheimer Volksbank -alt-
            "62391010",    //Volksbank Bad Mergentheim -alt-
            "62391420",    //Volksbank Vorbach-Tauber
            "63000000",    //Bundesbank
            "63010111",    //SEB
            "63020086",    //UniCredit Bank - HypoVereinsbank
            "63040053",    //Commerzbank
            "63050000",    //Sparkasse Ulm
            "63061486",    //VR-Bank Langenau-Ulmer Alb
            "63070024",    //Deutsche Bank Privat und Geschäftskunden
            "63070088",    //Deutsche Bank
            "63080015",    //Commerzbank vormals Dresdner Bank
            "63080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "63090100",    //Volksbank Ulm-Biberach
            "63091010",    //Donau-Iller Bank
            "63091200",    //Volksbank Blaubeuren
            "63091300",    //Volksbank Laichinger Alb
            "63220090",    //UniCredit Bank - HypoVereinsbank
            "63240016",    //Commerzbank
            "63250030",    //Kreissparkasse Heidenheim
            "63290110",    //Heidenheimer Volksbank
            "64000000",    //Bundesbank
            "64020186",    //UniCredit Bank - HypoVereinsbank
            "64040033",    //Commerzbank
            "64040045",    //Commerzbank
            "64050000",    //Kreissparkasse Reutlingen
            "64061854",    //VR Bank Steinlach-Wiesaz-Härten
            "64070024",    //Deutsche Bank Privat und Geschäftskunden
            "64070085",    //Deutsche Bank
            "64080014",    //Commerzbank vormals Dresdner Bank
            "64090100",    //Volksbank Reutlingen
            "64091200",    //Volksbank Ermstal-Alb
            "64091300",    //Volksbank Münsingen
            "64140036",    //Commerzbank Tübingen
            "64150020",    //Kreissparkasse Tübingen
            "64161397",    //Volksbank Ammerbuch
            "64161608",    //Raiffeisenbank Härten -alt-
            "64161956",    //Volksbank Mössingen -alt-
            "64163225",    //Volksbank Hohenzollern-Balingen
            "64180014",    //Commerzbank vormals Dresdner Bank
            "64190110",    //Volksbank Tübingen
            "64191030",    //Volksbank Nagoldtal -alt-
            "64191210",    //Volksbank Altensteig -alt-
            "64191700",    //Volksbank Horb -alt-
            "64240048",    //Commerzbank
            "64240071",    //Commerzbank
            "64250040",    //Kreissparkasse Rottweil
            "64251060",    //Kreissparkasse Freudenstadt
            "64261363",    //Volksbank Baiersbronn Murgtal
            "64261626",    //Murgtalbank Mitteltal - Obertal -alt-
            "64261853",    //Volksbank Nordschwarzwald
            "64262408",    //Volksbank Dornstetten
            "64290120",    //Volksbank Rottweil
            "64291010",    //Volksbank Horb-Freudenstadt
            "64291420",    //Volksbank Deisslingen
            "64292020",    //Volksbank Schwarzwald-Neckar -alt-
            "64292310",    //Volksbank Trossingen
            "64350070",    //Kreissparkasse Tuttlingen
            "64361359",    //Raiffeisenbank Donau-Heuberg
            "64380011",    //Commerzbank vormals Dresdner Bank
            "64390130",    //Volksbank Schwarzwald-Donau-Neckar
            "65020186",    //UniCredit Bank - HypoVereinsbank
            "65040073",    //Commerzbank
            "65050110",    //Kreissparkasse Ravensburg
            "65061219",    //Raiffeisenbank Aulendorf
            "65062577",    //Raiffeisenbank Ravensburg
            "65062793",    //Raiffeisenbank Vorallgäu -alt-
            "65063086",    //Raiffeisenbank Bad Saulgau
            "65070024",    //Deutsche Bank Privat und Geschäftskunden
            "65070084",    //Deutsche Bank
            "65080009",    //Commerzbank vormals Dresdner Bank
            "65090100",    //Volksbank Ulm-Biberach -alt-
            "65091040",    //Leutkircher Bank Raiffeisen- und Volksbank
            "65091300",    //Bad Waldseer Bank -alt-
            "65091600",    //Volksbank Weingarten
            "65092010",    //Volksbank Allgäu-West
            "65092200",    //Volksbank Altshausen
            "65093020",    //Volksbank Bad Saulgau
            "65110200",    //Internationales Bankhaus Bodensee
            "65140072",    //Commerzbank
            "65161497",    //Genossenschaftsbank Meckenbeuren
            "65162832",    //Raiffeisenbank Oberteuringen
            "65180005",    //Commerzbank vormals Dresdner Bank
            "65190110",    //Volksbank Friedrichshafen
            "65191500",    //Volksbank Tettnang
            "65310111",    //SEB
            "65340004",    //Commerzbank
            "65341204",    //Commerzbank
            "65351050",    //Hohenz Landesbank Kreissparkasse Sigmaringen
            "65351260",    //Sparkasse Zollernalb
            "65361469",    //Volksbank Heuberg
            "65361898",    //Winterlinger Bank
            "65361989",    //Onstmettinger Bank
            "65362499",    //Raiffeisenbank Geislingen-Rosenfeld
            "65370024",    //Deutsche Bank Privat und Geschäftskunden
            "65370075",    //Deutsche Bank
            "65380003",    //Commerzbank vormals Dresdner Bank
            "65390120",    //Volksbank Albstadt
            "65391210",    //Volksbank Balingen -alt-
            "65392030",    //Volksbank Tailfingen -alt-
            "65440087",    //Commerzbank
            "65450070",    //Kreissparkasse Biberach
            "65461878",    //Raiffeisenbank Riss-Umlach
            "65462231",    //Raiffeisenbank Illertal -alt-
            "65491320",    //Volksbank Raiffeisenbank Laupheim-Illertal
            "65491510",    //Volksbank-Raiffeisenbank Riedlingen
            "66000000",    //Bundesbank
            "66010075",    //Postbank
            "66010111",    //SEB
            "66010200",    //Deutsche Bausparkasse Badenia
            "66010700",    //Landeskreditbank Baden-Württemberg Förderbank
            "66020020",    //Baden-Württembergische Bank
            "66020286",    //UniCredit Bank - HypoVereinsbank
            "66020500",    //Bank für Sozialwirtschaft
            "66020566",    //Bank für Sozialwirtschaft
            "66030600",    //Isbank Fil Karlsruhe
            "66040018",    //Commerzbank
            "66040026",    //Commerzbank/Kreditcenter Badenia
            "66050000",    //Landesbank Baden-Württemberg
            "66050101",    //Sparkasse Karlsruhe
            "66051220",    //Sparkasse Ettlingen -alt-
            "66060000",    //DZ BANK
            "66060300",    //Spar- und Kreditbank
            "66061407",    //Spar- und Kreditbank
            "66061724",    //Volksbank Stutensee-Weingarten
            "66062138",    //Spar- und Kreditbank Hardt
            "66062366",    //Raiffeisenbank Hardt-Bruhrain
            "66069103",    //Raiffeisenbank Elztal
            "66069104",    //Spar- und Kreditbank
            "66069342",    //Volksbank Krautheim
            "66070004",    //Deutsche Bank
            "66070024",    //Deutsche Bank Privat und Geschäftskunden
            "66080052",    //Commerzbank vormals Dresdner Bank
            "66090621",    //apoBank
            "66090800",    //BBBank
            "66090900",    //PSD Bank Karlsruhe-Neustadt
            "66091200",    //Volksbank Ettlingen
            "66190000",    //Volksbank Karlsruhe
            "66240002",    //Commerzbank
            "66250030",    //Sparkasse Baden-Baden Gaggenau
            "66251434",    //Sparkasse Bühl
            "66261092",    //Spar- und Kreditbank
            "66261416",    //Raiffeisenbank Altschweier
            "66270001",    //Deutsche Bank
            "66270024",    //Deutsche Bank Privat und Geschäftskunden
            "66280053",    //Commerzbank vormals Dresdner Bank
            "66290000",    //Volksbank Baden-Baden Rastatt
            "66291300",    //Volksbank Achern -alt-
            "66291400",    //Volksbank Bühl
            "66340018",    //Commerzbank
            "66350036",    //Sparkasse Kraichgau Bruchsal-Bretten-Sinsheim
            "66391200",    //Volksbank Bruchsal-Bretten
            "66391600",    //Volksbank Bruhrain-Kraich-Hardt
            "66432700",    //Bankhaus J. Faißt
            "66440084",    //Commerzbank
            "66450050",    //Sparkasse Offenburg/Ortenau
            "66451346",    //Sparkasse Gengenbach
            "66451548",    //Sparkasse Haslach-Zell
            "66451862",    //Sparkasse Hanauerland
            "66452776",    //Sparkasse Wolfach
            "66470024",    //Deutsche Bank Privat und Geschäftskunden
            "66470035",    //Deutsche Bank
            "66490000",    //Volksbank in der Ortenau
            "66491800",    //Volksbank Bühl Fil Kehl
            "66492600",    //Volksbank Appenweier-Urloffen Appenweier -alt-
            "66492700",    //Volksbank Kinzigtal
            "66550070",    //Sparkasse Rastatt-Gernsbach
            "66562053",    //Raiffeisenbank Südhardt Durmersheim
            "66562300",    //VR-Bank in Mittelbaden
            "66610111",    //SEB
            "66640035",    //Commerzbank
            "66650085",    //Sparkasse Pforzheim Calw
            "66661244",    //Raiffeisenbank Bauschlott
            "66661329",    //Raiffeisenbank Kieselbronn
            "66661454",    //VR Bank im Enzkreis
            "66662155",    //Raiffeisenbank Ersingen
            "66662220",    //Volksbank Stein Eisingen
            "66670006",    //Deutsche Bank
            "66670024",    //Deutsche Bank Privat und Geschäftskunden
            "66680013",    //Commerzbank vormals Dresdner Bank
            "66690000",    //Volksbank Pforzheim
            "66692300",    //Volksbank Wilferdingen-Keltern
            "66762332",    //Raiffeisenbank Kraichgau
            "66762433",    //Raiffeisenbank Neudenau-Stein-Herbolzheim
            "67010111",    //SEB
            "67020190",    //UniCredit Bank - HypoVereinsbank
            "67040031",    //Commerzbank
            "67040060",    //Commerzbank CC
            "67040061",    //Commerzbank CC
            "67040085",    //Commerzbank, Gf Web-K
            "67050505",    //Sparkasse Rhein Neckar Nord
            "67051203",    //Sparkasse Hockenheim
            "67060031",    //Volksbank Sandhofen
            "67070010",    //Deutsche Bank
            "67070024",    //Deutsche Bank Privat und Geschäftskunden
            "67080050",    //Commerzbank vormals Dresdner Bank
            "67080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 2
            "67080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 3
            "67089440",    //Commerzbank vormals Dresdner Bank ITGK
            "67090000",    //VR Bank Rhein-Neckar
            "67090617",    //apoBank
            "67092300",    //Volksbank Weinheim
            "67210111",    //SEB
            "67220286",    //UniCredit Bank - HypoVereinsbank
            "67230000",    //MLP Finanzdienstleistungen
            "67230001",    //MLP Finanzdienstleistungen Zw CS
            "67240039",    //Commerzbank
            "67250020",    //Sparkasse Heidelberg
            "67262243",    //Raiffeisen Privatbank
            "67262550",    //Volksbank Rot
            "67270003",    //Deutsche Bank
            "67270024",    //Deutsche Bank Privat und Geschäftskunden
            "67280051",    //Commerzbank vormals Dresdner Bank
            "67290000",    //Heidelberger Volksbank
            "67290100",    //Volksbank Kurpfalz
            "67291700",    //Volksbank Neckartal
            "67291900",    //Volksbank Kraichgau -alt-
            "67292200",    //Volksbank Kraichgau Wiesloch-Sinsheim
            "67352565",    //Sparkasse Tauberfranken
            "67362560",    //Volksbank Tauber -alt-
            "67390000",    //Volksbank Main-Tauber
            "67450048",    //Sparkasse Neckartal-Odenwald
            "67460041",    //Volksbank Mosbach
            "67461424",    //Volksbank Franken
            "67461733",    //Volksbank Kirnau
            "67462368",    //Volksbank Limbach
            "67462480",    //Raiffeisenbank Schefflenz-Seckach -alt-
            "68000000",    //Bundesbank
            "68010111",    //SEB
            "68020186",    //UniCredit Bank - HypoVereinsbank
            "68030000",    //Bankhaus E. Mayer
            "68040007",    //Commerzbank
            "68050101",    //Sparkasse Freiburg-Nördlicher Breisgau
            "68051004",    //Sparkasse Hochschwarzwald
            "68051207",    //Sparkasse Bonndorf-Stühlingen
            "68052230",    //Sparkasse St. Blasien
            "68052328",    //Sparkasse Staufen-Breisach
            "68052863",    //Sparkasse Schönau-Todtnau
            "68061505",    //Volksbank Breisgau-Süd
            "68062105",    //Raiffeisenbank Denzlingen-Sexau
            "68062730",    //Raiffeisenbank Wyhl
            "68063479",    //Raiffeisenbank Kaiserstuhl
            "68064222",    //Raiffeisenbank
            "68070024",    //Deutsche Bank Privat und Geschäftskunden
            "68070030",    //Deutsche Bank
            "68080030",    //Commerzbank vormals Dresdner Bank
            "68080031",    //Commerzbank vormals Dresdner Bank Zw Münsterstraße
            "68080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "68080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 2
            "68090000",    //Volksbank Freiburg
            "68090622",    //apoBank
            "68090900",    //PSD Bank RheinNeckarSaar
            "68091900",    //Volksbank Müllheim
            "68092000",    //Volksbank Breisgau Nord
            "68092300",    //Volksbank Staufen
            "68270024",    //Deutsche Bank Privat und Geschäftskunden
            "68270033",    //Deutsche Bank
            "68290000",    //Volksbank Lahr
            "68310111",    //SEB
            "68340058",    //Commerzbank
            "68350048",    //Sparkasse Lörrach-Rheinfelden
            "68351557",    //Sparkasse Schopfheim-Zell
            "68351865",    //Sparkasse Markgräflerland
            "68351976",    //Sparkasse Zell i W -alt-
            "68370024",    //Deutsche Bank Privat und Geschäftskunden
            "68370034",    //Deutsche Bank
            "68390000",    //Volksbank Dreiländereck
            "68391500",    //VR Bank
            "68452290",    //Sparkasse Hochrhein
            "68462427",    //Volksbank Klettgau-Wutöschingen
            "68490000",    //Volksbank Rhein-Wehra
            "68492200",    //Volksbank Hochrhein
            "69010111",    //SEB
            "69020190",    //UniCredit Bank - HypoVereinsbank
            "69040045",    //Commerzbank
            "69050001",    //Sparkasse Bodensee
            "69051410",    //Bezirkssparkasse Reichenau
            "69051620",    //Sparkasse Pfullendorf-Meßkirch
            "69051725",    //Sparkasse Salem-Heiligenberg
            "69061800",    //Volksbank Überlingen
            "69070024",    //Deutsche Bank Privat und Geschäftskunden
            "69070032",    //Deutsche Bank
            "69091200",    //Hagnauer Volksbank
            "69091600",    //Volksbank Pfullendorf
            "69220186",    //UniCredit Bank - HypoVereinsbank
            "69240075",    //Commerzbank
            "69250035",    //Sparkasse Hegau-Bodensee
            "69251445",    //Sparkasse Engen-Gottmadingen
            "69251755",    //Sparkasse Stockach -alt-
            "69270024",    //Deutsche Bank Privat und Geschäftskunden
            "69270038",    //Deutsche Bank
            "69280035",    //Commerzbank vormals Dresdner Bank
            "69290000",    //Volksbank Hegau -alt-
            "69291000",    //Volksbank
            "69291099",    //Volksbank Gf GA
            "69362032",    //Volksbank Meßkirch Raiffeisenbank
            "69400000",    //Bundesbank
            "69440007",    //Commerzbank Villingen u Schwenningen
            "69440060",    //Commerzbank CC
            "69450065",    //Sparkasse Schwarzwald-Baar
            "69451070",    //Sparkasse Donaueschingen -alt-
            "69470024",    //Deutsche Bank Privat und Geschäftskunden
            "69470039",    //Deutsche Bank Villingen u Schwenningen
            "69490000",    //Volksbank Schwarzwald Baar Hegau
            "69491700",    //Volksbank Triberg
            "70000000",    //Bundesbank
            "70010080",    //Postbank (Giro)
            "70010111",    //SEB
            "70010424",    //Aareal Bank
            "70010500",    //Deutsche Pfandbriefbank
            "70010555",    //Deutsche Pfandbriefbank - Einlagengeschäfte
            "70010570",    //Deutsche Pfandbriefbank
            "70011100",    //Deutsche Kontor Privatbank
            "70011110",    //Deutsche Kontor Privatbank
            "70011200",    //Bank Vontobel Europe
            "70011300",    //Autobank
            "70011400",    //BfW - Bank für Wohnungswirtschaft
            "70011500",    //SIEMENS BANK
            "70011600",    //WEG Bank
            "70011700",    //Bankhaus von der Heydt
            "70011900",    //InterCard
            "70012000",    //UniCredit Family Financing Bank, Ndl der UniCredit
            "70012100",    //Dero Bank
            "70012200",    //Bank J. Safra Sarasin (Deutschland)
            "70012300",    //V-Bank
            "70012400",    //Die AKTIONÄRSBANK Kulmbach
            "70012600",    //Südtiroler Sparkasse Niederlassung München
            "70013000",    //European Bank for Financial Services
            "70013010",    //European Bank for Financial Services
            "70013100",    //net-m privatbank 1891
            "70013199",    //net-m privatbank 1891
            "70013400",    //IC Cash Services
            "70013500",    //Bankhaus Herzogpark
            "70015000",    //transact Elektronische Zahlungssysteme
            "70015015",    //transact Elektronische Zahlungssysteme
            "70015025",    //transact Elektronische Zahlungssysteme
            "70015035",    //transact Elektronische Zahlungssysteme
            "70017000",    //PayCenter
            "70020270",    //UniCredit Bank - HypoVereinsbank
            "70020300",    //Commerz Finanz
            "70020500",    //Bank für Sozialwirtschaft
            "70020570",    //Bank für Sozialwirtschaft
            "70020800",    //INTESA SANPAOLO
            "70021180",    //UniCredit Bank - HypoVereinsbank
            "70022200",    //Fidor Bank
            "70025175",    //UniCredit Bank - HypoVereinsbank
            "70030014",    //Fürst Fugger Privatbank
            "70030111",    //Bankhaus Max Flessa
            "70030300",    //Bankhaus Reuschel & Co -alt-
            "70030400",    //Merck Finck Privatbankiers
            "70031000",    //Bankhaus Ludwig Sperrer
            "70032500",    //St. Galler Kantonalbank Deutschland
            "70033100",    //Baader Bank
            "70035000",    //Oldenburgische Landesbank
            "70040041",    //Commerzbank
            "70040045",    //Commerzbank, Filiale München 2
            "70040048",    //Commerzbank GF-M48
            "70040060",    //Commerzbank Gf 860
            "70040061",    //Commerzbank Gf 861
            "70040062",    //Commerzbank CC
            "70040063",    //Commerzbank CC
            "70040070",    //Commerzbank, CC SP
            "70045050",    //Commerzbank Service-BZ
            "70050000",    //Bayerische Landesbank
            "70051003",    //Sparkasse Freising
            "70051540",    //Sparkasse Dachau
            "70051805",    //Kreissparkasse München Starnberg Ebersberg -alt-
            "70051995",    //Kreis- und Stadtsparkasse Erding-Dorfen
            "70052060",    //Sparkasse Landsberg-Dießen
            "70053070",    //Sparkasse Fürstenfeldbruck
            "70054306",    //Sparkasse Bad Tölz-Wolfratshausen
            "70070010",    //Deutsche Bank
            "70070024",    //Deutsche Bank Privat und Geschäftskunden
            "70080000",    //Commerzbank vormals Dresdner Bank
            "70080056",    //Commerzbank vormals Dresdner Bank Zw 56
            "70080057",    //Commerzbank vormals Dresdner Bank Gf ZW 57
            "70080085",    //Commerzbank vormals Dresdner Bank Gf PCC DCC-ITGK 3
            "70080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 4
            "70080087",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 5
            "70080088",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 6
            "70089470",    //Commerzbank vormals Dresdner Bank ITGK
            "70089472",    //Commerzbank vormals Dresdner Bank ITGK
            "70090100",    //Hausbank München
            "70090124",    //Hausbank München
            "70090500",    //Sparda-Bank München
            "70090606",    //apoBank
            "70091500",    //Volksbank Raiffeisenbank Dachau
            "70091600",    //VR-Bank Landsberg-Ammersee
            "70091900",    //VR-Bank Erding
            "70093200",    //Volksbank Raiffeisenbank Starnberg-Herrsching-Landsberg
            "70093400",    //VR-Bank Ismaning Hallbergmoos Neufahrn
            "70110088",    //Postbank (Spar)
            "70110500",    //Münchener Hypothekenbank
            "70110600",    //UBI BANCA INTERNATIONAL - Ndl München
            "70120100",    //State Street Bank International
            "70120400",    //BNP Paribas Niederlassung Deutschland
            "70120500",    //CACEIS Bank, Germany Branch
            "70120600",    //Airbus Group Bank
            "70120700",    //Oberbank Ndl Deutschland
            "70130700",    //Bankhaus August Lenz & Co
            "70130799",    //Bankhaus August Lenz & Co Gf GAA
            "70130800",    //Merkur Bank
            "70133300",    //Santander Consumer Bank
            "70150000",    //Stadtsparkasse München
            "70160000",    //DZ BANK
            "70160300",    //Raiffeisenbank München -alt-
            "70163370",    //Volksbank Raiffeisenbank Fürstenfeldbruck
            "70166486",    //VR Bank München Land
            "70169132",    //Raiffeisenbank Griesstätt-Halfing
            "70169165",    //Raiffeisenbank Chiemgau-Nord - Obing
            "70169168",    //VR-Bank Chiemgau-Süd -alt-
            "70169186",    //Raiffeisenbank Pfaffenhofen a d Glonn
            "70169190",    //Raiffeisenbank Tattenh-Großkarolinenf
            "70169191",    //Raiffeisenbank Rupertiwinkel
            "70169195",    //Raiffeisenbank Trostberg-Traunreut
            "70169310",    //Alxing-Brucker Genossenschaftsbank
            "70169331",    //Raiffeisenbank südöstl. Starnberger See -alt-
            "70169333",    //Raiffeisenbank Beuerberg-Eurasburg
            "70169351",    //Raiffeisenbank Nordkreis Landsberg
            "70169356",    //Raiffeisenbank Erding
            "70169382",    //Raiffeisenbank
            "70169383",    //Raiffeisenbank Gmund am Tegernsee
            "70169388",    //Raiffeisenbank Haag-Gars-Maitenbeth
            "70169402",    //Raiffeisenbank Höhenkirchen und Umgebung
            "70169410",    //Raiffeisenbank Holzkirchen-Otterfing
            "70169413",    //Raiffeisenbank Singoldtal
            "70169450",    //Raiffeisen-Volksbank Ebersberg
            "70169459",    //Raiffeisenbank
            "70169460",    //Raiffeisenbank Westkreis Fürstenfeldbruck
            "70169464",    //Genossenschaftsbank München
            "70169465",    //Raiffeisenbank München-Nord
            "70169466",    //Raiffeisenbank München-Süd
            "70169470",    //Raiffeisenbank München-Süd Gf GA
            "70169474",    //Raiffbk Neumarkt-St. Veit - Niederbergkirchen -alt-
            "70169476",    //Raiffeisenbank -alt-
            "70169493",    //Raiffeisenbank Oberschleißheim -alt-
            "70169509",    //Raiffeisenbank Pfaffenwinkel
            "70169521",    //Raiffeisenbank Raisting
            "70169524",    //Raiffeisenbank RSA
            "70169530",    //Raiffeisenbank Neumarkt-St. Veit - Reischach
            "70169538",    //Raiffeisenbank St. Wolfgang-Schwindkirchen
            "70169541",    //Raiffeisenbank Lech-Ammersee -alt-
            "70169543",    //Raiffeisenbank Isar-Loisachtal
            "70169558",    //Raiffeisenbank
            "70169566",    //VR-Bank Taufkirchen-Dorfen
            "70169568",    //Raiffeisenbank Taufkirchen-Oberneukirchen
            "70169571",    //Raiffeisenbank Tölzer Land
            "70169575",    //Raiffeisenbank
            "70169576",    //Raiffeisen-Volksbank Tüßling-Unterneukirchen
            "70169585",    //Raiffeisenbank Unterschleißheim-Haimhn -alt-
            "70169598",    //Raiffeisenbank im Oberland
            "70169599",    //Raiffeisenbank Weil u Umgebung -alt-
            "70169602",    //Raiffeisenbank Weilheim -alt-
            "70169605",    //Raiffeisen-Volksbank Isen-Sempt
            "70169614",    //Freisinger Bank Volksbank-Raiffeisenbank
            "70169619",    //Raiffeisenbank Zorneding
            "70169653",    //Raiffeisenbank Aiglsbach
            "70169693",    //Raiffeisenbank Hallertau
            "70190000",    //Münchner Bank
            "70220000",    //LfA Förderbank Bayern
            "70220200",    //BHF-BANK
            "70220300",    //BMW Bank
            "70220800",    //Vereinsbank Victoria Bauspar
            "70220900",    //Wüstenrot Bausparkasse
            "70230600",    //Isbank Fil München
            "70250150",    //Kreissparkasse München Starnberg Ebersberg
            "70320090",    //UniCredit Bank - HypoVereinsbank
            "70321194",    //UniCredit Bank - HypoVereinsbank
            "70322192",    //UniCredit Bank - HypoVereinsbank
            "70350000",    //Kreissparkasse Garmisch-Partenkirchen
            "70351030",    //Vereinigte Sparkassen im Landkreis Weilheim
            "70362595",    //Raiffeisenbank Wallgau-Krün
            "70380006",    //Commerzbank vormals Dresdner Bank
            "70390000",    //VR-Bank Werdenfels
            "70390010",    //VR-Bank Werdenfels
            "70391800",    //Volksbank-Raiffeisenbank Penzberg -alt-
            "71020072",    //UniCredit Bank - HypoVereinsbank
            "71021270",    //UniCredit Bank - HypoVereinsbank
            "71022182",    //UniCredit Bank - HypoVereinsbank
            "71023173",    //UniCredit Bank - HypoVereinsbank
            "71050000",    //Sparkasse Berchtesgadener Land
            "71051010",    //Kreissparkasse Altötting-Burghausen -alt-
            "71052050",    //Kreissparkasse Traunstein-Trostberg
            "71061009",    //VR meine Raiffeisenbank
            "71062802",    //Raiffeisenbank
            "71090000",    //Volksbank Raiffeisenbank Oberbayern Südost
            "71120077",    //UniCredit Bank - HypoVereinsbank
            "71120078",    //UniCredit Bank - HypoVereinsbank
            "71121176",    //UniCredit Bank - HypoVereinsbank
            "71122183",    //UniCredit Bank - HypoVereinsbank
            "71140041",    //Commerzbank Rosenheim
            "71141041",    //Commerzbank
            "71142041",    //Commerzbank
            "71150000",    //Sparkasse Rosenheim-Bad Aibling
            "71151020",    //Sparkasse Altötting-Mühldorf
            "71152570",    //Kreissparkasse Miesbach-Tegernsee
            "71152680",    //Kreis- und Stadtsparkasse Wasserburg
            "71160000",    //Volksbank Raiffeisenbank Rosenheim-Chiemsee
            "71160161",    //VR Bank Rosenheim-Chiemsee -alt-
            "71161964",    //Volksbank-Raiffeisenbank Chiemsee -alt-
            "71162355",    //Raiffeisenbank Oberaudorf
            "71162804",    //Raiffeisenbank Aschau-Samerberg
            "71165150",    //Raiffeisenbank Mangfalltal -alt-
            "71180005",    //Commerzbank vormals Dresdner Bank
            "71190000",    //Volksbank Rosenheim -alt-
            "71191000",    //VR-Bank Burghausen-Mühldorf -alt-
            "72000000",    //Bundesbank
            "72010111",    //SEB
            "72012300",    //Bank für Tirol und Vorarlberg Deutschland
            "72020070",    //UniCredit Bank - HypoVereinsbank
            "72020700",    //Augsburger Aktienbank
            "72021271",    //UniCredit Bank - HypoVereinsbank
            "72021876",    //UniCredit Bank - HypoVereinsbank
            "72030014",    //Fürst Fugger Privatbank
            "72030227",    //Bankhaus Anton Hafner
            "72030260",    //Bankhaus Anton Hafner (Gf PayCenter)
            "72040046",    //Commerzbank
            "72050000",    //Stadtsparkasse Augsburg
            "72050101",    //Kreissparkasse Augsburg
            "72051210",    //Sparkasse Aichach-Schrobenhausen
            "72051840",    //Sparkasse Günzburg-Krumbach
            "72062152",    //VR-Bank Handels- und Gewerbebank
            "72069002",    //Raiffeisenbank Adelzhausen-Sielenbach
            "72069005",    //Raiffeisenbank
            "72069034",    //Raiffeisenbank Bissingen
            "72069036",    //Raiffeisenbank
            "72069043",    //VR-Bank Donau-Mindel
            "72069105",    //Raiffeisenbank
            "72069113",    //Raiffeisenbank Aschberg
            "72069114",    //Raiffeisenbank
            "72069119",    //Raiffeisenbank Ichenhausen
            "72069123",    //Raiffeisenbank Jettingen-Scheppach
            "72069126",    //Raiffeisenbank Mittelschwaben
            "72069132",    //Raiffeisenbank Krumbach/Schwaben
            "72069135",    //Raiffeisenbank Stauden
            "72069155",    //Raiffeisenbank Kissing-Mering
            "72069179",    //Raiffeisenbank Unteres Zusamtal
            "72069181",    //Raiffeisenbank -alt-
            "72069193",    //Raiffeisenbank
            "72069209",    //Raiffeisenbank -alt-
            "72069220",    //Raiffeisenbank
            "72069235",    //Raiffeisenbank
            "72069263",    //Raiffeisenbank Wittislingen
            "72069274",    //Raiffeisenbank Augsburger Land West
            "72069308",    //Raiffeisen-Volksbank Wemding
            "72069329",    //Raiffeisen-Volksbank Ries
            "72069736",    //Raiffeisenbank Iller-Roth-Günz
            "72069789",    //Raiffeisenbank Pfaffenhausen
            "72070001",    //Deutsche Bank
            "72070024",    //Deutsche Bank Privat und Geschäftskunden
            "72080001",    //Commerzbank vormals Dresdner Bank
            "72090000",    //Augusta-Bank Raiffeisen-Volksbank
            "72090500",    //Sparda-Bank Augsburg
            "72090900",    //PSD Bank München
            "72091800",    //Volksbank Günzburg -alt-
            "72120078",    //UniCredit Bank - HypoVereinsbank
            "72122181",    //UniCredit Bank - HypoVereinsbank
            "72140052",    //Commerzbank
            "72150000",    //Sparkasse Ingolstadt Eichstätt
            "72151340",    //Sparkasse Eichstätt -alt-
            "72151650",    //Sparkasse Pfaffenhofen
            "72151880",    //Sparkasse Aichach-Schrobenhausen -alt-
            "72152070",    //Sparkasse Neuburg-Rain
            "72160818",    //Volksbank Raiffeisenbank Bayern Mitte
            "72169013",    //Raiffeisenbank Aresing-Hörzhausen-Schiltberg -alt-
            "72169080",    //Raiffeisenbank Aresing-Gerolsbach
            "72169111",    //Raiffeisenbank Hohenwart -alt-
            "72169218",    //Schrobenhausener Bank
            "72169246",    //Raiffeisenbank Schrobenhausener Land
            "72169380",    //Raiffeisenbank Beilngries
            "72169745",    //Raiffeisenbank Ehekirchen-Oberhausen
            "72169756",    //VR Bank Neuburg-Rain
            "72169764",    //Raiffeisenbank Donaumooser Land
            "72169812",    //Raiffeisenbank Gaimersheim-Buxheim
            "72169831",    //Raiffeisenbank Riedenburg-Lobsing
            "72170007",    //Deutsche Bank
            "72170024",    //Deutsche Bank Privat und Geschäftskunden
            "72180002",    //Commerzbank vormals Dresdner Bank
            "72191300",    //Volksbank Raiffeisenbank Eichstätt -alt-
            "72191600",    //Hallertauer Volksbank
            "72220074",    //UniCredit Bank - HypoVereinsbank
            "72223182",    //UniCredit Bank - HypoVereinsbank
            "72250000",    //Sparkasse Nördlingen
            "72250160",    //Sparkasse Donauwörth
            "72251520",    //Kreis- und Stadtsparkasse Dillingen
            "72261754",    //Raiffeisenbank Rain am Lech -alt-
            "72262401",    //Raiffeisen-Volksbank Dillingen -alt-
            "72290100",    //Raiffeisen-Volksbank Donauwörth
            "73050000",    //Sparkasse Neu-Ulm-Illertissen
            "73061191",    //VR-Bank Neu-Ulm
            "73090000",    //Volksbank Neu-Ulm -alt-
            "73120075",    //UniCredit Bank - HypoVereinsbank
            "73140046",    //Commerzbank Memmingen
            "73150000",    //Sparkasse Memmingen-Lindau-Mindelheim
            "73160000",    //Genossenschaftsbank Unterallgäu
            "73180011",    //Commerzbank vormals Dresdner Bank
            "73190000",    //VR-Bank Memmingen
            "73191500",    //Volksbank Ulm-Biberach -alt-
            "73311600",    //Vorarlberger Landes- und Hypothekenbank
            "73320073",    //UniCredit Bank - HypoVereinsbank
            "73321177",    //UniCredit Bank - HypoVereinsbank
            "73322380",    //UniCredit Bank - HypoVereinsbank
            "73331700",    //Gabler-Saliter Bankgeschäft
            "73340046",    //Commerzbank Kempten Allgäu
            "73350000",    //Sparkasse Allgäu
            "73351635",    //Sparkasse Riezlern, Kleinwalsertal
            "73362421",    //Bankhaus Jungholz Zndl der Raiffeisenbank Reutte
            "73369264",    //Raiffeisenbank im Allgäuer Land
            "73369821",    //BodenseeBank
            "73369823",    //Raiffeisenbank Westallgäu
            "73369826",    //Volksbank
            "73369851",    //Raiffeisenbank Aitrang-Ruderatshofen
            "73369854",    //Raiffeisenbank Fuchstal-Denklingen
            "73369859",    //Raiffeisenbank
            "73369871",    //Raiffeisenbank Baisweil-Eggenthal-Friesenried
            "73369878",    //Raiffeisenbank Füssen-Pfronten-Nesselwang -alt-
            "73369881",    //Raiffeisenbank Haldenwang -alt-
            "73369902",    //Raiffeisenbank Kempten -alt-
            "73369918",    //Raiffeisenbank Kirchweihtal
            "73369920",    //Raiffeisenbank Kempten-Oberallgäu
            "73369933",    //Raiffeisenbank Südliches Ostallgäu
            "73369936",    //Raiffeisenbank Seeg -alt-
            "73369954",    //Raiffeisenbank Wald-Görisried
            "73370008",    //Deutsche Bank
            "73370024",    //Deutsche Bank Privat und Geschäftskunden
            "73380004",    //Commerzbank vormals Dresdner Bank
            "73390000",    //Allgäuer Volksbank Kempten-Sonthofen
            "73391600",    //Volksbank im Kleinwalsertal
            "73392000",    //Volksbank Immenstadt
            "73420071",    //UniCredit Bank - HypoVereinsbank
            "73421478",    //UniCredit Bank - HypoVereinsbank
            "73440048",    //Commerzbank
            "73450000",    //Kreis- und Stadtsparkasse Kaufbeuren
            "73451450",    //Kreissparkasse Schongau
            "73460046",    //VR Bank Kaufbeuren-Ostallgäu
            "73480013",    //Commerzbank vormals Dresdner Bank
            "74020074",    //UniCredit Bank - HypoVereinsbank
            "74020100",    //Raiffeisenlandesbank OÖ Zndl Süddeutschland
            "74020150",    //Raiffeisenlandesbank OÖ Zndl Südde - für interne Zwecke
            "74040082",    //Commerzbank Passau
            "74050000",    //Sparkasse Passau
            "74051230",    //Sparkasse Freyung-Grafenau
            "74061101",    //Raiffeisenbank Am Goldenen Steig
            "74061564",    //Raiffeisenbank Unteres Inntal
            "74061670",    //Raiffeisenbank Ortenburg-Kirchberg
            "74061813",    //VR-Bank Rottal-Inn
            "74061814",    //VR-Bank Rottal-Inn
            "74062490",    //Raiffeisenbank Vilshofener Land
            "74062786",    //Raiffeisenbank i Lkr Passau-Nord
            "74064593",    //Raiffeisenbank
            "74065782",    //Raiffeisenbank Salzweg-Thyrnau -alt-
            "74066749",    //Raiffeisenbank Südl. Bayerischer Wald
            "74067000",    //Rottaler Raiffeisenbank
            "74069744",    //Raiffeisenbank
            "74069752",    //Raiffeisenbank Hohenau-Mauth -alt-
            "74069758",    //Raiffeisenbank Kirchberg v. Wald
            "74069768",    //Raiffeisenbank am Dreisessel
            "74090000",    //VR-Bank Passau
            "74092400",    //Volksbank Vilshofen
            "74120071",    //UniCredit Bank - HypoVereinsbank
            "74131000",    //TEBA Kreditbank
            "74140048",    //Commerzbank
            "74150000",    //Sparkasse Deggendorf
            "74151450",    //Sparkasse Regen-Viechtach
            "74160025",    //Raiffeisenbank Deggendorf-Plattling
            "74161608",    //Raiffeisenbank Hengersberg-Schöllnach
            "74164149",    //VR-Bank -alt-
            "74165013",    //Raiffeisenbank Sonnenwald
            "74180009",    //Commerzbank vormals Dresdner Bank
            "74190000",    //VR GenoBank DonauWald
            "74191000",    //VR-Bank Landau
            "74220075",    //UniCredit Bank - HypoVereinsbank
            "74221170",    //UniCredit Bank - HypoVereinsbank
            "74240062",    //Commerzbank Straubing
            "74250000",    //Sparkasse Niederbayern-Mitte
            "74251020",    //Sparkasse im Landkreis Cham
            "74260110",    //Raiffeisenbank
            "74261024",    //Raiffeisenbank Chamer Land
            "74290000",    //Volksbank Straubing
            "74290100",    //CB Bank
            "74320073",    //UniCredit Bank - HypoVereinsbank
            "74340077",    //Commerzbank
            "74350000",    //Sparkasse Landshut
            "74351310",    //Sparkasse Dingolfing-Landau -alt-
            "74351430",    //Sparkasse Rottal-Inn
            "74351740",    //Stadt- und Kreissparkasse Moosburg
            "74361211",    //Raiffeisenbank Arnstorf
            "74362663",    //Raiffeisenbank Altdorf-Ergolding
            "74364689",    //Raiffeisenbank Pfeffenhausen-Rottenburg-Wildenberg
            "74366666",    //Raiffeisenbank Geisenhausen
            "74369068",    //Raiffeisenbank Hofkirchen-Bayerbach
            "74369088",    //Raiffeisenbank Geiselhöring-Pfaffenberg
            "74369130",    //Raiffeisenbank Parkstetten
            "74369146",    //Raiffeisenbank Rattiszell-Konzell
            "74369656",    //Raiffeisenbank Essenbach
            "74369662",    //Raiffeisenbank Buch-Eching
            "74369704",    //Raiffeisenbank Mengkofen-Loiching
            "74369709",    //Raiffeisenbank Wildenberg -alt-
            "74380007",    //Commerzbank vormals Dresdner Bank
            "74390000",    //VR-Bank Landshut
            "74391300",    //Volksbank-Raiffeisenbank Dingolfing
            "74391400",    //VR-Bank Rottal-Inn
            "74392300",    //VR-Bank Vilsbiburg
            "75000000",    //Bundesbank
            "75010111",    //SEB
            "75020073",    //UniCredit Bank - HypoVereinsbank
            "75021174",    //UniCredit Bank - HypoVereinsbank
            "75040062",    //Commerzbank Regensburg
            "75050000",    //Sparkasse Regensburg
            "75051040",    //Sparkasse im Landkreis Schwandorf
            "75051565",    //Kreissparkasse Kelheim
            "75060150",    //Raiffeisenbank Regensburg-Wenzenbach
            "75061168",    //Raiffeisenbank Schwandorf-Nittenau
            "75061851",    //Raiffeisenbank Regenstauf
            "75062026",    //Raiffeisenbank Oberpfalz Süd
            "75069014",    //Raiffeisenbank Bad Abbach-Saal
            "75069015",    //Raiffeisenbank Bad Gögging
            "75069020",    //Raiffeisenbank Bruck
            "75069038",    //Raiffeisenbank Falkenstein-Wörth
            "75069050",    //Raiffeisenbank Grafenwöhr-Kirchenthumbach
            "75069055",    //Raiffeisenbank Alteglofsheim-Hagelstadt
            "75069061",    //Raiffeisenbank Hemau-Kallmünz
            "75069062",    //Raiffeisenbank Herrnwahlthann-Teugn-Dünzling -alt-
            "75069078",    //Raiffeisenbank
            "75069081",    //Raiffeisenbank Bad Kötzting
            "75069094",    //Raiffeisenbank Parsberg-Velburg
            "75069110",    //Raiffeisenbank Eschlkam-Lam-Lohberg-Neukirchen b Hl Blut
            "75069171",    //Raiffeisenbank im Naabtal
            "75070013",    //Deutsche Bank
            "75070024",    //Deutsche Bank Privat und Geschäftskunden
            "75080003",    //Commerzbank vormals Dresdner Bank
            "75090000",    //Volksbank Regensburg
            "75090300",    //LIGA Bank
            "75090500",    //Sparda-Bank Ostbayern
            "75090629",    //apoBank
            "75090900",    //PSD Bank Niederbayern-Oberpfalz
            "75091400",    //VR Bank Burglengenfeld
            "75220070",    //UniCredit Bank - HypoVereinsbank
            "75240000",    //Commerzbank
            "75250000",    //Sparkasse Amberg-Sulzbach
            "75261700",    //Raiffeisenbank Sulzbach-Rosenberg
            "75290000",    //Volksbank-Raiffeisenbank Amberg
            "75320075",    //UniCredit Bank - HypoVereinsbank
            "75340090",    //Commerzbank
            "75350000",    //Sparkasse Oberpfalz Nord
            "75351960",    //Vereinigte Sparkassen Eschenbach i d Opf
            "75360011",    //Raiffeisenbank Weiden
            "75362039",    //Raiffeisenbank
            "75363189",    //Raiffeisenbank Neustadt-Vohenstrauß
            "75390000",    //Volksbank Nordoberpfalz
            "76000000",    //Bundesbank
            "76010085",    //Postbank
            "76010111",    //SEB
            "76020070",    //UniCredit Bank - HypoVereinsbank
            "76020099",    //UniCredit Bank - HypoVereinsbank Prepaid Card
            "76026000",    //norisbank
            "76030080",    //BNP Paribas Niederlassung Deutschland
            "76030600",    //Isbank Fil Nürnberg
            "76030800",    //BIW Bank für Investments und Wertpapiere
            "76032000",    //TeamBank Nürnberg
            "76032001",    //TeamBank Nürnberg GF Austria
            "76035000",    //UmweltBank
            "76040060",    //Commerzbank CC
            "76040061",    //Commerzbank
            "76040062",    //Commerzbank CC
            "76040065",    //Commerzbank, Filiale Nürnberg 2
            "76050000",    //Bayerische Landesbank
            "76050101",    //Sparkasse Nürnberg
            "76052080",    //Sparkasse Neumarkt i d OPf-Parsberg
            "76060000",    //DZ BANK
            "76060618",    //Volksbank Raiffeisenbank
            "76061025",    //Raiffeisen Spar+Kreditbank Lauf a d Pegnitz
            "76061482",    //Raiffeisenbank Hersbruck
            "76069369",    //Raiffeisenbank Auerbach-Freihung
            "76069372",    //Raiffeisenbank Bad Windsheim
            "76069378",    //Raiffeisenbank
            "76069404",    //Raiffeisenbank Uehlfeld-Dachsbach
            "76069409",    //Raiffeisenbank Dietenhofen -alt-
            "76069410",    //Raiffeisenbank Dietersheim und Umgebung
            "76069440",    //Raiffeisenbank Altdorf-Feucht
            "76069441",    //VR-Bank Feuchtwangen-Limes
            "76069448",    //Raiffeisenbank -alt-
            "76069449",    //Raiffeisenbank Berching-Freystadt-Mühlhausen
            "76069462",    //Raiffeisenbank Greding - Thalmässing
            "76069468",    //Raiffeisenbank Weißenburg-Gunzenhausen
            "76069486",    //Raiffeisenbank Hirschau
            "76069512",    //Raiffeisenbank Knoblauchsland Nürnberg-Buch
            "76069549",    //Raiffeisenbank Münchaurach -alt-
            "76069552",    //Raiffeisenbank -alt-
            "76069553",    //Raiffeisenbank Neumarkt
            "76069559",    //VR meine Bank
            "76069564",    //Raiffeisenbank Oberferrieden-Burgthann
            "76069576",    //Raiffeisenbank Plankstetten
            "76069598",    //Raiffeisenbank Großhabersdorf-Roßtal -alt-
            "76069601",    //VR-Bank Rothenburg -alt-
            "76069602",    //Raiffeisenbank Seebachgrund
            "76069611",    //Raiffeisenbank Unteres Vilstal
            "76069635",    //Raiffeisenbank Ursensollen-Ammerthal-Hohenburg -alt-
            "76069663",    //Raiffeisenbank Heilsbronn-Windsbach
            "76069669",    //Raiffeisenbank Bibertgrund
            "76070012",    //Deutsche Bank
            "76070024",    //Deutsche Bank Privat und Geschäftskunden
            "76080040",    //Commerzbank vormals Dresdner Bank
            "76080053",    //Commerzbank vormals Dresdner Bank Zw 53
            "76080055",    //Commerzbank vormals Dresdner Bank Zw 55
            "76080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "76080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 2
            "76089480",    //Commerzbank vormals Dresdner Bank ITGK
            "76089482",    //Commerzbank vormals Dresdner Bank ITGK
            "76090400",    //Evenord-Bank
            "76090500",    //Sparda-Bank Nürnberg
            "76090613",    //apoBank
            "76090900",    //PSD Bank
            "76211900",    //CVW - Privatbank
            "76220073",    //UniCredit Bank - HypoVereinsbank
            "76230000",    //BSQ Bauspar
            "76240011",    //Commerzbank Fürth Bayern
            "76250000",    //Sparkasse Fürth
            "76251020",    //Sparkasse i Landkreis Neustadt a d Aisch
            "76260451",    //Raiffeisen-Volksbank Fürth -alt-
            "76320072",    //UniCredit Bank - HypoVereinsbank
            "76330111",    //Bankhaus Max Flessa
            "76340061",    //Commerzbank Erlangen
            "76350000",    //Stadt- und Kreissparkasse Erlangen
            "76351040",    //Sparkasse Forchheim
            "76351560",    //Kreissparkasse Höchstadt
            "76360033",    //VR-Bank Erlangen-Höchstadt-Herzogenaurach
            "76391000",    //Volksbank Forchheim
            "76420080",    //UniCredit Bank - HypoVereinsbank
            "76450000",    //Sparkasse Mittelfranken-Süd
            "76460015",    //Raiffeisenbank Roth-Schwabach
            "76461485",    //Raiffeisenbank am Rothsee
            "76520071",    //UniCredit Bank - HypoVereinsbank
            "76550000",    //Sparkasse Ansbach
            "76551020",    //Kreis- und Stadtsparkasse Dinkelsbühl
            "76551540",    //Vereinigte Sparkassen Gunzenhausen
            "76551860",    //Stadt- und Kreissparkasse Rothenburg
            "76560060",    //VR-Bank Mittelfranken West
            "76561979",    //Raiffeisenbank -alt-
            "76591000",    //VR Bank Dinkelsbühl
            "77020070",    //UniCredit Bank - HypoVereinsbank
            "77030111",    //Bankhaus Max Flessa
            "77040080",    //Commerzbank Bamberg
            "77050000",    //Sparkasse Bamberg
            "77060100",    //VR Bank Bamberg Raiffeisen-Volksbank
            "77061004",    //Raiffeisenbank Obermain Nord
            "77061425",    //Raiffeisen-Volksbank
            "77062014",    //Raiffeisenbank Burgebrach-Stegaurach
            "77062139",    //Raiffeisen-Volksbank Bad Staffelstein
            "77065141",    //Raiffeisenbank Stegaurach -alt-
            "77069042",    //Raiffeisenbank Gößweinstein -alt-
            "77069044",    //Raiffeisenbank Küps-Mitwitz-Stockheim
            "77069051",    //Raiffeisenbank
            "77069052",    //Raiffeisenbank
            "77069091",    //Raiffeisenbank Ebrachgrund
            "77069110",    //Raiffeisenbank Pretzfeld -alt-
            "77069461",    //Vereinigte Raiffeisenbanken
            "77069556",    //VR-Bank Erlangen-Höchstadt-Herzogenaurach
            "77069739",    //Raiffeisenbank Thurnauer Land
            "77069746",    //Raiffeisenbank
            "77069764",    //Raiffeisenbank Kemnather Land - Steinwald
            "77069782",    //Raiffeisenbank am Kulm
            "77069836",    //Raiffeisenbank Berg-Bad Steben -alt-
            "77069868",    //Raiffeisenbank Oberland
            "77069870",    //Raiffeisenbank Hochfranken West
            "77069906",    //Raiffeisenbank Wüstenselbitz
            "77069908",    //Raiffeisenbank Sparneck-Stammbach-Zell -alt-
            "77091800",    //Raiffeisen-Volksbank Lichtenfels-Itzgrund
            "77120073",    //UniCredit Bank - HypoVereinsbank
            "77140061",    //Commerzbank
            "77150000",    //Sparkasse Kulmbach-Kronach
            "77190000",    //Kulmbacher Bank
            "77300000",    //Bundesbank eh Bayreuth
            "77320072",    //UniCredit Bank - HypoVereinsbank
            "77322200",    //Fondsdepot Bank
            "77340076",    //Commerzbank
            "77350110",    //Sparkasse Bayreuth
            "77361600",    //Raiffeisen-Volksbank Kronach-Ludwigsstadt
            "77363749",    //Raiffeisenbank
            "77365792",    //Raiffeisenbank Hollfeld-Waischenfeld-Aufseß
            "77390000",    //Volksbank-Raiffeisenbank Bayreuth
            "77390628",    //apoBank
            "78020070",    //UniCredit Bank - HypoVereinsbank
            "78040081",    //Commerzbank Hof Saale
            "78050000",    //Sparkasse Hochfranken
            "78055050",    //Sparkasse Hochfranken -alt-
            "78060896",    //VR Bank Hof
            "78140000",    //Commerzbank
            "78160069",    //VR-Bank Fichtelgebirge-Frankenwald
            "78161575",    //Raiffeisenbank im Stiftland
            "78320076",    //UniCredit Bank - HypoVereinsbank
            "78330111",    //Bankhaus Max Flessa
            "78340091",    //Commerzbank
            "78350000",    //Sparkasse Coburg-Lichtenfels
            "78360000",    //VR-Bank Coburg
            "79000000",    //Bundesbank
            "79010111",    //SEB
            "79020076",    //UniCredit Bank - HypoVereinsbank
            "79030001",    //Fürstlich Castellsche Bank Credit-Casse
            "79032038",    //Bank Schilling & Co
            "79040047",    //Commerzbank Würzburg
            "79050000",    //Sparkasse Mainfranken Würzburg
            "79061000",    //Raiffeisenbank-alt-
            "79062106",    //Raiffeisenbank
            "79063060",    //Raiffeisenbank Estenfeld-Bergtheim
            "79063122",    //Raiffeisenbank Höchberg
            "79065028",    //VR-Bank Bad Kissingen-Bad Brückenau
            "79066082",    //Raiffeisenbank -alt-
            "79069001",    //Raiffeisenbank Volkach-Wiesentheid
            "79069010",    //VR-Bank Schweinfurt
            "79069031",    //Raiffeisenbank Bütthard-Gaukönigshofen
            "79069090",    //Raiffeisenbank Ulsenheim-Gollhofen -alt-
            "79069145",    //Raiffeisenbank Kreuzwertheim-Hasloch -alt-
            "79069150",    //Raiffeisenbank Main-Spessart
            "79069165",    //Volksbank Raiffeisenbank Rhön-Grabfeld
            "79069181",    //Raiffeisenbank
            "79069188",    //Raiffeisenbank im Grabfeld
            "79069213",    //Raiffeisenbank Maßbach
            "79069271",    //Raiffeisenbank -alt-
            "79070016",    //Deutsche Bank
            "79070024",    //Deutsche Bank Privat und Geschäftskunden
            "79080052",    //Commerzbank vormals Dresdner Bank
            "79080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "79090000",    //Volksbank Raiffeisenbank
            "79090624",    //apoBank
            "79161058",    //Raiffeisenbank Fränkisches Weinland
            "79161499",    //Raiffeisenbank Kitzinger Land
            "79190000",    //VR Bank Kitzingen
            "79320075",    //UniCredit Bank - HypoVereinsbank
            "79330111",    //Bankhaus Max Flessa
            "79340054",    //Commerzbank Schweinfurt
            "79350000",    //Städtische Sparkasse Schweinfurt -alt-
            "79350101",    //Sparkasse Schweinfurt
            "79351010",    //Sparkasse Bad Kissingen
            "79351730",    //Sparkasse Ostunterfranken
            "79353090",    //Sparkasse Bad Neustadt a d Saale
            "79362081",    //VR-Bank Gerolzhofen
            "79363016",    //Volksbank Raiffeisenbank Rhön-Grabfeld -alt-
            "79363151",    //Raiffeisen-Volksbank Haßberge
            "79364069",    //Raiffeisenbank Frankenwinheim und Umgebung
            "79364406",    //VR-Bank Schweinfurt Land -alt-
            "79380051",    //Commerzbank vormals Dresdner Bank
            "79510111",    //SEB
            "79520070",    //UniCredit Bank - HypoVereinsbank
            "79540049",    //Commerzbank
            "79550000",    //Sparkasse Aschaffenburg Alzenau
            "79561348",    //Raiffeisenbank Bachgau -alt-
            "79562514",    //Raiffeisenbank Aschaffenburg
            "79565568",    //Raiffeisenbank Waldaschaff-Heigenbrücken
            "79567531",    //VR-Bank
            "79568518",    //Raiffeisenbank Haibach-Obernau
            "79570024",    //Deutsche Bank Privat und Geschäftskunden
            "79570051",    //Deutsche Bank
            "79580099",    //Commerzbank vormals Dresdner Bank
            "79589402",    //Commerzbank vormals Dresdner Bank ITGK
            "79590000",    //Volksbank Aschaffenburg
            "79650000",    //Sparkasse Miltenberg-Obernburg
            "79665540",    //Raiffeisenbank Elsavatal
            "79666548",    //Raiffeisenbank Großostheim-Obernburg
            "79668509",    //Raiffeisenbank Eichenbühl und Umgebung
            "79690000",    //Raiffeisen-Volksbank Miltenberg -alt-
            "80020086",    //UniCredit Bank - HypoVereinsbank
            "80020087",    //UniCredit Bank - HypoVereinsbank
            "80040000",    //Commerzbank
            "80050500",    //Kreissparkasse Merseburg-Querfurt -alt-
            "80053000",    //Sparkasse Burgenlandkreis
            "80053572",    //Stadtsparkasse Dessau
            "80053622",    //Kreissparkasse Köthen -alt-
            "80053722",    //Kreissparkasse Anhalt-Bitterfeld
            "80053762",    //Saalesparkasse
            "80054000",    //Kreissparkasse Weißenfels -alt-
            "80055008",    //Sparkasse Mansfeld-Südharz
            "80055500",    //Salzlandsparkasse
            "80062608",    //Volksbank Elsterland
            "80063508",    //Harzer Volksbank
            "80063558",    //Volksbank
            "80063598",    //Volksbank Wittenberg
            "80063628",    //Volksbank
            "80063648",    //Volks- und Raiffeisenbank Saale-Unstrut
            "80063678",    //VR-Bank Zeitz -alt-
            "80063718",    //Volks- und Raiffeisenbank Eisleben
            "80080000",    //Commerzbank vormals Dresdner Bank
            "80093574",    //Volksbank Dessau-Anhalt
            "80093784",    //Volksbank Halle, Saale
            "80550101",    //Sparkasse Wittenberg
            "80550200",    //Kreissparkasse Anhalt-Zerbst -alt-
            "81000000",    //Bundesbank
            "81010111",    //SEB
            "81020500",    //Bank für Sozialwirtschaft
            "81040000",    //Commerzbank
            "81050555",    //Kreissparkasse Stendal
            "81052000",    //Harzsparkasse
            "81053272",    //Stadtsparkasse Magdeburg
            "81054000",    //Sparkasse Jerichower Land
            "81055000",    //Kreissparkasse Börde
            "81055555",    //Sparkasse Altmark West
            "81063028",    //Raiffeisenbank Kalbe-Bismark
            "81063238",    //Volksbank Jerichower Land
            "81068106",    //Bank für Kirche und Diakonie - KD-Bank Gf Sonder-BLZ
            "81069052",    //Volksbank Börde-Bernburg
            "81070000",    //Deutsche Bank
            "81070024",    //Deutsche Bank Privat und Geschäftskunden
            "81080000",    //Commerzbank vormals Dresdner Bank
            "81093034",    //Volksbank
            "81093044",    //Volksbank Osterburg-Lüchow-Dannenberg -alt-
            "81093054",    //Volksbank Stendal
            "81093274",    //Volksbank Magdeburg
            "82000000",    //Bundesbank
            "82010111",    //SEB
            "82020086",    //UniCredit Bank - HypoVereinsbank
            "82020087",    //UniCredit Bank - HypoVereinsbank
            "82020088",    //UniCredit Bank - HypoVereinsbank
            "82040000",    //Commerzbank
            "82040085",    //Commerzbank, Gf Web-K
            "82050000",    //Landesbank Hessen-Thür Girozentrale Erfurt
            "82051000",    //Sparkasse Mittelthüringen
            "82052020",    //Kreissparkasse Gotha
            "82054052",    //Kreissparkasse Nordhausen
            "82055000",    //Kyffhäusersparkasse
            "82056060",    //Sparkasse Unstrut-Hainich
            "82057070",    //Kreissparkasse Eichsfeld
            "82060197",    //Pax-Bank
            "82064038",    //VR Bank Westthüringen
            "82064088",    //Volksbank und Raiffeisenbank
            "82064168",    //Raiffeisenbank Gotha
            "82064188",    //VR Bank Weimar
            "82064228",    //Erfurter Bank
            "82070000",    //Deutsche Bank
            "82070024",    //Deutsche Bank Privat und Geschäftskunden
            "82080000",    //Commerzbank vormals Dresdner Bank
            "82094004",    //Volksbank Heiligenstadt
            "82094054",    //Nordthüringer Volksbank
            "83020086",    //UniCredit Bank - HypoVereinsbank
            "83020087",    //UniCredit Bank - HypoVereinsbank
            "83020088",    //UniCredit Bank - HypoVereinsbank
            "83040000",    //Commerzbank
            "83050000",    //Sparkasse Gera-Greiz
            "83050200",    //Sparkasse Altenburger Land
            "83050303",    //Kreissparkasse Saalfeld-Rudolstadt
            "83050505",    //Kreissparkasse Saale-Orla
            "83053030",    //Sparkasse Jena-Saale-Holzland
            "83064488",    //Raiffeisen-Volksbank Hermsdorfer Kreuz
            "83064568",    //Geraer Bank -alt-
            "83065408",    //VR-Bank Altenburger Land / Deutsche Skatbank
            "83080000",    //Commerzbank vormals Dresdner Bank
            "83094444",    //Raiffeisen-Volksbank Saale-Orla
            "83094454",    //Volksbank Gera-Jena-Rudolstadt
            "83094494",    //Volksbank Eisenberg
            "83094495",    //EthikBank, Zndl der Volksbank Eisenberg
            "84020087",    //UniCredit Bank - HypoVereinsbank
            "84030111",    //Bankhaus Max Flessa
            "84040000",    //Commerzbank
            "84050000",    //Rhön-Rennsteig-Sparkasse
            "84051010",    //Sparkasse Arnstadt-Ilmenau
            "84054040",    //Kreissparkasse Hildburghausen
            "84054722",    //Sparkasse Sonneberg
            "84055050",    //Wartburg-Sparkasse
            "84064798",    //Genobank Rhön-Grabfeld
            "84069065",    //Raiffeisenbank Schleusingen -alt-
            "84080000",    //Commerzbank vormals Dresdner Bank
            "84094754",    //VR-Bank Bad Salzungen Schmalkalden
            "84094814",    //VR Bank Südthüringen
            "85000000",    //Bundesbank eh Dresden
            "85010500",    //Sächsische Aufbaubank -Förderbank-
            "85020086",    //UniCredit Bank - HypoVereinsbank
            "85020500",    //Bank für Sozialwirtschaft
            "85040000",    //Commerzbank
            "85040060",    //Commerzbank CC
            "85040061",    //Commerzbank CC
            "85050100",    //Sparkasse Oberlausitz-Niederschlesien
            "85050200",    //Kreissparkasse Riesa-Großenhain -alt-
            "85050300",    //Ostsächsische Sparkasse Dresden
            "85055000",    //Sparkasse Meißen
            "85060000",    //Volksbank Pirna
            "85065028",    //Raiffeisenbank Neustadt, Sachs -alt-
            "85080000",    //Commerzbank vormals Dresdner Bank
            "85080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "85080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 2
            "85080200",    //Commerzbank vormals Dresdner Bank
            "85089270",    //Commerzbank vormals Dresdner Bank ITGK
            "85090000",    //Dresdner Volksbank Raiffeisenbank
            "85094984",    //Volksbank Riesa
            "85095004",    //Volksbank Raiffeisenbank Meißen Großenhain
            "85550000",    //Kreissparkasse Bautzen
            "85590000",    //Volksbank Bautzen
            "85590100",    //Volksbank Löbau-Zittau
            "85591000",    //Volksbank Raiffeisenbank Niederschlesien
            "86000000",    //Bundesbank
            "86010090",    //Postbank
            "86010111",    //SEB
            "86010424",    //Aareal Bank
            "86020086",    //UniCredit Bank - HypoVereinsbank
            "86020500",    //Bank für Sozialwirtschaft
            "86033300",    //Santander Consumer Bank
            "86040000",    //Commerzbank
            "86040060",    //Commerzbank CC
            "86040061",    //Commerzbank CC
            "86050000",    //ZV Landesbank Baden-Württemberg
            "86050200",    //Sparkasse Muldental
            "86050600",    //Kreissparkasse Torgau-Oschatz -alt-
            "86055002",    //Sparkasse Delitzsch-Eilenburg -alt-
            "86055462",    //Kreissparkasse Döbeln
            "86055592",    //Stadt- und Kreissparkasse Leipzig
            "86065448",    //VR Bank Leipziger Land
            "86065468",    //VR-Bank Mittelsachsen
            "86065483",    //Raiffeisenbank Grimma
            "86069070",    //Raiffeisenbank
            "86070000",    //Deutsche Bank
            "86070024",    //Deutsche Bank Privat und Geschäftskunden
            "86080000",    //Commerzbank vormals Dresdner Bank
            "86080055",    //Commerzbank vormals Dresdner Bank Zw 55
            "86080057",    //Commerzbank vormals Dresdner Bank Gf ZW 57
            "86080085",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 1
            "86080086",    //Commerzbank vormals Dresdner Bank, PCC DCC-ITGK 2
            "86089280",    //Commerzbank vormals Dresdner Bank ITGK
            "86095484",    //Volks- und Raiffeisenbank Muldental
            "86095554",    //Volksbank Delitzsch
            "86095604",    //Leipziger Volksbank
            "87000000",    //Bundesbank
            "87020086",    //UniCredit Bank - HypoVereinsbank
            "87020087",    //UniCredit Bank - HypoVereinsbank
            "87020088",    //UniCredit Bank - HypoVereinsbank
            "87040000",    //Commerzbank
            "87050000",    //Sparkasse Chemnitz
            "87051000",    //Sparkasse Mittelsachsen -alt-
            "87052000",    //Sparkasse Mittelsachsen
            "87053000",    //Sparkasse Mittleres Erzgebirge -alt-
            "87054000",    //Erzgebirgssparkasse
            "87055000",    //Sparkasse Zwickau
            "87056000",    //Kreissparkasse Aue-Schwarzenberg -alt-
            "87058000",    //Sparkasse Vogtland
            "87069075",    //Volksbank Mittleres Erzgebirge
            "87069077",    //Vereinigte Raiffeisenbank Burgstädt
            "87070000",    //Deutsche Bank
            "87070024",    //Deutsche Bank Privat und Geschäftskunden
            "87080000",    //Commerzbank vormals Dresdner Bank
            "87095824",    //Volksbank Vogtland
            "87095899",    //Volksbank Vogtland GAA
            "87095934",    //Volksbank Zwickau
            "87095974",    //Volksbank-Raiffeisenbank Glauchau
            "87096034",    //Volksbank Erzgebirge -alt-
            "87096124",    //Volksbank Mittweida
            "87096214",    //Volksbank Chemnitz
    };
}
