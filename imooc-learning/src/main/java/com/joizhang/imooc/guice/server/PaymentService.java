package com.joizhang.imooc.guice.server;

/**
 * @author imooc
 */
public interface PaymentService {

    /**
     * pay
     *
     * @param orderId
     * @param price
     * @param sessionId
     */
    void pay(long orderId, long price, Object sessionId);
}
