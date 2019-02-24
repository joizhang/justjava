package com.joizhang.leetcode.hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordPatternTest {

    @Test
    public void wordPattern() {
        assertTrue(new WordPattern().wordPattern("abba", "dog cat cat dog"));
        assertFalse(new WordPattern().wordPattern("abba", "dog cat cat fish"));
        assertFalse(new WordPattern().wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(new WordPattern().wordPattern("abba", "dog dog dog dog"));
        assertTrue(new WordPattern().wordPattern("abc", "b c a"));
    }
}