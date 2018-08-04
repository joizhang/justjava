package com.joizhang.leetcode.set;

import java.util.*;

/**
 * 349. Intersection of Two Arrays
 */
class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
