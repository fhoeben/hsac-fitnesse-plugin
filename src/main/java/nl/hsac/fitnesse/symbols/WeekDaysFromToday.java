package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Today;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Our version of !today, that allows us to specify working days instead of days,
 * i.e. no Saturdays and Sundays
 * Usage: !weekDaysFromToday [(format)] [+|-increment]
 */
public class WeekDaysFromToday extends Today {
    public WeekDaysFromToday() {
        super("WeekDaysFromToday", "!weekDaysFromToday", Calendar.DATE);
    }

    @Override
    protected void addIncrement(GregorianCalendar cal, int numWeekDays) {
        int numDays = Math.abs(numWeekDays);
        int dateAddition = numWeekDays < 0 ? -1 : 1;

        for (int i = 0; i < numDays; i++) {
            cal.add(Calendar.DATE, dateAddition);

            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY) {
                i--;
            }
        }
    }
}
