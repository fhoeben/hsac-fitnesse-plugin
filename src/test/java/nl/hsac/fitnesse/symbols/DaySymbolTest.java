package nl.hsac.fitnesse.symbols;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DaySymbolTest {
    @Test
    public void testNoIncrement() {
        checkNext(new Friday(), 0, 10);
        checkNext(new Saturday(), 0, 11);
        checkNext(new Sunday(), 0, 12);
        checkNext(new Monday(), 0, 13);
        checkNext(new Tuesday(), 0, 14);
        checkNext(new Wednesday(), 0, 15);
        checkNext(new Thursday(), 0, 16);
    }

    @Test
    public void testIncrementOne() {
        checkNext(new Friday(), 1, 11);
        checkNext(new Saturday(), 1, 12);
        checkNext(new Sunday(), 1, 13);
        checkNext(new Monday(), 1, 14);
        checkNext(new Tuesday(), 1, 15);
        checkNext(new Wednesday(), 1, 16);
        checkNext(new Thursday(), 1, 17);
    }

    @Test
    public void testIncrementMinusOne() {
        checkNext(new Friday(), -1, 9);
        checkNext(new Saturday(), -1, 10);
        checkNext(new Sunday(), -1, 11);
        checkNext(new Monday(), -1, 12);
        checkNext(new Tuesday(), -1, 13);
        checkNext(new Wednesday(), -1, 14);
        checkNext(new Thursday(), -1, 15);
    }

    @Test
    public void testIncrementTwo() {
        checkNext(new Friday(), 2, 12);
        checkNext(new Saturday(), 2, 13);
        checkNext(new Sunday(), 2, 14);
        checkNext(new Monday(), 2, 15);
        checkNext(new Tuesday(), 2, 16);
        checkNext(new Wednesday(), 2, 17);
        checkNext(new Thursday(), 2, 18);
    }

    @Test
    public void testIncrementMinusTwo() {
        checkNext(new Wednesday(), -2, 13);
        checkNext(new Thursday(), -2, 14);
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
