package com.joizhang.datastructure;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            String s = String.valueOf(a++);
            map.put(i + 1, s);
        }
        System.out.println(map);
    }
}
