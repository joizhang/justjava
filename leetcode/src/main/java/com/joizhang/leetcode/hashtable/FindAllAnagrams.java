package com.joizhang.leetcode.hashtable;

import java.util.*;

/**
 * 438. Find All Anagrams in a String
 *
 * @author joizhang
 */
class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1) {
                count--;
            }

            if (count == 0) {
                ans.add(left);
            }

            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                count++;
            }
        }
        return ans;
    }

}
