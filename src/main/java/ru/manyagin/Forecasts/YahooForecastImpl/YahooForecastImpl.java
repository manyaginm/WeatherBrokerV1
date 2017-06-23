package ru.manyagin.Forecasts.YahooForecastImpl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import ru.manyagin.Interfaces.Forecast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MManiagin on 08.06.2017.
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class YahooForecastImpl implements Forecast{
    private String country;
    private String city;
    private String region;

    private List<YahooDailyWeather> weatherList=new ArrayList<YahooDailyWeather>();

    public void addWeatherToList(YahooDailyWeather weather){
        weatherList.add(weather);
    }

    public List<YahooDailyWeather> getWeatherList() {
        return weatherList;
    }

    @JsonProperty(value="forecast")
    public void setWeatherList(List<YahooDailyWeather> weatherList) {
        this.weatherList = weatherList;
    }

    public String getCountry() {
        return country;
    }
    @JsonProperty(value = "country")
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }
    @JsonProperty(value = "city")
    public void setCity(String city) {
        this.city = city;
    }
    @JsonProperty(value = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString(){
        String str = this.country + " " + this.region + " " +this.city;

        for (YahooDailyWeather d: weatherList
                ) {
            str+="\n"+d.toString();
        }
        return str;
    }
}
