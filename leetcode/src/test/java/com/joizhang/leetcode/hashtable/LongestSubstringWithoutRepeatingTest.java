package com.joizhang.leetcode.hashtable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingTest {

    @Test
    public void lengthOfLongestSubstring() {
        LongestSubstringWithoutRepeating withoutRepeating = new LongestSubstringWithoutRepeating();
        assertEquals(3, withoutRepeating.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, withoutRepeating.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, withoutRepeating.lengthOfLongestSubstring("pwwkew"));
        assertEquals(2, withoutRepeating.lengthOfLongestSubstring("abba"));
    }

    @Test
    public void lengthOfLongestSubstring2() {
        LongestSubstringWithoutRepeating withoutRepeating = new LongestSubstringWithoutRepeating();
        assertEquals(3, withoutRepeating.lengthOfLongestSubstring2("abcabcbb"));
        assertEquals(1, withoutRepeating.lengthOfLongestSubstring2("bbbbb"));
        assertEquals(3, withoutRepeating.lengthOfLongestSubstring2("pwwkew"));
        assertEquals(2, withoutRepeating.lengthOfLongestSubstring2("abba"));
    }
}