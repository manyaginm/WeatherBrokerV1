package ru.manyagin.Senders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import ru.manyagin.Interfaces.Forecast;
import ru.manyagin.Interfaces.JMSSender;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by MManiagin on 14.06.2017.
 */
@Component(value="forecastSender")
public class ForecastSender implements JMSSender{
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    Destination destination;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    public Destination getDestination() {
        return destination;
    }
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void send(final Forecast forecast){
        jmsTemplate.send(destination, new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(forecast);
            }

        });

    }
    public ForecastSender(){}

}
