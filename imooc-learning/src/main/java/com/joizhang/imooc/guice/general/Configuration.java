package com.joizhang.imooc.guice.general;

/**
 * @author imooc
 */
public class Configuration {

    public static StringWritingApplet getMainApplet() {
        return new StringWritingApplet(
                new PrintStreamWriter(System.out),
                () -> "Hello world!");
    }

}
