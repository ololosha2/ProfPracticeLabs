package practice_lab2.football;

import practice_lab2.common.DataGroup;
import practice_lab2.common.DataGroupPrinter;
import practice_lab2.common.DataUnit;

import java.util.ArrayList;

/**
 * Prints a football club with smallest spread of scores.
 *
 * Note: this class is left just to show differences between old and new code in
 * main() method.
 */
public class SeasonSmallestSpreadPrinter implements DataGroupPrinter {
    @Override
    public void print(DataGroup group) {
        ArrayList<DataUnit> clubs = group.getDataUnits();
        DataUnit minSpread = clubs.get(0);

        for(DataUnit c : clubs) {
            if(minSpread.getSpread() > c.getSpread()) {
                minSpread = c;
            }
        }

        System.out.println(minSpread);
    }
}
