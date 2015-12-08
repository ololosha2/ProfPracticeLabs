package weather;

import major.Data;

public class Weather implements Data {
    private final int day, min, max;

    public Weather(int day, int min, int max) {
        this.day = day;
        this.min = min;
        this.max = max;
    }

    @Override
    public int getSpread() {
        return max - min;
    }

    @Override
    public String toString() {
        return "Weather: " + "day=" + day + ", max=" + max + ", min=" + min;
    }
}
