package com.joizhang.imooc.guice.guicedi;

import com.google.inject.AbstractModule;

/**
 * @author imooc
 */
public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new HelloWorldModule());
        install(new PrintLineModule());
    }

}
