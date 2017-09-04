package com.imooc.anntest;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1、成员类型是受限的，合法的类型包括原始类型及String，Class，Annotation，enumeration
 * 2、若果注解只有一个成员，则成员名必须取名为value()，在使用时可以忽略成员名和赋值号(=)
 * 3、注解类可以没有成员，没有成员的注解称为标志注解
      * */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited		//允许子类继承
@Documented		//生成javadoc时会包含注解
public @interface Description {
	
	String value();
	/*String desc();
	
	String author();
	
	int age() default 18;*/
}
