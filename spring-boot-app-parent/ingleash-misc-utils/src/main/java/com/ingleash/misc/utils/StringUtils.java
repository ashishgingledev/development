package com.ingleash.misc.utils;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringUtils {

    public static void main(String[] args) {
         System.out.println(" for 11221122221111112222112211222222 :=> " + StringUtils.mostRepetativeChar("11221122221111112222112211222222"));
        //System.out.println(" for bbbbbkkqqiiaallppppppppaajjaaazzzzzzzz :=> " + StringUtils.mostRepetativeChar("bbbbbkkqqiiaallppppppppaajjaaazzzzzzzz"));
        //System.out.println(" for ashish :=> " + StringUtils.mostRepetativeChar("ashish"));

        //System.out.println(" for letter :=> " + new String(StringUtils.mostRepetativeCharByJava8("letter")));
        //System.out.println(" for bbbbbkkqqiiaallppppppppaajjaaazzzzzzzz :=> " + StringUtils.mostRepetativeCharByJava8("bbbbbkkqqiiaallppppppppaajjaaazzzzzzzz"));
        //System.out.println(" for ashish :=> " + StringUtils.mostRepetativeCharByJava8("ashish"));
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
