package nl.hsac.fitnesse.symbols;

import java.util.Calendar;

/**
 * An altered !today, that allows us to calculate a date relative to the first Friday (today or later).
 * Usage: !Friday [(format)] [+|-increment]
 */
public class Friday extends DaySymbol {
    public Friday() {
        super("Friday", "!Friday", Calendar.FRIDAY);
    }
}