package com.joizhang.imooc.guice.guicedi;

import com.google.inject.Guice;

/**
 * @author joizhang
 */
public class App {

    /**
     * bootstrap:
     * parse command line
     * set up environment
     * kick off main logic
     * @param args
     */
    public static void main(String[] args) {
        MyApplet mainApplet = Guice.createInjector(new MainModule())
                .getInstance(MyApplet.class);
        mainApplet.run();
    }

}
