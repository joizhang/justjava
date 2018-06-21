package com.joizhang.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> lastOccurred = new HashMap<>();
        int start = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (lastOccurred.containsKey(chars[i])
                    && lastOccurred.get(chars[i]) >= start) {
                start = lastOccurred.get(chars[i]) + 1;
            }
            if (i - start + 1 > maxLength) {
                maxLength = i - start + 1;
            }
            lastOccurred.put(chars[i], i);
        }
        return maxLength;
    }

}
