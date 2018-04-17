package com.joizhang.imooc.guice.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ChinaModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder.newSetBinder(binder(), String.class)
                .addBinding().toInstance("CNY");
    }
}
