package com.joizhang.leetcode.hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidAnagramTest {

    @Test
    public void isAnagram() {
        assertTrue(new ValidAnagram().isAnagram("anagram","nagaram"));
        assertFalse(new ValidAnagram().isAnagram("rat","car"));
    }
}