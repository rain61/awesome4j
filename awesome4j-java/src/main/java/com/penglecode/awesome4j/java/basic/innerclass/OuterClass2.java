package com.penglecode.awesome4j.java.basic.innerclass;

/**
 * 静态成员内部类
 */
public class OuterClass2 {

	private static String name;
	
	public static class InnerClass {
		
		/**
		 * 静态内部类不能访问外部类的非静态成员变量
		 */
		public void greeting() {
			System.out.println("hello " + name);
		}
		
	}
	
	public void invokeGreeting() {
		new OuterClass2.InnerClass().greeting();
	}
	
	public static void main(String[] args) {
		//对静态内部类的调用不需要依赖外部类的实例
		new OuterClass2.InnerClass().greeting();
	}

}
