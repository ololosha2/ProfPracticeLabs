package practice_lab2;

import practice_lab2.common.DataGroup;
import practice_lab2.common.DataGroupLoader;
import practice_lab2.common.DataGroupPrinter;
import practice_lab2.common.DataGroupSmallestSpreadPrinter;
import practice_lab2.football.SeasonFCInfo;
import practice_lab2.football.SeasonFCInfoLoader;
import practice_lab2.football.SeasonSmallestSpreadPrinter;
import practice_lab2.weather.MonthSmallestSpreadPrinter;
import practice_lab2.weather.MonthWeatherInfo;
import practice_lab2.weather.MonthWeatherInfoLoader;

import java.io.IOException;

/**
 * Main.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Old code execution:");
        runOldCode();
        System.out.println("\n\n\nNew Code execution:");
        runNewCode();
    }

    /*
     * Main code after accomplishing 3rd task
     */
    public static void runNewCode() {
        DataGroupLoader monthLoader = new MonthWeatherInfoLoader();
        DataGroupLoader seasonFCLoader = new SeasonFCInfoLoader();

        DataGroup month = new DataGroup();
        DataGroup season = new DataGroup();

        try {
            // Temperature
            monthLoader.load(month);

            System.out.println("Smallest temperature spread:");
            DataGroupPrinter groupPrinter = new DataGroupSmallestSpreadPrinter();
            groupPrinter.print(month);

            // Football clubs
            seasonFCLoader.load(season);

            System.out.println("\nSmallest scores spread:");
            groupPrinter.print(season);
        }
        catch(IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Exception caught " + e.getMessage());
        }
    }

    /*
     * Main code before accomplishing 3rd task
     */
    public static void runOldCode() {
        MonthWeatherInfoLoader monthLoader = new MonthWeatherInfoLoader();
        SeasonFCInfoLoader seasonFCLoader = new SeasonFCInfoLoader();

        MonthWeatherInfo month = new MonthWeatherInfo();
        SeasonFCInfo season = new SeasonFCInfo();

        try {
            // Temperature
            monthLoader.load(month);

            System.out.println("Smallest temperature spread:");
            MonthSmallestSpreadPrinter monthPrinter = new MonthSmallestSpreadPrinter();
            monthPrinter.print(month);

            // Football clubs
            seasonFCLoader.load(season);

            System.out.println("\nSmallest scores spread:");
            SeasonSmallestSpreadPrinter clubPrinter = new SeasonSmallestSpreadPrinter();
            clubPrinter.print(season);
        }
        catch(IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Exception caught " + e.getMessage());
        }
    }
}
