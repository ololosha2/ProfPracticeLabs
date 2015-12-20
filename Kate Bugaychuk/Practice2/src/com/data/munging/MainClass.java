package com.data.munging;

public class MainClass {

    public static void main(String[] args) {

        System.out.println("Smallest temperature difference: day " + Weather.minTemperatureDifference());
        System.out.println("Smallest difference in ‘for’ and ‘against’ goals: team " + Football.minGoalsDifference());
    }
}
