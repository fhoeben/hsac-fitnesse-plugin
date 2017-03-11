package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Today;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Abstract class to get the first occurrence (starting today) of a specific day of the week.
 * Can be called with +x or -x to add x or subtract days.
 */
public abstract class DayOfWeek extends Today {
    private int day;

    protected DayOfWeek(String name, String symbol, int day){
        super(name, symbol, Calendar.DATE);
        this.day = day;
    }

    @Override
    protected void addIncrement(GregorianCalendar cal, int increment) {
        while (cal.get(Calendar.DAY_OF_WEEK) != day) {
            cal.add(Calendar.DATE, 1);
        }
        super.addIncrement(cal, increment);
    }

    /**
     * An altered !today, that allows us to calculate a date relative to the first Monday (today or later).
     * Usage: !Monday [(format)] [+|-increment]
     */
    public static class Monday extends DayOfWeek {
        public Monday() {
            super("Monday", "!Monday", Calendar.MONDAY);
        }
    }

    /**
     * An altered !today, that allows us to calculate a date relative to the first Tuesday (today or later).
     * Usage: !Tuesday [(format)] [+|-increment]
     */
    public static class Tuesday extends DayOfWeek {
        public Tuesday() {
            super("Tuesday", "!Tuesday", Calendar.TUESDAY);
        }
    }

    /**
     * An altered !today, that allows us to calculate a date relative to the first Wednesday (today or later).
     * Usage: !Wednesday [(format)] [+|-increment]
     */
    public static class Wednesday extends DayOfWeek {
        public Wednesday() {
            super("Wednesday", "!Wednesday", Calendar.WEDNESDAY);
        }
    }

    /**
     * An altered !today, that allows us to calculate a date relative to the first Thursday (today or later).
     * Usage: !Thursday [(format)] [+|-increment]
     */
    public static class Thursday extends DayOfWeek {
        public Thursday() {
            super("Thursday", "!Thursday", Calendar.THURSDAY);
        }
    }

    /**
     * An altered !today, that allows us to calculate a date relative to the first Friday (today or later).
     * Usage: !Friday [(format)] [+|-increment]
     */
    public static class Friday extends DayOfWeek {
        public Friday() {
            super("Friday", "!Friday", Calendar.FRIDAY);
        }
    }

    /**
     * An altered !today, that allows us to calculate a date relative to the first Saturday (today or later).
     * Usage: !Saturday [(format)] [+|-increment]
     */
    public static class Saturday extends DayOfWeek {
        public Saturday() {
            super("Saturday", "!Saturday", Calendar.SATURDAY);
        }
    }

    /**
     * An altered !today, that allows us to calculate a date relative to the first Sunday (today or later).
     * Usage: !Sunday [(format)] [+|-increment]
     */
    public static class Sunday extends DayOfWeek {
        public Sunday() {
            super("Sunday", "!Sunday", Calendar.SUNDAY);
        }
    }
}
