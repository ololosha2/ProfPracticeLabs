package com.yarolegovich.munging.football;

import com.yarolegovich.munging.DataStore;
import com.yarolegovich.munging.parser.Row;

/**
 * Created by yarolegovich on 20.12.2015.
 */
public class FootballStore extends DataStore<FootballInfo> {

    private static final String FOOTBALL_DATA = "football.dat";

    @Override
    protected String getFileName() {
        return FOOTBALL_DATA;
    }

    @Override
    protected String getRowRegex() {
        return "[^\\.]+\\. (\\w+) +(?:\\d+) +(?:\\d+) +(?:\\d+) +(?:\\d+) +(\\d+) +- +(\\d+)";
    }

    @Override
    protected FootballInfo mapRow(Row row) {
        return new FootballInfo(row.valueFor(0),
                Integer.parseInt(row.valueFor(1)),
                Integer.parseInt(row.valueFor(2))
        );
    }
}
