package com.joizhang.exception;

/**
 * 重复秒杀异常（运行其异常）
 * Created by joizhang on 16-9-15.
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
