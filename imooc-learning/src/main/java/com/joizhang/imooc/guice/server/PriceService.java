package com.joizhang.imooc.guice.server;

/**
 * @author imooc
 */
public interface PriceService {

    /**
     * get price
     * @param orderId
     * @return
     */
    long getPrice(long orderId);

}
