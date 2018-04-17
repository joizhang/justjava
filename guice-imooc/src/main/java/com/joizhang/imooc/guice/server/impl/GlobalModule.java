package com.joizhang.imooc.guice.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class GlobalModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<String> currencyMultibinder = Multibinder.newSetBinder(binder(), String.class);
        currencyMultibinder.addBinding().toInstance("USD");
        currencyMultibinder.addBinding().toInstance("EUR");
    }
}
