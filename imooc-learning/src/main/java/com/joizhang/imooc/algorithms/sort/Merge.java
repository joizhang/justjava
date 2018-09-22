package com.joizhang.imooc.algorithms.sort;

public class Merge {

    public static void sort(Comparable[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    /**
     * 递归使用归并排序，对arr[l...r]的范围进行排序
     */
    private static void mergeSort(Comparable[] a, int l, int r) {
//        if (l >= r) {
//            return;
//        }
        // 当需要排序的范围小于15的时候转为使用插入排序
        if (r - l <= 15) {
            insertionSort(a, l, r);
            return;
        }
        //0 1 2 3 4 5 6 7 8
        int mid = l + (r - l) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        // 对于近乎有序的数据可以加上这个判断
        if (Sorts.less(a[mid + 1], a[mid])) {
            merge(a, l, mid, r);
        }
    }

    private static void insertionSort(Comparable[] a, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            Comparable e = a[i];
            int j;
            for (j = i; j > l && Sorts.less(e, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = e;
        }
    }

    static void merge(Comparable[] a, int l, int mid, int r) {
        Comparable[] aux = new Comparable[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = a[i];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                a[k] = aux[j - l];
                j++;
            } else if (j > r) {
                a[k] = aux[i - l];
                j++;
            } else if (Sorts.less(aux[i - l], aux[j - l])) {
                a[k] = aux[i - l];
                i++;
            } else {
                a[k] = aux[j - l];
                j++;
            }
        }
    }


}
