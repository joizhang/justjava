package com.joizhang.imooc.guice.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.joizhang.imooc.guice.server.OrderService;
import com.joizhang.imooc.guice.server.PaymentService;
import com.joizhang.imooc.guice.server.PriceService;

import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

/**
 * @author imooc
 */
public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new GlobalModule());
        install(new ChinaModule());
        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);

        bind(new TypeLiteral<List<String>>() {})
                .toInstance(Arrays.asList("CNY", "USD", "EUR"));
    }

    @Provides
    @SessionId
    Long generateSessionId() {
        return System.currentTimeMillis();
    }

//    @Provides
//    @Named("supportedCurrencies")
//    List<String> getSupportedCurrencies(PriceService priceService) {
//        return priceService.getSupportedCurrencies();
//    }

}
