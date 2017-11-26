package com.joizhang.imooc.guice.guicedi;

import com.google.inject.AbstractModule;

/**
 * @author joizhang
 */
public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new HelloWorldModule());
    }

}
