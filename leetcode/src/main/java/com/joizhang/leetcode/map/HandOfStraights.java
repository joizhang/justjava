package com.joizhang.leetcode.map;

import java.util.TreeMap;

/**
 * 846. Hand of Straights
 *
 * @author joizhang
 */
class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> handMap = new TreeMap<>();
        for (int card : hand) {
            if (handMap.containsKey(card)) {
                handMap.put(card, handMap.get(card) + 1);
            } else {
                handMap.put(card, 1);
            }
        }
        while (!handMap.isEmpty()) {
            int minKeyInMap = handMap.firstKey();
            for (int i = 0; i < W; i++) {
                int nextKey = minKeyInMap + i;
                if (!handMap.containsKey(nextKey)) {
                    return false;
                }
                handMap.put(nextKey, handMap.get(nextKey) - 1);
                if (handMap.get(nextKey) == 0) {
                    handMap.remove(nextKey);
                }
            }
        }
        return true;
    }

}
