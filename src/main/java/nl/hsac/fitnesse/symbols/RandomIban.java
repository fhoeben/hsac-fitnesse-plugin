package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Matcher;
import fitnesse.wikitext.parser.Maybe;
import fitnesse.wikitext.parser.Parser;
import fitnesse.wikitext.parser.Rule;
import fitnesse.wikitext.parser.Symbol;
import fitnesse.wikitext.parser.Translation;
import fitnesse.wikitext.parser.Translator;
import nl.hsac.fitnesse.util.iban.IbanGenerator;

/**
 * Symbol that creates a random  IBAN number for use in tests.
 * Usage: !randomIBAN
 */

public class RandomIban extends SymbolBase implements Rule, Translation {
    private static final IbanGenerator IBAN_GENERATOR = new IbanGenerator();
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
        String country = symbol.findProperty(COUNTRY, "");
        String bankCode = symbol.findProperty(BANK, "");
        return IBAN_GENERATOR.generateIban(country, bankCode);
    }

}
