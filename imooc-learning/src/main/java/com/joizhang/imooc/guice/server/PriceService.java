package com.joizhang.imooc.guice.server;

import java.util.Set;

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

    /**
     * get supported currencies
     * @return
     */
    Set<String> getSupportedCurrencies();
}
