package com.joizhang.datastructure;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            list.add(i);
        }
    }
}
