package com.joizhang.imooc.algorithms.sort;

public class SortCompare {

    private static double time(String algo, Comparable[] a) {
        Stopwatch stopwatch = new Stopwatch();
        if ("Selection".equals(algo)) {
            Selection.sort(a);
        }
        if ("Insertion".equals(algo)) {
            Insertion.sort(a);
        }
        if ("Shell".equals(algo)) {
            Shell.sort(a);
        }
        if ("Merge".equals(algo)) {
            Merge.sort(a);
        }
        if ("Quick".equals(algo)) {
            Quick.sort(a);
        }
        return stopwatch.elapsedTime();
    }

    static void compareWithRandomArray(int n, String... algos) {
        for (String algo: algos) {
            Integer[] a = Sorts.generateRandomArray(n, 0, Integer.MAX_VALUE - 1);
            double t = time(algo, a);
            assert Sorts.isSorted(a);
            System.out.println(algo + ": " + t);
        }
    }

    static void compareWithNearlyOrderedArray(int n, String... algos) {
        for (String algo: algos) {
            Integer[] a = Sorts.generateNearlyOrderedArray(n, 100);
            double t = time(algo, a);
            assert Sorts.isSorted(a);
            System.out.println(algo + ": " + t);
        }
    }

}
