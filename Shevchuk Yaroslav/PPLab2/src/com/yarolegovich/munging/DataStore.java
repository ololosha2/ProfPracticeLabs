package com.yarolegovich.munging;

import com.yarolegovich.munging.parser.Row;
import com.yarolegovich.munging.parser.TableParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yarolegovich on 20.12.2015.
 */
public abstract class DataStore<T> {

    protected List<T> table;

    public DataStore() {
        String fileName = getFileName();
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IllegalStateException("Alert!!! No data found!");
        }

        try {
            table = TableParser.withRowPattern(getRowRegex())
                    .parseTable(Files.readAllLines(Paths.get(fileName)))
                    .stream().map(this::mapRow)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file: " + e.getMessage());
        }
    }

    public T getMin(Comparator<? super T> comparator) {
        List<T> temp = new ArrayList<>(table);
        Collections.sort(temp, comparator);
        return temp.get(0);
    }

    protected abstract String getFileName();
    protected abstract String getRowRegex();
    protected abstract T mapRow(Row row);
}
