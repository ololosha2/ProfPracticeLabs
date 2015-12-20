package com.data.munging;

public class Football {

    private static final String FILE_FOOTBALL = "files/football.dat";

    public static String minGoalsDifference() {
        return Common.minDifference(Common.readFromFile(FILE_FOOTBALL), 1);
    }

}
