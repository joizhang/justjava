package com.joizhang.imooc.algorithms.sort;

public class Selection {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间中的最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (Sorts.less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            Sorts.exchange(a, i, minIndex);
        }
    }

}
