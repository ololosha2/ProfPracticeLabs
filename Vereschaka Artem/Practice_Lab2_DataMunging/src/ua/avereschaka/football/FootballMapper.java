package ua.avereschaka.football;

import java.util.function.Function;

public class FootballMapper {
    public static final Function<String, FootballPoint> FOOTBALL_MAPPER = l -> {
        final String[] parts = l.split(" +");
        return new FootballPoint(parts[1],
                Integer.parseInt(parts[6]),
                Integer.parseInt(parts[8])
        );
    };
}
