package lab2_practice_snizhko_oleksandr;

/**
 *
 * @author Oleksandr
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
        return "\n\033[34mWeather: \n\033[31m  Day: " + day + 
               "\n  Maximum temperature: " + maxTemperature + 
               "\n  Minimum temperature: " + minTemperature + 
               "\n  Temperature spread: " + getTemperatureSpread();
    }
}
