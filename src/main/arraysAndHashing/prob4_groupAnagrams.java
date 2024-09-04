package main.arraysAndHashing;

import java.util.*;

public class prob4_groupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};
        groupAnagrams(strs).forEach(System.out::println);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        Map<String, List<String>> map = new HashMap<>(); // key, stringList
        for (String str : strs) {
            int[] charCount = new int[26];
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }
            String key = Arrays.toString(charCount);
            //System.out.println(STR."key: \{key}");
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
