package nl.hsac.fitnesse.symbols;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DaySymbolTest {
    @Test
    public void testNoIncrement() {
        checkNext(new DaySymbol.Friday(), 0, 10);
        checkNext(new DaySymbol.Saturday(), 0, 11);
        checkNext(new DaySymbol.Sunday(), 0, 12);
        checkNext(new DaySymbol.Monday(), 0, 13);
        checkNext(new DaySymbol.Tuesday(), 0, 14);
        checkNext(new DaySymbol.Wednesday(), 0, 15);
        checkNext(new DaySymbol.Thursday(), 0, 16);
    }

    @Test
    public void testIncrementOne() {
        checkNext(new DaySymbol.Friday(), 1, 11);
        checkNext(new DaySymbol.Saturday(), 1, 12);
        checkNext(new DaySymbol.Sunday(), 1, 13);
        checkNext(new DaySymbol.Monday(), 1, 14);
        checkNext(new DaySymbol.Tuesday(), 1, 15);
        checkNext(new DaySymbol.Wednesday(), 1, 16);
        checkNext(new DaySymbol.Thursday(), 1, 17);
    }

    @Test
    public void testIncrementMinusOne() {
        checkNext(new DaySymbol.Friday(), -1, 9);
        checkNext(new DaySymbol.Saturday(), -1, 10);
        checkNext(new DaySymbol.Sunday(), -1, 11);
        checkNext(new DaySymbol.Monday(), -1, 12);
        checkNext(new DaySymbol.Tuesday(), -1, 13);
        checkNext(new DaySymbol.Wednesday(), -1, 14);
        checkNext(new DaySymbol.Thursday(), -1, 15);
    }

    @Test
    public void testIncrementTwo() {
        checkNext(new DaySymbol.Friday(), 2, 12);
        checkNext(new DaySymbol.Saturday(), 2, 13);
        checkNext(new DaySymbol.Sunday(), 2, 14);
        checkNext(new DaySymbol.Monday(), 2, 15);
        checkNext(new DaySymbol.Tuesday(), 2, 16);
        checkNext(new DaySymbol.Wednesday(), 2, 17);
        checkNext(new DaySymbol.Thursday(), 2, 18);
    }

    @Test
    public void testIncrementMinusTwo() {
        checkNext(new DaySymbol.Wednesday(), -2, 13);
        checkNext(new DaySymbol.Thursday(), -2, 14);
    }

    private void checkNext(DaySymbol nf, int increment, int day) {
        GregorianCalendar calendar = new GregorianCalendar(2017, 2, 10);
        nf.addIncrement(calendar, increment);
        checkDate(2017, 3, day, calendar);
    }

    private void checkDate(int year, int month, int day, GregorianCalendar cal) {
        assertEquals("year", year, cal.get(Calendar.YEAR));
        assertEquals("month", month - 1, cal.get(Calendar.MONTH));
        assertEquals("day", day, cal.get(Calendar.DAY_OF_MONTH));
    }
}
