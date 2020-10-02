package com.ingleash.misc.utils;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import  java.util.*;

public class StringUtils {

    public static void main(String[] args) {
        //out.println("tst class ex");

        System.out.println(Stream.of("one", "two", "three", "four")
                        .filter(e -> e.length() > 3)
                         .peek(e -> System.out.println("Filtered value: " + e))
                         .map(String::toUpperCase)
                         .peek(e -> System.out.println("Mapped value: " + e))
                         .collect(Collectors.toList()));
    }


    public static char mostRepetativeChar(String word) {
        Map<Character, Integer> charIntMap = new LinkedHashMap<>();
        for (char c : word.toCharArray()) {
            if(charIntMap.containsKey(c)) {
                charIntMap.put(c, charIntMap.get(c) + 1);
            } else {
                charIntMap.put(c, 1);
            }

        }
        System.out.println("Map looks like - " + charIntMap);

        int maxCount = 0;
        char maxOccurence = ' ';

        for ( Map.Entry<Character, Integer> es : charIntMap.entrySet()) {
            if (es.getValue() > maxCount) {
                maxCount = es.getValue();
                maxOccurence = es.getKey();
            } else if (es.getValue() == maxCount) {
                continue;
            }
        }


        return maxOccurence;
    }
}
