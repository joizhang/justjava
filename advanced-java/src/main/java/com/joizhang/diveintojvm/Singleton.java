package com.joizhang.diveintojvm;

/**
 * java -verbose:class -XX:+TraceClassLoading Singleton
 *
 * 只有当调用 Singleton.getInstance 时，程序才会访问 LazyHolder.INSTANCE，
 * 才会触发对 LazyHolder 的初始化（对应第 4 种情况），继而新建一个 Singleton
 * 的实例。
 *
 * @author joizhang
 */
public class Singleton {

    private Singleton() {}

    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
        static {
            System.out.println("LazyHolder.<clinit>");
        }
    }

    public static Object getInstance(boolean flag) {
        if (flag) {
            // 新建 LazyHolder 数组会加载元素类 LazyHolder；不会初始化元素类
            return new LazyHolder[2];
        }
        // LazyHolder 链接和初始化
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        getInstance(true);
        System.out.println("----");
        getInstance(false);
    }

}
