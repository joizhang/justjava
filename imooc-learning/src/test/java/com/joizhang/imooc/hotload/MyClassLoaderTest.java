package com.joizhang.imooc.hotload;

import org.junit.Test;

public class MyClassLoaderTest {

    @Test
    public void test() {
        new Thread(new MsgHandler()).start();
    }

}