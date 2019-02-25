package com.joizhang.leetcode.hashtable;

import java.util.*;

/**
 * 49. Group Anagrams
 *
 * @author joizhang
 */
class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                List<String> group = new ArrayList<>();
                group.add(str);
                map.put(key, group);
            } else {
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

}
