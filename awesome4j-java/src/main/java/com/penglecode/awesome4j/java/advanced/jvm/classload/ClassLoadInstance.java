package com.penglecode.awesome4j.java.advanced.jvm.classload;

public class ClassLoadInstance {
	
	static {
		//先于构造函数执行
		System.out.println("【ClassLoadInstance】>>> 静态块被执行了");
	}

	public ClassLoadInstance() {
		super();
		System.out.println("【ClassLoadInstance】>>> 构造函数被调用了");
	}
	
}
