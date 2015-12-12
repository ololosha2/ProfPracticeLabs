package football;
import major.Data;

public class Football implements Data {
    private final String team;
    private final int goalsFor, goalsAgainst;

    public Football(String team, int goalsFor, int goalsAgainst) {
        this.team = team;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    @Override
    public int getSpread() {
        return goalsFor - goalsAgainst;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "Football: " + "team='" + team + '\'' + ", goals for=" + goalsFor + ", goals against=" + goalsAgainst;
    }
}
