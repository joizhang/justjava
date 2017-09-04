package com.joizhang.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonTest {

    @Test
    public void testJacksonRead() {
        User user = new User();

        ObjectMapper mapper = new ObjectMapper();

        try {
            user = mapper.readValue(new File("D:\\workspace\\json\\read.json"), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(user);
    }

    @Test
    public void testJacksonWrite() {
        User user = new User();
        user.setAge(24);
        user.setName("joizhang");

        List<String> messages = new ArrayList<String>();
        messages.add("Hey, maybe I will give you a call..");
        messages.add("Excuse me, I'd like to ask you a few..");
        messages.add("Brain freeze. Alrighty Then I just heard..");
        user.setMessages(messages);

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("D:\\workspace\\json\\write.json"), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
