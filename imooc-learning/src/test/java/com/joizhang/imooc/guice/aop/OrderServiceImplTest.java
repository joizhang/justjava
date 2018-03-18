package com.joizhang.imooc.guice.aop;

import com.google.inject.Guice;
import com.joizhang.imooc.guice.server.OrderService;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

public class OrderServiceImplTest {

    @Inject
    private OrderService orderService;

    @Before
    public void setUp() {
        Guice.createInjector(new AopModule())
                .injectMembers(this);
    }

    @Test
    public void sendToPayment() throws Exception {
        orderService.sendToPayment(123L);
    }

}