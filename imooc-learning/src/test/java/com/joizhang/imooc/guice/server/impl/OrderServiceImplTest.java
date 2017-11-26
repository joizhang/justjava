package com.joizhang.imooc.guice.server.impl;

import com.google.inject.Guice;
import com.joizhang.imooc.guice.server.OrderService;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class OrderServiceImplTest {

    @Inject private OrderService orderService;

    @Before
    public void setUp() {
        Guice.createInjector(new ServerModule())
                .injectMembers(this);
    }

    @Test
    public void testSendToPayment() {
        orderService.sendToPayment(789L);
    }

}