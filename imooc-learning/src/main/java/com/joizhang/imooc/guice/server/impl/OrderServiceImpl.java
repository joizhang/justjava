package com.joizhang.imooc.guice.server.impl;

import com.joizhang.imooc.guice.server.OrderService;
import com.joizhang.imooc.guice.server.PaymentService;
import com.joizhang.imooc.guice.server.PriceService;

import javax.inject.Inject;

public class OrderServiceImpl implements OrderService {

    /**
     * 加final保证依赖不变
     */
    private final PriceService priceService;

    private final PaymentService paymentService;

    private final SessionManager sessionManager;

    private Long ordersPaid = 0L;

    @Inject
    public OrderServiceImpl(PriceService priceService, PaymentService paymentService, SessionManager sessionManager) {
        this.priceService = priceService;
        this.paymentService = paymentService;
        this.sessionManager = sessionManager;
    }

    @Override
    public void sendToPayment(long orderId) {
        long price = priceService.getPrice(orderId);
        paymentService.pay(orderId, price, sessionManager.getSessionId());
        ordersPaid = ordersPaid + 1;
    }

}
