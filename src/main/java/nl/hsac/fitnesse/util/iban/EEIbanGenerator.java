package nl.hsac.fitnesse.util.iban;

public class EEIbanGenerator extends IbanGenerator {

    /**
     * Generates random number to create IBAN.
     *
     * @return random Estonian IBAN.
     */

    public String generateIban(String bankCode) {

        String countryCode = "EE";
        int accountLength = 14;
        String accountCodeType = "N";
        int bankCodeLength = 2;
        String bankCodeType = "N";

        bankCode = getBankCode(bankCode, BANK_CODE_LIST, bankCodeLength, bankCodeType);
        String account = getAccount(accountLength, accountCodeType);
        String controlNr = getControlNumber(bankCode, account, countryCode);

        return countryCode + controlNr + bankCode + account;

    }

    public final static String[] BANK_CODE_LIST = {

            "00",    //Tallinn Business Bank
            "42",    //Eesti Krediidipank
            "16",    //Bank of Estonia
            "10",    //SEB Bank
            "22",    //Swedbank
            "96",    //DNB Bank
            "17",    //Nordea Bank Finland PLC Estonian branch
            "12",    //Citadele Bank Estonian branch
            "55",    //Versobank
            "33",    //Danske Bank Estonian branch
            "83",    //Svenska Handelsbanken
            "51",    //Pohjola Bank plc Estonian branch
            "77",    //LHV Bank
            "75",    //BIGBANK

    };
}