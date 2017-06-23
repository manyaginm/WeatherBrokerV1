package ru.manyagin;

import ru.manyagin.Forecasts.YahooForecastImpl.YahooDailyWeather;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by MManiagin on 22.06.2017.
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        String date = "2017-06-30 00:00:00.0";
       YahooDailyWeather w = new YahooDailyWeather(10, 10, getDate(date));

        System.out.println(w.getDate());
    }

    static String getDate(String date) throws ParseException {
        Calendar c =new GregorianCalendar();
        int year = Integer.parseInt(date.substring(0,4));
        int month=Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        String h = c.getTime().toString();
        return h.substring(8,10)+" "+h.substring(4,7)+" "+h.substring(25, 29);

    }
}
