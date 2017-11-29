package com.joizhang.imooc.guice.scope;

import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.joizhang.imooc.guice.server.PaymentService;
import com.joizhang.imooc.guice.server.PriceService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author imooc
 */
public class ScopeModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeLiteral<Cache<String, String>>() {})
                .to(GuiceDemoCache.class);
        // 也可以in(singleton.class) 和 provides
        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);
        bind(new TypeLiteral<Set<String>>() {})
                .toInstance(new HashSet<>(Arrays.asList("CNY", "USD", "EUR")));
    }

}
