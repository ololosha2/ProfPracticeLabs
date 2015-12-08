package practice_lab2.common;

import java.util.ArrayList;

/**
 * Stores group of data units.
 */
public class DataGroup {
    ArrayList<DataUnit> dataUnits;


    public DataGroup() {
        this.dataUnits = new ArrayList<>();
    }

    public void add(DataUnit unit) {
        this.dataUnits.add(unit);
    }

    public ArrayList<DataUnit> getDataUnits() {
        return this.dataUnits;
    }
}
