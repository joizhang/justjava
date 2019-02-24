package com.joizhang.leetcode.hashtable;

/**
 * 242. Valid Anagram
 *
 * @author joizhang
 */
class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'a']--;
            if (hash[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
