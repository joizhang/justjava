package com.joizhang.imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
    /**
     * 打印类的信息
     */
    public static void printClassMethodMessage(Object obj) {
        //要获取类的类类型
        //JNI实现native方法
        Class<?> c = obj.getClass();

		/*
         * getMethods()方法获取的使所有的public的函数，包括父类继承而来的
		 * DeclaredzMethods()获取的是该类自己声明的方法，不问访问
		 * */
        Method[] methods = c.getMethods();
        for (int i = 0; i < methods.length; i++) {
            //得到方法的返回值类型的类类型
            Class<?> returnType = methods[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            //得到方法的名称
            System.out.print(methods[i].getName() + "(");
            //获得参数类型-》得到的是参数列表的类型的类类型
            Class<?>[] paramTypes = methods[i].getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                Class<?> class1 = paramTypes[j];
                if (j == (paramTypes.length - 1)) {
                    System.out.print(class1.getName());
                } else {
                    System.out.print(class1.getName() + ", ");
                }
            }
            System.out.println(")");
        }

    }

    public static void printClassFieldMessage(Object obj) {
        Class<?> c = obj.getClass();
		/*
		 * 成员变量也是对象
		 * java.lang.reflect.Field
		 * Field类封装了关于成员变量的操作
		 * getFields()方法获得是所有的public的成员变量的信息
		 * getDeclaredFields()获取的是该类自己声明的成员变量的信息
		 * */
        Field[] fs = c.getDeclaredFields();
        for (Field field : fs) {
            //得到成员变量的类型的类类型
            Class<?> fieldType = field.getType();
            String typeName = fieldType.getName();
            //得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }
    }

    public static void printConstructMessage(Object obj) {
        Class<?> c = obj.getClass();
        //构造函数也是对象
        //java.lang.Constructor中封装了构造函数的信息
        //getConstructors获取所有public的构造函数
        //getDeclaredConstructors得到所有的构造函数
        Constructor<?>[] cs = c.getConstructors();
        for (Constructor<?> constructor : cs) {
            System.out.print(constructor.getName() + "(");
            //获取构造函数的参数列表
            Class<?>[] paramTypes = constructor.getParameterTypes();
            for (Class<?> class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }
}
