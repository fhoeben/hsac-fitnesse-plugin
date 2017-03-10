package nl.hsac.fitnesse.symbols;

import java.util.Calendar;

/**
 * An altered !today, that allows us to calculate a date relative to a specific wednesday.
 * Usage: !nextWednesday [(format)] [+|-increment]
 */

public class NextWednesday extends NextXDay {
    public NextWednesday() {
        super("NextWednesday", "!nextWednesday", Calendar.DATE, Calendar.WEDNESDAY);
    }
}