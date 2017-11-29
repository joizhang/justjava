package com.joizhang.imooc.guice.web.greeting;

import com.google.inject.servlet.RequestScoped;

/**
 * @author imooc
 */
@RequestScoped
public class RequestParams {

    private String greetingName;

    public RequestParams() {
        System.out.println("RequestParams Constructed");
    }

    public String getGreetingName() {
        return greetingName;
    }

    public void setGreetingName(String greetingName) {
        this.greetingName = greetingName;
    }
}
