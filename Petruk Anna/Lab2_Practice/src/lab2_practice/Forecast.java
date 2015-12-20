/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.valueOf;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.compile;

/**
 *
 * @author Pavilion
 */
public class Forecast implements Reading{
    
    private ArrayList<Weather> forecast = new ArrayList<>();
    
    @Override
    public void reading(File file) throws IOException {

	try {
            BufferedReader buffReader = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            
            String currentLine;
            boolean inData = false;
            while ((currentLine = buffReader.readLine()) != null) {
                if (inData == true && currentLine.startsWith("  mo")) {
                    inData = false;
		} else if (inData == false && currentLine.startsWith("   ")) {
                    inData = true;
		}
                if (inData) {
                    Pattern p = compile("\\d");
                    Matcher m = p.matcher(currentLine);
                    m.find();
                    int dayStartIndex = m.start();
                    p = compile("\\d ");
                    m = p.matcher(currentLine);
                    m.find();
                    int dayEndIndex = m.start() + 1;
                    int day = valueOf(currentLine.substring(dayStartIndex, dayEndIndex));
                    
                    p = compile("\\d  ");
                    m = p.matcher(currentLine);
                    m.find();
                    int maxStartIndex = m.end();
                    p = compile("\\d  \\d+");
                    m = p.matcher(currentLine);
                    m.find();
                    int maxEndIndex = m.end();
                    int maxTemp = valueOf(currentLine.substring(maxStartIndex, maxEndIndex));

                    p = compile("    \\d");
                    m = p.matcher(currentLine);
                    m.find();
                    int minStartIndex = m.end() - 1;
                    p = compile("    [\\d]+");
                    m = p.matcher(currentLine);
                    m.find();
                    int minEndIndex = m.end();
                    int minTemp = valueOf(currentLine.substring(minStartIndex, minEndIndex));

                    getForecast().add(new Weather(day, maxTemp, minTemp));
                }
            }
            
            Weather smallestTemperatureSpead = calcTheSmallestTemp(getForecast());
            
            out.println("\n\033[31mDay " + smallestTemperatureSpead.getDay() +
                               " has the smallest spead of temperature \033[31m" + smallestTemperatureSpead.getTemperatureSpread());
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Weather calcTheSmallestTemp(ArrayList<Weather> forecast) {
        Weather smallestTemperatureSpead = forecast.get(0);
        for (Weather weather : forecast) {
            out.println(weather.toString());
            int temperatureSpread = weather.getTemperatureSpread();
            if (temperatureSpread < smallestTemperatureSpead.getTemperatureSpread()) {
                smallestTemperatureSpead = weather;
            }
        }
        return smallestTemperatureSpead;
    }

    /**
     * @return the forecast
     */
    public ArrayList<Weather> getForecast() {
        return forecast;
    }

    /**
     * @param forecast the forecast to set
     */
    public void setForecast(ArrayList<Weather> forecast) {
        this.forecast = forecast;
    }
}
