package com.joizhang.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * @author joizhang
 */
class LongestSubstringWithoutRepeating {

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

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int i = 0;
        for (; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
