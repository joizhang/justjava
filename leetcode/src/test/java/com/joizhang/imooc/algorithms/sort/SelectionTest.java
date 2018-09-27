package com.joizhang.imooc.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SelectionTest {

    @Test
    public void sortCharacters() {
        Character[] characters = "SORTEXAMPLE".chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);
        Selection.sort(characters);
        Sorts.show(characters);
        System.out.println(Sorts.isSorted(characters));

    }

    @Test
    public void sortStudents() {
        Student[] students = new Student[]{
                new Student("a", 100),
                new Student("b", 90),
                new Student("c", 80),
                new Student("d", 70),
                new Student("e", 60),
                new Student("f", 50)
        };
        Selection.sort(students);
        Sorts.show(students);
    }

    @Test
    public void sortGenerateRandomArray() {
        Integer[] integers = Sorts.generateRandomArray(10, 0, 100);
        Selection.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }
}