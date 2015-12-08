package weather;

import java.util.function.Function;

public class WeatherMapper {

    public static final Function<String, Weather> WEATHER_MAPPER = l -> {
        final String[] fields = l.split(" +");
        final String dayNumber = fields[0];
        final String maxTemp = fields[1];
        final String minTemp = fields[2];
        return new Weather(
                Integer.parseInt(dayNumber),
                Integer.parseInt(minTemp),
                Integer.parseInt(maxTemp));
    };

}
