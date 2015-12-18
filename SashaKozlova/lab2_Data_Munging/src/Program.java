/**
 * Created by Sergey.Kozlov on 24.11.2015.
 */
public class Program {

    public static void main(String[]args) {
        FileProcessor fileProcessor = new FileProcessor();

        WeatherFileProcessor weather = new WeatherFileProcessor();
        FootballFileProcessor football = new FootballFileProcessor();

        System.out.println(weather.processFile(fileProcessor.readFromFile("weather.dat")));
        System.out.println(football.processFile(fileProcessor.readFromFile("football.dat")));
    }



}
