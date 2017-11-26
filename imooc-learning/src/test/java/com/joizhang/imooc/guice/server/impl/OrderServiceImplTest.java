package com.joizhang.imooc.guice.server.impl;

import com.google.inject.Guice;
import com.joizhang.imooc.guice.server.OrderService;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceImplTest {

    @Test
    public void testSendToPayment() {
        OrderService orderService = Guice.createInjector(new ServerModule())
                .getInstance(OrderService.class);
        orderService.sendToPayment(789L);
    }

}