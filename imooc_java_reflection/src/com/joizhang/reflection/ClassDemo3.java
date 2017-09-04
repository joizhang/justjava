package com.joizhang.reflection;

public class ClassDemo3 {
	public static void main(String[] args) {
		String s = "hello";
		ClassUtil.printClassMethodMessage(s);
		
		Integer i = 1;
		ClassUtil.printClassFieldMessage(i);
	}
}
