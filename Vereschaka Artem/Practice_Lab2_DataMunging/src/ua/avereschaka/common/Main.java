package ua.avereschaka.common;

import ua.avereschaka.football.FootballMapper;
import ua.avereschaka.football.FootballPoint;
import ua.avereschaka.weather.WeatherMapper;
import ua.avereschaka.weather.WeatherPoint;

import java.io.*;
import java.util.Comparator;

public class Main<T> {
    private static final String WEATHER_INPUT_FILE = "resources/weather.dat";
    private static final String FOOTBALL_INPUT_FILE = "resources/football.dat";

    private final InputData<T> reader;
    private Comparator<T> comparator;

    public Main(InputData<T> reader, Comparator<T> comparator) {
        this.reader = reader;
        this.comparator = comparator;
    }

    public void printSpreads(String filename) throws IOException {
        final Object[] points = reader.getPoints(filename).sorted(comparator).toArray();
        System.out.println("min = " + points[0]);
        System.out.println("max = " + points[points.length - 1]);
    }

    public static void main(String[] args) throws IOException {

        final InputData<WeatherPoint> reader = new InputData<>(WeatherMapper.WEATHER_MAPPER);
        final Main<WeatherPoint> m = new Main(reader, new DataPointComparator());
        m.printSpreads(WEATHER_INPUT_FILE);

        final InputData<FootballPoint> reader2 = new InputData<>(FootballMapper.FOOTBALL_MAPPER);
        final Main<WeatherPoint> m2 = new Main(reader2, new DataPointComparator());
        m2.printSpreads(FOOTBALL_INPUT_FILE);


    }
}
