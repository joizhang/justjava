package com.joizhang.leetcode.segmenttree;

import com.joizhang.imooc.datastructure.SegmentTree;

/**
 * 303. Range Sum Query - Immutable
 */
class NumArray4 {

    private SegmentTree<Integer> segmentTree;

    public NumArray4(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int i, int val) {
        segmentTree.set(i, val);
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment tree is null.");
        }
        return segmentTree.query(i, j);
    }
}

