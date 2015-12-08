package practice_lab2.weather;

import practice_lab2.DataRowReader;
import practice_lab2.common.DataGroup;
import practice_lab2.common.DataGroupLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Valeriy on 8/12/2015.
 */
public class MonthWeatherInfoLoader implements DataGroupLoader {
    public int load(DataGroup group) throws IOException {
        int amount = 0;

        BufferedReader reader = new BufferedReader(new FileReader("data\\weather.dat"));
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

            if(params[0].equals("mo")) {
                continue;
            }

            group.add(new DayWeatherInfo(
                    Integer.parseInt(params[0]),
                    Double.parseDouble(params[1]),
                    Double.parseDouble(params[2])
            ));
            amount++;
        }
        return amount;
    }
}
