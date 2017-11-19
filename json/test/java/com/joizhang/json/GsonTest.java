package com.joizhang.json;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GsonTest {

    @Test
    public void testGsonRead() {
        User user = new User();
        Gson gson = new Gson();

        try {
            BufferedReader reader = new BufferedReader((new FileReader("D:\\workspace\\json\\read.json")));
            user = gson.fromJson(reader, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(user);
    }

    @Test
    public void testGsonWrite() {
        User user = new User();
        Gson gson = new Gson();
        user.setAge(24);
        user.setName("joizhang");

        List<String> messages = new ArrayList<String>();
        messages.add("Hey, maybe I will give you a call..");
        messages.add("Excuse me, I'd like to ask you a few..");
        messages.add("Brain freeze. Alrighty Then I just heard..");
        user.setMessages(messages);

        try {
            FileWriter writer = new FileWriter("D:\\workspace\\json\\write.json");
            writer.write(gson.toJson(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
