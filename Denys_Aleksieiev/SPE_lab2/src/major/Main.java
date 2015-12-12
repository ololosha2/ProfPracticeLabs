package major;
import weather.Weather;
import weather.WeatherMapper;

import java.io.*;
import java.util.Comparator;

import football.Football;
import football.FootballMapper;

public class Main {
	 private  static String WEATHER_PATH = "resources/weather.dat";
	 private  static String FOOTBALL_PATH = "resources/football.dat";

    public static void main(String[] args) throws IOException {

        final DataReader<Weather> reader = new DataReader<>(WeatherMapper.WEATHER_MAPPER);
        final DataManager<Weather> manager1 = new DataManager(reader, new DataComparator());
        manager1.printSpreads(WEATHER_PATH);
        System.out.println();
        final DataReader<Football> reader2 = new DataReader<>(FootballMapper.FOOTBALL_MAPPER);
        final DataManager<Weather> manager2 = new DataManager(reader2, new DataComparator());
        manager2.printSpreads(FOOTBALL_PATH);
    }
}
