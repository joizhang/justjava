package com.joizhang.json;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GsonTest {

    private static final String writeJson = System.getProperty("user.dir") + File.separator + "write.json";

    @Test
    public void testGsonRead() {
        User user = new User();
        Gson gson = new Gson();

        try {
            BufferedReader reader = new BufferedReader((new FileReader(writeJson)));
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
            FileWriter writer = new FileWriter(writeJson);
            writer.write(gson.toJson(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
