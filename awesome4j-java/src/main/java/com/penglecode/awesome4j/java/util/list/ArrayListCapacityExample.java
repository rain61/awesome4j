package com.penglecode.awesome4j.java.util.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ArrayList容量示例
 * 
 * 1、ArrayList初始容量为10
 * 2、当向ArrayList中添加元素时，会根据需要动态扩容，
 *    即：如果ArrayList.elementData剩余可存储空间不足以存储待添加元素时将会触发扩容，
 *    扩容大小至少是当前ArrayList.elementData的0.5倍(为什么是至少？当调用addAll()方法时大有可能出现扩容0.5倍仍不足以存储添加进来的新元素)。
 * 
 */
public class ArrayListCapacityExample {

	private static void printList(ArrayList<String> list, int size) throws Exception {
		System.out.println("--------------------------------" + size + "-------------------------------");
		Object[] elementData = getArrayListElementData(list);
		System.out.println(String.format("【%s】>>> list.size = %s, elementData.length = %s", size, list.size(), elementData.length));
		System.out.println(String.format("【%s】>>> list = %s, elementData = %s", size, list, Arrays.toString(elementData)));
	}
	
	private static Object[] getArrayListElementData(ArrayList<?> list) throws Exception {
		Field field = ArrayList.class.getDeclaredField("elementData");
		field.setAccessible(true);
		return (Object[]) field.get(list);
	}
	
	public static void main(String[] args) throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		printList(list, 0);
		
		for(int i = 0; i < 50; i++) {
			list.add(String.valueOf(i));
			printList(list, i);
		}
	}

}
