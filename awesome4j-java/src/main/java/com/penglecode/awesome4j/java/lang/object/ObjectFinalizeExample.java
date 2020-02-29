package com.penglecode.awesome4j.java.lang.object;

public class ObjectFinalizeExample {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("invoke finalize");
	}

	public static void main(String[] args) throws Throwable {
		new ObjectFinalizeExample();
		System.gc(); //强制触发垃圾回收，从而调用了重写的finalize()方法输出: invoke finalize
	}

}
