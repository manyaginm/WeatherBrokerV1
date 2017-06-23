package ru.manyagin.DAO;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.manyagin.Forecasts.YahooForecastImpl.YahooDailyWeather;
import ru.manyagin.Forecasts.YahooForecastImpl.YahooForecastImpl;
import ru.manyagin.Forecasts.YahooForecastImpl.YahooWeatherWrapper;
import ru.manyagin.Interfaces.Forecast;
import ru.manyagin.Interfaces.ForecastsDAO;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;

/**
 * Created by MManiagin on 19.06.2017.
 */
@Repository
public class YahooForecastDAO implements ForecastsDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void saveForecast(Forecast forecast) {
        Session session = sessionFactory.openSession();
        try{
            YahooForecastImpl impl =(YahooForecastImpl)forecast;
            for (YahooDailyWeather dw: impl.getWeatherList()
                    ) {
                YahooWeatherWrapper y = new YahooWeatherWrapper(impl.getCity(),
                        impl.getCountry(),
                        impl.getRegion(),
                        dw.getHigh(),
                        dw.getLow(),
                        dw.getDate());
                session.beginTransaction();
                session.persist(y);
                session.getTransaction().commit();
            }
            System.out.println("Loaded");
        }catch (ParseException e) {
            e.printStackTrace();
        }catch (ConstraintViolationException e){
            System.out.println("Данные записи уже сущ-т");
        } catch (PersistenceException e){e.printStackTrace();}

        finally {
            session.close();
        }
    }

    @Transactional
    public List<YahooWeatherWrapper> getForecast(String city) {
        Session session = sessionFactory.openSession();
        List<YahooWeatherWrapper> list =
                session.createQuery("from YahooWeatherWrapper where city=:city and date>current_date", YahooWeatherWrapper.class)
                        .setParameter("city", city).list();
        System.out.println("THIS IS SPAAAAAAAAAAAAAAAARTA!!!!!!!!!");
        for (YahooWeatherWrapper we:list
                ) {
            System.out.println(we.toString());
        }
        session.close();
        return list;

    }
}
