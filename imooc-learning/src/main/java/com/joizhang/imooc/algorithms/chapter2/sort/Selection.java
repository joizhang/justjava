package com.joizhang.imooc.algorithms.chapter2.sort;

public class Selection {

    public static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间里的最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            Sorts.swap(arr, i, minIndex);
        }
    }

}
