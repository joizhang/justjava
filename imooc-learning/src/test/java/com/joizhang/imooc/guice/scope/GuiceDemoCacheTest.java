package com.joizhang.imooc.guice.scope;

import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuiceDemoCacheTest {

    @Inject private PaymentServiceImpl paymentService;
    @Inject private PriceServiceImpl priceService;


    @Before
    public void setUp() {
        Guice.createInjector(new ScopeModule())
                .injectMembers(this);
    }

    @Test
    public void testCache() {
        paymentService.putCache("testKey", "testValue");
        String cachedValue = priceService.getCachedValue("testKey");
        assertEquals("testValue", cachedValue);
    }

}