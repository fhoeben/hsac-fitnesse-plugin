package nl.hsac.fitnesse.util.iban;

public class ATIbanGenerator extends IbanGenerator {

    /**
     *
     * @param bankCode
     * @return random Austrian IBAN
     */
    public String generateIban(String bankCode) {

        String countryCode = "AT";
        int accountLength = 11;
        String accountCodeType = "N";
        int bankCodeLength = 5;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, bankCodeList, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;
    }

    /**
     * Array of Austrian Bank codes
     */

    public String[] bankCodeList = {
            "52300",    //Addiko Bank AG
            "20320",    //Allgemeine Sparkasse Oberösterreich BankAG
            "20315",    //Allgemeine Sparkasse Oberösterreich BankAG
            "19330",    //Allianz Investmentbank AG
            "36791",    //Alpenbank AG
            "52000",    //Austrian Anadi Bank AG
            "19370",    //Autobank AG
            "19970",    //Banco do Brasil AG
            "18130",    //Bank für Ärzte und Freie Berufe AG
            "16000",    //Bank für Tirol und Vorarlberg AG
            "16300",    //Bank für Tirol und Vorarlberg AG
            "16310",    //Bank für Tirol und Vorarlberg AG
            "16320",    //Bank für Tirol und Vorarlberg AG
            "16330",    //Bank für Tirol und Vorarlberg AG
            "16340",    //Bank für Tirol und Vorarlberg AG
            "16350",    //Bank für Tirol und Vorarlberg AG
            "16360",    //Bank für Tirol und Vorarlberg AG
            "16370",    //Bank für Tirol und Vorarlberg AG
            "16380",    //Bank für Tirol und Vorarlberg AG
            "16390",    //Bank für Tirol und Vorarlberg AG
            "16400",    //Bank für Tirol und Vorarlberg AG
            "16410",    //Bank für Tirol und Vorarlberg AG
            "16420",    //Bank für Tirol und Vorarlberg AG
            "16430",    //Bank für Tirol und Vorarlberg AG
            "16440",    //Bank für Tirol und Vorarlberg AG
            "16450",    //Bank für Tirol und Vorarlberg AG
            "16460",    //Bank für Tirol und Vorarlberg AG
            "19140",    //Bank Gutmann AG
            "19540",    //Bank of China (Hungary) Close Ltd. Vienna Branch
            "19220",    //Bank Winter & Co. AG
            "19530",    //Bankhaus Carl Spängler & Co. AG
            "19380",    //Bankhaus Denzel AG
            "19520",    //Bankhaus Krentschker & Co. AG
            "19190",    //Bankhaus Schelhammer & Schattera AG
            "24012",    //Bausparkasse der österreichischen Sparkassen AG
            "19950",    //Bausparkasse Wüstenrot AG
            "14000",    //BAWAG P.S.K. Bank für Arbeit und Wirtschaft und Österreichische Postsparkasse AG
            "14900",    //BAWAG P.S.K. Bank für Arbeit und Wirtschaft und Österreichische Postsparkasse AG
            "18190",    //BAWAG P.S.K. Bank für Arbeit und Wirtschaft und Österreichische Postsparkasse AG
            "60000",    //BAWAG P.S.K. Bank für Arbeit und Wirtschaft und Österreichische Postsparkasse AG
            "19750",    //BAWAG P.S.K. Wohnbaubank AG
            "19480",    //biw Bank für Investments und Wertpapiere AG Zweigniederlassung Österreich
            "17000",    //BKS Bank AG
            "17100",    //BKS Bank AG
            "17200",    //BKS Bank AG
            "17300",    //BKS Bank AG
            "17400",    //BKS Bank AG
            "17500",    //BKS Bank AG
            "19390",    //BMW Austria Bank GmbH
            "18100",    //BNP Paribas Fortis SA/NV Niederlassung Österreich
            "19120",    //Brüll Kallmus Bank AG
            "19600",    //CAPITAL BANK - GRAWE GRUPPE AG
            "76040",    //card complete Service Bank AG
            "18140",    //Citibank Europe plc, Austria Branch
            "19675",    //Commerzbank AG Niederlassung Wien
            "19620",    //Commerzialbank Mattersburg im Burgenland AG
            "19470",    //Crédit Suisse (Luxembourg) S.A. Zweigniederlassung Österreich
            "19650",    //DenizBank AG
            "19100",    //Deutsche Bank AG Filiale Wien
            "19999",    //Deutsche Bank Österreich AG
            "20112",    //Die Zweite Wiener Vereins-Sparcasse
            "40730",    //DolomitenBank Osttirol-Westkärnten eG
            "43380",    //DolomitenBank Osttirol-Westkärnten eG
            "44400",    //DolomitenBank Osttirol-Westkärnten eG
            "20602",    //Dornbirner Sparkasse Bank AG
            "14200",    //easybank AG
            "20111",    //Erste Bank der oesterreichischen Sparkassen AG
            "18700",    //Erste Bank der oesterreichischen Sparkassen AG
            "20100",    //Erste Group Bank AG
            "75800",    //Erste Group Bank AG
            "19340",    //European American Investment Bank AG
            "19915",    //FIL Fondsbank GmbH Zweigniederlassung Wien
            "19965",    //Ford Bank Austria, Zweigniederlassung der FCE BANK PLC
            "18400",    //Generali Bank AG
            "19250",    //Hellobank BNP Paribas Austria AG
            "53100",    //HYPO NOE Gruppe Bank AG
            "53000",    //HYPO NOE Landesbank AG
            "57000",    //HYPO TIROL BANK AG
            "57100",    //HYPO TIROL BANK AG
            "51000",    //HYPO-BANK BURGENLAND AG
            "40074",    //immigon portfolioabbau ag
            "47050",    //IMMO-BANK AG
            "19210",    //ING-DiBa Austria Niederlassung der ING-DiBa AG
            "19360",    //ING-DiBa Austria Niederlassung der ING-DiBa AG
            "18170",    //KA Finanz AG
            "20706",    //Kärntner Sparkasse AG
            "19150",    //Kathrein Privatbank AG
            "19660",    //Kommunalkredit Austria AG
            "20228",    //KREMSER BANK UND SPARKASSEN AG
            "56000",    //Landes-Hypothekenbank Steiermark AG
            "73800",    //LEASFINANZ Bank GmbH
            "19460",    //LGT Bank AG, Zweigniederlassung Österreich
            "19450",    //Liechtensteinische Landesbank (Österreich) AG
            "20507",    //Lienzer Sparkasse AG
            "42110",    //Marchfelder Bank eG
            "19240",    //MEINL BANK AG
            "19410",    //Mercedes-Benz Bank GmbH
            "19490",    //Mizuho Bank Europe N.V. Vienna Branch
            "19400",    //MUFG Bank (Europe) N.V. Vienna Branch
            "31500",    //NOTARTREUHANDBANK AG
            "15000",    //Oberbank AG
            "15001",    //Oberbank AG
            "15002",    //Oberbank AG
            "15003",    //Oberbank AG
            "15004",    //Oberbank AG
            "15005",    //Oberbank AG
            "15006",    //Oberbank AG
            "15007",    //Oberbank AG
            "15008",    //Oberbank AG
            "15009",    //Oberbank AG
            "15010",    //Oberbank AG
            "15011",    //Oberbank AG
            "15012",    //Oberbank AG
            "15013",    //Oberbank AG
            "15021",    //Oberbank AG
            "15022",    //Oberbank AG
            "15023",    //Oberbank AG
            "15024",    //Oberbank AG
            "15025",    //Oberbank AG
            "15030",    //Oberbank AG
            "15031",    //Oberbank AG
            "15040",    //Oberbank AG
            "15041",    //Oberbank AG
            "15042",    //Oberbank AG
            "15060",    //Oberbank AG
            "15061",    //Oberbank AG
            "15062",    //Oberbank AG
            "15080",    //Oberbank AG
            "15081",    //Oberbank AG
            "15090",    //Oberbank AG
            "15091",    //Oberbank AG
            "15092",    //Oberbank AG
            "15093",    //Oberbank AG
            "15094",    //Oberbank AG
            "15095",    //Oberbank AG
            "15096",    //Oberbank AG
            "15097",    //Oberbank AG
            "15110",    //Oberbank AG
            "15120",    //Oberbank AG
            "15121",    //Oberbank AG
            "15122",    //Oberbank AG
            "15123",    //Oberbank AG
            "15130",    //Oberbank AG
            "15131",    //Oberbank AG
            "15132",    //Oberbank AG
            "15133",    //Oberbank AG
            "15134",    //Oberbank AG
            "15135",    //Oberbank AG
            "15150",    //Oberbank AG
            "15151",    //Oberbank AG
            "54000",    //Oberösterreichische Landesbank AG
            "10800",    //OeKB CSD GmbH
            "10000",    //Oesterreichische Kontrollbank AG
            "100",    //Oesterreichische Nationalbank
            "44220",    //Österreichische Apothekerbank eG
            "73700",    //Österreichische Hotel- und Tourismusbank Ges. m.b.H.
            "19170",    //PARTNER BANK AG
            "18120",    //paybox Bank AG
            "76000",    //Porsche Bank AG
            "39100",    //Posojilnica Bank eGen
            "39101",    //Posojilnica Bank eGen
            "39102",    //Posojilnica Bank eGen
            "39104",    //Posojilnica Bank eGen
            "39109",    //Posojilnica Bank eGen
            "39116",    //Posojilnica Bank eGen
            "39117",    //Posojilnica Bank eGen
            "39130",    //Posojilnica Bank eGen
            "75910",    //PSA Bank Österreich, Niederlassung der PSA Bank Deutschland GmbH
            "31000",    //Raiffeisen Bank International AG
            "30000",    //Raiffeisen Bank International AG
            "52200",    //Raiffeisen Bank International AG
            "39412",    //Raiffeisen Bank Lurnfeld-Reißeck reg.Gen.m.b.H.
            "39496",    //Raiffeisen Bank Villach reg.Gen.m.b.H.
            "39483",    //Raiffeisen Bank Villach reg.Gen.m.b.H.
            "31303",    //Raiffeisen Bausparkasse Ges. m.b.H.
            "36358",    //Raiffeisen Bezirksbank Kufstein eGen
            "36216",    //Raiffeisen Bezirksbank Kufstein eGen
            "36236",    //Raiffeisen Bezirksbank Kufstein eGen
            "19930",    //Raiffeisen Centrobank AG
            "36362",    //Raiffeisen Regionalbank Hall in Tirol eGen
            "32250",    //Raiffeisen Regionalbank Mödling eGen
            "32633",    //Raiffeisen Regionalbank Mödling eGen
            "36322",    //Raiffeisen Regionalbank Schwaz eGen
            "36265",    //Raiffeisen Regionalbank Schwaz eGen
            "36200",    //Raiffeisenbank Absam eGen
            "35001",    //Raiffeisenbank Abtenau-Rußbach reg.Gen.m.b.H.
            "35101",    //Raiffeisenbank Abtenau-Rußbach reg.Gen.m.b.H.
            "36201",    //Raiffeisenbank Achenkirch und Umgebung eGen
            "38001",    //Raiffeisenbank Admont eGen
            "38346",    //Raiffeisenbank Aichfeld eGen
            "38076",    //Raiffeisenbank Aichfeld eGen
            "37401",    //Raiffeisenbank Alberschwende reg.Gen.m.b.H.
            "36203",    //Raiffeisenbank Alpbach eGen
            "35004",    //Raiffeisenbank Altenmarkt-Flachau-Eben eGen
            "35104",    //Raiffeisenbank Altenmarkt-Flachau-Eben eGen
            "35204",    //Raiffeisenbank Altenmarkt-Flachau-Eben eGen
            "35404",    //Raiffeisenbank Altenmarkt-Flachau-Eben eGen
            "39255",    //Raiffeisenbank Althofen - Guttaring, reg.Gen.m.b.H.
            "37431",    //Raiffeisenbank am Bodensee reg.Gen.m.b.H.
            "37482",    //Raiffeisenbank am Hofsteig reg.Gen.m.b.H.
            "37429",    //Raiffeisenbank amKumma eGen
            "37402",    //Raiffeisenbank amKumma eGen
            "35005",    //Raiffeisenbank Anif-Niederalm eGen
            "35105",    //Raiffeisenbank Anif-Niederalm eGen
            "35006",    //Raiffeisenbank Annaberg-Lungötz reg.Gen.m.b.H.
            "35007",    //Raiffeisenbank Anthering - Elixhausen eGen
            "35014",    //Raiffeisenbank Anthering - Elixhausen eGen
            "33004",    //Raiffeisenbank Apetlon eGen
            "39257",    //Raiffeisenbank Arnoldstein, reg.Gen.m.b.H.
            "36207",    //Raiffeisenbank Arzl im Pitztal und Imsterberg reg.Gen.m.b.H.
            "34016",    //Raiffeisenbank Aspach-Wildenau eGen
            "34523",    //Raiffeisenbank Attergau eGen
            "34608",    //Raiffeisenbank Attersee-Nord eGen
            "34363",    //Raiffeisenbank Attersee-Süd eGen
            "37405",    //Raiffeisenbank Au reg.Gen.m.b.H.
            "32039",    //Raiffeisenbank Auersthal-Bockfließ-Groß Schweinbarth eGen
            "38312",    //Raiffeisenbank Bad Radkersburg-Klöch eGen
            "34750",    //Raiffeisenbank Bad Wimsbach-Neydharting eGen
            "35008",    //Raiffeisenbank Bergheim eGen
            "35108",    //Raiffeisenbank Bergheim eGen
            "32227",    //Raiffeisenbank Bernhardsthal - Großkrut - Altlichtenwarth eGen
            "37406",    //Raiffeisenbank Bezau-Mellau-Bizau reg.Gen.m.b.H.
            "35010",    //RAIFFEISENBANK BISCHOFSHOFEN eGen
            "35110",    //RAIFFEISENBANK BISCHOFSHOFEN eGen
            "35310",    //RAIFFEISENBANK BISCHOFSHOFEN eGen
            "39272",    //Raiffeisenbank Bleiburg reg.Gen.m.b.H.
            "37468",    //Raiffeisenbank Bludenz-Montafon eGen
            "37410",    //Raiffeisenbank Bludenz-Montafon eGen
            "35011",    //Raiffeisenbank Bramberg eGen
            "35111",    //Raiffeisenbank Bramberg eGen
            "36213",    //Raiffeisenbank Brandenberg eGen
            "38026",    //Raiffeisenbank Breitenau eGen
            "36215",    //Raiffeisenbank Brixen im Thale eGen
            "32073",    //Raiffeisenbank Bruck-Carnuntum eGen
            "35012",    //Raiffeisenbank Bruck-Fusch-Kaprun eGen
            "35112",    //Raiffeisenbank Bruck-Fusch-Kaprun eGen
            "35212",    //Raiffeisenbank Bruck-Fusch-Kaprun eGen
            "35312",    //Raiffeisenbank Bruck-Fusch-Kaprun eGen
            "39271",    //Raiffeisenbank Brückl-Eberstein-Klein St. Paul-Waisenberg, reg.Gen.m.b.H.
            "36272",    //Raiffeisenbank Buch, Gallzein und Strass reg.Gen.m.b.H.
            "36367",    //Raiffeisenbank Defereggental eGen
            "38043",    //Raiffeisenbank Deutschlandsberg eGen
            "34075",    //Raiffeisenbank Donau-Ameisberg eGen
            "33014",    //Raiffeisenbank Draßmarkt-Kobersdorf-St. Martin eGen
            "39442",    //Raiffeisenbank Drautal reg.Gen.m.b.H.
            "33038",    //Raiffeisenbank Dreiländereck Bgld-Nord eGen
            "33063",    //Raiffeisenbank Dreiländereck Bgld-Nord eGen
            "33114",    //Raiffeisenbank Dreiländereck Bgld-Nord eGen
            "36218",    //Raiffeisenbank Eben-Pertisau eGen
            "39288",    //Raiffeisenbank Eberndorf reg.Gen.m.b.H.
            "34081",    //Raiffeisenbank Eberschwang eGen
            "34083",    //Raiffeisenbank Edt-Lambach eGen
            "32123",    //Raiffeisenbank Eggenburg eGen
            "36219",    //Raiffeisenbank Ehrwald-Lermoos-Biberwier eGen
            "34080",    //Raiffeisenbank Ennstal eGen
            "36223",    //Raiffeisenbank Erl eGen
            "35015",    //Raiffeisenbank Eugendorf-Plainfeld eGen
            "35115",    //Raiffeisenbank Eugendorf-Plainfeld eGen
            "35215",    //Raiffeisenbank Eugendorf-Plainfeld eGen
            "35016",    //Raiffeisenbank Faistenau-Hintersee eGen
            "38497",    //Raiffeisenbank Feldbach-Gnas-Bad Gleichenberg eGen
            "38104",    //Raiffeisenbank Feldbach-Gnas-Bad Gleichenberg eGen
            "37422",    //Raiffeisenbank Feldkirch, reg.Gen.m.b.H.
            "34100",    //Raiffeisenbank Feldkirchen-Goldwörth eGen
            "39383",    //Raiffeisenbank Finkenstein - Faaker See, reg.Gen.m.b.H.
            "37424",    //RAIFFEISENBANK FRASTANZ-SATTEINS reg.Gen.m.b.H.
            "33116",    //Raiffeisenbank Frauenkirchen-Podersdorf am See eGen
            "33085",    //Raiffeisenbank Freistadt Rust eGen
            "39501",    //Raiffeisenbank Friesach-Metnitztal, reg.Gen.m.b.H.
            "36230",    //Raiffeisenbank Fulpmes-Telfes im Stubai eGen
            "39305",    //Raiffeisenbank Fürnitz, reg.Gen.m.b.H.
            "38077",    //Raiffeisenbank Fürstenfeld eGen
            "38094",    //Raiffeisenbank Gamlitz eGen
            "34113",    //Raiffeisenbank Gampern eGen
            "35026",    //Raiffeisenbank Gastein eGen
            "35126",    //Raiffeisenbank Gastein eGen
            "35226",    //Raiffeisenbank Gastein eGen
            "34118",    //Raiffeisenbank Geretsberg eGen
            "38102",    //Raiffeisenbank Gleinstätten-Leutschach eGen
            "38262",    //Raiffeisenbank Gleinstätten-Leutschach eGen
            "36232",    //RaiffeisenBank Going eGen
            "35017",    //Raiffeisenbank Golling-Scheffau-Kellau reg.Gen.m.b.H.
            "39320",    //Raiffeisenbank Grafenstein-Magdalensberg und Umgebung, reg.Gen.m.b.H.
            "34135",    //Raiffeisenbank Gramastetten-Herzogsdorf eGen
            "38111",    //Raiffeisenbank Gratkorn eGen
            "38112",    //Raiffeisenbank Gratwein eGen
            "38377",    //Raiffeisenbank Graz-Andritz eGen
            "38223",    //Raiffeisenbank Graz-Mariatrost eGen
            "38367",    //Raiffeisenbank Graz-St. Peter eGen
            "38439",    //Raiffeisenbank Graz-Straßgang eGen
            "34068",    //Raiffeisenbank Grein eGen
            "38113",    //Raiffeisenbank Gröbming eGen
            "35018",    //Raiffeisenbank Grödig eGen
            "35118",    //Raiffeisenbank Grödig eGen
            "38118",    //Raiffeisenbank Groß St. Florian-Wettmannstätten eGen
            "35019",    //Raiffeisenbank Großarl-Hüttschlag eGen
            "35119",    //Raiffeisenbank Großarl-Hüttschlag eGen
            "35020",    //Raiffeisenbank Großgmain eGen
            "34126",    //Raiffeisenbank Großraming eGen
            "32589",    //Raiffeisenbank Gross Gerungs eGen
            "38122",    //Raiffeisenbank Großwilfersdorf eGen
            "34127",    //Raiffeisenbank Grünau - St. Konrad - Scharnstein eGen
            "34129",    //Raiffeisenbank Gunskirchen eGen
            "34430",    //Raiffeisenbank Gunskirchen eGen
            "39511",    //Raiffeisenbank Gurktal, reg.Gen.m.b.H.
            "38128",    //Raiffeisenbank Halbenrain-Tieschen eGen
            "35022",    //Raiffeisenbank Hallein eGen
            "35122",    //Raiffeisenbank Hallein eGen
            "35322",    //Raiffeisenbank Hallein eGen
            "35422",    //Raiffeisenbank Hallein eGen
            "35522",    //Raiffeisenbank Hallein eGen
            "34155",    //Raiffeisenbank Handenberg - St. Georgen a. F. eGen
            "38403",    //Raiffeisenbank Hartberg eGen
            "38133",    //Raiffeisenbank Hausmannstätten eGen
            "33090",    //Raiffeisenbank Heideboden eGen
            "33028",    //Raiffeisenbank Heideboden eGen
            "38170",    //Raiffeisenbank Heiligenkreuz-Kirchbach eGen
            "34160",    //Raiffeisenbank Helfenberg - St. Stefan a.W. eGen
            "34161",    //Raiffeisenbank Hellmonsödt eGen
            "35024",    //Raiffeisenbank Henndorf am Wallersee eGen
            "39543",    //Raiffeisenbank Hermagor, reg.Gen.m.b.H.
            "32769",    //Raiffeisenbank Herzogenburg-Kapelln eGen
            "32356",    //Raiffeisenbank Herzogenburg-Kapelln eGen
            "34165",    //Raiffeisenbank Hinterstoder und Vorderstoder eGen
            "36241",    //Raiffeisenbank Hippach und Umgebung eGen
            "38138",    //Raiffeisenbank Hitzendorf-Rein eGen
            "38333",    //Raiffeisenbank Hitzendorf-Rein eGen
            "35003",    //Raiffeisenbank Hochkönig eGen
            "35013",    //Raiffeisenbank Hochkönig eGen
            "35025",    //Raiffeisenbank Hof-Koppl-Ebenau eGen
            "35125",    //Raiffeisenbank Hof-Koppl-Ebenau eGen
            "35225",    //Raiffeisenbank Hof-Koppl-Ebenau eGen
            "37438",    //Raiffeisenbank Hohenems reg.Gen.m.b.H.
            "32322",    //Raiffeisenbank Hollabrunn eGen
            "32198",    //Raiffeisenbank Hollabrunn eGen
            "36245",    //Raiffeisenbank Hopfgarten im Brixental eGen
            "33031",    //Raiffeisenbank Horitschon und Umgebung eGen
            "34170",    //Raiffeisenbank Hörsching-Thening eGen
            "35027",    //Raiffeisenbank Hüttau-St. Martin-Niedernfritz reg.Gen.m.b.H.
            "35127",    //Raiffeisenbank Hüttau-St. Martin-Niedernfritz reg.Gen.m.b.H.
            "39340",    //Raiffeisenbank Hüttenberg - Wieting, reg.Gen.m.b.H.
            "33033",    //Raiffeisenbank Illmitz eGen
            "38151",    //Raiffeisenbank Ilz-Großsteinbach-Riegersburg eGen
            "38120",    //Raiffeisenbank Ilz-Großsteinbach-Riegersburg eGen
            "38326",    //Raiffeisenbank Ilz-Großsteinbach-Riegersburg eGen
            "32033",    //Raiffeisenbank im Mostviertel Aschbach eGen
            "37420",    //Raiffeisenbank Im Rheintal eGen
            "37453",    //Raiffeisenbank Im Rheintal eGen
            "36229",    //Raiffeisenbank im Vorderen Zillertal, Fügen, Fügenberg, Kaltenbach, Ried und Uderns eGen
            "32501",    //Raiffeisenbank im Weinviertel eGen
            "34545",    //Raiffeisenbank Inneres Salzkammergut eGen
            "34200",    //Raiffeisenbank Innkreis Mitte eGen
            "36249",    //Raiffeisenbank Jenbach - Wiesing eGen
            "36260",    //Raiffeisenbank Kematen eGen
            "34214",    //Raiffeisenbank Kematen-Neuhofen eGen
            "39355",    //Raiffeisenbank Keutschach-Maria Wörth, e. Gen. m.b.H.
            "36262",    //Raiffeisenbank Kirchdorf Tirol reg.Gen.m.b.H.
            "36263",    //Raiffeisenbank Kitzbühel - St. Johann eGen
            "36254",    //Raiffeisenbank Kitzbühel - St. Johann eGen
            "34226",    //Raiffeisenbank Kleinmünchen/Linz eGen
            "32367",    //Raiffeisenbank Klosterneuburg eGen
            "34231",    //Raiffeisenbank Kollerschlag eGen
            "33041",    //Raiffeisenbank Königsdorf eGen
            "32395",    //Raiffeisenbank Korneuburg eGen
            "36264",    //Raiffeisenbank Kössen-Schwendt eGen
            "35021",    //Raiffeisenbank Köstendorf-Neumarkt-Schleedorf reg.Gen.m.b.H.
            "35121",    //Raiffeisenbank Köstendorf-Neumarkt-Schleedorf reg.Gen.m.b.H.
            "35221",    //Raiffeisenbank Köstendorf-Neumarkt-Schleedorf reg.Gen.m.b.H.
            "39364",    //Raiffeisenbank Kötschach - Mauthen, reg.Gen.m.b.H.
            "32397",    //Raiffeisenbank Krems eGen
            "32438",    //Raiffeisenbank Kreuzenstein eGen
            "32731",    //Raiffeisenbank Kreuzenstein eGen
            "35028",    //Raiffeisenbank Krimml reg.Gen.m.b.H.
            "36267",    //Raiffeisenbank Kundl eGen
            "32413",    //Raiffeisenbank Laa/Thaya eGen
            "35030",    //Raiffeisenbank Lamprechtshausen-Bürmoos eGen
            "35130",    //Raiffeisenbank Lamprechtshausen-Bürmoos eGen
            "39381",    //Raiffeisenbank Landskron - Gegendtal, reg.Gen.m.b.H.
            "36268",    //Raiffeisenbank Längenfeld eGen
            "32426",    //Raiffeisenbank Langenlois eGen
            "37445",    //Raiffeisenbank Langen-Thal reg.Gen.m.b.H.
            "36269",    //Raiffeisenbank Langkampfen eGen
            "39384",    //Raiffeisenbank Launsdorf, reg.Gen.m.b.H.
            "39292",    //Raiffeisenbank Lavamünd, reg.Gen.m.b.H.
            "37449",    //Raiffeisenbank Lech/Arlberg, reg.Gen.m.b.H.
            "37439",    //RAIFFEISENBANK LEIBLACHTAL reg.Gen.m.b.H.
            "38206",    //Raiffeisenbank Leibnitz eGen
            "38460",    //Raiffeisenbank Leoben-Bruck eGen
            "35031",    //Raiffeisenbank Leogang eGen
            "34276",    //Raiffeisenbank Leonding eGen
            "38210",    //Raiffeisenbank Lieboch-Stainz eGen
            "39464",    //Raiffeisenbank Liesertal, reg.Gen.m.b.H.
            "38227",    //Raiffeisenbank Liesingtal eGen
            "38215",    //Raiffeisenbank Liezen eGen
            "38211",    //Raiffeisenbank Ligist-St.Johann eGen
            "38487",    //Raiffeisenbank Lipizzanerheimat eGen
            "38053",    //Raiffeisenbank Lipizzanerheimat eGen
            "34290",    //Raiffeisenbank Lochen am See eGen
            "34284",    //Raiffeisenbank Lohnsburg eGen
            "33048",    //Raiffeisenbank Lutzmannsburg - Frankenau eGen
            "35035",    //Raiffeisenbank Maishofen eGen
            "39400",    //Raiffeisenbank Maltatal, reg.Gen.m.b.H.
            "39404",    //Raiffeisenbank Maria Saal reg.Gen.m.b.H.
            "34312",    //Raiffeisenbank Maria Schmolln-St. Johann eGen
            "35036",    //Raiffeisenbank Mariapfarr eGen
            "38129",    //Raiffeisenbank Mariazellerland eGen
            "38131",    //Raiffeisenbank Markt Hartmannsdorf eGen
            "35042",    //Raiffeisenbank Markt Neukirchen eGen
            "36273",    //Raiffeisenbank Matrei am Brenner und Umgebung eGen
            "36378",    //Raiffeisenbank Matrei in Osttirol, Virgen-Prägraten-Kals am Großglockner reg.Gen.m.b.H.
            "34303",    //Raiffeisenbank Mattigtal eGen
            "35037",    //Raiffeisenbank Mauterndorf-Tweng-Obertauern eGen
            "36274",    //Raiffeisenbank Mayrhofen und Umgebung eGen
            "34313",    //Raiffeisenbank Meggenhofen-Kematen eGen
            "39407",    //Raiffeisenbank Metnitz und Umgebung reg.Gen.m.b.H.
            "35038",    //Raiffeisenbank Michaelbeuern eGen
            "32497",    //Raiffeisenbank Michelhausen eGen
            "39479",    //Raiffeisenbank Millstättersee eG
            "37423",    //Raiffeisenbank Mittelbregenzerwald reg.Gen.m.b.H.
            "33010",    //Raiffeisenbank Mittelburgenland Ost eGen
            "35039",    //Raiffeisenbank Mittersill-Hollersbach-Stuhlfelden reg.Gen.m.b.H.
            "35139",    //Raiffeisenbank Mittersill-Hollersbach-Stuhlfelden reg.Gen.m.b.H.
            "35239",    //Raiffeisenbank Mittersill-Hollersbach-Stuhlfelden reg.Gen.m.b.H.
            "35339",    //Raiffeisenbank Mittersill-Hollersbach-Stuhlfelden reg.Gen.m.b.H.
            "39481",    //Raiffeisenbank Mittleres Lavanttal eGen
            "39465",    //Raiffeisenbank Mittleres Lavanttal eGen
            "39436",    //Raiffeisenbank Mittleres Mölltal, reg.Gen.m.b.H.
            "32939",    //Raiffeisenbank Mittleres Mostviertel eGen
            "32651",    //Raiffeisenbank Mittleres Mostviertel eGen
            "38075",    //Raiffeisenbank Mittleres Raabtal eGen
            "38171",    //Raiffeisenbank Mittleres Raabtal eGen
            "34383",    //Raiffeisenbank Mittleres Rodltal eGen
            "33054",    //Raiffeisenbank Mönchhof eGen
            "34322",    //Raiffeisenbank Mondseeland eGen
            "39411",    //Raiffeisenbank Moosburg-Tigring, reg.Gen.m.b.H.
            "38235",    //Raiffeisenbank Mooskirchen-Söding eGen
            "33055",    //Raiffeisenbank Mörbisch am See eGen
            "34330",    //Raiffeisenbank Mühlviertler Alm eGen
            "36279",    //Raiffeisenbank Münster eGen
            "38238",    //Raiffeisenbank Murau eGen
            "38370",    //Raiffeisenbank Mureck eGen
            "38186",    //Raiffeisenbank Mürztal eGen
            "38240",    //Raiffeisenbank Mürztal eGen
            "36283",    //Raiffeisenbank Nauders eGen
            "33058",    //Raiffeisenbank Neckenmarkt eGen
            "38252",    //Raiffeisenbank Nestelbach-Eggersdorf eGen
            "38055",    //Raiffeisenbank Nestelbach-Eggersdorf eGen
            "34356",    //Raiffeisenbank Neukirchen an der Vöckla eGen
            "38402",    //Raiffeisenbank Neumarkt-Oberwölz eGen
            "38452",    //Raiffeisenbank Neumarkt-Oberwölz eGen
            "32865",    //Raiffeisenbank Neunkirchen - Schwarzatal-Mitte eGen
            "33012",    //Raiffeisenbank Neusiedlersee-Hügelland eGen
            "33092",    //Raiffeisenbank Neusiedlersee-Hügelland eGen
            "36285",    //Raiffeisenbank Neustift im Stubai reg.Gen.m.b.H.
            "35043",    //Raiffeisenbank Niedernsill eGen
            "34361",    //Raiffeisenbank Niederwaldkirchen eGen
            "38108",    //Raiffeisenbank Nördliche Oststeiermark eGen
            "32195",    //Raiffeisenbank NÖ-Süd Alpin eGen
            "32631",    //Raiffeisenbank NÖ-Süd Alpin eGen
            "35044",    //Raiffeisenbank Nußdorf eGen
            "35045",    //Raiffeisenbank Oberalm-Puch reg.Gen.m.b.H.
            "39431",    //Raiffeisenbank Oberdrauburg, reg.Gen.m.b.H.
            "39322",    //Raiffeisenbank Oberdrautal-Weissensee, reg.Gen.m.b.H.
            "34370",    //Raiffeisenbank Oberes Innviertel eGen
            "39491",    //Raiffeisenbank Oberes Lavanttal reg.Gen.m.b.H.
            "39561",    //Raiffeisenbank Oberes Mölltal, reg.Gen.m.b.H.
            "32930",    //Raiffeisenbank Oberes Triestingtal eGen
            "32415",    //Raiffeisenbank Oberes Waldviertel eGen
            "32936",    //Raiffeisenbank Oberes Waldviertel eGen
            "36359",    //Raiffeisenbank Oberland eGen
            "36220",    //Raiffeisenbank Oberlechtal eGen
            "38266",    //Raiffeisenbank Öblarn eGen
            "34390",    //Raiffeisenbank Ohlsdorf eGen
            "39510",    //Raiffeisenbank Ossiacher See, reg.Gen.m.b.H.
            "32615",    //Raiffeisenbank Ottenschlag-Martinsberg eGen
            "34400",    //Raiffeisenbank Ottnang-Wolfsegg eGen
            "34420",    //Raiffeisenbank Pabneukirchen eGen
            "33071",    //Raiffeisenbank Pamhagen eGen
            "38282",    //Raiffeisenbank Passail eGen
            "36248",    //Raiffeisenbank Paznaun eGen
            "34777",    //Raiffeisenbank Perg eGen
            "34442",    //Raiffeisenbank Peuerbach eGen
            "35048",    //Raiffeisenbank Piesendorf reg.Gen.m.b.H.
            "32642",    //Raiffeisenbank Piestingtal eGen
            "38285",    //Raiffeisenbank Pischelsdorf-Stubenberg eGen
            "32647",    //Raiffeisenbank Pittental/Bucklige Welt eGen
            "36353",    //Raiffeisenbank Pitztal eGen
            "38023",    //Raiffeisenbank Pöllau-Birkfeld eGen
            "38311",    //Raiffeisenbank Pöllau-Birkfeld eGen
            "34434",    //Raiffeisenbank Pöndorf - Frankenmarkt eGen
            "34437",    //Raiffeisenbank Prambachkirchen eGen
            "34438",    //Raiffeisenbank Pramet eGen
            "38292",    //Raiffeisenbank Preding-Hengsberg-St. Nikolai i. S. eGen
            "33078",    //Raiffeisenbank Purbach eGen
            "39457",    //Raiffeisenbank Radenthein-Bad Kleinkirchheim reg.Gen.m.b.H.
            "35049",    //Raiffeisenbank Radstadt-Untertauern-Filzmoos-Forstau reg.Gen.m.b.H.
            "35149",    //Raiffeisenbank Radstadt-Untertauern-Filzmoos-Forstau reg.Gen.m.b.H.
            "35249",    //Raiffeisenbank Radstadt-Untertauern-Filzmoos-Forstau reg.Gen.m.b.H.
            "37461",    //Raiffeisenbank Rankweil reg.Gen.m.b.H.
            "35051",    //Raiffeisenbank Rauris-Bucheben reg.Gen.m.b.H.
            "34030",    //Raiffeisenbank Region Altheim eGen
            "32025",    //Raiffeisenbank Region Amstetten eGen
            "32778",    //Raiffeisenbank Region Amstetten eGen
            "32789",    //Raiffeisenbank Region Amstetten eGen
            "34277",    //Raiffeisenbank Region Bad Leonfelden eGen
            "32045",    //Raiffeisenbank Region Baden eGen
            "32118",    //Raiffeisenbank Region Baden eGen
            "34060",    //Raiffeisenbank Region Braunau eGen
            "34180",    //Raiffeisenbank Region Eferding eGen
            "38071",    //Raiffeisenbank Region Fehring eGen
            "38132",    //Raiffeisenbank Region Fehring eGen
            "34110",    //Raiffeisenbank Region Freistadt eGen
            "34111",    //Raiffeisenbank Region Gallneukirchen eGen
            "38103",    //Raiffeisenbank Region Gleisdorf eGen
            "38372",    //Raiffeisenbank Region Gleisdorf eGen
            "38477",    //Raiffeisenbank Region Graz-Thalerhof eGen
            "38072",    //Raiffeisenbank Region Graz-Thalerhof eGen
            "34736",    //Raiffeisenbank Region Grieskirchen eGen
            "34250",    //Raiffeisenbank Region Hausruck eGen
            "34380",    //Raiffeisenbank Region Kirchdorf eGen
            "34233",    //Raiffeisenbank Region Kirchdorf eGen
            "34318",    //Raiffeisenbank Region Kirchdorf eGen
            "34321",    //Raiffeisenbank Region Kirchdorf eGen
            "34362",    //Raiffeisenbank Region Kirchdorf eGen
            "34427",    //Raiffeisenbank Region Kirchdorf eGen
            "34481",    //Raiffeisenbank Region Kirchdorf eGen
            "34606",    //Raiffeisenbank Region Kirchdorf eGen
            "34300",    //Raiffeisenbank Region Neufelden eGen
            "33072",    //Raiffeisenbank Region Parndorf eGen
            "34460",    //Raiffeisenbank Region Pregarten eGen
            "34450",    //Raiffeisenbank Region Ried i.I. eGen
            "34410",    //Raiffeisenbank Region Rohrbach eGen
            "32477",    //Raiffeisenbank Region Schallaburg eGen
            "32368",    //Raiffeisenbank Region Schallaburg eGen
            "32455",    //Raiffeisenbank Region Schallaburg eGen
            "32679",    //Raiffeisenbank Region Schallaburg eGen
            "34455",    //Raiffeisenbank Region Schärding eGen
            "34630",    //Raiffeisenbank Region Schwanenstadt eGen
            "32823",    //Raiffeisenbank Region Schwechat eGen
            "34560",    //Raiffeisenbank Region Sierning-Enns eGen
            "34157",    //Raiffeisenbank Region Sierning-Enns eGen
            "32585",    //Raiffeisenbank Region St. Pölten eGen
            "34710",    //Raiffeisenbank Region Vöcklabruck eGen
            "32002",    //Raiffeisenbank Region Wagram eGen
            "32291",    //Raiffeisenbank Region Wagram eGen
            "32990",    //Raiffeisenbank Region Waldviertel Mitte eGen
            "34475",    //Raiffeisenbank Reichenau eGen
            "39461",    //Raiffeisenbank Reichenau-Gnesau, reg.Gen.m.b.H.
            "36303",    //Raiffeisenbank Reith im Alpbachtal eGen
            "36990",    //Raiffeisenbank Reutte reg.Gen.m.b.H.
            "36305",    //Raiffeisenbank Reutte reg.Gen.m.b.H.
            "36306",    //Raiffeisenbank Ried in Tirol Fendels-Tösens und Umgebung reg.Gen.m.b.H.
            "39487",    //Raiffeisenbank Rosental, reg.Gen.m.b.H.
            "35052",    //Raiffeisenbank Saalbach-Hinterglemm-Viehhofen eGen
            "35152",    //Raiffeisenbank Saalbach-Hinterglemm-Viehhofen eGen
            "35352",    //Raiffeisenbank Saalbach-Hinterglemm-Viehhofen eGen
            "35452",    //Raiffeisenbank Saalbach-Hinterglemm-Viehhofen eGen
            "35053",    //Raiffeisenbank Saalfelden reg.Gen.m.b.H.
            "35054",    //Raiffeisenbank Salzburg Maxglan-Siezenheim eGen
            "35154",    //Raiffeisenbank Salzburg Maxglan-Siezenheim eGen
            "35047",    //Raiffeisenbank Salzburger Seenland eGen
            "35009",    //Raiffeisenbank Salzburger Seenland eGen
            "35075",    //Raiffeisenbank Salzburger Seenland eGen
            "35109",    //Raiffeisenbank Salzburger Seenland eGen
            "35147",    //Raiffeisenbank Salzburger Seenland eGen
            "35034",    //Raiffeisenbank Salzburg-Liefering eGen
            "34510",    //Raiffeisenbank Salzkammergut eGen
            "38375",    //Raiffeisenbank Schilcherland eGen
            "38481",    //Raiffeisenbank Schladming-Ramsau-Haus eGen
            "34613",    //Raiffeisenbank Schwertberg eGen
            "32275",    //Raiffeisenbank Seefeld-Hadres eGen
            "36314",    //Raiffeisenbank Seefeld-Leutasch-Reith-Scharnitz reg.Gen.m.b.H.
            "33002",    //Raiffeisenbank Seewinkel-Hansag eGen
            "33104",    //Raiffeisenbank Seewinkel-Hansag eGen
            "33118",    //Raiffeisenbank Seewinkel-Hansag eGen
            "36315",    //Raiffeisenbank Serfaus-Fiss eGen
            "36368",    //Raiffeisenbank Sillian eGen
            "36374",    //Raiffeisenbank Sillian eGen
            "36387",    //Raiffeisenbank Sillian eGen
            "36316",    //Raiffeisenbank Silz-Haiming und Umgebung eGen
            "39254",    //Raiffeisenbank Sirnitz-Himmelberg-Deutsch-Griffen, reg.Gen.m.b.H.
            "36324",    //Raiffeisenbank Sölden eGen
            "36318",    //Raiffeisenbank Söll - Scheffau reg.Gen.m.b.H.
            "34521",    //Raiffeisenbank St. Agatha eGen
            "36252",    //Raiffeisenbank St. Anton am Arlberg eGen
            "38335",    //Raiffeisenbank St. Georgen a. d. Stiefing eGen
            "35057",    //Raiffeisenbank St. Johann im Pongau reg.Gen.m.b.H.
            "35058",    //Raiffeisenbank St. Koloman reg.Gen.m.b.H.
            "34530",    //Raiffeisenbank St. Marien eGen
            "34535",    //Raiffeisenbank St. Martin i.M.-Kleinzell eGen
            "35060",    //Raiffeisenbank St. Martin-Lofer-Weißbach eGen
            "35160",    //Raiffeisenbank St. Martin-Lofer-Weißbach eGen
            "39500",    //Raiffeisenbank St. Paul im Lavanttal mit Zweiganstalten Maria Rojach und St. Georgen, reg.Gen.m.b.H.
            "34540",    //Raiffeisenbank St. Roman eGen
            "38374",    //Raiffeisenbank St. Stefan-Jagerberg-Wolfsberg eGen
            "36349",    //RaiffeisenBank St. Ulrich - Waidring eGen
            "35055",    //Raiffeisenbank St. Veit-Schwarzach-Goldegg reg.Gen.m.b.H.
            "35155",    //Raiffeisenbank St. Veit-Schwarzach-Goldegg reg.Gen.m.b.H.
            "35255",    //Raiffeisenbank St. Veit-Schwarzach-Goldegg reg.Gen.m.b.H.
            "38433",    //Raiffeisenbank Stallhofen eGen
            "34633",    //Raiffeisenbank Steinbach-Grünburg eGen
            "38249",    //Raiffeisenbank Steirisches Salzkammergut eGen
            "34114",    //Raiffeisenbank Steyr eGen
            "34543",    //Raiffeisenbank Steyr eGen
            "34637",    //Raiffeisenbank Steyregg eGen
            "34522",    //Raiffeisenbank St.Florian am Inn eGen
            "35046",    //Raiffeisenbank St.Georgen eGen
            "35056",    //Raiffeisenbank St.Gilgen-Fuschl-Strobl eGen
            "35156",    //Raiffeisenbank St.Gilgen-Fuschl-Strobl eGen
            "35256",    //Raiffeisenbank St.Gilgen-Fuschl-Strobl eGen
            "35061",    //Raiffeisenbank St.Michael - Oberlungau eGen
            "35161",    //Raiffeisenbank St.Michael - Oberlungau eGen
            "35261",    //Raiffeisenbank St.Michael - Oberlungau eGen
            "35361",    //Raiffeisenbank St.Michael - Oberlungau eGen
            "32842",    //Raiffeisenbank Stockerau eGen
            "38436",    //Raiffeisenbank Straden eGen
            "38420",    //Raiffeisenbank Straß-Spielfeld eGen
            "35062",    //Raiffeisenbank Straßwalchen eGen
            "38373",    //Raiffeisenbank St.Stefan-Kraubath eGen
            "38056",    //Raiffeisenbank Süd-Weststeiermark eGen
            "38407",    //Raiffeisenbank Süd-Weststeiermark eGen
            "38503",    //Raiffeisenbank Süd-Weststeiermark eGen
            "35063",    //Raiffeisenbank Tamsweg eGen
            "35050",    //Raiffeisenbank Tamsweg eGen
            "35163",    //Raiffeisenbank Tamsweg eGen
            "35263",    //Raiffeisenbank Tamsweg eGen
            "36333",    //Raiffeisenbank Tannheimertal eGen
            "34661",    //Raiffeisenbank Tarsdorf eGen
            "35064",    //Raiffeisenbank Taxenbach reg.Gen.m.b.H.
            "35164",    //Raiffeisenbank Taxenbach reg.Gen.m.b.H.
            "36336",    //Raiffeisenbank Telfs-Mieming eGen
            "36276",    //Raiffeisenbank Telfs-Mieming eGen
            "35065",    //Raiffeisenbank Thalgau eGen
            "36337",    //Raiffeisenbank Thaur eGen
            "32127",    //Raiffeisenbank Thayatal-Mitte eGen
            "38411",    //Raiffeisenbank Thermenland eGen
            "36339",    //Raiffeisenbank Thiersee eGen
            "34669",    //Raiffeisenbank Timelkam-Lenzing-Puchkirchen eGen
            "32447",    //Raiffeisenbank Traisen-Gölsental eGen
            "32944",    //Raiffeisenbank Traisen-Gölsental eGen
            "38348",    //Raiffeisenbank Trieben eGen
            "32880",    //Raiffeisenbank Tulln eGen
            "38347",    //Raiffeisenbank Turnau-St. Lorenzen eGen
            "38462",    //Raiffeisenbank Turnau-St. Lorenzen eGen
            "36342",    //Raiffeisenbank Tux eGen
            "35066",    //Raiffeisenbank Unken eGen
            "35068",    //Raiffeisenbank Uttendorf eGen
            "39390",    //Raiffeisenbank Velden am Wörthersee reg.Gen.m.b.H.
            "36345",    //Raiffeisenbank Vils und Umgebung eGen
            "32901",    //Raiffeisenbank Vitis eGen
            "39546",    //Raiffeisenbank Völkermarkt, reg.Gen.m.b.H.
            "37435",    //Raiffeisenbank Vorderbregenzerwald reg.Gen.m.b.H.
            "36291",    //Raiffeisenbank Vorderes Oetztal reg.Gen.m.b.H.
            "37475",    //Raiffeisenbank Vorderland reg.Gen.m.b.H.
            "35069",    //Raiffeisenbank Wagrain-Kleinarl eGen
            "35169",    //Raiffeisenbank Wagrain-Kleinarl eGen
            "32904",    //Raiffeisenbank Waidhofen a. d. Thaya eGen
            "35070",    //Raiffeisenbank Wald reg.Gen.m.b.H.
            "35170",    //Raiffeisenbank Wald reg.Gen.m.b.H.
            "34732",    //Raiffeisenbank Walding-Ottensheim eGen
            "34735",    //Raiffeisenbank Waldzell eGen
            "37458",    //RAIFFEISENBANK WALGAU-GROSSWALSERTAL reg.Gen.m.b.H.
            "35071",    //Raiffeisenbank Wals-Himmelreich reg.Gen.m.b.H.
            "35371",    //Raiffeisenbank Wals-Himmelreich reg.Gen.m.b.H.
            "34738",    //Raiffeisenbank Wartberg an der Krems eGen
            "36351",    //Raiffeisenbank Wattens und Umgebung, reg.Gen.m.b.H.
            "38041",    //Raiffeisenbank Wechselland eGen
            "33106",    //Raiffeisenbank Weiden am See eGen
            "34741",    //Raiffeisenbank Weißkirchen a.d. Traun eGen
            "37474",    //Raiffeisenbank Weissachtal eGen
            "38187",    //Raiffeisenbank Weiz-Anger eGen
            "38010",    //Raiffeisenbank Weiz-Anger eGen
            "34680",    //Raiffeisenbank Wels eGen
            "34234",    //Raiffeisenbank Wels eGen
            "34770",    //Raiffeisenbank Wels Süd eGen
            "39559",    //Raiffeisenbank Wernberg, reg.Gen.m.b.H.
            "36354",    //Raiffeisenbank Westendorf eGen
            "36209",    //Raiffeisenbank Westliches Mittelgebirge eGen
            "34747",    //Raiffeisenbank Weyer eGen
            "32667",    //Raiffeisenbank Wienerwald eGen
            "32414",    //Raiffeisenbank Wienerwald eGen
            "38499",    //Raiffeisenbank Wildon-Lebring eGen
            "36357",    //Raiffeisenbank Wildschönau reg.Gen.m.b.H.
            "34491",    //Raiffeisenbank Windischgarsten eGen
            "36329",    //Raiffeisenbank Wipptal eGen
            "32951",    //Raiffeisenbank Wolkersdorf eGen
            "32906",    //Raiffeisenbank Ybbstal eGen
            "36360",    //Raiffeisenbank Zell am Ziller und Umgebung reg.Gen.m.b.H.
            "38368",    //Raiffeisenbank Zirbenland eGen
            "38261",    //Raiffeisenbank Zirbenland eGen
            "33027",    //Raiffeisenbezirksbank Güssing eGen
            "33034",    //Raiffeisenbezirksbank Jennersdorf eGen
            "39358",    //Raiffeisen-Bezirksbank Klagenfurt, reg.Gen.m.b.H.
            "33124",    //Raiffeisenbezirksbank Mattersburg eGen
            "33065",    //Raiffeisenbezirksbank Oberpullendorf eGen
            "33046",    //Raiffeisenbezirksbank Oberpullendorf eGen
            "33125",    //Raiffeisenbezirksbank Oberwart eGen
            "33067",    //Raiffeisenbezirksbank Oberwart eGen
            "39267",    //Raiffeisen-Bezirksbank Spittal/Drau, reg.Gen.m.b.H.
            "39475",    //Raiffeisen-Bezirksbank St. Veit a.d. Glan-Feldkirchen, reg.Gen.m.b.H.
            "39505",    //Raiffeisen-Bezirksbank St. Veit a.d. Glan-Feldkirchen, reg.Gen.m.b.H.
            "32059",    //Raiffeisenkasse Blindenmarkt eGen
            "32099",    //Raiffeisenkasse Dobersberg-Waldkirchen eGen
            "32145",    //Raiffeisenkasse Ernstbrunn eGen
            "36281",    //Raiffeisenkasse für Mutters, Natters und Kreith reg.Gen.m.b.H.
            "32242",    //Raiffeisenkasse Großweikersdorf-Wiesendorf-Ruppersthal eGen
            "32247",    //Raiffeisenkasse Günselsdorf eGen
            "32278",    //Raiffeisenkasse Haidershofen eGen
            "35023",    //Raiffeisenkasse Hallwang eGen
            "36240",    //Raiffeisenkasse Hart eGen
            "32286",    //Raiffeisenkasse Heiligeneich eGen
            "32374",    //Raiffeisenkasse Kirchschlag in der Buckligen Welt eGen
            "35029",    //Raiffeisenkasse Kuchl reg.Gen.m.b.H.
            "36373",    //Raiffeisenkasse Lienzer Talboden eGen
            "36275",    //Raiffeisenkasse Mieders-Schönberg reg.Gen.m.b.H.
            "32551",    //Raiffeisenkasse Neusiedl a.d.Zaya eGen
            "32614",    //Raiffeisenkasse Orth a.d. Donau eGen
            "32660",    //Raiffeisenkasse Pottschach reg.Gen.m.b.H.
            "32663",    //Raiffeisenkasse Poysdorf eGen
            "32715",    //Raiffeisenkasse Retz-Pulkautal reg.Gen.m.b.H.
            "36310",    //Raiffeisenkasse Rum-Innsbruck/Arzl eGen
            "36320",    //Raiffeisenkasse Schlitters, Bruck und Straß reg.Gen.m.b.H.
            "36332",    //Raiffeisenkasse Stumm, Stummerberg und Umgebung reg.Gen.m.b.H.
            "36386",    //Raiffeisenkasse Villgratental reg.Gen.m.b.H.
            "36347",    //Raiffeisenkasse Volders und Umgebung reg.Gen.m.b.H.
            "36352",    //Raiffeisenkasse Weerberg reg.Gen.m.b.H.
            "35072",    //Raiffeisenkasse Werfen reg.Gen.m.b.H.
            "35172",    //Raiffeisenkasse Werfen reg.Gen.m.b.H.
            "35272",    //Raiffeisenkasse Werfen reg.Gen.m.b.H.
            "32940",    //Raiffeisenkasse Wiesmath-Hochwolkersdorf eGen
            "32982",    //Raiffeisenkasse Ziersdorf reg.Gen.m.b.H.
            "32985",    //Raiffeisenkasse Zistersdorf - Dürnkrut reg.Gen.m.b.H.
            "33000",    //Raiffeisenlandesbank Burgenland und Revisionsverband eGen
            "33035",    //Raiffeisenlandesbank Burgenland und Revisionsverband eGen
            "33135",    //Raiffeisenlandesbank Burgenland und Revisionsverband eGen
            "39000",    //Raiffeisenlandesbank Kärnten - Rechenzentrum und Revisionsverband, reg.Gen.m.b.H.
            "32000",    //RAIFFEISENLANDESBANK NIEDERÖSTERREICH-WIEN AG
            "34000",    //Raiffeisenlandesbank Oberösterreich AG
            "34795",    //Raiffeisenlandesbank Oberösterreich AG
            "34796",    //Raiffeisenlandesbank Oberösterreich AG
            "34920",    //Raiffeisenlandesbank Oberösterreich AG
            "34921",    //Raiffeisenlandesbank Oberösterreich AG
            "34922",    //Raiffeisenlandesbank Oberösterreich AG
            "38000",    //Raiffeisen-Landesbank Steiermark AG
            "36000",    //Raiffeisen-Landesbank Tirol AG
            "37000",    //Raiffeisenlandesbank Vorarlberg Waren- und Revisionsverband reg.Gen.m.b.H.
            "31600",    //Raiffeisen-Leasing Bank AG
            "32092",    //Raiffeisen-Regionalbank Gänserndorf eGen
            "32937",    //Raiffeisenregionalbank Wiener Neustadt eGen
            "35000",    //Raiffeisenverband Salzburg eGen
            "19420",    //RCI Banque SA, Niederlassung Österreich
            "1000",    //Republik Österreich
            "19700",    //s Wohnbaubank AG
            "55000",    //SALZBURGER LANDES-HYPOTHEKENBANK AG
            "20404",    //Salzburger Sparkasse Bank AG
            "19810",    //Santander Consumer Bank GmbH
            "74000",    //Sberbank Europe AG
            "19200",    //Schoellerbank AG
            "76520",    //SEMPER CONSTANTIA PRIVATBANK AG
            "76030",    //SIX Payment Services (Austria) GmbH
            "18150",    //Société Générale Zweigniederlassung Wien
            "46660",    //SPARDA-BANK AUSTRIA eGen
            "49460",    //SPARDA-BANK AUSTRIA eGen
            "74200",    //SPAR-FINANZ BANK AG
            "20205",    //Sparkasse Baden
            "20225",    //Sparkasse Baden
            "20607",    //Sparkasse Bludenz Bank AG
            "20601",    //Sparkasse Bregenz Bank AG
            "20603",    //Sparkasse der Gemeinde Egg
            "20202",    //Sparkasse der Stadt Amstetten AG
            "20604",    //Sparkasse der Stadt Feldkirch
            "20505",    //Sparkasse der Stadt Kitzbühel
            "20330",    //Sparkasse Eferding-Peuerbach-Waizenkirchen
            "20702",    //Sparkasse Feldkirchen/Kärnten
            "20306",    //SPARKASSE FRANKENMARKT AG
            "20216",    //Sparkasse Hainburg-Bruck-Neusiedl AG
            "20218",    //Sparkasse Haugsdorf
            "20219",    //Sparkasse Herzogenburg-Neulengbach Bank AG
            "20221",    //Sparkasse Horn-Ravelsbach-Kirchberg AG
            "20502",    //Sparkasse Imst AG
            "20227",    //Sparkasse Korneuburg AG
            "20506",    //Sparkasse Kufstein Tiroler Sparkasse von 1877
            "20317",    //Sparkasse Lambach Bank AG
            "20230",    //Sparkasse Langenlois
            "20402",    //Sparkasse Mittersill Bank AG
            "20334",    //Sparkasse Mühlviertel-West Bank AG
            "20828",    //Sparkasse Mürzzuschlag AG
            "20326",    //Sparkasse Neuhofen Bank AG
            "20241",    //Sparkasse Neunkirchen
            "20256",    //SPARKASSE NIEDERÖSTERREICH MITTE WEST AG
            "20833",    //Sparkasse Pöllau AG
            "20245",    //Sparkasse Pottenstein N.Ö.
            "20246",    //Sparkasse Poysdorf AG
            "20331",    //Sparkasse Pregarten - Unterweißenbach AG
            "20508",    //Sparkasse Rattenberg Bank AG
            "20509",    //Sparkasse Reutte AG
            "20333",    //Sparkasse Ried im Innkreis-Haag am Hausruck
            "20314",    //Sparkasse Salzkammergut AG
            "20257",    //Sparkasse Scheibbs AG
            "20510",    //Sparkasse Schwaz AG
            "20839",    //Sparkasse Voitsberg-Köflach BankAG
            "43510",    //start:bausparkasse AG
            "75100",    //State Street Bank International GmbH Filiale Wien
            "20815",    //Steiermärkische Bank und Sparkassen AG
            "19685",    //Steyler Bank GmbH
            "76032",    //TeamBank Österreich - Niederlassung der TeamBank AG Nürnberg
            "20503",    //Tiroler Sparkasse BankAG Innsbruck
            "19430",    //UBS Europe SE Niederlassung Österreich
            "18250",    //UniCredit Bank AG, Zweigniederlassung Wien
            "12000",    //UniCredit Bank Austria AG
            "11000",    //UniCredit Bank Austria AG
            "19690",    //VakifBank International AG
            "45330",    //Volksbank Almtal e. Gen.
            "40720",    //Volksbank Bad Goisern e. Gen.
            "43180",    //Volksbank Bad Hall e.Gen.
            "42130",    //Volksbank Kärnten eG
            "42600",    //Volksbank Kärnten eG
            "42820",    //Volksbank Kärnten eG
            "46900",    //Volksbank Kärnten eG
            "47150",    //Volksbank Niederösterreich AG
            "40170",    //Volksbank Niederösterreich AG
            "40630",    //Volksbank Niederösterreich AG
            "40850",    //Volksbank Niederösterreich AG
            "41050",    //Volksbank Niederösterreich AG
            "41210",    //Volksbank Niederösterreich AG
            "43530",    //Volksbank Niederösterreich AG
            "43920",    //Volksbank Niederösterreich AG
            "44820",    //Volksbank Niederösterreich AG
            "44800",    //Volksbank Oberösterreich AG
            "42550",    //Volksbank Oberösterreich AG
            "42630",    //Volksbank Oberösterreich AG
            "42830",    //Volksbank Oberösterreich AG
            "43210",    //Volksbank Oberösterreich AG
            "43830",    //Volksbank Oberösterreich AG
            "44790",    //Volksbank Oberösterreich AG
            "35080",    //Volksbank Raiffeisenbank Oberbayern Südost eG-Zweigniederlassung VR-Bank Salzburg
            "45010",    //Volksbank Salzburg eG
            "44020",    //Volksbank Salzburg eG
            "44300",    //Volksbank Salzburg eG
            "44480",    //Volksbank Salzburg eG
            "44770",    //Volksbank Steiermark AG
            "42320",    //Volksbank Steiermark AG
            "43030",    //Volksbank Steiermark AG
            "44780",    //Volksbank Steiermark AG
            "44810",    //Volksbank Steiermark AG
            "46590",    //Volksbank Steiermark AG
            "48150",    //Volksbank Steiermark AG
            "42740",    //Volksbank Steirisches Salzkammergut, reg.Gen.m.b.H.
            "42390",    //Volksbank Tirol AG
            "43770",    //Volksbank Tirol AG
            "45850",    //Volksbank Tirol AG
            "45710",    //VOLKSBANK VORARLBERG e. Gen.
            "43000",    //VOLKSBANK WIEN AG
            "18160",    //VOLKSBANK WIEN AG
            "40000",    //VOLKSBANK WIEN AG
            "40100",    //VOLKSBANK WIEN AG
            "40430",    //VOLKSBANK WIEN AG
            "41600",    //VOLKSBANK WIEN AG
            "42750",    //VOLKSBANK WIEN AG
            "43610",    //VOLKSBANK WIEN AG
            "43690",    //VOLKSBANK WIEN AG
            "44430",    //VOLKSBANK WIEN AG
            "44570",    //VOLKSBANK WIEN AG
            "49220",    //VOLKSBANK WIEN AG
            "18600",    //Volkskreditbank AG
            "58000",    //Vorarlberger Landes- und Hypothekenbank AG
            "49500",    //VR-Bank Braunau Zweigniederlassung der VR-Bank Rottal-Inn eG
            "19940",    //VTB Bank (Austria) AG
            "20272",    //Waldviertler Sparkasse Bank AG
            "20263",    //Waldviertler Sparkasse Bank AG
            "43600",    //Waldviertler Volksbank Horn reg.Gen.m.b.H.
            "37434",    //Walser Privatbank AG
            "19880",    //Western Union International Bank GmbH
            "20267",    //Wiener Neustädter Sparkasse
            "19440",    //Wiener Privatbank SE
            "19160",    //Wiener Privatbank SE
            "44960",    //WSK Bank AG
            "31300",    //ZUNO BANK AG
            "19510"    //Zürcher Kantonalbank Österreich AG
    };
}
