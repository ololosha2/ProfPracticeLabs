package weather;

import common.DataRecordMapper;

public class WeatherMapper implements DataRecordMapper<WeatherRecord>
{

	public WeatherRecord map(String[] lineParts)
	{
		int day = Integer.valueOf(lineParts[0]);
		int max = Integer.valueOf(lineParts[1]);
		int min = Integer.valueOf(lineParts[2]);

		return new WeatherRecord(day, min, max);
	}

}
