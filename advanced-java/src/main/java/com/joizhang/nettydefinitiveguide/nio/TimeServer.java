package com.joizhang.nettydefinitiveguide.nio;

public class TimeServer {

    public static void main(String[] args) {
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(8080);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }

}
