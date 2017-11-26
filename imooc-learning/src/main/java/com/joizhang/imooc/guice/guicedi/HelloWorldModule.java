package com.joizhang.imooc.guice.guicedi;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.io.PrintStream;

public class HelloWorldModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(PrintStreamWriter.class);
        bind(PrintStream.class).toInstance(System.out);
    }

    @Provides
    private String getString() {
        return "Hello world!";
    }
}
