package nl.hsac.fitnesse.symbols;

import java.util.Calendar;


/**
 * An altered !today, that allows us to calculate a date relative to a specific weekday.
 * Usage: !nextMonday [(format)] [+|-increment]
 */

public class NextSaturday extends NextXDay {
    public NextSaturday() {
        super("NextSaturday", "!nextSaturday", Calendar.DATE, Calendar.SATURDAY);
    }
}