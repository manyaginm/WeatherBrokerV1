package ru.manyagin.Interfaces;

import ru.manyagin.Forecasts.YahooForecastImpl.YahooWeatherWrapper;

import javax.transaction.Transactional;
import java.lang.annotation.Inherited;
import java.util.List;

/**
 * Created by MManiagin on 19.06.2017.
 */
public interface ForecastsDAO {
    void saveForecast(Forecast forecast);
    List<YahooWeatherWrapper> getForecast(String city);
}
