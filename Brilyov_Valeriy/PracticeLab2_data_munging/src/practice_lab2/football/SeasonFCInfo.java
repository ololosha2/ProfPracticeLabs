package practice_lab2.football;

import practice_lab2.common.DataGroup;

import java.util.ArrayList;

/**
 * SeasonFCInfo - stores info about FCs statistics during a season.
 * Due to the implementation of DataGroup class, this class can be removed.
 *
 * Note: this class is left just to show differences between old and new code in
 * main() method.
 */
public class SeasonFCInfo extends DataGroup {
    ArrayList<FootballClubInfo> clubs;

    public SeasonFCInfo() {
        this.clubs = new ArrayList<>();
    }

    public void add(FootballClubInfo day) {
        this.clubs.add(day);
    }

    public ArrayList<FootballClubInfo> get() {
        return this.clubs;
    }
}
