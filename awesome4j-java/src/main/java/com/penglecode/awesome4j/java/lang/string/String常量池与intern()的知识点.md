#### 1.String常量池位置在哪？

在Java1.6版本中，String常量池是在方法区中的运行时常量池。在Java1.6版本以后，String常量池移到了Java heap(堆)中。

- java7之前，方法区位于永久代(PermGen)，永久代和堆相互隔离，永久代的大小在启动JVM时可以设置一个固定值，不可变；例如 ：PermSize 和 -XX:MaxPermSize

- java7中，存储在永久代的部分数据就已经转移到Java Heap或者Native memory。但永久代仍存在于JDK 1.7中，并没有完全移除，譬如符号引用(Symbols)转移到了native memory；字符串常量池(interned strings)转移到了Java heap；类的静态变量(class statics)转移到了Java heap。

- java8中，取消永久代， 其余的数据作为元数据存储在元空间中存放于元空间(Metaspace)， 元空间是一块与堆不相连的本地内存。（ 元数据是数据的数据或者叫做用来描述数据的数据或者叫做信息的信息。（比如原本方法区存储的类信息、即时编译器编译后的代码等），也可以把元数据简单的理解成，最小的数据单位。元数据可以为数据说明其元素或属性（名称、大小、数据类型、等），或其结构（长度、字段、数据列），或其相关数据（位于何处、如何联系、拥有者）。）

- 那方法区，永久代，元空间这三者之间又是怎样的逻辑关系？  

	首先方法区是java虚拟机规范中定义的区域具体如何实现没有规定，每个虚拟机可以自由实现。
	
	拿hotspot实现来说，在jdk7、8之前会在虚拟机内存中划分一块区域用于存储编译后的类字节码信息、类的静态变量等，称之为永久代，作为方法区的实现。
	
	从jdk8开始，已经移除了永久代的实现，但是方法区还在，原本永久代中储存的类的元数据将储存在元空间中，而类的静态变量和常量池放在java堆中，元空间是对方法区的一种实现，只不过他使用的不是虚拟机内存而是本地内存
	
#### 2.String类的intern()方法

String类的intern()方法:一个初始为空的字符串池，它由类String独自维护。当调用 intern方法时，如果池已经包含一个等于此String对象的字符串（用equals(oject)方法确定），则返回池中的字符串。否则，将此String对象添加到池中，并返回此String对象的引用。 对于任意两个字符串s和t，当且仅当s.equals(t)为true时，s.intern() == t.intern()才为true。**所有字面值字符串和字符串赋值常量表达式都使用 intern方法进行操作。**

##### 2.1为什么要介绍intern()方法

intern()方法设计的初衷，就是重用String对象，以节省内存消耗。

使用了intern()方法后程序运行时间有所增加。这是因为程序中每次都是用了new String后又进行intern()操作的耗时时间，但是不使用intern()占用内存空间导致GC的时间是要远远大于这点时间的。

##### 2.2深入认识intern()方法

JDK1.6以后，常量池被放入到堆空间中，导致intern()函数的功能不同,下面代码以jdk1.8为例分析：

1. 字面量创建对象方式：

示例1

```java

String s1 = "abc"; //常量池中添加"abc"对象，返回引用地址给s1对象
String s2 = "abc"; //通过equals()方法判断常量池中已有值为abc的对象，返回相同的引用给s2
System.out.println(s1 == s2); //所以s1 == s2为true

```

2. new 创建对象的方式：

示例2

```java

String s1 = new String("abc"); //在常量池中添加"abc"对象，在堆中创建字面值为"abc"的引用对象s1，且s1.value引用自常量池中"abc"对象.value
String s2 = new String("abc"); //常量池中已有值为"abc"的对象，不做处理，在堆中创建值为"abc"的引用对象s2，且s2.value引用自常量池中"abc"对象.value
System.out.println(s1==s2); //s1,s2是分别new出来的，肯定为false

```

3.intern()涉入的比较：

示例3

```java

String s1 = new String("abc"); //在常量池中添加"abc"对象，在堆中创建字面值为"abc"的引用对象s1，且s1.value引用自常量池中"abc"对象.value
String intern = s1.intern();  //常量池中已有"abc"，返回常量池中"abc"的引用
String s2 = "abc";  //常量池中已有"abc"，返回常量池中"abc"的引用
System.out.println(s2 == intern);//true  两者返回的都是常量池中"abc"的引用
System.out.println(s1 == intern);//false  堆引用地址和常量池引用地址不是一回事(不是一个地址)

```

4.两个String类型对象相加：

示例4.1

```java

/**
 * 存在字符串+拼接，那么可以断定其编译优化后的代码是：String s3 = new StringBuilder().append(new String("hello")).append(new String("hello")).toString();
 * 由于toString()方法最终调用的是new String("hellohello")，但是这是运行时发生的，相比于声明时(String s1 = new String("hellohello"))，编译器管不了运行时的优化，
 * 故此处s3虽然等效于new String("hellohello")，但是并不会在字符串常量池中放一份"hellohello"对象
 */
String s3 = new String("hello") + new String("hello");
/**
 * 调用s3.intern()方法，发现字符串池中不存在该串，则将s3的引用指向常量池中而不是复制一份该字面值放入字符串池中，因此intern3实际指向s3的引用
 */
String intern3 = s3.intern(); //与下面示例相比,注意s3.intern()在代码中行位置的变化
/**
 * 字符串池中存在该字面值的引用，则直接返回给s4，因此s4实际指向s3的引用，也就是s3,s4,intern3三者指向同一个引用
 */
String s4 = "hellohello";
System.out.println("s3 == s4 : " + (s3 == s4)); //true
System.out.println("intern3 == s3 : " + (intern3 == s3)); //true
System.out.println("intern3 == s4 : " + (intern3 == s4)); //true

```

示例4.2

```java

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
String intern3 = s3.intern(); //与上面示例相比,注意s3.intern()在代码中行位置的变化
System.out.println("s3 == s4 : " + (s3 == s4)); //false
System.out.println("intern3 == s3 : " + (intern3 == s3)); //false
System.out.println("intern3 == s4 : " + (intern3 == s4)); //true

```

#### 3.String常量池里存的是对象还是引用？

综上所述可以得出结论：

- 可能是对象，如示例1中的s1。
- 也可能是引用，如示例4所示中的s3。

#### 4.小结

- String str0 = "abc"; //声明时，产生编译优化，直接在字符串池中创建"abc"字符串对象并将其引用指向str0

- String str1 = new String("abc"); //声明时，且String构造器传入的是常量，那么就会触发编译优化：生成堆中str1的引用对象，以及字符串池中的"abc"字符串对象

- String str2 = new String(s1); //声明时，但String构造器传入的是变量，不会触发编译优化，运行时仅在堆中生成相应字面值的字符串对象！此时若再调用str2.intern()方法，那么则将str2的引用指向常量池中而不是复制一份该字面值放入字符串池中
