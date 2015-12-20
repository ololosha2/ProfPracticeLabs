package com.yarolegovich.munging;

import com.yarolegovich.munging.football.FootballInfo;
import com.yarolegovich.munging.football.FootballStore;
import com.yarolegovich.munging.weather.WeatherInfo;
import com.yarolegovich.munging.weather.WeatherStore;

/**
 * Created by yarolegovich on 20.12.2015.
 */
public class Main {

    public static void main(String[] args) {

        DataStore<WeatherInfo> weatherStore = new WeatherStore();
        WeatherInfo minSpreadW = weatherStore.getMin(new SpreadedComparator());
        System.out.printf("%s where spread=%d", minSpreadW.toString(), minSpreadW.getSpread());

        System.out.println();

        DataStore<FootballInfo> footballStore = new FootballStore();
        FootballInfo minSpreadF = footballStore.getMin(new SpreadedComparator());
        System.out.printf("%s where spread=%d", minSpreadF.toString(), minSpreadF.getSpread());
    }
}
