package com.joizhang.imooc.guice.server;

/**
 * @author imooc
 */
public interface OrderService {

    void sendToPayment(long orderId);
}
