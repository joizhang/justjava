package com.joizhang.imooc.algorithms.chapter2;

public class Selection {

    private static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间中的最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (Sorts.less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            Sorts.exch(a, i, minIndex);
        }
    }

    public static void main(String[] args) {
        Character[] characters = "SORTEXAMPLE".chars()
                .mapToObj(c -> (char)c)
                .toArray(Character[]::new);
        sort(characters);
        Sorts.show(characters);
        System.out.println(Sorts.isSorted(characters));

        Student[] students = new Student[]{
                new Student("a", 100),
                new Student("b", 90),
                new Student("c", 80),
                new Student("d", 70),
                new Student("e", 60),
                new Student("f", 50)
        };
        sort(students);
        Sorts.show(students);
    }

}
