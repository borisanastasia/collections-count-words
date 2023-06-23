package com.epam.rd.autotasks;


import java.util.*;

public class Words {

    public String countWords(List<String> lines) {
        Map<String, Integer> map = new HashMap<>();

        for (String line : lines) {
            String[] words = line.split("[^\\pL\\pN]+");
            for (String word : words) {
                if (word.length() < 4) {
                    continue;
                }

                String wordLower = word.toLowerCase();

                if (map.containsKey(wordLower)) {
                    Integer value = map.get(wordLower);
                    map.put(wordLower, value + 1);

                } else {
                    map.put(wordLower, 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(new WordsComparator());

        String statistics = "";
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() < 10) {
                continue;
            }
            statistics = statistics + entry.getKey() + " - " + entry.getValue() + "\n";
        }

        if (statistics.length() > 0) {
            return statistics.substring(0, statistics.length() - 1);
        } else {
            return statistics;
        }
    }

}
