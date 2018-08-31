package com.joizhang.diveintojvm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnsafeHelperTest {

    @Test
    public void toAddress() {
        boolean flag = false;
        long address = UnsafeHelper.toAddress(flag);
        System.out.println(address);
        assertEquals(false, UnsafeHelper.fromAddress(address));
    }

}