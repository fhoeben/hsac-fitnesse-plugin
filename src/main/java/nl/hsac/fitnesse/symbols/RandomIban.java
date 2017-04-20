package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.*;
import nl.hsac.fitnesse.util.iban.*;

/**
 * Symbol that creates a random  IBAN number for use in tests.
 * Usage: !randomIBAN
 */

public class RandomIban extends SymbolBase implements Rule, Translation {
    private static final IbanGenerator IBAN_UTIL = new IbanGenerator();
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
        String country = symbol.getProperty(COUNTRY, "");
        String bankCode = symbol.getProperty(BANK, "");
        return IBAN_UTIL.generateIban(country, bankCode);
    }

}
