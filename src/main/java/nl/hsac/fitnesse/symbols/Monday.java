package nl.hsac.fitnesse.symbols;

import java.util.Calendar;

/**
 * An altered !today, that allows us to calculate a date relative to the first Monday (today or later).
 * Usage: !Monday [(format)] [+|-increment]
 */
public class Monday extends DaySymbol {
    public Monday() {
        super("Monday", "!Monday", Calendar.MONDAY);
    }
}