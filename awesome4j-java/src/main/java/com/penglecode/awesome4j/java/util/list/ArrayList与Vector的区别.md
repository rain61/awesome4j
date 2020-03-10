#### ArrayList与Vector的区别

- `ArrayList`和`Vector`底层都是基于Object数组存储的。因此两者具有随机快速访问的能力，检索速度快。

- `ArrayList`和`Vector`扩容机制有所不同，`ArrayList`每次扩容大小为当前size/2，`Vector`每次扩容大小可以在初始化new时指定，如果不指定则每次扩容大小为当前size，即成倍扩容。

- `ArrayList`和`Vector`最大的区别在于：`ArrayList`不是线程安全的性能高而`Vector`是线程安全的性能差，所以在不需要保证线程安全时建议使用`ArrayList`。