package com.penglecode.awesome4j.java.basic.innerclass;

/**
 * 成员内部类
 */
public class OuterClass3 {

	private String name;
	
	public class InnerClass {
		
		private String name;
		
		public void greeting() {
			System.out.println("hello " + name); //指向内部类的name属性
			System.out.println("hello " + OuterClass3.this.name); //指向外部类的name属性
		}
		
	}
	
}
