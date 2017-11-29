package com.joizhang.imooc.guice.web.greeting;

import com.google.inject.AbstractModule;
import com.joizhang.imooc.guice.guicedi.MyApplet;
import com.joizhang.imooc.guice.guicedi.MyDestination;
import com.joizhang.imooc.guice.guicedi.Output;
import com.joizhang.imooc.guice.guicedi.StringWritingApplet;

/**
 * @author imooc
 */
public class HelloWorldModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(WebDestination.class);
        bind(String.class).annotatedWith(Output.class).toProvider(GreetingMessageProvider.class);
    }

}
