package nl.hsac.fitnesse.symbols;

import java.util.Calendar;

/**
 * An altered !today, that allows us to calculate a date relative to a specific monday.
 * Usage: !nextMonday [(format)] [+|-increment]
 */

public class NextMonday extends NextXDay {
    public NextMonday() {
        super("NextMonday", "!nextMonday", Calendar.DATE, Calendar.MONDAY);
    }
}