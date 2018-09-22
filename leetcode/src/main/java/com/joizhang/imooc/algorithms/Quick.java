package com.joizhang.imooc.algorithms;

/**
 * <p>快速排序</p>
 * <p>近乎有序的数组快速排序退化为O(n^2)</p>
 * <p>重复元素很多的数组快速排序退化为O(n^2)</p>
 *
 * @author joizhang
 */
public class Quick {

    private Quick() {
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        quickSort(a, 0, n - 1);
    }

    private static void quickSort(Comparable[] a, int l, int r) {
        // 优化：在小到一定程度时使用插入排序
        if (r - l <= 15) {
            Sorts.insertionSort(a, l, r);
            return;
        }
        int p = partition2(a, l, r);
        quickSort(a, l, p - 1);
        quickSort(a, p + 1, r);
    }

    /**
     * <p>对 a[l...r] 部分进行 partition 操作
     * <p>返回 j 使得 a[l...j-1] < a[j]; a[j+1...r] > a[j]
     */
    @SuppressWarnings("unused")
    private static int partition(Comparable[] a, int l, int r) {
        // 随机在 a[l...r] 的范围中选择一个数值作为标定点 pivot
        Sorts.exchange(a, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = a[l];
        // a[l+1...j] < v; a[j+1...i] > v
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

    /**
     * <p>双路快速排序
     * <p>返回 j 使得 a[l...j-1] < a[j]; a[j+1...r] > a[j]
     */
    private static int partition2(Comparable[] a, int l, int r) {
        // 随机在 a[l...r] 的范围中选择一个数值作为标定点 pivot
        Sorts.exchange(a, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = a[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && Sorts.less(a[i], v)) {
                i++;
            }
            while (j >= l + 1 && Sorts.less(v, a[j])) {
                j--;
            }
            if (i > j) {
                break;
            }
            Sorts.exchange(a, i, j);
            i++;
            j--;
        }
        Sorts.exchange(a, l, j);
        return j;
    }

}
