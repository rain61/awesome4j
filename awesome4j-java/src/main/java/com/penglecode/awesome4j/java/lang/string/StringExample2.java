package com.penglecode.awesome4j.java.lang.string;

/**
 * switch对String的支持是通过String.hashCode和equals两个方法来实现的。
 * 这一点可以通过jad反编译工具来反编译该class文件得知。
 * 
 * 总结一下我们可以发现，其实switch只支持一种数据类型，那就是整型，对其他类型诸如char、String的支持都是通过编译期的优化实现的。
 */
public class StringExample2 {

	public static void stringSwitch() {
		String str = "world";
		switch (str) {
			case "hello":
				System.out.println("hello");
				break;
			case "world":
				System.out.println("world");
				break;
			default:
				break;
		}
	}
	
	public static void enumSwith() {
		Language lan = Language.JAVA;
		switch (lan) {
			case JAVA:
				System.out.println("java");
				break;
			case GO:
				System.out.println("go");
				break;
			default:
				break;
		}
	}
	
	public static enum Language {
		
		JAVA, GO, PYTHON;
		
	}
}
