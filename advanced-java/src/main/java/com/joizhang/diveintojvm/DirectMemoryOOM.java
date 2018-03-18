package com.joizhang.diveintojvm;

import jdk.internal.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * <pre>
 * 	使用unsafe分配本机内存<br>
 * VM Args:-Xmx20M -XX:MaxDirectMemorySize=10M
 * 通过反射直接使用Unsafe类提供的allocateMemory()方法请求内存。
 * </pre>
 *
 * @author joizhang
 *
 */
public class DirectMemoryOOM {

    private static final int ONE_MB = 1024 * 1024;

    public static void main(String[] args) {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        try {
            Unsafe unsafe = (Unsafe) unsafeField.get(null);
            while(true){
                unsafe.allocateMemory(ONE_MB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
