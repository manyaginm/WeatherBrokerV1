package ru.manyagin.Forecasts.YahooForecastImpl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by MManiagin on 08.06.2017.
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class YahooDailyWeather implements Serializable{

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.US);


    @JsonProperty(value = "high")

    private int high;
    @JsonProperty(value = "low")

    private int low;
    @JsonProperty(value = "date")
    Date date;

    public YahooDailyWeather() {
    }

    public YahooDailyWeather(int high, int low, String date) throws ParseException {
        this.high = high;
        this.low = low;
        this.date = sdf.parse(date);

    }


    public int getHigh() {
        return high;
    }
    @JsonProperty(value = "high")
    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }
    @JsonProperty(value = "low")
    public void setLow(int low) {
        this.low = low;
    }

    public Date getDate() {
        return date;
    }

    @JsonProperty(value = "date")
    public void setDate(String date) throws ParseException {
        this.date =  sdf.parse(date);
    }

    @Override
    public String toString(){
        return "Date: "+ this.date + " high: "+this.high+" low: "+this.low;
    }
}
