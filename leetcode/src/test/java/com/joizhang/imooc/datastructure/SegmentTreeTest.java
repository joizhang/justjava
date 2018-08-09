package com.joizhang.imooc.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class SegmentTreeTest {

    @Test
    public void segmentTree() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segmentTree);
    }

}