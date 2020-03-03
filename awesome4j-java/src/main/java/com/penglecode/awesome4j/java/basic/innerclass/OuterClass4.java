package com.penglecode.awesome4j.java.basic.innerclass;

/**
 * 局部内部类
 */
public class OuterClass4 {

	private static final String version = "1.0";
	
	private String type = "1";
	
	public void testInner() {
		String id = "123";
		
		class InnerClass {
			
			public void test() {
				System.out.println(">>> version = " + version);
				System.out.println(">>> type = " + type);
				System.out.println(">>> id = " + id);
			}
			
		}
		
		new InnerClass().test();
		
	}
	
	public static void main(String[] args) {
		new OuterClass4().testInner();
	}

}
