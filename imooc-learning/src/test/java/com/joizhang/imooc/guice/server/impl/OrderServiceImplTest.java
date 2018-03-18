package com.joizhang.imooc.guice.server.impl;

import com.google.inject.Guice;
import com.google.inject.Provider;
import com.joizhang.imooc.guice.server.OrderService;
import com.joizhang.imooc.guice.server.PriceService;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class OrderServiceImplTest {

    @Inject
    private OrderService orderService;

    @Inject
//    @Named("supportedCurrencies")
    private Provider<List<String>> supportedCurrenciesProvider;

    @Inject
    private PriceService priceService;

    @Before
    public void setUp() {
        Guice.createInjector(new ServerModule()/*,
                new AbstractModule() {
                    @Override
                    protected void configure() {
                        bind(PriceServiceImpl.class)
                                .toInstance(new PriceServiceImpl() {
                                    @Override
                                    public long getPrice(long orderId) {
                                        return 567L;
                                    }
                                });
                    }
                }*/)
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