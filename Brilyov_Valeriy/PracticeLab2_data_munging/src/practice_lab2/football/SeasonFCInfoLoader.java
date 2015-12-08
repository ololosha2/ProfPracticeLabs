package practice_lab2.football;

import practice_lab2.DataRowReader;
import practice_lab2.common.DataGroup;
import practice_lab2.common.DataGroupLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Loads data of football clubs.
 */
public class SeasonFCInfoLoader implements DataGroupLoader {
    public int load(DataGroup group) throws IOException {
        int amount = 0;

        BufferedReader reader = new BufferedReader(new FileReader("data\\football.dat"));
        DataRowReader loader = new DataRowReader();

        boolean firstLine = true;
        String line;
        String[] params;
        while((line = reader.readLine()) != null) {
            if(firstLine) {
                firstLine = false;
                continue;
            }

            if((params = loader.getParameters(line)) == null) {
                continue;
            }

            group.add(new FootballClubInfo(
                    params[1], // Team column
                    Integer.parseInt(params[6]), // F column
                    Integer.parseInt(params[7]) // A column
            ));
            amount++;
        }
        return amount;
    }
}
