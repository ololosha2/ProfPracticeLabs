package com.yarolegovich.munging.parser;

import javafx.util.Pair;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by yarolegovich on 20.12.2015.
 */
public class TableParser {

    public static TableParser withRowPattern(String pattern) {
        return new TableParser(pattern);
    }

    private Pattern pattern;

    private TableParser(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public List<Row> parseTable(List<String> str) {
        return str.stream()
                .map(s -> new Pair<>(s, pattern.matcher(s)))
                .filter(p -> p.getValue().find())
                .map(p -> {
                    Matcher m = p.getValue();
                    return new Row(IntStream.rangeClosed(1, m.groupCount())
                            .mapToObj(m::group)
                            .collect(Collectors.toList()));
                }).collect(Collectors.toList());
    }
}
