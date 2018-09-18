package com.joizhang.imooc.sort;

import com.joizhang.imooc.algorithms.sort.Selection;
import org.junit.Test;

public class SelectionTest {

    @Test
    public void selectionSort() {
        Integer[] a = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Selection.sort(a);
        for (int i = 0; i < 10; i++) {
            System.out.print(a[i] + " ");
        }
    }
}