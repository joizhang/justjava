package com.joizhang.json;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonLibTest {

    @Test
    public void testJsonLibRead() {
        User user = new User();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\workspace\\json\\read.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
