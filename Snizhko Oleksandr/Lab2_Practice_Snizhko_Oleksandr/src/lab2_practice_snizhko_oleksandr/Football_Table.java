package lab2_practice_snizhko_oleksandr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author Oleksandr
 */
public class Football_Table implements Read{
    
    private static final int TEAM_COL = 2;
    private static final int FOR_GOALS_COL = 7;
    private static final int AGAINST_GOALS_COL = 9;
    
    private final Map<String, Integer> teamGoalSpread = new HashMap<>();
    
    @Override
    public void reading(File file) throws IOException {
        
        final BufferedReader reader = new BufferedReader(new FileReader(file));
        String lineRead = null;
        String team;
        String forGoals;
	String againstGoals;
        while ((lineRead = reader.readLine()) != null) {
            final String[] items = splitLine(lineRead);
            team = findValue(items, TEAM_COL);
            forGoals = findValue(items, FOR_GOALS_COL);
            againstGoals = findValue(items, AGAINST_GOALS_COL);
            recordGoalSpread(team, toInt(forGoals), toInt(againstGoals));
            if(!forGoals.isEmpty() && !againstGoals.isEmpty()){
                System.out.println("\n\033[34mName of team: \033[31m" + team + 
                                   "\n   for: " + forGoals + 
                                   "\n   against: " + againstGoals + 
                                   "\n   difference: " + diffGoals(toInt(forGoals), toInt(againstGoals)));
            }
        }
        System.out.print("\n\033[31mTeam with the smallest difference: \n\033[31m");
        System.out.println(smallestSpread());
    }
    
    private int diffGoals(int g1, int g2){
        int min = Math.min(g2, g1);
        int max = Math.max(g2, g1);
        return max - min;
    }
    
    private String smallestSpread() {
        final List<Integer> values = new ArrayList<>();
	final List<String> teams = new ArrayList<>();
        
        this.teamGoalSpread.entrySet().stream().map((teamEntry) -> {
            values.add(Math.abs(teamEntry.getValue()));
            return teamEntry;
        }).forEach((teamEntry) -> {
            teams.add(teamEntry.getKey());
        });
        
        int lastVal = 0;
        int currentVal = 0;
        int matchPos = 0;
        
	for (int i = 0; i < values.size(); i++) {
            currentVal = values.get(i);
            if (i != 0) {
                lastVal = values.get(i - 1);
            }
            if (lastVal != 0 && currentVal < values.get(matchPos)) {
                matchPos = i;
            }
        }
        return teams.get(matchPos);
    }
    
    private int toInt(final String temp) {
        try {
            return Integer.valueOf(temp);
	} catch (NumberFormatException exception) {
        }
	return -1;
    }
    
    private void recordGoalSpread(final String team, final int forGoals, final int againstGoals) {
        if (forGoals != -1 || againstGoals != -1) {
            this.teamGoalSpread.put(team, (forGoals - againstGoals));
        }
    }
    
    private String[] splitLine(final String lineRead) {
        Pattern p = Pattern.compile("\\s+");
	String[] items = p.split(lineRead);
        return items;
    }
    
    private String findValue(final String[] items, final int columnIndex) {
        for (int i = 0; i < items.length; i++) {
            if (i == columnIndex) {
                return items[i];
            }
        }
        return "";
    }   
}