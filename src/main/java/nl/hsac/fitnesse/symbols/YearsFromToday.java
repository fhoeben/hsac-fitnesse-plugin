package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Today;

import java.util.Calendar;

/**
 * Our version of !today, that allows us to specify years instead of days.
 * Usage: !yearsFromToday [(format)] [+|-increment]
 */
public class YearsFromToday extends Today {
    public YearsFromToday() {
        super("YearsFromToday", "!yearsFromToday", Calendar.YEAR);
    }

    public YearsFromToday(String symbolName, String symbolText)  {
        super(symbolName, symbolText, Calendar.YEAR);
    }
}
