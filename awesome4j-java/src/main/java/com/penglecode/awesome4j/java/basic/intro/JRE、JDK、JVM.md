#### JDK、JRE、JVM名词解释

- **JRE：**Java Runtime Environment（ java 运行时环境）。即java程序的运行时环境，包含了 java 虚拟机，java基础类库。

- **JDK：**Java Development Kit（ java 开发工具包）。即java语言编写的程序所需的开发工具包。JDK 包含了 JRE，同时还包括 java 源码的编译器 javac、监控工具 jconsole、分析工具 jvisualvm等。

- **JVM：**Java Virtual Machine（Java虚拟机）。实现跨平台的最核心的部分，.class 文件会在 JVM 上执行，JVM 会解释给操作系统执行，有自己的指令集，解释自己的指令集到 CPU 指令集和系统资源的调用。

#### JDK、JRE、JVM三者之间的关系

- JDK 是 JAVA 程序开发时用的开发工具包，包含 Java 运行环境 JRE。

- JDk、JRE 内部都包含 JAVA虚拟机 JVM。

- JVM 包含 Java 应用程序的类的解释器和类加载器等。