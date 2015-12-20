package com.yarolegovich.munging.football;

import com.yarolegovich.munging.Spreaded;

/**
 * Created by yarolegovich on 20.12.2015.
 */
public class FootballInfo implements Spreaded {

    public final String teamName;
    public final int scored;
    public final int passed;

    public FootballInfo(String teamName, int scored, int passed) {
        this.teamName = teamName;
        this.scored = scored;
        this.passed = passed;
    }

    @Override
    public String toString() {
        return "FootballInfo{" +
                "teamName='" + teamName + '\'' +
                ", scored=" + scored +
                ", passed=" + passed +
                '}';
    }

    @Override
    public int getSpread() {
        return Math.abs(scored - passed);
    }
}
