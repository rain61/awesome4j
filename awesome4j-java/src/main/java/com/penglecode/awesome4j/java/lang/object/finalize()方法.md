#### Object的finalize()方法

- 当这个对象不再被引用时，垃圾回收器(GC)在收集垃圾时就会调用这个方法，看起来就像是一个对象死亡之前的回调。

- 如果子类重写了Object.finalize()方法，finalize方法有可能会被触发，因为GC只在内存不足时才会进行垃圾回收，或者调用`System.gc()`来强制垃圾回收。

#### 示例代码

```java

public class ObjectFinalizeExample {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("invoke finalize");
	}

	public static void main(String[] args) throws Throwable {
		new ObjectFinalizeExample();
		System.gc(); //强制触发垃圾回收，从而调用了重写的finalize()方法输出: invoke finalize
	}

}

```