package com.joizhang.imooc.guice.scope;

import com.google.common.cache.Cache;
import com.joizhang.imooc.guice.server.PaymentService;

import javax.inject.Inject;

public class PaymentServiceImpl implements PaymentService {

    private final Cache<String, String> cache;

    @Inject
    public PaymentServiceImpl(Cache<String, String> cache) {
        this.cache = cache;
    }

    @Override
    public void pay(long orderId, long price, Object sessionId) {

    }

    void putCache(String key, String value) {
        cache.put(key, value);
    }

}
