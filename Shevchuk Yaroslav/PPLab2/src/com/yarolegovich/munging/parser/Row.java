package com.yarolegovich.munging.parser;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yarolegovich on 20.12.2015.
 */
public class Row {

    protected List<String> values;

    public Row(List<String> values) {
        this.values = values;
    }

    public String valueFor(int columnIndex) {
        return values.get(columnIndex);
    }

    @Override
    public String toString() {
        return "Row{" + values.stream()
                .collect(Collectors.joining(","))
                + "}";
    }
}
