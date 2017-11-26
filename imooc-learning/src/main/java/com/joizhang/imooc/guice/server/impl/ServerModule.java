package com.joizhang.imooc.guice.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.joizhang.imooc.guice.server.OrderService;
import com.joizhang.imooc.guice.server.PaymentService;
import com.joizhang.imooc.guice.server.PriceService;

/**
 * @author imooc
 */
public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);
    }

    @Provides
    Long generateSessionId() {
        return System.currentTimeMillis();
    }

}
