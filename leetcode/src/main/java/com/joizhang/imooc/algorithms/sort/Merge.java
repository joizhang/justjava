package com.joizhang.imooc.algorithms.sort;

/**
 * 归并排序
 *
 * @author joizhang
 */
public class Merge {

    private Merge() {
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        mergeSort(a, 0, n - 1);
    }

    /**
     * 递归使用归并排序，对 a[l...r]的范围进行排序
     */
    private static void mergeSort(Comparable[] a, int l, int r) {
        // 优化：在小到一定程度时使用插入排序
        if (r - l <= 15) {
            Sorts.insertionSort(a, l, r);
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        // 优化：对于近乎有序的数组
        if (Sorts.less(a[mid + 1], a[mid])) {
            merge(a, l, mid, r);
        }
    }

    /**
     * 将 a[l...mid] 和 a[mid+1...r] 两部分进行归并
     */
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
                i++;
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
