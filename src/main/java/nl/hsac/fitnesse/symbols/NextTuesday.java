package nl.hsac.fitnesse.symbols;

import java.util.Calendar;

/**
 * An altered !today, that allows us to calculate a date relative to a specific tuesday.
 * Usage: !nextTuesday [(format)] [+|-increment]
 */

public class NextTuesday extends NextXDay {
    public NextTuesday() {
        super("NextTuesday", "!nextTuesday", Calendar.DATE);
        super.setDAY(Calendar.TUESDAY);
    }
}