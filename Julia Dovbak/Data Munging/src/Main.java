import java.io.IOException;
import java.util.List;

import common.DataReader;
import common.MinSpreadComp;
import football.FootballMapper;
import football.FootballRecord;
import weather.WeatherMapper;
import weather.WeatherRecord;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		// Comparator
		final MinSpreadComp minSpreadComp = new MinSpreadComp();
		
		// Data Reader for reading files
		final DataReader dataReader = new DataReader();
		
		// "Mappers" for mapping text data to objects
		final WeatherMapper weatherMapper = new WeatherMapper();
		final FootballMapper footballMapper = new FootballMapper();
		
		// Reading records from file(s)
		final List<WeatherRecord> weatherRecords = dataReader.read("res/weather.dat", weatherMapper);
		final List<FootballRecord> footballRecords = dataReader.read("res/football.dat", footballMapper);
		
		// sorting them to find the ones with smallest "spread/goal difference"
		weatherRecords.sort(minSpreadComp);
		footballRecords.sort(minSpreadComp);
		
		// Output smallest weather record (first in list)
		WeatherRecord smallestWeatherSpread = weatherRecords.get(0);
		System.out.println("Weather Record with smallest spread");
		System.out.println(smallestWeatherSpread);
		
		// Output smallest football record (first in list)
		FootballRecord smallestGoalsDiff = footballRecords.get(0);
		System.out.println("Footbal Record with smallest difference in 'for' and 'against' goals:");
		System.out.println(smallestGoalsDiff);
	}
}
