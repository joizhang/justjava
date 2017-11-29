package com.joizhang.imooc.guice.aop;

import com.joizhang.imooc.guice.server.PaymentService;

public class PaymentServiceImpl implements PaymentService {

    @Override
    @Logged
    public void pay(long orderId, long price, Object sessionId) {

    }

}
