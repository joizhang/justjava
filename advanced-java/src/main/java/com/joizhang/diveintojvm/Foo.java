package com.joizhang.diveintojvm;

/**
 * ASM bytecode viewer 下载地址：https://plugins.jetbrains.com/plugin/10302-asm-bytecode-viewer
 *
 * @author joizhang
 */
public class Foo {

    public static void main(String[] args) {
        boolean flag = true;

        if (flag) {
            System.out.println("Hello, Java!");
        }
        if (flag == true) {
            System.out.println("Hello, JVM!");
        }
    }

}
