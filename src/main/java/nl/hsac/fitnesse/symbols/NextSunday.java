package nl.hsac.fitnesse.symbols;

import java.util.Calendar;

/**
 * An altered !today, that allows us to calculate a date relative to a specific weekday.
 * Usage: !nextSunday [(format)] [+|-increment]
 */

public class NextSunday extends NextXDay {
    public NextSunday() {
        super("NextSunday", "!nextSunday", Calendar.DATE);
        super.setDay(Calendar.SUNDAY);
    }
}
