package com.joizhang.imooc.algorithms.sort;

/**
 * 快速排序求第 n 大的元素
 */
public class NthElement {

    private int nthIndex;

    NthElement(Comparable[] a) {

    }

    private void nthElement(Comparable[] a) {
        int n = a.length;
        quickSort(a, 0, n - 1);
    }

    private void quickSort(Comparable[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(a, l, r);
        quickSort(a, l, p - 1);
        quickSort(a, p + 1, r);
    }

    // TODO
    private int partition(Comparable[] a, int l, int r) {
        return 0;
    }

}
