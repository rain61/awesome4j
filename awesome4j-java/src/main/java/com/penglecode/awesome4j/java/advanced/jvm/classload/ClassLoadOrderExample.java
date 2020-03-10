package com.penglecode.awesome4j.java.advanced.jvm.classload;

/**
 * 1.1、一个类中的初始化顺序
 * 
 * 类内容（静态变量、静态初始化块【它俩之间按本类中的声明顺序】） => 实例内容（变量、初始化块【它俩之间按本类中的声明顺序】、构造器）
 * 
 * 1.2、两个具有继承关系类的初始化顺序
 * 
 * 父类的（静态变量、静态初始化块【它俩之间按本类中的声明顺序】）=> 子类的（静态变量、静态初始化块【它俩之间按本类中的声明顺序】）=> 父类的（变量、初始化块【它俩之间按本类中的声明顺序】、构造器）=> 子类的（变量、初始化块【它俩之间按本类中的声明顺序】、构造器）  
 */
@SuppressWarnings("unused")
public class ClassLoadOrderExample extends Father {
    
	private int i = test();

    static {
        System.out.println("(6)");
    }
    
    private static int j = method();

    ClassLoadOrderExample(){
        System.out.println("(7)");
    }

    //非静态代码块
    {
        System.out.println("(8)");
    }

    //非静态方法
    public int test(){
        System.out.println("(9)");
        return 0;
    }

    //静态方法
    public static int method(){
        System.out.println("(10)");
        return 0;
    }

    //main方法
    public static void main(String[] args) {
    	/**
    	 * 输出：
    	 * (1)
    	 * (5)
    	 * (6)
    	 * (10)
    	 * (3)
    	 * (9) //因为子类重写了父类的方法，所以此处为(9)
    	 * (2)
    	 * (9)
    	 * (8)
    	 * (7)
    	 */
    	new ClassLoadOrderExample();
    }
}

@SuppressWarnings("unused")
class Father {
    //静态代码块
    static {
        System.out.println("(1)");
    }
    
    private static int j = method();

    //构造器
    Father(){
        System.out.println("(2)");
    }

    //非静态代码块
    {
        System.out.println("(3)");
    }

    //public 非静态方法
    public int test() {
        System.out.println("(4)");
        return 0;
    }

    private int i = test();
    
    //public 静态方法
    public static int method() {
        System.out.println("(5)");
        return 0;
    }
}