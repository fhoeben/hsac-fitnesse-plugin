package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Today;

import java.util.Calendar;

/**
 * Our version of !today, that allows us to specify months instead of days.
 * Usage: !monthsFromToday [(format)] [+|-increment]
 */
public class MonthsFromToday extends Today {
    public MonthsFromToday() {
        super("MonthsFromToday", "!monthsFromToday", Calendar.MONTH);
    }
}
