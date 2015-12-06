package nl.hsac.fitnesse.symbols;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Variation on !today, allowing last day of a month to be selected.
 */
public class LastDayOfMonth extends MonthsFromToday {
    public LastDayOfMonth() {
        super("LastDayOfMonth", "!lastDayOfMonth");
    }

    @Override
    protected void addIncrement(GregorianCalendar cal, int increment) {
        // go to first day of month
        cal.set(Calendar.DATE, 1);
        // add 1 more month than requested, to go to end of this
        super.addIncrement(cal, increment + 1);
        // subtract 1 to go to last of month before
        cal.add(Calendar.DATE, -1);
    }

}
