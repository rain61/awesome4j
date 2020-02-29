#### Java中对象clone的实现

- 实现Cloneable接口，这是一个标记接口，自身没有方法。

- 覆盖clone()方法，可见性提升为public。

- Object类的clone()方法默认是浅拷贝实现。