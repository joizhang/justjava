package com.joizhang.imooc.guice.aop;

import com.google.inject.Guice;
import com.joizhang.imooc.guice.server.PaymentService;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

public class PaymentServiceImplTest {

    @Inject
    private PaymentService paymentService;

    @Before
    public void setUp() {
        Guice.createInjector(new AopModule())
                .injectMembers(this);
    }

    @Test
    public void pay() throws Exception {
        paymentService.pay(123L, 23L, "asdasdasdq31");
    }

}