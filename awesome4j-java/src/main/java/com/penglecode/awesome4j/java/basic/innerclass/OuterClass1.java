package com.penglecode.awesome4j.java.basic.innerclass;

/**
 * 成员内部类
 */
public class OuterClass1 {

	private String name;
	
	public OuterClass1(String name) {
		this.name = name;
	}

	public class InnerClass {
		
		public void greeting() {
			//等价于: System.out.println("hello " + OuterClass1.this.name);
			System.out.println("hello " + name);
		}
		
	}
	
	public void invokeGreeting() {
		//调用内部类的实例方法，必须先有该内部类所依赖的外层类的实例，在当前情况下即为this
		InnerClass inner = new InnerClass();
		inner.greeting();
	}
	
	public static void main(String[] args) {
		OuterClass1 outer = new OuterClass1("Tony");
		outer.invokeGreeting();
		
		//调用内部类的实例方法，必须先有该内部类所依赖的外层类的实例，在当前情况下即为outer
		InnerClass inner = outer.new InnerClass();
		inner.greeting();
	}
	
}
