package com.joizhang.imooc;

import com.joizhang.imooc.config.JettyServer;

/**
 * @author joizhang
 */
public class Application {

    public static void main(String[] args) throws Exception {
        new JettyServer().run();
    }

}

