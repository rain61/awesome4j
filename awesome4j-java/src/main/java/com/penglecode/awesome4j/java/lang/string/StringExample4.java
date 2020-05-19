package com.penglecode.awesome4j.java.lang.string;

/**
 * String面试题
 * 
 */
public class StringExample4 {

	public static void round1() {
		String str1 = "abc"; //声明时，产生编译优化，直接在字符串池中创建"abc"字符串对象并将其引用指向str1
		String str2 = "abc"; //发现池中已经存在"abc"字符串对象，则直接返回其引用给str2
		System.out.println(str1 == str2); //true
		System.out.println(str1.equals(str2)); //true
	}
	
	public static void round2() {
		String str1 = new String("abc"); //声明时，且String构造器传入的是常量，那么就会触发编译优化：生成堆中str1的引用对象，以及字符串池中的"abc"字符串对象
		String str2 = "abc"; //发现池中已经存在"abc"字符串对象，则直接返回其引用给str2
		System.out.println(str1 == str2); //false，因为str1是堆内存中的引用，str2是常量池中的引用
		System.out.println(str1.equals(str2)); //true
	}
	
	public static void round3() {
		String str1 = "abc"; //声明时，产生编译优化，直接在字符串池中创建"abc"字符串对象并将其引用指向str1
		String str2 = new String("abc"); //发现池中已经存在"abc"字符串对象，在堆中创建一个str2引用其value指向常量池中的
		System.out.println(str1 == str2); //false
		System.out.println(str1.equals(str2)); //true
	}
	
	/**
	 * 该示例基本上等同于round1()
	 */
	public static void round4() {
		String str1 = "a" + "b" + "c"; //声明时，产生编译优化，等价于：String str1 = "abc";
		String str2 = "abc"; //发现池中已经存在"abc"字符串对象，则直接返回其引用给str2
		System.out.println(str1 == str2); //true
		System.out.println(str1.equals(str2)); //true
	}
	
	public static void round5() {
		String str1 = "ab";
		String str2 = "abc"; //声明时，产生编译优化，直接在字符串池中创建"abc"字符串对象并将其引用指向str1
		String str3 = str1 + "c"; //因为表达式中str1是变量，不会进行编译优化，其等价于new StringBuilder().append(str1).append("c").toString()，而toString()方法实际就是new String(...)
		System.out.println(str2 == str3); //false
		System.out.println(str2.equals(str3)); //true
	}
	
	public static void main(String[] args) {
		//round1();
		//round2();
		//round3();
		//round4();
		round5();
	}

}
