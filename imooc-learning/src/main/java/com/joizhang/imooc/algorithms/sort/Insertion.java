package com.joizhang.imooc.algorithms.sort;

public class Insertion {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // 寻找元素a[i]合适的插入位置
            Comparable e = a[i];
            int j;
            for (j = i; j > 0 && Sorts.less(e, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = e;
        }
    }

}
