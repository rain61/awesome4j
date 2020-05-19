package com.penglecode.awesome4j.java.basic.datatype;

/**
 * 阿里P9面试题：关于Java 类型系统的理解
 * 这段代码里面到底哪一行错了？为什么？如果某个 Java 版本能顺利运行这段代码，那么你如何让这个错误暴露得更致命一些？
 * 
 */
public class JavaDataTypeExample1 {

	/**
	 * 在Java中，数组中的数据类型必须一致，否则会触发ArrayStoreException(真正的Object[]数组除外，即Object[] oa = new Object[]{...});
	 */
	public static void main(String[] args) {
		String[] a = new String[2];
		Object[] b = a; //用object类型来欺骗编译器
		a[0] = "hi";
		b[1] = Integer.valueOf("42"); //最终骗不了执行器，触发了java.lang.ArrayStoreException
	}

}
