package com.yarolegovich.munging.weather;

import com.yarolegovich.munging.DataStore;
import com.yarolegovich.munging.parser.Row;

/**
 * Created by yarolegovich on 20.12.2015.
 */
public class WeatherStore extends DataStore<WeatherInfo> {

    private static final String WEATHER_DATA = "weather.dat";

    @Override
    protected String getFileName() {
        return WEATHER_DATA;
    }

    @Override
    protected String getRowRegex() {
        return " +(\\d+) +(\\d+)\\*? +(\\d+)\\*?";
    }

    @Override
    protected WeatherInfo mapRow(Row row) {
        return new WeatherInfo(Integer.parseInt(row.valueFor(0)),
                Integer.parseInt(row.valueFor(1)),
                Integer.parseInt(row.valueFor(2))
        );
    }
}
