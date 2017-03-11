package nl.hsac.fitnesse.symbols;

import java.util.Calendar;

/**
 * An altered !today, that allows us to calculate a date relative to the first Tuesday (today or later).
 * Usage: !Tuesday [(format)] [+|-increment]
 */
public class Tuesday extends DaySymbol {
    public Tuesday() {
        super("Tuesday", "!Tuesday", Calendar.TUESDAY);
    }
}