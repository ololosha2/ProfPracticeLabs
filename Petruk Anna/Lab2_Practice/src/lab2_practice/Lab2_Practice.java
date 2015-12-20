/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Pavilion
 */
public class Lab2_Practice {
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // Part One: Weather Data
        File file3 = new File
            ("C:\\Users\\Pavilion\\Documents\\NetBeansProjects\\Lab2_Practice\\Weather.dat");
        
        Forecast forecast = new Forecast();
        forecast.reading(file3);
        
        // Part Two: Soccer League Table
        
        File file2 = new File
            ("C:\\Users\\Pavilion\\Documents\\NetBeansProjects\\Lab2_Practice\\Football.dat");
        FootballTable data2 = new FootballTable();
        data2.reading(file2);
        
    }  
}