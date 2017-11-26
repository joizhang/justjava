package com.joizhang.imooc.guice.server.impl;

import com.joizhang.imooc.guice.server.PriceService;

public class PriceServiceImpl implements PriceService {

    @Override
    public long getPrice(long orderId) {
        return 456L;
    }
}
