package nl.hsac.fitnesse.symbols;

import fitnesse.util.Clock;
import fitnesse.wikitext.parser.Symbol;
import fitnesse.wikitext.parser.Today;
import fitnesse.wikitext.parser.Translator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Abstract class to get the next occurrence of a specific weekday. Can be called with +x to skip x occurrences
 */

public abstract class NextXDay extends Today {
    private int DAY;

    public NextXDay(String name, String symbol, int date){
        super(name, symbol, date);
    }

    public void setDAY(int newDay) {
        DAY = newDay;
    }

    @Override
    public String toTarget(Translator translator, Symbol symbol) {
        String increment = symbol.getProperty("Increment");
        int incrementInt = increment.startsWith("+")?Integer.parseInt(increment.substring(1)):(increment.startsWith("-")?-Integer.parseInt(increment.substring(1)):0);
        GregorianCalendar calendar = getNext(incrementInt);
        return (new SimpleDateFormat(this.makeFormat(symbol.getProperty("Format")))).format(calendar.getTime());
    }

    protected GregorianCalendar getNext(int incrementInt) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(Clock.currentDate());
        while(calendar.get(Calendar.DAY_OF_WEEK) != DAY) {
            calendar.add(Calendar.DATE, 1);
        }
        this.addIncrement(calendar, incrementInt);
        return calendar;
    }

    @Override
    protected void addIncrement(GregorianCalendar cal, int numWeekDays) {
        int numDays = Math.abs(numWeekDays);
        int dateAddition = numWeekDays < 0 ? -1 : 1;

        for (int i = 0; i < numDays; i++) {
            cal.add(Calendar.DATE, dateAddition);

            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != DAY) {
                i--;
            }
        }
    }

    private String makeFormat(String format) {
        return format.equals("-t")?"d MMM, yyyy HH:mm":(format.equals("-xml")?"yyyy-MM-dd\'T\'HH:mm:ss":(format.isEmpty()?"dd MMM, yyyy":format));
    }
}
