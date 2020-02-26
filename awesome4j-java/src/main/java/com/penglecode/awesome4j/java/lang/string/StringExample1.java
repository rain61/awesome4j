package com.penglecode.awesome4j.java.lang.string;

/**
 * 字符串是一种比较特殊的对象，他有自己特有的字符串常量池中。以字面量的形式创建String变量时，
 * JVM会在编译期间就把该字面量放到字符串常量池中，由Java程序启动的时候就已经加载到内存中了。
 * 这个字符串常量池的特点就是有且只有一份相同的字面量，如果有其它相同的字面量，JVM则返回这个字面量的引用，
 * 如果没有相同的字面量，则在字符串常量池创建这个字面量并返回它的引用。
 * 
 * String str0 = "abc"; //声明时，产生编译优化，直接在字符串池中创建"abc"字符串对象并将其引用指向str0
 * 
 * String str1 = new String("abc"); //声明时，且String构造器传入的是常量，那么就会触发编译优化：生成堆中str1的引用对象，以及字符串池中的"abc"字符串对象
 * 
 * String str2 = new String(s1); //声明时，但String构造器传入的是变量，不会触发编译优化，运行时仅在堆中生成相应字面值的字符串对象！此时若再调用str2.intern()方法，那么则将str2的引用指向常量池中而不是复制一份该字面值放入字符串池中
 * 
 */
public class StringExample1 {

	public static void stringPool1() {
		/**
		 * 执行语句String str = new String("abc")时，会创建两个对象：堆中的str引用对象，字符串池中的"abc"字符串对象，并且str中的value指向常量池中的"abc"对象.value
		 */
		String a1 = new String("abc"); //带new的操作，返回新对象的引用
		String a2 = new String("abc"); //带new的操作，返回新对象的引用
		
		System.out.println("a1 == a2 : " + (a1 == a2)); //因此此处结果是false
		
		/**
		 * 声明字符串变量，且=号右侧是个常量值，那么编译器在编译时进行优化，
		 * 将"abc"串放入字符串常量池中并且返回引用地址给变量s1
		 */
		String s1 = "abc";
		/**
		 * 声明字符串变量，且=号右侧是个常量值，那么编译器在编译时进行优化，
		 * 将"abc"串放入字符串常量池中，此时发现池中一寸存在该串，则立即返回该串的引用地址给变量s2
		 */
		String s2 = "abc";
		
		/**
		 * 编译期间优化为 String s3 = "abc";
		 */
		String s3 = "a" + "b" + "c";
		System.out.println("s1 == s2 : " + (s1 == s2)); //所以s1与s2的引用地址一样，因此s1 == s2为true
		System.out.println("s1 == s3 : " + (s1 == s3)); //所以s1与s3的引用地址一样，因此s1 == s3为true
		
		/**
		 * 运行期的字符串+拼接，编译器优化为StringBuilder.append()代替，最后调用toString()方法返回，
		 * StringBuilder.toString()方法其底层就是一个 new String()，通过new操作创建的对象肯定具有唯一的引用地址，
		 * 因此s1，s2具有不同的引用地址，因此==结果为false
		 */
		s1 = s1 + "d";
		s2 = s2 + "d";
		System.out.println("s1 == s2 : " + (s1 == s2));
	}
	
	/**
	 * String常量池的知识点: https://blog.csdn.net/hz90s/article/details/80819619
	 */
	public static void stringPool2() {
		String s1 = new String("hello"); //生成两个对象：堆中s1引用对象，字符串池中"abc"字符串对象
        String intern1 = s1.intern(); //执行intern()方法时，池中已经存在串"abc"则立即返回字符串池中"abc"字符串对象的引用
        String s2 = "hello"; //池中已经存在串"abc"则立即返回字符串池中"abc"字符串对象的引用
        System.out.println("s1 == s2 : " + (s1 == s2)); //s1是new出来的，因此s1与任何对象==运算不可能为true，所以此处肯定输出false
        System.out.println("intern1 == s1 : " + (intern1 == s1)); //s1是new出来的，因此s1与任何对象==运算不可能为true，所以此处肯定输出false
        System.out.println("intern1 == s2 : " + (intern1 == s2)); //intern1是返回自字符串常量池中的引用，因此为true
	}
	
	public static void stringPool3() {
		/**
		 * 存在字符串+拼接，那么可以断定其编译优化后的代码是：String s3 = new StringBuilder().append(new String("hello")).append(new String("hello")).toString();
		 * 由于toString()方法最终调用的是new String("hellohello")，但是这是运行时发生的，相比于声明时(String s1 = new String("hellohello"))，编译器管不了运行时的优化，
		 * 故此处s3虽然等效于new String("hellohello")，但是并不会在字符串常量池中放一份"hellohello"对象
		 */
		String s3 = new String("hello") + new String("hello");
		/**
		 * 调用s3.intern()方法，发现字符串池中不存在该串，则将s3的引用指向常量池中而不是复制一份该字面值放入字符串池中，因此intern3实际指向s3的引用
		 */
        String intern3 = s3.intern(); //与stringPool4()示例相比,注意s3.intern()在代码中行位置的变化
        /**
         * 字符串池中存在该字面值的引用，则直接返回给s4，因此s4实际指向s3的引用，也就是s3,s4,intern3三者指向同一个引用
         */
        String s4 = "hellohello";
        System.out.println("s3 == s4 : " + (s3 == s4)); //true
        System.out.println("intern3 == s3 : " + (intern3 == s3)); //true
        System.out.println("intern3 == s4 : " + (intern3 == s4)); //true
	}
	
	public static void stringPool4() {
		/**
		 * 存在字符串+拼接，那么可以断定其编译优化后的代码是：String s3 = new StringBuilder().append(new String("hello")).append(new String("hello")).toString();
		 * 由于toString()方法最终调用的是new String("hellohello")，但是这是运行时发生的，相比于声明时(String s1 = new String("hellohello"))，编译器管不了运行时的优化，
		 * 故此处s3虽然等效于new String("hellohello")，但是并不会在字符串常量池中放一份"hellohello"对象
		 */
		String s3 = new String("hello") + new String("hello");
		/**
		 * 发现字符串常量池中没有该字面量，创建并返回该引用
		 */
        String s4 = "hellohello";
        /**
         * 字符串池中存在该字面量字符串，则返回其引用给intern3
         */
        String intern3 = s3.intern(); //与stringPool3()示例相比,注意s3.intern()在代码中行位置的变化
        System.out.println("s3 == s4 : " + (s3 == s4)); //false
        System.out.println("intern3 == s3 : " + (intern3 == s3)); //false
        System.out.println("intern3 == s4 : " + (intern3 == s4)); //true
	}
	
	public static void main(String[] args) {
		//stringPool1();
		//stringPool2();
		//stringPool3();
		stringPool4();
	}

}
