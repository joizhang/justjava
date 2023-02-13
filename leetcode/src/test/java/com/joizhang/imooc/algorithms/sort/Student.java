package com.joizhang.imooc.algorithms.sort;

/**
 * @author joizhang
 */
public class Student implements Comparable<Student> {

    private String name;

    private int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(score, ((Student) o).score);
    }
}
