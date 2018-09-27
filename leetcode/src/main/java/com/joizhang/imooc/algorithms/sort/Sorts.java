package com.joizhang.imooc.algorithms.sort;

import java.util.Random;

/**
 * @author joizhang
 */
class Sorts {

    private static final Random RANDOM = new Random(47);

    /**
     * 排序类型
     */
    enum SortType {
        /**
         * 选择排序
         */
        SELECTION,
        /**
         * 插入排序
         */
        INSERTION,
        /**
         * 希尔排序
         */
        SHELL,
        /**
         * 归并排序
         */
        MERGE,
        /**
         * 快速排序
         */
        QUICK,
    }

    /**
     * v less than w
     */
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
        for (int i = 0; i < n; i++) {
            arr[i] = RANDOM.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            Sorts.exchange(arr, i, RANDOM.nextInt(swapTimes));
        }
        return arr;
    }

    static void insertionSort(Comparable[] a, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            Comparable e = a[i];
            int j;
            for (j = i; j > l && Sorts.less(e, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = e;
        }
    }

}
