package nl.hsac.fitnesse.util.iban;

import nl.hsac.fitnesse.util.RandomUtil;

/**
 * Generates a Swiss IBAN.
 */

public class CHIban {
    private RandomUtil randomUtil = new RandomUtil();
    private IbanUtil ibanUtil = new IbanUtil();

    /**
     * Generates random number to create IBAN.
     *
     * @return random Swiss IBAN.
     */

    public String generateCHIban(String country, String bankCode) {

        if (country.equals("")) {
            country = "CH";
        }

        bankCode = ibanUtil.getBankCode(bankCode, CHBankCodes);
        bankCode = ibanUtil.padWithStartingZeros(bankCode, 5);


        String permittedAccountDigits = "0123456789";
        String accountNumber = randomUtil.randomString(permittedAccountDigits, 12);

        String baseIbanStr = bankCode + accountNumber + ibanUtil.stringToNumbersIso13616(country) + "00";

        String controlNr = String.valueOf(98 - IbanUtil.mod97(baseIbanStr));
        if (controlNr.length() == 1) {
            controlNr = "0" + controlNr;
        }

        return country + controlNr + bankCode + accountNumber;

    }


    /**
     * Array of Swiss Bank codes
     */

    public String[] CHBankCodes = {
            "100", //Schweizerische Nationalbank
            "110", //Schweizerische Nationalbank
            "115", //Schweizerische Nationalbank
            "193", //SECB Swiss Euro Clearing Bank
            "202", //UBS Switzerland AG
            "203", //UBS Switzerland AG
            "204", //UBS Switzerland AG
            "206", //UBS Switzerland AG
            "207", //UBS Switzerland AG
            "208", //UBS Switzerland AG
            "209", //UBS Switzerland AG
            "210", //UBS Switzerland AG
            "211", //UBS Switzerland AG
            "213", //UBS Switzerland AG
            "214", //UBS Switzerland AG
            "216", //UBS Switzerland AG
            "217", //UBS Switzerland AG
            "219", //UBS Switzerland AG
            "220", //UBS Switzerland AG
            "221", //UBS Switzerland AG
            "222", //UBS Switzerland AG
            "223", //UBS Switzerland AG
            "225", //UBS Switzerland AG
            "226", //UBS Switzerland AG
            "227", //UBS Switzerland AG
            "228", //UBS Switzerland AG
            "230", //UBS Switzerland AG
            "231", //UBS Switzerland AG
            "232", //UBS Switzerland AG
            "233", //UBS Switzerland AG
            "234", //UBS Switzerland AG
            "235", //UBS Switzerland AG
            "236", //UBS Switzerland AG
            "238", //UBS Switzerland AG
            "239", //UBS Switzerland AG
            "240", //UBS Switzerland AG
            "241", //UBS Switzerland AG
            "242", //UBS Switzerland AG
            "243", //UBS Switzerland AG
            "244", //UBS Switzerland AG
            "245", //UBS Switzerland AG
            "246", //UBS Switzerland AG
            "247", //UBS Switzerland AG
            "248", //UBS Switzerland AG
            "249", //UBS Switzerland AG
            "250", //UBS Switzerland AG
            "251", //UBS Switzerland AG
            "252", //UBS Switzerland AG
            "253", //UBS Switzerland AG
            "254", //UBS Switzerland AG
            "255", //UBS Switzerland AG
            "256", //UBS Switzerland AG
            "257", //UBS Switzerland AG
            "258", //UBS Switzerland AG
            "259", //UBS Switzerland AG
            "260", //UBS Switzerland AG
            "261", //UBS Switzerland AG
            "262", //UBS Switzerland AG
            "263", //UBS Switzerland AG
            "264", //UBS Switzerland AG
            "265", //UBS Switzerland AG
            "266", //UBS Switzerland AG
            "267", //UBS Switzerland AG
            "268", //UBS Switzerland AG
            "269", //UBS Switzerland AG
            "270", //UBS Switzerland AG
            "271", //UBS Switzerland AG
            "272", //UBS Switzerland AG
            "273", //UBS Switzerland AG
            "274", //UBS Switzerland AG
            "275", //UBS Switzerland AG
            "276", //UBS Switzerland AG
            "277", //UBS Switzerland AG
            "278", //UBS Switzerland AG
            "279", //UBS Switzerland AG
            "283", //UBS Switzerland AG
            "284", //UBS Switzerland AG
            "285", //UBS Switzerland AG
            "286", //UBS Switzerland AG
            "287", //UBS Switzerland AG
            "288", //UBS Switzerland AG
            "290", //UBS Switzerland AG
            "291", //UBS Switzerland AG
            "292", //UBS Switzerland AG
            "293", //UBS Switzerland AG
            "294", //UBS Switzerland AG
            "295", //UBS Switzerland AG
            "296", //UBS Switzerland AG
            "297", //UBS Switzerland AG
            "298", //UBS Switzerland AG
            "315", //UBS AG
            "4003", //Credit Suisse (Schweiz) AG
            "4006", //Credit Suisse (Schweiz) AG
            "4017", //Credit Suisse (Schweiz) AG
            "4020", //Credit Suisse (Schweiz) AG
            "4023", //Credit Suisse (Schweiz) AG
            "4036", //Credit Suisse (Schweiz) AG
            "4041", //Credit Suisse (Schweiz) AG
            "4047", //Credit Suisse (Schweiz) AG
            "4049", //Credit Suisse (Schweiz) AG
            "4050", //Credit Suisse (Schweiz) AG
            "4055", //Credit Suisse (Schweiz) AG
            "4060", //Credit Suisse (Schweiz) AG
            "4061", //Credit Suisse (Schweiz) AG
            "4073", //Credit Suisse (Schweiz) AG
            "4083", //Credit Suisse (Schweiz) AG
            "4088", //Credit Suisse (Schweiz) AG
            "4090", //Credit Suisse (Schweiz) AG
            "4094", //Credit Suisse (Schweiz) AG
            "4097", //Credit Suisse (Schweiz) AG
            "4106", //Credit Suisse (Schweiz) AG
            "4108", //Credit Suisse (Schweiz) AG
            "4112", //Credit Suisse (Schweiz) AG
            "4115", //Credit Suisse (Schweiz) AG
            "4132", //Credit Suisse (Schweiz) AG
            "4141", //Credit Suisse (Schweiz) AG
            "4144", //Credit Suisse (Schweiz) AG
            "4147", //Credit Suisse (Schweiz) AG
            "4150", //Credit Suisse (Schweiz) AG
            "4155", //Credit Suisse (Schweiz) AG
            "4156", //Credit Suisse (Schweiz) AG
            "4163", //Credit Suisse (Schweiz) AG
            "4172", //Credit Suisse (Schweiz) AG
            "4175", //Credit Suisse (Schweiz) AG
            "4177", //Credit Suisse (Schweiz) AG
            "4182", //Credit Suisse (Schweiz) AG
            "4187", //Credit Suisse (Schweiz) AG
            "4188", //Credit Suisse (Schweiz) AG
            "4190", //Credit Suisse (Schweiz) AG
            "4192", //Credit Suisse (Schweiz) AG
            "4193", //Credit Suisse (Schweiz) AG
            "4199", //Credit Suisse (Schweiz) AG
            "4204", //Credit Suisse (Schweiz) AG
            "4209", //Credit Suisse (Schweiz) AG
            "4210", //Credit Suisse (Schweiz) AG
            "4213", //Credit Suisse (Schweiz) AG
            "4216", //Credit Suisse (Schweiz) AG
            "4226", //Credit Suisse (Schweiz) AG
            "4230", //Credit Suisse (Schweiz) AG
            "4235", //Credit Suisse (Schweiz) AG
            "4243", //Credit Suisse (Schweiz) AG
            "4251", //Credit Suisse (Schweiz) AG
            "4254", //Credit Suisse (Schweiz) AG
            "4266", //Credit Suisse (Schweiz) AG
            "4267", //Credit Suisse (Schweiz) AG
            "4271", //Credit Suisse (Schweiz) AG
            "4272", //Credit Suisse (Schweiz) AG
            "4274", //Credit Suisse (Schweiz) AG
            "4278", //Credit Suisse (Schweiz) AG
            "4279", //Credit Suisse (Schweiz) AG
            "4280", //Credit Suisse (Schweiz) AG
            "4281", //Credit Suisse (Schweiz) AG
            "4322", //Credit Suisse (Schweiz) AG
            "4323", //Credit Suisse (Schweiz) AG
            "4334", //Credit Suisse (Schweiz) AG
            "4337", //Credit Suisse (Schweiz) AG
            "4339", //Credit Suisse (Schweiz) AG
            "4343", //Credit Suisse (Schweiz) AG
            "4353", //Credit Suisse (Schweiz) AG
            "4355", //Credit Suisse (Schweiz) AG
            "4358", //Credit Suisse (Schweiz) AG
            "4363", //Credit Suisse (Schweiz) AG
            "4367", //Credit Suisse (Schweiz) AG
            "4373", //Credit Suisse (Schweiz) AG
            "4381", //Credit Suisse (Schweiz) AG
            "4383", //Credit Suisse (Schweiz) AG
            "4384", //Credit Suisse (Schweiz) AG
            "4396", //Credit Suisse (Schweiz) AG
            "4400", //Credit Suisse (Schweiz) AG
            "4405", //Credit Suisse (Schweiz) AG
            "4412", //Credit Suisse (Schweiz) AG
            "4413", //Credit Suisse (Schweiz) AG
            "4419", //Credit Suisse (Schweiz) AG
            "4424", //Credit Suisse (Schweiz) AG
            "4425", //Credit Suisse (Schweiz) AG
            "4427", //Credit Suisse (Schweiz) AG
            "4428", //Credit Suisse (Schweiz) AG
            "4429", //Credit Suisse (Schweiz) AG
            "4441", //Neue Aargauer Bank AG
            "4446", //Credit Suisse (Schweiz) AG
            "4451", //Credit Suisse (Schweiz) AG
            "4455", //Credit Suisse (Schweiz) AG
            "4456", //Credit Suisse (Schweiz) AG
            "4457", //Credit Suisse (Schweiz) AG
            "4458", //Credit Suisse (Schweiz) AG
            "4459", //Credit Suisse (Schweiz) AG
            "4463", //Credit Suisse (Schweiz) AG
            "4465", //Credit Suisse (Schweiz) AG
            "4467", //Credit Suisse (Schweiz) AG
            "4469", //Credit Suisse (Schweiz) AG
            "4480", //Credit Suisse (Schweiz) AG
            "4486", //Credit Suisse (Schweiz) AG
            "4488", //Credit Suisse (Schweiz) AG
            "4490", //Credit Suisse (Schweiz) AG
            "4497", //Credit Suisse (Schweiz) AG
            "4499", //Credit Suisse (Schweiz) AG
            "4500", //Credit Suisse (Schweiz) AG
            "4503", //Credit Suisse (Schweiz) AG
            "4507", //Credit Suisse (Schweiz) AG
            "4520", //Credit Suisse (Schweiz) AG
            "4528", //Credit Suisse (Schweiz) AG
            "4531", //Credit Suisse (Schweiz) AG
            "4541", //Credit Suisse (Schweiz) AG
            "4556", //Credit Suisse (Schweiz) AG
            "4565", //Credit Suisse (Schweiz) AG
            "4570", //Credit Suisse (Schweiz) AG
            "4573", //Credit Suisse (Schweiz) AG
            "4574", //Credit Suisse (Schweiz) AG
            "4580", //Credit Suisse (Schweiz) AG
            "4585", //Credit Suisse (Schweiz) AG
            "4589", //Credit Suisse (Schweiz) AG
            "4595", //Credit Suisse (Schweiz) AG
            "4596", //Credit Suisse (Schweiz) AG
            "4598", //Credit Suisse (Schweiz) AG
            "4605", //Credit Suisse (Schweiz) AG
            "4607", //Credit Suisse (Schweiz) AG
            "4614", //Credit Suisse (Schweiz) AG
            "4616", //Credit Suisse (Schweiz) AG
            "4625", //Credit Suisse (Schweiz) AG
            "4631", //Credit Suisse (Schweiz) AG
            "4637", //Credit Suisse (Schweiz) AG
            "4642", //Credit Suisse (Schweiz) AG
            "4644", //Credit Suisse (Schweiz) AG
            "4647", //Credit Suisse (Schweiz) AG
            "4648", //Credit Suisse (Schweiz) AG
            "4654", //Credit Suisse (Schweiz) AG
            "4655", //Credit Suisse (Schweiz) AG
            "4656", //Credit Suisse (Schweiz) AG
            "4658", //Credit Suisse (Schweiz) AG
            "4659", //Credit Suisse (Schweiz) AG
            "4660", //Credit Suisse (Schweiz) AG
            "4663", //Credit Suisse (Schweiz) AG
            "4665", //Credit Suisse (Schweiz) AG
            "4667", //Credit Suisse (Schweiz) AG
            "4671", //Credit Suisse (Schweiz) AG
            "4674", //Credit Suisse (Schweiz) AG
            "4678", //Credit Suisse (Schweiz) AG
            "4680", //Credit Suisse (Schweiz) AG
            "4685", //Credit Suisse (Schweiz) AG
            "4691", //Neue Aargauer Bank AG
            "4694", //Credit Suisse (Schweiz) AG
            "4697", //Credit Suisse (Schweiz) AG
            "4706", //Credit Suisse (Schweiz) AG
            "4712", //Credit Suisse (Schweiz) AG
            "4716", //Credit Suisse (Schweiz) AG
            "4720", //Credit Suisse (Schweiz) AG
            "4721", //Credit Suisse (Schweiz) AG
            "4737", //Credit Suisse (Schweiz) AG
            "4741", //Credit Suisse (Schweiz) AG
            "4744", //Credit Suisse (Schweiz) AG
            "4747", //Credit Suisse (Schweiz) AG
            "4748", //Credit Suisse (Schweiz) AG
            "4750", //Credit Suisse (Schweiz) AG
            "4758", //Credit Suisse (Schweiz) AG
            "4763", //Credit Suisse (Schweiz) AG
            "4765", //Credit Suisse (Schweiz) AG
            "4770", //Credit Suisse (Schweiz) AG
            "4772", //Credit Suisse (Schweiz) AG
            "4777", //Credit Suisse (Schweiz) AG
            "4781", //Neue Aargauer Bank AG
            "4784", //Credit Suisse (Schweiz) AG
            "4787", //Credit Suisse (Schweiz) AG
            "4791", //Credit Suisse (Schweiz) AG
            "4795", //Credit Suisse (Schweiz) AG
            "4796", //Credit Suisse (Schweiz) AG
            "4806", //Credit Suisse (Schweiz) AG
            "4811", //Credit Suisse (Schweiz) AG
            "4814", //Credit Suisse (Schweiz) AG
            "4818", //Credit Suisse (Schweiz) AG
            "4823", //Credit Suisse (Schweiz) AG
            "4835", //Credit Suisse (Schweiz) AG
            "4836", //Credit Suisse (Schweiz) AG
            "4837", //Credit Suisse (Schweiz) AG
            "4839", //Credit Suisse (Schweiz) AG
            "4840", //Credit Suisse (Schweiz) AG
            "4842", //Credit Suisse (Schweiz) AG
            "4845", //Credit Suisse (Schweiz) AG
            "4848", //Credit Suisse (Schweiz) AG
            "4850", //Credit Suisse (Schweiz) AG
            "4852", //Credit Suisse (Schweiz) AG
            "4857", //Credit Suisse (Schweiz) AG
            "4858", //Credit Suisse (Schweiz) AG
            "4860", //Credit Suisse (Schweiz) AG
            "4862", //Credit Suisse (Schweiz) AG
            "4864", //Credit Suisse (Schweiz) AG
            "4865", //Credit Suisse (Schweiz) AG
            "4866", //Credit Suisse AG
            "4868", //Credit Suisse (Schweiz) AG
            "4870", //Credit Suisse (Schweiz) AG
            "4872", //Credit Suisse (Schweiz) AG
            "4877", //Credit Suisse (Schweiz) AG
            "4878", //Credit Suisse (Schweiz) AG
            "4879", //Credit Suisse (Schweiz) AG
            "4892", //Credit Suisse (Schweiz) AG
            "4893", //Credit Suisse (Schweiz) AG
            "501", //Neue Aargauer Bank AG
            "502", //Credit Suisse (Schweiz) AG
            "503", //Credit Suisse (Schweiz) AG
            "504", //Credit Suisse (Schweiz) AG
            "505", //Credit Suisse (Schweiz) AG
            "506", //Credit Suisse (Schweiz) AG
            "5065", //Credit Suisse (Schweiz) AG
            "507", //Credit Suisse (Schweiz) AG
            "508", //Credit Suisse (Schweiz) AG
            "509", //Neue Aargauer Bank AG
            "510", //Credit Suisse (Schweiz) AG
            "511", //Credit Suisse (Schweiz) AG
            "512", //Credit Suisse (Schweiz) AG
            "513", //Credit Suisse (Schweiz) AG
            "514", //Credit Suisse (Schweiz) AG
            "515", //Credit Suisse (Schweiz) AG
            "516", //Credit Suisse (Schweiz) AG
            "517", //Credit Suisse (Schweiz) AG
            "518", //Credit Suisse (Schweiz) AG
            "519", //Credit Suisse (Schweiz) AG
            "5195", //Credit Suisse (Schweiz) AG
            "520", //Credit Suisse (Schweiz) AG
            "5205", //Credit Suisse (Schweiz) AG
            "5209", //Credit Suisse (Schweiz) AG
            "521", //Credit Suisse (Schweiz) AG
            "5212", //Credit Suisse (Schweiz) AG
            "5215", //Credit Suisse (Schweiz) AG
            "522", //Credit Suisse (Schweiz) AG
            "523", //Credit Suisse (Schweiz) AG
            "524", //Credit Suisse (Schweiz) AG
            "525", //Credit Suisse (Schweiz) AG
            "526", //Neue Aargauer Bank AG
            "527", //Credit Suisse (Schweiz) AG
            "528", //Credit Suisse (Schweiz) AG
            "5288", //Credit Suisse (Schweiz) AG
            "529", //Credit Suisse (Schweiz) AG
            "530", //Credit Suisse (Schweiz) AG
            "5301", //Credit Suisse (Schweiz) AG
            "5302", //Credit Suisse (Schweiz) AG
            "5303", //Credit Suisse (Schweiz) AG
            "5304", //Credit Suisse (Schweiz) AG
            "5305", //Credit Suisse (Schweiz) AG
            "5306", //Credit Suisse (Schweiz) AG
            "5307", //Credit Suisse (Schweiz) AG
            "5308", //Credit Suisse (Schweiz) AG
            "5309", //Credit Suisse (Schweiz) AG
            "531", //Credit Suisse (Schweiz) AG
            "5311", //Credit Suisse (Schweiz) AG
            "5312", //Credit Suisse (Schweiz) AG
            "5313", //Credit Suisse (Schweiz) AG
            "5314", //Credit Suisse (Schweiz) AG
            "5315", //Credit Suisse (Schweiz) AG
            "5316", //Credit Suisse (Schweiz) AG
            "5317", //Credit Suisse (Schweiz) AG
            "5318", //Credit Suisse (Schweiz) AG
            "5319", //Credit Suisse (Schweiz) AG
            "532", //Credit Suisse (Schweiz) AG
            "5321", //Credit Suisse (Schweiz) AG
            "5322", //Credit Suisse (Schweiz) AG
            "5323", //Credit Suisse (Schweiz) AG
            "5324", //Neue Aargauer Bank AG
            "5325", //Credit Suisse (Schweiz) AG
            "5326", //Credit Suisse (Schweiz) AG
            "5327", //Credit Suisse (Schweiz) AG
            "5328", //Credit Suisse (Schweiz) AG
            "533", //Credit Suisse (Schweiz) AG
            "5331", //Credit Suisse (Schweiz) AG
            "5332", //Credit Suisse (Schweiz) AG
            "5333", //Credit Suisse (Schweiz) AG
            "5334", //Credit Suisse (Schweiz) AG
            "5335", //Credit Suisse (Schweiz) AG
            "5336", //Credit Suisse (Schweiz) AG
            "5337", //Credit Suisse (Schweiz) AG
            "5338", //Neue Aargauer Bank AG
            "5339", //Credit Suisse (Schweiz) AG
            "534", //Credit Suisse (Schweiz) AG
            "5342", //Credit Suisse (Schweiz) AG
            "5343", //Credit Suisse (Schweiz) AG
            "5344", //Credit Suisse (Schweiz) AG
            "5345", //Credit Suisse (Schweiz) AG
            "5347", //Credit Suisse (Schweiz) AG
            "5348", //Credit Suisse (Schweiz) AG
            "5349", //Credit Suisse (Schweiz) AG
            "535", //Credit Suisse (Schweiz) AG
            "5351", //Credit Suisse (Schweiz) AG
            "5352", //Credit Suisse (Schweiz) AG
            "5353", //Credit Suisse (Schweiz) AG
            "5354", //Credit Suisse (Schweiz) AG
            "5355", //Credit Suisse (Schweiz) AG
            "5356", //Credit Suisse (Schweiz) AG
            "5357", //Credit Suisse (Schweiz) AG
            "5358", //Credit Suisse (Schweiz) AG
            "5359", //Credit Suisse (Schweiz) AG
            "536", //Neue Aargauer Bank AG
            "5361", //Credit Suisse (Schweiz) AG
            "5362", //Credit Suisse (Schweiz) AG
            "5363", //Credit Suisse (Schweiz) AG
            "5364", //Credit Suisse (Schweiz) AG
            "5365", //Credit Suisse (Schweiz) AG
            "5366", //Credit Suisse (Schweiz) AG
            "5368", //Credit Suisse (Schweiz) AG
            "537", //Credit Suisse (Schweiz) AG
            "5371", //Credit Suisse (Schweiz) AG
            "5373", //Credit Suisse (Schweiz) AG
            "5374", //Credit Suisse (Schweiz) AG
            "5375", //Credit Suisse (Schweiz) AG
            "5376", //Credit Suisse (Schweiz) AG
            "5377", //Credit Suisse (Schweiz) AG
            "5378", //Credit Suisse (Schweiz) AG
            "538", //Credit Suisse (Schweiz) AG
            "539", //Credit Suisse (Schweiz) AG
            "540", //Credit Suisse (Schweiz) AG
            "541", //Credit Suisse (Schweiz) AG
            "542", //Credit Suisse (Schweiz) AG
            "543", //Credit Suisse (Schweiz) AG
            "544", //Credit Suisse (Schweiz) AG
            "545", //Credit Suisse (Schweiz) AG
            "546", //Credit Suisse (Schweiz) AG
            "547", //Credit Suisse (Schweiz) AG
            "548", //Credit Suisse (Schweiz) AG
            "549", //Credit Suisse (Schweiz) AG
            "550", //Credit Suisse (Schweiz) AG
            "551", //Credit Suisse (Schweiz) AG
            "552", //Credit Suisse (Schweiz) AG
            "553", //Credit Suisse (Schweiz) AG
            "554", //Credit Suisse (Schweiz) AG
            "555", //Credit Suisse (Schweiz) AG
            "556", //Credit Suisse (Schweiz) AG
            "557", //Credit Suisse (Schweiz) AG
            "558", //Credit Suisse (Schweiz) AG
            "559", //Credit Suisse (Schweiz) AG
            "560", //Credit Suisse (Schweiz) AG
            "561", //Credit Suisse (Schweiz) AG
            "5611", //Credit Suisse (Schweiz) AG
            "562", //Credit Suisse (Schweiz) AG
            "563", //Credit Suisse (Schweiz) AG
            "564", //Credit Suisse (Schweiz) AG
            "565", //Credit Suisse (Schweiz) AG
            "566", //Credit Suisse (Schweiz) AG
            "567", //Credit Suisse (Schweiz) AG
            "568", //Credit Suisse (Schweiz) AG
            "569", //Credit Suisse (Schweiz) AG
            "570", //Credit Suisse (Schweiz) AG
            "571", //Credit Suisse (Schweiz) AG
            "572", //Credit Suisse (Schweiz) AG
            "573", //Credit Suisse (Schweiz) AG
            "574", //Neue Aargauer Bank AG
            "575", //Credit Suisse (Schweiz) AG
            "576", //Credit Suisse (Schweiz) AG
            "577", //Credit Suisse (Schweiz) AG
            "578", //Neue Aargauer Bank AG
            "579", //Credit Suisse (Schweiz) AG
            "580", //Credit Suisse (Schweiz) AG
            "581", //Credit Suisse (Schweiz) AG
            "582", //Credit Suisse (Schweiz) AG
            "583", //Credit Suisse (Schweiz) AG
            "584", //Credit Suisse (Schweiz) AG
            "585", //Credit Suisse (Schweiz) AG
            "586", //Credit Suisse (Schweiz) AG
            "587", //Credit Suisse (Schweiz) AG
            "588", //Credit Suisse (Schweiz) AG
            "5881", //Neue Aargauer Bank AG
            "5882", //Neue Aargauer Bank AG
            "5883", //Neue Aargauer Bank AG
            "5884", //Neue Aargauer Bank AG
            "5885", //Neue Aargauer Bank AG
            "5886", //Neue Aargauer Bank AG
            "5887", //Neue Aargauer Bank AG
            "5889", //Neue Aargauer Bank AG
            "589", //Credit Suisse (Schweiz) AG
            "5899", //Neue Aargauer Bank AG
            "590", //Credit Suisse (Schweiz) AG
            "591", //Credit Suisse (Schweiz) AG
            "592", //Credit Suisse (Schweiz) AG
            "593", //Credit Suisse (Schweiz) AG
            "594", //Credit Suisse (Schweiz) AG
            "595", //Credit Suisse (Schweiz) AG
            "6180", //Crédit Mutuel de la Vallée SA
            "6182", //Caisse d'Epargne de Cossonay société coopérative
            "6186", //Sparkasse Sense
            "61861", //Sparkasse Sense
            "6240", //Caisse d'Epargne CEC SA
            "62401", //Caisse d'Epargne CEC SA
            "62402", //Caisse d'Epargne CEC SA
            "62403", //Caisse d'Epargne CEC SA
            "6300", //Valiant Bank AG
            "6305", //Valiant Bank AG (ex Valiant Privatbank AG)
            "6313", //Bernerland Bank AG
            "6336", //Clientis AG
            "6342", //SB Saanen Bank AG
            "6363", //Bank SLM AG
            "6374", //Spar+Leihkasse Riggisberg AG
            "6382", //Burgerliche Ersparniskasse Bern Genossenschaft
            "6387", //Ersparniskasse Affoltern i. E. AG
            "6395", //Entris Banking AG
            "6428", //Clientis Sparkasse Oftringen Genossenschaft
            "6434", //Clientis Bank im Thal AG
            "6450", //Bank Oberaargau AG
            "6575", //Clientis Bank Küttigen-Erlinsbach AG
            "6588", //Bank Leerau Genossenschaft
            "6633", //Sparkasse Schwyz AG
            "6666", //Sparkasse Engelberg AG
            "6670", //Clientis EB Entlebucher Bank AG
            "66701", //Clientis EB Entlebucher Bank AG
            "66702", //Clientis EB Entlebucher Bank AG
            "6690", //Triba Partner Bank AG
            "66901", //Triba Partner Bank AG
            "66902", //Triba Partner Bank AG
            "66905", //Triba Partner Bank AG
            "66906", //Triba Partner Bank AG
            "66907", //Triba Partner Bank AG
            "6807", //GRB Glarner Regionalbank Genossenschaft
            "6808", //Bank Sparhafen
            "6814", //Sparcassa 1816 Genossenschaft
            "68141", //Sparcassa 1816 Genossenschaft
            "68142", //Sparcassa 1816 Genossenschaft
            "68143", //Sparcassa 1816 Genossenschaft
            "68144", //Sparcassa 1816 Genossenschaft
            "6824", //BANK ZIMMERBERG AG
            "68241", //BANK ZIMMERBERG AG
            "68242", //BANK ZIMMERBERG AG
            "6828", //Regiobank Männedorf AG
            "6830", //Lienhardt & Partner Privatbank Zürich AG
            "6835", //Ersparniskasse Schaffhausen AG
            "6850", //Clientis Zürcher Regionalbank Genossenschaft
            "6858", //BS Bank Schaffhausen AG
            "6866", //Spar- und Leihkasse Thayngen AG
            "6873", //acrevis Bank AG
            "6875", //Leihkasse Stammheim AG
            "6877", //Zürcher Landbank AG
            "6888", //Bank BSU Genossenschaft
            "6900", //acrevis Bank AG
            "6910", //acrevis Bank AG
            "6920", //Alpha RHEINTAL Bank AG
            "6935", //Clientis Bank Oberuzwil AG
            "6950", //Vadian Bank AG
            "6955", //Clientis Bank Toggenburg AG
            "6964", //Bank in Zuzwil
            "6977", //Clientis Bank Thur Genossenschaft
            "6980", //Biene Bank im Rheintal Genossenschaft
            "700", //Zürcher Kantonalbank
            "702", //Zürcher Kantonalbank
            "703", //Zürcher Kantonalbank
            "704", //Zürcher Kantonalbank
            "705", //Zürcher Kantonalbank
            "706", //Zürcher Kantonalbank
            "708", //Zürcher Kantonalbank
            "709", //Zürcher Kantonalbank
            "710", //Zürcher Kantonalbank
            "711", //Zürcher Kantonalbank
            "712", //Zürcher Kantonalbank
            "713", //Zürcher Kantonalbank
            "714", //Zürcher Kantonalbank
            "715", //Zürcher Kantonalbank
            "716", //Zürcher Kantonalbank
            "717", //Zürcher Kantonalbank
            "718", //Zürcher Kantonalbank
            "719", //Zürcher Kantonalbank
            "720", //Zürcher Kantonalbank
            "721", //Zürcher Kantonalbank
            "722", //Zürcher Kantonalbank
            "723", //Zürcher Kantonalbank
            "724", //Zürcher Kantonalbank
            "725", //Zürcher Kantonalbank
            "726", //Zürcher Kantonalbank
            "727", //Zürcher Kantonalbank
            "728", //Zürcher Kantonalbank
            "729", //Zürcher Kantonalbank
            "730", //Zürcher Kantonalbank
            "731", //Zürcher Kantonalbank
            "732", //Zürcher Kantonalbank
            "733", //Zürcher Kantonalbank
            "734", //Zürcher Kantonalbank
            "735", //Zürcher Kantonalbank
            "736", //Zürcher Kantonalbank
            "737", //Zürcher Kantonalbank
            "738", //Zürcher Kantonalbank
            "739", //Zürcher Kantonalbank
            "740", //Zürcher Kantonalbank
            "741", //Zürcher Kantonalbank
            "742", //Zürcher Kantonalbank
            "743", //Zürcher Kantonalbank
            "744", //Zürcher Kantonalbank
            "745", //Zürcher Kantonalbank
            "746", //Zürcher Kantonalbank
            "747", //Zürcher Kantonalbank
            "748", //Zürcher Kantonalbank
            "749", //Zürcher Kantonalbank
            "750", //Zürcher Kantonalbank
            "751", //Zürcher Kantonalbank
            "752", //Zürcher Kantonalbank
            "753", //Zürcher Kantonalbank
            "754", //Zürcher Kantonalbank
            "755", //Zürcher Kantonalbank
            "756", //Zürcher Kantonalbank
            "757", //Zürcher Kantonalbank
            "758", //Zürcher Kantonalbank
            "759", //Zürcher Kantonalbank
            "761", //Aargauische Kantonalbank
            "76120", //Aargauische Kantonalbank
            "76121", //Aargauische Kantonalbank
            "76130", //Aargauische Kantonalbank
            "76140", //Aargauische Kantonalbank
            "76150", //Aargauische Kantonalbank
            "76160", //Aargauische Kantonalbank
            "76170", //Aargauische Kantonalbank
            "763", //Appenzeller Kantonalbank
            "764", //Banca dello Stato del Cantone Ticino
            "76410", //Banca dello Stato del Cantone Ticino
            "76411", //Banca dello Stato del Cantone Ticino
            "76412", //Banca dello Stato del Cantone Ticino
            "76420", //Banca dello Stato del Cantone Ticino
            "76430", //Banca dello Stato del Cantone Ticino
            "76440", //Banca dello Stato del Cantone Ticino
            "76450", //Banca dello Stato del Cantone Ticino
            "76460", //Banca dello Stato del Cantone Ticino
            "76470", //Banca dello Stato del Cantone Ticino
            "765", //Banque Cantonale du Valais
            "766", //Banque Cantonale Neuchâteloise
            "767", //Banque Cantonale Vaudoise
            "76711", //Banque Cantonale Vaudoise
            "76712", //Banque Cantonale Vaudoise
            "76713", //Banque Cantonale Vaudoise
            "76714", //Banque Cantonale Vaudoise
            "76715", //Banque Cantonale Vaudoise
            "76716", //Banque Cantonale Vaudoise
            "76717", //Banque Cantonale Vaudoise
            "76718", //Banque Cantonale Vaudoise
            "76719", //Banque Cantonale Vaudoise
            "76720", //Banque Cantonale Vaudoise
            "76721", //Banque Cantonale Vaudoise
            "76722", //Banque Cantonale Vaudoise
            "76723", //Banque Cantonale Vaudoise
            "76724", //Banque Cantonale Vaudoise
            "76725", //Banque Cantonale Vaudoise
            "76726", //Banque Cantonale Vaudoise
            "76727", //Banque Cantonale Vaudoise
            "76728", //Banque Cantonale Vaudoise
            "76729", //Banque Cantonale Vaudoise
            "76730", //Banque Cantonale Vaudoise
            "76731", //Banque Cantonale Vaudoise
            "76732", //Banque Cantonale Vaudoise
            "76733", //Banque Cantonale Vaudoise
            "76734", //Banque Cantonale Vaudoise
            "76735", //Banque Cantonale Vaudoise
            "76736", //Banque Cantonale Vaudoise
            "76737", //Banque Cantonale Vaudoise
            "76738", //Banque Cantonale Vaudoise
            "76739", //Banque Cantonale Vaudoise
            "76740", //Banque Cantonale Vaudoise
            "76741", //Banque Cantonale Vaudoise
            "76742", //Banque Cantonale Vaudoise
            "76743", //Banque Cantonale Vaudoise
            "76744", //Banque Cantonale Vaudoise
            "76745", //Banque Cantonale Vaudoise
            "76746", //Banque Cantonale Vaudoise
            "76747", //Banque Cantonale Vaudoise
            "76748", //Banque Cantonale Vaudoise
            "76749", //Banque Cantonale Vaudoise
            "76750", //Banque Cantonale Vaudoise
            "76751", //Banque Cantonale Vaudoise
            "76752", //Banque Cantonale Vaudoise
            "76753", //Banque Cantonale Vaudoise
            "76754", //Banque Cantonale Vaudoise
            "76755", //Banque Cantonale Vaudoise
            "76756", //Banque Cantonale Vaudoise
            "76758", //Banque Cantonale Vaudoise
            "76761", //Banque Cantonale Vaudoise
            "76762", //Banque Cantonale Vaudoise
            "76763", //Banque Cantonale Vaudoise
            "76764", //Banque Cantonale Vaudoise
            "76765", //Banque Cantonale Vaudoise
            "76766", //Banque Cantonale Vaudoise
            "768", //Banque Cantonale de Fribourg
            "76822", //Banque Cantonale de Fribourg
            "76823", //Banque Cantonale de Fribourg
            "76824", //Banque Cantonale de Fribourg
            "76825", //Freiburger Kantonalbank
            "76826", //Banque Cantonale de Fribourg
            "76827", //Banque Cantonale de Fribourg
            "76828", //Banque Cantonale de Fribourg
            "76829", //Freiburger Kantonalbank
            "76830", //Banque Cantonale de Fribourg
            "76831", //Freiburger Kantonalbank
            "76832", //Freiburger Kantonalbank
            "76833", //Banque Cantonale de Fribourg
            "76834", //Banque Cantonale de Fribourg
            "76835", //Banque Cantonale de Fribourg
            "76836", //Freiburger Kantonalbank
            "76837", //Banque Cantonale de Fribourg
            "76838", //Banque Cantonale de Fribourg
            "76839", //Banque Cantonale de Fribourg
            "76840", //Banque Cantonale de Fribourg
            "76841", //Banque Cantonale de Fribourg
            "76842", //Banque Cantonale de Fribourg
            "76843", //Banque Cantonale de Fribourg
            "769", //Basellandschaftliche Kantonalbank
            "770", //Basler Kantonalbank
            "773", //Glarner Kantonalbank
            "774", //Graubündner Kantonalbank
            "777", //Schwyzer Kantonalbank
            "77711", //Schwyzer Kantonalbank
            "77712", //Schwyzer Kantonalbank
            "77713", //Schwyzer Kantonalbank
            "77714", //Schwyzer Kantonalbank
            "77715", //Schwyzer Kantonalbank
            "77716", //Schwyzer Kantonalbank
            "77717", //Schwyzer Kantonalbank
            "77718", //Schwyzer Kantonalbank
            "77719", //Schwyzer Kantonalbank
            "77720", //Schwyzer Kantonalbank
            "77721", //Schwyzer Kantonalbank
            "77722", //Schwyzer Kantonalbank
            "77723", //Schwyzer Kantonalbank
            "77724", //Schwyzer Kantonalbank
            "77725", //Schwyzer Kantonalbank
            "77726", //Schwyzer Kantonalbank
            "77727", //Schwyzer Kantonalbank
            "77728", //Schwyzer Kantonalbank
            "77729", //Schwyzer Kantonalbank
            "77730", //Schwyzer Kantonalbank
            "77731", //Schwyzer Kantonalbank
            "77732", //Schwyzer Kantonalbank
            "77733", //Schwyzer Kantonalbank
            "77734", //Schwyzer Kantonalbank
            "778", //Luzerner Kantonalbank AG
            "77811", //Luzerner Kantonalbank AG
            "77812", //Luzerner Kantonalbank AG
            "77813", //Luzerner Kantonalbank AG
            "77814", //Luzerner Kantonalbank AG
            "77815", //Luzerner Kantonalbank AG
            "77816", //Luzerner Kantonalbank AG
            "77817", //Luzerner Kantonalbank AG
            "77818", //Luzerner Kantonalbank AG
            "77819", //Luzerner Kantonalbank AG
            "77820", //Luzerner Kantonalbank AG
            "77821", //Luzerner Kantonalbank AG
            "77822", //Luzerner Kantonalbank AG
            "77823", //Luzerner Kantonalbank AG
            "77824", //Luzerner Kantonalbank AG
            "77825", //Luzerner Kantonalbank AG
            "77826", //Luzerner Kantonalbank AG
            "77827", //Luzerner Kantonalbank AG
            "77828", //Luzerner Kantonalbank AG
            "77829", //Luzerner Kantonalbank AG
            "77860", //Luzerner Kantonalbank AG
            "77866", //Luzerner Kantonalbank AG
            "779", //Nidwaldner Kantonalbank
            "780", //Obwaldner Kantonalbank
            "781", //St. Galler Kantonalbank AG
            "78102", //St. Galler Kantonalbank AG
            "78103", //St. Galler Kantonalbank AG
            "78111", //St. Galler Kantonalbank AG
            "78112", //St. Galler Kantonalbank AG
            "78113", //St. Galler Kantonalbank AG
            "78114", //St. Galler Kantonalbank AG
            "78115", //St. Galler Kantonalbank AG
            "78116", //St. Galler Kantonalbank AG
            "78117", //St. Galler Kantonalbank AG
            "78118", //St. Galler Kantonalbank AG
            "78119", //St. Galler Kantonalbank AG
            "78120", //St. Galler Kantonalbank AG
            "78121", //St. Galler Kantonalbank AG
            "78122", //St. Galler Kantonalbank AG
            "78123", //St. Galler Kantonalbank AG
            "78124", //St. Galler Kantonalbank AG
            "78125", //St. Galler Kantonalbank AG
            "78126", //St. Galler Kantonalbank AG
            "78127", //St. Galler Kantonalbank AG
            "78128", //St. Galler Kantonalbank AG
            "78129", //St. Galler Kantonalbank AG
            "78130", //St. Galler Kantonalbank AG
            "78131", //St. Galler Kantonalbank AG
            "78132", //St. Galler Kantonalbank AG
            "78158", //St. Galler Kantonalbank AG
            "782", //Schaffhauser Kantonalbank
            "78212", //Schaffhauser Kantonalbank
            "78213", //Schaffhauser Kantonalbank
            "784", //Thurgauer Kantonalbank
            "78411", //Thurgauer Kantonalbank
            "78412", //Thurgauer Kantonalbank
            "78413", //Thurgauer Kantonalbank
            "78414", //Thurgauer Kantonalbank
            "78415", //Thurgauer Kantonalbank
            "78416", //Thurgauer Kantonalbank
            "78417", //Thurgauer Kantonalbank
            "78418", //Thurgauer Kantonalbank
            "78419", //Thurgauer Kantonalbank
            "78420", //Thurgauer Kantonalbank
            "78421", //Thurgauer Kantonalbank
            "78422", //Thurgauer Kantonalbank
            "78423", //Thurgauer Kantonalbank
            "78424", //Thurgauer Kantonalbank
            "785", //Urner Kantonalbank
            "787", //Zuger Kantonalbank
            "788", //Banque Cantonale de Genève
            "789", //Banque Cantonale du Jura SA
            "78910", //Banque Cantonale du Jura SA
            "78920", //Banque Cantonale du Jura SA
            "790", //Berner Kantonalbank AG
            "79005", //Banque cantonale bernoise SA
            "79010", //Berner Kantonalbank AG
            "79011", //Banque cantonale bernoise SA
            "79012", //Berner Kantonalbank AG
            "79015", //Berner Kantonalbank AG
            "79020", //Berner Kantonalbank AG
            "79025", //Berner Kantonalbank AG
            "79030", //Berner Kantonalbank AG
            "79031", //Berner Kantonalbank AG
            "79032", //Berner Kantonalbank AG
            "79035", //Berner Kantonalbank AG
            "79045", //Banque cantonale bernoise SA
            "79046", //Banque cantonale bernoise SA
            "79050", //Berner Kantonalbank AG
            "79051", //Berner Kantonalbank AG
            "79052", //Berner Kantonalbank AG
            "79055", //Berner Kantonalbank AG
            "79065", //Berner Kantonalbank AG
            "79070", //Banque cantonale bernoise SA
            "79071", //Banque cantonale bernoise SA
            "79075", //Berner Kantonalbank AG
            "79085", //Berner Kantonalbank AG
            "79095", //Berner Kantonalbank AG
            "80000", //Raiffeisen Schweiz
            "80002", //Banque Raiffeisen Région Delémont
            "80004", //Banque Raiffeisen de la Sorne
            "80005", //Raiffeisen Schweiz, Niederlassung St. Gallen
            "80015", //Banque Raiffeisen de l'Allaine
            "80027", //Banque Raiffeisen  Ajoie
            "80037", //Banque Raiffeisen Clos du Doubs et Haute-Ajoie
            "80051", //Banque Raiffeisen Pierre Pertuis
            "80059", //Banque Raiffeisen Franches-Montagnes
            "80073", //Banque Raiffeisen du Val-Terbi
            "80093", //Banque Raiffeisen Haute Birse
            "80094", //Raiffeisenbank Worblen-Emmental
            "80097", //Raiffeisenbank Laufental-Thierstein
            "80098", //Raiffeisenbank Gürbe
            "80102", //Banque Raiffeisen Sarine-Ouest
            "80105", //Banque Raiffeisen de Marly
            "80107", //Banque Raiffeisen Vuadens/Sâles/St-Martin
            "80108", //Banque Raiffeisen de la Glâne
            "80117", //Banque Raiffeisen Vallée de la Jogne
            "80123", //Banque Raiffeisen Basse Broye Vully
            "80129", //Banque Raiffeisen Moléson
            "80139", //Banque Raiffeisen Estavayer-Montagny
            "80150", //Banque Raiffeisen Cousimbert
            "80155", //Banque Raiffeisen du Gibloux
            "80159", //Banque Raiffeisen Fribourg-Ouest
            "80181", //Banque Raiffeisen Région Genève Rhône
            "80187", //Banque Raiffeisen du Salève
            "80188", //Banque Raiffeisen d'Arve et Lac
            "80206", //Banque Raiffeisen de Meyrin
            "80210", //Banque Raiffeisen Genève Ouest
            "80215", //Banque Raiffeisen de la Versoix
            "80237", //Banque Raiffeisen des Montagnes Neuchâteloises
            "80241", //Banque Raiffeisen du Vignoble
            "80251", //Banque Raiffeisen du Val-de-Ruz
            "80261", //Banque Raiffeisen Val-de-Travers
            "80272", //Banca Raiffeisen del Basso Mendrisiotto
            "80280", //Banca Raiffeisen Cugnasco Gordola Verzasca
            "80281", //Banca Raiffeisen Centovalli Pedemonte Onsernone
            "80283", //Banca Raiffeisen del Vedeggio
            "80287", //Banca Raiffeisen Basso Ceresio
            "80290", //Banca Raiffeisen Morbio-Vacallo
            "80296", //Banca Raiffeisen Riva San Vitale
            "80307", //Banca Raiffeisen Malcantonese
            "80315", //Banca Raiffeisen Canobbio-Comano-Cureglia
            "80317", //Banca Raiffeisen della Magliasina
            "80324", //Banca Raiffeisen Gambarogno e Cadenazzo
            "80332", //Banca Raiffeisen del Monte San Giorgio
            "80333", //Banca Raiffeisen Losone-Circolo delle Isole
            "80335", //Banca Raiffeisen Vallemaggia
            "80340", //Banca Raiffeisen Mendrisio e Valle di Muggio
            "80344", //Banca Raiffeisen del Camoghè
            "80350", //Banca Raiffeisen Tre Valli
            "80362", //Banca Raiffeisen Colline del Ceresio
            "80364", //Banca Raiffeisen Medio Cassarate
            "80365", //Banca Raiffeisen della Campagnadorna
            "80366", //Banca Raiffeisen del Cassarate
            "80374", //Banca Raiffeisen Leventina
            "80375", //Banca Raiffeisen Lugano
            "80379", //Banca Raiffeisen Locarno
            "80382", //Banca Raiffeisen Biasca-Lodrino
            "80387", //Banca Raiffeisen Bellinzonese e Visagno
            "80400", //Banque Raiffeisen des Alpes Vaudoises
            "80401", //Banque Raiffeisen Mont-Aubert Orbe
            "80403", //Banque Raiffeisen Talent-Menthue
            "80414", //Banque Raiffeisen d'Assens
            "80428", //Banque Raiffeisen du Pays-d'Enhaut
            "80430", //Banque Raiffeisen de La Riviera
            "80434", //Banque Raiffeisen du Gros-de-Vaud
            "80442", //Banque Raiffeisen Nyon-La Vallée
            "80445", //Banque Raiffeisen du Mont-Tendre
            "80447", //Banque Raiffeisen Alpes Chablais Vaudois
            "80451", //Banque Raiffeisen Lausanne Haute-Broye-Jorat
            "80453", //Banque Raiffeisen Puidoux-Chexbres-Forel
            "80454", //Banque Raiffeisen de Lavaux
            "80460", //Banque Raiffeisen Morges Venoge
            "80465", //Banque Raiffeisen Plateau du Jorat-Molondin
            "80472", //Banque Raiffeisen d'Yverdon-les-Bains
            "80479", //Banque Raiffeisen de la Broye
            "80482", //Banque Raiffeisen du district de Moudon
            "80485", //Banque Raiffeisen de Gimel
            "80492", //Raiffeisenbank Aletsch
            "80496", //Raiffeisenbank Mischabel-Matterhorn
            "80499", //Raiffeisenbank Visperterminen
            "80521", //Raiffeisenbank Gampel-Raron
            "80527", //Raiffeisenbank Region Leuk
            "80532", //Raiffeisenbank Belalp-Simplon
            "80538", //Raiffeisenbank Raron-St. German-Niedergesteln
            "80539", //Raiffeisenbank Aletsch-Goms
            "80553", //Raiffeisenbank Region Visp
            "80571", //Banque Raiffeisen Riddes-Saxon-Isérables
            "80572", //Banque Raiffeisen Sion et Région
            "80577", //Banque Raiffeisen de Nendaz
            "80581", //Banque Raiffeisen Entremont
            "80584", //Banque Raiffeisen de Chalais-Vercorin
            "80585", //Banque Raiffeisen des Coteaux du Soleil
            "80588", //Banque Raiffeisen du Haut-Léman
            "80589", //Banque Raiffeisen de Conthey
            "80595", //Banque Raiffeisen Martigny et Région
            "80598", //Banque Raiffeisen de Sierre & Région
            "80599", //Banque Raiffeisen Hérens
            "80602", //Banque Raiffeisen de Leytron-Saillon
            "80606", //Banque Raiffeisen Massongex-St-Maurice-Vérossaz
            "80608", //Banque Raiffeisen de Miège-Venthône-Veyras
            "80611", //Banque Raiffeisen de Monthey
            "80613", //Banque Raiffeisen de la Vallée d'Entremont
            "80615", //Banque Raiffeisen des Communes du Haut Plateau
            "80626", //Banque Raiffeisen de Troistorrents
            "80627", //Banque Raiffeisen de Val-d'Illiez-Champéry
            "80652", //Raiffeisenbank Böttstein
            "80666", //Raiffeisenbank an der Limmat
            "80669", //Raiffeisenbank am Lindenberg
            "80670", //Raiffeisenbank Abtwil AG
            "80673", //Raiffeisenbank Mutschellen-Reppischtal
            "80675", //Raiffeisenbank Boswil-Bünzen
            "80683", //Raiffeisenbank Eiken
            "80689", //Raiffeisenbank Mettauertal
            "80690", //Raiffeisenbank Wasserschloss
            "80691", //Raiffeisenbank Regio Frick
            "80696", //Raiffeisenbank Regio Laufenburg
            "80698", //Raiffeisenbank Aarau-Lenzburg
            "80700", //Raiffeisenbank Surbtal-Wehntal
            "80701", //Raiffeisenbank Aare-Rhein
            "80702", //Raiffeisenbank Kelleramt-Albis
            "80704", //Raiffeisenbank Aare-Reuss
            "80705", //Raiffeisenbank Merenschwand-Obfelden
            "80706", //Raiffeisenbank Möhlin
            "80719", //Raiffeisenbank Rohrdorferberg-Fislisbach
            "80721", //Raiffeisenbank Region Zofingen
            "80723", //Raiffeisenbank Reitnau-Rued
            "80728", //Raiffeisenbank Oberfreiamt
            "80736", //Raiffeisenbank Villmergen
            "80740", //Raiffeisenbank Lägern-Baregg
            "80744", //Raiffeisenbank Wohlen
            "80746", //Raiffeisenbank Siggenthal-Würenlingen
            "80747", //Raiffeisenbank Würenlos
            "80748", //Raiffeisenbank Wegenstettertal
            "80749", //Raiffeisenbank Zufikon
            "80771", //Raiffeisenbank Oberbaselbiet
            "80773", //Raiffeisenbank Liestal-Oberbaselbiet
            "80774", //Raiffeisenbank Birsig
            "80775", //Raiffeisenbank Allschwil-Schönenbuch
            "80776", //Raiffeisenbank Arlesheim
            "80779", //Raiffeisenbank Aesch-Pfeffingen
            "80780", //Raiffeisenbank Reinach BL
            "80784", //Raiffeisenbank Therwil Ettingen
            "80811", //Raiffeisenbank Kiesental
            "80816", //Raiffeisenbank Niedersimmental
            "80817", //Raiffeisenbank Steffisburg
            "80819", //Raiffeisenbank Grauholz
            "80820", //Raiffeisenbank Frutigland
            "80823", //Raiffeisenbank Saanenland
            "80833", //Raiffeisenbank Bielersee
            "80837", //Raiffeisenbank Lütschinentäler
            "80838", //Raiffeisenbank Thunersee-Süd
            "80842", //Raiffeisenbank Jungfrau
            "80843", //Raiffeisenbank Region Haslital-Brienz
            "80853", //Raiffeisenbank Ringgenberg
            "80856", //Raiffeisenbank Obersimmental-Saanenland
            "80860", //Raiffeisenbank Schwarzwasser
            "80862", //Raiffeisenbank Seeland
            "80867", //Raiffeisenbank Thunersee
            "80873", //Raiffeisenbank Oberemmental
            "80875", //Raiffeisenbank Unteremmental
            "80882", //Raiffeisenbank Oberes Emmental
            "80888", //Raiffeisenbank Region Burgdorf
            "80894", //Raiffeisenbank Düdingen
            "80895", //Raiffeisenbank Sense-Oberland
            "80896", //Raiffeisenbank See-Lac
            "80899", //Raiffeisenbank Plaffeien-Plasselb
            "80901", //Raiffeisenbank Freiburg Ost / Fribourg Est
            "80904", //Raiffeisenbank Ueberstorf
            "80905", //Raiffeisenbank Sensetal
            "80911", //Raiffeisenbank Dulliken-Starrkirch
            "80912", //Raiffeisenbank Gäu-Bipperamt
            "80914", //Raiffeisenbank Fulenbach-Murgenthal-Langenthal
            "80918", //Raiffeisenbank Mittelgösgen
            "80924", //Raiffeisenbank Gilgenberg
            "80928", //Raiffeisenbank Aeschi- Buchsi
            "80930", //Raiffeisenbank Balsthal-Laupersdorf
            "80933", //Raiffeisenbank Biberist
            "80936", //Raiffeisenbank Däniken-Gretzenbach
            "80938", //Raiffeisenbank Wasseramt Mitte
            "80939", //Raiffeisenbank Dornach
            "80940", //Raiffeisenbank Erlinsbach
            "80947", //Raiffeisenbank Untergäu
            "80962", //Raiffeisenbank Dünnerntal-Guldental
            "80964", //Raiffeisenbank Niederbuchsiten
            "80965", //Raiffeisenbank Niedergösgen-Schönenwerd-Eppenberg
            "80968", //Raiffeisenbank Weissenstein
            "80970", //Raiffeisenbank Olten
            "80971", //Raiffeisenbank Recherswil-Gerlafingen-Koppigen
            "80976", //Raiffeisenbank Weissenstein
            "80977", //Raiffeisenbank Solothurn
            "80982", //Raiffeisenbank Dünnerntal
            "80985", //Raiffeisenbank Oberes Gäu-Aare
            "80986", //Raiffeisenbank Zuchwil
            "81011", //Raiffeisenbank Appenzeller Hinterland
            "81012", //Raiffeisenbank Heiden
            "81023", //Raiffeisenbank Appenzell
            "81031", //Raiffeisenbank Glarnerland
            "81045", //Raiffeisenbank Bündner Rheintal
            "81047", //Raiffeisenbank Vorderprättigau
            "81048", //Raiffeisenbank Calanda
            "81054", //Banca Raiffeisen del Moesano
            "81063", //Raiffeisenbank Mittelbünden
            "81072", //Raiffeisenbank Cadi
            "81073", //Raiffeisenbank Surselva
            "81084", //Raiffeisenbank Prättigau-Davos
            "81103", //Banca Raiffeisen Valposchiavo
            "81137", //Raiffeisenbank Tumpiv
            "81144", //Raiffeisenbank Engiadina Val Müstair
            "81164", //Raiffeisenbank Hildisrieden
            "81165", //Raiffeisenbank Kriens
            "81168", //Raiffeisenbank Adligenswil-Udligenswil-Meggen
            "81169", //Raiffeisenbank Hitzkirchertal
            "81170", //Raiffeisenbank Beromünster
            "81172", //Raiffeisenbank Buttisholz-Ruswil
            "81177", //Raiffeisenbank Emmen
            "81179", //Raiffeisenbank im Entlebuch
            "81184", //Raiffeisenbank Hergiswil LU
            "81186", //Raiffeisenbank Horw
            "81187", //Raiffeisenbank Oberseetal
            "81190", //Raiffeisenbank Littau-Reussbühl
            "81191", //Raiffeisenbank Luthern
            "81192", //Raiffeisenbank Malters
            "81194", //Raiffeisenbank Menznau-Wolhusen
            "81196", //Raiffeisenbank Sempachersee Süd
            "81197", //Raiffeisenbank Pfaffnerntal-Rottal
            "81203", //Raiffeisenbank Luzern
            "81204", //Raiffeisenbank Rothenburg
            "81211", //Raiffeisenbank Luzerner Hinterland
            "81212", //Raiffeisenbank Ettiswil
            "81214", //Raiffeisenbank Luzerner Landschaft Nordwest
            "81222", //Raiffeisenbank Vierwaldstättersee-Süd
            "81223", //Raiffeisenbank Region Stans
            "81231", //Raiffeisenbank Sachseln
            "81232", //Raiffeisenbank Obwalden
            "81241", //Raiffeisenbank Abtwil-St.-Josefen
            "81244", //Raiffeisenbank Eggersriet-Grub
            "81245", //Raiffeisenbank Goldingen-Wald
            "81251", //Raiffeisenbank Werdenberg
            "81253", //Raiffeisenbank Andwil-Arnegg
            "81256", //Raiffeisenbank Benken
            "81258", //Raiffeisenbank Berneck-Au
            "81259", //Raiffeisenbank Bernhardzell
            "81261", //Raiffeisenbank Unteres Toggenburg
            "81262", //Raiffeisenbank Diepoldsau-Schmitter
            "81265", //Raiffeisenbank Engelburg
            "81267", //Raiffeisenbank Flums
            "81269", //Raiffeisenbank Goldach
            "81271", //Raiffeisenbank Gossau-Niederwil
            "81274", //Raiffeisenbank Rapperswil-Jona
            "81275", //Raiffeisenbank Kriessern
            "81281", //Raiffeisenbank Sarganserland
            "81284", //Raiffeisenbank Mörschwil
            "81287", //Raiffeisenbank Obertoggenburg
            "81289", //Raiffeisenbank Niederhelfenschwil
            "81291", //Raiffeisenbank Regio Uzwil
            "81294", //Raiffeisenbank Quarten
            "81295", //Raiffeisenbank Unteres Rheintal
            "81296", //Raiffeisenbank Rorschacherberg-Thal
            "81297", //Raiffeisenbank Oberes Rheintal
            "81298", //Raiffeisenbank am Ricken
            "81300", //Raiffeisenbank Neckertal
            "81301", //Raiffeisenbank Oberes Sarganserland
            "81302", //Raiffeisenbank Schänis-Amden
            "81303", //Raiffeisenbank Schwarzenbach
            "81304", //Raiffeisenbank Sennwald
            "81307", //Raiffeisenbank Regio Arbon
            "81313", //Raiffeisenbank Waldkirch
            "81314", //Raiffeisenbank Walenstadt
            "81317", //Raiffeisenbank Mittleres Toggenburg
            "81319", //Raiffeisenbank Mittelrheintal
            "81320", //Raiffeisenbank Wil und Umgebung
            "81322", //Raiffeisenbank Winkeln
            "81323", //Raiffeisenbank Wittenbach-Haeggenschwil
            "81324", //Raiffeisenbank Marbach-Rebstein
            "81325", //Raiffeisenbank Flawil-Degersheim-Mogelsberg-Oberuzwil
            "81344", //Raiffeisenbank Schaffhausen
            "81351", //Raiffeisenbank Rigi
            "81356", //Raiffeisenbank Höfe
            "81357", //Raiffeisenbank Illgau
            "81358", //Raiffeisenbank Waldstätte
            "81360", //Raiffeisenbank Muotathal
            "81361", //Raiffeisenbank Einsiedeln
            "81363", //Raiffeisenbank March
            "81364", //Raiffeisenbank Yberg
            "81371", //Raiffeisenbank Regio Altnau
            "81373", //Raiffeisenbank Amriswil-Dozwil-Sommeri
            "81377", //Raiffeisenbank Aadorf
            "81378", //Raiffeisenbank am Bichelsee
            "81379", //Raiffeisenbank Berg-Erlen
            "81380", //Raiffeisenbank Mittelthurgau
            "81381", //Raiffeisenbank Dussnang-Fischingen
            "81382", //Raiffeisenbank Untersee-Rhein
            "81384", //Raiffeisenbank Frauenfeld
            "81398", //Raiffeisenbank Neukirch-Romanshorn
            "81401", //Raiffeisenbank Seerücken
            "81402", //Raiffeisenbank Rickenbach-Wilen
            "81409", //Raiffeisenbank Sirnach
            "81411", //Raiffeisenbank Sulgen
            "81412", //Raiffeisenbank Tägerwilen
            "81414", //Raiffeisenbank Münchwilen-Tobel
            "81416", //Raiffeisenbank Wängi-Matzingen
            "81417", //Raiffeisenbank Zihlschlacht-Muolen-Bischofszell
            "81431", //Raiffeisenbank Urner Unterland
            "81432", //Raiffeisenbank Schächental
            "81433", //Raiffeisenbank Urner Oberland
            "81452", //Raiffeisenbank Steinhausen
            "81454", //Raiffeisenbank Zug
            "81455", //Raiffeisenbank Cham-Steinhausen
            "81456", //Raiffeisenbank Hünenberg
            "81457", //Raiffeisenbank Menzingen-Neuheim
            "81459", //Raiffeisenbank Region Ägerital-Sattel
            "81460", //Raiffeisenbank Risch-Rotkreuz
            "81461", //Raiffeisenbank Unterägeri
            "81471", //Raiffeisenbank Zürcher Oberland
            "81472", //Raiffeisenbank Guntalingen-Neunforn
            "81474", //Raiffeisenbank Zürich Flughafen
            "81475", //Raiffeisenbank Züri-Unterland
            "81477", //Raiffeisenbank Oberembrach-Bassersdorf
            "81479", //Raiffeisenbank Weinland
            "81481", //Raiffeisenbank rechter Zürichsee
            "81485", //Raiffeisen Schweiz, Zweigniederlassung Winterthur
            "81486", //Raiffeisen Schweiz, Niederlassung Basel
            "81487", //Raiffeisen Schweiz, Niederlassung Zürich
            "81488", //Raiffeisen Schweiz, Niederlassung Bern
            "81490", //Raiffeisen Schweiz, Zweigniederlassung Thalwil
            "81491", //RAIFFEISEN SCHWEIZ, FIRMENKUNDEN
            "82004", //NORDEA BANK S.A. LUXEMBOURG
            "82006", //Bank Hapoalim (Switzerland) Ltd.
            "82007", //Union Bancaire Privée (Europe) SA
            "82008", //Mirabaud & Cie (Europe) SA
            "8235", //Banco Santander (Suisse) SA
            "8236", //Credit Europe Bank (Suisse SA
            "8237", //BANQUE PRIVEE BCP (SUISSE) SA
            "8238", //Investec Bank (Switzerland) AG
            "8239", //Banca Intermobiliare di Investimenti e Gestioni (Suisse) SA
            "8242", //Fibi Bank (Schweiz) AG
            "8243", //Crédit Agricole Financements (Suisse) SA
            "8244", //Mourgue d'Algue & Cie
            "8245", //AP ANLAGE & PRIVATBANK AG
            "8246", //GS Banque SA
            "8248", //F. van Lanschot Bankiers (Schweiz) AG
            "8252", //Banca Popolare di Sondrio (Suisse) SA
            "8255", //Volksbank AG
            "8256", //FINTER BANK ZUERICH AG
            "8260", //Falcon Private Bank AG
            "8261", //KBL (SWITZERLAND) Ltd
            "8263", //Deutsche Bank (Schweiz) AG, ex Bank Sal. Oppenheim (Schweiz)
            "8268", //Banque Internationale à Luxembourg (Suisse) SA
            "8270", //BBVA (Suiza) SA
            "8278", //Goldman Sachs Bank AG
            "8281", //Bank Hapoalim (Schweiz) AG
            "8283", //AKB Privatbank Zürich AG
            "8285", //Sallfort Privatbank AG
            "8288", //Frankfurter Bankgesellschaft (Schweiz) AG
            "8289", //BHF-BANK (Schweiz) AG
            "8296", //Cembra Money Bank AG
            "82961", //Cembra Money Bank SA
            "82962", //Cembra Money Bank SA
            "82963", //Cembra Money Bank AG
            "82964", //Cembra Money Bank AG
            "82965", //Cembra Money Bank AG
            "82966", //Cembra Money Bank AG
            "82967", //Cembra Money Bank AG
            "82968", //Cembra Money Bank SA
            "82969", //Cembra Money Bank SA
            "82971", //Cembra Money Bank AG
            "82972", //Cembra Money Bank SA
            "82973", //Cembra Money Bank AG
            "82975", //Cembra Money Bank SA
            "82976", //Cembra Money Bank SA
            "82977", //Cembra Money Bank AG
            "82979", //Cembra Money Bank AG
            "82981", //Cembra Money Bank AG
            "82983", //Cembra Money Bank AG
            "82984", //Cembra Money Bank AG
            "82986", //Cembra Money Bank SA
            "82998", //Cembra Money Bank AG
            "8300", //Spar- und Leihkasse Wynigen AG
            "83001", //+Mitsubishi UFJ Wealth Management Bank (Switzerland), Ltd.
            "83002", //Bank von Roll AG
            "83003", //SIX x-clear AG
            "8307", //Hypothekarbank Lenzburg AG
            "8309", //Banque SYZ SA
            "8326", //Caisse d'Epargne de Nyon société coopérative
            "8327", //Caisse d'Epargne d'Aubonne Sociéte coopérative
            "8329", //Ersparniskasse Speicher
            "8334", //Baloise Bank SoBa AG
            "8335", //LGT Bank (Schweiz) AG
            "8346", //Banque Algérienne du Commerce Extérieur SA
            "8347", //Spar- und Leihkasse Leuk und Umgebung Genossenschaft
            "8348", //Caisse d'Epargne et de Crédit Mutuel de Chermignon
            "8349", //Caisse d'Epargne Riviera, société coopérative
            "8350", //SecurePost AG
            "8351", //SOS Surveillance SA
            "8352", //Loomis Schweiz SA
            "8353", //Loomis Schweiz SA
            "8373", //China Construction Bank Corporation, Beijing, Swiss Branch
            "8374", //CACEIS Bank Luxembourg
            "8376", //Banque Degroof Petercam (Suisse) SA
            "8377", //UBS Swiss Financial Advisers AG
            "8378", //NPB Neue Privat Bank AG
            "8379", //QNB (Suisse) SA
            "8380", //J.P. Morgan (Suisse) SA
            "8384", //Reyl & Cie S.A.
            "8385", //NBK Banque Privée (Suisse) SA
            "8386", //Swissquote Bank SA
            "8387", //ING Belgique, Bruxelles
            "8388", //Banque Eric Sturdza SA
            "8389", //Bezirks-Sparkasse Dielsdorf Genossenschaft
            "8390", //Alternative Bank Schweiz AG
            "8391", //WIR Bank Genossenschaft
            "8392", //Freie Gemeinschaftsbank Genossenschaft
            "8393", //Bank EKI Genossenschaft
            "8394", //Bank EEK AG
            "8395", //Spar- und Leihkasse Bucheggberg
            "8396", //SPAR + LEIHKASSE GUERBETAL AG
            "8397", //DC Bank Deposito-Cassa der Stadt Bern
            "8398", //VZ Depotbank AG
            "8401", //Migros Bank AG
            "8440", //Bank Coop AG
            "8441", //Bank Coop AG
            "8442", //Bank Coop AG
            "8443", //Bank Coop AG
            "8444", //Bank Coop AG
            "8445", //Bank Coop AG
            "8446", //Banque Coop SA
            "8447", //Banque Coop SA
            "8448", //Banque Coop SA
            "8449", //Banca Coop SA
            "8450", //Bank Coop AG
            "8451", //Bank Coop AG
            "8452", //Bank Coop AG
            "8453", //Bank Coop AG
            "8454", //Bank Coop AG
            "8455", //Banca Coop SA
            "8456", //Bank Coop AG
            "8457", //Banque Coop SA
            "8465", //BSI SA
            "8466", //BSI SA
            "8468", //BSI SA
            "8471", //BSI SA
            "8472", //BSI SA
            "8473", //BSI SA
            "8486", //BSI AG
            "8487", //BSI AG
            "8490", //Cornèr Banca SA
            "8495", //BANCA CREDINVEST SA
            "8496", //Banca Aletti & C. (Suisse) SA
            "8497", //SAXO BANK (SCHWEIZ) SA
            "8498", //Axion SWISS Bank SA
            "8499", //NBAD Private Bank (Suisse) SA
            "8504", //DEGROOF BANQUE PRIVEE SA
            "8509", //Mercantil Bank (Schweiz) AG
            "8514", //Nordea Bank S.A. Luxemburg, Zurich
            "8515", //Bank Julius Bär & Co AG
            "8518", //Bank Gantrisch Genossenschaft
            "8519", //Ersparniskasse Rüeggisberg Genossenschaft
            "8521", //BBO Bank Brienz Oberhasli AG
            "8522", //Società Bancaria Ticinese
            "8524", //EDMOND DE ROTHSCHILD (SUISSE) S.A.
            "8525", //Bank für Tirol und Vorarlberg Aktiengesellschaft, Innsbruck
            "8528", //Privatbank IHAG Zürich AG
            "8529", //UniCredit Bank AG, München, Niederlassung Zürich
            "8530", //Hyposwiss Privatbank AG
            "8533", //SELVI & Cie SA
            "8534", //VP Bank (Schweiz) AG
            "8537", //Banque Internationale de Commerce-BRED (Suisse) SA
            "8539", //BERENBERG BANK (SCHWEIZ) AG
            "8540", //BLOM BANK (Switzerland) SA
            "8542", //Banca Privata Ed.de Rothschild Lugano SA, (ex Sella Bank AG)
            "8543", //Scobag Privatbank AG
            "8547", //Banque J. Safra Sarasin SA
            "8548", //Hyposwiss Private Bank Genève SA
            "8549", //Valartis Bank AG
            "8550", //Banque de Dépôts et de Gestion SA
            "85502", //Banque de Dépôts et de Gestion SA
            "8551", //Banque de Dépôts et de Gestion SA
            "8552", //Banque de Dépôts et de Gestion SA
            "8553", //BZ Bank Aktiengesellschaft
            "8559", //Bank am Bellevue AG
            "8564", //Privatbank Von Graffenried AG
            "8565", //Dreyfus Söhne & Cie AG, Banquiers
            "8570", //Banque Bonhôte & Cie SA
            "8571", //Edmond de Rothschild (Suisse) S.A
            "8572", //Trafina Privatbank AG
            "8573", //Maerki, Baumann & Co. AG
            "8574", //BANKMED SUISSE SA
            "8575", //M.M. Warburg Bank (Schweiz) AG
            "8578", //BANQUE MORVAL SA
            "8582", //SOCIETE GENERALE
            "8584", //Banca del Ceresio SA
            "8587", //Banque Genevoise de Gestion SA
            "8609", //BANCA ZARATTINI & Co. SA
            "8615", //DZ PRIVATBANK (SCHWEIZ) AG
            "8616", //EFG Bank European Financial Group SA
            "8619", //Nomura Bank (Switzerland) Ltd
            "8623", //Banque Havilland (Suisse) SA
            "8624", //Banque Audi (Suisse) SA
            "8629", //Banque de Commerce et de Placements SA
            "8634", //Schroder & Co Bank AG
            "8635", //JPMorgan Chase Bank, National Association, Columbus
            "8638", //Citibank (Switzerland) AG
            "8644", //Mizuho Bank (Schweiz) AG
            "8657", //UNION BANCAIRE PRIVEE, UBP SA
            "8659", //Deutsche Bank (Suisse) S.A.
            "8660", //Gazprombank (Schweiz) AG
            "8661", //Rothschild Bank AG
            "8663", //PKB PRIVATBANK SA
            "8664", //PKB PRIVATBANK AG
            "8665", //PKB PRIVATBANK SA
            "8666", //BANCA DEL SEMPIONE SA
            "8667", //EFG Bank AG
            "8672", //Banque SYZ SA (ex-RBC)
            "8686", //BNP Paribas (Suisse) SA
            "8689", //HSBC Private Bank (Suisse) SA
            "8695", //UNITED MIZRAHI BANK (Schweiz) AG
            "8700", //Citibank N.A., Sioux Falls
            "8701", //HSBC Bank plc, London, Zweigniederlassung Zürich
            "8702", //Leonteq Securities AG
            "8703", //bank zweiplus ag
            "8704", //AEK BANK 1826 Genossenschaft
            "8705", //Société Générale
            "8710", //Bank CIC (SCHWEIZ) AG
            "87105", //Bank CIC (SCHWEIZ) AG
            "8719", //Arab Bank (Switzerland) Ltd.
            "8721", //Gonet & Cie SA
            "8726", //Bank of America Merrill Lynch Int. London, Zurich Branch
            "8727", //Banque Cramer & Cie SA
            "8731", //Bank Linth LLB AG
            "8733", //Bank Thalwil Genossenschaft
            "8735", //Barclays Bank (Suisse) SA
            "8737", //Banque Thaler SA
            "8738", //Habibsons Bank Limited, London
            "8740", //CA Indosuez (Switzerland) SA
            "8741", //CA Indosuez (Switzerland) SA
            "8742", //CA Indosuez (Switzerland) SA
            "8743", //CA Indosuez (Switzerland) SA
            "8747", //BANQUE PROFIL DE GESTION SA
            "8750", //Bank J. Safra Sarasin AG
            "8751", //Bank J. Safra Sarasin AG
            "8752", //Bank J. Safra Sarasin AG
            "8755", //Banque Pictet & Cie SA
            "8756", //Baumann & Cie
            "8757", //Bank Vontobel AG
            "8760", //Banque Lombard Odier & Cie SA
            "8761", //Reichmuth & Co
            "8762", //CBH - Compagnie Bancaire Helvétique SA
            "8765", //Notenstein La Roche Privatbank AG
            "8767", //Bordier & Cie
            "8768", //LANDOLT & CIE SA
            "8770", //Mirabaud & Cie SA
            "8774", //Isbank AG, Frankfurt am Main (DE)
            "8775", //E. Gutzwiller & Cie Banquiers
            "8777", //Piguet Galland & Cie SA
            "8778", //BANCA ARNER SA
            "8779", //Rahn+Bodmer Co.
            "8780", //Deutsche Bank AG Zürich Branch
            "87801", //Deutsche Bank AG Zürich Branch
            "87802", //Deutsche Bank AG Zürich Branch
            "8781", //Swissquote Bank SA
            "8784", //Spar- und Leihkasse Frutigen AG
            "8785", //Regiobank Solothurn AG
            "8786", //Bankhaus Jungholz AG
            "8787", //Pfandbriefbank schweizerischer Hypothekarinstitute AG
            "8788", //BANQUE HERITAGE SA
            "8789", //Habib Bank AG Zürich
            "8792", //BNP PARIBAS SECURITIES SERVICES
            "8797", //Timber Hill (Europe) AG
            "8799", //InCore Bank AG
            "8800", //Liechtensteinische Landesbank Aktiengesellschaft
            "8801", //BANK ALPINUM AKTIENGESELLSCHAFT
            "8802", //Neue Bank AG
            "8803", //BENDURA BANK AG
            "8805", //VP Bank AG
            "8806", //Kaiser Partner Privatbank AG
            "8808", //VP Bank AG (formerly Centrum Bank AG)
            "8810", //LGT Bank AG
            "8811", //Bank Frick & Co. Aktiengesellschaft
            "8812", //Volksbank AG
            "8813", //Raiffeisen Privatbank Liechtenstein AG
            "8814", //Banque Havilland (Liechtenstein) AG
            "8815", //Union Bank AG
            "8820", //Dominick Company AG
            "8821", //Vorarlberger Landes- und Hypothekenbank AG
            "8822", //CIM BANQUE SA
            "8825", //SBERBANK (SWITZERLAND) AG
            "8826", //Bantleon Bank AG
            "8827", //HINDUJA BANQUE (SUISSE) SA
            "8830", //INTESA SANPAOLO PRIVATE BANK (SUISSE) SA
            "8831", //ABANCA CORPORACION BANCARIA S.A., BETANZOS
            "8833", //Banque Pâris Bertrand Sturdza SA
            "8836", //COMMERZBANK AG FF, Zweigniederlassung Zürich
            "8838", //Banque du Léman SA
            "8839", //Quilvest (Switzerland) Ltd.
            "8841", //Banco Itaú (Suisse) SA
            "8842", //Globalance Bank AG
            "8843", //Dukascopy Bank SA
            "8845", //Neue Helvetische Bank AG
            "8846", //Aquila & Co. AG
            "8847", //UBL (Switzerland) AG
            "8848", //IG Bank S.A.
            "8850", //Fonds de compensation AVS/AI/APG
            "8851", //SUVA
            "8852", //Swiss Life AG
            "8853", //Schweizerische Rückversicherungs-Gesellschaft AG
            "8854", //AXA Leben AG
            "8855", //Zurich Insurance Company Ltd
            "8856", //Basler Leben AG
            "8857", //New Reinsurance Company Ltd.
            "8858", //Basler Versicherung AG
            "8859", //Schweizerische Mobiliar Versicherungsgesellschaft AG
            "8863", //RBC Investor Services Bank S.A.
            "8864", //Compagnie Privée de Conseils et d'Investissement
            "8865", //Remaco Wealth Management AG
            "8866", //LF FINANCE (SUISSE) SA
            "8867", //State Street Bank International GmbH, München, ZN Zürich
            "8869", //PATRIMONY 1873 SA
            "8871", //Zähringer Privatbank AG
            "8880", //SIX SIS AG
            "8881", //SIX SIS AG
            "8883", //EUREX Clearing AG
            "8887", //SIX SIS AG
            "88871", //SIX SIS (Terravis) AG
            "8890", //Sparkasse Bundespersonal
            "8899", //BIZ Bank für Internationalen Zahlungsausgleich
            "89002", //B. Metzler seel. Sohn & Co. KGaA
            "89006", //Landesbank Berlin AG
            "89007", //Bankhaus Lampe KG
            "89012", //Bayerische Landesbank
            "89013", //UniCredit Bank AG
            "89018", //COMMERZBANK AG
            "89021", //Bethmann Bank AG
            "89022", //Deutsche Bank AG
            "89023", //DekaBank Deutsche Girozentrale
            "89024", //Deutsche Postbank AG
            "89025", //DZ Bank AG
            "89030", //Hamburger Sparkasse AG
            "89033", //J.P. Morgan Securities plc.
            "89034", //Landesbank Hessen-Thüringen
            "89036", //HSH Nordbank AG
            "89042", //Merck Finck & Co Privatbankiers
            "89045", //Morgan Stanley Bank AG
            "89058", //Landesbank Baden-Württemberg
            "89059", //HSBC Trinkaus & Burkhardt AG
            "89060", //DZ Bank AG Deutsche Genossenschaftsbank
            "89067", //Banco Santander, SA, Filiale Frankfurt
            "89070", //Goldman Sachs AG
            "89079", //The Royal Bank of Scotland Plc
            "89081", //Dornbirner Sparkasse Bank AG
            "89088", //Skandinaviska Enskilda Banken AB
            "89089", //Landesbank Hessen Thüringen
            "89091", //DZ PRIVATBANK S.A.
            "89092", //Barclays Bank PLC
            "89093", //Volksbank Dreiländereck EG
            "89095", //Citibank N.A.
            "89098", //Allgemeine Sparkasse Oberösterreich Bank AG
            "89099", //Erste Group Bank AG
            "8910", //CLS Bank International
            "89101", //Societe Generale International Ltd
            "89102", //Coöperatieve Rabobank U.A.
            "89104", //UniCredit Bank Austria AG
            "89105", //NORD/LB Luxembourg S.A.
            "89108", //KAS Bank N.V.
            "89109", //Raiffeisenlandesbank Oberösterreich AG
            "89112", //Oberbank AG
            "89113", //Bank of America N.A.
            "89115", //Swisscanto Funds Centre Limited
            "89116", //National Bank of Greece S.A.
            "89117", //Vorarlberger Landes- und Hyppothekenbank AG
            "89122", //BAWAG P.S.K.
            "89123", //Merrill Lynch International
            "89128", //Banca IMI S.p.A.
            "89129", //Bank für Tirol und Vorarlberg Aktiengesellschaft
            "89136", //Banque Internationale à Luxembourg SA
            "89139", //Raiffeisen Bank International AG
            "89142", //European Investment Bank
            "89144", //Aareal Bank AG
            "89149", //Marex Financial Limited
            "89151", //ING Bank N.V.
            "89152", //Sparkasse der Stadt Feldkirch
            "89157", //HYPO TIROL BANK AG
            "89158", //RBC Europe Limited
            "89162", //Danske Bank A/S
            "89165", //Raiffeisenlandesbank Vorarlberg
            "89169", //CACEIS Bank Deutschland GmbH
            "89171", //RAIFFEISENLANDESBANK NIEDERÖSTERREICH-WIEN AG
            "89172", //Raiffeisen-Landesbank Steiermark AG
            "89174", //Raiffeisen-Landesbank Tirol AG
            "89175", //NRW.BANK
            "89176", //Raiffeisenverband Salzburg eGen
            "89183", //Nomura International plc
            "89184", //Raiffeisenlandesbank Kärnten reg.Gen.m.b.H.
            "89185", //BKS Bank AG
            "89186", //Sparkasse Schwaz AG
            "89191", //Goldman Sachs International
            "89193", //HYPO NOE Gruppe Bank AG
            "89195", //IKB Deutsche Industriebank AG
            "89196", //Abbey National Treasury Services plc London
            "89197", //Nordea Bank AB (publ)
            "89199", //Volksbank Hochrhein eG
            "89202", //Sparkasse Hochrhein
            "89205", //Austrian Anadi Bank AG
            "89206", //European Central Counterparty N.V.
            "89207", //Oesterreichische Kontrollbank AG
            "89208", //Volksbank Rhein-Wehra eG
            "89212", //E D & F  Man Capital Markets Limited
            "89213", //Banque de Luxembourg S.A.
            "89214", //Sparkasse Lörrach-Rheinfelden
            "89215", //LCH Limited
            "89216", //ABN AMRO Clearing Bank N.V.
            "9000", //PostFinance AG
    };
}
