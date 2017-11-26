package com.joizhang.imooc.guice.general;

import java.io.PrintStream;

/**
 * @author joizhang
 */
public class PrintStreamWriter implements MyDestination {

    private PrintStream destination;

    public PrintStreamWriter(PrintStream destination) {
        this.destination = destination;
    }

    @Override
    public void write(String s) {
        destination.println(s);
    }

}
