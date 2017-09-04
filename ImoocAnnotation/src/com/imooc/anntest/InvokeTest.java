package com.imooc.anntest;

import java.lang.reflect.Method;

public class InvokeTest {
	public static void main(String[] args) {
		String [] names ={"tom","tim","allen","alice"};
	    Class<?> clazz = Test.class;
	    try {
	    	Method method = clazz.getMethod("sayHi", String.class);
	        for(String name:names)
	        	method.invoke(clazz.newInstance(),name);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}

class Test {
    public void sayHi(String name) {
        System.out.println("Hi "+name);
    }
}