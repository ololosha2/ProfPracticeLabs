package football;

import common.DataRecord;

public class FootballRecord implements DataRecord
{
	private String teamName;
	private int goalsFor;
	private int goalsAgainst;

	public FootballRecord(String teamName, int goalsFor, int goalsAgainst)
	{
		this.teamName = teamName;
		this.goalsFor = goalsFor;
		this.goalsAgainst = goalsAgainst;
	}

	public int getSpread()
	{
		return goalsFor - goalsAgainst;
	}

    @Override
    public String toString()
    {
    	StringBuilder builder = new StringBuilder();
    	builder.append("Football Record(");
    	builder.append("team = " + teamName + ", ");
    	builder.append("for = " + goalsFor + ", ");
    	builder.append("against = " + goalsAgainst + ", ");
    	builder.append("difference = " + getSpread() + ")");
    	
    	return builder.toString();
    }
}
