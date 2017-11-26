package com.joizhang.imooc.guice.general;

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
        // 1
        MyApplet mainApplet = Configuration.getMainApplet();
        mainApplet.run();
    }

}
