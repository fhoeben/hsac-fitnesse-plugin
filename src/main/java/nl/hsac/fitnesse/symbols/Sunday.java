package nl.hsac.fitnesse.symbols;

import java.util.Calendar;

/**
 * An altered !today, that allows us to calculate a date relative to the first Sunday (today or later).
 * Usage: !Sunday [(format)] [+|-increment]
 */
public class Sunday extends DaySymbol {
    public Sunday() {
        super("Sunday", "!Sunday", Calendar.SUNDAY);
    }
}
