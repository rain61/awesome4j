package com.penglecode.awesome4j.java.basic.array;

import java.util.Arrays;

/**
 * java.util.Arrays的使用示例
 */
public class ArraysExample {

	public static void fill() {
		String[] array = new String[10];
		Arrays.fill(array, "a"); //使用某个值填充整个数组
		System.out.println(Arrays.toString(array));
		
		Arrays.fill(array, 3, 7, "b"); //使用某个值填充数组的某一段[fromIndex, toIndex)
		System.out.println(Arrays.toString(array));
	}
	
	public static void equals() {
		int[] a1 = new int[10];
		for(int i = 0; i < 10; i++) {
			a1[i] = i;
		}
		
		int[] a2 = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		/**
		 * 比较两个数组(一维数组，如果是多维数组请用deepEquals())的顺序内容是否相同(基本类型数组通过==比较,对象类型数组通过equals()方法比较)
		 */
		System.out.println(Arrays.equals(a1, a2)); //true
	}
	
	public static void deepEquals() {
		int[] a1 = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] a2 = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		Object[] oa1 = new Object[] {"a", "b", "c", a1};
		Object[] oa2 = new Object[] {"a", "b", "c", a2};
		
		System.out.println(Arrays.equals(a1, a2)); //true
		System.out.println(Arrays.equals(oa1, oa2)); //false
		/**
		 * 深度比较两个数组的顺序内容是否相同，与Arrays.equals()方法不同的是: Arrays.deepEquals()考虑到了数组嵌套(多维数组)的情况
		 */
		System.out.println(Arrays.deepEquals(oa1, oa2)); //true
	}
	
	public static void copyOf() {
		int[] a1 = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] a2 = Arrays.copyOf(a1, a1.length); //完全拷贝
		System.out.println("a1 = " + Arrays.toString(a1)); //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		System.out.println("a2 = " + Arrays.toString(a2)); //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		System.out.println(a1 == a2); //false
		System.out.println(Arrays.equals(a1, a2)); //true
		
		/**
		 * Arrays.copyOf()，从指定数组的起始位置(index=0)开始拷贝指定数组的副本，
		 * 根据所传newLength的大小来决定是截断或是扩展数组，当newLength > originalLength时将会以指定数组的类型默认值来扩展数组
		 */
		int[] a3 = Arrays.copyOf(a1, a1.length + 5); //扩展拷贝
		System.out.println("a3 = " + Arrays.toString(a3)); //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0]
		
		Integer[] a4 = new Integer[] {0, 1, 2, 3, 4, 5};
		Integer[] a5 = Arrays.copyOf(a4, 10);
		System.out.println("a5 = " + Arrays.toString(a5)); //[0, 1, 2, 3, 4, 5, null, null, null, null]
	}
	
	/**
	 * Java7以后，对应基本变量数组采用变异的快速排序方法DualPivotQuicksort，对于对象数组比较由原来的mergeSort改为ComparableTimSort方法，
	 * TimSort当数组大小小于32时，采用二分插入排序算法，当大于32时，采用基于块-区run的归并排序。所以TimSort是一种二分插入排序和归并排序的变种算法。
	 * 对对象进行排序，没有采用快速排序，是因为快速排序是不稳定的，而Timsort是稳定的。与其他合并排序一样，Timesrot是稳定的排序算法，最坏时间复杂度是O（n log n）。
	 * 在最坏情况下，Timsort算法需要的临时空间是n/2，在最好情况下，它只需要一个很小的临时存储空间。
	 */
	public static void sort() {
		int[] ia = new int[] {12, 115, 19, -23, 45, -101, 97, 50, 0};
		Arrays.sort(ia);
		System.out.println(Arrays.toString(ia));
		
		char[] ca = new char[] { 'J', 'a', 'v', 'E', 'O', 'd', 'W'};
		Arrays.sort(ca);
		System.out.println(Arrays.toString(ca));
		
		String[] sa = new String[] {"java", "j2se", "j2ee", "java.lang.String", "java.lang.Object", "java.lang.StringBuilder", "java.lang.StringBuffer"};
		Arrays.sort(sa);
		for(String s : sa) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		//fill();
		//equals();
		//deepEquals();
		//copyOf();
		sort();
	}

}
