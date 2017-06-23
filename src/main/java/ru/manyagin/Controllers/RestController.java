package ru.manyagin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.manyagin.Forecasts.YahooForecastImpl.YahooDailyWeather;
import ru.manyagin.Forecasts.YahooForecastImpl.YahooForecastImpl;
import ru.manyagin.Forecasts.YahooForecastImpl.YahooWeatherWrapper;
import ru.manyagin.Interfaces.ForecastsDAO;
import ru.manyagin.Interfaces.JMSSender;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by MManiagin on 20.06.2017.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    JMSSender sender;

    @Autowired
    ForecastsDAO dao;

    @Autowired
    YahooForecastImpl impl;


    @RequestMapping(method = RequestMethod.GET, value = "/forecasts/{city}")
    public ResponseEntity getForecastfromDB(ModelAndView modelAndView, @PathVariable String city) throws ParseException {
         List<YahooWeatherWrapper> list = dao.getForecast(city);
         return new ResponseEntity(list, HttpStatus.OK);

    }


}
