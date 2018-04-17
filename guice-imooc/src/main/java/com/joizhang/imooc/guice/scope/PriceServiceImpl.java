package com.joizhang.imooc.guice.scope;

import com.google.common.cache.Cache;
import com.joizhang.imooc.guice.server.PriceService;

import javax.inject.Inject;
import java.util.Set;

public class PriceServiceImpl implements PriceService {

    private final Set<String> supportedCurrencies;

    private final Cache<String, String> cache;

    @Inject
    public PriceServiceImpl(Set<String> supportedCurrencies, Cache<String, String> cache) {
        this.supportedCurrencies = supportedCurrencies;
        this.cache = cache;
    }

    @Override
    public long getPrice(long orderId) {
        return 0;
    }

    @Override
    public Set<String> getSupportedCurrencies() {
        return null;
    }

    String getCachedValue(String key) {
        return cache.getIfPresent(key);
    }
}
