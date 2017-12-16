package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.*;
import nl.hsac.fitnesse.util.RandomPostalCodeGenerator;

/**
 * Generates a random Postal for the indicated country
 * Default country is The Netherlands
 * if a country code is chosen without postalcode definition, a warning is given
 */
public class RandomPostalCode extends SymbolBase implements Rule, Translation {
    private static final RandomPostalCodeGenerator RANDOM_POSTAL_CODE_GENERATOR = new RandomPostalCodeGenerator();
    private static final String COUNTRY_CODE = "CountryCode";

    public RandomPostalCode() {
        super("RandomPostalCode");
        wikiMatcher(new Matcher().string("!randomPostalCode"));
        wikiRule(this);
        htmlTranslation(this);
    }

    public Maybe<Symbol> parse(Symbol current, Parser parser) {
        return storeParenthesisContent(current, parser, COUNTRY_CODE);
    }

    public String toTarget(Translator translator, Symbol symbol) {
        String param = symbol.getProperty(COUNTRY_CODE, "NL");
        return RANDOM_POSTAL_CODE_GENERATOR.getRandomPostalCodeString(param);
    }


}
