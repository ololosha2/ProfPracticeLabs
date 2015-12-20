package com.yarolegovich.munging.weather;

import com.yarolegovich.munging.Spreaded;

/**
 * Created by yarolegovich on 20.12.2015.
 */
public class WeatherInfo implements Spreaded {

    public final int day;
    public final int max;
    public final int min;

    public WeatherInfo(int day, int max, int min) {
        this.day = day;
        this.max = max;
        this.min = min;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "day=" + day +
                ", max=" + max +
                ", min=" + min +
                '}';
    }

    @Override
    public int getSpread() {
        return max - min;
    }
}
