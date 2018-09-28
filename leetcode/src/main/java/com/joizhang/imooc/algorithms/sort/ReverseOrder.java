package com.joizhang.imooc.algorithms.sort;

/**
 * 归并排序求逆序对
 *
 * @author joizhang
 */
public class ReverseOrder {

    private int count;

    public ReverseOrder(Comparable[] a) {
        reverseOrder(a);
    }

    private void reverseOrder(Comparable[] a) {
        int n = a.length;
        mergeSort(a, 0, n - 1);
    }

    private void mergeSort(Comparable[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    private void merge(Comparable[] a, int l, int mid, int r) {
        Comparable[] aux = new Comparable[r - l + 1];
        for (int i = 0; i < r - l + 1; i++) {
            aux[i] = a[i + l];
        }

        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                a[k] = aux[j - l];
                j++;
            } else if (j > r) {
                a[k] = aux[i - l];
                i++;
            } else if (Sorts.less(aux[j - l], aux[i - l])) {
                a[k] = aux[j - l];
                j++;
                count += (mid - l) - (i - l) + 1;
            } else {
                a[k] = aux[i - l];
                i++;
            }
        }
    }

    public int getCount() {
        return this.count;
    }

}
