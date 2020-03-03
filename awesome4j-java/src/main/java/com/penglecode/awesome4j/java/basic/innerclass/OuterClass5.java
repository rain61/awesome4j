package com.penglecode.awesome4j.java.basic.innerclass;

/**
 * 匿名内部类
 */
public class OuterClass5 {

	public static void main(String[] args) {
		Thread thread = new Thread() { //局部内部类
			@Override
			public void run() {
				System.out.println(">>> 这是一个匿名内部类...");
			}
		};
		thread.start();
	}

}
