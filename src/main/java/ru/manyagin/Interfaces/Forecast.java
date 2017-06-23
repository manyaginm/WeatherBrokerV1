package ru.manyagin.Interfaces;

import java.io.Serializable;

/**
 * Created by MManiagin on 08.06.2017.
 */
/*FIXME*/
/*Должен содержать методы тиапа getHigh getLow, и тогда его должны имплементить готовые реализации*/
public interface Forecast extends Serializable {
     String getCity();
     String getRegion();
     String getCountry();

}
