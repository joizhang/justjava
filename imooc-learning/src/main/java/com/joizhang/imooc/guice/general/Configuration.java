package com.joizhang.imooc.guice.general;

/**
 * @author joizhang
 */
public class Configuration {

    public static StringWritingApplet getMainApplet() {
        return new StringWritingApplet(
                new PrintStreamWriter(System.out),
                () -> "Hello world!");
    }

}
