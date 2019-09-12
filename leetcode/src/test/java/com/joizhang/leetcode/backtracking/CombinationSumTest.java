package com.joizhang.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class CombinationSumTest {

    @Test
    public void combinationSum() {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(2, 2, 3));
        result.add(Collections.singletonList(7));
        assertEquals(combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7), result);
    }
}