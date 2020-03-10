package com.penglecode.awesome4j.java.advanced.jvm.classload;

public class ClassLoadStaticVariable {
	
	static {
		System.out.println("【ClassLoadStaticVariable】>>> 静态块被执行了");
	}
	
	public static int staticNum = 1;

}
