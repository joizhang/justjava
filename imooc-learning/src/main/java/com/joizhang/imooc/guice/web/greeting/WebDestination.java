package com.joizhang.imooc.guice.web.greeting;

import com.google.inject.servlet.RequestScoped;
import com.joizhang.imooc.guice.guicedi.MyDestination;

/**
 * @author imooc
 */
@RequestScoped
public class WebDestination implements MyDestination {

    private final StringBuilder sb;

    public WebDestination() {
        System.out.println("WebDestination Constructed");
        sb = new StringBuilder();
    }

    @Override
    public void write(String outputString) {
        sb.append(outputString);
    }


    public String getResult() {
        return sb.toString();
    }
}
