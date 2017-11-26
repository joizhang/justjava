package com.joizhang.imooc.guice.guicedi;

import com.google.inject.AbstractModule;

import java.io.PrintStream;

/**
 * @author imooc
 */
public class HelloWorldModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(PrintStreamWriter.class);
        bind(PrintStream.class).toInstance(System.out);
        bind(String.class).annotatedWith(Output.class).toInstance("Hello world!");
    }

//    @Provides
//    private String getString() {
//        return "Hello world!";
//    }
}
