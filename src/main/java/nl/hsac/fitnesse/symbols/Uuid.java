package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.*;
import java.util.UUID;

public class Uuid extends SymbolBase implements Rule, Translation {

    public Uuid() {
        super("Uuid");
        wikiMatcher(new Matcher().string("!uuid"));
        wikiRule(this);
        htmlTranslation(this);
    }

    @Override
    public Maybe<Symbol> parse(Symbol current, Parser parser) {
        return new Maybe<>(current);
    }

    @Override
    public String toTarget(Translator translator, Symbol symbol) {
        return UUID.randomUUID().toString();
    }
}
