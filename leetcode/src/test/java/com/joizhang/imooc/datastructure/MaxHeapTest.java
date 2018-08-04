package com.joizhang.imooc.datastructure;

import org.junit.Test;

import java.util.Random;

public class MaxHeapTest {

    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else{
            maxHeap = new MaxHeap<>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }

        int n = testData.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i-1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("Test MaxHeap completed");

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void add() {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + "s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + "s");
    }

}