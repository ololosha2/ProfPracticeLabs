package weather;

import common.DataRecord;

public class WeatherRecord implements DataRecord
{
	private int day;
	private int min;
	private int max;

    public WeatherRecord(int dayNumber, int minTemp, int maxTemp) {
        this.day = dayNumber;
        this.min = minTemp;
        this.max = maxTemp;
    }

    public int getSpread() {
        return max - min;
    }
    
    @Override
    public String toString()
    {
    	StringBuilder builder = new StringBuilder();
    	builder.append("Weather Record(");
    	builder.append("day = " + day + ", ");
    	builder.append("min = " + min + ", ");
    	builder.append("max = " + max + ", ");
    	builder.append("spread = " + getSpread() + ")");
    	
    	return builder.toString();
    }

}
