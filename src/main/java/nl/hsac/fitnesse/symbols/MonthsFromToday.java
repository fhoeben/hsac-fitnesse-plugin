package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Today;

import java.util.Calendar;

/**
 * Our version of !today, that allows us to specify months instead of days, and allows
 * 0s in the increment.
 * Usage: !monthsFromToday [(format)] [+|-increment]
 *
 * To be able to use it, please ensure the class name is added to the list of SymbolTypes in
 * plugins.properties
 */
public class MonthsFromToday extends Today {
    public MonthsFromToday() {
        super("MonthsFromToday", "!monthsFromToday", Calendar.MONTH);
    }
}
