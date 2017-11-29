package com.joizhang.imooc.guice.web.persistence;

import org.springframework.stereotype.Component;

/**
 * @author imooc
 */
@Component
public class SampleDao {

    public void save(String data) {
        System.out.println(data + " saved.");
    }

    public String getPersonData(String data) {
        System.out.println("Getting person data for: " + data);
        return data;
    }

}
