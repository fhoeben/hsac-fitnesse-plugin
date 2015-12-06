package nl.hsac.fitnesse.symbols;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LastDayOfMonthTest {
    @Test
    public void testAddNegative() {
        LastDayOfMonth symbol = new LastDayOfMonth();
        GregorianCalendar c = new GregorianCalendar();

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, 0);
        checkDate(c, 31, Calendar.MAY, 2015);

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, -1);
        checkDate(c, 30, Calendar.APRIL, 2015);

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, -3);
        checkDate(c, 28, Calendar.FEBRUARY, 2015);
    }

    @Test
    public void testAddPositive() {
        LastDayOfMonth symbol = new LastDayOfMonth();
        GregorianCalendar c = new GregorianCalendar();

        c.set(2015, Calendar.MAY, 4);
        symbol.addIncrement(c, 0);
        checkDate(c, 31, Calendar.MAY, 2015);

        c.set(2015, Calendar.MAY, 2);
        symbol.addIncrement(c, 1);
        checkDate(c, 30, Calendar.JUNE, 2015);

        c.set(2016, Calendar.JANUARY, 1);
        symbol.addIncrement(c, 1);
        checkDate(c, 29, Calendar.FEBRUARY, 2016);

        c.set(2016, Calendar.JANUARY, 15);
        symbol.addIncrement(c, 7);
        checkDate(c, 31, Calendar.AUGUST, 2016);
    }

    private void checkDate(GregorianCalendar c, int day, int month, int year) {
        WeekDaysFromTodayTest.checkDate(c, day, month, year);
    }
}
