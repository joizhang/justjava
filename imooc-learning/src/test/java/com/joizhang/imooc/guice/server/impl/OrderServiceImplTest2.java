package com.joizhang.imooc.guice.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Provider;
import com.google.inject.util.Modules;
import com.joizhang.imooc.guice.server.OrderService;
import com.joizhang.imooc.guice.server.PriceService;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

class PriceServiceMock implements PriceService {

    @Override
    public long getPrice(long orderId) {
        return 567L;
    }

    @Override
    public Set<String> getSupportedCurrencies() {
        return null;
    }
}

public class OrderServiceImplTest2 {

    @Inject private OrderService orderService;

    @Inject
    private Provider<List<String>> supportedCurrenciesProvider;

    @Inject
    private PriceService priceService;

    @Before
    public void setUp() {
        Guice.createInjector(Modules.override(new ServerModule())
                .with(new AbstractModule() {
                    @Override
                    protected void configure() {
                        bind(PriceService.class).to(PriceServiceMock.class);
                    }
                }))
                .injectMembers(this);
    }

    @Test
    public void testSendToPayment() {
        orderService.sendToPayment(789L);
    }

    @Test
    public void testGetSupportedCurrencies() {
        assertTrue(supportedCurrenciesProvider.get().size() == 3);
    }

    @Test
    public void testGetSupportedCurrencies2() {
        throw new RuntimeException(priceService.getSupportedCurrencies().toString());
    }
}