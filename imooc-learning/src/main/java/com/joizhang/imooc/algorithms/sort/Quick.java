package com.joizhang.imooc.algorithms.sort;

public class Quick {

    public static void sort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /**
     * 对arr[l...r]部分进行快速排序
     */
    private static void quickSort(Comparable[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(a, l, r);
        quickSort(a, l, p - 1);
        quickSort(a, p + 1, r);
    }

    /**
     * 对arr[l...r]部分进行快速排序
     * 返回p，使得arr[l...p-1] < arr[p]；arr[p+1...r] > arr[p]
     */
    private static int partition(Comparable[] a, int l, int r) {
        Comparable v = a[l];
        // arr[l+1...j] < v；arr[j+1...i) > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (Sorts.less(a[i], v)) {
                Sorts.exchange(a, j + 1, i);
                j++;
            }
        }
        Sorts.exchange(a, l, j);
        return j;
    }

}
