package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;

/**
 * Generates a Danish IBAN.
 */

public class DKIban {
    private RandomUtil randomUtil = new RandomUtil();
    private IbanUtil ibanUtil = new IbanUtil();

    /**
     * Generates random number to create IBAN.
     *
     * @return random Danish IBAN.
     */

    public String generateDKIban(String country, String bankCode) {

        if (country.equals("")) {
            country = "DK";
        }

        bankCode = ibanUtil.getBankCode(bankCode, DKBankCodes);
        bankCode = ibanUtil.padWithStartingZeros(bankCode, 4);

        String permittedAccountDigits = "0123456789";
        String accountNumber = randomUtil.randomString(permittedAccountDigits, 10);

        String baseIbanStr = bankCode + accountNumber + ibanUtil.stringToNumbersIso13616(country) + "00";

        String controlNr = String.valueOf(98 - IbanUtil.mod97(baseIbanStr));
        if (controlNr.length() == 1) {
            controlNr = "0" + controlNr;
        }

        return country + controlNr + bankCode + accountNumber;

    }


    /**
     * Array of Danish Bank codes
     */

    public String[] DKBankCodes = {
            "40",    //NordeaNordea Vordingborg Afdeling
            "41",    //NordeaNordea Vordingborg Afdeling
            "42",    //NordeaNordea Vordingborg Afdeling
            "43",    //NordeaNordea Vordingborg Afdeling
            "44",    //NordeaNordea Vordingborg Afdeling
            "45",    //NordeaNordea Vordingborg Afdeling
            "46",    //NordeaNordea Næstved Afdeling
            "47",    //NordeaNordea Vordingborg Afdeling
            "48",    //Nordea
            "51",    //NordeaNordea Vordingborg Afdeling
            "52",    //NordeaNordea Vordingborg Afdeling
            "53",    //NordeaNordea Vordingborg Afdeling
            "56",    //NordeaNordea Stege Afdeling
            "57",    //Nordea
            "59",    //NordeaNordea Næstved Afdeling
            "101",    //NordeaNordea Kongens Nytorv Afdeling
            "102",    //NordeaNordea Vesterport Afdeling
            "103",    //NordeaNordea Trianglen Afdeling
            "104",    //NordeaNordea Svanemølle Afdeling
            "105",    //NordeaNordea Nørreport Afdeling
            "106",    //NordeaNordea Amagerbro Afdeling
            "107",    //NordeaNordea Falkoner Alle Afdeling
            "108",    //NordeaNordea Nørrebro Afdeling
            "109",    //NordeaNordea Enghave Afdeling
            "110",    //NordeaNordea Valby Afdeling
            "111",    //NordeaNordea Hellerup Afdeling
            "113",    //Nordea
            "114",    //NordeaNordea Gentofte Afdeling
            "115",    //NordeaNordea Vanløse Afdeling
            "116",    //NordeaNordea Vesterport Afdeling
            "117",    //Nordea
            "118",    //NordeaNordea Vanløse Afdeling
            "119",    //NordeaNordea Nørreport Afdeling
            "120",    //NordeaNordea Sundbyvester Afdeling
            "121",    //NordeaNordea Nørreport Afdeling
            "122",    //NordeaNordea Trianglen Afdeling
            "123",    //NordeaNordea Kastrup Afdeling
            "124",    //NordeaNordea Glostrup Afdeling
            "125",    //NordeaNordea Nørreport Afdeling
            "126",    //Nordea
            "127",    //Nordea
            "128",    //NordeaNordea Sundbyvester Afdeling
            "129",    //NordeaNordea Søborg Afdeling
            "130",    //NordeaNordea Hvidovre Afdeling
            "131",    //NordeaNordea Rødovre Afdeling
            "132",    //NordeaNordea Vesterport Afdeling
            "133",    //NordeaNordea Vesterport Afdeling
            "134",    //NordeaNordea Forvaltning
            "135",    //NordeaNordea Falkoner Alle Afdeling
            "136",    //NordeaNordea Vesterport Afdeling
            "137",    //NordeaNordea Valby Afdeling
            "138",    //NordeaNordea Glostrup Afdeling
            "139",    //NordeaNordea Glostrup Afdeling
            "140",    //NordeaNordea Søborg Afdeling
            "141",    //NordeaNordea Lyngby Afdeling
            "142",    //NordeaNordea Kongens Nytorv Afdeling
            "143",    //NordeaNordea Frederiksberg Afdeling
            "144",    //NordeaNordea Rødovre Afdeling
            "145",    //NordeaNordea Vesterport Afdeling
            "146",    //NordeaNordea Herlev Afdeling
            "148",    //NordeaNordea Amager Afdeling
            "149",    //NordeaNordea Charlottenlund Afdeling
            "150",    //NordeaNordea Svanemølle Afdeling
            "151",    //Nordea
            "152",    //NordeaNordea Nørreport Afdeling
            "154",    //NordeaNordea Valby Afdeling
            "155",    //NordeaNordea Falkoner Alle Afdeling
            "156",    //NordeaNordea Hvidovre Afdeling
            "157",    //Nordea
            "158",    //NordeaNordea Lyngby Afdeling
            "159",    //NordeaNordea Lyngby Afdeling
            "160",    //NordeaNordea Holte Afdeling
            "161",    //Nordea
            "163",    //NordeaNordea Nørreport Afdeling
            "164",    //NordeaNordea Svanemølle Afdeling
            "165",    //NordeaNordea Tårnby Afdeling
            "166",    //NordeaNordea Sundbyvester Afdeling
            "167",    //NordeaNordea Nørrebro Afdeling
            "168",    //NordeaNordea Vesterport Afdeling
            "169",    //NordeaNordea Hvidovre Afdeling
            "170",    //NordeaNordea Islands Brygge Afdeling
            "171",    //NordeaNordea Holte Afdeling
            "172",    //NordeaNordea Vesterport Afdeling
            "173",    //NordeaNordea Sundbyvester Afdeling
            "174",    //NordeaNordea Vanløse Afdeling
            "175",    //Nordea
            "176",    //NordeaNordea Sundbyvester Afdeling
            "177",    //NordeaNordea Vanløse Afdeling
            "178",    //Nordea
            "179",    //NordeaNordea Vesterport Afdeling
            "180",    //NordeaNordea Herlev Afdeling
            "181",    //NordeaNordea Nørreport Afdeling
            "182",    //NordeaNordea Hvidovre Afdeling
            "183",    //NordeaNordea Frederiksberg Afdeling
            "184",    //NordeaNordea Svanemølle Afdeling
            "185",    //NordeaNordea Falkoner Alle Afdeling
            "186",    //NordeaNordea Vesterport Afdeling
            "187",    //NordeaNordea Kongens Nytorv Afdeling
            "190",    //Nordea
            "191",    //Nordea
            "194",    //NordeaNordea Kongens Nytorv Afdeling
            "198",    //Nordea
            "200",    //Danske Bank
            "216",    //Danske BankDanske Bank Statens Betalinger
            "220",    //Danske BankDanske Bank Holbæk Afdeling
            "222",    //Danske BankDanske Bank Køge Afdeling
            "225",    //Danske BankDanske Bank Gentofte Afdeling
            "227",    //Danske BankDanske Bank Solrød Afdeling
            "233",    //Danske BankDanske Bank Allerød Afdeling
            "238",    //Danske BankDanske Bank Amagerbrogade Afdeling
            "239",    //Danske BankDanske Bank Ishøj Afdeling
            "241",    //Danske BankDanske Bank Helsingør Afdeling
            "242",    //Danske BankDanske Bank Amagerbrogade Afdeling
            "246",    //Danske BankDanske Bank Vanløse Afdeling
            "247",    //Danske BankDanske Bank Støvring Afdeling
            "248",    //Danske BankDanske Bank Hvidovre Afdeling
            "249",    //Danske BankDanske Bank Hørsholm Afdeling
            "250",    //Danske BankDanske Bank Holmens Kanal Afdeling
            "252",    //Danske BankDanske Bank Østerbro Afdeling
            "254",    //Danske BankDanske Bank Christianshavn Afdeling
            "255",    //Danske BankDanske Bank Vesterport Afdeling
            "258",    //Danske BankDanske Bank Brønshøj Afdeling
            "259",    //Danske BankDanske Bank Frederiksberg Afdeling
            "260",    //Danske BankDanske Bank Lyngbyvej Afdeling
            "261",    //Danske BankDanske Bank Frederiksberg Afdeling
            "263",    //Danske BankDanske Bank Charlottenlund Afdeling
            "264",    //Danske BankDanske Bank Frederikssundsvej Afdeling
            "265",    //Danske BankDanske Bank Toftegårds Alle Afdeling
            "266",    //Danske BankDanske Bank Hvidovre Afdeling
            "268",    //Danske BankDanske Bank Amagerbrogade Afdeling
            "270",    //Danske BankDanske Bank Glostrup Afdeling
            "271",    //Danske BankDanske Bank Herlev Afdeling
            "272",    //Danske BankDanske Bank Charlottenlund Afdeling
            "274",    //Danske BankDanske Bank Nørreport Afdeling
            "275",    //Danske BankDanske Bank Søborg Afdeling
            "276",    //Danske BankDanske Bank Store Kongensgade Afdeling
            "280",    //Danske BankDanske Bank Bagsværd Afdeling
            "283",    //Danske BankDanske Bank Farum Afdeling
            "284",    //Danske BankDanske Bank Ballerup Afdeling
            "294",    //Danske Bank
            "297",    //Danske BankDanske Bank Holmens Kanal Afdeling
            "301",    //Nordea
            "303",    //NordeaNordea Albertslund Afdeling
            "306",    //Nordea
            "307",    //NordeaNordea Ballerup Afdeling
            "308",    //NordeaNordea Skovlunde Afdeling
            "309",    //Nordea
            "311",    //NordeaNordea Korsør Afdeling
            "312",    //NordeaNordea Albertslund Afdeling
            "314",    //NordeaNordea Næstved Afdeling
            "315",    //NordeaNordea Taastrup Afdeling
            "316",    //NordeaNordea Taastrup Afdeling
            "317",    //NordeaNordea Taastrup Afdeling
            "319",    //NordeaNordea Værløse Afdeling
            "320",    //NordeaNordea Ballerup Afdeling
            "321",    //NordeaNordea Skovlunde Afdeling
            "322",    //NordeaNordea Ballerup Afdeling
            "327",    //NordeaNordea Roskilde Afdeling
            "328",    //NordeaNordea Roskilde Afdeling
            "329",    //NordeaNordea Jyllinge Afdeling
            "333",    //NordeaNordea Skibby Afdeling
            "336",    //Nordea
            "337",    //NordeaNordea Jyllinge Afdeling
            "338",    //Nordea
            "339",    //NordeaNordea Ringsted Afdeling
            "340",    //NordeaNordea Ringsted Afdeling
            "341",    //NordeaNordea Slagelse Afdeling
            "342",    //NordeaNordea Sorø Afdeling
            "343",    //NordeaNordea Korsør Afdeling
            "344",    //NordeaNordea Næstved Afdeling
            "345",    //NordeaNordea Haslev Afdeling
            "346",    //NordeaNordea Næstved Afdeling
            "347",    //NordeaNordea Næstved Afdeling
            "352",    //NordeaNordea Næstved Afdeling
            "354",    //NordeaNordea Ringsted Afdeling
            "373",    //NordeaNordea Slagelse Afdeling
            "378",    //NordeaNordea Dianalund Afdeling
            "379",    //Nordea
            "385",    //NordeaNordea Dianalund Afdeling
            "388",    //NordeaNordea Slagelse Afdeling
            "390",    //NordeaNordea Hvalsø Afdeling
            "392",    //NordeaNordea Viby Sj. Afdeling
            "393",    //NordeaNordea Solrød Center Afdeling
            "400",    //Lån og Spar BankLån og Spar Bank
            "404",    //Lån og Spar BankLån og Spar Bank
            "418",    //Danske BankDanske Bank Roskilde Afdeling
            "421",    //Danske BankEksport & Import Inkasso
            "424",    //Danske Bank
            "429",    //Danske BankDanske Bank Roskilde Afdeling
            "430",    //Danske BankDanske Bank Roskilde Afdeling
            "434",    //Danske BankDanske Bank Greve Afdeling
            "435",    //Nordea
            "440",    //Danske BankDanske Bank Tre Falke Afdeling
            "443",    //Danske BankDanske Bank Gammel Kongevej Afdeling
            "452",    //Danske BankDanske Bank Holte Afdeling
            "454",    //Danske BankDanske Bank Nærumvænge Afdeling
            "455",    //Danske BankDanske Bank Virum-Sorgenfri Afdeling
            "465",    //NordeaNordea Helsingør Afdeling
            "466",    //NordeaNordea Helsingør Afdeling
            "467",    //NordeaNordea Nivå Afdeling
            "468",    //Nordea
            "469",    //NordeaNordea Helsingør Afdeling
            "470",    //Nordea
            "471",    //Nordea
            "473",    //NordeaNordea Helsingør Afdeling
            "474",    //NordeaNordea Helsingør Afdeling
            "480",    //NordeaNordea Hillerød Afdeling
            "482",    //Danske Bank
            "516",    //Sparekassen SjællandSparekassen Sjælland Kalundborg
            "517",    //Sparekassen SjællandSparekassen Sjælland Nykøbing Sj.
            "518",    //Sparekassen SjællandSparekassen Sjælland Jyderup
            "519",    //Sparekassen SjællandSparekassen Sjælland Høng
            "520",    //Sparekassen SjællandSparekassen Sjælland Holbæk
            "521",    //Sparekassen SjællandSparekassen Sjælland Tølløse
            "522",    //Sparekassen SjællandSparekassen Sjælland Hovedkontor
            "523",    //Sparekassen SjællandSparekassen Sjælland Frederikssund
            "524",    //Sparekassen SjællandSparekassen Sjælland Slagelse
            "525",    //Sparekassen SjællandSparekassen Sjælland Roskilde
            "526",    //Sparekassen Sjælland
            "533",    //Dragsholm SparekasseDragsholm Sparekasse Asnæs
            "534",    //Dragsholm SparekasseDragsholm Sparekasse Hørve
            "535",    //Dragsholm Sparekasse
            "536",    //Danske BankDanske Bank Odder Afdeling
            "537",    //Dragsholm SparekasseDragsholm Sparekasse Asnæs, Hovedkontor
            "539",    //Sparekassen SjællandSparekassen Sjælland Vig
            "540",    //Sparekassen SjællandSparekassen Sjælland Høng
            "541",    //Sparekassen SjællandSparekassen Sjælland Sorø
            "542",    //Sparekassen SjællandSparekassen Sjælland Næstved
            "543",    //Sparekassen SjællandSparekassen Sjælland Hillerød
            "544",    //Refsnæs SparekasseRefsnæs Sogns Spare- Og Lånekasse
            "545",    //Sparekassen SjællandSparekassen Sjælland Frederiksberg
            "547",    //Dragsholm SparekasseDragsholm Sparekasse Asnæs Afdeling
            "548",    //Danske BankDanske Bank Nykøbing Sjælland  Afdeling
            "561",    //FS Bank
            "562",    //Danske BankDanske Bank Næstved Afdeling
            "570",    //Sydbank
            "571",    //Danske BankDanske Bank Korsør Afdeling
            "573",    //Danske BankDanske Bank Sorø Afdeling
            "575",    //Danske BankDanske Bank Haslev Afdeling
            "577",    //Sparekassen Sjælland Sparekassen Sjælland Slagelse
            "579",    //Den Lille BikubeDen Lille Bikube Fuglebjerg
            "580",    //Sparekassen SjællandSparekassen Sjælland Slagelse
            "581",    //Sydbank A/S Sydbank Sorø Afdeling
            "582",    //Ikano BankIkano Bank, filial af Ikano Bank AB (publ), Sverige
            "586",    //Sparekassen Sjælland Sparekassen Sjælland Slagelse
            "587",    //Sparekassen Sjælland Sparekassen Sjælland Næstved
            "588",    //Sydbank A/S Sydbank Slagelse Afdeling
            "600",    //
            "601",    //NordeaNordea Faxe Afdeling
            "602",    //NordeaNordea Faxe Afdeling
            "603",    //NordeaNordea Haslev Afdeling
            "604",    //Nordea
            "605",    //NordeaNordea St. Heddinge Afdeling
            "607",    //NordeaNordea Køge Afdeling
            "608",    //Nordea
            "612",    //Danske BankDanske Bank Næstved Afdeling
            "614",    //Danske BankDanske Bank Næstved Afdeling
            "616",    //Danske BankDanske Bank Nykøbing F Afdeling
            "619",    //Danske Bank
            "620",    //Danske Bank
            "622",    //Danske BankDanske Bank Vordingborg Afdeling
            "624",    //Danske BankDanske Bank Fakse Afdeling
            "629",    //Danske BankDanske Bank Køge Afdeling
            "630",    //Danske Bank
            "631",    //Møns Bank Møns Bank Kongsted Afdeling
            "634",    //Snesere Sogns Spare- og Laanekasse
            "637",    //NordeaNordea Rønne Afdeling
            "644",    //Møns BankMøns Bank Fanefjord Afdeling
            "646",    //NordeaNordea Rønne Afdeling
            "647",    //NordeaNordea Rønne Afdeling
            "648",    //NordeaNordea Rønne Afdeling
            "649",    //NordeaNordea Rønne Afdeling
            "650",    //NordeaNordea Rønne Afdeling
            "651",    //NordeaNordea Rønne Afdeling
            "653",    //NordeaNordea Rønne Afdeling
            "654",    //NordeaNordea Rønne Afdeling
            "655",    //NordeaNordea Rønne Afdeling
            "656",    //NordeaNordea Rønne Afdeling
            "657",    //NordeaNordea Rønne Afdeling
            "658",    //NordeaNordea Rønne Afdeling
            "659",    //NordeaNordea Rønne Afdeling
            "660",    //NordeaNordea Rønne Afdeling
            "661",    //NordeaNordea Rønne Afdeling
            "662",    //NordeaNordea Rønne Afdeling
            "670",    //NordeaNordea Nykøbing Falster Afdeling
            "672",    //NordeaNordea Nykøbing Falster Afdeling
            "673",    //NordeaNordea Nykøbing Falster Afdeling
            "674",    //NordeaNordea Nykøbing Sj. Afdeling
            "675",    //NordeaNordea Nykøbing Falster Afdeling
            "676",    //NordeaNordea Nykøbing Falster Afdeling
            "677",    //NordeaNordea Sakskøbing Afdeling
            "678",    //NordeaNordea Nørre Alslev Afdeling
            "679",    //NordeaNordea Nørre Alslev Afdeling
            "680",    //NordeaNordea Nørre Alslev Afdeling
            "681",    //Jyske BankJyske Bank Silkeborg
            "682",    //Jyske BankJyske Bank Maribo
            "683",    //Jyske BankJyske Bank Roskilde
            "684",    //Jyske BankJyske Bank Nakskov
            "685",    //Jyske BankJyske Bank Private Banking Copenhagen
            "686",    //Jyske BankJyske Bank Kreditkontor
            "687",    //Jyske BankJyske Bank Vordingborg
            "688",    //Jyske BankJyske Bank Hellerup
            "689",    //Jyske BankJyske Bank Nakskov
            "690",    //Jyske BankJyske Bank Nakskov
            "691",    //Jyske BankJyske Bank Hellerup
            "692",    //Jyske BankJyske Bank København
            "693",    //Jyske BankJyske Bank Nakskov
            "694",    //Jyske BankJyske Bank Nykøbing F.
            "696",    //Jyske BankJyske Bank Køge
            "697",    //Jyske BankJyske Bank Næstved
            "704",    //Jyske BankJyske Bank Sakskøbing
            "705",    //Jyske BankJyske Bank Rødby
            "706",    //NordeaNordea Nørre Alslev Afdeling
            "708",    //NordeaNordea Lolland-Falster
            "710",    //NordeaNordea Lolland-Falster
            "711",    //Nordea
            "712",    //NordeaNordea Maribo Afdeling
            "713",    //NordeaNordea Lolland-Falster
            "719",    //Danske Bank
            "725",    //FS Bank
            "735",    //NordeaNordea Svendborg Afdeling
            "740",    //NordeaNordea Odense Afdeling
            "745",    //NordeaNordea Assens Afdeling
            "750",    //NordeaNordea Odense Afdeling
            "751",    //FS Bank
            "755",    //Middelfart SparekasseMiddelfart Sparekasse Middelfart
            "756",    //Middelfart SparekasseMiddelfart Sparekasse Strib
            "757",    //Middelfart SparekasseMiddelfart Sparekasse Fredericia
            "758",    //Middelfart SparekasseMiddelfart Sparekasse Vejle
            "759",    //Middelfart SparekasseMiddelfart Sparekasse Kolding
            "762",    //NordeaNordea Kerteminde Afdeling
            "763",    //FS Bank
            "766",    //NordeaNordea Assens Afdeling
            "767",    //NordeaNordea Assens Afdeling
            "773",    //NordeaNordea Ringe Afdeling
            "774",    //NordeaNordea Ejby Afdeling
            "775",    //NordeaNordea Aarup Afdeling
            "776",    //NordeaNordea Middelfart Afdeling
            "777",    //NordeaNordea Middelfart Afdeling
            "778",    //NordeaNordea Middelfart Afdeling
            "779",    //NordeaNordea Middelfart Afdeling
            "784",    //NordeaNordea Kolding Afdeling
            "785",    //NordeaNordea Vejle
            "787",    //NordeaNordea Middelfart Afdeling
            "788",    //NordeaNordea Fredericia Afdeling
            "790",    //NordeaNordea Tarup Afdeling
            "791",    //NordeaNordea Hjallesevej Afdeling
            "798",    //NordeaNordea Haarby Afdeling
            "800",    //Flemløse SparekasseFlemløse Sparekasse
            "802",    //NordeaNordea Ejby Afdeling
            "808",    //NordeaNordea Haarby Afdeling
            "809",    //NordeaNordea Otterup Afdeling
            "810",    //NordeaNordea Odense Afdeling
            "811",    //NordeaNordea Dalum Afdeling
            "812",    //NordeaNordea Odense Afdeling
            "813",    //Fynske Bank Fynske Bank Thurø
            "814",    //Fynske Bank Fynske Bank Nyborg
            "815",    //Fynske Bank Fynske Bank Svendborg
            "816",    //Fynske Bank Fynske Bank Sørup
            "817",    //Fynske Bank Fynske Bank Hesselager
            "818",    //Fynske Bank Fynske Bank Sørup
            "819",    //Fynske Bank Fynske Bank Skårup
            "820",    //Fynske Bank Fynske Bank Nyborg
            "821",    //NordeaNordea Ærø Afdeling
            "823",    //NordeaNordea Ærø Afdeling
            "824",    //FS Bank
            "825",    //NordeaNordea Rudkøbing Afdeling
            "826",    //NordeaNordea Rudkøbing Afdeling
            "827",    //NordeaNordea Rudkøbing Afdeling
            "828",    //Sparekassen Fyn Sparekassen Fyn Faaborg
            "831",    //NordeaNordea Rudkøbing Afdeling
            "834",    //NordeaNordea Nyborg Afdeling
            "835",    //NordeaNordea Nyborg Afdeling
            "836",    //NordeaNordea Nyborg Afdeling
            "837",    //NordeaNordea Langeskov Afdeling
            "838",    //NordeaNordea Langeskov Afdeling
            "839",    //NordeaNordea Nyborg Afdeling
            "840",    //NordeaNordea Nyborg Afdeling
            "841",    //NordeaNordea Nyborg Afdeling
            "842",    //NordeaNordea Nyborg Afdeling
            "843",    //NordeaNordea Nyborg Afdeling
            "844",    //Fynske Bank Fynske Bank Svendborg
            "847",    //Rise Spare- og LånekasseRise Spare- og Lånekasse Ærøskøbing
            "850",    //NordeaNordea Faaborg Afdeling
            "851",    //NordeaNordea Faaborg Afdeling
            "852",    //NordeaNordea Ollerup Afdeling
            "853",    //NordeaNordea Ollerup Afdeling
            "854",    //NordeaNordea Ærø Afdeling
            "855",    //NordeaNordea Ærø Afdeling
            "860",    //Fynske Bank Fynske Sparekassen Rudkøbing
            "861",    //Fynske Bank Fynske Bank Svendborg
            "862",    //Fynske Bank Fynske Bank Sørup
            "863",    //Fynske Bank Fynske Bank Svendborg
            "864",    //Fynske Bank Fynske Bank Svendborg
            "865",    //Fynske Bank Fynske Bank Svendborg
            "866",    //Sparekassen KronjyllandSparekassen Kronjylland Stoholm
            "867",    //Den Jyske SparekasseDen Jyske Sparekasse Give
            "868",    //Den Jyske SparekasseDen Jyske Sparekasse Grindsted
            "870",    //Den Jyske SparekasseDen Jyske Sparekasse Ikast
            "871",    //Den Jyske SparekasseDen Jyske Sparekasse Ikast
            "872",    //Den Jyske SparekasseDen Jyske Sparekasse Esbjerg
            "873",    //Den Jyske SparekasseDen Jyske Sparekasse Grindsted
            "875",    //Ingeniørernes Pensionsbank
            "877",    //Middelfart SparekasseMiddelfart Sparekasse Uldum
            "878",    //Middelfart SparekasseMiddelfart Sparekasse Ødsted
            "880",    //HandelsbankenHandelsbanken København
            "881",    //HandelsbankenHandelsbanken København
            "883",    //HandelsbankenHandelsbanken København
            "884",    //HandelsbankenHandelsbanken København
            "888",    //HandelsbankenHandelsbanken København
            "889",    //HandelsbankenHandelsbanken København
            "890",    //HandelsbankenHandelsbanken København K
            "891",    //HandelsbankenHandelsbanken Århus Syd
            "892",    //HandelsbankenHandelsbanken København Vest
            "893",    //HandelsbankenHandelsbanken Kolding
            "894",    //HandelsbankenHandelsbanken Odense
            "895",    //HandelsbankenHandelsbanken Kongens Lyngby
            "896",    //HandelsbankenHandelsbanken Aalborg City
            "897",    //HandelsbankenHandelsbanken Østerbro
            "898",    //HandelsbankenHandelsbanken Ballerup
            "899",    //HandelsbankenHandelsbanken Aalborg Syd
            "901",    //Unknown
            "903",    //Danske BankDanske Bank Svendborg Afdeling
            "904",    //Danske BankDanske Bank Nyborg Afdeling
            "905",    //Danske BankDanske Bank Faaborg Afdeling
            "906",    //Danske BankDanske Bank Kerteminde Afdeling
            "907",    //Danske BankDanske Bank Ringe Afdeling
            "908",    //Danske BankDanske Bank Kochsgade Afdeling
            "909",    //Danske BankDanske Bank Otterup Afdeling
            "910",    //Danske BankDanske Bank Assens Afdeling
            "913",    //Danske BankDanske Bank Aarup Afdeling
            "914",    //Danske BankDanske Bank Dalum Afdeling
            "917",    //Danske BankDanske Bank Ringe Afdeling
            "918",    //Danske BankDanske Bank Ringe Afdeling
            "922",    //Danske BankDanske Bank Aarup Afdeling
            "924",    //Danske BankDanske Bank Bogense Afdeling
            "925",    //Danske BankDanske Bank Hunderup Afdeling
            "928",    //Danske BankDanske Bank Dalum Afdeling
            "930",    //Danske BankDanske Bank Hunderup Afdeling
            "933",    //Danske BankDanske Bank Søndersø Afdeling
            "939",    //Danske BankDanske Bank Odense Afdeling
            "940",    //Danske BankDanske Bank Søndersø Afdeling
            "941",    //Danske BankDanske Bank Dalum Afdeling
            "942",    //Danske BankDanske Bank Ringe Afdeling
            "948",    //Danske BankDanske Bank Svendborg Afdeling
            "952",    //Danske BankDanske Bank Svendborg Afdeling
            "954",    //Danske BankDanske Bank Svendborg Afdeling
            "964",    //Danske BankDanske Bank Assens Afdeling
            "971",    //Danske BankDanske Bank Søndersø Afdeling
            "972",    //Danske BankDanske Bank Bogense Afdeling
            "974",    //Danske BankDanske Bank Finascenter Jylland Midt
            "975",    //Danske BankDanske Bank Kochsgade Afdeling
            "976",    //Danske BankDanske Bank Faaborg Afdeling
            "977",    //Danske BankDanske Bank Faaborg Afdeling
            "978",    //Danske BankDanske Bank Tarup Afdeling
            "979",    //Danske BankDanske Bank Kochsgade Afdeling
            "980",    //Danske BankDanske Bank Dalum Afdeling
            "981",    //Danske BankDanske Bank Middelfart Afdeling
            "982",    //Danske BankDanske Bank Middelfart Afdeling
            "983",    //Danske BankDanske Bank Faaborg Afdeling
            "985",    //Danske BankDanske Bank Lyngby Afdeling
            "987",    //Danske BankDanske Bank Erhvervscenter Fyn
            "988",    //Danske BankDanske Bank Erhvervscenter Fyn
            "989",    //Danske BankDanske Bank Erhvervscenter Sønderjylland
            "991",    //Danske BankDanske Bank Odense Afdeling
            "993",    //Danske BankDanske Bank Sjælland Syd
            "994",    //Danske BankDanske Bank Haderslev Afdeling
            "996",    //Danske BankDanske Bank Odense Afdeling
            "998",    //Danske BankDanske Bank Storkøbenhavn
            "999",    //Danske BankDanske Bank Holmens Kanal Afdeling
            "1001",    //NationalbankenNationalbanken København K
            "1003",    //NationalbankenNationalbanken København K
            "1005",    //NationalbankenNationalbanken København K
            "1011",    //NationalbankenNationalbanken København K
            "1111",    //NationalbankenNationalbanken København K
            "1171",    //Danske BankDanske Bank Posthus Service
            "1172",    //Danske BankDanske Bank Handelsfinas
            "1187",    //Saxo PrivatbankSaxo privatbank
            "1199",    //Danske BankDanske Bank København K
            "1202",    //NordeaNordea Espergærde Afdeling
            "1204",    //NordeaNordea Gilleleje Afdeling
            "1205",    //NordeaNordea Kongens Nytorv Afdeling
            "1206",    //NordeaNordea Kongens København K Afdeling
            "1207",    //NordeaNordea Hillerød Afdeling
            "1225",    //Nordea
            "1289",    //Unknown
            "1307",    //NordeaNordea Skibby Afdeling
            "1308",    //NordeaNordea Hillerød Afdeling
            "1309",    //NordeaNordea Hillerød Afdeling
            "1310",    //NordeaNordea Hillerød Afdeling
            "1315",    //NordeaNordea Birkerød Afdeling
            "1316",    //NordeaNordea Birkerød Afdeling
            "1317",    //NordeaNordea Birkerød Afdeling
            "1319",    //NordeaNordea Farum Afdeling
            "1320",    //NordeaNordea Farum Afdeling
            "1321",    //NordeaNordea Fredensborg Afdeling
            "1322",    //NordeaNordea Hillerød Afdeling
            "1323",    //NordeaNordea Stenløse Afdeling
            "1324",    //NordeaNordea Hillerød Afdeling
            "1325",    //NordeaNordea Hillerød Afdeling
            "1326",    //NordeaNordea Hillerød Afdeling
            "1328",    //NordeaNordea Hillerød Afdeling
            "1329",    //NordeaNordea Hørsholm Afdeling
            "1331",    //NordeaNordea Allerød Afdeling
            "1332",    //NordeaNordea Allerød Afdeling
            "1333",    //NordeaNordea Allerød Afdeling
            "1335",    //NordeaNordea Frederikssund Afdeling
            "1340",    //NordeaNordea Frederikssund Afdeling
            "1341",    //NordeaNordea Frederikssund Afdeling
            "1342",    //NordeaNordea Skibby Afdeling
            "1343",    //NordeaNordea Frederikssund Afdeling
            "1344",    //NordeaNordea Skibby Afdeling
            "1345",    //NordeaNordea Stenløse Afdeling
            "1347",    //NordeaNordea Skibby Afdeling
            "1348",    //NordeaNordea Stenløse Afdeling
            "1349",    //NordeaNordea Stenløse Afdeling
            "1350",    //NordeaNordea Frederiksværk Afdeling
            "1352",    //NordeaNordea Frederiksværk Afdeling
            "1353",    //NordeaNordea Frederiksværk Afdeling
            "1355",    //NordeaNordea Frederiksværk Afdeling
            "1360",    //NordeaNordea Frederiksværk Afdeling
            "1362",    //NordeaNordea Søborg Afdeling
            "1364",    //NordeaNordea Søborg Afdeling
            "1400",    //NordeaNordea Hillerød Afdeling
            "1401",    //NordeaNordea Hillerød Afdeling
            "1402",    //NordeaNordea Helsingør Afdeling
            "1403",    //NordeaNordea Helsingør Afdeling
            "1404",    //NordeaNordea Helsinge Afdeling
            "1405",    //NordeaNordea Randers Syd
            "1406",    //NordeaNordea Randers Syd
            "1407",    //NordeaNordea Helsinge Afdeling
            "1418",    //NordeaNordea Greve Afdeling
            "1420",    //NordeaNordea Vallensbæk Afdeling
            "1421",    //NordeaNordea Vallensbæk Afdeling
            "1422",    //NordeaNordea Greve Afdeling
            "1423",    //NordeaNordea Greve Afdeling
            "1424",    //NordeaNordea Greve Afdeling
            "1425",    //NordeaNordea Greve Afdeling
            "1426",    //NordeaNordea Solrød Center Afdeling
            "1428",    //NordeaNordea Solrød Center Afdeling
            "1429",    //NordeaNordea Borup Afdeling
            "1430",    //NordeaNordea Køge Afdeling
            "1432",    //NordeaNordea Køge Afdeling
            "1433",    //NordeaNordea Køge Afdeling
            "1434",    //NordeaNordea Køge Afdeling
            "1436",    //NordeaNordea Køge Afdeling
            "1437",    //NordeaNordea Køge Afdeling
            "1438",    //NordeaNordea Køge Afdeling
            "1439",    //NordeaNordea Ølby Afdeling
            "1471",    //Danske BankDanske Bank Lyngby Afdeling
            "1479",    //Danske BankDanske Bank Nørreport Afdeling
            "1481",    //Danske BankDanske Bank Brøndby Afdeling
            "1482",    //Danske BankDanske Bank Brøndby Afdeling
            "1492",    //Danske BankDanske Bank Store Kongensgade Afdeling
            "1498",    //Danske BankDanske Bank Store Kongensgade Afdeling
            "1501",    //Danske BankDanske Bank Billund Afdeling
            "1505",    //Danske BankDanske Bank Odder Afdeling
            "1506",    //Danske BankDanske Bank Vorup Afdeling
            "1507",    //Danske BankDanske Bank Skanderborg Afdeling
            "1510",    //Danske BankIkast
            "1511",    //Danske BankDanske Bank Holstebro Afdeling
            "1513",    //Danske BankDanske Bank Herning Afdeling
            "1515",    //Danske BankDanske Bank Aabenraa Afdeling
            "1517",    //Danske BankDanske Bank Viborg Afdeling
            "1519",    //Sparekassen ThySparekassen Thy Hurup Afdeling
            "1520",    //Danske BankDanske Bank Slagelse Afdeling
            "1521",    //Danske BankDanske Bank Varde Afdeling
            "1525",    //Danske BankDanske Bank Fredericia Afdeling
            "1527",    //Danske BankDanske Bank Hobro Afdeling
            "1532",    //Danske BankDanske Bank Frederikssund Afdeling
            "1533",    //Danske BankDanske Bank Børkop Afdeling
            "1535",    //Danske BankDanske Bank Risskov Afdeling
            "1536",    //Danske BankDanske Bank Aarhus Afdeling
            "1543",    //Danske BankDanske Bank Gjesing Afdeling
            "1546",    //Danske BankDanske Bank Esbjerg Afdeling
            "1548",    //Danske BankDanske Bank Frederikshavn Afdeling
            "1550",    //Danske Bank
            "1551",    //Danske Bank
            "1552",    //Danske BankDanske Bank Aalborg Afdeling
            "1559",    //Danske BankDanske Bank Sæby Afdeling
            "1560",    //Danske BankDanske Bank Sæby Afdeling
            "1562",    //Danske BankDanske Bank Randers Afdeling
            "1563",    //Danske BankDanske Bank Randers Afdeling
            "1564",    //Danske BankDanske Bank Grenaa Afdeling
            "1567",    //Danske BankDanske Bank Viby Afdeling
            "1569",    //Danske BankDanske Bank Kolding Afdeling
            "1570",    //Danske Bank
            "1577",    //Danske BankDanske Bank Hillerød Afdeling
            "1579",    //Danske BankDanske Bank Haslev Afdeling
            "1584",    //Danske BankDanske Bank Nørreport Afdeling
            "1588",    //Danske BankDanske Bank Brøndby Afdeling
            "1594",    //Danske BankDanske Bank Aarhus Afdeling
            "1597",    //Danske Bank
            "1599",    //Danske Bank
            "1601",    //Grønlandsbanken Grønlandsbanken Nuuk Afdeling
            "1621",    //Danske Bank
            "1670",    //Danske Bank
            "1671",    //BasisbankBasisbank København SV
            "1681",    //Middelfart SparekasseMiddelfart Sparekasse Hedensted
            "1682",    //Middelfart SparekasseMiddelfart Sparekasse Vinding
            "1684",    //Middelfart SparekasseMiddelfart Sparekasse Odense
            "1685",    //Middelfart SparekasseMiddelfart Sparekasse Horsens
            "1686",    //Middelfart SparekasseMiddelfart Sparekasse Esbjerg
            "1687",    //Middelfart SparekasseMiddelfart Sparekasse Aarhus
            "1693",    //PFA UdbetalingsbankPFA Udbetalingsbank København
            "1701",    //Nordea
            "1702",    //Nordea
            "1703",    //Nordea
            "1704",    //NordeaNordea Kalundborg Afdeling
            "1705",    //NordeaNordea Asnæs Afdeling
            "1706",    //NordeaNordea Asnæs Afdeling
            "1707",    //NordeaNordea Kalundborg Afdeling
            "1708",    //NordeaNordea Kalundborg Afdeling
            "1709",    //NordeaNordea Kalundborg Afdeling
            "1710",    //Nordea
            "1711",    //NordeaNordea Kalundborg Afdeling
            "1714",    //Nordea
            "1715",    //NordeaNordea Kalundborg Afdeling
            "1716",    //NordeaNordea Erhverv + Privat
            "1717",    //NordeaNordea Kalundborg Afdeling
            "1718",    //NordeaNordea Hvalsø Afdeling
            "1726",    //NordeaNordea Holbæk Afdeling
            "1727",    //NordeaNordea Erhverv + Privat
            "1728",    //NordeaNordea Erhverv + Privat
            "1729",    //NordeaNordea Erhverv + Privat
            "1730",    //Nordea
            "1732",    //NordeaNordea Erhvervsfilial København
            "1735",    //Nordea
            "1738",    //NordeaNordea Hørsholm Afdeling
            "1739",    //NordeaNordea Erhvervscenter København Vest
            "1740",    //Nordea
            "1742",    //NordeaNordea Landbrugscenter Fyn
            "1850",    //NordeaNordea Landbrugscenter Fyn
            "1901",    //NordeaNordea Aarhus Afdeling
            "1905",    //NordeaNordea Ebeltoft Afdeling
            "1908",    //NordeaNordea Grenaa Afdeling
            "1909",    //NordeaNordea Hammel Afdeling
            "1910",    //NordeaNordea Åbyhøj Afdeling
            "1911",    //NordeaNordea Hinnerup Afdeling
            "1912",    //NordeaNordea Galten Afdeling
            "1913",    //NordeaNordea Grenaa Afdeling
            "1914",    //NordeaNordea Hornslet Afdeling
            "1915",    //NordeaNordea Galten Afdeling
            "1916",    //NordeaNordea Risskov Afdeling
            "1917",    //NordeaNordea Beder Afdeling
            "1918",    //NordeaNordea Hornslet Afdeling
            "1919",    //NordeaNordea Beder Afdeling
            "1920",    //NordeaNordea Beder Afdeling
            "1922",    //Nordea
            "1924",    //NordeaNordea Lystrup Afdeling
            "1925",    //NordeaNordea Risskov Afdeling
            "1927",    //NordeaNordea Viby J. Afdeling
            "1928",    //NordeaNordea Åbyhøj Afdeling
            "1929",    //NordeaAarhus Nord Afdeling
            "1930",    //Nordea
            "1931",    //NordeaNordea Tilst Afdeling
            "1932",    //NordeaNordea Lystrup Afdeling
            "1933",    //NordeaNordea Tilst Afdeling
            "1935",    //NordeaNordea Hadsten Afdeling
            "1936",    //NordeaNordea Viby J. Afdeling
            "1938",    //NordeaNordea Silkeborg Afdeling
            "1939",    //NordeaNordea Silkeborg Afdeling
            "1941",    //Nordea
            "1944",    //NordeaNordea Odder Afdeling
            "1946",    //NordeaNordea Odder Afdeling
            "1947",    //Nordea
            "1948",    //Nordea
            "1949",    //NordeaNordea Skanderborg
            "1950",    //NordeaNordea Skanderborg
            "1951",    //NordeaNordea Søndergade Afdeling
            "1954",    //NordeaNordea Frederiksbjerg Afdeling
            "1955",    //Nordea
            "1957",    //NordeaNordea Frederiksbjerg Afdeling
            "1958",    //NordeaNordea Risskov Afdeling
            "1959",    //NordeaNordea Aarhus Afdeling
            "1969",    //Nordea
            "1970",    //NordeaNordea Aarhus Afdeling
            "1971",    //NordeaNordea Søndergade Afdeling
            "1973",    //NordeaNordea Randers Syd
            "1974",    //NordeaNordea Frederiksbjerg Afdeling
            "1978",    //NordeaNordea Aarhus N Afdeling
            "1980",    //NordeaNordea Viby J. Afdeling
            "1981",    //NordeaNordea Åbyhøj Afdeling
            "1982",    //NordeaNordea Aarhus N Afdeling
            "1984",    //NordeaNordea Åbyhøj Afdeling
            "1985",    //NordeaNordea Højbjerg Afdeling
            "1986",    //NordeaNordea Risskov Afdeling
            "1987",    //Nordea
            "1989",    //NordeaNordea Aarhus Afdeling
            "1995",    //Nordea
            "1996",    //NordeaNordea Aarhus Afdeling
            "1997",    //NordeaNordea Aarhus Afdeling
            "1998",    //NordeaNordea Aarhus Afdeling
            "2000",    //Nordea
            "2001",    //NordeaNordea Vesterport Afdeling
            "2005",    //NordeaNordea Rønne Afdeling
            "2006",    //NordeaNordea Tarup Afdeling
            "2007",    //NordeaNordea StorkundeAfdelingen Aarhus
            "2008",    //NordeaNordea Dalum Afdeling
            "2009",    //NordeaNordea Kerteminde Afdeling
            "2010",    //NordeaNordea Rønne Afdeling
            "2011",    //NordeaNordea Ejby Afdeling
            "2012",    //NordeaNordea Middelfart Afdeling
            "2013",    //NordeaNordea Nyborg Afdeling
            "2014",    //NordeaNordea Langeskov Afdeling
            "2015",    //NordeaNordea Taastrup Afdeling
            "2016",    //NordeaNordea Islands Brygge Afdeling
            "2017",    //NordeaNordea Aarup Afdeling
            "2018",    //NordeaNordea Middelfart Afdeling
            "2019",    //NordeaNordea Ejby Afdeling
            "2021",    //NordeaNordea Faaborg Afdeling
            "2022",    //Nordea
            "2024",    //NordeaNordea Assens Afdeling
            "2026",    //Nordea Finans
            "2027",    //NordeaNordea Haarby Afdeling
            "2028",    //NordeaNordea Haarby Afdeling
            "2029",    //NordeaNordea Svendborg Afdeling
            "2030",    //Nordea
            "2031",    //Nordea
            "2032",    //Nordea
            "2033",    //Nordea
            "2035",    //Nordea
            "2036",    //NordeaNordea Ringe Afdeling
            "2037",    //NordeaNordea Ollerup Afdeling
            "2038",    //NordeaNordea Nyborg Afdeling
            "2039",    //NordeaNordea Rudkøbing Afdeling
            "2040",    //Nordea
            "2041",    //NordeaNordea Rudkøbing Afdeling
            "2042",    //NordeaNordea Rudkøbing Afdeling
            "2043",    //Nordea
            "2044",    //Nordea
            "2045",    //Nordea
            "2046",    //Nordea
            "2047",    //NordeaNordea Ærø Afdeling
            "2048",    //NordeaNordea Ærø Afdeling
            "2049",    //NordeaNordea Kolding Afdeling
            "2051",    //Nordea
            "2052",    //NordeaNordea Fredericia Afdeling
            "2053",    //NordeaNordea Vejle
            "2057",    //Nordea
            "2061",    //Nordea
            "2062",    //Nordea
            "2063",    //NordeaNordea Odense Afdeling
            "2065",    //NordeaNordea Aarhus Afdeling
            "2066",    //NordeaNordea Otterup Afdeling
            "2067",    //NordeaNordea StorkundeAfdelingen Aarhus
            "2068",    //Nordea
            "2069",    //Nordea
            "2075",    //Nordea
            "2076",    //NordeaNordea Odense Afdeling
            "2077",    //Nordea
            "2080",    //Nordea
            "2081",    //Nordea
            "2082",    //Nordea
            "2086",    //Nordea
            "2087",    //Nordea
            "2088",    //Nordea
            "2089",    //Nordea
            "2091",    //Nordea
            "2093",    //Nordea
            "2094",    //Nordea
            "2096",    //Nordea
            "2097",    //Nordea
            "2100",    //Nordea
            "2101",    //Nordea
            "2102",    //NordeaNordea Kongens Nytorv Afdeling
            "2103",    //NordeaNordea Vesterport Afdeling
            "2104",    //NordeaNordea Trianglen Afdeling
            "2105",    //NordeaNordea Nørreport Afdeling
            "2106",    //NordeaNordea Vesterport Afdeling
            "2107",    //NordeaNordea Frederiksberg Afdeling
            "2108",    //NordeaNordea Vesterport Afdeling
            "2109",    //NordeaNordea Nørreport Afdeling
            "2110",    //NordeaNordea Amager Afdeling
            "2111",    //NordeaNordea Valby Afdeling
            "2112",    //NordeaNordea Falkoner Alle Afdeling
            "2113",    //NordeaNordea Svanemølle Afdeling
            "2114",    //NordeaNordea Nørrebro Afdeling
            "2115",    //NordeaNordea Enghave Afdeling
            "2116",    //NordeaNordea Hellerup Afdeling
            "2117",    //NordeaNordea Falkoner Alle Afdeling
            "2118",    //Nordea
            "2119",    //NordeaNordea Nørreport Afdeling
            "2120",    //NordeaNordea Brønshøj Afdeling
            "2121",    //NordeaNordea Erhvervsfilial København
            "2122",    //NordeaNordea Frederiksberg Afdeling
            "2123",    //NordeaNordea Nørreport Afdeling
            "2124",    //NordeaNordea Trianglen Afdeling
            "2125",    //NordeaNordea Brønshøj Afdeling
            "2126",    //NordeaNordea Hvidovre Afdeling
            "2127",    //NordeaNordea Hellerup Afdeling
            "2128",    //NordeaNordea Vanløse Afdeling
            "2129",    //NordeaNordea Valby Afdeling
            "2130",    //NordeaNordea Sundbyvester Afdeling
            "2131",    //NordeaNordea Vesterport Afdeling
            "2132",    //NordeaNordea Hvidovre Afdeling
            "2133",    //NordeaNordea Charlottenlund Afdeling
            "2134",    //NordeaNordea Valby Afdeling
            "2135",    //NordeaNordea Charlottenlund Afdeling
            "2136",    //NordeaNordea Svanemølle Afdeling
            "2137",    //NordeaNordea Nørreport Afdeling
            "2138",    //NordeaNordea Vesterport Afdeling
            "2139",    //NordeaNordea Hvidovre Afdeling
            "2140",    //Nordea
            "2141",    //Nordea
            "2142",    //NordeaNordea Vanløse Afdeling
            "2143",    //NordeaNordea Vanløse Afdeling
            "2144",    //NordeaNordea Trianglen Afdeling
            "2145",    //NordeaNordea Risskov Afdeling
            "2147",    //Nordea
            "2148",    //NordeaNordea Nørreport Afdeling
            "2149",    //NordeaNordea StorkundeAfdelingen Aarhus
            "2150",    //Nordea
            "2152",    //Nordea
            "2153",    //Nordea
            "2155",    //Nordea
            "2156",    //Nordea
            "2157",    //NordeaNordea Vesterport Afdeling
            "2159",    //NordeaNordea Thisted Afdeling
            "2161",    //Nordea
            "2162",    //Nordea
            "2164",    //Nordea
            "2165",    //NordeaNordea Vallensbæk Afdeling
            "2166",    //NordeaNordea Erhvervsfilial København
            "2168",    //NordeaNordea Erhvervsfilial København
            "2170",    //NordeaNordea Hillerød Afdeling
            "2172",    //NordeaNordea Roskilde Afdeling
            "2173",    //NordeaNordea Køge Afdeling
            "2174",    //NordeaNordea Slagelse Afdeling
            "2177",    //NordeaNordea Erhvervsfilial Sønderjylland
            "2178",    //NordeaNordea Esbjerg Afdeling
            "2181",    //NordeaNordea Aarhus Afdeling
            "2182",    //NordeaNordea Randers
            "2183",    //NordeaNordea Viborg PrivatkundeAfdeling
            "2185",    //NordeaNordea St. Heddinge Afdeling
            "2186",    //NordeaNordea Erhvervscenter København Vest
            "2187",    //Nordea
            "2189",    //Nordea
            "2190",    //NordeaNordea Kalundborg Afdeling
            "2191",    //NordeaNordea Erhvervsfilial København
            "2193",    //NordeaNordea Grenaa Afdeling
            "2194",    //Nordea
            "2195",    //Nordea
            "2196",    //NordeaNordea Erhvervsfilial København
            "2197",    //NordeaNordea Erhvervsfilial København
            "2198",    //Nordea
            "2199",    //NordeaNordea Helsingør Afdeling
            "2201",    //NordeaNordea Lyngby Afdeling
            "2202",    //Nordea
            "2203",    //NordeaNordea Køge Afdeling
            "2204",    //NordeaNordea Slagelse Afdeling
            "2205",    //Nordea
            "2206",    //Nordea
            "2207",    //Nordea
            "2208",    //Nordea
            "2209",    //NordeaNordea Brønderslev Afdeling
            "2210",    //Nordea
            "2211",    //Nordea
            "2212",    //Nordea
            "2213",    //Nordea
            "2214",    //Nordea
            "2215",    //NordeaNordea Erhvervsfilial København
            "2216",    //NordeaNordea Erhvervscenter København Vest
            "2217",    //NordeaNordea Erhvervscenter København Vest
            "2218",    //NordeaNordea Randers Syd
            "2219",    //NordeaNordea Aarhus Afdeling
            "2220",    //NordeaNordea Erhvervsfilial København
            "2222",    //NordeaNordea Erhvervscenter København Vest
            "2223",    //NordeaNordea Erhvervsfilial København
            "2224",    //NordeaNordea Erhvervscenter København Vest
            "2225",    //Unknown
            "2226",    //Nordea
            "2228",    //NordeaNordea Lyngby Afdeling
            "2229",    //NordeaNordea Lyngby Afdeling
            "2230",    //NordeaNordea Hillerød Afdeling
            "2232",    //Nordea
            "2233",    //Nordea
            "2235",    //NordeaNordea Erhvervsfilial København
            "2236",    //NordeaNordea Landbrugscenter Fyn
            "2237",    //NordeaNordea Aabenraa Afdeling
            "2239",    //NordeaNordea Erhvervsfilial Sønderjylland
            "2241",    //NordeaNordea Aarhus Afdeling
            "2242",    //NordeaNordea Erhvervsfilial København
            "2243",    //NordeaNordea Viborg PrivatkundeAfdeling
            "2245",    //NordeaNordea Erhvervsfilial Sønderjylland
            "2246",    //Nordea
            "2247",    //Nordea
            "2251",    //NordeaNordea Aarhus Afdeling
            "2252",    //NordeaNordea Lyngby Afdeling
            "2253",    //NordeaNordea Holte Afdeling
            "2254",    //NordeaNordea Lyngby Afdeling
            "2255",    //NordeaNordea Helsingør Afdeling
            "2256",    //NordeaNordea Søborg Afdeling
            "2257",    //NordeaNordea Holte Afdeling
            "2259",    //NordeaNordea Nivå Afdeling
            "2260",    //NordeaNordea Gilleleje Afdeling
            "2261",    //NordeaNordea Lyngby Afdeling
            "2262",    //NordeaNordea Herlev Afdeling
            "2263",    //NordeaNordea Hørsholm Afdeling
            "2264",    //NordeaNordea Aarhus Nord Afdeling
            "2265",    //NordeaNordea Aarhus Afdeling
            "2266",    //NordeaNordea Lyngby Afdeling
            "2267",    //NordeaNordea Risskov Afdeling
            "2268",    //NordeaNordea Birkerød Afdeling
            "2269",    //NordeaNordea Hørsholm Afdeling
            "2270",    //Nordea
            "2271",    //NordeaNordea Lyngby Afdeling
            "2272",    //Nordea
            "2273",    //NordeaNordea Frederiksberg Afdeling
            "2274",    //NordeaNordea Fredensborg Afdeling
            "2275",    //NordeaNordea Taastrup Afdeling
            "2276",    //NordeaNordea Hillerød Afdeling
            "2277",    //NordeaNordea Glostrup Afdeling
            "2278",    //NordeaNordea Aarhus Nord Afdeling
            "2279",    //NordeaNordea Ballerup Afdeling
            "2280",    //NordeaNordea Roskilde Afdeling
            "2281",    //NordeaNordea Hvalsø Afdeling
            "2282",    //NordeaNordea Viby Sj. Afdeling
            "2283",    //NordeaNordea Roskilde Afdeling
            "2284",    //NordeaNordea Viby Sj. Afdeling
            "2285",    //NordeaNordea Viby Sj. Afdeling
            "2286",    //NordeaNordea Randers Syd
            "2287",    //NordeaNordea Greve Afdeling
            "2288",    //Nordea
            "2289",    //NordeaNordea Roskilde Afdeling
            "2290",    //NordeaNordea Roskilde Afdeling
            "2291",    //NordeaNordea Jyllinge Afdeling
            "2292",    //NordeaNordea Roskilde Afdeling
            "2293",    //NordeaNordea Borup Afdeling
            "2294",    //NordeaNordea Vesterport Afdeling
            "2295",    //Nordea
            "2296",    //NordeaNordea Thisted Afdeling
            "2300",    //NordeaNordea Sorø Afdeling
            "2301",    //NordeaNordea Nexø Afdeling
            "2302",    //NordeaNordea Dianalund Afdeling
            "2305",    //NordeaNordea Hillerød Afdeling
            "2306",    //Nordea
            "2307",    //NordeaNordea Erhvervsfilial København
            "2308",    //NordeaNordea Aarhus Afdeling
            "2310",    //NordeaNordea Værløse Afdeling
            "2311",    //NordeaNordea Søborg Afdeling
            "2313",    //NordeaNordea Espergærde Afdeling
            "2314",    //NordeaNordea Skovlunde Afdeling
            "2315",    //NordeaNordea Erhvervsfilial København
            "2316",    //NordeaNordea Viby Afdeling
            "2317",    //NordeaNordea Skibby Afdeling
            "2318",    //NordeaNordea Højbjerg Afdeling
            "2320",    //NordeaNordea Faxe Afdeling
            "2321",    //NordeaNordea Faxe Afdeling
            "2322",    //NordeaNordea Faxe Afdeling
            "2323",    //Nordea
            "2324",    //NordeaNordea Rønne Afdeling
            "2325",    //NordeaNordea Aarhus Afdeling
            "2330",    //NordeaNordea Viborg Afdeling
            "2331",    //NordeaNordea Bjerringbro Afdeling
            "2332",    //NordeaNordea Viborg Afdeling
            "2334",    //NordeaNordea Viborg Afdeling
            "2335",    //NordeaNordea Viborg Afdeling
            "2336",    //NordeaNordea Aarhus Afdeling
            "2340",    //NordeaNordea St. Heddinge Afdeling
            "2341",    //NordeaNordea St. Heddinge Afdeling
            "2342",    //Nordea
            "2343",    //NordeaNordea Greve Afdeling
            "2344",    //NordeaNordea Solrød Center Afdeling
            "2346",    //NordeaNordea Roskilde Afdeling
            "2347",    //NordeaNordea Greve Afdeling
            "2348",    //NordeaNordea Allerød Afdeling
            "2350",    //NordeaNordea Aalborg Afdeling
            "2351",    //NordeaNordea Aalborg Afdeling
            "2352",    //NordeaNordea Aalborg Afdeling
            "2356",    //NordeaNordea Hadsten Afdeling
            "2358",    //NordeaNordea Erhverv + Privat
            "2360",    //NordeaNordea Køge Afdeling
            "2361",    //NordeaNordea St. Heddinge Afdeling
            "2362",    //NordeaNordea Køge Afdeling
            "2363",    //NordeaNordea Køge Afdeling
            "2364",    //NordeaNordea Borup Afdeling
            "2366",    //NordeaNordea Ølby Afdeling
            "2370",    //NordeaNordea Odense C Afdeling
            "2371",    //NordeaNordea Odense Afdeling
            "2373",    //NordeaNordea Tarup Afdeling
            "2374",    //NordeaNordea Dalum Afdeling
            "2375",    //NordeaNordea Hjallesevej Afdeling
            "2376",    //NordeaNordea Tarup Afdeling
            "2377",    //NordeaNordea Kerteminde Afdeling
            "2378",    //NordeaNordea Nordvestjylland Kredit
            "2379",    //NordeaNordea Nordvestjylland Kredit
            "2380",    //NordeaNordea Silkeborg Afdeling
            "2381",    //NordeaNordea Silkeborg Afdeling
            "2382",    //NordeaNordea Silkeborg Afdeling
            "2383",    //NordeaNordea Silkeborg Afdeling
            "2384",    //NordeaNordea Silkeborg Afdeling
            "2390",    //NordeaNordea Nordvestjylland Kredit
            "2392",    //NordeaNordea Nordvestjylland Kredit
            "2393",    //NordeaNordea Struer Afdeling
            "2400",    //NordeaNordea Slagelse Afdeling
            "2401",    //NordeaNordea Slagelse Afdeling
            "2402",    //NordeaNordea Roskilde Afdeling
            "2403",    //NordeaNordea Frederikssund Afdeling
            "2404",    //NordeaNordea Aarhus Afdeling
            "2405",    //NordeaNordea Åbyhøj Afdeling
            "2406",    //NordeaNordea Solrød Center Afdeling
            "2407",    //NordeaNordea Hellerup Afdeling
            "2408",    //NordeaNordea Søborg Afdeling
            "2409",    //NordeaNordea Risskov Afdeling
            "2410",    //NordeaNordea Albertslund Afdeling
            "2411",    //NordeaNordea Gilleleje Afdeling
            "2412",    //NordeaNordea Åbyhøj Afdeling
            "2413",    //NordeaNordea Farum Afdeling
            "2414",    //NordeaNordea Ishøj Afdeling
            "2415",    //NordeaNordea Nivå Afdeling
            "2416",    //NordeaNordea Ballerup Afdeling
            "2417",    //NordeaNordea Taastrup Afdeling
            "2418",    //NordeaNordea Helsinge Afdeling
            "2419",    //NordeaNordea Stenløse Afdeling
            "2420",    //NordeaNordea Løgstør Afdeling
            "2421",    //NordeaNordea Aars Afdeling
            "2423",    //NordeaNordea Viby Sj. Afdeling
            "2424",    //NordeaNordea Odder Afdeling
            "2425",    //NordeaNordea Horsens
            "2426",    //NordeaNordea Vordingborg Afdeling
            "2427",    //NordeaNordea Næstved Afdeling
            "2428",    //NordeaNordea Holbæk Afdeling
            "2429",    //NordeaNordea Holbæk Afdeling
            "2430",    //NordeaNordea Ribe Afdeling
            "2431",    //NordeaNordea Kalundborg Afdeling
            "2432",    //NordeaNordea Kalundborg Afdeling
            "2433",    //NordeaNordea Slagelse Afdeling
            "2434",    //NordeaNordea Rønne
            "2435",    //NordeaNordea Middelfart Afdeling
            "2436",    //NordeaNordea Nyborg Afdeling
            "2437",    //NordeaNordea Svendborg Afdeling
            "2438",    //NordeaNordea Rudkøbing Afdeling
            "2440",    //NordeaNordea Fredericia Afdeling
            "2441",    //NordeaNordea Middelfart Afdeling
            "2442",    //NordeaNordea Fredericia Afdeling
            "2443",    //NordeaNordea Fredericia Afdeling
            "2444",    //NordeaNordea Vejle Afdeling
            "2445",    //NordeaNordea Lyngby Afdeling
            "2446",    //NordeaNordea Lyngby Afdeling
            "2447",    //NordeaNordea Hørsholm Afdeling
            "2448",    //NordeaNordea Hørsholm Afdeling
            "2449",    //NordeaNordea Haderslev Afdeling
            "2450",    //NordeaNordea Holstebro
            "2451",    //NordeaNordea Rødding Afdeling
            "2452",    //NordeaNordea Toftlund Afdeling
            "2453",    //NordeaNordea Vojens Afdeling
            "2454",    //NordeaNordea Vojens Afdeling
            "2455",    //NordeaNordea Christiansfeld Afdeling
            "2456",    //NordeaNordea Erhvervsfilial Sønderjylland
            "2457",    //NordeaNordea Vojens Afdeling
            "2459",    //NordeaNordea Erhvervsfilial Sønderjylland
            "2460",    //NordeaNordea Haderslev Afdeling
            "2462",    //NordeaNordea Lemvig Afdeling
            "2463",    //NordeaNordea Holstebro
            "2464",    //NordeaNordea Birkerød Afdeling
            "2465",    //NordeaNordea Erhvervsfilial Sønderjylland
            "2466",    //NordeaNordea Holte Afdeling
            "2468",    //NordeaNordea Værløse Afdeling
            "2469",    //NordeaNordea St. Heddinge Afdeling
            "2470",    //NordeaNordea Kolding Afdeling
            "2471",    //NordeaNordea Kolding Afdeling
            "2472",    //NordeaNordea Kolding Afdeling
            "2473",    //NordeaNordea Roskilde Afdeling
            "2474",    //NordeaNordea Stenløse Afdeling
            "2475",    //NordeaNordea Skibby Afdeling
            "2480",    //NordeaNordea Rødding Afdeling
            "2481",    //NordeaNordea Landbrugscenter Sjælland
            "2482",    //NordeaNordea Landbrugscenter Sjælland
            "2483",    //NordeaNordea Vejen Afdeling
            "2484",    //NordeaNordea Landbrugscenter Sjælland
            "2490",    //NordeaNordea Maribo Afdeling
            "2491",    //NordeaNordea Maribo Afdeling
            "2492",    //NordeaNordea Maribo Afdeling
            "2495",    //NordeaNordea Erhvervscenter Jylland Nord
            "2500",    //NordeaNordea Horsens
            "2501",    //Nordea
            "2502",    //NordeaNordea Erhvervscenter Jylland Nord
            "2504",    //Nordea
            "2510",    //NordeaNordea Næstved Afdeling
            "2520",    //NordeaNordea Ringsted Afdeling
            "2521",    //NordeaNordea Ringsted Afdeling
            "2522",    //NordeaNordea Ringsted Afdeling
            "2523",    //Nordea
            "2524",    //NordeaNordea Ringsted Afdeling
            "2530",    //NordeaNordea Kalundborg Afdeling
            "2540",    //NordeaNordea Esbjerg Afdeling
            "2541",    //NordeaNordea Randers Syd
            "2543",    //Nordea
            "2550",    //NordeaNordea Vordingborg Afdeling
            "2560",    //NordeaNordea Aalestrup Afdeling
            "2561",    //NordeaNordea Viborg Afdeling
            "2562",    //NordeaNordea Viborg Afdeling
            "2570",    //NordeaNordea Herning Afdeling
            "2571",    //NordeaNordea Herning Afdeling
            "2572",    //NordeaNordea Herning Afdeling
            "2580",    //NordeaNordea Frederiksværk Afdeling
            "2589",    //Nordea
            "2590",    //NordeaNordea Landbrugscenter Sjælland
            "2591",    //NordeaNordea Rønne Afdeling
            "2592",    //NordeaNordea Maribo Afdeling
            "2593",    //NordeaNordea Rønne Afdeling
            "2594",    //NordeaNordea Erhvervscenter København Vest
            "2595",    //NordeaNordea Rønne Afdeling
            "2596",    //NordeaNordea Rønne Afdeling
            "2597",    //NordeaNordea Rønne Afdeling
            "2598",    //NordeaNordea Rønne Afdeling
            "2599",    //NordeaNordea Rønne Afdeling
            "2600",    //NordeaNordea Skive Afdeling
            "2601",    //NordeaNordea Helsingør Afdeling
            "2603",    //NordeaNordea Lyngby Afdeling
            "2610",    //NordeaNordea Frederikshavn Afdeling
            "2620",    //NordeaNordea Hjørring Afdeling
            "2630",    //NordeaNordea Vejle Afdeling
            "2640",    //NordeaNordea Skanderborg Afdeling
            "2641",    //NordeaNordea Aarhus Afdeling
            "2643",    //NordeaNordea Erhvervsfilial København
            "2644",    //NordeaNordea Erhvervsfilial København
            "2645",    //NordeaNordea Erhvervsfilial København
            "2646",    //NordeaNordea Erhvervsfilial København
            "2647",    //NordeaNordea Erhvervsfilial København
            "2648",    //NordeaNordea Hørsholm Afdeling
            "2649",    //NordeaNordea Hillerød Afdeling
            "2650",    //NordeaNordea Erhvervsfilial Hillerød
            "2651",    //NordeaNordea Landbrugscenter Lolland-Falster
            "2652",    //NordeaNordea Landbrugscenter Lolland-Falster
            "2653",    //NordeaNordea Roskilde Afdeling
            "2654",    //Nordea
            "2655",    //Nordea
            "2656",    //NordeaNordea Køge Afdeling
            "2657",    //NordeaNordea Landbrugscenter Lolland-Falster
            "2658",    //NordeaNordea Aarhus Afdeling
            "2659",    //NordeaNordea Erhvervsfilial Sønderjylland
            "2660",    //NordeaNordea Erhvervsfilial København
            "2661",    //NordeaNordea Vesterport Afdeling
            "2662",    //NordeaNordea Erhvervsfilial Sønderjylland
            "2663",    //NordeaNordea Randers Syd
            "2664",    //NordeaNordea Horsens
            "2665",    //NordeaNordea Horsens
            "2666",    //NordeaNordea Randers Syd
            "2667",    //NordeaNordea Thisted Afdeling
            "2668",    //NordeaNordea Aarhus Afdeling
            "2669",    //NordeaNordea Aarhus Afdeling
            "2670",    //NordeaNordea Frederikssund Afdeling
            "2671",    //NordeaNordea Aarhus Afdeling
            "2672",    //NordeaNordea Aarhus Afdeling
            "2673",    //NordeaNordea Viborg PrivatkundeAfdeling
            "2674",    //Nordea
            "2675",    //Nordea
            "2676",    //NordeaNordea Rønne Afdeling
            "2680",    //NordeaNordea Erhvervsfilial Svendborg
            "2690",    //NordeaNordea Grenaa Afdeling
            "2700",    //NordeaNordea Randers C
            "2701",    //NordeaNordea Randers C
            "2702",    //NordeaNordea Randers Syd
            "2703",    //NordeaNordea Randers Syd
            "2704",    //NordeaNordea Randers Syd
            "2706",    //NordeaNordea Randers Syd
            "2707",    //NordeaNordea Randers Syd
            "2709",    //NordeaNordea Hornslet Afdeling
            "2712",    //NordeaNordea Erhvervscenter Jylland Nord
            "2720",    //NordeaNordea Sønderborg Afdeling
            "2730",    //NordeaNordea Holbæk Afdeling
            "2740",    //NordeaNordea Aabenraa Afdeling
            "2750",    //NordeaNordea Haslev Afdeling
            "2752",    //NordeaNordea Haslev Afdeling
            "2760",    //NordeaNordea Ikast Afdeling
            "2761",    //NordeaNordea Kongens Nytorv Afdeling
            "2762",    //Nordea
            "2764",    //NordeaNordea Erhvervsfilial København
            "2765",    //NordeaNordea Viby Sj. Afdeling
            "2766",    //NordeaNordea Erhvervsfilial København
            "2767",    //NordeaNordea Erhvervsfilial København
            "2768",    //NordeaNordea Erhvervsfilial København
            "2769",    //NordeaNordea Hørsholm Afdeling
            "2770",    //NordeaNordea Hillerød Afdeling
            "2772",    //NordeaNordea Viby Sj. Afdeling
            "2775",    //Nordea
            "2776",    //NordeaNordea Landbrugscenter Fyn
            "2777",    //Nordea
            "2778",    //NordeaNordea Erhvervsfilial Sønderjylland
            "2779",    //NordeaNordea Aarhus Afdeling
            "2780",    //NordeaNordea Erhvervscenter Jylland Nord
            "2781",    //NordeaNordea Randers Syd
            "2783",    //NordeaNordea Viborg PrivatkundeAfdeling
            "2784",    //Nordea
            "2785",    //NordeaNordea Erhvervsfilial København
            "2786",    //NordeaNordea Erhvervsfilial København
            "2787",    //NordeaNordea Erhvervsfilial København
            "2788",    //NordeaNordea Erhvervsfilial København
            "2805",    //Nordea
            "2806",    //Nordea
            "2807",    //Nordea
            "2810",    //Nordea
            "2815",    //Nordea
            "2816",    //Nordea
            "2820",    //NordeaNordea Randers Syd
            "2821",    //NordeaNordea Randers Syd
            "2825",    //NordeaNordea Randers Syd
            "2830",    //NordeaNordea Silkeborg Afdeling
            "2831",    //Nordea
            "2835",    //Nordea
            "2840",    //NordeaNordea Erhvervscenter Jylland Nord
            "2841",    //NordeaNordea Erhvervscenter Jylland Nord
            "2845",    //NordeaNordea Erhvervscenter Jylland Nord
            "2850",    //Nordea
            "2851",    //Nordea
            "2852",    //NordeaNordea Falkoner Alle Afdeling
            "2853",    //Nordea
            "2884",    //Nordea
            "2885",    //Nordea
            "2900",    //Nordea
            "2901",    //Nordea
            "2902",    //Nordea
            "2903",    //Nordea
            "2904",    //Nordea
            "2905",    //NordeaNordea Korsør Afdeling
            "2906",    //NordeaNordea Roskilde Afdeling
            "2907",    //NordeaNordea Taastrup Afdeling
            "2908",    //NordeaNordea Køge Afdeling
            "2909",    //NordeaNordea Greve Afdeling
            "2913",    //NordeaATM Nykredit Nordea Bank
            "2915",    //Nordea
            "2916",    //NordeaATM Nykredit Nordea Bank
            "2917",    //NordeaATM Nykredit Nordea Bank
            "2918",    //Nordea
            "2919",    //Nordea
            "2920",    //Nordea
            "2922",    //Nordea
            "2924",    //Nordea
            "2925",    //Nordea
            "2926",    //Nordea
            "2927",    //Nordea
            "2928",    //Nordea
            "2930",    //NordeaNordea Kastrup Afdeling
            "2950",    //NordeaNordea Kastrup Afdeling
            "2955",    //Nordea
            "2957",    //Nordea
            "2968",    //Nordea
            "2971",    //NordeaNordea Erhvervscenter Jylland Nord
            "2972",    //NordeaNordea Randers Syd
            "2973",    //NordeaNordea Løgstør Afdeling
            "2974",    //NordeaNordea Randers Syd
            "2975",    //NordeaNordea Støvring Afdeling
            "2976",    //NordeaNordea Støvring Afdeling
            "2977",    //NordeaNordea Støvring Afdeling
            "2978",    //NordeaNordea Støvring Afdeling
            "2979",    //Nordea
            "2980",    //Nordea
            "2983",    //NordeaNordea Erhvervsfilial København
            "2984",    //Nordea
            "2985",    //Nordea
            "2986",    //Nordea
            "2987",    //Nordea
            "2988",    //Nordea
            "2989",    //Nordea
            "2991",    //NordeaNordea Rønne Afdeling
            "2996",    //NordeaNordea Erhvervsfilial København
            "3000",    //Danske Bank
            "3001",    //Danske BankDanske Bank Holmens Kanal Afdeling
            "3002",    //Danske Bank
            "3003",    //Danske BankDanske Bank Lyngby Afdeling
            "3008",    //Danske Bank
            "3010",    //Danske Bank
            "3011",    //Danske BankDanske Bank Lyngby Afdeling
            "3012",    //Danske BankDanske Bank Lyngby Afdeling
            "3013",    //Danske BankDanske Bank Aarhus Afdeling
            "3014",    //Danske Bank
            "3015",    //Danske Bank
            "3020",    //Danske Bank
            "3022",    //Danske BankDanske Bank Lyngby Afdeling
            "3024",    //Danske Bank
            "3028",    //Danske BankDanske Bank Lyngby Afdeling
            "3042",    //Danske BankDanske Bank Lyngby Afdeling
            "3043",    //Danske BankDanske Bank Lyngby Afdeling
            "3054",    //Danske Bank
            "3057",    //Danske BankDanske Bank Lyngby Afdeling
            "3058",    //Danske Bank
            "3063",    //Danske Bank
            "3066",    //Danske Bank
            "3067",    //Danske Bank
            "3068",    //Danske Bank
            "3071",    //Danske Bank
            "3073",    //Danske Bank
            "3077",    //Danske Bank
            "3091",    //Danske Bank
            "3098",    //Danske Bank
            "3100",    //Danske Bank
            "3103",    //Danske BankDanske Bank Christianshavn Afdeling
            "3106",    //Danske BankDanske Bank Gammel Kongevej Afdeling
            "3107",    //Danske BankDanske Bank Gammel Kongevej Afdeling
            "3109",    //Danske BankDanske Bank Hellerup Afdeling
            "3110",    //Danske Bank
            "3112",    //Danske BankDanske Bank Bagsværd Afdeling
            "3113",    //Danske BankDanske Bank Nørreport Afdeling
            "3114",    //Danske BankDanske Bank Støvring Afdeling
            "3115",    //Danske BankDanske Bank Nørrebro Afdeling
            "3117",    //Danske BankDanske Bank Søborg Afdeling
            "3118",    //Danske BankDanske Bank Valby Afdeling
            "3121",    //Danske BankDanske Bank Østerbro Afdeling
            "3123",    //Danske BankDanske Bank Lyngbyvej Afdeling
            "3124",    //Danske BankDanske Bank Halmtorv Afdeling
            "3128",    //Danske BankDanske Bank Bagsværd Afdeling
            "3129",    //Danske BankDanske Bank Taastrup Afdeling
            "3130",    //Danske BankDanske Bank Glostrup Afdeling
            "3134",    //Danske BankDanske Bank Frederikssundsvej Afdeling
            "3137",    //Danske Bank
            "3138",    //Danske BankDanske Bank Ballerup
            "3139",    //Danske BankDanske Bank Ballerup
            "3140",    //Danske BankDanske Bank Bagsværd Afdeling
            "3141",    //Danske BankDanske Bank Bagsværd Afdeling
            "3143",    //Danske Bank
            "3144",    //Danske BankDanske Bank Aarhus Afdeling
            "3146",    //Danske BankDanske Bank Aarhus Afdeling
            "3148",    //Danske BankDanske Bank Amager Afdeling
            "3149",    //Danske BankDanske Bank Tårnby Afdeling
            "3152",    //Danske BankDanske Bank Aalborg Afdeling
            "3154",    //Danske BankDanske Bank Aalborg Afdeling
            "3155",    //Danske BankDanske Bank Aalborg Afdeling
            "3156",    //Danske BankDanske Bank Nørrebro Afdeling
            "3159",    //Danske BankDanske Bank Ballerup
            "3161",    //Danske BankDanske Bank Lyngby Afdeling
            "3162",    //Danske BankDanske Bank Lyngby Afdeling
            "3163",    //Danske BankDanske Bank Helsingør Afdeling
            "3164",    //Danske BankDanske Bank Halmtorv Afdeling
            "3167",    //Danske BankDanske Bank Farum Afdeling
            "3168",    //Danske BankDanske Bank Frederikssund Afdeling
            "3169",    //Danske BankDanske Bank Værløse Afdeling
            "3170",    //Danske BankDanske Bank Hørsholm Afdeling
            "3171",    //Danske BankDanske Bank Hørsholm Afdeling
            "3172",    //Danske BankDanske Bank Helsingør Afdeling
            "3173",    //Danske BankDanske Bank Bagsværd Afdeling
            "3174",    //Danske BankDanske Bank Bagsværd Afdeling
            "3175",    //Danske BankDanske Bank Odense Afdeling
            "3177",    //Danske BankDanske Bank - Vallensbæk Afdeling
            "3178",    //Danske BankDanske Bank Taastrup Afdeling
            "3183",    //Danske BankDanske Bank Espergærde Afdeling
            "3185",    //Danske BankDanske Bank Tårnby Afdeling
            "3186",    //Danske BankDanske Bank Brønshøj Afdeling
            "3188",    //Danske BankDanske Bank Bagsværd Afdeling
            "3191",    //Danske Bank
            "3193",    //Danske BankDanske Bank Fredericia Afdeling
            "3194",    //Danske BankDanske Bank - Albertslund Afdeling
            "3198",    //Danske BankDanske Bank Lyngby Afdeling
            "3199",    //Danske BankDanske Bank Islands Brygge Afdeling
            "3201",    //Danske BankDanske Bank Aalborg Afdeling
            "3203",    //Danske BankDanske Bank Esbjerg Afdeling
            "3204",    //Danske Bank
            "3205",    //Danske BankDanske Bank Fredericia Afdeling
            "3206",    //Danske BankDanske Bank Torvet Afdeling
            "3208",    //Danske BankDanske Bank Holbæk Afdeling
            "3211",    //Danske BankDanske Bank Kolding Afdeling
            "3212",    //Danske BankDanske Bank Korsør Afdeling
            "3215",    //Danske BankDanske Bank - Maribo Afdeling
            "3216",    //Danske BankDanske Bank Nyborg Afdeling
            "3217",    //Danske BankDanske Bank - Langeskov Afdeling
            "3218",    //Danske BankDanske Bank Nyborg Afdeling
            "3219",    //Danske BankDanske Bank Nykøbing F Afdeling
            "3221",    //Danske BankDanske Bank Nykøbing F Afdeling
            "3222",    //Danske BankDanske Bank Maribo Afdeling
            "3223",    //Danske BankDanske Bank Maribo Afdeling
            "3224",    //Danske BankDanske Bank Svendborg Afdeling
            "3225",    //Danske BankDanske Bank Svendborg Afdeling
            "3226",    //Danske BankDanske Bank Svendborg Afdeling
            "3227",    //Danske BankDanske Bank Sønderborg Afdeling
            "3229",    //Danske BankDanske Bank Holbæk Afdeling
            "3230",    //Danske BankDanske Bank Tønder Afdeling
            "3231",    //Danske BankDanske Bank Vejle Afdeling
            "3232",    //Danske BankDanske Bank Børkop Afdeling
            "3234",    //Danske BankDanske Bank Esbjerg Afdeling
            "3238",    //Danske Bank
            "3241",    //Danske BankDanske Bank - Rønde Afdeling
            "3243",    //Danske BankDanske Bank Vejgaard Afdeling
            "3244",    //Danske BankDanske Bank - Rønde Afdeling
            "3251",    //Danske BankDanske Bank Holmens Kanal Afdeling
            "3256",    //Danske BankDanske Bank Nyborg Afdeling
            "3259",    //Danske BankDanske Bank Støvring Afdeling
            "3262",    //Danske BankDanske Bank Vejle Afdeling
            "3263",    //Danske Bank
            "3264",    //Danske BankDanske Bank Thisted Afdeling
            "3265",    //Danske BankDanske Bank Nykøbing Sjælland Afdeling
            "3266",    //Danske BankDanske Bank Aalborg Afdeling
            "3269",    //Danske BankDanske Bank - Nørresundby Afdeling
            "3271",    //Danske BankDanske Bank Fredericia Afdeling
            "3282",    //Danske BankDanske Bank Hasseris Afdeling
            "3283",    //Danske BankDanske Bank Prismet Afdeling
            "3285",    //Danske BankDanske Bank Nykøbing F Afdeling
            "3287",    //Danske BankDanske Bank Kolding Afdeling
            "3288",    //Danske BankDanske Bank Vejle Afdeling
            "3291",    //Danske BankDanske Bank Aars Afdeling
            "3296",    //Danske BankDanske Bank Aabybro Afdeling
            "3306",    //Danske BankDanske Bank Frederiksberg Afdeling
            "3307",    //Danske BankDanske Bank Hvidovre Afdeling
            "3312",    //Danske BankDanske Bank Rødovre Centrum Afdeling
            "3315",    //Danske Bank
            "3316",    //Danske BankDanske Bank Nørrebro Afdeling
            "3318",    //Danske BankDanske Bank Københavns Lufthavn Afdeling
            "3319",    //Danske Bank
            "3321",    //Danske BankDanske Bank Nørrebro Afdeling
            "3322",    //Danske BankDanske Bank Ballerup
            "3324",    //Danske Bank
            "3325",    //Danske BankDanske Bank Nærumvænge Afdeling
            "3326",    //Danske BankDanske Bank Ishøj Afdeling
            "3333",    //Danske Bank
            "3334",    //Danske BankDanske Bank Vordingborg Afdeling
            "3336",    //Danske BankDanske Bank Hellerup Afdeling
            "3338",    //Danske BankDanske Bank Bagsværd Afdeling
            "3341",    //Danske BankDanske Bank Lyngby Afdeling
            "3344",    //Danske Bank
            "3345",    //Danske BankDanske Bank Holmens Kanal Afdeling
            "3346",    //Danske BankDanske Bank Lyngbyvej Afdeling
            "3347",    //Danske BankDanske Bank Holte Afdeling
            "3348",    //Danske BankDanske Bank Brøndby Afdeling
            "3349",    //Danske BankDanske Bank Solrød Afdeling
            "3350",    //Danske BankDanske Bank Hvidovre Afdeling
            "3357",    //Danske BankDanske Bank Ballerup
            "3359",    //Danske BankDanske Bank Lyngby Afdeling
            "3361",    //Danske BankDanske Bank Amager Afdeling
            "3386",    //Danske BankDanske Bank Middelfart Afdeling
            "3387",    //Danske Bank
            "3390",    //Danske Bank
            "3391",    //Danske BankDanske Bank Lyngby Afdeling
            "3395",    //Danske Bank
            "3401",    //Danske BankDanske Bank Vejgaard Afdeling
            "3404",    //Danske BankDanske Bank Herning Afdeling
            "3405",    //Danske BankDanske Bank Lyngby Afdeling
            "3406",    //Danske BankDanske Bank Ikast Afdeling
            "3408",    //Danske BankDanske Bank Egå Afdeling
            "3409",    //Danske Bank
            "3411",    //Danske Bank
            "3412",    //Danske BankDanske Bank Bjerringbro Afdeling
            "3415",    //Danske BankDanske Bank Thisted Afdeling
            "3416",    //Danske BankDanske Bank Hurup Afdeling
            "3420",    //Danske BankDanske Bank Middelfart Afdeling
            "3421",    //Danske BankDanske Bank Middelfart Afdeling
            "3426",    //Danske BankDanske Bank Fredericia Afdeling
            "3427",    //Danske BankDanske Bank Seest Afdeling
            "3428",    //Danske BankDanske Bank Aalborg Afdeling
            "3429",    //Danske BankDanske Bank Roskilde Afdeling
            "3430",    //Danske BankDanske Bank Frederikssund Afdeling
            "3431",    //Danske BankDanske Bank Frederikssund Afdeling
            "3433",    //Danske BankDanske Bank Ølstykke Afdeling
            "3434",    //Danske BankDanske Bank Stenløse Afdeling
            "3437",    //Danske Bank
            "3439",    //Danske BankDanske Bank Ølstykke Afdeling
            "3440",    //Danske BankDanske Bank Haderslev Afdeling
            "3443",    //Danske BankDanske Bank Vordingborg Afdeling
            "3445",    //Danske BankDanske Bank Esbjerg Afdeling
            "3448",    //Danske BankDanske Bank Hirtshals Afdeling
            "3449",    //Danske Bank
            "3453",    //Danske BankDanske Bank Lyngby Afdeling
            "3457",    //Danske BankDanske Bank Sorø Afdeling
            "3462",    //Danske BankDanske Bank Varde Afdeling
            "3463",    //Danske BankDanske Bank Frederikshavn Afdeling
            "3467",    //Danske BankDanske Bank Lyngby Afdeling
            "3470",    //Danske BankDanske Bank Randers Afdeling
            "3479",    //Danske BankDanske Bank Randers Afdeling
            "3480",    //Danske Bank
            "3482",    //Danske Bank
            "3487",    //Danske BankDanske Bank Herning Afdeling
            "3489",    //Danske Bank
            "3490",    //Danske Bank
            "3506",    //Danske Bank
            "3507",    //Danske Bank
            "3508",    //Danske BankDanske Bank Store Kongensgade Afdeling
            "3509",    //Danske BankDanske Bank Bagsværd Afdeling
            "3511",    //Danske BankDanske Bank Slagelse Afdeling
            "3512",    //Danske BankDanske Bank Sorø Afdeling
            "3515",    //Danske BankDanske Bank Slagelse Afdeling
            "3517",    //Danske BankDanske Bank Lyngby Afdeling
            "3523",    //Danske BankDanske Bank Skælskør Afdeling
            "3525",    //Danske BankDanske Bank Ringsted Afdeling
            "3530",    //Danske BankDanske Bank Køge Afdeling
            "3531",    //Danske BankDanske Bank Sønderborg Afdeling
            "3534",    //Danske BankDanske Bank Tønder Afdeling
            "3537",    //Danske BankDanske Bank Gilleleje Afdeling
            "3543",    //Danske BankDanske Bank Hillerød Afdeling
            "3544",    //Danske BankDanske Bank Fredensborg Afdeling
            "3545",    //Danske BankDanske Bank Helsinge Afdeling
            "3555",    //Danske BankDanske Bank Holbæk Afdeling
            "3556",    //Danske BankDanske Bank Holbæk Afdeling
            "3562",    //Danske BankDanske Bank Holbæk Afdeling
            "3565",    //Danske BankDanske Bank Nykøbing Sjælland Afdeling
            "3566",    //Danske BankDanske Bank Asnæs Afdeling
            "3567",    //Danske BankDanske Bank Asnæs Afdeling
            "3568",    //Danske BankDanske Bank Nykøbing Sjælland Afdeling
            "3569",    //Danske BankDanske Bank Nykøbing Sjælland Afdeling
            "3572",    //Danske BankDanske Bank Frederiksværk Afdeling
            "3573",    //Danske BankDanske Bank Frederiksværk Afdeling
            "3574",    //Danske BankDanske Bank Odense Afdeling
            "3575",    //Danske BankDanske Bank Kochsgade Afdeling
            "3577",    //Danske BankDanske Bank Tarup Afdeling
            "3578",    //Danske BankDanske Bank Odense Afdeling
            "3586",    //Danske BankDanske Bank Ringe Afdeling
            "3588",    //Danske BankDanske Bank Haderslev Afdeling
            "3590",    //Danske BankDanske Bank Aabenraa Afdeling
            "3591",    //Danske BankDanske Bank Hunderup Afdeling
            "3596",    //Danske BankDanske Bank Kerteminde Afdeling
            "3597",    //Danske BankDanske Bank Aarup Afdeling
            "3600",    //Danske BankDanske Bank Kerteminde Afdeling
            "3603",    //Danske BankDanske Bank Lyngby Afdeling
            "3604",    //Danske Bank
            "3606",    //Danske Bank
            "3609",    //Danske Bank
            "3610",    //Danske Bank
            "3611",    //Danske Bank
            "3612",    //Danske BankDanske Bank Assens Afdeling
            "3613",    //Danske Bank
            "3614",    //Danske Bank
            "3616",    //Danske BankDanske Bank Holmens Kanal Afdeling
            "3618",    //Danske BankDanske Bank Vejle Afdeling
            "3619",    //Danske BankDanske Bank Kochsgade Afdeling
            "3627",    //Danske BankDanske Bank Aarhus Afdeling
            "3628",    //Danske Bank
            "3629",    //Danske Bank
            "3631",    //Danske BankDanske Bank Frederiksbjerg Afdeling
            "3632",    //Danske Bank
            "3633",    //Danske BankDanske Bank Universitets Afdeling
            "3635",    //Danske BankDanske Bank Universitets Afdeling
            "3636",    //Danske BankDanske Bank Frederiksbjerg Afdeling
            "3638",    //Danske Bank
            "3639",    //Danske BankDanske Bank Egå Afdeling
            "3640",    //Danske Bank
            "3642",    //Danske Bank
            "3643",    //Danske BankDanske Bank Brabrand Afdeling
            "3645",    //Danske BankDanske Bank Brabrand Afdeling
            "3647",    //Danske BankDanske Bank Hammel Afdeling
            "3648",    //Danske BankDanske Bank Hinnerup Afdeling
            "3649",    //Danske BankDanske Bank Højbjerg Afdeling
            "3651",    //Danske BankDanske Bank Ebeltoft Afdeling
            "3652",    //Danske BankDanske Bank Egå Afdeling
            "3654",    //Danske BankDanske Bank Bagsværd Afdeling
            "3655",    //Danske Bank
            "3656",    //Danske BankDanske Bank Viby Afdeling
            "3657",    //Danske BankDanske Bank Risskov Afdeling
            "3661",    //Danske BankDanske Bank Viby Afdeling
            "3667",    //Danske BankDanske Bank Store Kongensgade Afdeling
            "3668",    //Danske BankDanske Bank Bagsværd Afdeling
            "3671",    //Danske Bank
            "3672",    //Danske Bank
            "3673",    //Danske BankDanske Bank Bagsværd Afdeling
            "3674",    //Danske BankDanske Bank Bagsværd Afdeling
            "3675",    //Danske BankDanske Bank Skanderborg Afdeling
            "3678",    //Danske BankDanske Bank Viby Afdeling
            "3679",    //Danske BankDanske Bank Ry Afdeling
            "3683",    //Danske BankDanske Bank Bagsværd Afdeling
            "3684",    //Danske BankDanske Bank Lyngby Afdeling
            "3685",    //Danske Bank
            "3686",    //Danske Bank
            "3688",    //Danske Bank
            "3695",    //Danske BankDanske Bank Bagsværd Afdeling
            "3696",    //Danske BankDanske Bank Vejgaard Afdeling
            "3697",    //Danske BankDanske Bank Hasseris Afdeling
            "3698",    //Danske BankDanske Bank Hasseris Afdeling
            "3701",    //Danske BankDanske Bank Hasseris Afdeling
            "3702",    //Danske BankDanske Bank Hasseris Afdeling
            "3703",    //Danske BankDanske Bank Holmens Kanal Afdeling
            "3705",    //Danske BankDanske Bank Brønderslev Afdeling
            "3706",    //Danske Bank
            "3708",    //Danske BankDanske Bank Hobro Afdeling
            "3710",    //Danske BankDanske Bank Aars Afdeling
            "3711",    //Danske BankDanske Bank Støvring Afdeling
            "3714",    //Danske BankDanske Bank Aabybro Afdeling
            "3724",    //Danske BankDanske Bank Nibe Afdeling
            "3730",    //Danske Bank
            "3733",    //Danske BankDanske Bank Kolding Afdeling
            "3734",    //Danske BankDanske Bank Varde Afdeling
            "3735",    //Danske BankDanske Bank Lyngby Afdeling
            "3737",    //Danske BankDanske Bank Vejen Afdeling
            "3738",    //Danske BankDanske Bank Vejen Afdeling
            "3740",    //Danske BankDanske Bank Skive Afdeling
            "3741",    //Danske BankDanske Bank Lyngby Afdeling
            "3742",    //Danske BankDanske Bank Hillerød Afdeling
            "3743",    //Danske BankDanske Bank Bagsværd Afdeling
            "3747",    //Danske BankDanske Bank Bagsværd Afdeling
            "3748",    //Danske Bank
            "3750",    //Danske Bank
            "3767",    //Danske BankDanske Bank Rødovre Centrum Afdeling
            "3775",    //Danske BankDanske Bank Lyngby Afdeling
            "3776",    //Danske Bank
            "3777",    //Danske Bank
            "3778",    //Danske Bank
            "3779",    //Danske Bank
            "3783",    //Danske Bank
            "3784",    //Danske Bank
            "3785",    //Danske Bank
            "3786",    //Danske BankDanske Bank Lyngby Afdeling
            "3787",    //Danske BankDanske Bank Lyngby Afdeling
            "3788",    //Danske BankDanske Bank Lyngby Afdeling
            "3789",    //Danske BankDanske Bank Lyngby Afdeling
            "3809",    //Danske BankDanske Bank Store Kongensgade Afdeling
            "3824",    //Danske BankDanske Bank Lyngby Afdeling
            "3825",    //Danske Bank
            "3827",    //Danske Bank
            "3828",    //Danske Bank
            "3829",    //Danske Bank
            "3830",    //Danske Bank
            "3837",    //Danske BankDanske Bank Lyngby Afdeling
            "3838",    //Danske Bank
            "3840",    //Danske Bank
            "3845",    //Danske BankDanske Bank Vejen Afdeling
            "3846",    //Danske BankDanske Bank Brabrand Afdeling
            "3858",    //Danske Bank
            "3860",    //Danske Bank
            "3861",    //Danske BankDanske Bank Lyngby Afdeling
            "3862",    //Danske Bank
            "3864",    //Danske BankDanske Bank Lyngby Afdeling
            "3868",    //Danske BankDanske Bank Lyngby Afdeling
            "3873",    //Danske Bank
            "3874",    //Danske Bank
            "3880",    //Danske BankDanske Bank Store Kongensgade Afdeling
            "3881",    //Danske Bank
            "3882",    //Danske BankDanske Bank Lyngby Afdeling
            "3883",    //Danske BankDanske Bank Lyngby Afdeling
            "3884",    //Danske BankDanske Bank Lyngby Afdeling
            "3885",    //Danske BankDanske Bank Lyngby Afdeling
            "3886",    //Danske Bank
            "3887",    //Danske Bank
            "3896",    //Danske Bank
            "3900",    //Unknown
            "3901",    //Danske Bank
            "3903",    //Danske Bank
            "3913",    //Danske BankDanske Bank Lyngby Afdeling
            "3914",    //Danske BankDanske Bank Nyborg Afdeling
            "3920",    //Danske Bank
            "3921",    //Danske BankDanske Bank Lyngby Afdeling
            "3922",    //Danske BankDanske Bank Aalborg Afdeling
            "3924",    //Danske Bank
            "3925",    //Danske Bank
            "3928",    //Danske BankDanske Bank Lyngby Afdeling
            "3930",    //Danske Bank
            "3931",    //Danske BankDanske Bank Lyngby Afdeling
            "3936",    //Danske Bank
            "3939",    //Danske Bank
            "3940",    //Danske Bank
            "3941",    //Danske Bank
            "3943",    //Danske Bank
            "3945",    //Danske BankDanske Bank Lyngby Afdeling
            "3946",    //Danske BankDanske Bank Lyngby Afdeling
            "3947",    //Danske Bank
            "3948",    //Danske Bank
            "3950",    //Danske BankDanske Bank Lyngby Afdeling
            "3952",    //Danske Bank
            "3954",    //Danske BankDanske Bank Amager Afdeling
            "3956",    //Danske Bank
            "3958",    //Danske Bank
            "3970",    //Danske Bank
            "3981",    //Danske Bank
            "3985",    //Danske Bank
            "3991",    //Danske Bank
            "3993",    //Danske BankDanske Bank Lyngby Afdeling
            "3996",    //Danske Bank
            "3999",    //Danske Bank
            "4000",    //Danske Bank
            "4001",    //Danske BankDanske Bank Holmens Kanal Afdeling
            "4002",    //Danske Bank
            "4003",    //Danske Bank
            "4014",    //Danske BankDanske Bank Odense Afdeling
            "4015",    //Danske Bank
            "4020",    //Danske Bank
            "4023",    //Danske Bank
            "4024",    //Danske BankDanske Bank Helsingør Afdeling
            "4025",    //Danske BankDanske Bank Hillerød Afdeling
            "4027",    //Danske BankDanske Bank Store Kongensgade Afdeling
            "4028",    //Danske BankDanske Bank Lyngby Afdeling
            "4029",    //Danske BankDanske Bank Nykøbing F Afdeling
            "4030",    //Danske BankDanske Bank Næstved Afdeling
            "4031",    //Danske BankDanske Bank Roskilde Afdeling
            "4032",    //Danske BankDanske Bank Ringsted Afdeling
            "4033",    //Danske BankDanske Bank Glostrup Afdeling
            "4037",    //Danske BankDanske Bank Esbjerg Afdeling
            "4038",    //Danske BankDanske Bank Thisted Afdeling
            "4039",    //Danske BankDanske Bank Odense Afdeling
            "4040",    //Danske Bank
            "4041",    //Danske BankDanske Bank Fredericia Vest Afdeling
            "4045",    //Danske BankDanske Bank Hjørring Afdeling
            "4046",    //Danske BankDanske Bank Bagsværd Afdeling
            "4047",    //Danske BankDanske Bank Aalborg Afdeling
            "4048",    //Danske BankDanske Bank Bagsværd Afdeling
            "4049",    //Danske BankDanske Bank Herning Afdeling
            "4050",    //Danske BankDanske Bank Randers Afdeling
            "4051",    //Danske BankDanske Bank Bagsværd Afdeling
            "4052",    //Danske BankDanske Bank Frederikshavn Afdeling
            "4053",    //Danske BankDanske Bank Silkeborg Afdeling
            "4054",    //Danske BankDanske Bank Vejle Afdeling
            "4057",    //Danske BankDanske Bank Bagsværd Afdeling
            "4061",    //Danske Bank
            "4064",    //Danske Bank
            "4065",    //Danske BankDanske Bank Rødovre Centrum Afdeling
            "4066",    //Danske BankDanske Bank Bagsværd Afdeling
            "4067",    //Danske BankDanske Bank Esbjerg Afdeling
            "4070",    //Danske BankDanske Bank Hvidovre Afdeling
            "4072",    //Danske BankDanske Bank Lyngby Afdeling
            "4073",    //Danske BankDanske Bank Lyngby Afdeling
            "4076",    //Danske BankDanske Bank Bagsværd Afdeling
            "4083",    //Danske BankDanske Bank Frederiksberg Afdeling
            "4085",    //Danske BankDanske Bank Tårnby Afdeling
            "4089",    //Danske BankDanske Bank Børkop Afdeling
            "4090",    //Danske Bank
            "4092",    //Danske BankDanske Bank Odense Afdeling
            "4095",    //Danske Bank
            "4099",    //Danske BankDanske Bank Peter Bangs Vej Afdeling
            "4120",    //Danske BankDanske Bank Hellerup Afdeling
            "4130",    //Danske BankDanske Bank Birkerød Afdeling
            "4133",    //Danske BankDanske Bank Bagsværd Afdeling
            "4160",    //Danske BankDanske Bank Frederikssundsvej Afdeling
            "4180",    //Danske BankDanske Bank Nytorv Afdeling
            "4183",    //Danske BankDanske Bank Store Kongensgade Afdeling
            "4188",    //Danske BankDanske Bank Bagsværd Afdeling
            "4189",    //Danske BankDanske Bank Nytorv Afdeling
            "4190",    //Danske BankDanske Bank Gentofte Afdeling
            "4200",    //Danske BankDanske Bank Grøndals Afdeling
            "4201",    //Danske BankDanske Bank Charlottenlund Afdeling
            "4205",    //Danske BankDanske Bank Gentofte Afdeling
            "4230",    //Danske Bank
            "4236",    //Unknown
            "4250",    //Danske BankDanske Bank Peter Bangs Vej Afdeling
            "4260",    //Danske BankDanske Bank Lyngby Afdeling
            "4263",    //Danske BankDanske Bank Lyngby Afdeling
            "4278",    //Danske BankDanske Bank Bagsværd Afdeling
            "4279",    //Danske BankDanske Bank Nørreport Afdeling
            "4280",    //Danske BankDanske Bank Nørrebro Afdeling
            "4282",    //Danske BankDanske Bank Store Kongensgade Afdeling
            "4284",    //Danske Bank
            "4287",    //Danske Bank
            "4300",    //Danske BankDanske Bank Charlottenlund Afdeling
            "4309",    //Danske Bank
            "4310",    //Danske BankDanske Bank Store Kongensgade Afdeling
            "4312",    //Danske BankDanske Bank Bagsværd Afdeling
            "4314",    //Danske BankDanske Bank Helsingør Afdeling
            "4315",    //Danske BankDanske Bank Svendborg Afdeling
            "4316",    //Danske Bank
            "4317",    //Danske BankDanske Bank Roskilde Afdeling
            "4319",    //Danske BankDanske Bank Odense Nord Afdeling
            "4330",    //Danske BankDanske Bank Nordhavn Afdeling
            "4336",    //Danske BankDanske Bank Bagsværd Afdeling
            "4343",    //Danske Bank
            "4348",    //Danske BankDanske Bank Bagsværd Afdeling
            "4356",    //Danske BankDanske Bank Hillerød Afdeling
            "4363",    //Danske BankDanske Bank Frederikssund Afdeling
            "4366",    //Danske Bank
            "4368",    //Danske Bank
            "4380",    //Danske BankDanske Bank Vanløse Afdeling
            "4383",    //Danske BankDanske Bank Næstved Afdeling
            "4386",    //Danske BankDanske Bank Nykøbing F Afdeling
            "4387",    //Danske Bank
            "4394",    //Danske Bank
            "4396",    //Danske BankDanske Bank Lyngby Afdeling
            "4398",    //Danske BankDanske Bank Holbæk Afdeling
            "4400",    //Danske BankDanske Bank Vesterport Afdeling
            "4401",    //Danske Bank
            "4403",    //Danske BankDanske Bank Kalundborg Afdeling
            "4406",    //Danske BankDanske Bank Slagelse Afdeling
            "4420",    //Danske BankDanske Bank Herlev Afdeling
            "4424",    //Danske BankDanske Bank Køge Afdeling
            "4425",    //Danske Bank
            "4426",    //Danske BankDanske Bank Ringsted Afdeling
            "4434",    //Danske BankDanske Bank Glostrup Afdeling
            "4440",    //Danske BankDanske Bank Glostrup Afdeling
            "4444",    //Danske BankDanske Bank Ballerup
            "4447",    //Danske Bank
            "4448",    //Danske Bank
            "4450",    //Danske Bank
            "4451",    //Danske BankDanske Bank Rønne Afdeling
            "4453",    //Danske BankDanske Bank Nytorv Afdeling
            "4460",    //Danske BankDanske Bank Grøndals Afdeling
            "4467",    //Danske BankDanske Bank Lyngby Afdeling
            "4480",    //Danske BankDanske Bank Stenløse Afdeling
            "4485",    //Danske BankDanske Bank Stenløse Afdeling
            "4490",    //Danske BankDanske Bank Virum-Sorgenfri Afdeling
            "4496",    //Danske BankDanske Bank Vejle Afdeling
            "4498",    //Danske Bank
            "4511",    //Danske BankDanske Bank Greve Afdeling
            "4515",    //Danske BankDanske Bank Brøndby Afdeling
            "4530",    //Danske BankDanske Bank Tre Falke Afdeling
            "4540",    //Danske BankDanske Bank Toftegårds Alle Afdeling
            "4560",    //Danske BankDanske Bank Nordhavn Afdeling
            "4571",    //Unknown
            "4580",    //Danske Bank
            "4582",    //Danske Bank
            "4584",    //Danske BankDanske Bank Lyngby Afdeling
            "4585",    //Danske BankDanske Bank Dragør Afdeling
            "4587",    //Danske BankDanske Bank Lyngby Afdeling
            "4592",    //Danske BankDanske Bank Bagsværd Afdeling
            "4595",    //Danske BankDanske Bank Odense Nord Afdeling
            "4596",    //Danske Bank
            "4597",    //Danske Bank
            "4598",    //Danske Bank
            "4605",    //Danske BankDanske Bank Odense Nord Afdeling
            "4606",    //Danske Bank
            "4610",    //Danske BankDanske Bank Sønderborg Afdeling
            "4611",    //Danske Bank
            "4619",    //Danske BankDanske Bank Støvring Afdeling
            "4620",    //Danske BankDanske Bank Rådhus Afdeling
            "4625",    //Danske BankDanske Bank Risskov Afdeling
            "4629",    //Danske BankDanske Bank Højbjerg Afdeling
            "4630",    //Danske Bank
            "4633",    //Danske BankDanske Bank Odder Afdeling
            "4634",    //Danske Bank
            "4640",    //Danske Bank
            "4644",    //Danske BankDanske Bank Gjesing Afdeling
            "4645",    //Danske BankDanske Bank Gjesing Afdeling
            "4649",    //Danske BankDanske Bank Grøndals Afdeling
            "4650",    //Danske BankDanske Bank Sønderborg Afdeling
            "4652",    //Danske BankDanske Bank Padborg Afdeling
            "4657",    //Danske BankDanske Bank Billund Afdeling
            "4660",    //Danske Bank
            "4662",    //Danske BankDanske Bank Aalborg Afdeling
            "4663",    //Danske BankDanske Bank Thisted Afdeling
            "4665",    //Danske BankDanske Bank Herning Afdeling
            "4669",    //Danske BankDanske Bank Bagsværd Afdeling
            "4671",    //Danske BankDanske Bank Vojens Afdeling
            "4672",    //Danske BankDanske Bank Støvring Afdeling
            "4676",    //Danske BankDanske Bank Lyngby Afdeling
            "4681",    //Danske BankDanske Bank Randers Afdeling
            "4690",    //Danske BankDanske Bank Kalundborg Afdeling
            "4691",    //Danske BankDanske Bank Holbæk Afdeling
            "4692",    //Danske BankDanske Bank Ringe Afdeling
            "4695",    //Danske BankDanske Bank Aarhus Afdeling
            "4701",    //Danske Bank
            "4703",    //Danske BankDanske Bank Hunderup Afdeling
            "4710",    //Danske BankDanske Bank Randers Afdeling
            "4713",    //Danske Bank
            "4716",    //Danske BankDanske Bank Silkeborg Afdeling
            "4720",    //Danske BankDanske Bank Rønne Afdeling
            "4727",    //Danske BankDanske Bank Horsens Afdeling
            "4728",    //Danske BankDanske Bank Herning Afdeling
            "4731",    //Danske BankDanske Bank Sønderborg Afdeling
            "4733",    //Danske BankDanske Bank Vejle Afdeling
            "4735",    //Danske Bank
            "4736",    //Danske BankDanske Bank Fredericia Vest Afdeling
            "4738",    //Danske Bank
            "4739",    //Danske Bank
            "4745",    //Danske BankDanske Bank Hjørring Afdeling
            "4747",    //Danske BankDanske Bank Bagsværd Afdeling
            "4754",    //Danske Bank
            "4756",    //Danske Bank
            "4757",    //Danske Bank
            "4759",    //Danske Bank
            "4760",    //Danske BankDanske Bank Varde Afdeling
            "4761",    //Danske BankDanske Bank Lyngby Afdeling
            "4762",    //Danske Bank
            "4763",    //Danske Bank
            "4768",    //Unknown
            "4770",    //Danske BankDanske Bank Viborg Afdeling
            "4772",    //Danske BankDanske Bank Viborg Afdeling
            "4779",    //Danske BankDanske Bank Aarhus Afdeling
            "4780",    //Danske BankDanske Bank Frederikshavn Afdeling
            "4782",    //Danske BankDanske Bank Skagen Afdeling
            "4784",    //Danske BankDanske Bank Thisted Afdeling
            "4791",    //Danske BankDanske Bank Hørsholm Afdeling
            "4799",    //Danske Bank
            "4808",    //Danske BankDanske Bank Bagsværd Afdeling
            "4814",    //Danske BankDanske Bank Lyngby Afdeling
            "4815",    //Danske BankDanske Bank Rådhus Afdeling
            "4817",    //Danske Bank
            "4818",    //Danske BankDanske Bank Ringsted Afdeling
            "4820",    //Danske BankDanske Bank Allerød Afdeling
            "4836",    //Danske Bank
            "4841",    //Danske BankDanske Bank Lyngby Afdeling
            "4842",    //Danske Bank
            "4845",    //Danske BankDanske Bank Helsinge Afdeling
            "4860",    //Danske BankDanske Bank Tønder Afdeling
            "4865",    //Danske BankDanske Bank Køge Afdeling
            "4866",    //Danske BankDanske Bank Solrød Afdeling
            "4868",    //Danske BankDanske Bank Køge Afdeling
            "4875",    //Danske BankDanske Bank Maribo Afdeling
            "4880",    //Danske BankDanske Bank Vordingborg Afdeling
            "4897",    //Danske Bank
            "4899",    //Danske Bank
            "4900",    //Danske BankDanske Bank Nykøbing F Afdeling
            "4904",    //Danske Bank
            "4905",    //Danske BankDanske Bank Næstved Afdeling
            "4907",    //Danske BankDanske Bank Aalborg Afdeling
            "4908",    //Danske BankDanske Bank Lyngby Afdeling
            "4912",    //Danske BankDanske Bank Bagsværd Afdeling
            "4913",    //Danske Bank
            "4915",    //Danske Bank
            "4916",    //Danske Bank
            "4917",    //Danske BankDanske Bank Støvring Afdeling
            "4918",    //Danske Bank
            "4920",    //Danske BankDanske Bank Ebeltoft Afdeling
            "4921",    //Danske BankDanske Bank Støvring Afdeling
            "4922",    //Danske BankDanske Bank Bagsværd Afdeling
            "4923",    //Danske BankDanske Bank Fredericia Vest Afdeling
            "4925",    //Danske BankDanske Bank Holstebro Afdeling
            "4927",    //Danske Bank
            "4928",    //Danske Bank
            "4929",    //Danske BankDanske Bank Odense Nord Afdeling
            "4930",    //Danske Bank
            "4932",    //Danske Bank
            "4936",    //Danske BankDanske Bank Holstebro Afdeling
            "4940",    //Danske BankDanske Bank Brønderslev Afdeling
            "4945",    //Danske BankDanske Bank Struer Afdeling
            "4951",    //Danske BankDanske Bank Korsør Afdeling
            "4955",    //Danske BankDanske Bank Ringsted Afdeling
            "4956",    //Danske Bank
            "4957",    //Nordania Leasing Bank
            "4971",    //Danske BankDanske Bank Lyngby Afdeling
            "5002",    //Jyske Bank
            "5005",    //Jyske Bank
            "5006",    //Jyske Bank
            "5007",    //Jyske Bank
            "5009",    //Jyske BankJyske Bank Holstebro, St. Torv
            "5010",    //Jyske BankJyske Bank Vesterbrogade
            "5011",    //Jyske Bank
            "5012",    //Jyske Bank
            "5013",    //Jyske BankJyske Bank Østerbro
            "5014",    //Jyske BankJyske Bank Ordrup
            "5015",    //Jyske BankJyske Bank Amager
            "5016",    //Jyske Bank
            "5017",    //Jyske Bank
            "5018",    //Jyske Bank
            "5019",    //Jyske Bank
            "5020",    //Jyske Bank
            "5021",    //Jyske Bank
            "5022",    //Jyske Bank
            "5023",    //Jyske BankJyske Bank Farum
            "5024",    //Jyske BankJyske Bank Nørrebro
            "5025",    //Jyske Bank
            "5026",    //Jyske Bank
            "5027",    //Jyske Bank
            "5028",    //Jyske Bank
            "5029",    //Jyske BankJyske Bank Hjørring
            "5030",    //Jyske Bank
            "5031",    //Jyske Bank
            "5032",    //Jyske Bank
            "5033",    //Jyske BankJyske Bank Aalborg Nytorv
            "5034",    //Jyske Bank
            "5035",    //Jyske Bank
            "5036",    //Jyske Bank
            "5037",    //Jyske Bank
            "5038",    //Jyske Bank
            "5039",    //Jyske Bank
            "5040",    //Jyske Bank
            "5041",    //Jyske Bank
            "5042",    //Jyske BankJyske Bank Charlottenlund
            "5043",    //Jyske Bank
            "5044",    //Jyske Bank
            "5045",    //Jyske Bank
            "5046",    //Jyske BankJyske Bank Silkeborg Alderslyst
            "5047",    //Jyske BankJyske Bank Brønshøj
            "5050",    //Jyske Bank
            "5051",    //Jyske BankJyske Bank Odense Erhverv
            "5052",    //Jyske Bank
            "5053",    //Jyske BankJyske Bank Dalum
            "5054",    //Jyske BankJyske Bank Svendborg
            "5055",    //Jyske Bank
            "5056",    //Jyske Bank
            "5057",    //Jyske BankJyske Bank Silkeborg Alderslyst
            "5058",    //Jyske Bank
            "5059",    //Jyske BankJyske Bank Aalborg Erhverv
            "5060",    //Jyske BankJyske Bank Odense Erhverv
            "5061",    //Jyske BankJyske Bank Aarhus Østergade Privat
            "5062",    //Jyske BankJyske Bank Greve
            "5063",    //Jyske BankJyske Bank Allerød
            "5064",    //Jyske Bank
            "5065",    //Jyske BankJyske Bank Roskilde
            "5066",    //Jyske Bank
            "5067",    //Jyske BankJyske Bank Nykøbing F.
            "5068",    //Jyske Bank
            "5069",    //Jyske Bank
            "5071",    //Jyske Bank
            "5072",    //Jyske Bank
            "5073",    //Jyske BankJyske Bank Aarhus Østergade Privat
            "5074",    //Jyske BankJyske Bank Christiansbjerg
            "5075",    //Jyske Bank
            "5076",    //Jyske Bank
            "5077",    //Jyske Bank
            "5078",    //Jyske BankJyske Bank København Erhverv
            "5079",    //Jyske BankJyske Bank Aalborg Erhverv
            "5081",    //Jyske Bank
            "5084",    //Jyske Bank
            "5085",    //Jyske Bank
            "5087",    //Jyske Bank
            "5090",    //Jyske Bank
            "5091",    //Jyske Bank
            "5093",    //Jyske BankJyske Bank Ribe
            "5095",    //Jyske BankJyske Bank Esbjerg
            "5096",    //Jyske Bank
            "5097",    //Jyske BankJyske Bank København Erhverv
            "5098",    //Jyske Bank
            "5099",    //Jyske Bank
            "5100",    //Citibank International Plc.
            "5130",    //HSH Nordbank AG Filial (closed)
            "5140",    //Finansbanken
            "5170",    //Unknown
            "5190",    //FS Bank
            "5191",    //FS Bank
            "5192",    //FS Bank
            "5195",    //FS Bank
            "5201",    //FS Bank
            "5202",    //FS Bank
            "5203",    //FS Bank
            "5204",    //FS Bank
            "5205",    //FS Bank
            "5206",    //FS Bank
            "5207",    //FS Bank
            "5208",    //FS Bank
            "5209",    //FS Bank
            "5210",    //FS Bank
            "5211",    //FS Bank
            "5212",    //FS Bank
            "5213",    //FS Bank
            "5214",    //FS Bank
            "5215",    //FS Bank
            "5217",    //FS Bank
            "5218",    //FS Bank
            "5220",    //FS Bank
            "5221",    //FS Bank
            "5222",    //FS Bank
            "5223",    //FS Bank
            "5224",    //FS Bank
            "5225",    //FS Bank
            "5226",    //FS Bank
            "5227",    //FS Bank
            "5228",    //FS Bank
            "5229",    //FS Bank
            "5230",    //FS Bank
            "5231",    //FS Bank
            "5252",    //
            "5290",    //Dnb Bank Asa
            "5292",    //Sparekassen Sjælland
            "5295",    //Skandinaviska Enskilda Banken
            "5301",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5302",    //Arbejdernes Landsbank
            "5303",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5304",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5305",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5306",    //Arbejdernes Landsbank
            "5308",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5310",    //Arbejdernes LandsbankArbejdernes Landsbank Glostrup
            "5311",    //Arbejdernes LandsbankArbejdernes Landsbank Odense
            "5312",    //Arbejdernes LandsbankArbejdernes Landsbank Aarhus
            "5321",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5322",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5323",    //Arbejdernes LandsbankArbejdernes Landsbank Bispebjerg
            "5324",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5325",    //Arbejdernes LandsbankArbejdernes Landsbank Kongelundsvej
            "5326",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5327",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5328",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5329",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5330",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5331",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5332",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5333",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5336",    //Arbejdernes LandsbankArbejdernes Landsbank Enghave Plads
            "5338",    //Arbejdernes LandsbankArbejdernes Landsbank Frederiksberg
            "5339",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5341",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5342",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5343",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5344",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5345",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5346",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5347",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5348",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5349",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5350",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5351",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5352",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5353",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5354",    //Arbejdernes LandsbankArbejdernes Landsbank Nordals
            "5355",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5356",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5357",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5358",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5359",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5360",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5361",    //Arbejdernes Landsbank
            "5362",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5363",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5364",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5365",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5366",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5367",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5368",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5371",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5372",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5377",    //Arbejdernes Landsbank
            "5378",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5379",    //Arbejdernes Landsbank
            "5380",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5381",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5382",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5383",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5384",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5385",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5386",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5387",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5388",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5389",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5390",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5391",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5392",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5393",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5394",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5395",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5396",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5397",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5398",    //Arbejdernes LandsbankArbejdernes Landsbank Amager
            "5400",    //Sydbank
            "5420",    //The Royal Bank of Scotland
            "5426",    //Alfred Berg Bank A/S
            "5451",    //Sammenslutningen af Danske Andelskasser
            "5470",    //Nykredit Bank
            "5471",    //Nykredit BankNykredit Tåstrup Privat
            "5472",    //Nykredit BankNykredit Privat Ballerup
            "5473",    //Nykredit BankNykredit Tåstrup Privat
            "5474",    //Nykredit BankNykredit Privat Charlottenlund
            "5475",    //Nykredit BankNykredit Privat Rødovre
            "5476",    //Nykredit BankNykredit Privat Frederiksberg
            "5478",    //Nykredit BankNykredit Privat Hellerup
            "5479",    //Nykredit Bank
            "5490",    //Nykredit BankNykredit Privat Hørsholm
            "5491",    //Nykredit BankNykredit Privat Birkerød
            "5492",    //Nykredit BankNykredit Privat Hillerød
            "5493",    //Nykredit BankNykredit Privat Østerbro
            "5494",    //Nykredit BankNykredit Privat Helsingør
            "5495",    //Nykredit BankNykredit Privat Århus
            "5496",    //Nykredit Bank
            "5499",    //Nykredit Bank
            "5501",    //NordeaNordea Vesterport Afdeling
            "5502",    //Nordea
            "5503",    //NordeaNordea Farum Afdeling
            "5504",    //NordeaNordea Hørsholm Afdeling
            "5505",    //NordeaNordea Herlev Afdeling
            "5506",    //NordeaNordea Ballerup Afdeling
            "5507",    //NordeaNordea Lyngby Afdeling
            "5508",    //NordeaNordea Vesterport Afdeling
            "5509",    //NordeaNordea Ballerup Afdeling
            "5510",    //NordeaNordea Glostrup Afdeling
            "5512",    //NordeaNordea Glostrup Afdeling
            "5513",    //NordeaNordea Vallensbæk Afdeling
            "5514",    //NordeaNordea Glostrup Afdeling
            "5515",    //Nordea
            "5516",    //NordeaNordea Albertslund Afdeling
            "5518",    //NordeaNordea Hvidovre Afdeling
            "5520",    //NordeaNordea Hillerød Afdeling
            "5521",    //NordeaNordea Helsinge Afdeling
            "5523",    //Nordea
            "5524",    //Nordea
            "5525",    //Nordea
            "5526",    //NordeaNordea Brovst Afdeling
            "5529",    //NordeaNordea Brønderslev Afdeling
            "5530",    //NordeaNordea Støvring Afdeling
            "5531",    //NordeaNordea Støvring Afdeling
            "5532",    //NordeaNordea Støvring Afdeling
            "5533",    //NordeaNordea Støvring Afdeling
            "5534",    //NordeaNordea Aalborg Afdeling
            "5535",    //NordeaNordea Aalborg Afdeling
            "5537",    //NordeaNordea Aalborg Afdeling
            "5538",    //NordeaNordea Aalborg Afdeling
            "5539",    //NordeaNordea Brovst Afdeling
            "5540",    //NordeaNordea Silkeborg Afdeling
            "5541",    //NordeaNordea Silkeborg Afdeling
            "5542",    //NordeaNordea Silkeborg Afdeling
            "5543",    //NordeaNordea Silkeborg Afdeling
            "5545",    //NordeaNordea Vejle
            "5546",    //NordeaNordea Give
            "5547",    //NordeaNordea Give
            "5548",    //NordeaNordea Give
            "5550",    //NordeaNordea Vejle
            "5551",    //NordeaNordea Vejle
            "5552",    //Nordea
            "5553",    //NordeaNordea Vejle
            "5555",    //NordeaNordea Rønne Afdeling
            "5556",    //NordeaNordea Rønne Afdeling
            "5558",    //Nordea
            "5559",    //NordeaNordea Rønne
            "5562",    //NordeaNordea Rønne
            "5563",    //NordeaNordea Rønne Afdeling
            "5565",    //NordeaNordea Odense Afdeling
            "5567",    //NordeaNordea Søndersø Afdeling
            "5568",    //NordeaNordea Tarup Afdeling
            "5570",    //Nordea
            "5572",    //Nordea
            "5574",    //NordeaNordea Grenaa Afdeling
            "5575",    //Nordea
            "5578",    //NordeaNordea Hjørring Afdeling
            "5580",    //NordeaNordea Aarhus Afdeling
            "5581",    //Nordea
            "5582",    //NordeaNordea Viby Sj. Afdeling
            "5583",    //NordeaNordea Hornslet Afdeling
            "5584",    //NordeaNordea Viby Sj. Afdeling
            "5585",    //Nordea
            "5586",    //NordeaNordea Galten Afdeling
            "5588",    //NordeaNordea Lystrup Afdeling
            "5591",    //NordeaNordea Åbyhøj Afdeling
            "5592",    //NordeaNordea Hornslet Afdeling
            "5594",    //NordeaNordea Lystrup Afdeling
            "5595",    //NordeaNordea Roskilde Afdeling
            "5596",    //NordeaNordea Viby Sj. Afdeling
            "5597",    //Nordea
            "5598",    //NordeaNordea Roskilde Afdeling
            "5600",    //Nordea
            "5601",    //Nordea
            "5603",    //NordeaNordea Nørre Alslev Afdeling
            "5605",    //NordeaNordea Køge Afdeling
            "5606",    //NordeaNordea St. Heddinge Afdeling
            "5607",    //NordeaNordea Ølby Afdeling
            "5608",    //NordeaNordea Køge Afdeling
            "5609",    //NordeaNordea Solrød Center Afdeling
            "5610",    //NordeaNordea Esbjerg Afdeling
            "5611",    //NordeaNordea Esbjerg Afdeling
            "5612",    //Nordea
            "5613",    //NordeaNordea Esbjerg Afdeling
            "5615",    //NordeaNordea Helsingør Afdeling
            "5616",    //Nordea
            "5620",    //NordeaNordea Randers Syd
            "5621",    //NordeaNordea Randers Syd
            "5622",    //NordeaNordea Randers Syd
            "5623",    //NordeaNordea Hadsten Afdeling
            "5624",    //NordeaNordea Randers Syd
            "5625",    //NordeaNordea Randers Syd
            "5627",    //Nordea
            "5629",    //Nordea
            "5630",    //NordeaNordea Rudkøbing Afdeling
            "5631",    //NordeaNordea Rudkøbing Afdeling
            "5632",    //NordeaNordea Rudkøbing Afdeling
            "5633",    //NordeaNordea Rudkøbing Afdeling
            "5634",    //Nordea
            "5635",    //NordeaNordea Struer Afdeling
            "5637",    //Nordea
            "5640",    //NordeaNordea Landbrugscenter Lolland-Falster
            "5641",    //NordeaNordea Nørre Alslev Afdeling
            "5642",    //NordeaNordea Sakskøbing Afdeling
            "5643",    //NordeaNordea Nørre Alslev Afdeling
            "5645",    //NordeaNordea Sakskøbing Afdeling
            "5647",    //Nordea
            "5648",    //Nordea
            "5650",    //NordeaNordea Viborg PrivatkundeAfdeling
            "5651",    //NordeaNordea Bjerringbro Afdeling
            "5653",    //Nordea
            "5655",    //NordeaNordea Brønderslev Afdeling
            "5656",    //NordeaNordea Brønderslev Afdeling
            "5658",    //NordeaNordea Aarhus Afdeling
            "5659",    //NordeaNordea Lemvig Afdeling
            "5660",    //NordeaNordea Kalundborg Afdeling
            "5661",    //NordeaNordea Erhvervscenter København Vest
            "5663",    //NordeaNordea Kalundborg Afdeling
            "5664",    //NordeaNordea Kalundborg Afdeling
            "5665",    //NordeaNordea Skanderborg
            "5666",    //Nordea
            "5667",    //NordeaNordea Ry Afdeling
            "5670",    //NordeaNordea Frederiksberg Afdeling
            "5671",    //NordeaNordea Trianglen Afdeling
            "5675",    //NordeaNordea Bjerringbro Afdeling
            "5677",    //NordeaNordea Amager Afdeling
            "5678",    //NordeaNordea Kongens Nytorv Afdeling
            "5680",    //NordeaNordea Erhvervsfilial Sønderjylland
            "5682",    //NordeaNordea Rødding Afdeling
            "5683",    //NordeaNordea Vojens Afdeling
            "5686",    //Nordea
            "5690",    //NordeaNordea Løgstør Afdeling
            "5694",    //NordeaNordea Aars Afdeling
            "5695",    //NordeaNordea Svendborg Afdeling
            "5697",    //NordeaNordea Svendborg Afdeling
            "5698",    //NordeaNordea Svendborg Afdeling
            "5699",    //NordeaNordea Ollerup Afdeling
            "5700",    //NordeaNordea Svendborg Afdeling
            "5702",    //NordeaNordea Ollerup Afdeling
            "5704",    //NordeaNordea Svendborg Afdeling
            "5705",    //Nordea
            "5706",    //NordeaNordea Erhverv + Privat
            "5707",    //Nordea
            "5710",    //Nordea
            "5711",    //Nordea
            "5714",    //Nordea
            "5715",    //NordeaNordea Frederikssund Afdeling
            "5716",    //NordeaNordea Frederikssund Afdeling
            "5717",    //NordeaNordea Skibby Afdeling
            "5719",    //NordeaNordea Stenløse Afdeling
            "5720",    //NordeaNordea Ringsted Afdeling
            "5722",    //NordeaNordea Ringsted Afdeling
            "5723",    //NordeaNordea Landbrugscenter Sjælland
            "5726",    //NordeaNordea Gentofte Afdeling
            "5730",    //Nordea
            "5732",    //NordeaNordea Vejen Afdeling
            "5733",    //NordeaNordea Vejen Afdeling
            "5735",    //NordeaNordea Rødding Afdeling
            "5736",    //NordeaNordea Charlottenlund Afdeling
            "5738",    //Nordea
            "5739",    //NordeaNordea StorkundeAfdelingen Aarhus
            "5740",    //Nordea
            "5742",    //NordeaNordea Risskov Afdeling
            "5743",    //NordeaNordea Hadsten Afdeling
            "5744",    //NordeaNordea Hinnerup Afdeling
            "5749",    //Nordea
            "5750",    //NordeaNordea Varde Afdeling
            "5751",    //NordeaNordea Grindsted Afdeling
            "5752",    //NordeaNordea Varde Afdeling
            "5753",    //NordeaNordea Varde Afdeling
            "5760",    //Nordea
            "5762",    //NordeaNordea Rødekro Afdeling
            "5763",    //NordeaNordea Rødekro Afdeling
            "5764",    //Nordea
            "5768",    //Nordea
            "5772",    //NordeaNordea Ringe Afdeling
            "5773",    //NordeaNordea Tarup Afdeling
            "5774",    //NordeaNordea Kochsgade Afdeling
            "5775",    //NordeaNordea Dalum Afdeling
            "5779",    //NordeaNordea Rønne Afdeling
            "5780",    //NordeaNordea Haslev Afdeling
            "5781",    //NordeaNordea Charlottenlund Afdeling
            "5785",    //Nordea
            "5787",    //NordeaNordea Hammel Afdeling
            "5790",    //NordeaNordea Vordingborg Afdeling
            "5791",    //NordeaNordea Vordingborg Afdeling
            "5800",    //NordeaNordea Thisted Afdeling
            "5801",    //NordeaNordea Thisted Afdeling
            "5803",    //NordeaNordea Thisted Afdeling
            "5804",    //NordeaNordea Herning Afdeling
            "5807",    //NordeaNordea Hellerup Afdeling
            "5808",    //NordeaNordea Hellerup Afdeling
            "5810",    //NordeaNordea Asnæs Afdeling
            "5811",    //NordeaNordea Asnæs Afdeling
            "5812",    //NordeaNordea Rønne
            "5813",    //NordeaNordea Værløse Afdeling
            "5815",    //NordeaNordea Kjellerup Afdeling
            "5819",    //NordeaNordea Nivå Afdeling
            "5820",    //NordeaNordea Hillerød Afdeling
            "5821",    //NordeaNordea Hellerup Afdeling
            "5822",    //NordeaNordea Stenløse Afdeling
            "5825",    //NordeaNordea Lyngby Afdeling
            "5826",    //NordeaNordea Erhvervsfilial København
            "5827",    //NordeaNordea Birkerød Afdeling
            "5834",    //NordeaNordea Maribo Afdeling
            "5835",    //NordeaNordea Erhverv + Privat
            "5844",    //NordeaNordea Hjallesevej Afdeling
            "5850",    //NordeaNordea Silkeborg Afdeling
            "5855",    //NordeaNordea Erhverv + Privat
            "5860",    //NordeaNordea Sønderborg Afdeling
            "5862",    //NordeaNordea Sønderborg Afdeling
            "5863",    //NordeaNordea Hinnerup Afdeling
            "5864",    //NordeaNordea Holte Afdeling
            "5867",    //Nordea
            "5870",    //NordeaNordea Hadsten Afdeling
            "5875",    //Nordea
            "5880",    //NordeaNordea Randers Syd
            "5881",    //NordeaNordea Maribo Afdeling
            "5882",    //NordeaNordea Vejen Afdeling
            "5890",    //NordeaNordea Herning Afdeling
            "5900",    //Nordea
            "5908",    //NordeaATM Nykredit Nordea Bank
            "5910",    //NordeaNordea Åbyhøj Afdeling
            "5911",    //NordeaNordea Risskov Afdeling
            "5912",    //NordeaNordea Frederiksbjerg Afdeling
            "5913",    //NordeaNordea Erhvervsfilial København
            "5915",    //NordeaNordea Odder Afdeling
            "5916",    //NordeaNordea Risskov Afdeling
            "5917",    //NordeaNordea Højbjerg Afdeling
            "5919",    //NordeaNordea Åbyhøj Afdeling
            "5920",    //NordeaNordea Fredericia Afdeling
            "5922",    //NordeaNordea Fredericia Afdeling
            "5923",    //NordeaNordea Højbjerg Afdeling
            "5929",    //NordeaNordea Thisted Afdeling
            "5930",    //NordeaNordea Skive Afdeling
            "5932",    //Nordea
            "5934",    //Nordea
            "5935",    //Nordea
            "5938",    //NordeaNordea Aalborg Afdeling
            "5939",    //NordeaNordea Aars Afdeling
            "5941",    //NordeaNordea Hadsten Afdeling
            "5942",    //NordeaNordea Aalborg Afdeling
            "5944",    //NordeaNordea Aalborg Afdeling
            "5947",    //NordeaNordea Vesterport Afdeling
            "5948",    //NordeaNordea Brønderslev Afdeling
            "5949",    //NordeaNordea Maribo Afdeling
            "5950",    //Danske Andelskassers Bank
            "5951",    //Danske Andelskassers Bank
            "5952",    //Danske Andelskassers Bank
            "5953",    //Danske Andelskassers Bank
            "5954",    //Danske Andelskassers Bank
            "5955",    //Danske Andelskassers Bank
            "5957",    //Danske Andelskassers Bank
            "5958",    //Faster Andelskasse
            "5959",    //Danske Andelskassers Bank
            "5960",    //Frørup Andelskasse
            "5961",    //Danske Andelskassers Bank
            "5966",    //Danske Andelskassers Bank
            "5967",    //Danske Andelskassers Bank
            "5969",    //Danske Andelskassers Bank
            "5970",    //Danske Andelskassers Bank
            "5971",    //Danske Andelskassers Bank
            "5974",    //Danske Andelskassers Bank
            "5975",    //Danske Andelskassers Bank
            "5976",    //Danske Andelskassers Bank
            "5977",    //Danske Andelskassers Bank
            "5979",    //Danske Andelskassers Bank
            "5980",    //Danske Andelskassers Bank
            "5982",    //Danske Andelskassers Bank
            "5983",    //Danske Andelskassers Bank
            "5984",    //Danske Andelskassers Bank
            "5985",    //Danske Andelskassers Bank
            "5986",    //Danske Andelskassers Bank
            "5987",    //Danske Andelskassers Bank
            "5988",    //Sparekassen Faaborg
            "5989",    //Danske Andelskassers Bank
            "5990",    //Danske Andelskassers Bank
            "5991",    //Danske Andelskassers Bank
            "5993",    //Danske Andelskassers Bank
            "5994",    //Danske Andelskassers Bank
            "5995",    //Danske Andelskassers Bank
            "5996",    //Danske Andelskassers Bank
            "5997",    //Danske Andelskassers Bank
            "5998",    //Danske Andelskassers Bank
            "5999",    //Danske Andelskassers Bank
            "6004",    //Swedbank
            "6010",    //Cargill Bank
            "6011",    //Swedbank
            "6060",    //Diba Bank
            "6070",    //Sparekassen SjællandSparekassen Sjælland Nykøbing Sj.
            "6075",    //Sparekassen SjællandSparekassen Sjælland Næstved
            "6085",    //Sparekassen SjællandSparekassen Sjælland København S
            "6100",    //Skandinaviska Enskilda Banken
            "6110",    //Sparekassen Kronjylland
            "6111",    //Sparekassen Kronjylland
            "6112",    //Sparekassen Kronjylland
            "6113",    //Sparekassen Kronjylland
            "6114",    //Sparekassen Kronjylland
            "6115",    //Sparekassen Kronjylland
            "6116",    //Sparekassen Kronjylland
            "6117",    //Sparekassen Kronjylland
            "6119",    //Sparekassen Kronjylland
            "6120",    //Sparekassen Kronjylland
            "6121",    //Sparekassen Kronjylland
            "6122",    //Sparekassen Kronjylland
            "6123",    //Sparekassen Kronjylland
            "6124",    //Sparekassen Kronjylland
            "6125",    //Sparekassen Kronjylland
            "6126",    //Sparekassen Kronjylland
            "6127",    //Sparekassen Kronjylland
            "6128",    //Sparekassen Kronjylland
            "6129",    //Sparekassen Kronjylland
            "6130",    //Sparekassen Kronjylland
            "6132",    //Sparekassen Kronjylland
            "6140",    //Møns Bank
            "6150",    //Sparekassen SjællandSparekassen Sjælland Skælskør
            "6160",    //FS Bank
            "6180",    //Sparekassen Kronjylland
            "6181",    //Sparekassen Kronjylland
            "6182",    //Sparekassen Kronjylland
            "6183",    //Sparekassen Kronjylland
            "6184",    //Sparekassen Kronjylland
            "6185",    //Sparekassen Kronjylland
            "6186",    //Sparekassen Kronjylland
            "6187",    //Sparekassen KronjyllandSparekassen Kronjylland
            "6188",    //Sparekassen Kronjylland
            "6189",    //Sparekassen Kronjylland
            "6190",    //Sparekassen Kronjylland
            "6191",    //Sparekassen Kronjylland
            "6192",    //Sparekassen Kronjylland
            "6193",    //Sparekassen Kronjylland
            "6194",    //Sparekassen Kronjylland
            "6220",    //Vordingborg Bank
            "6230",    //Sparekassen Kronjylland
            "6231",    //Sparekassen Kronjylland
            "6260",    //Jyske Bank
            "6261",    //Jyske Bank
            "6262",    //Jyske Bank
            "6263",    //Jyske Bank
            "6264",    //Jyske BankJyske Bank Nykøbing F.
            "6265",    //Jyske BankJyske Bank Holstebro, St. Torv
            "6267",    //Jyske BankJyske Bank Silkeborg Alderslyst
            "6268",    //Jyske Bank
            "6300",    //Handelsbanken
            "6301",    //Handelsbanken
            "6302",    //Handelsbanken
            "6326",    //Jyske Bank
            "6327",    //Jyske Bank
            "6328",    //Jyske Bank
            "6329",    //Jyske Bank
            "6330",    //Jyske Bank
            "6331",    //Jyske Bank
            "6332",    //Jyske Bank
            "6423",    //Danske Bank
            "6424",    //Danske Bank
            "6425",    //Danske Bank
            "6460",    //BankNordik
            "6471",    //Grønlandsbanken A/S
            "6482",    //Brfkredit Bank A/S
            "6483",    //Handelsbanken
            "6484",    //HandelsbankenHandelsbanken Herning City
            "6485",    //Handelsbanken
            "6486",    //Handelsbanken
            "6487",    //Handelsbanken
            "6488",    //Handelsbanken
            "6489",    //Handelsbanken
            "6490",    //Handelsbanken
            "6491",    //Handelsbanken
            "6492",    //Handelsbanken
            "6493",    //Handelsbanken
            "6494",    //HandelsbankenHandelsbanken Hammerum
            "6495",    //Handelsbanken
            "6496",    //Handelsbanken
            "6499",    //Handelsbanken
            "6500",    //Handelsbanken
            "6503",    //BankNordik
            "6504",    //BankNordikBankNordik Amager
            "6505",    //BankNordikBankNordik Amager
            "6506",    //BankNordikBankNordik Amager
            "6507",    //BankNordikBankNordik Amager
            "6508",    //BankNordikBankNordik Dragør
            "6509",    //BankNordikBankNordik Amager
            "6510",    //BankNordikBankNordik Kongelundsvej
            "6511",    //BankNordikBankNordik Østerbro
            "6512",    //BankNordikBankNordik Frederiksberg
            "6513",    //BankNordikBankNordik Lyngby
            "6514",    //BankNordikBankNordik Frederiksberg
            "6515",    //BankNordikBankNordik Hvidovre
            "6516",    //BankNordikBankNordik Aarhus
            "6520",    //Lollands Bank
            "6525",    //Lollands Bank
            "6532",    //Unknown
            "6540",    //FS Bank
            "6541",    //FS Bank
            "6542",    //FS Bank
            "6543",    //FS Bank
            "6610",    //Jyske Bank
            "6620",    //Coop Bank A/S
            "6735",    //Sydbank
            "6736",    //Sydbank
            "6737",    //Sydbank
            "6738",    //Sydbank
            "6739",    //Sydbank
            "6743",    //Sydbank
            "6748",    //Sydbank
            "6749",    //Sydbank
            "6771",    //Lægernes Pensionsbank A/S
            "6810",    //Sydbank
            "6812",    //SydbankSydbank Viborg
            "6813",    //Sydbank
            "6814",    //SydbankSydbank Ballerup
            "6815",    //Sydbank
            "6816",    //Sydbank
            "6817",    //Sydbank
            "6818",    //SydbankSydbank Greve
            "6819",    //Sydbank
            "6820",    //Sydbank
            "6821",    //Sydbank
            "6822",    //Sydbank
            "6823",    //Sydbank
            "6824",    //Sydbank
            "6825",    //Sydbank
            "6826",    //Sydbank
            "6840",    //Sydbank
            "6845",    //Sydbank
            "6847",    //Sydbank
            "6848",    //SydbankSydbank Landbrugscenter Østjylland
            "6850",    //Vestfyns Bank A/S
            "6851",    //Vestfyns Bank A/S
            "6852",    //Vestfyns Bank A/S
            "6853",    //Vestfyns Bank A/S
            "6854",    //Vestfyns Bank A/S
            "6855",    //Vestfyns Bank A/S
            "6856",    //Vestfyns Bank A/S
            "6860",    //Nordfyns Bank A/S
            "6861",    //Nordfyns Bank A/S
            "6862",    //Nordfyns Bank A/S
            "6863",    //Nordfyns Bank A/S
            "6864",    //Nordfyns Bank A/S
            "6865",    //Nordfyns Bank A/S
            "6866",    //Nordfyns Bank A/S
            "6867",    //Nordfyns Bank A/S
            "6868",    //Nordfyns Bank A/S
            "6880",    //Totalbanken A/S
            "6958",    //Danske BankDanske Bank Rønne Afdeling
            "6961",    //Danske Bank
            "6962",    //Danske BankDanske Bank Rønne Afdeling
            "7000",    //FS Bank
            "7001",    //FS Bank
            "7002",    //FS Bank
            "7030",    //Sydbank
            "7031",    //Sydbank
            "7032",    //Sydbank
            "7034",    //Sydbank
            "7035",    //Sydbank
            "7036",    //Sydbank
            "7037",    //Sydbank
            "7038",    //Sydbank
            "7039",    //Sydbank
            "7040",    //Sydbank
            "7041",    //Sydbank
            "7043",    //Sydbank
            "7045",    //Sydbank
            "7046",    //SydbankSydbank Silkeborg
            "7050",    //Sydbank
            "7051",    //Sydbank
            "7055",    //Sydbank
            "7059",    //Sydbank
            "7109",    //Danske Bank
            "7110",    //Sydbank
            "7116",    //Sydbank
            "7117",    //Sydbank
            "7118",    //Sydbank
            "7120",    //Sydbank
            "7121",    //Sydbank
            "7123",    //Sydbank
            "7124",    //Sydbank
            "7125",    //Sydbank
            "7126",    //Sydbank
            "7127",    //Sydbank
            "7128",    //Sydbank
            "7130",    //Spar Nord
            "7131",    //Spar Nord
            "7140",    //Sydbank
            "7160",    //Sydbank
            "7161",    //Sydbank
            "7170",    //Jyske BankJyske Bank Silkeborg Vestergade
            "7171",    //Jyske BankJyske Bank Silkeborg Alderslyst
            "7172",    //Jyske BankJyske Bank Silkeborg Vestergade
            "7173",    //Jyske Bank
            "7174",    //Jyske BankJyske Bank Silkeborg Vestergade
            "7175",    //Jyske Bank
            "7176",    //Jyske Bank
            "7177",    //Jyske BankJyske Bank Silkeborg Vestergade
            "7178",    //Jyske BankJyske Bank Silkeborg Vestergade
            "7179",    //Jyske BankJyske Bank Silkeborg Vestergade
            "7181",    //Jyske Bank
            "7182",    //Jyske Bank
            "7183",    //Jyske BankJyske Bank Silkeborg Vestergade
            "7184",    //Jyske Bank
            "7185",    //Jyske BankJyske Bank Silkeborg Alderslyst
            "7186",    //Jyske Bank
            "7187",    //Jyske Bank
            "7220",    //Spar Nord
            "7230",    //Østjydsk Bank
            "7240",    //Jyske Bank
            "7241",    //Jyske Bank
            "7242",    //Jyske Bank
            "7243",    //Jyske BankJyske Bank Brædstrup
            "7244",    //Jyske Bank
            "7245",    //Jyske Bank
            "7247",    //Jyske Bank
            "7248",    //Jyske Bank
            "7249",    //Jyske Bank
            "7250",    //Jyske Bank
            "7251",    //Jyske Bank
            "7252",    //Jyske Bank
            "7253",    //Jyske BankJyske Bank Risskov
            "7254",    //Jyske Bank
            "7255",    //Jyske BankJyske Bank Aarhus Østergade Privat
            "7256",    //Jyske Bank
            "7257",    //Jyske Bank
            "7258",    //Jyske Bank
            "7259",    //Jyske BankJyske Bank Silkeborg Alderslyst
            "7260",    //Djurslands Bank
            "7261",    //Djurslands Bank
            "7264",    //Djurslands Bank
            "7265",    //Djurslands Bank
            "7266",    //Djurslands Bank
            "7267",    //Djurslands Bank
            "7268",    //Djurslands Bank
            "7270",    //vestjyskBANKVestjysk Bank vestjyskBANK Aarhus Erhverv
            "7300",    //Djurslands Bank
            "7301",    //Djurslands Bank
            "7305",    //Djurslands Bank
            "7309",    //Djurslands Bank
            "7320",    //Djurslands Bank
            "7321",    //Djurslands Bank
            "7360",    //Jyske BankJyske Bank Hjørring
            "7361",    //Jyske Bank
            "7362",    //Jyske BankJyske Bank Tårs
            "7363",    //Jyske BankJyske Bank Løkken
            "7364",    //Jyske Bank
            "7365",    //Jyske Bank
            "7366",    //Jyske BankJyske Bank Hjørring
            "7367",    //Jyske BankJyske Bank Hjørring
            "7368",    //Jyske Bank
            "7369",    //Jyske Bank
            "7370",    //Nordjyske Bank
            "7371",    //Nordjyske BankNordjyske Bank Hirtshals
            "7372",    //Nordjyske Bank
            "7375",    //Nordjyske Bank
            "7379",    //Nordjyske Bank
            "7380",    //Jyske Bank
            "7381",    //Den Jyske Sparekasse
            "7382",    //Den Jyske Sparekasse
            "7383",    //Den Jyske Sparekasse
            "7384",    //Den Jyske Sparekasse
            "7385",    //Den Jyske Sparekasse
            "7386",    //Den Jyske Sparekasse
            "7387",    //Den Jyske Sparekasse
            "7391",    //Den Jyske Sparekasse
            "7392",    //Den Jyske Sparekasse
            "7393",    //Den Jyske Sparekasse
            "7396",    //Den Jyske Sparekasse
            "7397",    //Den Jyske Sparekasse
            "7399",    //Den Jyske Sparekasse
            "7400",    //Nordjyske Bank
            "7401",    //Nordjyske Bank
            "7402",    //Nordjyske Bank
            "7403",    //Nordjyske Bank
            "7405",    //Nordjyske Bank
            "7406",    //Nordjyske Bank
            "7407",    //Nordjyske Bank
            "7410",    //Jutlander Bank
            "7420",    //Nordjyske Bank
            "7421",    //Nordjyske Bank
            "7422",    //Nordjyske Bank
            "7423",    //Nordjyske Bank
            "7428",    //Nordjyske Bank
            "7432",    //Nordjyske Bank
            "7433",    //Nordjyske Bank
            "7434",    //Nordjyske Bank
            "7435",    //Nordjyske Bank
            "7436",    //Nordjyske Bank
            "7440",    //Nørresundby Bank
            "7441",    //Nørresundby Bank
            "7442",    //Nørresundby BankNørresundby Bank
            "7443",    //Nørresundby Bank
            "7444",    //Nørresundby BankNørresundby Bank
            "7445",    //Nørresundby Bank
            "7446",    //Nørresundby Bank
            "7447",    //Nørresundby Bank
            "7448",    //Nørresundby Bank
            "7449",    //Nørresundby Bank
            "7450",    //Nørresundby BankNørresundby Bank
            "7451",    //Nørresundby Bank
            "7452",    //Nørresundby BankNørresundby Bank
            "7453",    //Nørresundby Bank
            "7454",    //Nørresundby Bank
            "7455",    //Nørresundby Bank
            "7456",    //Nørresundby BankNørresundby Bank
            "7457",    //Nørresundby Bank
            "7458",    //Nørresundby Bank
            "7459",    //Nørresundby Bank
            "7461",    //Jutlander Bank
            "7465",    //Jyske Bank
            "7470",    //Spar NordSpar Nord Aars
            "7471",    //Spar NordSpar Nord Bank Farsø Afdeling
            "7500",    //Hvidbjerg Bank
            "7530",    //Nordjyske Bank
            "7531",    //Nordjyske Bank
            "7535",    //Nordjyske Bank
            "7540",    //Jyske BankJyske Bank Brønderslev
            "7541",    //Jyske BankJyske Bank Hjørring
            "7543",    //Jyske Bank
            "7545",    //Jyske Bank
            "7546",    //Jyske Bank
            "7547",    //Jyske Bank
            "7555",    //Jyske BankJyske Bank Nakskov
            "7570",    //Pen-Sam Bank
            "7573",    //Frøs Herreds Sparekasse
            "7575",    //Alm. Brand Bank
            "7590",    //Jyske Bank
            "7591",    //Jyske Bank
            "7593",    //Jyske Bank
            "7595",    //Jyske BankJyske Bank Holstebro, St. Torv
            "7596",    //Jyske BankJyske Bank Holstebro, St. Torv
            "7597",    //Jyske BankJyske Bank Holstebro, St. Torv
            "7598",    //Jyske BankJyske Bank Holstebro, St. Torv
            "7599",    //Jyske BankJyske Bank Holstebro, St. Torv
            "7600",    //vestjyskBANKVestjysk Bank vestjyskBANK Holstebro
            "7601",    //vestjyskBANKVestjysk Bank vestjyskBANK Holstebro
            "7602",    //vestjyskBANKVestjysk Bank vestjyskBANK Holstebro
            "7603",    //vestjyskBANK
            "7604",    //vestjyskBANKVestjysk Bank vestjyskBANK Herning
            "7605",    //vestjyskBANKVestjysk Bank vestjyskBANK Viborg
            "7606",    //vestjyskBANKVestjysk Bank vestjyskBANK Esbjerg
            "7607",    //vestjyskBANKVestjysk Bank vestjyskBANK Holstebro
            "7608",    //vestjyskBANKVestjysk Bank vestjyskBANK Ringkøbing
            "7610",    //Handelsbanken
            "7611",    //HandelsbankenHandelsbanken Vildbjerg
            "7612",    //Handelsbanken
            "7613",    //Handelsbanken
            "7614",    //HandelsbankenHandelsbanken Fredhøj
            "7615",    //HandelsbankenHandelsbanken Herning City
            "7616",    //HandelsbankenHandelsbanken Hammerum
            "7617",    //Handelsbanken
            "7618",    //Handelsbanken
            "7619",    //Handelsbanken
            "7620",    //HandelsbankenHandelsbanken Herning City
            "7621",    //Handelsbanken
            "7622",    //Handelsbanken
            "7623",    //Handelsbanken
            "7624",    //Handelsbanken
            "7625",    //HandelsbankenHandelsbanken Vildbjerg
            "7627",    //Handelsbanken
            "7629",    //Handelsbanken
            "7630",    //Handelsbanken
            "7631",    //HandelsbankenHandelsbanken Herning City
            "7632",    //Handelsbanken
            "7633",    //Handelsbanken
            "7635",    //Handelsbanken
            "7636",    //HandelsbankenHandelsbanken Herning City
            "7637",    //Handelsbanken
            "7638",    //Handelsbanken
            "7639",    //HandelsbankenHandelsbanken Vildbjerg
            "7640",    //HandelsbankenHandelsbanken Herning City
            "7641",    //HandelsbankenHandelsbanken Ikast
            "7642",    //Handelsbanken
            "7643",    //Handelsbanken
            "7644",    //HandelsbankenHandelsbanken Vildbjerg
            "7646",    //Handelsbanken
            "7647",    //HandelsbankenHandelsbanken Ikast
            "7648",    //HandelsbankenHandelsbanken Ikast
            "7649",    //Handelsbanken
            "7650",    //vestjyskBANKVestjysk Bank vestjyskBANK Ringkøbing
            "7651",    //vestjyskBANKVestjysk Bank vestjyskBANK Hvide Sande
            "7652",    //vestjyskBANKVestjysk Bank vestjyskBANK Hvide Sande
            "7653",    //vestjyskBANKVestjysk Bank vestjyskBANK Hadsten
            "7654",    //vestjyskBANKVestjysk Bank vestjyskBANK Aarhus
            "7655",    //vestjyskBANK
            "7656",    //vestjyskBANKVestjysk Bank vestjyskBANK Hvide Sande
            "7660",    //vestjyskBANK
            "7670",    //Ringkjøbing Landbobank
            "7679",    //Ringkjøbing Landbobank
            "7680",    //vestjyskBANK
            "7681",    //Alm. Brand Bank
            "7700",    //Sydbank
            "7701",    //Sydbank
            "7702",    //Sydbank
            "7703",    //Sydbank
            "7704",    //Sydbank
            "7705",    //Sydbank
            "7708",    //Sydbank
            "7710",    //Sydbank
            "7711",    //Sydbank
            "7712",    //Sydbank
            "7713",    //Sydbank
            "7714",    //SydbankSydbank Farum
            "7715",    //Sydbank
            "7716",    //Sydbank
            "7717",    //Sydbank
            "7718",    //Sydbank
            "7724",    //Danske Andelskassers Bank
            "7725",    //Danske Andelskassers Bank
            "7726",    //Danske Andelskassers Bank
            "7729",    //Danske Andelskassers Bank
            "7730",    //vestjyskBANKVestjysk Bank vestjyskBANK Ringkøbing
            "7732",    //vestjyskBANKVestjysk Bank vestjyskBANK Kolding
            "7733",    //vestjyskBANKVestjysk Bank vestjyskBANK Horsens
            "7734",    //vestjyskBANKVestjysk Bank vestjyskBANK Silkeborg
            "7735",    //vestjyskBANKVestjysk Bank vestjyskBANK Hvide Sande
            "7736",    //vestjyskBANKVestjysk Bank vestjyskBANK Thisted
            "7737",    //vestjyskBANKVestjysk Bank vestjyskBANK Ringkøbing
            "7738",    //vestjyskBANKVestjysk Bank vestjyskBANK Randers
            "7739",    //vestjyskBANKVestjysk Bank vestjyskBANK Aarhus Erhverv
            "7740",    //vestjyskBANKVestjysk Bank vestjyskBANK Ikast
            "7747",    //vestjyskBANKVestjysk Bank vestjyskBANK Aarhus Erhverv
            "7749",    //vestjyskBANK
            "7750",    //Jyske Bank
            "7751",    //Jyske Bank
            "7753",    //Jyske Bank
            "7754",    //Jyske Bank
            "7755",    //Jyske Bank
            "7780",    //Skjern Bank
            "7788",    //Danske Andelskassers Bank
            "7789",    //Danske Andelskassers Bank
            "7790",    //Salling Bank
            "7800",    //Ringkjøbing Landbobank
            "7810",    //Sydbank
            "7811",    //Sydbank
            "7821",    //Jyske Bank
            "7822",    //Jyske Bank
            "7829",    //Jyske Bank
            "7831",    //Jyske Bank
            "7833",    //Jyske BankJyske Bank Viborg
            "7834",    //Jyske Bank
            "7835",    //Jyske Bank
            "7836",    //Jyske Bank
            "7837",    //Jyske Bank
            "7840",    //Jyske Bank
            "7841",    //Jyske BankJyske Bank Kjellerup
            "7842",    //Jyske BankJyske Bank Viborg
            "7843",    //Jyske BankJyske Bank Kjellerup
            "7844",    //Jyske Bank
            "7845",    //Jyske BankJyske Bank Bjerringbro
            "7846",    //Jyske Bank
            "7849",    //Jyske Bank
            "7851",    //Jyske BankJyske Bank Vesterbrogade
            "7852",    //Jyske BankJyske Bank Østerbro
            "7853",    //Jyske Bank
            "7854",    //Jyske Bank
            "7856",    //Jyske Bank
            "7857",    //Jyske BankJyske Bank Silkeborg Vestergade
            "7858",    //Jyske Bank
            "7860",    //Sydbank
            "7872",    //Københavns Andelskasse
            "7890",    //Salling Bank
            "7910",    //Sydbank
            "7911",    //Sydbank
            "7915",    //Sydbank
            "7920",    //Sydbank
            "7921",    //Sydbank
            "7922",    //Sydbank
            "7925",    //Sydbank
            "7930",    //Kreditbanken
            "7931",    //Kreditbanken
            "7932",    //Kreditbanken
            "7933",    //Kreditbanken
            "7952",    //Saxo Privatbank
            "7953",    //Saxo Privatbank
            "7955",    //Saxo Privatbank
            "7970",    //Sydbank
            "7971",    //Sydbank
            "7980",    //Sydbank
            "7981",    //Sydbank
            "7982",    //SydbankSydbank Private Banking
            "7990",    //SydbankSydbank Tønder
            "8010",    //Sydbank
            "8011",    //Sydbank
            "8012",    //Sydbank
            "8013",    //Sydbank
            "8020",    //Sydbank
            "8060",    //Sydbank
            "8061",    //Sydbank
            "8063",    //Sydbank
            "8065",    //Sydbank
            "8066",    //SydbankSydbank Private Banking
            "8068",    //Sydbank
            "8071",    //Sydbank
            "8072",    //Sydbank
            "8075",    //Sydbank
            "8076",    //Sydbank
            "8077",    //Sydbank
            "8079",    //Sydbank
            "8090",    //Nordjyske Bank
            "8091",    //Nordjyske Bank
            "8099",    //Nordjyske BankNordjyske Bank Hirtshals
            "8109",    //Jyske Bank
            "8113",    //Nykredit Bank
            "8114",    //Nykredit Bank
            "8117",    //Nykredit Bank
            "8119",    //BankNordikBankNordik Esbjerg
            "8120",    //BankNordik
            "8121",    //BankNordikBankNordik Odense
            "8122",    //Spar Nord
            "8123",    //Spar Nord
            "8124",    //BankNordik
            "8125",    //Spar Nord
            "8126",    //BankNordikBankNordik Esbjerg
            "8127",    //BankNordik
            "8128",    //Nykredit Bank
            "8129",    //Nykredit Bank
            "8130",    //Den Jyske Sparekasse
            "8131",    //Den Jyske Sparekasse
            "8132",    //Den Jyske Sparekasse
            "8133",    //Den Jyske Sparekasse
            "8139",    //Jutlander Bank
            "8140",    //Jutlander Bank
            "8141",    //Jutlander Bank
            "8142",    //Jutlander Bank
            "8143",    //Jutlander BankSparekassen Hobro Mariager Afdeling
            "8144",    //Jutlander Bank
            "8145",    //Jutlander BankSparekassen Hobro Aalborg Afdeling
            "8146",    //Saxo Privatbank
            "8147",    //Saxo Privatbank
            "8148",    //Saxo Privatbank
            "8149",    //Bnp Paribas Fortis Danmark
            "8205",    //Den Jyske Sparekasse
            "8211",    //Den Jyske Sparekasse
            "8212",    //Den Jyske Sparekasse
            "8213",    //Den Jyske Sparekasse
            "8214",    //Den Jyske Sparekasse
            "8215",    //Den Jyske Sparekasse
            "8220",    //Den Jyske Sparekasse
            "8222",    //BIL Danmark (Banque Internationale à Luxembourg SA)
            "8223",    //Den Jyske Sparekasse
            "8224",    //Den Jyske Sparekasse
            "8230",    //Fih Erhvervsbank
            "8232",    //Fih Erhvervsbank
            "8269",    //Carnegie Bank
            "8401",    //Merkur
            "8411",    //Andelskassen Fælleskassen
            "8460",    //Nørresundby Bank
            "8461",    //Nørresundby Bank
            "8480",    //Spar Nord
            "8481",    //Spar Nord
            "8482",    //Spar Nord
            "8483",    //Spar Nord
            "8484",    //Spar Nord
            "8485",    //Spar Nord
            "8486",    //Spar Nord
            "8487",    //Spar Nord
            "8489",    //Spar Nord
            "8490",    //BankNordikBankNordik Aarhus
            "8491",    //Spar Nord
            "8492",    //Spar Nord
            "8493",    //Spar Nord
            "8494",    //Spar NordSpar Nord
            "8495",    //Spar Nord
            "8496",    //Spar Nord
            "8497",    //Spar Nord
            "8498",    //Spar Nord
            "8499",    //Spar Nord
            "8500",    //Spar Nord
            "8501",    //Spar Nord
            "8502",    //Spar Nord
            "8503",    //Spar Nord
            "8504",    //Spar Nord
            "8505",    //Spar Nord
            "8506",    //Spar Nord
            "8507",    //Spar Nord
            "8508",    //Spar Nord
            "8509",    //Spar Nord
            "8510",    //Spar Nord
            "8514",    //Spar Nord
            "8515",    //Spar Nord
            "8516",    //Spar Nord
            "8517",    //Spar Nord
            "8518",    //Spar Nord
            "8519",    //Spar Nord
            "8520",    //Spar Nord
            "8521",    //Spar Nord
            "8522",    //Spar Nord
            "8523",    //Spar Nord
            "8524",    //Spar Nord
            "8525",    //Spar Nord
            "8526",    //Spar Nord
            "8527",    //Spar Nord
            "8528",    //Spar Nord
            "8529",    //Spar Nord
            "8530",    //Spar Nord
            "9001",    //Spar Nord
            "9002",    //Spar Nord
            "9004",    //Spar Nord
            "9006",    //Spar Nord
            "9007",    //Spar Nord
            "9008",    //Spar Nord
            "9009",    //Spar Nord
            "9010",    //Spar Nord
            "9011",    //Spar Nord
            "9012",    //Spar Nord
            "9015",    //Spar Nord
            "9016",    //Spar Nord
            "9020",    //Sparekassen VendsysselSparekassen Vendsyssel
            "9022",    //Brovst Sparekasse
            "9024",    //Nordjyske Bank
            "9025",    //Jerslev Sparekasse
            "9028",    //Spar Nord
            "9029",    //Spar Nord
            "9033",    //Nordjyske Bank
            "9035",    //Spar Nord
            "9037",    //Spar Nord
            "9040",    //Spar Nord
            "9041",    //Danske BankDanske Bank Frederikshavn Afdeling
            "9044",    //Dronninglund Sparekasse
            "9046",    //Spar Nord
            "9048",    //Unknown
            "9049",    //Spar NordSpar Nord Herning
            "9050",    //Spar Nord
            "9053",    //Hellevad-Ørum Sparekasse
            "9054",    //Spar Nord
            "9056",    //Spar Nord
            "9057",    //Danske BankDanske Bank Hjørring Afdeling
            "9060",    //Spar Nord
            "9061",    //Spar NordSpar Nord Herning
            "9066",    //Spar Nord
            "9067",    //Spar Nord
            "9070",    //Sparekassen Vendsyssel
            "9075",    //Spar Nord
            "9076",    //Spar Nord
            "9077",    //Spar Nord
            "9078",    //Spar Nord
            "9080",    //FS Bank
            "9081",    //Sparekassen Thy
            "9083",    //Sparekassen Thy
            "9086",    //Sparekassen Thy
            "9087",    //Sparekassen Thy
            "9088",    //Sparekassen Thy
            "9089",    //Sparekassen Thy
            "9090",    //Sparekassen Thy
            "9100",    //Jyske BankJyske Bank Nykøbing Mors
            "9101",    //Spar Nord
            "9102",    //Spar Nord
            "9106",    //Sparekassen Thy
            "9107",    //Sparekassen Thy
            "9108",    //Sparekassen Thy
            "9109",    //Sparekassen Thy
            "9110",    //Sparekassen Thy
            "9111",    //Sparekassen Thy
            "9112",    //Sparekassen Thy
            "9114",    //Sparekassen Thy
            "9116",    //Sparekassen Vendsyssel
            "9117",    //Frøslev-Mollerup Sparekasse
            "9118",    //Sparekassen Thy
            "9119",    //Sparekassen Thy
            "9120",    //Sparekassen Thy
            "9121",    //Boddum-Ydby Sparekasse
            "9124",    //Sønderhå-Hørsted Sparekasse
            "9127",    //Spar Nord
            "9128",    //Spar Nord
            "9129",    //Sparekassen Thy
            "9133",    //Frøslev-Mollerup Sparekasse
            "9135",    //Klim Sparekasse
            "9139",    //Sparekassen Spar Mors
            "9140",    //Sparekassen Vendsyssel
            "9141",    //Sparekassen Vendsyssel
            "9143",    //Hunstrup-Østerild Sparekasse
            "9156",    //Spar Nord
            "9160",    //Spar Nord
            "9161",    //NordeaNordea Aalborg Afdeling
            "9162",    //NordeaNordea Aalborg Afdeling
            "9163",    //NordeaNordea Korsør Afdeling
            "9164",    //NordeaNordea Aalborg Afdeling
            "9170",    //Danske BankDanske Bank Aars Afdeling
            "9173",    //Danske BankDanske Bank Roskilde Afdeling
            "9174",    //Den Jyske Sparekasse
            "9181",    //FS Bank 
            "9189",    //FS Bank 
            "9190",    //Spar Nord
            "9196",    //Spar Nord
            "9200",    //Spar Nord
            "9201",    //Jutlander Bank
            "9202",    //Jutlander Bank
            "9203",    //Jutlander Bank
            "9206",    //Danske BankDanske Bank Hjørring Afdeling
            "9208",    //Danske Bank
            "9209",    //Danske BankDanske Bank Vejle Afdeling
            "9210",    //Spar Nord
            "9211",    //Spar Nord
            "9212",    //Hals Sparekasse
            "9213",    //Spar Nord
            "9214",    //Jutlander Bank
            "9215",    //Spar Nord
            "9216",    //Jutlander Bank
            "9217",    //Jutlander Bank
            "9218",    //Jutlander Bank
            "9219",    //Spar Nord
            "9221",    //Spar NordSpar Nord Herning
            "9223",    //Jutlander Bank
            "9224",    //Ulsted Sparekasse
            "9225",    //Spar Nord
            "9226",    //Spar Nord
            "9227",    //Spar Nord
            "9231",    //Jutlander Bank
            "9233",    //Spar NordSpar Nord
            "9236",    //Spar Nord
            "9237",    //Spar Nord
            "9238",    //Jutlander Bank
            "9239",    //Danske Bank
            "9240",    //Spar Nord
            "9241",    //Spar Nord
            "9242",    //Spar Nord
            "9243",    //Spar Nord
            "9244",    //Spar Nord
            "9245",    //Spar Nord
            "9246",    //Spar Nord
            "9247",    //Danske BankDanske Bank Aars Afdeling
            "9249",    //Danske BankDanske Bank Lyngby Afdeling
            "9251",    //NordeaNordea Viborg PrivatkundeAfdeling
            "9252",    //NordeaNordea Viborg PrivatkundeAfdeling
            "9254",    //Nordea
            "9255",    //NordeaNordea Landbrugscenter Sjælland
            "9256",    //Spar Nord
            "9258",    //Spar Nord
            "9259",    //Spar Nord
            "9260",    //Spar Nord
            "9261",    //Den Jyske Sparekasse
            "9265",    //NordeaNordea Viborg PrivatkundeAfdeling
            "9266",    //NordeaNordea Søndergade Afdeling
            "9268",    //Danske Bank
            "9269",    //Danske BankDanske Bank Risskov Afdeling
            "9272",    //NordeaNordea Viborg PrivatkundeAfdeling
            "9274",    //NordeaNordea Nørre Alslev Afdeling
            "9275",    //Nordea
            "9277",    //Spar Nord
            "9278",    //Spar Nord
            "9279",    //Danske BankDanske Bank Torvet Afdeling
            "9280",    //Spar Nord
            "9281",    //Danske BankDanske Bank Bjerringbro Afdeling
            "9282",    //Spar Nord
            "9283",    //Langå Sparekasse
            "9284",    //NordeaNordea Kjellerup Afdeling
            "9285",    //Fuur Sparekasse
            "9286",    //Spar Nord
            "9287",    //Spar Nord
            "9289",    //Spar Nord
            "9291",    //Roslev Sparekasse
            "9292",    //Sparekassen Sundsøre
            "9294",    //Sparekassen Kronjylland
            "9296",    //Spar Nord
            "9297",    //Spar Nord
            "9298",    //Sparekassen Kronjylland
            "9299",    //NordeaNordea Bjerringbro Afdeling
            "9301",    //Spar Nord
            "9302",    //Spar Nord
            "9303",    //Jutlander BankSparekassen Hobro Klejtrup Afdeling
            "9304",    //Spar Nord
            "9306",    //Spar NordSpar Nord Aars
            "9307",    //Den Jyske Sparekasse
            "9308",    //Spar Nord
            "9309",    //Spar Nord
            "9310",    //NordeaNordea Aalestrup Afdeling
            "9311",    //Spar Nord
            "9312",    //Sparekassen Balling
            "9313",    //Durup Sparekasse
            "9314",    //Spar Nord
            "9315",    //Danske BankDanske Bank Silkeborg Afdeling
            "9316",    //Sparekassen Kronjylland
            "9317",    //Sparekassen Kronjylland
            "9318",    //Sparekassen Kronjylland
            "9319",    //Sparekassen Kronjylland
            "9320",    //Sparekassen Kronjylland
            "9321",    //Sparekassen Kronjylland
            "9322",    //Sparekassen Kronjylland
            "9323",    //Sparekassen Kronjylland
            "9324",    //Sparekassen Kronjylland
            "9325",    //Sparekassen Kronjylland
            "9326",    //Sparekassen Kronjylland
            "9328",    //Sparekassen Kronjylland
            "9329",    //Sparekassen Kronjylland
            "9330",    //Sparekassen Kronjylland
            "9331",    //Sparekassen Kronjylland
            "9332",    //Sparekassen Kronjylland
            "9333",    //Sparekassen Kronjylland
            "9334",    //Sparekassen Kronjylland
            "9335",    //Sparekassen Kronjylland
            "9336",    //Jutlander Bank
            "9337",    //Jutlander Bank
            "9338",    //Jutlander BankSparekassen Hobro Hadsund Afdeling
            "9339",    //Jutlander Bank
            "9340",    //Jutlander BankSparekassen Hobro Mariager Afdeling
            "9341",    //Jutlander Bank
            "9342",    //Spar Nord
            "9343",    //Danske BankDanske Bank Grenaa Afdeling
            "9344",    //Danske BankDanske Bank Grenaa Afdeling
            "9345",    //Spar Nord
            "9346",    //Spar Nord
            "9347",    //Spar Nord
            "9348",    //Spar Nord
            "9349",    //Spar Nord
            "9351",    //Jutlander Bank
            "9352",    //Jutlander BankSparekassen Hobro Afdeling
            "9353",    //Danske BankDanske Bank Torvet Afdeling
            "9354",    //Rønde og Omegns Sparekasse
            "9355",    //Mørke Sparekasse
            "9356",    //Sparekassen Djursland 
            "9357",    //Helgenæs Sparekasse
            "9358",    //Vistoft Sparekasse
            "9359",    //Spar Nord
            "9360",    //Sparekassen Kronjylland
            "9361",    //Sparekassen Kronjylland
            "9362",    //Sparekassen Kronjylland
            "9363",    //Jutlander Bank
            "9364",    //Sparekassen Kronjylland
            "9365",    //Sparekassen Kronjylland
            "9366",    //Spar Nord
            "9367",    //Spar Nord
            "9368",    //Sparekassen Kronjylland
            "9369",    //Søby-Skader-Halling Sparekasse
            "9370",    //Spar Nord
            "9371",    //Sparekassen Kronjylland
            "9373",    //Sparekassen Kronjylland
            "9374",    //Spar Nord
            "9376",    //Sparekassen Kronjylland
            "9377",    //Sparekassen Djursland
            "9378",    //Spar Nord
            "9380",    //Spar Nord
            "9381",    //Sparekassen Kronjylland
            "9383",    //Spar Nord
            "9385",    //Spar Nord
            "9387",    //Spar Nord
            "9388",    //Sparekassen Djursland
            "9390",    //Unknown
            "9395",    //Sparekassen Kronjylland
            "9402",    //Danske BankDanske Bank Vejle Afdeling
            "9404",    //Danske BankDanske Bank Lyngby Afdeling
            "9407",    //Nordea
            "9410",    //Nordea
            "9412",    //Nordea
            "9416",    //Nordea
            "9417",    //Nordea
            "9420",    //Nordea
            "9421",    //Nordea
            "9422",    //Nordea
            "9423",    //Nordea
            "9424",    //Nordea
            "9425",    //Nordea
            "9426",    //Nordea
            "9427",    //Nordea
            "9428",    //Nordea
            "9433",    //Nordea
            "9436",    //Jutlander Bank
            "9439",    //Danske BankDanske Bank Odder Afdeling
            "9442",    //Danske BankDanske Bank Horsens Afdeling
            "9444",    //Danske Bank
            "9445",    //Danske BankDanske Bank Vejle Afdeling
            "9447",    //Danske BankDanske Bank Varde Afdeling
            "9451",    //Danske BankDanske Bank Varde Afdeling
            "9452",    //Danske Bank
            "9455",    //Danske Bank
            "9456",    //Danske BankDanske Bank Horsens Afdeling
            "9458",    //Danske Bank
            "9459",    //Danske BankDanske Bank Horsens Afdeling
            "9462",    //Danske Bank
            "9463",    //Danske Bank
            "9464",    //Danske BankDanske Bank Horsens Afdeling
            "9465",    //Danske Bank
            "9467",    //Danske BankDanske Bank Hedensted Afdeling
            "9468",    //Danske BankDanske Bank Hedensted Afdeling
            "9470",    //Danske BankDanske Bank Horsens Afdeling
            "9472",    //Danske BankDanske Bank Horsens Afdeling
            "9473",    //Danske BankDanske Bank Horsens Afdeling
            "9474",    //Danske Bank
            "9479",    //Danske BankDanske Bank Silkeborg Afdeling
            "9480",    //Danske BankDanske Bank Silkeborg Afdeling
            "9481",    //Danske BankDanske Bank Silkeborg Afdeling
            "9482",    //Danske BankDanske Bank Hammel Afdeling
            "9483",    //Danske Bank
            "9484",    //Danske BankDanske Bank Horsens Afdeling
            "9485",    //Danske BankDanske Bank Horsens Afdeling
            "9486",    //Danske Bank
            "9488",    //Danske Bank
            "9490",    //Danske BankDanske Bank Lyngby Afdeling
            "9491",    //Danske Bank
            "9493",    //Danske Bank
            "9496",    //Danske Bank
            "9499",    //Danske Bank
            "9501",    //Fruering-Vitved Sparekasse
            "9505",    //Danske BankDanske Bank Ry Afdeling
            "9506",    //Danske BankDanske Bank Silkeborg Afdeling
            "9507",    //Danske Bank
            "9508",    //Danske Bank
            "9509",    //Danske Bank
            "9510",    //Danske BankDanske Bank Ry Afdeling
            "9511",    //Danske BankDanske Bank Vejle Afdeling
            "9512",    //Danske BankDanske Bank Hedensted Afdeling
            "9513",    //Danske BankDanske Bank Billund Afdeling
            "9514",    //Danske BankDanske Bank Vejle Afdeling
            "9515",    //Danske Bank
            "9517",    //Danske BankDanske Bank Vejle Afdeling
            "9518",    //Danske Bank
            "9519",    //Danske Bank
            "9521",    //Danske BankDanske Bank Hedensted Afdeling
            "9522",    //Danske BankDanske Bank Hedensted Afdeling
            "9524",    //Danske BankDanske Bank Vejle Afdeling
            "9525",    //Danske BankDanske Bank Støvring Afdeling
            "9528",    //Danske Bank
            "9530",    //Danske BankDanske Bank Fredericia Afdeling
            "9532",    //Danske BankDanske Bank Kolding Afdeling
            "9536",    //Danske BankDanske Bank Børkop Afdeling
            "9537",    //Danske BankDanske Bank Horsens Afdeling
            "9538",    //Danske Bank
            "9539",    //Danske BankDanske Bank Kolding Afdeling
            "9541",    //Danske Bank
            "9543",    //Danske Bank
            "9544",    //Danske BankDanske Bank Vejle Afdeling
            "9545",    //Danske BankDanske Bank Vejle Afdeling
            "9547",    //Danske Bank
            "9551",    //Den Jyske Sparekasse
            "9552",    //Danske Bank
            "9554",    //Danske Bank
            "9556",    //Danske Bank
            "9557",    //NordeaNordea Ebeltoft Afdeling
            "9559",    //NordeaNordea Hinnerup Afdeling
            "9560",    //Den Jyske Sparekasse
            "9561",    //Den Jyske Sparekasse
            "9562",    //Danske Bank
            "9568",    //Danske BankDanske Bank Børkop Afdeling
            "9569",    //Danske BankDanske Bank Børkop Afdeling
            "9570",    //Danske Bank
            "9571",    //Danske Bank
            "9573",    //Danske BankDanske Bank Seest Afdeling
            "9577",    //Danske Bank
            "9578",    //Danske BankDanske Bank Kolding Afdeling
            "9580",    //Danske BankDanske Bank Fredericia Afdeling
            "9581",    //Danske BankDanske Bank Fredericia Afdeling
            "9582",    //Danske Bank
            "9583",    //Danske Bank
            "9584",    //Danske BankDanske Bank Fredericia Afdeling
            "9585",    //NordeaNordea Holstebro
            "9587",    //NordeaNordea Nexø Afdeling
            "9588",    //NordeaNordea Ringkøbing Afdeling
            "9589",    //NordeaNordea Maribo Afdeling
            "9590",    //NordeaNordea Lemvig Afdeling
            "9593",    //NordeaNordea Ikast Afdeling
            "9595",    //Nordea
            "9598",    //NordeaNordea Herning Afdeling
            "9600",    //NordeaNordea Herning Afdeling
            "9602",    //NordeaNordea Herning Afdeling
            "9604",    //Nordea
            "9605",    //NordeaNordea Lemvig Afdeling
            "9606",    //NordeaNordea Herning Afdeling
            "9607",    //NordeaNordea Kibæk Afdeling
            "9608",    //Nordea
            "9609",    //NordeaNordea Ikast Afdeling
            "9610",    //NordeaNordea Herning Afdeling
            "9611",    //NordeaNordea Herning Afdeling
            "9612",    //NordeaNordea Herning Afdeling
            "9613",    //NordeaNordea Herning Afdeling
            "9614",    //NordeaNordea Herning Afdeling
            "9615",    //NordeaNordea Thisted Afdeling
            "9617",    //NordeaNordea Hadsten Afdeling
            "9619",    //Nordea
            "9620",    //NordeaNordea Herning Afdeling
            "9621",    //Nordea
            "9622",    //NordeaNordea Videbæk Afdeling
            "9623",    //NordeaNordea Videbæk Afdeling
            "9624",    //Nordea
            "9625",    //NordeaNordea Vejen Afdeling
            "9626",    //Nordea
            "9627",    //Ulfborg Sparekasse
            "9628",    //Danske BankDanske Bank Næstved Afdeling
            "9629",    //Stadil Sparekasse
            "9630",    //NordeaNordea Lemvig Afdeling
            "9631",    //Den Jyske Sparekasse
            "9632",    //NordeaNordea Struer Afdeling
            "9633",    //NordeaNordea Ikast Afdeling
            "9634",    //Borbjerg Sparekasse
            "9635",    //NordeaNordea Struer Afdeling
            "9637",    //Nordea
            "9638",    //Nordea
            "9641",    //NordeaNordea Skjern Afdeling
            "9642",    //Nordea
            "9643",    //Nordea
            "9644",    //Nordea
            "9647",    //Danske BankDanske Bank Randers Afdeling
            "9648",    //Nordea
            "9649",    //Nordea
            "9658",    //Danske BankDanske Bank Aalborg Afdeling
            "9659",    //Danske BankDanske Bank Aalborg Afdeling
            "9660",    //Danske BankDanske Bank Ribe Afdeling
            "9661",    //Danske Bank
            "9662",    //Danske BankDanske Bank Aarhus Afdeling
            "9663",    //Danske BankDanske Bank Vejle Afdeling
            "9664",    //Danske Bank
            "9665",    //Danske BankDanske Bank Lyngby Afdeling
            "9669",    //Danske Bank
            "9670",    //Danske BankDanske Bank Varde Afdeling
            "9672",    //Danske BankDanske Bank Vejen Afdeling
            "9674",    //Danske BankDanske Bank Varde Afdeling
            "9675",    //Danske BankDanske Bank Vejle Afdeling
            "9676",    //Danske BankDanske Bank Vejen Afdeling
            "9677",    //Danske BankDanske Bank Kolding Afdeling
            "9678",    //Danske Bank
            "9680",    //Danske BankDanske Bank Varde Afdeling
            "9681",    //Danske Bank
            "9682",    //Sparekassen For Nørre Nebel og Omegn
            "9684",    //Fanø Sparekasse
            "9686",    //Den Jyske Sparekasse
            "9687",    //Den Jyske Sparekasse
            "9689",    //Danske BankDanske Bank Esbjerg Afdeling
            "9690",    //Vorbasse-Hejnsvig Sparekasse
            "9691",    //Vorbasse-Hejnsvig Sparekasse
            "9692",    //Danske BankDanske Bank Ribe Afdeling
            "9693",    //Danske Bank
            "9694",    //Saxo Privatbank
            "9695",    //Saxo Privatbank
            "9698",    //Danske Bank
            "9699",    //Danske BankDanske Bank Varde Afdeling
            "9700",    //Danske Bank
            "9701",    //Danske Bank
            "9704",    //Danske BankDanske Bank Vejen Afdeling
            "9705",    //Danske BankDanske Bank Seest Afdeling
            "9706",    //Danske Bank
            "9707",    //Danske Bank
            "9709",    //Danske BankDanske Bank Vejen Afdeling
            "9710",    //Danske Bank
            "9711",    //Danske Bank
            "9712",    //Den Jyske Sparekasse
            "9713",    //Danske Bank
            "9714",    //Danske BankDanske Bank Esbjerg Afdeling
            "9716",    //Danske BankDanske Bank Esbjerg Afdeling
            "9718",    //Danske Bank
            "9720",    //Danske Bank
            "9722",    //Danske BankDanske Bank Odense Nord Afdeling
            "9724",    //Danske BankDanske Bank Odense Afdeling
            "9725",    //Danske BankDanske Bank Vojens Afdeling
            "9726",    //Danske BankDanske Bank Vojens Afdeling
            "9727",    //Danske BankDanske Bank Vojens Afdeling
            "9729",    //Danske BankDanske Bank Næstved Afdeling
            "9731",    //Danske BankDanske Bank Vojens Afdeling
            "9733",    //Frøs Herreds Sparekasse
            "9734",    //Frøs Herreds Sparekasse
            "9735",    //Frøs Herreds Sparekasse
            "9736",    //Frøs Herreds Sparekasse
            "9737",    //Frøs Herreds SparekasseFrøs Herreds Sparekasse
            "9738",    //Frøs Herreds Sparekasse
            "9739",    //Frøs Herreds Sparekasse
            "9740",    //Frøs Herreds Sparekasse
            "9741",    //Frøs Herreds Sparekasse
            "9742",    //Frøs Herreds Sparekasse
            "9743",    //Danske BankDanske Bank Christiansfeld Afdeling
            "9745",    //Danske Bank
            "9748",    //Danske BankDanske Bank Haderslev Afdeling
            "9749",    //Danske Bank
            "9750",    //Danske BankDanske Bank Vejen Afdeling
            "9752",    //Danske BankDanske Bank Hillerød Afdeling
            "9756",    //Danske Bank
            "9757",    //Danske Bank
            "9758",    //Danske BankDanske Bank Nørreport Afdeling
            "9762",    //Danske BankDanske Bank Silkeborg Afdeling
            "9767",    //Danske BankDanske Bank Lyngby Afdeling
            "9768",    //Danske BankDanske Bank Vejle Afdeling
            "9769",    //Danske BankDanske Bank Tre Falke Afdeling
            "9770",    //Danske BankDanske Bank Støvring Afdeling
            "9797",    //Broager Sparekasse
            "9800",    //Danske BankDanske Bank Sønderborg Afdeling
            "9803",    //Danske Bank
            "9805",    //Jutlander Bank
            "9806",    //Jutlander Bank
            "9807",    //Jutlander Bank
            "9809",    //Jutlander Bank
            "9811",    //Spar Nord
            "9812",    //Jutlander Bank
            "9813",    //Jutlander Bank
            "9814",    //Jutlander Bank
            "9815",    //Spar Nord
            "9817",    //Spar NordSpar Nord Bank Farsø Afdeling
            "9818",    //Spar Nord
            "9819",    //Spar Nord
            "9823",    //Den Jyske Sparekasse
            "9824",    //Den Jyske Sparekasse
            "9825",    //Danske BankDanske Bank Tønder Afdeling
            "9826",    //Danske BankDanske Bank Hvidovre Afdeling
            "9827",    //Sparekassen Bredebro
            "9828",    //Sparekassen Bredebro
            "9838",    //Jutlander Bank
            "9839",    //Sparekassen Bredebro
            "9846",    //Danske BankDanske Bank Tønder Afdeling
            "9851",    //Jutlander Bank
            "9852",    //Jutlander Bank
            "9860",    //Folkesparekassen
            "9865",    //Nordoya Sparikassi
            "9870",    //Suduroyar Sparikassi
            "9872",    //Spar Nord
            "9873",    //Spar NordSpar Nord Herning
            "9874",    //BankNordikBankNordik Kolding
            "9876",    //Danske BankDanske Bank Horsens Afdeling
            "9877",    //Danske BankDanske Bank Horsens Afdeling
            "9878",    //Danske BankDanske Bank Horsens Afdeling
            "9880",    //Sparekassen Sjælland
            "9881",    //Sparekassen SjællandSparekassen Sjælland Asnæs
            "9882",    //Sparekassen SjællandSparekassen Sjælland Jyderup
            "9883",    //Sparekassen SjællandSparekassen Sjælland Dianalund
            "9884",    //Sparekassen SjællandSparekassen Sjælland Hillerød
            "9885",    //Sparekassen SjællandSparekassen Sjælland Holbæk
            "9886",    //Sparekassen Sjælland
            "9887",    //Sparekassen SjællandSparekassen Sjælland Roskilde
            "9888",    //Sparekassen SjællandSparekassen Sjælland Ringsted
            "9889",    //Sparekassen SjællandSparekassen Sjælland Asnæs
            "9890",    //BankNordikBankNordik Horsens
            "9891",    //BankNordikBankNordik Vejle
            "9892",    //BankNordikBankNordik Haderslev
            "9893",    //Spar Nord
            "9894",    //Spar Nord
            "9895",    //Spar Nord
            "9896",    //Spar Nord
            "9897",    //Spar Nord
            "9898",    //Spar Nord
            "9899",    //BankNordikBankNordik Aarhus
            "9942",    //Diba Bank
            "9960",    //Forvaltningsinstituttet for Lokale Pengeinstitutter
    };
}
