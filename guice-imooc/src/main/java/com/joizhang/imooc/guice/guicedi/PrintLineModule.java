package com.joizhang.imooc.guice.guicedi;

import com.google.inject.AbstractModule;

/**
 * @author imooc
 */
public class PrintLineModule extends AbstractModule {

    @Override
    protected void configure() {
        Applets.register(binder()).named("println")
                .to(PrintLineApplet.class);
    }

}
