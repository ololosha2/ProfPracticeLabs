package com.data.munging;

import java.util.LinkedList;

public class Weather {

    private static final String FILE_WEATHER = "files/weather.dat";

    public static String minTemperatureDifference() {
        LinkedList<LinkedList<String>> temperatureList = Common.readFromFile(FILE_WEATHER);
        temperatureList.removeLast();
        return Common.minDifference(temperatureList, 0);
    }
}
