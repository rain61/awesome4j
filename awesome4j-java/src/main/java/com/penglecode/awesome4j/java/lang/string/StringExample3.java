package com.penglecode.awesome4j.java.lang.string;

/**
 * String类中的一些方法的示例
 * 
 */
public class StringExample3 {

	/**
	 * String.replace(CharSequence target, CharSequence replacement)方法是基于字面值的替换,
	 * 而没有广义上的正则模式匹配，进入源代码可以看到：Pattern.compile(target.toString(), Pattern.LITERAL),
	 * 使用的是Pattern.LITERAL(字面值)
	 */
	public static void replaceTest() {
		String str = "Hello Java. Java is a language.";
		System.out.println(str.replace("Java.", "c++"));//打印 Hello c++ Java is a language.
	}
	
	/**
	 * replaceAll是真正基于正则表达式的
	 */
	public static void replaceAllTest() {
		String str = "Hello Java. Java is a language.";
		System.out.println(str.replaceAll("Java.", "c++"));//打印 Hello c++ c++is a language.
	}
	
	public static void reverseString() {
		String str = "java.lang.String0";
		
		char[] chars = str.toCharArray();
		int length = chars.length;
		for(int ascIndex = 0, descIndex = length - 1; ascIndex < descIndex; ascIndex++, descIndex--) {
			char temp = chars[ascIndex];
			chars[ascIndex] = chars[descIndex];
			chars[descIndex] = temp;
		}
		System.out.println(new String(chars));
	}
	
	public static void main(String[] args) {
		replaceTest();
		replaceAllTest();
		reverseString();
	}

}
