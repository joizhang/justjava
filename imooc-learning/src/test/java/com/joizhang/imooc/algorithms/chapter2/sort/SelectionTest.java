package com.joizhang.imooc.algorithms.chapter2.sort;

import org.junit.Test;

public class SelectionTest {

    @Test
    public void selectionSort() {
        int[] a = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Selection.selectionSort(a, 10);
        for( int i = 0 ; i < 10 ; i ++ ) {
            System.out.print(a[i] + " ");
        }
    }
}