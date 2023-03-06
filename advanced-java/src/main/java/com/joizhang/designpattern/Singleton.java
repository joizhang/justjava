package com.joizhang.designpattern;

public class Singleton {

    /**
     * 饿汉式
     */
    static class Singleton1 {
        private static final Singleton1 instance = new Singleton1();

        //构造私有化，防止直接new
        private Singleton1() {
        }

        public static Singleton1 getInstance() {
            return instance;
        }
    }

    /**
     * 懒汉式，同步方法
     */
    static class Singleton2 {
        private static Singleton2 instance;

        private Singleton2() {
        }

        public static synchronized Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }
    }

    /**
     * 懒汉式，双重检查加锁
     */
    static class Singleton3 {
        // volatile 禁止指令重排
        private static volatile Singleton3 instance;

        private Singleton3() {
        }

        private static Singleton3 getInstance() {
            if (instance == null) {
                synchronized (Singleton3.class) {
                    if (instance == null) {
                        instance = new Singleton3();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 静态内部类，静态内部类方式在Singleton 类被装载的时候并不会立即实例化，
     * 而是在调用getInstance的时候，才去装载内部类SingletonInstance ,从
     * 而完成Singleton的实例化
     */
    static class Singleton4 {
        private Singleton4() {
        }

        private static class SingletonHolder {
            private static final Singleton4 INSTANCE = new Singleton4();
        }

        private static Singleton4 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 枚举，不仅可以避免多线程同步问题，还能防止反序列化重新创建新的对象，
     * 但是在枚举中的其他任何方法的线程安全由程序员自己负责。还有防止上面的
     * 通过反射机制调用私用构造器。
     */
    enum Singleton5 {
        INSTANCE;
    }

    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println(singleton1);
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2);
        Singleton3 singleton3 = Singleton3.getInstance();
        System.out.println(singleton3);
        Singleton4 singleton4 = Singleton4.getInstance();
        System.out.println(singleton4);
        Singleton5 singleton5 = Singleton5.INSTANCE;
        System.out.println(singleton5);
    }
}
