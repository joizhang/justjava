package com.joizhang.imooc.algorithms;

/**
 * 三路快速排序
 *
 * @author joizhang
 */
public class Quick3Ways {

    private Quick3Ways() {
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        quickSort(a, 0, n - 1);
    }

    private static void quickSort(Comparable[] a, int l, int r) {
        if (r - l <= 15) {
            Sorts.insertionSort(a, l, r);
            return;
        }

        // partition
        Sorts.exchange(a, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = a[l];
        // a[l+1...lt] < v
        int lt = l;
        // a[gt...r] > v
        int gt = r + 1;
        // a[lt+1...i] == v
        int i = l + 1;
        while (i < gt) {
            if (Sorts.less(a[i], v)) {
                Sorts.exchange(a, i, lt + 1);
                lt++;
                i++;
            } else if (Sorts.less(v, a[i])) {
                Sorts.exchange(a, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }

        Sorts.exchange(a, l, lt);

        quickSort(a, l, lt - 1);
        quickSort(a, gt, r);
    }

}
