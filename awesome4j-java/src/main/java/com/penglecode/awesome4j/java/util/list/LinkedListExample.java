package com.penglecode.awesome4j.java.util.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * LinkedList经典示例
 */
public class LinkedListExample {

	/**
	 * 向列表中添加元素
	 */
	public static void add() {
		System.out.println("==========================add==========================");
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(1); //添加一个元素到列表的尾部
		System.out.println(list);
		
		list.addFirst(0); //添加一个元素到列表的头部
		System.out.println(list);
		
		list.addAll(Arrays.asList(2, 3, 4, 5, 6, 7, 8)); //添加一个集合到列表的尾部
		System.out.println(list);
		
		list.addLast(9); //添加一个元素到列表的尾部
		System.out.println(list);
	}
	
	/**
	 * 获取列表中元素
	 */
	public static void get() {
		System.out.println("==========================get==========================");
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		
		System.out.println(String.format("LinkedList#java.util.List.get(int index) = %s", list.get(1))); //按索引获取元素,不存在抛异常:IndexOutOfBoundsException
		System.out.println(list);
		System.out.println(String.format("LinkedList#java.util.Deque.getFirst() = %s", list.getFirst())); //获取Deque的头元素,不存在抛异常: NoSuchElementException
		System.out.println(list);
		System.out.println(String.format("LinkedList#java.util.Deque.getLast() = %s", list.getLast())); //获取Deque的尾元素,不存在抛异常: NoSuchElementException
		System.out.println(list);
		
		System.out.println(String.format("LinkedList#java.util.Deque.peekFirst() = %s", list.peekFirst())); //获取Deque的头元素,不存在返回null
		System.out.println(list);
		
		System.out.println(String.format("LinkedList#java.util.Deque.peekLast() = %s", list.peekLast())); //获取Deque的尾元素,不存在返回null
		System.out.println(list);
		
		System.out.println(String.format("LinkedList#java.util.Deque.element() = %s", list.element())); //获取Deque的头元素,不存在抛异常: NoSuchElementException,该方法等价于getFirst()
		System.out.println(list);
		
		System.out.println(String.format("LinkedList#java.util.Deque.peek() = %s", list.peek())); //获取Deque的尾元素,不存在返回null,该方法等价于peekFirst()
		System.out.println(list);
		
		System.out.println(String.format("LinkedList#java.util.Deque.pollFirst() = %s", list.pollFirst())); //获取并移除Deque的头元素,不存在返回null
		System.out.println(list);
		
		System.out.println(String.format("LinkedList#java.util.Deque.pollLast() = %s", list.pollLast())); //获取并移除Deque的尾元素,不存在返回null
		System.out.println(list);
		
		System.out.println(String.format("LinkedList#java.util.Deque.poll() = %s", list.poll())); //获取并移除Deque的头元素,不存在返回null,该方法等价于pollFirst()
		System.out.println(list);
	}
	
	/**
	 * 设置列表中的元素
	 */
	public static void set() {
		System.out.println("==========================get==========================");
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		
		System.out.println(String.format("LinkedList#java.util.List.set(int index, Object e) = %s", list.set(2, 10))); //设置索引index处的元素,不存则抛出异常: IndexOutOfBoundsException
		System.out.println(list);
	}
	
	/**
	 * 删除列表中的元素
	 */
	public static void remove() {
		System.out.println("==========================remove==========================");
		LinkedList<String> list = new LinkedList<>(Arrays.asList("java", "c++", "c", "go", "python", "groovy", "javascript", "ruby"));
		
		System.out.println(String.format("LinkedList#java.util.Deque.remove() = %s", list.remove())); //移除并返回Deque的头元素,不存在抛异常: NoSuchElementException
		System.out.println(list);
		
		System.out.println(String.format("LinkedList#java.util.List.remove(int index) = %s", list.remove(1))); //移除并返回指定索引处的元素,不存在抛异常: IndexOutOfBoundsException
		System.out.println(list);
		
		System.out.println(String.format("LinkedList#java.util.List|Deque.remove(Object e) = %s", list.remove("c"))); //移除指定元素
		System.out.println(list);
		
		System.out.println(String.format("LinkedList#java.util.List|Deque.removeFirst() = %s", list.removeFirst())); //移除并返回Deque的头元素,不存在抛异常: NoSuchElementException
		System.out.println(list);
		
		System.out.println(String.format("LinkedList#java.util.List|Deque.removeLast() = %s", list.removeLast())); //移除并返回Deque的尾元素,不存在抛异常: NoSuchElementException
		System.out.println(list);
	}
	
	/**
	 * 遍历列表
	 */
	public static void traverseList() {
		System.out.println("==========================traverse==========================");
		LinkedList<String> list = new LinkedList<>(Arrays.asList("java", "c++", "c", "go", "python", "groovy", "javascript", "ruby"));
		
		//for-each循环遍历
		System.out.println("==========================for-each循环遍历==========================");
		for(String s : list) {
			System.out.println(s);
		}
		
		//普通for循环遍历
		System.out.println("==========================普通for循环遍历==========================");
		for(int i = 0, len = list.size(); i < len; i++) {
			System.out.println(list.get(i));
		}
		
		//通过Iterator迭代器遍历
		System.out.println("==========================通过Iterator迭代器遍历==========================");
		for(Iterator<String> it = list.iterator(); it.hasNext(); ) {
			System.out.println(it.next());
		}
		
		//通过队列的poll()方法来遍历
		System.out.println("==========================通过队列的poll()方法来遍历==========================");
		String s = null;
		while((s = list.poll()) != null) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		//add();
		//get();
		//set();
		//remove();
		traverseList();
	}

}
