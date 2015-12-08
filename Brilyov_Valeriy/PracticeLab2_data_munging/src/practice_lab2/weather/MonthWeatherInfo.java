package practice_lab2.weather;

import practice_lab2.common.DataGroup;
import practice_lab2.common.DataUnit;

import java.util.ArrayList;

/**
 * MonthWeatherInfo - stores info about the weather during all month.
 * Due to the implementation of DataGroup class, this class can be removed.
 *
 * Note: this class is left just to show differences between old and new code in
 * main() method.
 */
public class MonthWeatherInfo extends DataGroup {

    @Override
    public void add(DataUnit day) {
        super.add(day);
    }

    public ArrayList<DataUnit> getDataUnits() {
        return super.getDataUnits();
    }
}
