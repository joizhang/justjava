package com.joizhang.datastructure;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            String s = String.valueOf(a++);
            map.put(s, s);
        }
        System.out.println(map);
    }
}
