package nl.hsac.fitnesse.symbols;

import java.util.Calendar;

/**
 * An altered !today, that allows us to calculate a date relative to a specific weekday.
 * Usage: !nextThursday [(format)] [+|-increment]
 */

public class NextThursday extends NextXDay {
    public NextThursday() {
        super("NextThursday", "!nextThursday", Calendar.THURSDAY);
    }
}