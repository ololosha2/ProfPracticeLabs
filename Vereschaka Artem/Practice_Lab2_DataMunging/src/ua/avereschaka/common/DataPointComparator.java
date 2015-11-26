package ua.avereschaka.common;

import java.util.Comparator;

public class DataPointComparator implements Comparator<DataPoint> {

    @Override
    public int compare(DataPoint o1, DataPoint o2) {
        return o1.getSpread() - o2.getSpread();
    }
}
