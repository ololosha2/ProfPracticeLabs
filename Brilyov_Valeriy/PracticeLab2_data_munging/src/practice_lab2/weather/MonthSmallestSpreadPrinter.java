package practice_lab2.weather;

import practice_lab2.common.DataGroup;
import practice_lab2.common.DataGroupPrinter;
import practice_lab2.common.DataUnit;

import java.util.ArrayList;

/**
 * Prints a day with the smallest spread of temperature.
 *
 * Note: this class is left just to show differences between old and new code in
 * main() method.
 */
public class MonthSmallestSpreadPrinter implements DataGroupPrinter {
    @Override
    public void print(DataGroup group) {
        ArrayList<DataUnit> days = group.getDataUnits();
        DataUnit minSpread = days.get(0);

        for(DataUnit d : days) {
            if(minSpread.getSpread() > d.getSpread()) {
                minSpread = d;
            }
        }

        System.out.println(minSpread);
    }
}
