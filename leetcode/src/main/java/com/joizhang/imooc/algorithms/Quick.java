package com.joizhang.imooc.algorithms;

/**
 * 快速排序
 *
 * @author joizhang
 */
public class Quick {

    public static void sort(Comparable[] a) {
        int n = a.length;
        quickSort(a, 0, n - 1);
    }

    private static void quickSort(Comparable[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(a, l, r);
        quickSort(a, l, p - 1);
        quickSort(a, p+1, r);
    }

    /**
     * 对a[l...r]部分进行partition操作
     * 返回
     */
    private static int partition(Comparable[] a, int l, int r) {
        return 0;
    }

}
