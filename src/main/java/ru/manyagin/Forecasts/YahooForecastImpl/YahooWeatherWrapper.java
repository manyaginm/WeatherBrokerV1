package ru.manyagin.Forecasts.YahooForecastImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by MManiagin on 19.06.2017.
 */
@Entity
@Table(name = "forecasts")
@IdClass(WrapperKey.class)
public class YahooWeatherWrapper implements Serializable{
    @Id
    private String city;
    @Id
    private String country;
    @Id
    private String region;
    @Id
    private String date;



    @Column(name = "high")
    private int high;
    @Column(name = "low")
    private int low;


    public YahooWeatherWrapper() {
    }

    public YahooWeatherWrapper(String city, String country, String region, int high, int low, Date date) throws ParseException {
        this.city = city;
        this.country = country;
        this.region = region;
        this.high = high;
        this.low = low;
        this.date = toNormalDate(date);
    }




    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) throws ParseException {
        this.date = toNormalDate(date);
    }

    static private String toNormalDate(Date date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DATE);
        return year+"-"+month+"-"+day;

    }
    public String toString(){
        return this.getCity()+" "+this.getRegion()+" "+this.getCountry()+" "+this.getHigh()+" "+this.getLow()+" "+this.getDate().toString();
    }
}
