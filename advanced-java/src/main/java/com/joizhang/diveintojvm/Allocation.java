package com.joizhang.diveintojvm;

/**
 * <pre>
 * 验证：对象优先在Eden分配
 *
 * VM Args:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 * </pre>
 *
 * @author joizhang
 */
public class Allocation {

    private static final int ONE_MB = 1024 * 1024;

    /**
     * 尝试分配了3个2MB大小和一个4MB大小的对象，
     * 在运行时通过-Xms20M、-Xmx20M和-Xmn10M这三个参数限制Java堆大小为20MB，且不可扩展。
     * 其中10MB分配给新生代，剩下的10MB分配给老生代。
     * -XX:SurvivorRatio=8决定了新生代中Eden区与一个Survivor区的空间大小比例为8:1，
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * ONE_MB];
        allocation2 = new byte[2 * ONE_MB];
        allocation3 = new byte[2 * ONE_MB];
        // 出现一次Minor GC
        allocation4 = new byte[4 * ONE_MB];
    }

}
