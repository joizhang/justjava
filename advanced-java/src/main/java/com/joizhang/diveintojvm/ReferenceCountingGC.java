package com.joizhang.diveintojvm;

/**
 * <pre>
 * 引用计数算法的缺陷是不能很好的解决对象之间循环引用的问题。
 * 示例代码证明了，虚拟机并不是采用引用计数算法来判断对象是否存活的。
 * </pre>
 *
 * @author joizhang
 */
public class ReferenceCountingGC {

    private static final int ONE_MB = 1024 * 1024;

    private Object instance = null;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便在GC日志中能清楚是否被回收过
     */
    @SuppressWarnings("unused")
    private byte[] bigSize = new byte[2 * ONE_MB];

    public static void main(String[] args) {

        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 执行GC
        System.gc();

    }

}
