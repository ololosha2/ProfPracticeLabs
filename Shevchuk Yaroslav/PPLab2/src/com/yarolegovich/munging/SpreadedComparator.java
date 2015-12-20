package com.yarolegovich.munging;

import java.util.Comparator;

/**
 * Created by yarolegovich on 20.12.2015.
 */
public class SpreadedComparator implements Comparator<Spreaded> {
    @Override
    public int compare(Spreaded o1, Spreaded o2) {
        return o1.getSpread() - o2.getSpread();
    }
}
