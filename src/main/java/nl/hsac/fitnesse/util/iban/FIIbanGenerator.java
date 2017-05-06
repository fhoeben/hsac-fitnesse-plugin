package nl.hsac.fitnesse.util.iban;

public class FIIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     * Finland has a very complex system to create a check digit as the last digitt
     * Similar to Germany, we choose to ignore this now.
     * Bankcode is including branch code
     *
     * @param bankCode bank code to (blank for random).
     * @return random IBAN.
     */
    public String generateIban(String bankCode) {

        String countryCode = "FI";
        int accountLength = 11;
        String accountCodeType = "N";
        int bankCodeLength = 3;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, BANK_CODE_LIST, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    public final static String[] BANK_CODE_LIST = {
            "405",    //Aktia Bank
            "497",    //Aktia Bank
            "470",    //Local Co-operative Banks (POP)
            "471",    //Local Co-operative Banks (POP)
            "472",    //Local Co-operative Banks (POP)
            "473",    //Local Co-operative Banks (POP)
            "474",    //Local Co-operative Banks (POP)
            "475",    //Local Co-operative Banks (POP)
            "476",    //Local Co-operative Banks (POP)
            "477",    //Local Co-operative Banks (POP)
            "478",    //Local Co-operative Banks (POP)
            "479",    //Bonum Bank
            "713",    //Citibank
            "8",    //Danske Bank
            "34",    //Danske Bank
            "37",    //DNB Bank ASA Finland Branch
            "31",    //Handelsbanken
            "799",    //Holvi Payment Services
            "715",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "400",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "402",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "403",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "406",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "407",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "408",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "410",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "411",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "412",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "414",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "415",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "416",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "417",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "418",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "419",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "420",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "421",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "423",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "424",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "425",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "426",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "427",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "428",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "429",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "430",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "431",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "432",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "435",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "436",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "437",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "438",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "439",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "440",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "441",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "442",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "443",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "444",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "445",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "446",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "447",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "448",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "449",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "450",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "451",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "452",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "454",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "455",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "456",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "457",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "458",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "459",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "460",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "461",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "462",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "463",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "464",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "483",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "484",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "485",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "486",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "487",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "488",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "489",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "490",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "491",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "492",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "493",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "495",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "496",    //Central Bank of Savings Banks Finland and Savings Banks (Sp) and Oma Säästöpankki
            "1",    //Nordea Bank (Nordea)
            "2",    //Nordea Bank (Nordea)
            "5",    //Pohjola Bank
            "33",   //Skandinaviska Enskilda Banken
            "36",   //S-Bank
            "39",   //S-Bank
            "38",   //Swedbank
            "6",    //Bank of Åland (ÅAB)
    };

}