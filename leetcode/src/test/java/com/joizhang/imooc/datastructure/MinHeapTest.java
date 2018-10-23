package com.joizhang.imooc.datastructure;

import com.joizhang.imooc.algorithms.sort.Sorts;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class MinHeapTest {

    @Test
    public void extractMin() {
        int n = 1000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        MinHeap<Integer> heap = new MinHeap<>(testData);
        List<Integer> list = new ArrayList<>(n);
        while (!heap.isEmpty()) {
            list.add(heap.extractElement());
        }
        testData = new Integer[n];
        list.toArray(testData);
        assertTrue(Sorts.isSorted(testData));
    }

}