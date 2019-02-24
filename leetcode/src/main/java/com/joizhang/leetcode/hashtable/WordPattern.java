package com.joizhang.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 *
 * @author joizhang
 */
class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(c, words[i]);
            }
        }
        return true;
    }

}
