package ru.manyagin.Conectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.manyagin.Forecasts.YahooForecastImpl.YahooDailyWeather;
import ru.manyagin.Forecasts.YahooForecastImpl.YahooForecastImpl;
import ru.manyagin.Interfaces.Forecast;
import ru.manyagin.Interfaces.WeatherServerConnection;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;


@Component
public class YahooConnector implements WeatherServerConnection{
    public Forecast getForecast(String city) {

        /*FIXME
        * @Autowired doesnt work restTemplate
        * */

        RestTemplate restTemplate = new RestTemplate();
        YahooForecastImpl impl = new YahooForecastImpl();


        String jsonResult = restTemplate.getForObject("https://query.yahooapis.com/v1/public/yql?q=select" +
                " * from weather.forecast where woeid in (select woeid from geo.places(1) where text='"+city+"')and u='c'&format=json", String.class);

        ObjectMapper om = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = om.readTree(jsonResult);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String location = rootNode.get("query").get("results").get("channel").get("location").toString();
        String weatherConditions = rootNode.get("query").get("results").get("channel").get("item").get("forecast").toString();
        try {
            impl = om.readValue(location, YahooForecastImpl.class);
            impl.setWeatherList((List<YahooDailyWeather>) om.readValue(weatherConditions,
                    om.getTypeFactory().constructCollectionType(List.class, YahooDailyWeather.class)));
            System.out.println(impl.getWeatherList().toString());
        }catch (IOException e){e.printStackTrace();}


        return impl;
    }

}
