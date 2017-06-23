package ru.manyagin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.manyagin.Conectors.YahooConnector;
import ru.manyagin.Interfaces.ForecastsDAO;
import ru.manyagin.Interfaces.JMSSender;
import ru.manyagin.Interfaces.WeatherServerConnection;

/**
 * Created by MManiagin on 06.06.2017.
 */
@Controller
public class MainController {

    @Autowired
    JMSSender sender;
    @Autowired
    ForecastsDAO dao;
    @Autowired
    @Qualifier(value = "yahooConnector")
    WeatherServerConnection conn;

    @RequestMapping(value = "/")
    public ModelAndView main(ModelAndView mav){
        mav.setViewName("weatherMain");
        return mav;
    }

    @RequestMapping(value="/weatherResult")
    public ModelAndView weatherResult(@RequestParam(value = "city", required = false) String city, ModelAndView modelAndView){
       modelAndView.setViewName("weatherResults");
       modelAndView.addObject("city", city);
       sender.send(conn.getForecast(city));
       return modelAndView;

   }
    @RequestMapping(value = "/test")
    public void getTest(){
        dao.getForecast("samara");
    }
}
