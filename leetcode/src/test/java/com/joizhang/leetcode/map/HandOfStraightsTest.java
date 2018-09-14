package com.joizhang.leetcode.map;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HandOfStraightsTest {

    @Test
    public void isNStraightHand() {
        HandOfStraights handOfStraights = new HandOfStraights();
        assertTrue(handOfStraights.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        assertFalse(handOfStraights.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }
}