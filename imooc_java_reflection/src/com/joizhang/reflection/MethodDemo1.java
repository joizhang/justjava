package com.joizhang.reflection;

import java.lang.reflect.Method;

public class MethodDemo1 {
	public static void main(String[] args) {
		//要获取print(int, int)方法
		//1.要获取一个方法就是获取类的信息，获取泪的信息首先要获取类类型
		A a1 = new A();
		Class<?> c = a1.getClass();
		//2.获取方法 名称和参数列表决定
		//getMethod获取的是public的方法
		//getDeclaredMethod自己生命的方法
		
		try {
			//Method m = c.getMethod("print", new Class[]{int.class, int.class});
			Method m = c.getMethod("print", int.class, int.class);
			
			//方法的反射操作
//			a1.print(10, 20);方法的反射操作使用m对象进行方法的条用和a1.print调用的效果相同
			//返回如果没有返回值返回null，有返回值返回具体的返回值
			//Object o = m.invoke(a1, new Object[]{10, 20});
			Object o = m.invoke(a1, 10, 20);
			System.out.println("==================");
			
			Method m1 = c.getMethod("print", String.class, String.class);
			Object o1 = m1.invoke(a1, "hello", "WORLD");
			System.out.println("==================");
			
			//Method m2 = c.getMethod("print", new Object(){});
			Method m2 = c.getMethod("print");
			//Object o2 = m2.invoke(a1, new Object(){});
			Object o2 = m2.invoke(a1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class A {
	
	public void print() {
		System.out.println("hello world");
	}
	
	public void print(int a, int b) {
		testPravite();
		System.out.println(a + b);
	}
	
	public void print(String a, String b) {
		System.out.println(a.toUpperCase() + "," + b.toUpperCase());
	}
	
	private void testPravite() {
		System.out.println("hello");
	}
}
