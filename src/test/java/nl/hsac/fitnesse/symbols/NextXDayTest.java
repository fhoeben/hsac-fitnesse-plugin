package nl.hsac.fitnesse.symbols;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class NextXDayTest {
    @Test
    public void testNoIncrement() {
        checkNext(new NextFriday(), 0, 10);
        checkNext(new NextSaturday(), 0, 11);
        checkNext(new NextSunday(), 0, 12);
        checkNext(new NextMonday(), 0, 13);
        checkNext(new NextTuesday(), 0, 14);
        checkNext(new NextWednesday(), 0, 15);
        checkNext(new NextThursday(), 0, 16);
    }

    @Test
    public void testIncrementOne() {
        checkNext(new NextFriday(), 1, 17);
        checkNext(new NextSaturday(), 1, 18);
        checkNext(new NextSunday(), 1, 19);
        checkNext(new NextMonday(), 1, 20);
        checkNext(new NextTuesday(), 1, 21);
        checkNext(new NextWednesday(), 1, 22);
        checkNext(new NextThursday(), 1, 23);
    }

    @Test
    public void testIncrementMinusOne() {
        checkNext(new NextFriday(), -1, 3);
        checkNext(new NextSaturday(), -1, 4);
        checkNext(new NextSunday(), -1, 5);
        checkNext(new NextMonday(), -1, 6);
        checkNext(new NextTuesday(), -1, 7);
        checkNext(new NextWednesday(), -1, 8);
        checkNext(new NextThursday(), -1, 9);
    }

    @Test
    public void testIncrementTwo() {
        checkNext(new NextFriday(), 2, 24);
        checkNext(new NextSaturday(), 2, 25);
        checkNext(new NextSunday(), 2, 26);
        checkNext(new NextMonday(), 2, 27);
        checkNext(new NextTuesday(), 2, 28);
        checkNext(new NextWednesday(), 2, 29);
        checkNext(new NextThursday(), 2, 30);
    }

    @Test
    public void testIncrementMinusTwo() {
        checkNext(new NextWednesday(), -2, 1);
        checkNext(new NextThursday(), -2, 2);
    }

    private void checkNext(NextXDay nf, int increment, int day) {
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
