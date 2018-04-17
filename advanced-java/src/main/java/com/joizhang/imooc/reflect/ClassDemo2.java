package com.joizhang.imooc.reflect;

public class ClassDemo2 {
    public static void main(String[] args) {
        //int的类类型
        Class c1 = int.class;
        //String的类类型
        Class c2 = String.class;
        Class c3 = double.class;
        Class c4 = Double.class;
        Class c5 = void.class;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c1.getSimpleName());
        System.out.println(c5.getName());
    }
}
