package nl.hsac.fitnesse.symbols;

import java.util.Calendar;

/**
 * An altered !today, that allows us to calculate a date relative to a specific friday.
 * Usage: !nextFriday [(format)] [+|-increment]
 */

public class NextFriday extends NextXDay {
    public NextFriday() {
        super("NextFriday", "!nextFriday", Calendar.DATE);
        super.setDAY(Calendar.FRIDAY);
    }
}