package com.joizhang.diveintojvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出异常测试<br>
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author joizhang
 *
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while(true){
            list.add(new Object());
        }
    }

}
