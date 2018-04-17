package com.joizhang.nettydefinitiveguide.aio;

public class TimeClient {

    public static void main(String[] args) {
        AsyncTimeClientHandler asyncTimeClientHandler = new AsyncTimeClientHandler("127.0.0.1", 8080);
        new Thread(asyncTimeClientHandler, "AIO-AsyncTimeClientHandler-001").start();
    }

}
