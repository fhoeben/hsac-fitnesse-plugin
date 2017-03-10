package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Today;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Abstract class to get the next occurrence of a specific weekday. Can be called with +x to skip x occurrences
 */

public abstract class NextXDay extends Today {
    private int day;

    protected NextXDay(String name, String symbol, int day){
        super(name, symbol, Calendar.DATE);
        this.day = day;
    }

    @Override
    protected void addIncrement(GregorianCalendar cal, int numWeekDays) {
        while (cal.get(Calendar.DAY_OF_WEEK) != day) {
            cal.add(Calendar.DATE, 1);
        }

        int numDays = Math.abs(numWeekDays);
        int dateAddition = numWeekDays < 0 ? -1 : 1;

        for (int i = 0; i < numDays; i++) {
            cal.add(Calendar.DATE, dateAddition);

            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != day) {
                i--;
            }
        }
    }
}
