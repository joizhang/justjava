package com.joizhang.imooc.algorithms;

/**
 * @author joizhang
 */
public class SortCompare {

    private static double time(Sorts.SortType sortType, Comparable[] a) {
        Stopwatch stopwatch = new Stopwatch();
        if (Sorts.SortType.SELECTION.equals(sortType)) {
            Selection.sort(a);
        } else if (Sorts.SortType.INSERTION.equals(sortType)) {
            Insertion.sort(a);
        } else if (Sorts.SortType.SHELL.equals(sortType)) {
            Shell.sort(a);
        } else if (Sorts.SortType.MERGE.equals(sortType)) {
            Merge.sort(a);
        }
        return stopwatch.elapsedTime();
    }

    static void compareWithRandomArray(int n, Sorts.SortType... algos) {
        for (Sorts.SortType algo : algos) {
            Integer[] a = Sorts.generateRandomArray(n, 0, Integer.MAX_VALUE - 1);
            double t = time(algo, a);
            assert Sorts.isSorted(a);
            System.out.println(algo + ": " + t);
        }
    }

    static void compareWithNearlyOrderedArray(int n, Sorts.SortType... algos) {
        for (Sorts.SortType algo : algos) {
            Integer[] a = Sorts.generateNearlyOrderedArray(n, 100);
            double t = time(algo, a);
            assert Sorts.isSorted(a);
            System.out.println(algo + ": " + t);
        }
    }

}
