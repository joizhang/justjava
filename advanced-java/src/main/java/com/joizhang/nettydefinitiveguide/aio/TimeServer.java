package com.joizhang.nettydefinitiveguide.aio;

import java.io.IOException;

public class TimeServer {

    public static void main(String[] args) throws IOException {
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(8080);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }

}
