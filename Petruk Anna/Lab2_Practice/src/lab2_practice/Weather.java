/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_practice;

/**
 *
 * @author Pavilion
 */
public class Weather {
    private final int day;
    private final int maxTemperature;
    private final int minTemperature;
    
    public Weather(int newDay, int newMax, int newMin){
        this.day = newDay;
        this.maxTemperature = newMax;
        this.minTemperature = newMin;
    }
    
    public int getDay(){
        return day;
    }
    
    public int getTemperatureSpread(){
        return maxTemperature - minTemperature;
    }
    
    @Override
    public String toString(){
        return "Weather:\n  Day: " + day + 
               "\n  Max temperature: " + maxTemperature + 
               "\n  Min temperature: " + minTemperature + 
               "\n  Temperature spread: " + getTemperatureSpread();
    }
}
