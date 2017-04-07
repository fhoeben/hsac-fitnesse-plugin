package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.*;
import nl.hsac.fitnesse.util.NlBankCodes;
import nl.hsac.fitnesse.util.IbanUtil;
import nl.hsac.fitnesse.util.RandomUtil;

/**
 * Symbol that creates a random  IBAN number for use in tests.
 * Currently only Dutch IBAN's are supported
 * Usage: !randomIBAN
 */
public class RandomIban extends SymbolBase implements Rule, Translation {
    private static final IbanUtil IBAN_UTIL = new IbanUtil();
    private static final RandomUtil RANDOM_UTIL = new RandomUtil();
    private static final String COUNTRY = "countryCode";
    private static final String BANK = "bankCode";


    public RandomIban() {
        super("RandomIban");
        wikiMatcher(new Matcher().string("!randomIBAN"));
        wikiRule(this);
        htmlTranslation(this);
    }

    public Maybe<Symbol> parse(Symbol current, Parser parser) {
        Maybe<Symbol> result = storeParenthesisContent(current, parser, COUNTRY);
        if (!result.isNothing()) {
            result = storeParenthesisContent(current, parser, BANK);
        }
        return result;
    }

    public String toTarget(Translator translator, Symbol symbol) {
        String bankCode = symbol.getProperty(BANK, RANDOM_UTIL.randomEnum(NlBankCodes.class).toString());
        String country = symbol.getProperty(COUNTRY, "NL");
        return IBAN_UTIL.generateIban(country, bankCode);

    }

}
