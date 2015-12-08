package practice_lab2.common;

import java.util.ArrayList;

/**
 * Implementation of data units group printer.
 */
public class DataGroupSmallestSpreadPrinter implements DataGroupPrinter {
    @Override
    public void print(DataGroup group) {
        ArrayList<DataUnit> units = group.getDataUnits();
        DataUnit minSpread = units.get(0);

        for(DataUnit c : units) {
            if(minSpread.getSpread() > c.getSpread()) {
                minSpread = c;
            }
        }

        System.out.println(minSpread);
    }
}
