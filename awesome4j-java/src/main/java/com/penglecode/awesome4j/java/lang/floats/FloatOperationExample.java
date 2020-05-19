package com.penglecode.awesome4j.java.lang.floats;

/**
 * 浮点型运算面试题
 * https://blog.csdn.net/qq_22771739/article/details/82825536
 */
public class FloatOperationExample {

	public static void round1() {
		/**
		 * 此处由于浮点型运算导致的精度丢失，
		 * 正确结果应该是0.1，而实际因为运算时精度丢失变成了0.09999999999999998
		 * 所以此后的任何比较都是没有意义的，此处的运算应该使用BigDecimal来做
		 */
		Double d1 = 1.0 - 0.9;
		Double d2 = 0.1;
		System.out.println(d1); //0.09999999999999998
		System.out.println(d2); //0.1
		System.out.println(d1 == d2); //false
		System.out.println(d1.compareTo(d2)); //-1
	}
	
	/**
	 * 类型升级(type promotion)而丢失精度，比较结果是false
	 * 
	 * 首先，来看看Java中的几种原生的数值类型进行==或!=比较运算的时候会发生什么。
	 * 
	 * 如果运算符两边的数值类型不同，则首先会进行类型升级(type promotion)，规则如下：
	 * 
	 * 		1、如果运算符任意一方的类型为double，则另一方会转换为double
	 * 		2、否则，如果运算符任意一方的类型为float，则另一方会转换为float
	 * 		3、否则，如果运算符任意一方的类型为long，则另一方会转换为long
	 * 		4、否则，两边都会转换为int
	 * 
	 */
	public static void round2() {
		System.out.println(0.1d == 0.1f);
	}
	
	public static void round3() {
		Double a = Math.sqrt(-1.0);
		System.out.println(a);
		
		Double b = 0.0 / 0.0;
		System.out.println(b);
		
		Double c = 1.0 / 0.0;
		System.out.println(c);
		
		Double d = -1.0 / 0.0;
		System.out.println(d);
		
		Double f = b + 2.0;
		System.out.println(f);
		
		System.out.println("NaN equals NaN = " + a.equals(b));
		System.out.println("NaN compareTo NaN = " + a.compareTo(b));
	}
	
	public static void main(String[] args) {
		//round1();
		//round2();
		round3();
	}

}
