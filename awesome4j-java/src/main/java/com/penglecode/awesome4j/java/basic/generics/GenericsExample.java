package com.penglecode.awesome4j.java.basic.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * <? extends E> : 上限通配符，用来限制类型的上限，向下兼容子类及其子孙类
 * <? super E> : 下限通配符，用来限制类型的下限，向上兼容父类及其祖类
 * 
 * PECS原则总结
 * 从上述两方面的分析，总结PECS原则如下：
 * 
 * 如果要从集合中读取类型T的数据，并且不能写入，可以使用 ? extends 通配符；(Producer Extends)
 * 如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)
 * 如果既要存又要取，那么就不要使用任何通配符。
 * 
 * @author 	pengpeng
 * @date 	2020年4月3日 下午3:38:01
 */
public class GenericsExample {

	/**
	 * list能接受的元素最低为A或A的子类
	 */
	public static void extendsTest1(List<? extends A> list) {
		System.out.println("extendsTest1: " + list);
	}
	
	/**
	 * list能接受的元素最低为B或B的子类
	 */
	public static void extendsTest2(List<? extends B> list) {
		System.out.println("extendsTest2: " + list);
	}
	
	/**
	 * list能接受的元素最高为B或B的超类
	 */
	public static void superTest1(List<? super B> list) {
		System.out.println("superTest1: " + list);
	}
	
	/**
	 * list能接受的元素最高为C或C的超类
	 */
	public static void superTest2(List<? super C> list) {
		System.out.println("superTest2: " + list);
	}
	
	public static void main(String[] args) {
		List<A> listA = new ArrayList<>();
		List<B> listB = new ArrayList<>();
		List<C> listC = new ArrayList<>();
		List<D> listD = new ArrayList<>();
		
		extendsTest1(listA);
		extendsTest1(listB);
		extendsTest1(listC);
		extendsTest1(listD);
		
		//extendsTest2(listA); //编译报错
		extendsTest2(listB);
		extendsTest2(listC);
		extendsTest2(listD);
		
		superTest1(listA);
		superTest1(listB);
		//superTest1(listC); //编译报错
		//superTest1(listD); //编译报错
		
		superTest2(listA);
		superTest2(listB);
		superTest2(listC);
		//superTest2(listD); //编译报错
	}

	public static interface A {}
	
	public static class B implements A {}
	
	public static class C extends B {}
	
	public static class D extends C {};
	
}
