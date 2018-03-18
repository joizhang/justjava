package com.joizhang.imooc.algorithms.chapter2.sort;

/**
 * @author joizhang
 */
public class Sorts {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
