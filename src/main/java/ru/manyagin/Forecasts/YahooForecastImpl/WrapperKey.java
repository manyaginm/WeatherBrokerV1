package ru.manyagin.Forecasts.YahooForecastImpl;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by MManiagin on 19.06.2017.
 */
@Embeddable
public class WrapperKey implements Serializable{
    @Column(name="city")
    protected String city;
    @Column(name="country")
    protected   String country;
    @Column(name="region")
    protected   String region;
    @Column(name="forecastdate")
    protected   String date;

    public WrapperKey() {
    }

    public WrapperKey(String city, String country, String region, String date) {
        this.city = city;
        this.country = country;
        this.region = region;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
