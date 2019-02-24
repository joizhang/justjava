package com.joizhang.leetcode.hashtable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FindAllAnagramsTest {

    @Test
    public void findAnagrams() {
        assertEquals(Arrays.asList(0, 6), new FindAllAnagrams().findAnagrams("cbaebabacd", "abc"));
        assertEquals(Arrays.asList(0, 1, 2), new FindAllAnagrams().findAnagrams("abab", "ab"));
    }
}