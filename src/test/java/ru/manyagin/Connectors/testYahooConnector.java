package ru.manyagin.Connectors;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import ru.manyagin.Conectors.YahooConnector;
import ru.manyagin.Forecasts.YahooForecastImpl.YahooForecastImpl;

/**
 * Created by MManiagin on 22.06.2017.
 */
public class testYahooConnector {

    YahooForecastImpl impl;
    YahooConnector conn = new YahooConnector();

    @Test
    public void getForecastTest(){
    impl = (YahooForecastImpl) conn.getForecast("saratov");
    Assert.assertEquals("Saratov", impl.getCity());
    Assert.assertEquals("Russia", impl.getCountry());
    Assert.assertEquals(" Saratov Oblast", impl.getRegion());
    }

    @Test
    public void testNull(){
        impl = (YahooForecastImpl) conn.getForecast("Moscow");
        Assert.assertNotSame("Saratov", impl.getCity());
        Assert.assertNotSame("Russia", impl.getCountry());
        Assert.assertNotSame(" Saratov Oblast", impl.getRegion());
    }
}
