package nl.hsac.fitnesse.util.iban;

public class ESIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     * see https://docs.oracle.com/cd/E18727_01/doc.121/e13483/T359831T498954.htm
     * for explanation on the checksum calculations
     *
     * @param bankCode bank code to (blank for random).
     * @return random IBAN.
     */
    public String generateIban(String bankCode) {

        String countryCode = "ES";
        int accountLength = 10;
        String accountCodeType = "N";
        int bankCodeLength = 8;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, BANK_CODE_LIST, bankCodeLength, bankCodeType);
        String checkDigit1 = checkDigit1(bankCode);
        String account = getAccount(accountLength, accountCodeType);
        String checkDigit2 = checkDigit2(account);
        account = checkDigit1 + checkDigit2 + account;
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    public String checkDigit1(String bankcode) {
        int n1 = Character.getNumericValue(bankcode.charAt(0)) * 4;
        int n2 = Character.getNumericValue(bankcode.charAt(1)) * 8;
        int n3 = Character.getNumericValue(bankcode.charAt(2)) * 5;
        int n4 = Character.getNumericValue(bankcode.charAt(3)) * 10;
        int n5 = Character.getNumericValue(bankcode.charAt(4)) * 9;
        int n6 = Character.getNumericValue(bankcode.charAt(5)) * 7;
        int n7 = Character.getNumericValue(bankcode.charAt(6)) * 3;
        int n8 = Character.getNumericValue(bankcode.charAt(7)) * 6;
        int total = n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8;
        int controlNumber = getESControlNumber(total);

        return Integer.toString(controlNumber);
    }

    public String checkDigit2(String account) {
        int n1 = Character.getNumericValue(account.charAt(0)) * 1;
        int n2 = Character.getNumericValue(account.charAt(1)) * 2;
        int n3 = Character.getNumericValue(account.charAt(2)) * 4;
        int n4 = Character.getNumericValue(account.charAt(3)) * 8;
        int n5 = Character.getNumericValue(account.charAt(4)) * 5;
        int n6 = Character.getNumericValue(account.charAt(5)) * 10;
        int n7 = Character.getNumericValue(account.charAt(6)) * 9;
        int n8 = Character.getNumericValue(account.charAt(7)) * 7;
        int n9 = Character.getNumericValue(account.charAt(8)) * 3;
        int n10 = Character.getNumericValue(account.charAt(9)) * 6;
        int total = n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10;
        int controlNumber = getESControlNumber(total);

        return Integer.toString(controlNumber);

    }

    public int getESControlNumber(int total) {
        int controlNumber = total / 11;
        controlNumber = total - (controlNumber * 11);
        controlNumber = 11 - controlNumber;

        if (controlNumber == 10) {
            controlNumber = 1;
        }
        if (controlNumber == 11) {
            controlNumber = 0;
        }

        return controlNumber;
    }


    public final static String[] BANK_CODE_LIST = {
            "00080155",    //BANCO ATLANTICO
            "00190520",    //DEUTSCHE BANK, S.A.E.
            "00190642",    //DEUTSCHE BANK, S.A.E.
            "00194376",    //DEUTSCHE BANK, S.A.E.
            "00194377",    //DEUTSCHE BANK, S.A.E.
            "00194378",    //DEUTSCHE BANK, S.A.E.
            "00194379",    //DEUTSCHE BANK, S.A.E.
            "00194380",    //DEUTSCHE BANK, S.A.E.
            "00194381",    //DEUTSCHE BANK, S.A.E.
            "00194382",    //DEUTSCHE BANK, S.A.E.
            "00194383",    //DEUTSCHE BANK, S.A.E.
            "00194384",    //DEUTSCHE BANK, S.A.E.
            "00194385",    //DEUTSCHE BANK, S.A.E.
            "00197695",    //DEUTSCHE BANK, S.A.E.
            "00304521",    //BANCO ESPAÑOL DE CREDITO
            "00305636",    //BANCO ESPAÑOL DE CREDITO
            "00305842",    //BANCO ESPAÑOL DE CREDITO
            "00306195",    //BANCO ESPAÑOL DE CREDITO
            "00306760",    //BANCO ESPAÑOL DE CREDITO
            "00308037",    //BANCO ESPAÑOL DE CREDITO
            "00308039",    //BANCO ESPAÑOL DE CREDITO
            "00308063",    //BANCO ESPAÑOL DE CREDITO
            "00490024",    //BANCO SANTANDER
            "00490348",    //BANCO SANTANDER
            "00492810",    //BANCO SANTANDER
            "00494644",    //BANCO SANTANDER
            "00494822",    //BANCO SANTANDER
            "00494843",    //BANCO SANTANDER
            "00494949",    //BANCO SANTANDER
            "00495038",    //BANCO SANTANDER
            "00495071",    //BANCO SANTANDER
            "00495084",    //BANCO SANTANDER
            "00495085",    //BANCO SANTANDER
            "00495363",    //BANCO SANTANDER
            "00496463",    //BANCO SANTANDER
            "00496466",    //BANCO SANTANDER
            "00651003",    //BARCLAYS BANK
            "00651004",    //BARCLAYS BANK
            "00651168",    //BARCLAYS BANK
            "00750105",    //BANCO POPULAR ESPAÑOL
            "00750597",    //BANCO POPULAR ESPAÑOL
            "00750787",    //BANCO POPULAR ESPAÑOL
            "00755714",    //BANCO POPULAR ESPAÑOL
            "00755801",    //BANCO POPULAR ESPAÑOL
            "00755802",    //BANCO POPULAR ESPAÑOL
            "00755830",    //BANCO POPULAR ESPAÑOL
            "00755843",    //BANCO POPULAR ESPAÑOL
            "00755844",    //BANCO POPULAR ESPAÑOL
            "00755886",    //BANCO POPULAR ESPAÑOL
            "00817155",    //BANCO DE SABADELL
            "00825714",    //BANCO DE CASTILLA
            "00825801",    //BANCO DE CASTILLA
            "00825802",    //BANCO DE CASTILLA
            "00825830",    //BANCO DE CASTILLA
            "00825843",    //BANCO DE CASTILLA
            "00825844",    //BANCO DE CASTILLA
            "00825886",    //BANCO DE CASTILLA
            "01220045",    //CITIBANK ESPAÑA
            "01280290",    //BANKINTER
            "01283411",    //BANKINTER
            "01331479",    //NUEVO MICRO BANK
            "01332349",    //NUEVO MICRO BANK
            "01334710",    //NUEVO MICRO BANK
            "01334964",    //NUEVO MICRO BANK
            "01336337",    //NUEVO MICRO BANK
            "01336823",    //NUEVO MICRO BANK
            "01336827",    //NUEVO MICRO BANK
            "01337975",    //NUEVO MICRO BANK
            "01337980",    //NUEVO MICRO BANK
            "01337985",    //NUEVO MICRO BANK
            "01337986",    //NUEVO MICRO BANK
            "01338029",    //NUEVO MICRO BANK
            "01820320",    //BANCO BILBAO VIZCAYA ARGENTARIA
            "01821328",    //BANCO BILBAO VIZCAYA ARGENTARIA
            "01822294",    //BANCO BILBAO VIZCAYA ARGENTARIA
            "01825549",    //BANCO BILBAO VIZCAYA ARGENTARIA
            "01825652",    //BANCO BILBAO VIZCAYA ARGENTARIA
            "01826100",    //BANCO BILBAO VIZCAYA ARGENTARIA
            "01826224",    //BANCO BILBAO VIZCAYA ARGENTARIA
            "01826844",    //BANCO BILBAO VIZCAYA ARGENTARIA
            "01829943",    //BANCO BILBAO VIZCAYA ARGENTARIA
            "20131565",    //CATALUNYA BANC
            "20387583",    //BANKIA
            "20389417",    //BANKIA
            "20771211",    //C.A. VALENCIA,CASTELLON Y ALICANTE
            "20801034",    //NCG BANCO
            "20858087",    //IBERCAJA BANCO
            "20859609",    //IBERCAJA BANCO
            "20859610",    //IBERCAJA BANCO
            "20859611",    //IBERCAJA BANCO
            "20905370",    //BANCO CAM
            "20911034",    //CAJA DE AHORROS DE GALICIA
            "20960507",    //CAJA ESPAÑA INV.SALAMANCA SORIA2096
            "20960693",    //CAJA ESPAÑA INV.SALAMANCA SORIA2096
            "21001479",    //CAIXABANK
            "21002349",    //CAIXABANK
            "21004710",    //CAIXABANK
            "21004964",    //CAIXABANK
            "21006337",    //CAIXABANK
            "21006823",    //CAIXABANK
            "21006827",    //CAIXABANK
            "21007975",    //CAIXABANK
            "21007980",    //CAIXABANK
            "21007985",    //CAIXABANK
            "21007986",    //CAIXABANK
            "21008029",    //CAIXABANK
            "21040501",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040502",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040503",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040504",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040505",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040506",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040510",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040511",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040512",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040513",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040514",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040515",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040520",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040521",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040530",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040531",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040540",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040541",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040542",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040543",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040544",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040545",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040546",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040547",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040550",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040551",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040552",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040553",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040560",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040561",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040570",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040571",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040572",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040580",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040581",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040582",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040590",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040591",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040592",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040593",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040594",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040595",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040600",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040601",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040620",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040630",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040632",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040640",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040641",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040642",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040650",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040651",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040652",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040660",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040661",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040662",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040663",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040664",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040665",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040670",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040680",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040690",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040700",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21040743",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "21041676",    //CAJA ESPAÑA INV.SALAMANCA SORIA2104
            "30170100",    //CAJA RURAL DE SORIA
            "30170101",    //CAJA RURAL DE SORIA
            "30170102",    //CAJA RURAL DE SORIA
            "30170103",    //CAJA RURAL DE SORIA
            "30170104",    //CAJA RURAL DE SORIA
            "30170105",    //CAJA RURAL DE SORIA
            "30170106",    //CAJA RURAL DE SORIA
            "30170107",    //CAJA RURAL DE SORIA
            "30170108",    //CAJA RURAL DE SORIA
            "30170110",    //CAJA RURAL DE SORIA
            "30170111",    //CAJA RURAL DE SORIA
            "30170113",    //CAJA RURAL DE SORIA
            "30170115",    //CAJA RURAL DE SORIA
            "30170120",    //CAJA RURAL DE SORIA
            "30170125",    //CAJA RURAL DE SORIA
            "30170130",    //CAJA RURAL DE SORIA
            "30170140",    //CAJA RURAL DE SORIA
            "30170150",    //CAJA RURAL DE SORIA
            "30170160",    //CAJA RURAL DE SORIA
            "30170170",    //CAJA RURAL DE SORIA
            "30170200",    //CAJA RURAL DE SORIA
            "30170201",    //CAJA RURAL DE SORIA
            "30170220",    //CAJA RURAL DE SORIA
            "30170240",    //CAJA RURAL DE SORIA
            "30170250",    //CAJA RURAL DE SORIA
            "30170300",    //CAJA RURAL DE SORIA
            "30170400",    //CAJA RURAL DE SORIA
            "30170410",    //CAJA RURAL DE SORIA
            "30170430",    //CAJA RURAL DE SORIA
            "30170500",    //CAJA RURAL DE SORIA
            "30170558",    //CAJA RURAL DE SORIA
            "30170600",    //CAJA RURAL DE SORIA
            "30170610",    //CAJA RURAL DE SORIA
            "30170700",    //CAJA RURAL DE SORIA
            "30170710",    //CAJA RURAL DE SORIA
            "30170720",    //CAJA RURAL DE SORIA
            "30170730",    //CAJA RURAL DE SORIA
            "30170800",    //CAJA RURAL DE SORIA
            "30170900",    //CAJA RURAL DE SORIA
            "30179122",    //CAJA RURAL DE SORIA
            "30179123",    //CAJA RURAL DE SORIA
            "30179124",    //CAJA RURAL DE SORIA
            "30179125",    //CAJA RURAL DE SORIA
            "30585801",    //CAJAS RURALES UNIDAS,SDAD.COOP.CDTO
    };

}