package com.joizhang.leetcode.hashtable;

import java.util.HashMap;

/**
 * 205. Isomorphic Strings
 *
 * @author joizhang
 */
class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer previousValue1 = map1.put(s.charAt(i), i);
            Integer previousValue2 = map2.put(t.charAt(i), i);
            if (previousValue1 == null && previousValue2 != null) {
                return false;
            }
            if (previousValue1 != null && !previousValue1.equals(previousValue2)) {
                return false;
            }
        }
        return true;
    }

}
