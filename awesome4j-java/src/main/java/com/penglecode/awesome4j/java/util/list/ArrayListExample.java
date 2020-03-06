package com.penglecode.awesome4j.java.util.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * ArrayList经典示例
 */
public class ArrayListExample {

	private static Object[] getArrayListElementData(ArrayList<?> list) throws Exception {
		Field field = ArrayList.class.getDeclaredField("elementData");
		field.setAccessible(true);
		return (Object[]) field.get(list);
	}
	
	private static void printCapacity(ArrayList<String> list, int size) throws Exception {
		System.out.println("--------------------------------" + size + "-------------------------------");
		Object[] elementData = getArrayListElementData(list);
		System.out.println(String.format("【%s】>>> list.size = %s, elementData.length = %s", size, list.size(), elementData.length));
		System.out.println(String.format("【%s】>>> list = %s, elementData = %s", size, list, Arrays.toString(elementData)));
	}
	
	/**
	 * ArrayList扩容示例
	 * 
	 * 1、ArrayList初始容量为10
	 * 2、当向ArrayList中添加元素时，会根据需要动态扩容，
	 *    即：如果ArrayList.elementData剩余可存储空间不足以存储待添加元素时将会触发扩容，
	 *    扩容大小至少是当前ArrayList.elementData的0.5倍(为什么是至少？当调用addAll()方法时大有可能出现扩容0.5倍仍不足以存储添加进来的新元素)。
	 * 
	 */
	public static void expandCapacity() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		printCapacity(list, 0);
		
		for(int i = 1; i <= 50; i++) {
			list.add(String.valueOf(i));
			printCapacity(list, i);
		}
	}

	/**
	 * trimToSize：将此ArrayList实例的容量调整为列表的当前大小。应用程序可以使用此操作最小化ArrayList实例的存储。
	 */
	public static void trimToSize() throws Exception {
		ArrayList<String> list = new ArrayList<>(15);
		Object[] elementData = null;
		elementData = getArrayListElementData(list);
		System.out.println(String.format(">>> list.size = %s, elementData.length = %s", list.size(), elementData.length));
		System.out.println(String.format(">>> list = %s, elementData = %s", list, Arrays.toString(elementData)));
		
		list.addAll(Arrays.asList("1", "2", "3", "4", "5", "6"));
		
		elementData = getArrayListElementData(list);
		System.out.println(String.format(">>> list.size = %s, elementData.length = %s", list.size(), elementData.length));
		System.out.println(String.format(">>> list = %s, elementData = %s", list, Arrays.toString(elementData)));
		
		list.trimToSize(); //缩减ArrayList.elementData，即trim掉索引[size, elementData.length)处的null元素
		
		elementData = getArrayListElementData(list);
		System.out.println(String.format(">>> list.size = %s, elementData.length = %s", list.size(), elementData.length));
		System.out.println(String.format(">>> list = %s, elementData = %s", list, Arrays.toString(elementData)));
	}
	
	/**
	 * 遍历列表：
	 * 1、通过迭代器遍历
	 * 2、通过索引值遍历
	 * 3、for-each循环遍历
	 */
	public static void listTraverse() throws Exception {
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		
		System.out.println("--------------------通过迭代器遍历--------------------");
		//通过迭代器遍历
		Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        System.out.println("--------------------通过索引值遍历--------------------");
		//通过索引值遍历
        for(int i = 0, len = list.size(); i < len; i++) {
        	System.out.println(list.get(i));
        }
        
        System.out.println("--------------------for-each循环遍历--------------------");
		//for-each循环遍历
        for(Integer i : list) {
        	System.out.println(i);
        }
        
	}
	
	/**
	 * 列表元素添加/删除
	 */
	public static void listAddAndRemove() throws Exception {
		List<String> list = new ArrayList<>();
		
		System.out.println("------------add-----------");
		
		list.addAll(Arrays.asList("1", "2", "3", "4", "5", "6"));
		System.out.println(list);
		
		list.add(null);
		System.out.println(list);
		
		list.add(3, null);
		System.out.println(list);
		
		list.addAll(6, Arrays.asList("a", "b", "c", "d", "e"));
		System.out.println(list);
		
		System.out.println("------------remove-----------");
		
		list.remove("6"); //从列表中删除第一个出现的指定元素
		System.out.println(list);
		
		list.remove(5);
		System.out.println(list);
		
		list.removeIf(item -> Objects.isNull(item)); //删除符合条件的元素
		System.out.println(list);
		
	}
	
	public static void toArray() throws Exception {
		List<String> list = new ArrayList<>();
		
		list.addAll(Arrays.asList("java", "c++", "go", "erlang", "python"));
		
		Object[] array1 = list.toArray();
		System.out.println(Arrays.toString(array1));
		
		String[] array2 = list.toArray(new String[0]);
		System.out.println(Arrays.toString(array2));
		
		String[] array3 = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(array3));
		
		String[] array4 = list.toArray(new String[10]);
		System.out.println(Arrays.toString(array4));
	}

	public static void main(String[] args) throws Exception {
		//expandCapacity();
		//trimToSize();
		//listTraverse();
		//listAddAndRemove();
		toArray();
	}
	
}
