package com.joizhang.imooc.sort;

<<<<<<< HEAD
import com.joizhang.imooc.algorithms.sort.Selection;
=======
import com.joizhang.imooc.chapter2.Selection;
>>>>>>> e42665aa20675b7a965c0b5912a60c4aa9a3c4bf
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