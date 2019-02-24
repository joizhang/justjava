package com.joizhang.leetcode.hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortCharactersByFrequencyTest {

    @Test
    public void frequencySort() {
        assertEquals("eert", new SortCharactersByFrequency().frequencySort("tree"));
        assertEquals("aaaccc", new SortCharactersByFrequency().frequencySort("cccaaa"));
        assertEquals("bbAa", new SortCharactersByFrequency().frequencySort("Aabb"));
    }
}