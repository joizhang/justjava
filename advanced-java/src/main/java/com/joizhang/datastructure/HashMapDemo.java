package com.joizhang.datastructure;

import java.util.HashMap;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            String s = String.valueOf(a++);
            map.put(s, s);
        }
        System.out.println(map);
    }

}
