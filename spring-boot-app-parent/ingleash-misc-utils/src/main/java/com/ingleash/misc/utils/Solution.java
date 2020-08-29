package com.ingleash.misc.utils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;


    public class Solution {

        public static void main(String[] args) {
            fSort(7,1,3,4,7,1,7,1,4,5,1,9,3);
            fSort(2,2,1,0,0);
        }
        public static void fSort(int... intArray) {

            //Complete the code
            Map<Integer, Integer> elementCountMap = new
                    LinkedHashMap<Integer, Integer>();

            for (int i=0; i<intArray.length; i++) {
                if(elementCountMap.containsKey(intArray[i])) {
                    elementCountMap.put(intArray[i],
                            elementCountMap.get(intArray[i])+1);
                }else {
                    elementCountMap.put(intArray[i], 1);
                }
            }

            elementCountMap = sortByValue(elementCountMap);


            System.out.println(elementCountMap);

            ArrayList<Integer> sortedElements = new ArrayList<Integer>();
            ArrayList<Integer> sortedElements1 = new ArrayList<Integer>();


            for ( Map.Entry<Integer, Integer> es : elementCountMap.entrySet()) {
                int i1 = es.getKey();
                int i2= es.getValue();
                for(int ii=0;ii<i2;ii++){
                    sortedElements.add(i1);
                }
            }



            System.out.println(sortedElements);
        }


        public static Map<Integer, Integer> sortByValue(final Map<Integer,
                Integer> wordCounts) {
            return wordCounts.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        }
}
