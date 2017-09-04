package com.joizhang.reflection;

public class ClassDemo1 {
	public static void main(String[] args) {
		// Foo的实例对象如何表示
		Foo foo1 = new Foo();// foo1就表示出来了
		// Foo这个类也是一个实例对象， Class泪的实例对象
		// 任何一个类都是Class的实例对象，这个实例对象有三种表示方法

		// 第一种表示方法->实际在告诉我们任何一个类都有一个隐含的静态成员变量c
		Class c1 = Foo.class;

		// 第二种表达方式 已经知道该类的对象通过getClass方法
		Class c2 = foo1.getClass();

		/*
		 * 官网c1, c2表示了Foo类的类类型(class type) 万事万物皆对象 类也是对象，是Class类的实例对象
		 * 这个对象我们成为该类的类类型
		 */

		// 不管c1 or c2 ,都代表了Foo类的类类型，一个类只可能是Class类
		System.out.println(c1 == c2);

		// 第三种表达方式
		Class c3 = null;
		try {
			c3 = Class.forName("com.joizhang.reflection.Foo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c2 == c3);

		// 我们完全可以通过累累想创建该类的对象实例--》通过c1 or c2 or c3创建Foo的实力
		try {
			Foo foo = (Foo) c1.newInstance();
			foo.print();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Foo {
	void print() {

	}
}
