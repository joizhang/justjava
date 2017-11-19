package com.joizhang.imooc.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodDemo4 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("hello");

        Class c1 = list.getClass();
        Class c2 = list1.getClass();
        System.out.println(c1 == c2);
        //反射的操作都是编译之后的操作

        //c1 == c2 结果返回true说明编译之后集合的泛型是去泛型化的
        //java中集合的泛型，是泛指错误输入的，只在编译阶段有效
        //绕过编译就无效了
        //验证：我们可以通过方法的反射来操作，绕过编译

        try {
            Method m = c1.getMethod("add", Object.class);
            //绕过了编译操作就绕过了泛型
            m.invoke(list1, 100);
            System.out.println(list1.size());
            System.out.println(list1);
            //使用for each会抛出类转化异常
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}	
