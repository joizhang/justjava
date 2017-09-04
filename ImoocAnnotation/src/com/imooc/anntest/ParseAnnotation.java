package com.imooc.anntest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseAnnotation {

	public static void main(String[] args) {
		//1、使用类加载其加载类
		try {
			Class c = Class.forName("com.imooc.anntest.Child");
			//2、找到类上面的注解
			boolean isExist = c.isAnnotationPresent(Description.class);
			if(isExist) {
				//3、找到注解实例
				Description d = (Description)c.getAnnotation(Description.class);
				System.out.println(d.value());
			}
			
			//4、找到方法上的注解
			Method[] ms = c.getMethods();
			for(Method m : ms) {
				boolean isMExist = m.isAnnotationPresent(Description.class);
				if(isMExist) {
					Description d = (Description)m.getAnnotation(Description.class);
					System.out.println(d.value());
				}
			}
			
			//另外一种解析方法
			for(Method m : ms) {
				Annotation[] as = m.getAnnotations();
				for(Annotation a : as) {
					if(a instanceof Description) {
						Description d = (Description)a;
						System.out.println(d.value());
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
