package com.epam.rd.autotasks;

import java.util.Comparator;
import java.util.Map;

public class WordsComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
        if (entry1.getValue() > entry2.getValue()) {
            return -1;
        }

        if (entry1.getValue() < entry2.getValue()) {
            return 1;
        }

        return entry1.getKey().compareTo(entry2.getKey());
    }
}
