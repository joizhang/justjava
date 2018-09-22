package com.joizhang.imooc.algorithms.sort;

public class MergeBU {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                Merge.merge(a, i, i + sz - 1, Math.min(i + 2 * sz - 1, n - 1));
            }
        }
    }

}
