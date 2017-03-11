package nl.hsac.fitnesse.symbols;

import java.util.Calendar;

/**
 * An altered !today, that allows us to calculate a date relative to the first Wednesday (today or later).
 * Usage: !Wednesday [(format)] [+|-increment]
 */
public class Wednesday extends DaySymbol {
    public Wednesday() {
        super("Wednesday", "!Wednesday", Calendar.WEDNESDAY);
    }
}