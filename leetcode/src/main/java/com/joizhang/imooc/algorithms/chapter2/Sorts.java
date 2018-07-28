package com.joizhang.imooc.algorithms.chapter2;

import java.util.Random;

class Sorts {

    @SuppressWarnings("unchecked")
    static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void show(Comparable[] a) {
        for (Comparable anA : a) {
            System.out.print(anA + " ");
        }
        System.out.println();
    }

    static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        Integer[] arr = new Integer[n];
        Random random = new Random(47);
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Random random = new Random(47);
        for (int i = 0; i < swapTimes; i++) {
            Sorts.exchange(arr, i, random.nextInt(swapTimes));
        }
        return arr;
    }

}
