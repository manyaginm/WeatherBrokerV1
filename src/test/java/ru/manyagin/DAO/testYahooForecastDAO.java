package ru.manyagin.DAO;



import org.junit.Test;

import static org.mockito.Mockito.*;
import org.springframework.test.context.ContextConfiguration;
import ru.manyagin.Forecasts.YahooForecastImpl.YahooForecastImpl;
import ru.manyagin.Forecasts.YahooForecastImpl.YahooWeatherWrapper;
import ru.manyagin.Interfaces.Forecast;
import ru.manyagin.Interfaces.ForecastsDAO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by MManiagin on 22.06.2017.
 */

@ContextConfiguration(value = {"classpath:../webapp/WEB-INF/dispatcher-servlet.xml"})

public class testYahooForecastDAO {


    @Test
    public void testDAO() throws ParseException {
    ForecastsDAO dao = mock(ForecastsDAO.class);
    Forecast forecast1 =mock(Forecast.class);
    Forecast forecast2=mock(YahooForecastImpl.class);
    List<YahooWeatherWrapper> list =  new ArrayList<>();
    list.add(new YahooWeatherWrapper("saratov", "saratov", "saratov", 0,0,new Date()));
    YahooForecastImpl impl = mock(YahooForecastImpl.class);

    dao.getForecast("Saratov");
    dao.getForecast("moscow");
    dao.saveForecast(forecast1);
    dao.saveForecast(forecast2);
    verify(dao).getForecast("Saratov");
    verify(dao).getForecast("moscow");
    verify(dao).saveForecast(forecast1);
    verify(dao).saveForecast(forecast2);


    when(dao.getForecast("saratov")).thenReturn(list);


    }
}
