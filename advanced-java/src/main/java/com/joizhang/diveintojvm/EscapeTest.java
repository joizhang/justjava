package com.joizhang.diveintojvm;

import java.util.ArrayList;
import java.util.function.Consumer;

public class EscapeTest {

    public static void forEach(ArrayList<Object> list, Consumer<Object> f) {
        for (Object obj : list) {
            f.accept(obj);
        }
    }

    // Run with
    // java -XX:+PrintGC -XX:+DoEscapeAnalysis demo.EscapeTest
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < 400_000_000; i++) {
            forEach(list, obj -> { });
        }
    }
}
