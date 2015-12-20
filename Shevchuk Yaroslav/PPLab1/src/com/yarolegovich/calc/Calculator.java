package com.yarolegovich.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yarolegovich on 19.12.2015.
 */
public class Calculator {

    public int add(String numberString) {
        if (numberString.isEmpty()) {
            return 0;
        }

        List<String> delimiters = getDelimiters(numberString);

        if (!delimiters.stream().anyMatch(numberString::contains)) {
            return Integer.parseInt(numberString);
        }

        List<Integer> numbers = parseNumbers(numberString, delimiters);

        Predicate<Integer> isNegative = i -> i < 0;
        if (numbers.stream().anyMatch(isNegative)) {
            String exceptionMessage = numbers.stream()
                    .filter(isNegative).map(String::valueOf)
                    .collect(Collectors.joining(","));
            throw new NegativesNotSupportedException(exceptionMessage);
        }

        return numbers.stream()
                .filter(i -> i <= 1000)
                .reduce(0, (i1, i2) -> i1 + i2);
    }

    private List<String> getDelimiters(String numbers) {
        List<String> delimiters = new ArrayList<>();
        delimiters.addAll(Arrays.asList(",", "\n"));
        if (numbers.startsWith("//")) {
            String delims = numbers.substring(2, numbers.indexOf("\n"));
            if (delims.contains("[") && delims.contains("]")) {
                Pattern multiCharDelimiter = Pattern.compile("\\[([^\\]]+)\\]");
                Matcher matcher = multiCharDelimiter.matcher(delims);
                while (matcher.find()) {
                    delimiters.add(matcher.group(1));
                }
            } else {
                delimiters.add(delims);
            }
        }
        return delimiters;
    }

    private List<Integer> parseNumbers(String numberString, List<String> delimiters) {
        String splitRegex = delimiters.stream()
                .map(this::escapeMetaCharacters)
                .collect(Collectors.joining("|"));
        numberString = delimiters.size() > 2 ?
                numberString.substring(numberString.indexOf("\n") + 1) :
                numberString;
        return Stream.of(numberString
                .split(splitRegex))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String escapeMetaCharacters(String delimiter) {
        List<String> metacharacter = Arrays.asList("[", "]", "|", "*", "+", ".");
        return delimiter.chars().mapToObj(i -> String.valueOf((char) i))
                .map(c -> metacharacter.contains(c) ? "\\" + c : c)
                .collect(Collectors.joining(""));
    }

}
