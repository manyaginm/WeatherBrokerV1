package ru.manyagin.DAO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.manyagin.Forecasts.YahooForecastImpl.YahooForecastImpl;
import ru.manyagin.Interfaces.Forecast;
import ru.manyagin.Interfaces.ForecastsDAO;

import javax.transaction.Transactional;

/**
 * Created by MManiagin on 22.06.2017.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(value = {"classpath:WEB-INF/dispatcher-servlet.xml"})
public class secondTestYahooForecastDao {
    @InjectMocks
    @Autowired
    ForecastsDAO dao;
    @InjectMocks
    @Autowired
    Forecast forecast;
    @InjectMocks
    @Autowired
    YahooForecastImpl yahooForecast;

    @Test
    public void objTest(){
        Assert.assertNotNull(dao);
    }

    @Test
    public void saveTest(){
        dao.saveForecast(forecast);
    }
    @Test
    public void saveYahoForecastTest(){
        dao.saveForecast(yahooForecast);
    }
    @Test(expected = ClassCastException.class)
    public void castExceptionTest(){
         dao.saveForecast((Forecast)new Object());
    }

}
