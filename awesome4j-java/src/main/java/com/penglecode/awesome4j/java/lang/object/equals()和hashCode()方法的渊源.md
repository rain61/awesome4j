#### equals()和hashCode()方法的渊源

- **equals(): **用来判断两个对象是否相同，在Object类中是通过判断对象间的内存地址来决定是否相同。
- **hashCode(): **获取哈希码，也称为散列码，返回一个int整数。这个哈希码的作用是确定该对象在哈希表中的索引位置。hashCode()方法设计初衷是为了哈希散列表(HashSet,HashMap等)的索引而设计，用于提升查询效率提高哈希表性能，因此hashCode()在散列表中才有用，在其它情况下基本没用。

#### equals()和hashCode()方法的协约

1. 两个对象用 equals() 比较返回true，那么两个对象的hashCode()方法必须返回相同的结果。

2. 两个对象用 equals() 比较返回false，不要求hashCode()方法也一定返回不同的值，但是最好返回不同值，以提搞哈希表性能。

3. 两个对象的hashCode()返回值相同，两对象不一定相同，还需要通过equals()再次判断。

4. 重写 equals() 方法，必须重写 hashCode() 方法，以保证 equals() 方法相等时两个对象 hashcode() 返回相同的值。

#### 总结

1. hashCode主要用于提升查询效率提高哈希表性能，来确定在散列结构中对象的存储地址。
2. 重写equals()必须重写hashCode()。
3. 哈希存储结构中，添加元素重复性校验的标准就是先检查hashCode值，后判断equals()。(第5点可以证明这一点)
4. 两个对象equals()相等，hashcode()必定相等。
5. 两个对象hashcode()不等，equals()必定也不等。
6. 两个对象hashcode()相等，对象不一定相等，需要通过equals()进一步判断。
