package com.joizhang.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class LetterCombinationsTest {

    @Test
    public void letterCombinations() {
        assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
                new LetterCombinations().letterCombinations("23"));
        assertEquals(new ArrayList<>(),
                new LetterCombinations().letterCombinations(""));
    }
}