package nl.hsac.fitnesse.symbols;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class WeekDaysFromTodayTest {
    @Test
    public void testAddNegative() {
        WeekDaysFromToday symbol = new WeekDaysFromToday();
        GregorianCalendar c = new GregorianCalendar();

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, 0);
        checkDate(c, 2, Calendar.MAY, 2015);

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, -1);
        checkDate(c, 1, Calendar.MAY, 2015);

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, -2);
        checkDate(c, 30, Calendar.APRIL, 2015);

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, -3);
        checkDate(c, 29, Calendar.APRIL, 2015);

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, -4);
        checkDate(c, 28, Calendar.APRIL, 2015);

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, -5);
        checkDate(c, 27, Calendar.APRIL, 2015);

        c.set(2015, Calendar.MAY, 1);
        symbol.addIncrement(c, -4);
        checkDate(c, 27, Calendar.APRIL, 2015);
    }

    @Test
    public void testAddNegativeWithWeekend() {
        WeekDaysFromToday symbol = new WeekDaysFromToday();
        GregorianCalendar c = new GregorianCalendar();

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, -6);
        checkDate(c, 24, Calendar.APRIL, 2015);

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, -7);
        checkDate(c, 23, Calendar.APRIL, 2015);

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, -8);
        checkDate(c, 22, Calendar.APRIL, 2015);
    }

    @Test
    public void testAddPositive() {
        WeekDaysFromToday symbol = new WeekDaysFromToday();
        GregorianCalendar c = new GregorianCalendar();

        c.set(2015, Calendar.MAY, 4);
        symbol.addIncrement(c, 0);
        checkDate(c, 4, Calendar.MAY, 2015);

        c.set(2015, Calendar.MAY, 4);
        symbol.addIncrement(c, 1);
        checkDate(c, 5, Calendar.MAY, 2015);

        c.set(2015, Calendar.MAY, 4);
        symbol.addIncrement(c, 2);
        checkDate(c, 6, Calendar.MAY, 2015);

        c.set(2015, Calendar.MAY, 4);
        symbol.addIncrement(c, 3);
        checkDate(c, 7, Calendar.MAY, 2015);

        c.set(2015, Calendar.MAY, 4);
        symbol.addIncrement(c, 4);
        checkDate(c, 8, Calendar.MAY, 2015);

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, 4);
        checkDate(c, 7, Calendar.MAY, 2015);
    }

    @Test
    public void testAddPositiveWithWeekend() {
        WeekDaysFromToday symbol = new WeekDaysFromToday();
        GregorianCalendar c = new GregorianCalendar();

        c.set(2015, Calendar.MAY, 4);
        symbol.addIncrement(c, 5);
        checkDate(c, 11, Calendar.MAY, 2015);

        c.set(2015, Calendar.MAY, 4);
        symbol.addIncrement(c, 6);
        checkDate(c, 12, Calendar.MAY, 2015);

        c.set(2015, Calendar.MAY, 4);
        symbol.addIncrement(c, 10);
        checkDate(c, 18, Calendar.MAY, 2015);
    }

    private void checkDate(GregorianCalendar c, int day, int month, int year) {
        assertEquals(day, c.get(Calendar.DAY_OF_MONTH));
        assertEquals(month, c.get(Calendar.MONTH));
        assertEquals(year, c.get(Calendar.YEAR));
    }


}
