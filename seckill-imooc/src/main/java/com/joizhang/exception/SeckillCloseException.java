package com.joizhang.exception;

/**
 * 秒杀关闭异常
 * Created by joizhang on 16-9-15.
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
