package nl.hsac.fitnesse.symbols;

import java.util.Calendar;

/**
 * An altered !today, that allows us to calculate a date relative to the first Thursday (today or later).
 * Usage: !Thursday [(format)] [+|-increment]
 */
public class Thursday extends DaySymbol {
    public Thursday() {
        super("Thursday", "!Thursday", Calendar.THURSDAY);
    }
}