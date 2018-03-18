package com.joizhang.imooc.guice.aop;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.joizhang.imooc.guice.server.OrderService;
import com.joizhang.imooc.guice.server.PaymentService;
import com.joizhang.imooc.guice.server.PriceService;
import com.joizhang.imooc.guice.server.impl.SessionId;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author imooc
 */
public class AopModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);
        bind(new TypeLiteral<Set<String>>() {
        })
                .toInstance(new HashSet<>(Arrays.asList("CNY", "USD", "EUR")));

        LoggingInterceptor loggingInterceptor = new LoggingInterceptor();
        requestInjection(loggingInterceptor);
        bindInterceptor(Matchers.any(),
                Matchers.annotatedWith(Logged.class),
                loggingInterceptor);
    }

    @Provides
    @SessionId
    Long generateSessionId() {
        return System.currentTimeMillis();
    }

}
