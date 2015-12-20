package lab2_practice_snizhko_oleksandr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Oleksandr
 */
public class Lab2_Practice_Snizhko_Oleksandr {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // Part One: Weather Data
        File file3 = new File
            ("C:\\Users\\Oleksandr\\Desktop\\Lab2_Practice_Snizhko_Oleksandr\\Weather.dat");
        
        Forecast forecast = new Forecast();
        forecast.reading(file3);
        
        // Part Two: Soccer League Table
        
        File file2 = new File
            ("C:\\Users\\Oleksandr\\Desktop\\Lab2_Practice_Snizhko_Oleksandr\\Football.dat");
        Football_Table data2 = new Football_Table();
        data2.reading(file2);
        
    }  
}