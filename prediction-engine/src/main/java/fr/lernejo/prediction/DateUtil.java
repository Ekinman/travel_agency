package fr.lernejo.prediction;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date MinusDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
}
