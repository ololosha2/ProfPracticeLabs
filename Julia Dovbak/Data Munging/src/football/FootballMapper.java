package football;
import common.DataRecordMapper;

public class FootballMapper implements DataRecordMapper<FootballRecord>
{

	public FootballRecord map(String[] lineParts)
	{
		String team 		= lineParts[1];
		int goalsFor 		= Integer.valueOf(lineParts[6]);
		int goalsAgainst 	= Integer.valueOf(lineParts[7]);

		return new FootballRecord(team, goalsFor, goalsAgainst);
	}

}