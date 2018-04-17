package com.joizhang.imooc.guice.guicedi;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.io.PrintStream;
import java.util.List;

/**
 * @author imooc
 */
public class HelloWorldModule extends AbstractModule {

    @Override
    protected void configure() {
        Applets.register(binder()).named("hello")
                .to(StringWritingApplet.class);

        bind(MyDestination.class).to(PrintStreamWriter.class);
        bind(PrintStream.class).toInstance(System.out);
    }

    @Provides
    private @Output
    String getString(@Args List<String> args) {
        return args.get(0);
    }
}
