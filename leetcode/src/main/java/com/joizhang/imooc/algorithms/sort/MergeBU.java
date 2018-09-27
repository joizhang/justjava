package com.joizhang.imooc.algorithms.sort;

/**
 * 自底向上归并排序
 *
 * @author joizhang
 */
public class MergeBU {

    private MergeBU() {
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz * 2) {
                // 对 a[i...i+sz-1] 和 a[i+sz...i+2*sz-1] 进行归并
                Merge.merge(a, i, i + sz - 1, Math.min(n - 1, i + sz * 2 - 1));
            }
        }
    }

}
