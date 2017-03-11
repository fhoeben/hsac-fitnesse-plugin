package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Today;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Abstract class to get the first occurrence (starting today) of a specific day of the week.
 * Can be called with +x or -x to add x or subtract days.
 */
public abstract class DaySymbol extends Today {
    private int day;

    protected DaySymbol(String name, String symbol, int day){
        super(name, symbol, Calendar.DATE);
        this.day = day;
    }

    @Override
    protected void addIncrement(GregorianCalendar cal, int increment) {
        while (cal.get(Calendar.DAY_OF_WEEK) != day) {
            cal.add(Calendar.DATE, 1);
        }
        super.addIncrement(cal, increment);
    }
}
