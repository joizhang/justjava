package com.joizhang.exception;

/**
 * 秒杀相关业务异常
 * Created by joizhang on 16-9-15.
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
