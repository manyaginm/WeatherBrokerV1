package ru.manyagin.Senders;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.mockito.Mockito.*;

import ru.manyagin.Forecasts.YahooForecastImpl.YahooForecastImpl;
import ru.manyagin.Interfaces.Forecast;
import ru.manyagin.Interfaces.JMSSender;

/**
 * Created by MManiagin on 22.06.2017.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(value = {"classpath:WEB-INF/dispatcher-servlet.xml"})
public class testforecastSender {
    @InjectMocks
    @Autowired
    JMSSender sender;

    @Autowired
    @InjectMocks
    Forecast f ;

    @Autowired
    YahooForecastImpl impl=null;

    @Test
    public void testSenderfail(){
        Assert.assertNotNull(sender);
    }
    @Test
    public void testSender(){
        sender.send(f);
    }

}
