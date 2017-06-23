package ru.manyagin.Senders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ru.manyagin.DAO.YahooForecastDAO;
import ru.manyagin.Interfaces.Forecast;
import ru.manyagin.Interfaces.ForecastsDAO;

import javax.jms.*;

/**
 * Created by MManiagin on 14.06.2017.
 */

@Component(value = "forecastTopicListener")
public class ForecastTopicListener implements MessageListener {

    @Autowired
    ForecastsDAO dao;


    public void onMessage(Message message) {
        System.out.println("Receiver");
        ObjectMessage msg = (ObjectMessage) message;
        try{
            Forecast forecast = (Forecast) msg.getObject();
            dao.saveForecast(forecast);
            System.out.println("MESSAGE: " + forecast.toString());
        }catch (JMSException e){
            e.printStackTrace();
        }
    }


}
