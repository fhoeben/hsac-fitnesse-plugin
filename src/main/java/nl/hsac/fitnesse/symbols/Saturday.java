package nl.hsac.fitnesse.symbols;

import java.util.Calendar;


/**
 * An altered !today, that allows us to calculate a date relative to the first Saturday (today or later).
 * Usage: !Saturday [(format)] [+|-increment]
 */
public class Saturday extends DaySymbol {
    public Saturday() {
        super("Saturday", "!Saturday", Calendar.SATURDAY);
    }
}