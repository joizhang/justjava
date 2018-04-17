package com.joizhang.imooc.guice.aop;

import com.joizhang.imooc.guice.server.OrderService;
import com.joizhang.imooc.guice.server.PaymentService;
import com.joizhang.imooc.guice.server.PriceService;
import com.joizhang.imooc.guice.server.impl.SessionManager;

import javax.inject.Inject;

/**
 * @author imooc
 */
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
    @Logged
    public void sendToPayment(long orderId) {
        long price = priceService.getPrice(orderId);
        paymentService.pay(orderId, price, sessionManager.getSessionId());
        ordersPaid = ordersPaid + 1;
    }

}
