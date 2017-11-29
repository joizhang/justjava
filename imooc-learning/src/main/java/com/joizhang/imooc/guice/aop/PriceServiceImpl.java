package com.joizhang.imooc.guice.aop;

import com.joizhang.imooc.guice.server.PriceService;

import javax.inject.Inject;
import java.util.Set;

/**
 * @author imooc
 */
public class PriceServiceImpl implements PriceService {

    private final Set<String> supportedCurrencies;

    @Inject
    public PriceServiceImpl(Set<String> supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
    }

    @Override
    @Logged
    public long getPrice(long orderId) {
        return 456L;
    }

    @Override
    public Set<String> getSupportedCurrencies() {
        return supportedCurrencies;
    }
}
