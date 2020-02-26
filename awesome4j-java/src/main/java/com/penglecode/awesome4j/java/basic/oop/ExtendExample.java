package com.penglecode.awesome4j.java.basic.oop;

public class ExtendExample {

	public static class Parent {
		
		public void work() {
			System.out.println("work");
		}
		
	}
	
	//类之间只能单继承
	public static class Child extends Parent {
		
	}
	
	public static interface A {}
	
	public static interface B {}
	
	//接口之间可以多继承
	public static interface C extends A, B {}
	
	//类实现多继承的方式
	public static class D implements A, B {}
	
}
