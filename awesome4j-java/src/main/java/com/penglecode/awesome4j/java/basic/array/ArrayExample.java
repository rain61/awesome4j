package com.penglecode.awesome4j.java.basic.array;

import java.util.Arrays;

@SuppressWarnings({"rawtypes", "unused"})
public class ArrayExample {
	
	public static void arrayDeclaration() {
		/**
		 * 合法的数组声明，必须指定数组长度，未明确指定数组元素则使用相应数据类型的默认值填充，
		 * 例如int类型用0填充，Object类型用null填充。
		 */
		int[] a = new int[10];
		//double[] b = new double[]; //不合法的数组声明，必须指定数组的长度
	}

	public static void arrayBasicInfo() throws Exception {
		Object array = null;
		Class arrayClass = null;
		
		array = new int[] {1, 2, 3, 4, 5};
		arrayClass =  array.getClass();
		System.out.println("数组的Class：" + arrayClass);
		System.out.println("数组的SuperClass：" + arrayClass.getSuperclass());
		System.out.println("数组的Class的声明字段个数：" + arrayClass.getDeclaredFields().length);
		System.out.println("数组的Class的声明方法个数：" + arrayClass.getDeclaredMethods().length);
		
		array = new String[] {"a", "b", "c", "d", "e"};
		arrayClass = array.getClass();
		System.out.println("数组的Class：" + arrayClass);
		System.out.println("数组的SuperClass：" + arrayClass.getSuperclass());
		System.out.println("数组的Class的声明字段个数：" + arrayClass.getDeclaredFields().length);
		System.out.println("数组的Class的声明方法个数：" + arrayClass.getDeclaredMethods().length);
	}
	
	public static void arrayLength() throws Exception {
		int[] a = new int[0];
		int l = a.length; //数组.length仅仅是一个语法糖，并不表示数组具有length属性字段，通过查看class字节码文件可知：数组.length是由jvm指令arraylength来获取的而非数组的length字段
	}
	
	/**
	 * @param      src      the source array. 源数组
	 * @param      srcPos   starting position in the source array. 源数组的起始位置
	 * @param      dest     the destination array. 目标数组
	 * @param      destPos  starting position in the destination data. 目标数组的起始位置
	 * @param      length   the number of array elements to be copied. 复制的长度
	 * public static native void arraycopy(Object src,int srcPos,Object dest, int destPos,int length);
	 */
	public static void systemArraycopy() {
		int[] src = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] dest1 = new int[15];
		int[] dest2 = new int[8];
		int[] dest3 = new int[5];
		
		/**
		 * 将整个src完全复制给dest1数组
		 * 注意: 如果复制长度length大于原数组的长度或者目标数组的长度小于复制长度length都会触发ArrayIndexOutOfBoundsException。
		 */
		System.arraycopy(src, 0, dest1, 0, Math.min(src.length, dest1.length));
		System.out.println("dest1 = " + Arrays.toString(dest1));
		
		/**
		 * 将整个src完全复制给dest2数组
		 */
		//System.arraycopy(src, 0, dest2, 0, src.length); //dest2的长度小于src.length，触发ArrayIndexOutOfBoundsException
		System.arraycopy(src, 0, dest2, 0, Math.min(src.length, dest2.length));
		System.out.println("dest2 = " + Arrays.toString(dest2));
		
		/**
		 * 从原数组的第5个元素开始复制
		 */
		System.arraycopy(src, 5, dest3, 0, Math.min(src.length, dest3.length));
		System.out.println("dest3 = " + Arrays.toString(dest3));
	}
	
	public static void main(String[] args) throws Exception {
		//arrayBasicInfo();
		systemArraycopy();
	}

}
