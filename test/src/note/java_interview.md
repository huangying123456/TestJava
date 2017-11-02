---
title: Java Interview
date: 2017-10-23 13:18:00
## 摘要
Note For Java Interview
<!--more-->

# 基础知识部分
## switch语句能否作用在byte上，能否作用在long上，能否作用在String上?
switch能作用在byte、char、short和int上，JDK1.7后可以作用在String上。

## "=="和equals方法究竟有什么区别？
==和equals都可以比较地址。==是运算符，equals是方法，方法可以通过重写改变其行为，如String的equals就是比较字符串内容。
 
## 构造方法能否被重写和重载？
构造方法不能被重写但是能被重载。
 
## 面向对象的特征有哪些？
封装、继承、多态和抽象。

## 抽象类和接口的区别？
- 抽象类是abstract class修饰，接口是interface修饰。
- 抽象类可以有任意类型的属性，接口只能有静态常量修饰的属性。
- 抽象类可以有普通方法和抽象法方法，接口的方法都是抽象方法。
- 抽象类和接口都不能实例化，但是抽象类有构造方法，接口没有构造方法。
- 抽象类只能单根继承，接口可以多重实现。
 
## 内部类可以引用它的包含类的成员吗？有没有什么限制？ 
可以引用。如果需要指定当前类时要用外部类.this来引用。如果引用局部变量，需要将局部变量指定为final。
 
## String s = new String("xyz");创建了几个String Object? 二者之间有什么区别？
2个对象。"xyz"创建在字符串常量池中，new String()创建在堆中。
 
## try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会在return前执行。
 
## Integer与int的区别
Integer为包装类，int是基本数据类型。包装类拥有方法和属性，基本数据类型不具备。包装类可以通过intValue来转换成基本数据类型，也可以通过new Integer()将基本数据类型转换为包装类。在JDK1.5后，包装类和基本数据类型可以实现自动转换。
 
## sleep()和wait()有什么区别?
- sleep是Thread类的方法，wait是Object类的方法。
- sleep是自动唤醒，wait需要其他线程来唤醒。
- sleep不会释放同步锁，wait会释放同步锁。
- sleep可以用在任意方法中，wait只能用在同步方法或同步块中。
 
## java中有几种类型的流？JDK为每种类型的流提供了一些抽象类以供继承，请说出他们分别是哪些类？
java中有三种流，分别是字节流（InputStream、OutputStream）、字符流（Reader、Writer）、对象流（ObjectInputStream、ObjectOutputStream）。
 
## 字节流与字符流的区别？
字节流用于读取或写出二进制数据，比如图片、影像等数据。
字符流用于读取或写出字符数据，比如传输字符串。
所有的数据都可以通过字节流来进行处理，不过如果是字符数据，用字节流还需要进行转换后传输，如果使用字符流可以方便数据的转换。
 
## error和exception有什么区别?
error是系统错误，代码不能处理的错误，比如内存溢出、堆栈溢出等。
exception是程序异常，可以通过代码try-catch进行处理，比如空指针异常，数组越界等。
 
## 谈谈final,finally,finalize的区别？
final是修饰符，可以修饰类（不能被继承）、属性（常量）、和方法（不能被重写）。
finally是异常处理块中的代码块，表示无论如何都会执行的代码块。
finalize是Object类的方法，该方法在对象被垃圾回收之前执行的方法。
 
## 当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递?
java中只有值传递，如果传递的对象，实际也是传递该对象的地址。
 
## 作用域public,private,protected,以及不写时的区别
public公共修饰符，表示任意类都可以访问。
protected为受保护的修饰符，表示同类、同包以及不同包但是父子关系的是可以访问。
不写表示默认修饰符，或者称为package修饰符，该修饰符表示只有同类或同包下的类可以访问，出了这个包就不能访问了。
private为私有修饰符，表示只有同类中可以访问，出了这个类就不能访问了。
 
## 用最有效率的方法算出2乘以8等於几 2《 3
将2的二进制向左移3位。java中用<<来移位。
 
## heap和stack有什么区别。
heap表示堆，stack表示栈。堆中放对象，栈中放引用变量。
堆空间是一个无序的空间，栈是先进后出的结构。
 
## 运行时异常与一般异常有何异
运行时异常是指继承于RuntimeException的异常，这些异常在编译时可以不进行处理，当运行时如果出现问题才会抛出。如NullPointException、ArrayIndexOutOfBoundsException
一般异常也称为编译时异常，这些异常是继承Exception但又不属于RuntimeException的子类，如果程序中出现这些异常，在编译时必须进行捕获或抛出，否则编译无法通过。如IOException、FileNotFoundException
 
## 是否可以从一个static方法内部发出对非static方法的调用？
不能，除非先创建非static方法所在类的对象。
 
## 什么是java序列化，如何实现java序列化？
使用serializable关键字 使用一个输出流构造一个对象流流对象 然后使用对象流对象的writeObject（）就可以将参数为obj的对象写出
 
## Anonymous Inner Class(匿名内部类)是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)？
匿名内部类可以继承类或实现接口，但不是显示的使用extends或implements来继承或实现。
 
## ArrayList和Vector的区别,HashMap和Hashtable的区别？
ArrayList是JDK1.2的集合类并且线程不安全，Vector是1.0的集合类并且线程安全，二者用法类似。
HashMap线程不安全且能放空键或空值，Hashtable线程安全且不能放空键或空值。
 
## String 和StringBuffer有什么差别？在什么情况下使用它们？
String字符串的基本类，该字符串是不可变的。StringBuffer是利用堆来存储字符串，并且可以对字符串的内容进行改变。
 
## new一个类对象和使用类名创建一个对象有什么区别？二者使用时应该注意什么？
new对象是最常见的创建对象的方式，利用类模板是通过反射来创建对象。虽然new对象时在底层也会通过类模板来创建对象，但是new对象的效率要比直接通过类模板创建对象的方式要高。
但是使用类模板的方式可以让程序的灵活性提高。
 
## LinkedList和ArrayList的区别？
- LinkedList是链表结构的集合，ArrayList数组结构的集合。
- LinkedList在中间或前面增加或删除数据时效率比ArrayList高。
- LinkedList在最后添加或删除数据时效率比ArrayList低。
- 遍历数据时ArrayList效率高于LinkedList。
 
## 介绍JAVA开发中常用的Collection FrameWork（集合框架）?
Java中集合框架分为Collection和Map接口，Collection接口下的集合每个元素都由一个值组成，Map接口下的集合类每个元素都是由键值对组成。
Collection接口下面有List和Set接口，List接口下常见的类有ArrayList、LinkedList、Vector。它们中的元素可以重复，并且是有序的。Set接口下常见的类有HashSet、TreeSet。它们中的元素不能重复，并且是无序的。
 
## 在异常当中 throw和throws 有什么区别和联系？
throw是在代码中抛出一个异常，后面跟的是异常对象，虚拟机运行到这里时会立即引发一个异常。
throws是写在方法声明上的，表示声明该方法可能会抛出异常，后面跟的是异常类型。调用该方法的时候可以选择处理它或继续往外抛。
 
## 重载和重写的区别
重载是指在一个类中，两个或两个以上的方法具有相同方法名和不同参数列表，则表示这些方法为重载方法。
重写是指在父类和子类中，子类的方法和父类的方法具有相同方法名、相同参数列表、相同返回类型、子类的访问修饰符范围不小于父类的访问修饰符范围，异常的类型和个数不大于或多于父类的异常类型和个数，则表示该方法为重写方法。换句话说重载方法是区分同一个类中相同方法名的方法，重写方法是找到父类相同方法名的方法并重新改变方法的行为。

## 了解Java四种引用方式
JDK 1.2版本开始，把对象的引用分为4种级别，从而使程序能更加灵活地控制对象的生命周期。这4种级别由高到低依次为：强引用、软引用、弱引用和虚引用。
### 强引用（StrongReference）
强引用是使用最普遍的引用。如果一个对象具有强引用，那垃圾回收器绝不会回收它。当内存空间不足，Java虚拟机宁愿抛出OutOfMemoryError错误，使程序异常终止，也不会靠随意回收具有强引用的对象来解决内存不足的问题。
 
### 软引用（SoftReference）
如果一个对象只具有软引用，则内存空间足够，垃圾回收器就不会回收它；如果内存空间不足了，就会回收这些对象的内存。只要垃圾回收器没有回收它，该对象就可以被程序使用。软引用可用来实现内存敏感的高速缓存。
 
### 弱引用（WeakReference）
在垃圾回收器线程扫描它所管辖的内存区域的过程中，一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。不过，由于垃圾回收器是一个优先级很低的线程，因此不一定会很快发现那些只具有弱引用的对象。
 
### 虚引用（PhantomReference）
顾名思义，就是形同虚设。与其他几种引用都不同，虚引用并不会决定对象的生命周期。如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收器回收。
了解并熟练掌握这4中引用方式，选择合适的对象应用方式，对内存的回收是很有帮助的。

## String,StringBuffer, StringBuilder 的区别是什么？String为什么是不可变的？
- String是字符串常量，StringBuffer和StringBuilder都是字符串变量。后两者的字符内容可变，而前者创建后内容不可变。
- String不可变是因为在JDK中String类被声明为一个final类。
- StringBuffer是线程安全的，而StringBuilder是非线程安全的。
- 线程安全会带来额外的系统开销，所以StringBuilder的效率比StringBuffer高。如果对系统中的线程是否安全很掌握，可用StringBuffer，在线程不安全处加上关键字Synchronize。

## Vector,ArrayList, LinkedList的区别是什么？
- Vector、ArrayList都是以类似数组的形式存储在内存中，LinkedList则以链表的形式进行存储。
- List中的元素有序、允许有重复的元素，Set中的元素无序、不允许有重复元素。
- Vector线程同步，ArrayList、LinkedList线程不同步。
- LinkedList适合指定位置插入、删除操作，不适合查找；ArrayList、Vector适合查找，不适合指定位置的插入、删除操作。
- ArrayList在元素填满容器时会自动扩充容器大小的50%，而Vector则是100%，因此ArrayList更节省空间。

## HashTable, HashMap，TreeMap区别？
- HashTable线程同步，HashMap非线程同步。
- HashTable不允许<键,值>有空值，HashMap允许<键,值>有空值。
- HashTable使用Enumeration，HashMap使用Iterator。
- HashTable中hash数组的默认大小是11，增加方式的old*2+1，HashMap中hash数组的默认大小是16，增长方式一定是2的指数倍。
- TreeMap能够把它保存的记录根据键排序，默认是按升序排序。

## Statement与PreparedStatement的区别,什么是SQL注入，如何防止SQL注入
- PreparedStatement支持动态设置参数，Statement不支持。
- PreparedStatement可避免如类似 单引号 的编码麻烦，Statement不可以。
- PreparedStatement支持预编译，Statement不支持。
- 在sql语句出错时PreparedStatement不易检查，而Statement则更便于查错。
- PreparedStatement可防止Sql助于，更加安全，而Statement不行。
 
## 什么是SQL注入：
通过sql语句的拼接达到无参数查询数据库数据目的的方法。
如将要执行的sql语句为 select * from table where name = "+appName+"，利用appName参数值的输入，来生成恶意的sql语句，如将['or'1'='1']  传入可在数据库中执行。
因此可以采用PrepareStatement来避免Sql注入，在服务器端接收参数数据后，进行验证，此时PrepareStatement会自动检测，而Statement不行，需要手工检测。

## 一个对象（两个属性，四个方法）实例化100次，现在内存中的存储状态，几个对象，几个属性，几个方法。
由于JAVA中new出来的对象都是放在堆中，所以如果要实例化100次，将在堆中产生100个对象，一般对象与其中的属性、方法都属于一个整体，但如果属性和方法是静态的，就是用static关键字声明的，那么属于类的属性和方法永远只在内存中存在一份。

## 反射的概念
反射机制的定义：
是在运行状态中，对于任意的一个类，都能够知道这个类的所有属性和方法，对任意一个对象都能够通过反射机制调用一个类的任意方法，这种动态获取类信息及动态调用类对象方法的功能称为java的反射机制。
反射的作用：

- 动态地创建类的实例，将类绑定到现有的对象中，或从现有的对象中获取类型。
- 应用程序需要在运行时从某个特定的程序集中载入一个特定的类

## DB中索引原理，种类，使用索引的好处和问题是什么？ 
经常需要修改的表不易对改变建立索引，因为数据库对索引进行维护需要额外的开销。对经常需要查询的大数据表需要建立索引，这样会增加查询的效率。
索引的原理：没有找到合适的答案。
索引的种类：B*Tree、反向索引、降序索引、位图索引、函数索引。

## Java如何遍历Map
### 方法一：在for-each循环中使用entries来遍历
这是最常见的并且在大多数情况下也是最可取的遍历方式。在键值都需要时使用。
```java
Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
  
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {  
  
    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
  
}  
```

注意：for-each循环在java 5中被引入所以该方法只能应用于java 5或更高的版本中。如果你遍历的是一个空的map对象，for-each循环将抛出NullPointerException，因此在遍历前你总是应该检查空引用。
 
### 方法二:在for-each循环中遍历keys或values。
如果只需要map中的键或者值，你可以通过keySet或values来实现遍历，而不是用entrySet。
```java
Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
  
//遍历map中的键  
  
for (Integer key : map.keySet()) {  
  
    System.out.println("Key = " + key);  
  
}  

//遍历map中的值  
  
for (Integer value : map.values()) {  
  
    System.out.println("Value = " + value);  
  
}  
```

该方法比entrySet遍历在性能上稍好（快了10%），而且代码更加干净。
 
### 方法三:使用Iterator遍历
使用泛型：
```java
Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
  
Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();  
  
while (entries.hasNext()) {  
  
    Map.Entry<Integer, Integer> entry = entries.next();  
  
    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
  
}  
```

不使用泛型：
```java
Map map = new HashMap();  
  
Iterator entries = map.entrySet().iterator();  
  
while (entries.hasNext()) {  
  
    Map.Entry entry = (Map.Entry) entries.next();  
  
    Integer key = (Integer)entry.getKey();  
  
    Integer value = (Integer)entry.getValue();  
  
    System.out.println("Key = " + key + ", Value = " + value);  
  
}  
```

你也可以在keySet和values上应用同样的方法。
该种方式看起来冗余却有其优点所在。首先，在老版本java中这是惟一遍历map的方式。另一个好处是，你可以在遍历时调用iterator.remove()来删除entries，另两个方法则不能。根据javadoc的说明，如果在for-each遍历中尝试使用此方法，结果是不可预测的。
从性能方面看，该方法类同于for-each遍历（即方法二）的性能。
 
### 方法四:通过键找值遍历（效率低）
```java
Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
  
for (Integer key : map.keySet()) {  
  
    Integer value = map.get(key);  
  
    System.out.println("Key = " + key + ", Value = " + value);  
  
}  
```

作为方法一的替代，这个代码看上去更加干净；但实际上它相当慢且无效率。因为从键取值是耗时的操作（与方法一相比，在不同的Map实现中该方法慢了20%~200%）。如果你安装了FindBugs，它会做出检查并警告你关于哪些是低效率的遍历。所以尽量避免使用。
 
总结
如果仅需要键(keys)或值(values)使用方法二。如果你使用的语言版本低于java 5，或是打算在遍历时删除entries，必须使用方法三。否则使用方法一(键值都要)。

## 阻塞了应该怎么办？
### sleep（）方法： 
sleep（）允许指定以毫秒为单位的一段时间作为参数，它使得线程在指定的时间内进入阻塞状态，不能得到CPU 时间，指定的时间一过，线程重新进入可执行状态。典型地，sleep（）被用在等待某个资源就绪的情形：测试发现条件不满足后，让线程阻塞一段时间后重新测试，直到条件满足为止。 
　　
### suspend（）和 resume（）方法： 
两个方法配套使用，suspend（）使得线程进入阻塞状态，并且不会自动恢复，必须其对应的resume（）被调用，才能使得线程重新进入可执行状态。典型地，suspend（）和 resume（）被用在等待另一个线程产生的结果的情形：测试发现结果还没有产生后，让线程阻塞，另一个线程产生了结果后，调用 resume（）使其恢复。
### yield（）方法： 
yield（）使得线程放弃当前分得的CPU时间，但是不使线程阻塞，即线程仍处于可执行状态，随时可能再次分得 CPU 时间。调用 yield（）的效果等价于调度程序认为该Java线程同步已执行了足够的时间从而转到另一个线程。
### wait（）和 notify（）方法： 
两个方法配套使用，wait（）使得线程进入阻塞状态，它有两种形式，一种允许指定以毫秒为单位的一段时间作为参数，另一种没有参数，前者当对应的 notify（）被调用或者超出指定时间时Java线程同步重新进入可执行状态，后者则必须对应的 notify（）被调用。 
初看起来它们与 suspend（）和 resume（）方法对没有什么分别，但是事实上它们是截然不同的。区别的核心在于，前面叙述的所有方法，阻塞时都不会释放占用的锁（如果占用了的话），而这一对方法则相反。

## 数据库索引
我们通过一个简单的例子来开始教程，解释为什么我们需要数据库索引。假设我们有一个数据库表 Employee， 这个表有三个字段（列）分别是 Employee_Name、Employee_Age 和Employee_Address。假设表Employee 有上千行数据。 
现在假设我们要从这个表中查找出所有名字是‘Jesus’的雇员信息。我们决定使用下面的查询语句：
SELECT * FROM Employee  WHERE Employee_Name = 'Jesus' 
如果表中没有所以会发生什么？
一旦我们运行这个查询，在查找名字为Jesus的雇员的过程中，究竟会发生什么？数据库不得不Employee表中的每一行并确定雇员的名字（Employee_Name）是否为 ‘Jesus’。由于我们想要得到每一个名字为Jesus的雇员信息，在查询到第一个符合条件的行后，不能停止查询，因为可能还有其他符合条件的行。所以，必须一行一行的查找直到最后一行-这就意味数据库不得不检查上千行数据才能找到所以名字为Jesus的雇员。这就是所谓的全表扫描。
### 数据库索引是怎样提升性能的？
你可能会想为如此简单的事情做全表扫描效率欠佳-数据库是不是应该更聪明一点呢？这就像用人眼从头到尾浏览整张表-很慢也不优雅（原文：not at all sleek，不知如何翻译才好）。但是，你可以能根据文章标题已经猜到，这就是索引派上用场的时候。使用索引的全部意义就是通过缩小一张表中需要查询的记录/行的数目来加快搜索的速度。
### 什么是索引？
一个索引是存储的表中一个特定列的值数据结构（最常见的是B-Tree）。索引是在表的列上创建。所以，要记住的关键点是索引包含一个表中列的值，并且这些值存储在一个数据结构中。请记住记住这一点：索引是一种数据结构 。
### 什么样的数据结构可以作为索引？
B-Tree 是最常用的用于索引的数据结构。因为它们是时间复杂度低， 查找、删除、插入操作都可以可以在对数时间内完成。另外一个重要原因存储在B-Tree中的数据是有序的。数据库管理系统（RDBMS）通常决定索引应该用哪些数据结构。但是，在某些情况下，你在创建索引时可以指定索引要使用的数据结构。
### 哈希表索引是怎么工作的？
哈希表是另外一种你可能看到用作索引的数据结构-这些索引通常被称为哈希索引。使用哈希索引的原因是，在寻找值时哈希表效率极高。所以，如果使用哈希索引，对于比较字符串是否相等的查询能够极快的检索出的值。例如之前我们讨论过的这个查询(SELECT * FROM Employee WHERE Employee_Name = ‘Jesus’) 就可以受益于创建在Employee_Name 列上的哈希索引。哈系索引的工作方式是将列的值作为索引的键值（key），和键值相对应实际的值（value）是指向该表中相应行的指针。因为哈希表基本上可以看作是关联数组，一个典型的数据项就像“Jesus => 0x28939″，而0x28939是对内存中表中包含Jesus这一行的引用。在哈系索引的中查询一个像“Jesus”这样的值，并得到对应行的在内存中的引用，明显要比扫描全表获得值为“Jesus”的行的方式快很多。
### 哈希索引的缺点
哈希表是无顺的数据结构，对于很多类型的查询语句哈希索引都无能为力。举例来说，假如你想要找出所有小于40岁的员工。你怎么使用使用哈希索引进行查询？这不可行，因为哈希表只适合查询键值对-也就是说查询相等的查询（例：like “WHERE name = ‘Jesus’）。哈希表的键值映射也暗示其键的存储是无序的。这就是为什么哈希索引通常不是数据库索引的默认数据结构-因为在作为索引的数据结构时，其不像B-Tree那么灵活
### 还有什么其他类型的索引？
使用R-Tree作为数据结构的索引通常用来为空间问题提供帮助。例如，一个查询要求“查询出所有距离我两公里之内的星巴克”，如果数据库表使用R- Tree索引，这类查询的效率将会提高。 
另一种索引是位图索引（bitmap index）， 这类索引适合放在包含布尔值(true 和 false)的列上，但是这些值（表示true或false的值）的许多实例-基本上都是选择性（selectivity）低的列。
### 索引是怎么提升性能的？
因为索引基本上是用来存储列值的数据结构，这使查找这些列值更加快速。如果索引使用最常用的数据结构-B-Tree-那么其中的数据是有序的。有序的列值可以极大的提升性能。下面解释原因。
假设我们在 Employee_Name这一列上创建一个B-Tree索引。这意味着当我们用之前的SQL查找姓名是‘Jesus’的雇员时，不需要再扫描全表。而是用索引查找去查找名字为‘Jesus’的雇员，因为索引已经按照按字母顺序排序。索引已经排序意味着查询一个名字会快很多，因为名字少字母为‘J’的员工都是排列在一起的。另外重要的一点是，索引同时存储了表中相应行的指针以获取其他列的数据。
### 数据库索引里究竟存的是什么？
你现在已经知道数据库索引是创建在表的某列上的，并且存储了这一列的所有值。但是，需要理解的重点是数据库索引并不存储这个表中其他列（字段）的值。举例来说，如果我们在Employee_Name列创建索引，那么列Employee_Age和Employee_Address上的值并不会存储在这个索引当中。如果我们确实把其他所有字段也存储在个这个索引中，那就成了拷贝一整张表做为索引-这样会占用太大的空间而且会十分低效。
索引存储了指向表中某一行的指针
如果我们在索引里找到某一条记录作为索引的列的值，如何才能找到这一条记录的其它值呢？这是很简单 - 数据库索引同时存储了指向表中的相应行的指针。指针是指一块内存区域， 该内存区域记录的是对硬盘上记录的相应行的数据的引用。因此，索引中除了存储列的值，还存储着一个指向在行数据的索引。也就是说，索引中的Employee_Name这列的某个值（或者节点）可以描述为 (“Jesus”, 0x82829)， 0x82829 就是包含 “Jesus”那行数据在硬盘上的地址。如果没有这个引用，你就只能访问到一个单独的值（“Jesus”），而这样没有意义，因为你不能获取这一行记录的employee的其他值-例如地址（address）和年龄（age）。
数据库怎么知道什么时候使用索引？
当这个SQL （SELECT * FROM Employee WHERE Employee_Name = ‘Jesus’ ）运行时，数据库会检查在查询的列上是否有索引。假设Employee_Name列上确实创建了索引，数据库会接着检查使用这个索引做查询是否合理 - 因为有些场景下，使用索引比起全表扫描会更加低效。如果想要了解更多这些场景，请阅读这篇文章：Selectivity in SQL
### 你能强制数据库使用索引吗？
通常来说， 你不会告诉数据库什么时候使用索引 - 数据库自己决定。然而，值得注意的是在大多数数据库中（像Oracle 和 MYSQL）， 你实际上可以制订你想要使用的索引。
### 如何在使用SQL创建索引：
之前的例子中，在Employee_Name列上创建索引的SQL如下：
CREATE INDEX name_index ON Employee (Employee_Name)
### 如何创建联合索引
我们可以在雇员表上创建两个列的联合索引，SQL如下：
CREATE INDEX name_index ON Employee (Employee_Name, Employee_Age)
### 把数据库索引类比成什么比较好呢?
一个非常好的类比是把数据库索引看作是书的索引。如果你有一本关于狗的书，你想要找关于‘黄金猎犬’的那部分。当你可以通过在书背的索引找到哪几页有关于‘黄金猎犬’信息的时候，你为什么要翻完正本书 - 这相当于数据库中的全表扫描。同样的，就像一本书的索引包含页码一样，数据库的索引包含了指针，指向你在SQL中想要查询的值所在的行。
### 使用数据库索引会有什么代价？
那么，使用数据库索引有什么缺点呢？其一，索引会占用空间 - 你的表越大，索引占用的空间越大。其二，性能损失（主要值更新操作），当你在表中添加、删除或者更新行数据的时候， 在索引中也会有相同的操作。记住：建立在某列（或多列）索引需要保存该列最新的数据。
基本原则是只如果表中某列在查询过程中使用的非常频繁，那就在该列上创建索引。



# Java虚拟机
## GC是什么？为什么要有GC？
GC是垃圾收集的意思（Gabage Collection）,内存处理是编程人员容易出现问题的地方，忘记或者错误的内存回收会导致程序或系统的不稳定甚至崩溃，Java提供的GC功能可以自动监测对象是否超过作用域从而达到自动回收内存的目的，Java语言没有提供释放已分配内存的显示操作方法。

## 垃圾回收的优点和原理。并考虑2种回收机制
Java语言中一个显著的特点就是引入了垃圾回收机制，使c++程序员最头疼的内存管理的问题迎刃而解，它使得Java程序员在编写程序的时候不再需要考虑内存管理。由于有个垃圾回收机制，Java中的对象不再有"作用域"的概念，只有对象的引用才有"作用域"。垃圾回收可以有效的防止内存泄露，有效的使用可以使用的内存。垃圾回收器通常是作为一个单独的低级别的线程运行，不可预知的情况下对内存堆中已经死亡的或者长时间没有使用的对象进行清楚和回收，程序员不能实时的调用垃圾回收器对某个对象或所有对象进行垃圾回收。回收机制有分代复制垃圾回收和标记垃圾回收，增量垃圾回收。
 
## 描述一下JVM加载class文件的原理机制?
JVM中类的装载是由ClassLoader和它的子类来实现的,Java ClassLoader 是一个重要的Java运行时系统组件。它负责在运行时查找和装入类文件的类。

## 分代/堆模型 
分代是Java垃圾收集的一大亮点，根据对象的生命周期长短，把堆分为3个代：Young，Old和Permanent，根据不同代的特点采用不同的收集算法，可以扬长避短。可参考如下的模型图： 

### Young(Nursery)：年轻代 
研究表明大部分对象都是朝生暮死，随生随灭的。所以对于年轻代在GC时都采取复制收集算法，具体算法参考下面的描述； 
Young的默认值为4M，随堆内存增大，约为1/15，JVM会根据情况动态管理其大小变化。 
Young里面又分为3 个区域，一个Eden，所有新建对象都会存在于该区，两个Survivor区，用来实施复制算法。 
-XX:NewRatio= 参数可以设置Young与Old的大小比例，-server时默认为1:2，但实际上young启动时远低于这个比率？如果信不过JVM，也可以用 -Xmn硬性规定其大小，有文档推荐设为Heap总大小的1/4。 
-XX:SurvivorRatio= 参数可以设置Eden与Survivor的比例，默认为32。Survivio大了会浪费，小了的话，会使一些年轻对象潜逃到老人区，引起老人区的不安，但这个参数对性能并不太重要。 

### Old(Tenured)：年老代 
年轻代的对象如果能够挺过数次收集，就会进入老人区。老人区使用标记整理算法。因为老人区的对象都没那么容易死的，采用复制算法就要反复的复制对象，很不合算，只好采用标记清理算法，但标记清理算法其实也不轻松，每次都要遍历区域内所有对象，所以还是没有免费的午餐啊。 
-XX:MaxTenuringThreshold= 设置熬过年轻代多少次收集后移入老人区，CMS中默认为0，熬过第一次GC就转入，可以用-XX:+PrintTenuringDistribution 查看。 

### Permanent：持久代 
装载Class信息等基础数据，默认64M，如果是类很多很多的服务程序，需要加大其设置 -XX:MaxPermSize=，否则它满了之后会引起fullgc()或Out of Memory。 注意Spring，Hibernate这类喜欢AOP动态生成类的框架需要更多的持久代内存。一般情况下，持久代是不会进行GC的，除非通过 -XX:+CMSClassUnloadingEnabled -XX:+CMSPermGenSweepingEnabled进行强制设置。 

## GC的类型 
当每个代满了之后都会自动促发collection，各收集器触发的条件不一样，当然也可以通过一些参数进行强制设定。主要分为两种类型： 

### Minor Collection：
GC用较高的频率对young进行扫描和回收，采用复制算法。 
### Major Collection：
同时对Young和Old进行内存收集，也叫Full GC；因为成本关系对Old的检查回收频率要比Young低很多，采用标记清除/标记整理算法。可以通过调用代码System.gc()引发major collection，使用-XX:+DisableExplicitGC禁止它，或设为CMS并发 -XX:+ExplicitGCInvokesConcurrent。 
更为具体的阐述如下： 
由于年轻代进进出出的人多而频繁，所以年轻代的GC也就频繁一点，但涉及范围也就年轻代这点弹丸之地内的对象，其特点就是少量，多次，但快速，称之为 Minor Collection。当年轻代的内存使用达到一定的阀值时，Minor Collection就被触发，Eden及某一Survior space（from space）之内存活的的对象被移到另一个空的Survior space（to space）中，然后from space和to space角色对调。当一个对象在两个survivor space之间移动过一定次数（达到预设的阀值）时，它就足够old了，够资格呆在年老代了。当然，如果survivor space比较小不足以容下所有live objects时，部分live objects也会直接晋升到年老代。 
Survior spaces可以看作是Eden和年老代之间的缓冲，通过该缓冲可以检验一个对象生命周期是否足够的长，因为某些对象虽然逃过了一次Minor Collection，并不能说明其生命周期足够长，说不定在下一次Minor Collection之前就挂了。这样一定程度上确保了进入年老代的对象是货真价实的，减少了年老代空间使用的增长速度，也就降低年老代GC的频率。 
当年老代或者永久代的内存使用达到一定阀值时，一次基于所有代的GC就触发了，其特定是涉及范围广（量大），耗费的时间相对较长（较慢），但是频率比较低（次数少），称之为Major Collection(Full Collection)。通常，首先使用针对年轻代的GC算法进行年轻代的GC，然后使用针对年老代的GC算法对年老代和永久代进行GC。 

## 基本回收算法 

### 引用计数（Reference Counting） 
比较古老的回收算法。原理是此对象有一个引用，即增加一个计数，删除一个引用则减少一个计数。垃圾回收时，只用收集计数为0的对象。此算法最致命的是无法处理循环引用的问题。 
### 标记-清除（Mark-Sweep） 
此算法执行分两阶段。第一阶段从引用根节点开始标记所有被引用的对象，第二阶段遍历整个堆，把未标记的对象清除。此算法需要暂停整个应用，同时，会产生内存碎片。 
### 复制（Copying） 
此算法把内存空间划为两个相等的区域，每次只使用其中一个区域。垃圾回收时，遍历当前使用区域，把正在使用中的对象复制到另外一个区域中。次算法每次只处理正在使用中的对象，因此复制成本比较小，同时复制过去以后还能进行相应的内存整理，不过出现“碎片”问题。当然，此算法的缺点也是很明显的，就是需要两倍内存空间。 
### 标记-整理（Mark-Compact） 
此算法结合了 “标记-清除”和“复制”两个算法的优点。也是分两阶段，第一阶段从根节点开始标记所有被引用对象，第二阶段遍历整个堆，把清除未标记对象并且把存活对象 “压缩”到堆的其中一块，按顺序排放。此算法避免了“标记-清除”的碎片问题，同时也避免了“复制”算法的空间问题。 
### 增量收集（Incremental Collecting） 
实施垃圾回收算法，即：在应用进行的同时进行垃圾回收。不知道什么原因JDK5.0中的收集器没有使用这种算法的。 
### 分代（Generational Collecting） 
基于对对象生命周期分析后得出的垃圾回收算法。把对象分为年青代、年老代、持久代，对不同生命周期的对象使用不同的算法（上述方式中的一个）进行回收。现在的垃圾回收器（从J2SE1.2开始）都是使用此算法的。 

1. Young（年轻代） 
年轻代分三个区。一个Eden区，两个 Survivor区。大部分对象在Eden区中生成。当Eden区满时，还存活的对象将被复制到Survivor区（两个中的一个），当这个 Survivor区满时，此区的存活对象将被复制到另外一个Survivor区，当这个Survivor去也满了的时候，从第一个Survivor区复制过来的并且此时还存活的对象，将被复制“年老区(Tenured)”。需要注意，Survivor的两个区是对称的，没先后关系，所以同一个区中可能同时存在从Eden复制过来对象，和从前一个Survivor复制过来的对象，而复制到年老区的只有从第一个Survivor去过来的对象。而且，Survivor区总有一个是空的。 
2. Tenured（年老代） 
年老代存放从年轻代存活的对象。一般来说年老代存放的都是生命期较长的对象。 
3. Perm（持久代） 
用于存放静态文件，如今Java类、方法等。持久代对垃圾回收没有显著影响，但是有些应用可能动态生成或者调用一些class，例如Hibernate等，在这种时候需要设置一个比较大的持久代空间来存放这些运行过程中新增的类。持久代大小通过-XX:MaxPermSize=<N>进行设置。 


## GC类型 
GC有两种类型：Scavenge GC和Full GC。 

1. Scavenge GC 
一般情况下，当新对象生成，并且在Eden申请空间失败时，就好触发Scavenge GC，堆Eden区域进行GC，清除非存活对象，并且把尚且存活的对象移动到Survivor区。然后整理Survivor的两个区。 
2. Full GC 
对整个堆进行整理，包括Young、Tenured和Perm。Full GC比Scavenge GC要慢，因此应该尽可能减少Full GC。有如下原因可能导致Full GC： 
* Tenured被写满 
* Perm域被写满 
* System.gc()被显示调用 
* 上一次GC之后Heap的各域分配策略动态变化 

## 垃圾回收器 
目前的收集器主要有三种：串行收集器、并行收集器、并发收集器。 

1. 串行收集器 
使用单线程处理所有垃圾回收工作，因为无需多线程交互，所以效率比较高。但是，也无法使用多处理器的优势，所以此收集器适合单处理器机器。当然，此收集器也可以用在小数据量（100M左右）情况下的多处理器机器上。可以使用-XX:+UseSerialGC打开。 

2. 并行收集器 
- 对年轻代进行并行垃圾回收，因此可以减少垃圾回收时间。一般在多线程多处理器机器上使用。使用-XX:+UseParallelGC.打开。并行收集器在J2SE5.0第六6更新上引入，在Java SE6.0中进行了增强--可以堆年老代进行并行收集。如果年老代不使用并发收集的话，是使用单线程进行垃圾回收，因此会制约扩展能力。使用-XX:+UseParallelOldGC打开。 
- 使用-XX:ParallelGCThreads=<N>设置并行垃圾回收的线程数。此值可以设置与机器处理器数量相等。 
- 此收集器可以进行如下配置： 
最大垃圾回收暂停:指定垃圾回收时的最长暂停时间，通过-XX:MaxGCPauseMillis=<N>指定。<N>为毫秒.如果指定了此值的话，堆大小和垃圾回收相关参数会进行调整以达到指定值。设定此值可能会减少应用的吞吐量。 
吞吐量:吞吐量为垃圾回收时间与非垃圾回收时间的比值，通过-XX:GCTimeRatio=<N>来设定，公式为1/（1+N）。例如，-XX:GCTimeRatio=19时，表示5%的时间用于垃圾回收。默认情况为99，即1%的时间用于垃圾回收。 

3. 并发收集器 
可以保证大部分工作都并发进行（应用不停止），垃圾回收只暂停很少的时间，此收集器适合对响应时间要求比较高的中、大规模应用。使用-XX:+UseConcMarkSweepGC打开。 
- 并发收集器主要减少年老代的暂停时间，他在应用不停止的情况下使用独立的垃圾回收线程，跟踪可达对象。在每个年老代垃圾回收周期中，在收集初期并发收集器会对整个应用进行简短的暂停，在收集中还会再暂停一次。第二次暂停会比第一次稍长，在此过程中多个线程同时进行垃圾回收工作。 
- 并发收集器使用处理器换来短暂的停顿时间。在一个N个处理器的系统上，并发收集部分使用K/N个可用处理器进行回收，一般情况下1<=K<=N/4。 
- 在只有一个处理器的主机上使用并发收集器，设置为incremental mode模式也可获得较短的停顿时间。 
- 浮动垃圾：由于在应用运行的同时进行垃圾回收，所以有些垃圾可能在垃圾回收进行完成时产生，这样就造成了“Floating Garbage”，这些垃圾需要在下次垃圾回收周期时才能回收掉。所以，并发收集器一般需要20%的预留空间用于这些浮动垃圾。 
- Concurrent Mode Failure：并发收集器在应用运行时进行收集，所以需要保证堆在垃圾回收的这段时间有足够的空间供程序使用，否则，垃圾回收还未完成，堆空间先满了。这种情况下将会发生“并发模式失败”，此时整个应用将会暂停，进行垃圾回收。 
- 启动并发收集器：因为并发收集在应用运行时进行收集，所以必须保证收集完成之前有足够的内存空间供程序使用，否则会出现“Concurrent Mode Failure”。通过设置-XX:CMSInitiatingOccupancyFraction=<N>指定还有多少剩余堆时开始执行并发收集 

# Java并发编程
## 同步和异步有何异同，在什么情况下分别使用他们？
同步指同一时间只能一个线程执行该方法，其他线程需要等待。异步指多个线程可以同时执行某个方法，并共享同一资源。
同步可以让访问的资源具有安全性，因为同一时间只能一个线程对其进行访问。但是效率不高。
异步对访问的资源会造成不稳定性，比如多个线程同时访问一个资源，一个在修改、一个在删除、一个在读取，这样可能会造成资源的混乱。但是由于同时运行，执行效率得到提高。

## 当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法?
如果其他方法没有加synchronized的话是可以进入的。

## 线程同步，并发操作怎么控制 
Java中可在方法名前加关键字syschronized来处理当有多个线程同时访问共享资源时候的问题。syschronized相当于一把锁，当有申请者申请该资源时，如果该资源没有被占用，那么将资源交付给这个申请者使用，在此期间，其他申请者只能申请而不能使用该资源，当该资源被使用完成后将释放该资源上的锁，其他申请者可申请使用。
并发控制主要是为了多线程操作时带来的资源读写问题。如果不加以空间可能会出现死锁，读脏数据、不可重复读、丢失更新等异常。
并发操作可以通过加锁的方式进行控制，锁又可分为乐观锁和悲观锁。
悲观锁：
悲观锁并发模式假定系统中存在足够多的数据修改操作，以致于任何确定的读操作都可能会受到由个别的用户所制造的数据修改的影响。也就是说悲观锁假定冲突总会发生，通过独占正在被读取的数据来避免冲突。但是独占数据会导致其他进程无法修改该数据，进而产生阻塞，读数据和写数据会相互阻塞。
乐观锁：
乐观锁假定系统的数据修改只会产生非常少的冲突，也就是说任何进程都不大可能修改别的进程正在访问的数据。乐观并发模式下，读数据和写数据之间不会发生冲突，只有写数据与写数据之间会发生冲突。即读数据不会产生阻塞，只有写数据才会产生阻塞。

## Java内存模型(JMM)
### 概述
　　多任务和高并发是衡量一台计算机处理器的能力重要指标之一。一般衡量一个服务器性能的高低好坏，使用每秒事务处理数（Transactions Per Second，TPS）这个指标比较能说明问题，它代表着一秒内服务器平均能响应的请求数，而TPS值与程序的并发能力有着非常密切的关系。在讨论Java内存模型和线程之前，先简单介绍一下硬件的效率与一致性。
### 硬件的效率与一致性
　　由于计算机的存储设备与处理器的运算能力之间有几个数量级的差距，所以现代计算机系统都不得不加入一层读写速度尽可能接近处理器运算速度的高速缓存（cache）来作为内存与处理器之间的缓冲：将运算需要使用到的数据复制到缓存中，让运算能快速进行，当运算结束后再从缓存同步回内存之中没这样处理器就无需等待缓慢的内存读写了。
　　基于高速缓存的存储交互很好地解决了处理器与内存的速度矛盾，但是引入了一个新的问题：缓存一致性（Cache Coherence）。在多处理器系统中，每个处理器都有自己的高速缓存，而他们又共享同一主存，如下图所示：多个处理器运算任务都涉及同一块主存，需要一种协议可以保障数据的一致性，这类协议有MSI、MESI、MOSI及Dragon Protocol等。Java虚拟机内存模型中定义的内存访问操作与硬件的缓存访问操作是具有可比性的，后续将介绍Java内存模型。

　　除此之外，为了使得处理器内部的运算单元能竟可能被充分利用，处理器可能会对输入代码进行乱起执行（Out-Of-Order Execution）优化，处理器会在计算之后将对乱序执行的代码进行结果重组，保证结果准确性。与处理器的乱序执行优化类似，Java虚拟机的即时编译器中也有类似的指令重排序（Instruction Recorder）优化。
### Java内存模型
　　定义Java内存模型并不是一件容易的事情，这个模型必须定义得足够严谨，才能让Java的并发操作不会产生歧义；但是，也必须得足够宽松，使得虚拟机的实现能有足够的自由空间去利用硬件的各种特性（寄存器、高速缓存等）来获取更好的执行速度。经过长时间的验证和修补，在JDK1.5发布后，Java内存模型就已经成熟和完善起来了。
#### 主内存与工作内存
　　Java内存模型的主要目标是定义程序中各个变量的访问规则，即在虚拟机中将变量存储到内存和从内存中取出变量这样底层细节。此处的变量与Java编程时所说的变量不一样，指包括了实例字段、静态字段和构成数组对象的元素，但是不包括局部变量与方法参数，后者是线程私有的，不会被共享。
　　Java内存模型中规定了所有的变量都存储在主内存中，每条线程还有自己的工作内存（可以与前面将的处理器的高速缓存类比），线程的工作内存中保存了该线程使用到的变量到主内存副本拷贝，线程对变量的所有操作（读取、赋值）都必须在工作内存中进行，而不能直接读写主内存中的变量。不同线程之间无法直接访问对方工作内存中的变量，线程间变量值的传递均需要在主内存来完成，线程、主内存和工作内存的交互关系如下图所示，和上图很类似。

这里的主内存、工作内存与Java内存区域的Java堆、栈、方法区不是同一层次内存划分。
#### 内存间交互操作
　　关于主内存与工作内存之间的具体交互协议，即一个变量如何从主内存拷贝到工作内存、如何从工作内存同步到主内存之间的实现细节，Java内存模型定义了以下八种操作来完成：

- lock（锁定）：作用于主内存的变量，把一个变量标识为一条线程独占状态。
- unlock（解锁）：作用于主内存变量，把一个处于锁定状态的变量释放出来，释放后的变量才可以被其他线程锁定。
- read（读取）：作用于主内存变量，把一个变量值从主内存传输到线程的工作内存中，以便随后的load动作使用
- load（载入）：作用于工作内存的变量，它把read操作从主内存中得到的变量值放入工作内存的变量副本中。
- use（使用）：作用于工作内存的变量，把工作内存中的一个变量值传递给执行引擎，每当虚拟机遇到一个需要使用变量的值的字节码指令时将会执行这个操作。
- assign（赋值）：作用于工作内存的变量，它把一个从执行引擎接收到的值赋值给工作内存的变量，每当虚拟机遇到一个给变量赋值的字节码指令时执行这个操作。
- store（存储）：作用于工作内存的变量，把工作内存中的一个变量的值传送到主内存中，以便随后的write的操作。
- write（写入）：作用于主内存的变量，它把store操作从工作内存中一个变量的值传送到主内存的变量中。
　　如果要把一个变量从主内存中复制到工作内存，就需要按顺寻地执行read和load操作，如果把变量从工作内存中同步回主内存中，就要按顺序地执行store和write操作。Java内存模型只要求上述操作必须按顺序执行，而没有保证必须是连续执行。也就是read和load之间，store和write之间是可以插入其他指令的，如对主内存中的变量a、b进行访问时，可能的顺序是read a，read b，load b， load a。Java内存模型还规定了在执行上述八种基本操作时，必须满足如下规则：
- 不允许read和load、store和write操作之一单独出现
- 不允许一个线程丢弃它的最近assign的操作，即变量在工作内存中改变了之后必须同步到主内存中。
- 不允许一个线程无原因地（没有发生过任何assign操作）把数据从工作内存同步回主内存中。
- 一个新的变量只能在主内存中诞生，不允许在工作内存中直接使用一个未被初始化（load或assign）的变量。即就是对一个变量实施use和store操作之前，必须先执行过了assign和load操作。
- 一个变量在同一时刻只允许一条线程对其进行lock操作，lock和unlock必须成对出现
- 如果对一个变量执行lock操作，将会清空工作内存中此变量的值，在执行引擎使用这个变量前需要重新执行load或assign操作初始化变量的值
- 如果一个变量事先没有被lock操作锁定，则不允许对它执行unlock操作；也不允许去unlock一个被其他线程锁定的变量。
- 对一个变量执行unlock操作之前，必须先把此变量同步到主内存中（执行store和write操作）。
#### 重排序
　　在执行程序时为了提高性能，编译器和处理器经常会对指令进行重排序。重排序分成三种类型：
编译器优化的重排序。编译器在不改变单线程程序语义放入前提下，可以重新安排语句的执行顺序。
指令级并行的重排序。现代处理器采用了指令级并行技术来将多条指令重叠执行。如果不存在数据依赖性，处理器可以改变语句对应机器指令的执行顺序。
内存系统的重排序。由于处理器使用缓存和读写缓冲区，这使得加载和存储操作看上去可能是在乱序执行。
从Java源代码到最终实际执行的指令序列，会经过下面三种重排序：
 
为了保证内存的可见性，Java编译器在生成指令序列的适当位置会插入内存屏障指令来禁止特定类型的处理器重排序。Java内存模型把内存屏障分为LoadLoad、LoadStore、StoreLoad和StoreStore四种.

## 在并发编程中，多个线程之间采取什么机制进行通信（信息交换），什么机制进行数据的同步？
　在Java语言中，采用的是共享内存模型来实现多线程之间的信息交换和数据同步的。
　线程之间通过共享程序公共的状态，通过读-写内存中公共状态的方式来进行隐式的通信。同步指的是程序在控制多个线程之间执行程序的相对顺序的机制，在共享内存模型中，同步是显式的，程序员必须显式指定某个方法/代码块需要在多线程之间互斥执行。
## 在说Java内存模型之前，我们先说一下Java的内存结构，也就是运行时的数据区域：
　Java虚拟机在执行Java程序的过程中，会把它管理的内存划分为几个不同的数据区域，这些区域都有各自的用途、创建时间、销毁时间。
Java运行时数据区分为下面几个内存区域：

- PC寄存器/程序计数器：
　　严格来说是一个数据结构，用于保存当前正在执行的程序的内存地址，由于Java是支持多线程执行的，所以程序执行的轨迹不可能一直都是线性执行。当有多个线程交叉执行时，被中断的线程的程序当前执行到哪条内存地址必然要保存下来，以便用于被中断的线程恢复执行时再按照被中断时的指令地址继续执行下去。为了线程切换后能恢复到正确的执行位置，每个线程都需要有一个独立的程序计数器，各个线程之间计数器互不影响，独立存储，我们称这类内存区域为“线程私有”的内存,这在某种程度上有点类似于“ThreadLocal”，是线程安全的。
- Java栈 Java Stack：
　　Java栈总是与线程关联在一起的，每当创建一个线程，JVM就会为该线程创建对应的Java栈，在这个Java栈中又会包含多个栈帧(Stack Frame)，这些栈帧是与每个方法关联起来的，每运行一个方法就创建一个栈帧，每个栈帧会含有一些局部变量、操作栈和方法返回值等信息。每当一个方法执行完成时，该栈帧就会弹出栈帧的元素作为这个方法的返回值，并且清除这个栈帧，Java栈的栈顶的栈帧就是当前正在执行的活动栈，也就是当前正在执行的方法，PC寄存器也会指向该地址。只有这个活动的栈帧的本地变量可以被操作栈使用，当在这个栈帧中调用另外一个方法时，与之对应的一个新的栈帧被创建，这个新创建的栈帧被放到Java栈的栈顶，变为当前的活动栈。同样现在只有这个栈的本地变量才能被使用，当这个栈帧中所有指令都完成时，这个栈帧被移除Java栈，刚才的那个栈帧变为活动栈帧，前面栈帧的返回值变为这个栈帧的操作栈的一个操作数。
　　由于Java栈是与线程对应起来的，Java栈数据不是线程共有的，所以不需要关心其数据一致性，也不会存在同步锁的问题。
　　在Java虚拟机规范中，对这个区域规定了两种异常状况：如果线程请求的栈深度大于虚拟机所允许的深度，将抛出StackOverflowError异常；如果虚拟机可以动态扩展，如果扩展时无法申请到足够的内存，就会抛出OutOfMemoryError异常。在Hot Spot虚拟机中，可以使用-Xss参数来设置栈的大小。栈的大小直接决定了函数调用的可达深度。
                                                   
 
- 堆 Heap:
　　堆是JVM所管理的内存中国最大的一块，是被所有Java线程锁共享的，不是线程安全的，在JVM启动时创建。堆是存储Java对象的地方，这一点Java虚拟机规范中描述是：所有的对象实例以及数组都要在堆上分配。Java堆是GC管理的主要区域，从内存回收的角度来看，由于现在GC基本都采用分代收集算法，所以Java堆还可以细分为：新生代和老年代；新生代再细致一点有Eden空间、From Survivor空间、To Survivor空间等。
- 方法区Method Area:
　　方法区存放了要加载的类的信息（名称、修饰符等）、类中的静态常量、类中定义为final类型的常量、类中的Field信息、类中的方法信息，当在程序中通过Class对象的getName.isInterface等方法来获取信息时，这些数据都来源于方法区。方法区是被Java线程锁共享的，不像Java堆中其他部分一样会频繁被GC回收，它存储的信息相对比较稳定，在一定条件下会被GC，当方法区要使用的内存超过其允许的大小时，会抛出OutOfMemory的错误信息。方法区也是堆中的一部分，就是我们通常所说的Java堆中的永久区 Permanet Generation，大小可以通过参数来设置,可以通过-XX:PermSize指定初始值，-XX:MaxPermSize指定最大值。
- 常量池Constant Pool:
　　常量池本身是方法区中的一个数据结构。常量池中存储了如字符串、final变量值、类名和方法名常量。常量池在编译期间就被确定，并保存在已编译的.class文件中。一般分为两类：字面量和应用量。字面量就是字符串、final变量等。类名和方法名属于引用量。引用量最常见的是在调用方法的时候，根据方法名找到方法的引用，并以此定为到函数体进行函数代码的执行。引用量包含：类和接口的权限定名、字段的名称和描述符，方法的名称和描述符。
- 本地方法栈Native Method Stack:
　　本地方法栈和Java栈所发挥的作用非常相似，区别不过是Java栈为JVM执行Java方法服务，而本地方法栈为JVM执行Native方法服务。本地方法栈也会抛出StackOverflowError和OutOfMemoryError异常。
　　
主内存和工作内存：
　　Java内存模型的主要目标是定义程序中各个变量的访问规则，即在JVM中将变量存储到内存和从内存中取出变量这样的底层细节。此处的变量与Java编程里面的变量有所不同步，它包含了实例字段、静态字段和构成数组对象的元素，但不包含局部变量和方法参数，因为后者是线程私有的，不会共享，当然不存在数据竞争问题（如果局部变量是一个reference引用类型，它引用的对象在Java堆中可被各个线程共享，但是reference引用本身在Java栈的局部变量表中，是线程私有的）。为了获得较高的执行效能，Java内存模型并没有限制执行引起使用处理器的特定寄存器或者缓存来和主内存进行交互，也没有限制即时编译器进行调整代码执行顺序这类优化措施。
　　JMM规定了所有的变量都存储在主内存（Main Memory）中。每个线程还有自己的工作内存（Working Memory）,线程的工作内存中保存了该线程使用到的变量的主内存的副本拷贝，线程对变量的所有操作（读取、赋值等）都必须在工作内存中进行，而不能直接读写主内存中的变量（volatile变量仍然有工作内存的拷贝，但是由于它特殊的操作顺序性规定，所以看起来如同直接在主内存中读写访问一般）。不同的线程之间也无法直接访问对方工作内存中的变量，线程之间值的传递都需要通过主内存来完成。
                                                                   
 
## 线程1和线程2要想进行数据的交换一般要经历下面的步骤：
1.线程1把工作内存1中的更新过的共享变量刷新到主内存中去。
2.线程2到主内存中去读取线程1刷新过的共享变量，然后copy一份到工作内存2中去。
 
## Java内存模型是围绕着并发编程中原子性、可见性、有序性这三个特征来建立的，那我们依次看一下这三个特征：
- 原子性（Atomicity）：一个操作不能被打断，要么全部执行完毕，要么不执行。在这点上有点类似于事务操作，要么全部执行成功，要么回退到执行该操作之前的状态。
　　基本类型数据的访问大都是原子操作，long 和double类型的变量是64位，但是在32位JVM中，32位的JVM会将64位数据的读写操作分为2次32位的读写操作来进行，这就导致了long、double类型的变量在32位虚拟机中是非原子操作，数据有可能会被破坏，也就意味着多个线程在并发访问的时候是线程非安全的。
下面我们来演示这个32位JVM下，对64位long类型的数据的访问的问题：
 
- 可见性：一个线程对共享变量做了修改之后，其他的线程立即能够看到（感知到）该变量这种修改（变化）。
　　Java内存模型是通过将在工作内存中的变量修改后的值同步到主内存，在读取变量前从主内存刷新最新值到工作内存中，这种依赖主内存的方式来实现可见性的。
无论是普通变量还是volatile变量都是如此，区别在于：volatile的特殊规则保证了volatile变量值修改后的新值立刻同步到主内存，每次使用volatile变量前立即从主内存中刷新，因此volatile保证了多线程之间的操作变量的可见性，而普通变量则不能保证这一点。
　除了volatile关键字能实现可见性之外，还有synchronized,Lock，final也是可以的。
　使用synchronized关键字，在同步方法/同步块开始时（Monitor Enter）,使用共享变量时会从主内存中刷新变量值到工作内存中（即从主内存中读取最新值到线程私有的工作内存中），在同步方法/同步块结束时(Monitor Exit),会将工作内存中的变量值同步到主内存中去（即将线程私有的工作内存中的值写入到主内存进行同步）。
　使用Lock接口的最常用的实现ReentrantLock(重入锁)来实现可见性：当我们在方法的开始位置执行lock.lock()方法，这和synchronized开始位置（Monitor Enter）有相同的语义，即使用共享变量时会从主内存中刷新变量值到工作内存中（即从主内存中读取最新值到线程私有的工作内存中），在方法的最后finally块里执行lock.unlock()方法，和synchronized结束位置（Monitor Exit）有相同的语义,即会将工作内存中的变量值同步到主内存中去（即将线程私有的工作内存中的值写入到主内存进行同步）。
　final关键字的可见性是指：被final修饰的变量，在构造函数数一旦初始化完成，并且在构造函数中并没有把“this”的引用传递出去（“this”引用逃逸是很危险的，其他的线程很可能通过该引用访问到只“初始化一半”的对象），那么其他线程就可以看到final变量的值。
　　
- 有序性：对于一个线程的代码而言，我们总是以为代码的执行是从前往后的，依次执行的。这么说不能说完全不对，在单线程程序里，确实会这样执行；但是在多线程并发时，程序的执行就有可能出现乱序。用一句话可以总结为：在本线程内观察，操作都是有序的；如果在一个线程中观察另外一个线程，所有的操作都是无序的。前半句是指“线程内表现为串行语义（WithIn Thread As-if-Serial Semantics）”,后半句是指“指令重排”现象和“工作内存和主内存同步延迟”现象。

Java提供了两个关键字volatile和synchronized来保证多线程之间操作的有序性,volatile关键字本身通过加入内存屏障来禁止指令的重排序，而synchronized关键字通过一个变量在同一时间只允许有一个线程对其进行加锁的规则来实现，
在单线程程序中，不会发生“指令重排”和“工作内存和主内存同步延迟”现象，只在多线程程序中出现。
 
## happens-before原则：
　　Java内存模型中定义的两项操作之间的次序关系，如果说操作A先行发生于操作B，操作A产生的影响能被操作B观察到，“影响”包含了修改了内存中共享变量的值、发送了消息、调用了方法等。
　　下面是Java内存模型下一些”天然的“happens-before关系，这些happens-before关系无须任何同步器协助就已经存在，可以在编码中直接使用。如果两个操作之间的关系不在此列，并且无法从下列规则推导出来的话，它们就没有顺序性保障，虚拟机可以对它们进行随意地重排序。

- 程序次序规则(Pragram Order Rule)：在一个线程内，按照程序代码顺序，书写在前面的操作先行发生于书写在后面的操作。准确地说应该是控制流顺序而不是程序代码顺序，因为要考虑分支、循环结构。
- 管程锁定规则(Monitor Lock Rule)：一个unlock操作先行发生于后面对同一个锁的lock操作。这里必须强调的是同一个锁，而”后面“是指时间上的先后顺序。
- volatile变量规则(Volatile Variable Rule)：对一个volatile变量的写操作先行发生于后面对这个变量的读取操作，这里的”后面“同样指时间上的先后顺序。
- 线程启动规则(Thread Start Rule)：Thread对象的start()方法先行发生于此线程的每一个动作。
- 线程终于规则(Thread Termination Rule)：线程中的所有操作都先行发生于对此线程的终止检测，我们可以通过Thread.join()方法结束，Thread.isAlive()的返回值等作段检测到线程已经终止执行。
- 线程中断规则(Thread Interruption Rule)：对线程interrupt()方法的调用先行发生于被中断线程的代码检测到中断事件的发生，可以通过Thread.interrupted()方法检测是否有中断发生。
- 对象终结规则(Finalizer Rule)：一个对象初始化完成(构造方法执行完成)先行发生于它的finalize()方法的开始。
- 传递性(Transitivity)：如果操作A先行发生于操作B，操作B先行发生于操作C，那就可以得出操作A先行发生于操作C的结论。
　一个操作”时间上的先发生“不代表这个操作会是”先行发生“，那如果一个操作”先行发生“是否就能推导出这个操作必定是”时间上的先发生 “呢？也是不成立的，一个典型的例子就是指令重排序。所以时间上的先后顺序与happens-before原则之间基本没有什么关系，所以衡量并发安全问题一切必须以happens-before 原则为准。

## Java中如何创建进程
在Java中，可以通过两种方式来创建进程，总共涉及到5个主要的类。
第一种方式是通过Runtime.exec()方法来创建一个进程，第二种方法是通过ProcessBuilder的start方法来创建进程。下面就来讲一讲这2种方式的区别和联系。
首先要讲的是Process类，Process类是一个抽象类，在它里面主要有几个抽象的方法，这个可以通过查看Process类的源代码得知：
位于java.lang.Process路径下：
```java
public abstract class Process
{
 
 abstract public OutputStream getOutputStream(); //获取进程的输出流
 
 abstract public InputStream getInputStream(); //获取进程的输入流
 
 abstract public InputStream getErrorStream(); //获取进程的错误流
 
 abstract public int waitFor() throws InterruptedException; //让进程等待
 
 abstract public int exitValue(); //获取进程的退出标志
 
 abstract public void destroy(); //摧毁进程
}
```
通过ProcessBuilder创建进程
ProcessBuilder是一个final类，它有两个构造器：
```java
public final class ProcessBuilder
{
 private List<String> command;
 private File directory;
 private Map<String,String> environment;
 private boolean redirectErrorStream;
 
 public ProcessBuilder(List<String> command) {
 if (command == null)
 throw new NullPointerException();
 this.command = command;
 }
 
 public ProcessBuilder(String... command) {
 this.command = new ArrayList<String>(command.length);
 for (String arg : command)
 this.command.add(arg);
 }
....
}
```
构造器中传递的是需要创建的进程的命令参数，第一个构造器是将命令参数放进List当中传进去，第二构造器是以不定长字符串的形式传进去。
那么我们接着往下看，前面提到是通过ProcessBuilder的start方法来创建一个新进程的，我们看一下start方法中具体做了哪些事情。下面是start方法的具体实现源代码：
```java
public Process start() throws IOException {
// Must convert to array first -- a malicious user-supplied
// list might try to circumvent the security check.
String[] cmdarray = command.toArray(new String[command.size()]);
for (String arg : cmdarray)
 if (arg == null)
 throw new NullPointerException();
// Throws IndexOutOfBoundsException if command is empty
String prog = cmdarray[0];
 
SecurityManager security = System.getSecurityManager();
if (security != null)
 security.checkExec(prog);
 
String dir = directory == null ? null : directory.toString();
 
try {
 return ProcessImpl.start(cmdarray,
 environment,
 dir,
 redirectErrorStream);
} catch (IOException e) {
 // It's much easier for us to create a high-quality error
 // message than the low-level C code which found the problem.
 throw new IOException(
 "Cannot run program \"" + prog + "\""
 + (dir == null ? "" : " (in directory \"" + dir + "\")")
 + ": " + e.getMessage(),
 e);
}
}
```
该方法返回一个Process对象，该方法的前面部分相当于是根据命令参数以及设置的工作目录进行一些参数设定，最重要的是try语句块里面的一句：
return ProcessImpl.start(cmdarray,environment,dir,redirectErrorStream);
说明真正创建进程的是这一句，注意调用的是ProcessImpl类的start方法，此处可以知道start必然是一个静态方法。那么ProcessImpl又是什么类呢？该类同样位于java.lang.ProcessImpl路径下，看一下该类的具体实现：
ProcessImpl也是一个final类，它继承了Process类：
```java
final class ProcessImpl extends Process {
 
 // System-dependent portion of ProcessBuilder.start()
 static Process start(String cmdarray[],
 java.util.Map<String,String> environment,
 String dir,
 boolean redirectErrorStream)
 throws IOException
 {
 String envblock = ProcessEnvironment.toEnvironmentBlock(environment);
 return new ProcessImpl(cmdarray, envblock, dir, redirectErrorStream);
 }
 ....
}
```
这是ProcessImpl类的start方法的具体实现，而事实上start方法中是通过这句来创建一个ProcessImpl对象的：
return new ProcessImpl(cmdarray, envblock, dir, redirectErrorStream);
而在ProcessImpl中对Process类中的几个抽象方法进行了具体实现。
说明事实上通过ProcessBuilder的start方法创建的是一个ProcessImpl对象。
下面看一下具体使用ProcessBuilder创建进程的例子，比如我要通过ProcessBuilder来启动一个进程打开cmd，并获取ip地址信息，那么可以这么写：
```java
public class Test {
 public static void main(String[] args) throws IOException {
 ProcessBuilder pb = new ProcessBuilder("cmd","/c","ipconfig/all");
 Process process = pb.start();
 Scanner scanner = new Scanner(process.getInputStream());
 
 while(scanner.hasNextLine()){
 System.out.println(scanner.nextLine());
 }
 scanner.close();
 }
}
```
第一步是最关键的，就是将命令字符串传给ProcessBuilder的构造器，一般来说，是把字符串中的每个独立的命令作为一个单独的参数，不过也可以按照顺序放入List中传进去。
至于其他很多具体的用法不在此进行赘述，比如通过ProcessBuilder的environment方法和directory(File directory)设置进程的环境变量以及工作目录等，感兴趣的朋友可以查看相关API文档。
2）通过Runtime的exec方法来创建进程
首先还是来看一下Runtime类和exec方法的具体实现，Runtime，顾名思义，即运行时，表示当前进程所在的虚拟机实例。
由于任何进程只会运行于一个虚拟机实例当中，所以在Runtime中采用了单例模式，即只会产生一个虚拟机实例：
```java
public class Runtime {
 private static Runtime currentRuntime = new Runtime();
 
 /**
 * Returns the runtime object associated with the current Java application.
 * Most of the methods of class <code>Runtime</code> are instance
 * methods and must be invoked with respect to the current runtime object.
 *
 * @return the <code>Runtime</code> object associated with the current
 * Java application.
 */
 public static Runtime getRuntime() {
 return currentRuntime;
 }
 
 /** Don't let anyone else instantiate this class */
 private Runtime() {}
 ...
 }
 ```
从这里可以看出，由于Runtime类的构造器是private的，所以只有通过getRuntime去获取Runtime的实例。接下来着重看一下exec方法 实现，在Runtime中有多个exec的不同重载实现，但真正最后执行的是这个版本的exec方法：
```java
public Process exec(String[] cmdarray, String[] envp, File dir)
 throws IOException {
 return new ProcessBuilder(cmdarray)
 .environment(envp)
 .directory(dir)
 .start();
 }
 ```
可以发现，事实上通过Runtime类的exec创建进程的话，最终还是通过ProcessBuilder类的start方法来创建的。
下面看一个例子，看一下通过Runtime的exec如何创建进程，还是前面的例子，调用cmd，获取ip地址信息：
```java
public class Test {
 public static void main(String[] args) throws IOException {
 String cmd = "cmd "+"/c "+"ipconfig/all";
 Process process = Runtime.getRuntime().exec(cmd);
 Scanner scanner = new Scanner(process.getInputStream());
 
 while(scanner.hasNextLine()){
 System.out.println(scanner.nextLine());
 }
 scanner.close();
 }
}
```
要注意的是，exec方法不支持不定长参数（ProcessBuilder是支持不定长参数的），所以必须先把命令参数拼接好再传进去。


## 线程池

### 什么是线程池：
java.util.concurrent.Executors提供了一个 java.util.concurrent.Executor接口的实现用于创建线程池
多线程技术主要解决处理器单元内多个线程执行的问题，它可以显著减少处理器单元的闲置时间，增加处理器单元的吞吐能力。    
假设一个服务器完成一项任务所需时间为：T1 创建线程时间，T2 在线程中执行任务的时间，T3 销毁线程时间。
如果：T1 + T3 远大于 T2，则可以采用线程池，以提高服务器性能。
一个线程池包括以下四个基本组成部分：

- 线程池管理器（ThreadPool）：用于创建并管理线程池，包括 创建线程池，销毁线程池，添加新任务；
- 工作线程（PoolWorker）：线程池中线程，在没有任务时处于等待状态，可以循环的执行任务；
- 任务接口（Task）：每个任务必须实现的接口，以供工作线程调度任务的执行，它主要规定了任务的入口，任务执行完后的收尾工作，任务的执行状态等；
- 任务队列（taskQueue）：用于存放没有处理的任务。提供一种缓冲机制。

线程池技术正是关注如何缩短或调整T1,T3时间的技术，从而提高服务器程序性能的。它把T1，T3分别安排在服务器程序的启动和结束的时间段或者一些空闲的时间段，这样在服务器程序处理客户请求时，不会有T1，T3的开销了。
 
### 常见线程池
- newSingleThreadExecutor
单个线程的线程池，即线程池中每次只有一个线程工作，单线程串行执行任务
- newFixedThreadExecutor(n)
固定数量的线程池，没提交一个任务就是一个线程，直到达到线程池的最大数量，然后后面进入等待队列直到前面的任务完成才继续执行
- newCacheThreadExecutor（推荐使用）
可缓存线程池，当线程池大小超过了处理任务所需的线程，那么就会回收部分空闲（一般是60秒无执行）的线程，当有任务来时，又智能的添加新线程来执行。
- newScheduleThreadExecutor
大小无限制的线程池，支持定时和周期性的执行线程
 
java提供的线程池更加强大，相信理解线程池的工作原理，看类库中的线程池就不会感到陌生了。

### 线程池的作用：
线程池作用就是限制系统中执行线程的数量。
根据系统的环境情况，可以自动或手动设置线程数量，达到运行的最佳效果；少了浪费了系统资源，多了造成系统拥挤效率不高。用线程池控制线程数量，其他线程排队等候。一个任务执行完毕，再从队列的中取最前面的任务开始执行。若队列中没有等待进程，线程池的这一资源处于等待。当一个新任务需要运行时，如果线程池中有等待的工作线程，就可以开始运行了；否则进入等待队列。

### 为什么要用线程池:
- 减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。
- 可以根据系统的承受能力，调整线程池中工作线线程的数目，防止因为消耗过多的内存，而把服务器累趴下(每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大，最后死机)。

Java里面线程池的顶级接口是Executor，但是严格意义上讲Executor并不是一个线程池，而只是一个执行线程的工具。真正的线程池接口是ExecutorService。
要配置一个线程池是比较复杂的，尤其是对于线程池的原理不是很清楚的情况下，很有可能配置的线程池不是较优的，因此在Executors类里面提供了一些静态工厂，生成一些常用的线程池。

### ThreadPoolExecutor详解
ThreadPoolExecutor的完整构造方法的签名是：ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) .

corePoolSize - 池中所保存的线程数，包括空闲线程。

maximumPoolSize-池中允许的最大线程数。

keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。

unit - keepAliveTime 参数的时间单位。

workQueue - 执行前用于保持任务的队列。此队列仅保持由 execute方法提交的 Runnable任务。

threadFactory - 执行程序创建新线程时使用的工厂。

handler - 由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序。

ThreadPoolExecutor是Executors类的底层实现。

### 在JDK帮助文档中，有如此一段话：
“强烈建议程序员使用较为方便的Executors工厂方法Executors.newCachedThreadPool()（无界线程池，可以进行自动线程回收）、Executors.newFixedThreadPool(int)（固定大小线程池）Executors.newSingleThreadExecutor()（单个后台线程）
它们均为大多数使用场景预定义了设置。”

下面介绍一下几个类的源码：
ExecutorService  newFixedThreadPool (int nThreads):固定大小线程池。
可以看到，corePoolSize和maximumPoolSize的大小是一样的（实际上，后面会介绍，如果使用无界queue的话maximumPoolSize参数是没有意义的），keepAliveTime和unit的设值表名什么？-就是该实现不想keep alive！最后的BlockingQueue选择了LinkedBlockingQueue，该queue有一个特点，他是无界的。

ExecutorService  newSingleThreadExecutor()：单线程

ExecutorService newCachedThreadPool()：无界线程池，可以进行自动线程回收
这个实现就有意思了。首先是无界的线程池，所以我们可以发现maximumPoolSize为big big。其次BlockingQueue的选择上使用SynchronousQueue。可能对于该BlockingQueue有些陌生，简单说：该QUEUE中，每个插入操作必须等待另一个线程的对应移除操作。
 先从BlockingQueue<Runnable> workQueue这个入参开始说起。在JDK中，其实已经说得很清楚了，一共有三种类型的queue。
所有BlockingQueue 都可用于传输和保持提交的任务。可以使用此队列与池大小进行交互：
如果运行的线程少于 corePoolSize，则 Executor始终首选添加新的线程，而不进行排队。（如果当前运行的线程小于corePoolSize，则任务根本不会存放，添加到queue中，而是直接抄家伙（thread）开始运行）
如果运行的线程等于或多于 corePoolSize，则 Executor始终首选将请求加入队列，而不添加新的线程。
如果无法将请求加入队列，则创建新的线程，除非创建此线程超出 maximumPoolSize，在这种情况下，任务将被拒绝。
 
### 排队有三种通用策略：
直接提交。工作队列的默认选项是 SynchronousQueue，它将任务直接提交给线程而不保持它们。在此，如果不存在可用于立即运行任务的线程，则试图把任务加入队列将失败，因此会构造一个新的线程。此策略可以避免在处理可能具有内部依赖性的请求集时出现锁。直接提交通常要求无界 maximumPoolSizes 以避免拒绝新提交的任务。当命令以超过队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性。
无界队列。使用无界队列（例如，不具有预定义容量的 LinkedBlockingQueue）将导致在所有corePoolSize 线程都忙时新任务在队列中等待。这样，创建的线程就不会超过 corePoolSize。（因此，maximumPoolSize的值也就无效了。）当每个任务完全独立于其他任务，即任务执行互不影响时，适合于使用无界队列；例如，在 Web页服务器中。这种排队可用于处理瞬态突发请求，当命令以超过队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性。
有界队列。当使用有限的 maximumPoolSizes时，有界队列（如 ArrayBlockingQueue）有助于防止资源耗尽，但是可能较难调整和控制。队列大小和最大池大小可能需要相互折衷：使用大型队列和小型池可以最大限度地降低 CPU 使用率、操作系统资源和上下文切换开销，但是可能导致人工降低吞吐量。如果任务频繁阻塞（例如，如果它们是 I/O边界），则系统可能为超过您许可的更多线程安排时间。使用小型队列通常要求较大的池大小，CPU使用率较高，但是可能遇到不可接受的调度开销，这样也会降低吞吐量。  
BlockingQueue的选择。


## 进程和线程之间有什么不同？ 
一个进程是一个独立(self contained)的运行环境，它可以被看作一个程序或者一个应用。而线程是在进程中执行的一个任务。Java运行环境是一个包含了不同的类和程序的单一进程。线程可以被称为轻量级进程。线程需要较少的资源来创建和驻留在进程中，并且可以共享进程中的资源。
## 多线程编程的好处是什么？  
在多线程程序中，多个线程被并发的执行以提高程序的效率，CPU不会因为某个线程需要等待资源而进入空闲状态。多个线程共享堆内存(heap memory)，因此创建多个线程去执行一些任务会比创建多个进程更好。举个例子，Servlets比CGI更好，是因为Servlets支持多线程而CGI不支持。
## 用户线程和守护线程有什么区别？  
当我们在Java程序中创建一个线程，它就被称为用户线程。一个守护线程是在后台执行并且不会阻止JVM终止的线程。当没有用户线程在运行的时候，JVM关闭程序并且退出。一个守护线程创建的子线程依然是守护线程。
## 我们如何创建一个线程？  
有两种创建线程的方法：一是实现Runnable接口，然后将它传递给Thread的构造函数，创建一个Thread对象；二是直接继承Thread类。若想了解更多可以阅读这篇关于如何在Java中创建线程的文章。
## 有哪些不同的线程生命周期？  
当我们在Java程序中新建一个线程时，它的状态是New。当我们调用线程的start()方法时，状态被改变为Runnable。线程调度器会为 Runnable线程池中的线程分配CPU时间并且讲它们的状态改变为Running。其他的线程状态还有Waiting，Blicked 和Dead。读这篇文章可以了解更多关于线程生命周期的知识。
## 可以直接调用Thread类的run()方法么？  
当然可以，但是如果我们调用了Thread的run()方法，它的行为就会和普通的方法一样，为了在新的线程中执行我们的代码，必须使用Thread.start()方法。
## 如何让正在运行的线程暂停一段时间？  
我们可以使用Thread类的Sleep()方法让线程暂停一段时间。需要注意的是，这并不会让线程终止，一旦从休眠中唤醒线程，线程的状态将会被改变为 Runnable，并且根据线程调度，它将得到执行。
## 你对线程优先级的理解是什么？  
每一个线程都是有优先级的，一般来说，高优先级的线程在运行时会具有优先权，但这依赖于线程调度的实现，这个实现是和操作系统相关的(OS dependent)。我们可以定义线程的优先级，但是这并不能保证高优先级的线程会在低优先级的线程前执行。线程优先级是一个int变量(从1-10)，1代表最低优先级，10代表最高优先级。
## 什么是线程调度器(Thread Scheduler)和时间分片(Time Slicing)？ 
线程调度器是一个操作系统服务，它负责为Runnable状态的线程分配CPU时间。一旦我们创建一个线程并启动它，它的执行便依赖于线程调度器的实现。时间分片是指将可用的CPU时间分配给可用的 Runnable线程的过程。分配CPU时间可以基于线程优先级或者线程等待的时间。线程调度并不受到Java虚拟机控制，所以由应用程序来控制它是更好的选择（也就是说不要让你的程序依赖于线程的优先级）。
## 在多线程中，什么是上下文切换(context-switching)？  
上下文切换是存储和恢复CPU状态的过程，它使得线程执行能够从中断点恢复执行。上下文切换是多任务操作系统和多线程环境的基本特征。
## 你如何确保main()方法所在的线程是Java程序最后结束的线程？ 
我们可以使用Thread类的joint()方法来确保所有程序创建的线程在main()方法退出前结束。这里有一篇文章关于Thread类的joint()方法。
## 线程之间是如何通信的？  
当线程间是可以共享资源时，线程间通信是协调它们的重要的手段。Object类中wait()\notify()\notifyAll()方法可以用于线程间通信关于资源的锁的状态。点击这里有更多关于线程wait, notify和notifyAll.
## 为什么线程通信的方法wait(), notify()和notifyAll()被定义在Object类里？ 
Java的每个对象中都有一个锁(monitor，也可以成为监视器) 并且wait()，notify()等方法用于等待对象的锁或者通知其他线程对象的监视器可用。在Java的线程中并没有可供任何对象使用的锁和同步器。这就是为什么这些方法是Object类的一部分，这样Java的每一个类都有用于线程间通信的基本方法
## 为什么wait(), notify()和notifyAll()必须在同步方法或者同步块中被调用？  
当一个线程需要调用对象的wait()方法的时候，这个线程必须拥有该对象的锁，接着它就会释放这个对象锁并进入等待状态直到其他线程调用这个对象上的notify()方法。同样的，当一个线程需要调用对象的notify()方法时，它会释放这个对象的锁，以便其他在等待的线程就可以得到这个对象锁。由于所有的这些方法都需要线程持有对象的锁，这样就只能通过同步来实现，所以他们只能在同步方法或者同步块中被调用。
## 为什么Thread类的sleep()和yield()方法是静态的？  
Thread类的sleep()和yield()方法将在当前正在执行的线程上运行。所以在其他处于等待状态的线程上调用这些方法是没有意义的。这就是为什么这些方法是静态的。它们可以在当前正在执行的线程中工作，并避免程序员错误的认为可以在其他非运行线程调用这些方法。
## 如何确保线程安全？ 
在Java中可以有很多方法来保证线程安全——同步，使用原子类(atomic concurrent classes)，实现并发锁，使用volatile关键字，使用不变类和线程安全类。在线程安全教程中，你可以学到更多。
## volatile关键字在Java中有什么作用？  
当我们使用volatile关键字去修饰变量的时候，所以线程都会直接读取该变量并且不缓存它。这就确保了线程读取到的变量是同内存中是一致的。
## 同步方法和同步块，哪个是更好的选择？  
同步块是更好的选择，因为它不会锁住整个对象（当然你也可以让它锁住整个对象）。同步方法会锁住整个对象，哪怕这个类中有多个不相关联的同步块，这通常会导致他们停止执行并需要等待获得这个对象上的锁。
## 如何创建守护线程？  
使用Thread类的setDaemon(true)方法可以将线程设置为守护线程，需要注意的是，需要在调用start()方法前调用这个方法，否则会抛出IllegalThreadStateException异常。
## 什么是ThreadLocal?  
ThreadLocal用于创建线程的本地变量，我们知道一个对象的所有线程会共享它的全局变量，所以这些变量不是线程安全的，我们可以使用同步技术。但是当我们不想使用同步的时候，我们可以选择ThreadLocal变量。
每个线程都会拥有他们自己的Thread变量，它们可以使用get()\set()方法去获取他们的默认值或者在线程内部改变他们的值。ThreadLocal实例通常是希望它们同线程状态关联起来是private static属性。在ThreadLocal例子这篇文章中你可以看到一个关于ThreadLocal的小程序。
## 什么是Thread Group？为什么建议使用它？ 
ThreadGroup是一个类，它的目的是提供关于线程组的信息。
ThreadGroup API比较薄弱，它并没有比Thread提供了更多的功能。它有两个主要的功能：一是获取线程组中处于活跃状态线程的列表；二是设置为线程设置未捕获异常处理器(ncaught exception handler)。但在Java 1.5中Thread类也添加了setUncaughtExceptionHandler(UncaughtExceptionHandler eh) 方法，所以ThreadGroup是已经过时的，不建议继续使用。
t1.setUncaughtExceptionHandler(new UncaughtExceptionHandler(){ @Override public void uncaughtException(Thread t, Throwable e) { System.out.println("exception occured:"+e.getMessage()); } }); 22. 什么是Java线程转储(Thread Dump)，如何得到它？  线程转储是一个JVM活动线程的列表，它对于分析系统瓶颈和死锁非常有用。有很多方法可以获取线程转储——使用Profiler，Kill -3命令，jstack工具等等。我更喜欢jstack工具，因为它容易使用并且是JDK自带的。由于它是一个基于终端的工具，所以我们可以编写一些脚本去定时的产生线程转储以待分析。读这篇文档可以了解更多关于产生线程转储的知识。
## 什么是死锁(Deadlock)？如何分析和避免死锁？ 
死锁是指两个以上的线程永远阻塞的情况，这种情况产生至少需要两个以上的线程和两个以上的资源。
分析死锁，我们需要查看Java应用程序的线程转储。我们需要找出那些状态为BLOCKED的线程和他们等待的资源。每个资源都有一个唯一的id，用这个id我们可以找出哪些线程已经拥有了它的对象锁。
避免嵌套锁，只在需要的地方使用锁和避免无限期等待是避免死锁的通常办法，阅读这篇文章去学习如何分析死锁。
## 什么是Java Timer类？如何创建一个有特定时间间隔的任务？  
java.util.Timer是一个工具类，可以用于安排一个线程在未来的某个特定时间执行。Timer类可以用安排一次性任务或者周期任务。
java.util.TimerTask是一个实现了Runnable接口的抽象类，我们需要去继承这个类来创建我们自己的定时任务并使用Timer去安排它的执行。
## 什么是线程池？如何创建一个Java线程池？ 
一个线程池管理了一组工作线程，同时它还包括了一个用于放置等待执行的任务的队列。
java.util.concurrent.Executors提供了一个 java.util.concurrent.Executor接口的实现用于创建线程池。线程池例子展现了如何创建和使用线程池，或者阅读ScheduledThreadPoolExecutor例子，了解如何创建一个周期任务。

## 什么是线程？
线程是操作系统能够进行运算调度的最小单位，它被包含在进程之中，是进程中的实际运作单位。程序员可以通过它进行多处理器编程，你可以使用多线程对运算密集型任务提速。比如，如果一个线程完成一个任务要100毫秒，那么用十个线程完成改任务只需10毫秒。Java在语言层面对多线程提供了卓越的支持，它也是一个很好的卖点。
## 线程和进程有什么区别？
线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务。不同的进程使用不同的内存空间，而所有的线程共享一片相同的内存空间。别把它和栈内存搞混，每个线程都拥有单独的栈内存用来存储本地数据。
## 如何在Java中实现线程？
在语言层面有两种方式。java.lang.Thread 类的实例就是一个线程但是它需要调用java.lang.Runnable接口来执行，由于线程类本身就是调用的Runnable接口所以你可以继承java.lang.Thread 类或者直接调用Runnable接口来重写run()方法实现线程。
## 用Runnable还是Thread？
这个问题是上题的后续，大家都知道我们可以通过继承Thread类或者调用Runnable接口来实现线程，问题是，那个方法更好呢？什么情况下使用它？这个问题很容易回答，如果你知道Java不支持类的多重继承，但允许你调用多个接口。所以如果你要继承其他类，当然是调用Runnable接口好了。
## Thread 类中的start() 和 run() 方法有什么区别？
这个问题经常被问到，但还是能从此区分出面试者对Java线程模型的理解程度。start()方法被用来启动新创建的线程，而且start()内部调用了run()方法，这和直接调用run()方法的效果不一样。当你调用run()方法的时候，只会是在原来的线程中调用，没有新的线程启动，start()方法才会启动新线程。
## Java中Runnable和Callable有什么不同？
Runnable和Callable都代表那些要在不同的线程中执行的任务。Runnable从JDK1.0开始就有了，Callable是在JDK1.5增加的。它们的主要区别是Callable的 call() 方法可以返回值和抛出异常，而Runnable的run()方法没有这些功能。Callable可以返回装载有计算结果的Future对象。

## Java中CyclicBarrier 和 CountDownLatch有什么不同？
CyclicBarrier 和 CountDownLatch 都可以用来让一组线程等待其它线程。与 CyclicBarrier 不同的是，CountdownLatch 不能重新使用。

## Java内存模型是什么？
Java内存模型规定和指引Java程序在不同的内存架构、CPU和操作系统间有确定性地行为。它在多线程的情况下尤其重要。Java内存模型对一个线程所做的变动能被其它线程可见提供了保证，它们之间是先行发生关系。这个关系定义了一些规则让程序员在并发编程时思路更清晰。比如，先行发生关系确保了：

- 线程内的代码能够按先后顺序执行，这被称为程序次序规则。
- 对于同一个锁，一个解锁操作一定要发生在时间上后发生的另一个锁定操作之前，也叫做管程锁定规则。
- 前一个对volatile的写操作在后一个volatile的读操作之前，也叫volatile变量规则。-  一个线程内的任何操作必需在这个线程的start()调用之后，也叫作线程启动规则。
- 一个线程的所有操作都会在线程终止之前，线程终止规则。
- 一个对象的终结操作必需在这个对象构造完成之后，也叫对象终结规则。
- 可传递性
## Java中的volatile 变量是什么？
volatile是一个特殊的修饰符，只有成员变量才能使用它。在Java并发程序缺少同步类的情况下，多线程对成员变量的操作对其它线程是透明的。volatile变量可以保证下一个读取操作会在前一个写操作之后发生，就是上一题的volatile变量规则。

## 什么是线程安全？Vector是一个线程安全类吗？ 
如果你的代码所在的进程中有多个线程在同时运行，而这些线程可能会同时运行这段代码。如果每次运行结果和单线程运行的结果是一样的，而且其他的变量的值也和预期的是一样的，就是线程安全的。一个线程安全的计数器类的同一个实例对象在被多个线程使用的情况下也不会出现计算失误。很显然你可以将集合类分成两组，线程安全和非线程安全的。Vector 是用同步方法来实现线程安全的, 而和它相似的ArrayList不是线程安全的。
## Java中什么是竞态条件？ 举个例子说明。
竞态条件会导致程序在并发情况下出现一些bugs。多线程对一些资源的竞争的时候就会产生竞态条件，如果首先要执行的程序竞争失败排到后面执行了，那么整个程序就会出现一些不确定的bugs。这种bugs很难发现而且会重复出现，因为线程间的随机竞争。
## Java中如何停止一个线程？
Java提供了很丰富的API但没有为停止线程提供API。JDK 1.0本来有一些像stop(), suspend() 和 resume()的控制方法但是由于潜在的死锁威胁因此在后续的JDK版本中他们被弃用了，之后Java API的设计者就没有提供一个兼容且线程安全的方法来停止一个线程。当run() 或者 call() 方法执行完的时候线程会自动结束,如果要手动结束一个线程，你可以用volatile 布尔变量来退出run()方法的循环或者是取消任务来中断线程。
## 一个线程运行时发生异常会怎样？
这是我在一次面试中遇到的一个很刁钻的Java面试题, 简单的说，如果异常没有被捕获该线程将会停止执行。Thread.UncaughtExceptionHandler是用于处理未捕获异常造成线程突然中断情况的一个内嵌接口。当一个未捕获异常将造成线程中断的时候JVM会使用Thread.getUncaughtExceptionHandler()来查询线程的UncaughtExceptionHandler并将线程和异常作为参数传递给handler的uncaughtException()方法进行处理。
## 如何在两个线程间共享数据？
你可以通过共享对象来实现这个目的，或者是使用像阻塞队列这样并发的数据结构。这篇教程《Java线程间通信》(涉及到在两个线程间共享对象)用wait和notify方法实现了生产者消费者模型。
## Java中notify 和 notifyAll有什么区别？
这又是一个刁钻的问题，因为多线程可以等待单监控锁，Java API 的设计人员提供了一些方法当等待条件改变的时候通知它们，但是这些方法没有完全实现。notify()方法不能唤醒某个具体的线程，所以只有一个线程在等待的时候它才有用武之地。而notifyAll()唤醒所有线程并允许他们争夺锁确保了至少有一个线程能继续运行。
## 为什么wait, notify 和 notifyAll这些方法不在thread类里面？
这是个设计相关的问题，它考察的是面试者对现有系统和一些普遍存在但看起来不合理的事物的看法。回答这些问题的时候，你要说明为什么把这些方法放在Object类里是有意义的，还有不把它放在Thread类里的原因。一个很明显的原因是JAVA提供的锁是对象级的而不是线程级的，每个对象都有锁，通过线程获得。如果线程需要等待某些锁那么调用对象中的wait()方法就有意义了。如果wait()方法定义在Thread类中，线程正在等待的是哪个锁就不明显了。简单的说，由于wait，notify和notifyAll都是锁级别的操作，所以把他们定义在Object类中因为锁属于对象。
## 什么是ThreadLocal变量？
ThreadLocal是Java里一种特殊的变量。每个线程都有一个ThreadLocal就是每个线程都拥有了自己独立的一个变量，竞争条件被彻底消除了。它是为创建代价高昂的对象获取线程安全的好方法，比如你可以用ThreadLocal让SimpleDateFormat变成线程安全的，因为那个类创建代价高昂且每次调用都需要创建不同的实例所以不值得在局部范围使用它，如果为每个线程提供一个自己独有的变量拷贝，将大大提高效率。首先，通过复用减少了代价高昂的对象的创建个数。其次，你在没有使用高代价的同步或者不变性的情况下获得了线程安全。线程局部变量的另一个不错的例子是ThreadLocalRandom类，它在多线程环境中减少了创建代价高昂的Random对象的个数。
## 什么是FutureTask？
在Java并发程序中FutureTask表示一个可以取消的异步运算。它有启动和取消运算、查询运算是否完成和取回运算结果等方法。只有当运算完成的时候结果才能取回，如果运算尚未完成get方法将会阻塞。一个FutureTask对象可以对调用了Callable和Runnable的对象进行包装，由于FutureTask也是调用了Runnable接口所以它可以提交给Executor来执行。
## Java中interrupted 和 isInterruptedd方法的区别？
interrupted() 和 isInterrupted()的主要区别是前者会将中断状态清除而后者不会。Java多线程的中断机制是用内部标识来实现的，调用Thread.interrupt()来中断一个线程就会设置中断标识为true。当中断线程调用静态方法Thread.interrupted()来检查中断状态时，中断状态会被清零。而非静态方法isInterrupted()用来查询其它线程的中断状态且不会改变中断状态标识。简单的说就是任何抛出InterruptedException异常的方法都会将中断状态清零。无论如何，一个线程的中断状态有有可能被其它线程调用中断来改变。
## 为什么wait和notify方法要在同步块中调用？
主要是因为Java API强制要求这样做，如果你不这么做，你的代码会抛出IllegalMonitorStateException异常。还有一个原因是为了避免wait和notify之间产生竞态条件。
## 为什么你应该在循环中检查等待条件?
处于等待状态的线程可能会收到错误警报和伪唤醒，如果不在循环中检查等待条件，程序就会在没有满足结束条件的情况下退出。因此，当一个等待线程醒来时，不能认为它原来的等待状态仍然是有效的，在notify()方法调用之后和等待线程醒来之前这段时间它可能会改变。这就是在循环中使用wait()方法效果更好的原因，你可以在Eclipse中创建模板调用wait和notify试一试。
## Java中的同步集合与并发集合有什么区别？
同步集合与并发集合都为多线程和并发提供了合适的线程安全的集合，不过并发集合的可扩展性更高。在Java1.5之前程序员们只有同步集合来用且在多线程并发的时候会导致争用，阻碍了系统的扩展性。Java5介绍了并发集合像ConcurrentHashMap，不仅提供线程安全还用锁分离和内部分区等现代技术提高了可扩展性。
## Java中堆和栈有什么不同？
为什么把这个问题归类在多线程和并发面试题里？因为栈是一块和线程紧密相关的内存区域。每个线程都有自己的栈内存，用于存储本地变量，方法参数和栈调用，一个线程中存储的变量对其它线程是不可见的。而堆是所有线程共享的一片公用内存区域。对象都在堆里创建，为了提升效率线程会从堆中弄一个缓存到自己的栈，如果多个线程使用该变量就可能引发问题，这时volatile 变量就可以发挥作用了，它要求线程从主存中读取变量的值。
## 什么是线程池？ 为什么要使用它？
创建线程要花费昂贵的资源和时间，如果任务来了才创建线程那么响应时间会变长，而且一个进程能创建的线程数有限。为了避免这些问题，在程序启动的时候就创建若干线程来响应处理，它们被称为线程池，里面的线程叫工作线程。从JDK1.5开始，Java API提供了Executor框架让你可以创建不同的线程池。比如单线程池，每次处理一个任务；数目固定的线程池或者是缓存线程池（一个适合很多生存期短的任务的程序的可扩展线程池）。
## 如何写代码来解决生产者消费者问题？
在现实中你解决的许多线程问题都属于生产者消费者模型，就是一个线程生产任务供其它线程进行消费，你必须知道怎么进行线程间通信来解决这个问题。比较低级的办法是用wait和notify来解决这个问题，比较赞的办法是用Semaphore 或者 BlockingQueue来实现生产者消费者模型，这篇教程有实现它。
## 如何避免死锁？
Java多线程中的死锁
死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力作用，它们都将无法推进下去。这是一个严重的问题，因为死锁会让你的程序挂起无法完成任务，死锁的发生必须满足以下四个条件：

- 互斥条件：一个资源每次只能被一个进程使用。
- 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
- 不剥夺条件：进程已获得的资源，在末使用完之前，不能强行剥夺。
- 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。
避免死锁最简单的方法就是阻止循环等待条件，将系统中所有的资源设置标志位、排序，规定所有的进程申请资源必须以一定的顺序（升序或降序）做操作来避免死锁。

## Java中活锁和死锁有什么区别？
这是上题的扩展，活锁和死锁类似，不同之处在于处于活锁的线程或进程的状态是不断改变的，活锁可以认为是一种特殊的饥饿。一个现实的活锁例子是两个人在狭小的走廊碰到，两个人都试着避让对方好让彼此通过，但是因为避让的方向都一样导致最后谁都不能通过走廊。简单的说就是，活锁和死锁的主要区别是前者进程的状态可以改变但是却不能继续执行。
##  怎么检测一个线程是否拥有锁？
我一直不知道我们竟然可以检测一个线程是否拥有锁，直到我参加了一次电话面试。在java.lang.Thread中有一个方法叫holdsLock()，它返回true如果当且仅当当前线程拥有某个具体对象的锁。
## 你如何在Java中获取线程堆栈？
对于不同的操作系统，有多种方法来获得Java进程的线程堆栈。当你获取线程堆栈时，JVM会把所有线程的状态存到日志文件或者输出到控制台。在Windows你可以使用Ctrl + Break组合键来获取线程堆栈，Linux下用kill -3命令。你也可以用jstack这个工具来获取，它对线程id进行操作，你可以用jps这个工具找到id。
## JVM中哪个参数是用来控制线程的栈堆栈小的
这个问题很简单， -Xss参数用来控制线程的堆栈大小。你可以查看JVM配置列表来了解这个参数的更多信息。
## Java中synchronized 和 ReentrantLock 有什么不同？
Java在过去很长一段时间只能通过synchronized关键字来实现互斥，它有一些缺点。比如你不能扩展锁之外的方法或者块边界，尝试获取锁时不能中途取消等。Java 5 通过Lock接口提供了更复杂的控制来解决这些问题。 ReentrantLock 类实现了 Lock，它拥有与 synchronized 相同的并发性和内存语义且它还具有可扩展性。
## 有三个线程T1，T2，T3，怎么确保它们按顺序执行？
在多线程中有多种方法让线程按特定顺序执行，你可以用线程类的join()方法在一个线程中启动另一个线程，另外一个线程完成该线程继续执行。为了确保三个线程的顺序你应该先启动最后一个(T3调用T2，T2调用T1)，这样T1就会先完成而T3最后完成。
## Thread类中的yield方法有什么作用？
Yield方法可以暂停当前正在执行的线程对象，让其它有相同优先级的线程执行。它是一个静态方法而且只保证当前线程放弃CPU占用而不能保证使其它线程一定能占用CPU，执行yield()的线程有可能在进入到暂停状态后马上又被执行。
## Java中ConcurrentHashMap的并发度是什么？
ConcurrentHashMap把实际map划分成若干部分来实现它的可扩展性和线程安全。这种划分是使用并发度获得的，它是ConcurrentHashMap类构造函数的一个可选参数，默认值为16，这样在多线程情况下就能避免争用。
## Java中Semaphore是什么？
Java中的Semaphore是一种新的同步类，它是一个计数信号。从概念上讲，从概念上讲，信号量维护了一个许可集合。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release()添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore只对可用许可的号码进行计数，并采取相应的行动。信号量常常用于多线程的代码中，比如数据库连接池。
## 如果你提交任务时，线程池队列已满。会时发会生什么？
这个问题问得很狡猾，许多程序员会认为该任务会阻塞直到线程池队列有空位。事实上如果一个任务不能被调度执行那么ThreadPoolExecutor’s submit()方法将会抛出一个RejectedExecutionException异常。
## Java线程池中submit() 和 execute()方法有什么区别？
两个方法都可以向线程池提交任务，execute()方法的返回类型是void，它定义在Executor接口中, 而submit()方法可以返回持有计算结果的Future对象，它定义在ExecutorService接口中，它扩展了Executor接口，其它线程池类像ThreadPoolExecutor和ScheduledThreadPoolExecutor都有这些方法。
## 什么是阻塞式方法？
阻塞式方法是指程序会一直等待该方法完成期间不做其他事情，ServerSocket的accept()方法就是一直等待客户端连接。这里的阻塞是指调用结果返回之前，当前线程会被挂起，直到得到结果之后才会返回。此外，还有异步和非阻塞式方法在任务完成前就返回。
## Swing是线程安全的吗？ 为什么？
你可以很肯定的给出回答，Swing不是线程安全的，但是你应该解释这么回答的原因即便面试官没有问你为什么。当我们说swing不是线程安全的常常提到它的组件，这些组件不能在多线程中进行修改，所有对GUI组件的更新都要在AWT线程中完成，而Swing提供了同步和异步两种回调方法来进行更新。

## Java中invokeAndWait 和 invokeLater有什么区别？
这两个方法是Swing API 提供给Java开发者用来从当前线程而不是事件派发线程更新GUI组件用的。InvokeAndWait()同步更新GUI组件，比如一个进度条，一旦进度更新了，进度条也要做出相应改变。如果进度被多个线程跟踪，那么就调用invokeAndWait()方法请求事件派发线程对组件进行相应更新。而invokeLater()方法是异步调用更新组件的。
## Swing API中那些方法是线程安全的？
这个问题又提到了swing和线程安全，虽然组件不是线程安全的但是有一些方法是可以被多线程安全调用的，比如repaint(), revalidate()。 JTextComponent的setText()方法和JTextArea的insert() 和 append() 方法也是线程安全的。
## 如何在Java中创建Immutable对象？
这个问题看起来和多线程没什么关系， 但不变性有助于简化已经很复杂的并发程序。Immutable对象可以在没有同步的情况下共享，降低了对该对象进行并发访问时的同步化开销。可是Java没有@Immutable这个注解符，要创建不可变类，要实现下面几个步骤：通过构造方法初始化所有成员、对变量不要提供setter方法、将所有的成员声明为私有的，这样就不允许直接访问这些成员、在getter方法中，不要直接返回对象本身，而是克隆对象，并返回对象的拷贝。
## Java中的ReadWriteLock是什么？
一般而言，读写锁是用来提升并发程序性能的锁分离技术的成果。Java中的ReadWriteLock是Java 5 中新增的一个接口，一个ReadWriteLock维护一对关联的锁，一个用于只读操作一个用于写。在没有写线程的情况下一个读锁可能会同时被多个读线程持有。写锁是独占的，你可以使用JDK中的ReentrantReadWriteLock来实现这个规则，它最多支持65535个写锁和65535个读锁。
## 多线程中的忙循环是什么?
忙循环就是程序员用循环让一个线程等待，不像传统方法wait(), sleep() 或 yield() 它们都放弃了CPU控制，而忙循环不会放弃CPU，它就是在运行一个空循环。这么做的目的是为了保留CPU缓存，在多核系统中，一个等待线程醒来的时候可能会在另一个内核运行，这样会重建缓存。为了避免重建缓存和减少等待重建的时间就可以使用它了。
## volatile 变量和 atomic 变量有什么不同？
这是个有趣的问题。首先，volatile 变量和 atomic 变量看起来很像，但功能却不一样。Volatile变量可以确保先行关系，即写操作会发生在后续的读操作之前, 但它并不能保证原子性。例如用volatile修饰count变量那么 count++ 操作就不是原子性的。而AtomicInteger类提供的atomic方法可以让这种操作具有原子性如getAndIncrement()方法会原子性的进行增量操作把当前值加一，其它数据类型和引用变量也可以进行相似操作。
## 如果同步块内的线程抛出异常会发生什么？
这个问题坑了很多Java程序员，若你能想到锁是否释放这条线索来回答还有点希望答对。无论你的同步块是正常还是异常退出的，里面的线程都会释放锁，所以对比锁接口我更喜欢同步块，因为它不用我花费精力去释放锁，该功能可以在finally block里释放锁实现。
## 单例模式的双检锁是什么？
这个问题在Java面试中经常被问到，但是面试官对回答此问题的满意度仅为50%。一半的人写不出双检锁还有一半的人说不出它的隐患和Java1.5是如何对它修正的。它其实是一个用来创建线程安全的单例的老方法，当单例实例第一次被创建时它试图用单个锁进行性能优化，但是由于太过于复杂在JDK1.4中它是失败的，我个人也不喜欢它。无论如何，即便你也不喜欢它但是还是要了解一下，因为它经常被问到。
## 如何在Java中创建线程安全的Singleton？
这是上面那个问题的后续，如果你不喜欢双检锁而面试官问了创建Singleton类的替代方法，你可以利用JVM的类加载和静态变量初始化特征来创建Singleton实例，或者是利用枚举类型来创建Singleton，我很喜欢用这种方法。
## 写出3条你遵循的多线程最佳实践
这种问题我最喜欢了，我相信你在写并发代码来提升性能的时候也会遵循某些最佳实践。以下三条最佳实践我觉得大多数Java程序员都应该遵循：

- 给你的线程起个有意义的名字。
这样可以方便找bug或追踪。OrderProcessor, QuoteProcessor or TradeProcessor 这种名字比 Thread-1. Thread-2 and Thread-3 好多了，给线程起一个和它要完成的任务相关的名字，所有的主要框架甚至JDK都遵循这个最佳实践。
- 避免锁定和缩小同步的范围
锁花费的代价高昂且上下文切换更耗费时间空间，试试最低限度的使用同步和锁，缩小临界区。因此相对于同步方法我更喜欢同步块，它给我拥有对锁的绝对控制权。
- 多用同步类少用wait 和 notify
首先，CountDownLatch, Semaphore, CyclicBarrier 和 Exchanger 这些同步类简化了编码操作，而用wait和notify很难实现对复杂控制流的控制。其次，这些类是由最好的企业编写和维护在后续的JDK中它们还会不断优化和完善，使用这些更高等级的同步工具你的程序可以不费吹灰之力获得优化。
- 多用并发集合少用同步集合
这是另外一个容易遵循且受益巨大的最佳实践，并发集合比同步集合的可扩展性更好，所以在并发编程时使用并发集合效果更好。如果下一次你需要用到map，你应该首先想到用ConcurrentHashMap。
## 如何强制启动一个线程？
这个问题就像是如何强制进行Java垃圾回收，目前还没有觉得方法，虽然你可以使用System.gc()来进行垃圾回收，但是不保证能成功。在Java里面没有办法强制启动一个线程，它是被线程调度器控制着且Java没有公布相关的API。
## Java中的fork join框架是什么？
fork join框架是JDK7中出现的一款高效的工具，Java开发人员可以通过它充分利用现代服务器上的多处理器。它是专门为了那些可以递归划分成许多子模块设计的，目的是将所有可用的处理能力用来提升程序的性能。fork join框架一个巨大的优势是它使用了工作窃取算法，可以完成更多任务的工作线程可以从其它线程中窃取任务来执行。
## Java多线程中调用wait() 和 sleep()方法有什么不同？
Java程序中wait 和 sleep都会造成某种形式的暂停，它们可以满足不同的需要。wait()方法用于线程间通信，如果等待条件为真且其它线程被唤醒时它会释放锁，而sleep()方法仅仅释放CPU资源或者让当前线程停止执行一段时间，但不会释放锁。


# JavaWeb以及Spring相关

## Tomcat，Apache，JBoss的区别？
- Apache是Http服务器，Tomcat是web服务器，JBoss是应用服务器。
- Apache解析静态的html文件；Tomcat可解析jsp动态页面、也可充当servlet容器。

## GET，POST区别？
- Get是从服务器端获取数据，Post则是向服务器端发送数据。
- 在客户端，Get方式通过URL提交数据，在URL地址栏可以看到请求消息，该消息被编码过；Post数据则是放在Html header内提交。
- 对于Get方式，服务器端用Request.QueryString获取变量的值；对用Post方式，服务器端用Request.Form获取提交的数据值。
- Get方式提交的数据最多1024字节，而Post则没有限制。
- Get方式提交的参数及参数值会在地址栏显示，不安全，而Post不会，比较安全。

## Session, Cookie区别
- Session由应用服务器维护的一个服务器端的存储空间；Cookie是客户端的存储空间，由浏览器维护。
- 用户可以通过浏览器设置决定是否保存Cookie，而不能决定是否保存Session，因为Session是由服务器端维护的。
- Session中保存的是对象，Cookie中保存的是字符串。
- Session和Cookie不能跨窗口使用，每打开一个浏览器系统会赋予一个SessionID，此时的SessionID不同，若要完成跨浏览器访问数据，可以使用       Application。
- Session、Cookie都有失效时间，过期后会自动删除，减少系统开销。

## Servlet的生命周期
大致分为4步骤：Servlet类加载-->实例化-->服务-->销毁
下图是Tomcat中Servlet时序图。
![](/images/servlet_life.png)

- Web Client向Servlet容器(Tomcat)发出Http请求。
- Servlet容器接收Client端的请求。
- Servlet容器创建一个HttpRequest对象，将Client的请求信息封装到这个对象中。
- Servlet创建一个HttpResponse对象。
- Servlet调用HttpServlet对象的service方法，把HttpRequest对象和HttpResponse对象作为参数传递给HttpServlet对象中。
- HttpServlet调用HttpRequest对象的方法，获取Http请求，并进行相应处理。
- 处理完成HttpServlet调用HttpResponse对象的方法，返回响应数据。
- Servlet容器把HttpServlet的响应结果传回客户端。
其中的3个方法说明了Servlet的生命周期：
- init()：负责初始化Servlet对象。
- service()：负责响应客户端请求。
- destroy()：当Servlet对象推出时，负责释放占用资源。

## sendRedirect, foward区别
foward是服务器端控制页面转向，在客户端的浏览器地址中不会显示转向后的地址；sendRedirect则是完全的跳转，浏览器中会显示跳转的地址并重新发送请求链接。
原理：forward是服务器请求资源，服务器直接访问目标地址的URL，把那个URL的响应内容读取过来，然后再将这些内容返回给浏览器，浏览器根本不知道服务器发送的这些内容是从哪来的，所以地址栏还是原来的地址。

redirect是服务器端根据逻辑，发送一个状态码，告诉浏览器重新去请求的那个地址，浏览器会用刚才的所有参数重新发送新的请求。

## 谈谈Hibernate的理解，一级和二级缓存的作用，在项目中Hibernate都是怎么使用缓存的。
Hibernate是一个开发的对象关系映射框架（ORM）。它对JDBC进行了非常对象封装，Hibernate允许程序员采用面向对象的方式来操作关系数据库。
Hibernate的优点：

- 程序更加面向对象
- 提高了生产率
- 方便移植
- 无入侵性。
缺点：
- 效率比JDBC略差
- 不适合批量操作
- 只能配置一种关联关系
Hibernate有四种查询方式：
- get、load方法，根据id号查询对象。
- Hibernate query language
- 标准查询语言
- 通过sql查询
Hibernage工作原理：
- 配置hibernate对象关系映射文件、启动服务器
- 服务器通过实例化Configuration对象，读取hibernate.cfg.xml文件的配置内容，并根据相关的需求建好表以及表之间的映射关系。
- 通过实例化的Configuration对象建立SeesionFactory实例，通过SessionFactory实例创建Session对象。
- 通过Seesion对象完成数据库的增删改查操作。
Hibernate中的状态转移
临时状态（transient）
- 不处于session缓存中
- 数据库中没有对象记录
java是如何进入临时状态的：
- 通过new语句创建一个对象时。
- 刚调用session的delete方法时，从seesion缓存中删除一个对象时。
持久化状态(persisted)
- 处于session缓存中
- 持久化对象数据库中没有对象记录
- seesion在特定的时刻会保存两者同步
java如何进入持久化状态：
- session的save()方法。
- session的load().get()方法返回的对象。
- session的find()方法返回的list集合中存放的对象。
- session的update().save()方法。
流离状态（detached）
- 不再位于session缓存中
- 游离对象由持久化状态转变而来，数据库中还没有相应记录。
java如何进入流离状态：
- Session的close()。
- Session的evict()方法，从缓存中删除一个对象。
Hibernate中的缓存主要有Session缓存（一级缓存）和SessionFactory缓存（二级缓存，一般由第三方提供）。

## 谈谈Hibernate与Ibatis的区别，哪个性能会更高一些
- Hibernate偏向于对象的操作达到数据库相关操作的目的；而ibatis更偏向于sql语句的优化。
- Hibernate的使用的查询语句是自己的hql，而ibatis则是标准的sql语句。
- Hibernate相对复杂，不易学习；ibatis类似sql语句，简单易学。
性能方面：
- 如果系统数据处理量巨大，性能要求极为苛刻时，往往需要人工编写高性能的sql语句或存错过程，此时ibatis具有更好的可控性，因此性能优于Hibernate。
- 同样的需求下，由于hibernate可以自动生成hql语句，而ibatis需要手动写sql语句，此时采用Hibernate的效率高于ibatis。

## 对Spring的理解，项目中都用什么？怎么用的？对IOC、和AOP的理解及实现原理

Spring是一个开源框架，处于MVC模式中的控制层，它能应对需求快速的变化，其主要原因它有一种面向切面编程（AOP）的优势，其次它提升了系统性能，因为通过依赖倒置机制（IOC），系统中用到的对象不是在系统加载时就全部实例化，而是在调用到这个类时才会实例化该类的对象，从而提升了系统性能。这两个优秀的性能            使得Spring受到许多J2EE公司的青睐，如阿里里中使用最多的也是Spring相关技术。
Spring的优点：

- 降低了组件之间的耦合性，实现了软件各层之间的解耦。
- 可以使用容易提供的众多服务，如事务管理，消息服务，日志记录等。
- 容器提供了AOP技术，利用它很容易实现如权限拦截、运行期监控等功能。
Spring中AOP技术是设计模式中的动态代理模式。只需实现jdk提供的动态代理接口InvocationHandler，所有被代理对象的方法都由InvocationHandler接管实际的处理任务。面向切面编程中还要理解切入点、切面、通知、织入等概念。
Spring中IOC则利用了Java强大的反射机制来实现。所谓依赖注入即组件之间的依赖关系由容器在运行期决定。其中依赖注入的方法有两种，通过构造函数注入，通过set方法进行注入。

## 描述struts的工作流程
- 在web应用启动时，加载并初始化ActionServlet，ActionServlet从struts-config.xml文件中读取配置信息，将它们存放到各个配置对象中。
- 当ActionServlet接收到一个客户请求时，首先检索和用户请求相匹配的ActionMapping实例，如果不存在，就返回用户请求路径无效信息。
- 如果ActionForm实例不存在，就创建一个ActionForm对象，把客户提交的表单数据保存到ActionForm对象中。
- 根据配置信息决定是否需要验证表单，如果需要，就调用ActionForm的validate()方法，如果ActionForm的validate()方法返回null或返回一个不包含ActionMessage的ActionErrors对象，就表示表单验证成功。
- ActionServlet根据ActionMapping实例包含的映射信息决定请求转发给哪个Action，如果相应的Action实例不存在，就先创建一个实例，然后调用Action的execute()方法。
- Action的execute()方法返回一个ActionForward对象，ActionServlet再把客户请求转发给ActionForward对象指向的JSP组件。
- ActionForward对象指向的JSP组件生成动态网页，返回给客户。


## Spring补充
### 什么是Spring？
Spring的核心是一个轻量级的容器（Container）,它是实现IoC(Inversion of Control)容器和非侵入性（No intrusive）的框架，并提供AOP(Aspect-oriented Programming)的实现方式，提供对持久层（Persistence）、事务（Transcation）的支持;提供MVC Web框架的实现，并对一些常用的企业服务API提供了一致的模型封装，是一个全方位的应用程序框架，除此之外，对现存的各种框架（Structs、JSF、Hibernate、Ibatis、Webwork等），Spring也提供了与他们相整合的方案。 
细化：
 
- Spring的核心是一个轻量级（Lightweight）的容器（Container）。 
- Spring是实现IoC（Inversion of Control）容器和非入侵性（No intrusive）的框架。 
- Spring提供AOP（Aspect-oriented programming）的实现方式，把应用业务逻辑和系统服务分开。 
- Spring提供对持久层（Persistence）、事物（Transcation）的支持。 
- Spring供MVC Web框架的实现，并对一些常用的企业服务API（Application Interface）提供一致的模型封装。 
-Spring提供了对现存的各种框架（Structs、JSF、Hibernate、Ibatis、Webwork等）相整合的方案。 
总之，Spring是一个全方位的应用程序框架。

### Spring的核心
#### IoC/DI(控制反转/依赖注入)： 
- 控制反转可以分开来解读，控制和反转-> 首先控制什么?对什么进行控制? 其实此处的控制指的是程序中的一些对象或者变量的控制权，在传统的程序中都是由应用程序自己控制对象创建或者变量赋值，这是一种主动式的控制，导致组件之间的完全耦合；现在将一些对象或者变量的创建控制权交给一个叫做Ioc容器的东西，由这个容器来控制应用程序中所需要的资源,这样就变成了被动的控制，对组件之间的关系进行解耦，所以所谓的反转就是将控制权由应用程序转交到Ioc容器。 
- 依赖注入：同样将DI分开来解读，依赖和注入-> 首先依赖什么？谁依赖谁？ 其实应用程序中所需要的资源创建和获取都是要依赖于Ioc容器，需要IoC容器装配类之间的关系，即应用程序依赖于IoC容器的装配功能；相反，注入就是IoC容器向应用程序中进行注入应用程序所需要的资源，由应用程序主动装配对象的依赖变应用程序被动接受依赖，所以IoC容器也叫DI容器。
综上所述，控制权的主动与被动式其实都是相对于（参考物）IoC容器来说的，也可以将IoC模式看做是工厂模式的升华，不同的是Spring中的控制反转所用到的是Java的“反射”技术，通过在XML文件中定义应用程序所需要的类，再由IoC容器根据xml文件创建这些对象。所以这也形成了工厂与对象生成这两者独立分隔开，目的就是提高灵活性和可维护性。之所以将对象生成放到xml文件中，如果我们想要换一个实现的类将变得很简单，只需要修改xml文件即可。 
#### AOP(面向切面编程)：将具体的通用的应用从业务逻辑中分离出来，各自做各自专业的事情。 
- 切面：简单的理解就是一个类，每个或者对象 
- 连接点：类中的方法（可以切入的地方） 
- 通知：切面在某个连接点执行的操作(分为: Before advice , After returning advice , After throwing advice , After (finally) advice , Around advice )； 
- 切入点：符合切点表达式的连接点，也就是真正被切入的地方 
### Spring注入Bean的方式
- 设值注入（set方法） 
- 构造器注入 
- 工厂方法 
Spring加载Bean的流程： 
- 创建一个上下文context = createApplicationContext; 
- context中都会有一个BeanFactory（默认是DefaultListableBeanFactory）,在该类的子类类xmlBeanFactory中进行xml文件的解析； 
- 在类XmlBeanDefinitionParser 中用Dom解析xml文件(DefaultXmlBeanDefinitionParser)，解析xml文件中所有bean，并将bean放到BeanDefinitionHolder中，封装成BeanDefinition； 
- 再进行bean的注册，具体在BeanDefinitionReaderUtils类调用DefaultListableBeanFactory类的registerBeanDefinition进行bean的注册，在这里用了一HashMap存放bean,其中用Beanname作为键值，其封装好的beanDefinition作为值。还有用一个List存放所有的bean的名字。

设值注入和构造器注入的区别

- 在设置注入需要该Bean包含这些属性的setter方法； 
- 与传统的JavaBean的写法更相似，程序开发人员更容易理解、接收。通过setter方法设定依赖关系显得更加只管; 
- 对于复杂的依赖关系，如果采用构造注入，会导致构造器参数列表复杂，难以阅读。Spring在创建Bean实例时，需要同时实例化其它依赖的全部实例，因而导致性能下降。而使用设值注入，则能避免这些问题； 
- 尤其是在某些属性可选的情况况下，多参数的构造器显得更加复杂; 

但是在其他的场景，构造器注入显得更好的性能： 

- 构造注入需要该Bean包含带有这些属性的构造器; 
- 构造注入可以在构造器中决定依赖关系的注入顺序，优先依赖的优先注入; 
- 对于依赖关系无需变化的Bean，构造注入更有用处。因为没有Setter方法，所有的依赖关系全部在构造器内设定。因此，无需担心后续的代码对依赖关系产生破坏 
-  依赖关系只能在构造器中设定，则只有组件的创建者才能改变组件的依赖关系。对组件的调用者而言，组件内部的依赖关系完全透明，更符合高内聚的原则.
### Bean的生命周期（以BeanFactory）
- Bean的建立，由BeanFactory读取Bean定义文件，并创建Bean实例； 
-  执行Bean的属性注入,Setter注入； 
-  如果Bean类实现了org.springframework.beans.factory.BeanNameAware接口,则执行其setBeanName方法； 
-  如果Bean类实现了org.springframework.beans.factory.BeanFactoryAware接口,则执行其setBeanFactory方法； 
-  如果容器中有实现org.springframework.beans.factory.BeanPostProcessors接口的实例，则任何Bean在初始化之前都会执行这个实例的processBeforeInitialization()方法； 
-  如果Bean类实现了org.springframework.beans.factory.InitializingBean接口，则执行其afterPropertiesSet()方法； 
-  调用Bean的初始化方法”init-method” (！！注意，init-method方法没有参数)； 
-  如果容器中有实现org.springframework.beans.factory.BeanPostProcessors接口的实例，则任何Bean在初始化之后都会执行这个实例的processAfterInitialization()方法； 
-  使用Bean做一些业务逻辑…. 
-  使用完，容器关闭，如果Bean类实现了org.springframework.beans.factory.DisposableBean接口，则执行它的destroy()方法； 
-  在容器关闭时，可以在Bean定义文件中使用“destory-method”定义的方法，销毁Bean (！！注意，destory-method方法没有参数)；
ApplicationContext中bean的生命周期也是类似的。
### BeanFactory 和ApplicationContext的区别
- 首先BeanFactory和ApplicationContext都是接口，并且ApplicationContext是BeanFactory的子接口。
- 其次BeanFactory是Spring中最底层的接口，提供了最简单的容器的功能，只提供了实例化对象和拿对象的功能， 
ApplicationContext（应用上下文）它是Spring的一个更高级的容器，提供了更多的有用的功能； 
1)ApplicationContext继承了BeanFactory接口，所以，ApplicationContext也能像BeanFactory从容器中得到Bean(继承至 ListableBeanFactory); 
2)ApplicationContext提供的额外的功能： 
国际化的功能,消息发送、响应机制(继承至MessageSource );统一加载资源的功能(继承至ResourceLoader);强大的事件机制( 继承至ApplicationEventPublisher);对Web应用的支持()
- 它们的加载方式不同： 
1) BeanFactory采用的是延迟加载的形式来注入Bean,即只有在使用某个bean的时候，才对该Bean进行加载实例化.好处是节约内存，缺点是速度比较慢. 
2) ApplicationContext则相反的，它是在Ioc容易启动时就一次性创建所有的Bean,这样的好处是可以马上发现Spring配置文件中的错误。坏处就是浪费内存。
ApplicationContext的三种较常见的实现方式： 
1) ClassPathXmlApplicationContext:从classpath的xml配置文件中读取上下文，并生成上下文定义，应用程序上下文从程序环境中取得。
ApplicationContext context = new ClassPathXmlApplicationContext("****.xml");
2) FileSystemXmlApplicationContext:由文件系统中的xml配置文件读取上下文。
ApplicationContext context = new FileSystemXmlApplicationContext("****.xml");
3) XmlWebApplicationContext:由Web应用的Xml文件读取上下文。
### Spring Bean的作用域
-  Singleton: 这是默认的作用域，这种范围确保不管接受多少个请求，每个容器中只有一个bean的实例，单例模式有BeanFactory自身维护； 
-  Prototype: 原形范围与单例范围相反，为每一个bean请求提供一个实例； 
-  Request: 在请求bean范围内会为每一个来自客户端的网络请求创建一个实例，在请求完成以后，bean会失效并被垃圾回收器回收； 
-  Session: 与请求范围类似，确保每个session中有一个bean的实例，在session过期后，bean会随之失效； 
-  global-session: global-session和Portlet应用相关。当你的应用部署在Portlet容器中工作时，它包含很多portlet。如果你想要声明让所有的portlet共用全局的存储变量的话，那么这全局变量需要存储在global-session中。
### Bean的自动装配模式
1.  no: spring默认的设置，在该设置下自动装配是关闭的，开发者需要在配置文件中用标签明确依赖关系；
2.  byName: 该选项可以根据bean名称设置依赖关系。当向一个bean中自动装配一个属性时，容器将根据bean的名称自动在在配置文件中查询一个匹配的bean。如果找到的话，就装配这个属性，如果没找到的话就报错。
3.  byType: 该选项可以根据bean类型设置依赖关系。当向一个bean中自动装配一个属性时，容器将根据bean的类型自动在在配置文件中查询一个匹配的bean。如果找到的话，就装配这个属性，如果没找到的话就报错。
4.  constructor: 构造器自动装载，仅仅适用于与有构造器相同参数的bean，如果在容器中没有找到与构造器参数类型一致的bean，那么将会抛出异常。
5.  autodetect: 该模式自动探测使用构造器自动装配或者byType自动装配。先尝试找合适的带参数的构造函数，若没有则自动选择byType的自动装配模式。
基于注解的自动装配，spring默认是关闭注解模式的，所以需要在配置文件中设置 
### 各种注解的解释
1.  @Required: 验证bean是否被正确的设置了，需要在Ioc容器中注册RequiredAnnotationBeanPostProcessor，它是Spring中的后置处理用来验证被@Required 注解的bean属性是否被正确的设置了,若没有属性被@Required注解过的话，后置处理器会抛出一个BeanInitializationException异常。 

2.  @AutoWired: 该注解用于在bean的设值方法上自动装配bean的属性，一个参数或者带有任意名称或带有多个参数的方法。（尝试用byType 自动装配）
3.  @Qualifer: 该注解一般和@AutoWired一起使用，用于帮助Ioc容器能知道当前注解的属性应该自动装配哪一个。（对于在xml文件中定义了多个同类的bean,但是id不同，若单单用@AutoWired进行注解，Ioc容器无法分辨出应该自动装配哪一个bean）
### Spring 中的所有哪些不同类型的事件？
Spring的ApplicationContext提供了支持事务和代码中添加监听器的功能。 
可以创建一个bean其实现ApplicationListener接口（类型是ApplicationEvent）,当一个ApplicationEvent 被发布后，bean就自动被通知，并且在方法onApplicationEvent(…)方法中处理该事件。
在Spring中有5中标准的事件： 
1. 上下文更新事件（ContextRefreshedEvent）:该事件会在ApplicationContext被初始化或者更新时发布，也可以在调用ConfigurableApplicationContext接口中的refresh()方法时被触发。 
2. 上下文开始事件（ContextStartedEvent）: 当容器调用ConfigurableApplicationContext的Start()方法开始/重新开始容器时被触发。 
3. 上下文停止事件（ContextStoppedEvent）: 当容器调用ConfigurableApplicationContext的Stop()方法停止容器时触发该事件。 
4. 上下文关闭事件（ContextClosedEvent）: 当ApplicationContext被关闭时触发该事件。容器被关闭时，其管理的所有单例Bean都被销毁。 
5. 请求处理事件（RequestHandledEvent）: 在Web应用中，当一个http请求（request）结束触发该事件。
spring也让用户可以自定义事件类型,继承ApplicationEvent。
### Spring 框架中都用到了哪些设计模式？
1.  代理模式—在AOP和remoting中被用的比较多。
2.  单例模式—在spring配置文件中定义的bean默认为单例模式。
3.  模板方法—用来解决代码重复的问题。比如. RestTemplate, JmsTemplate, JpaTemplate。
4.  前端控制器—Spring提供了DispatcherServlet来对请求进行分发。
5.  视图帮助(View Helper )—Spring提供了一系列的JSP标签，高效宏来辅助将分散的代码整合在视图里。
6.  依赖注入—贯穿于BeanFactory / ApplicationContext接口的核心理念。
7.  工厂模式—BeanFactory用来创建对象的实例。

## Spring框架的7个模块
Spring 框架是一个分层架构，由 7 个定义良好的模块组成。Spring 模块构建在核心容器之上，核心容器定义了创建、配置和管理 bean 的方式，组成 Spring 框架的每个模块（或组件）都可以单独存在，或者与其他一个或多个模块联合实现。每个模块的功能如下：

### 核心容器：
核心容器提供 Spring 框架的基本功能。核心容器的主要组件是 BeanFactory，它是工厂模式的实现。BeanFactory 使用控制反转 （IOC）模式将应用程序的配置和依赖性规范与实际的应用程序代码分开。
### Spring 上下文：
Spring 上下文是一个配置文件，向 Spring 框架提供上下文信息。Spring 上下文包括企业服务，例如 JNDI、EJB、电子邮件、国际化、校验和调度功能。
### Spring AOP：
通过配置管理特性，Spring AOP 模块直接将面向方面的编程功能集成到了 Spring 框架中。所以，可以很容易地使 Spring 框架管理的任何对象支持 AOP。Spring AOP 模块为基于 Spring 的应用程序中的对象提供了事务管理服务。通过使用 Spring AOP，不用依赖 EJB 组件，就可以将声明性事务管理集成到应用程序中。
### Spring DAO：
JDBC DAO 抽象层提供了有意义的异常层次结构，可用该结构来管理异常处理和不同数据库供应商抛出的错误消息。异常层次结构简化了错误处理，并且极大地降低了需要编写的异常代码数量（例如打开和关闭连接）。Spring DAO 的面向 JDBC 的异常遵从通用的 DAO 异常层次结构。
### Spring ORM：
Spring 框架插入了若干个 ORM 框架，从而提供了 ORM 的对象关系工具，其中包括 JDO、Hibernate 和 iBatis SQL Map。所有这些都遵从 Spring 的通用事务和 DAO 异常层次结构。
### Spring Web 模块：
Web 上下文模块建立在应用程序上下文模块之上，为基于 Web 的应用程序提供了上下文。所以，Spring 框架支持与 Jakarta Struts 的集成。Web 模块还简化了处理多部分请求以及将请求参数绑定到域对象的工作。
### Spring MVC 框架：
MVC 框架是一个全功能的构建 Web 应用程序的 MVC 实现。通过策略接口，MVC 框架变成为高度可配置的，MVC 容纳了大量视图技术，其中包括 JSP、Velocity、Tiles、iText 和 POI。

## 什么是Spring框架？Spring框架有哪些主要模块？
Spring框架是一个为Java应用程序的开发提供了综合、广泛的基础性支持的Java平台。Spring帮助开发者解决了开发中基础性的问题，使得开发人员可以专注于应用程序的开发。Spring框架本身亦是按照设计模式精心打造，这使得我们可以在开发环境中安心的集成Spring框架，不必担心Spring是如何在后台进行工作的。
Spring框架至今已集成了20多个模块。这些模块主要被分如下图所示的核心容器、数据访问/集成,、Web、AOP（面向切面编程）、工具、消息和测试模块。更多信息：Spring 框架教程。

## 使用Spring框架能带来哪些好处？
下面列举了一些使用Spring框架带来的主要好处：
Dependency Injection(DI) 方法使得构造器和JavaBean properties文件中的依赖关系一目了然。
与EJB容器相比较，IoC容器更加趋向于轻量级。这样一来IoC容器在有限的内存和CPU资源的情况下进行应用程序的开发和发布就变得十分有利。
Spring并没有闭门造车，Spring利用了已有的技术比如ORM框架、logging框架、J2EE、Quartz和JDK Timer，以及其他视图技术。
Spring框架是按照模块的形式来组织的。由包和类的编号就可以看出其所属的模块，开发者仅仅需要选用他们需要的模块即可。
要测试一项用Spring开发的应用程序十分简单，因为测试相关的环境代码都已经囊括在框架中了。更加简单的是，利用JavaBean形式的POJO类，可以很方便的利用依赖注入来写入测试数据。
Spring的Web框架亦是一个精心设计的Web MVC框架，为开发者们在web框架的选择上提供了一个除了主流框架比如Struts、过度设计的、不流行web框架的以外的有力选项。
Spring提供了一个便捷的事务管理接口，适用于小型的本地事物处理（比如在单DB的环境下）和复杂的共同事物处理（比如利用JTA的复杂DB环境）。

## 什么是控制反转(IOC)？什么是依赖注入？
控制反转是应用于软件工程领域中的，在运行时被装配器对象来绑定耦合对象的一种编程技巧，对象之间耦合关系在编译时通常是未知的。在传统的编程方式中，业务逻辑的流程是由应用程序中的早已被设定好关联关系的对象来决定的。在使用控制反转的情况下，业务逻辑的流程是由对象关系图来决定的，该对象关系图由装配器负责实例化，这种实现方式还可以将对象之间的关联关系的定义抽象化。而绑定的过程是通过“依赖注入”实现的。
控制反转是一种以给予应用程序中目标组件更多控制为目的设计范式，并在我们的实际工作中起到了有效的作用。
依赖注入是在编译阶段尚未知所需的功能是来自哪个的类的情况下，将其他对象所依赖的功能对象实例化的模式。这就需要一种机制用来激活相应的组件以提供特定的功能，所以依赖注入是控制反转的基础。否则如果在组件不受框架控制的情况下，框架又怎么知道要创建哪个组件？
在Java中依然注入有以下三种实现方式：

- 构造器注入
- Setter方法注入
- 接口注入

## 请解释下Spring框架中的IoC？
Spring中的 org.springframework.beans 包和 org.springframework.context包构成了Spring框架IoC容器的基础。
BeanFactory 接口提供了一个先进的配置机制，使得任何类型的对象的配置成为可能。ApplicationContex接口对BeanFactory（是一个子接口）进行了扩展，在BeanFactory的基础上添加了其他功能，比如与Spring的AOP更容易集成，也提供了处理message resource的机制（用于国际化）、事件传播以及应用层的特别配置，比如针对Web应用的WebApplicationContext。
org.springframework.beans.factory.BeanFactory 是Spring IoC容器的具体实现，用来包装和管理前面提到的各种bean。BeanFactory接口是Spring IoC 容器的核心接口。

## BeanFactory和ApplicationContext有什么区别？
BeanFactory 可以理解为含有bean集合的工厂类。BeanFactory 包含了种bean的定义，以便在接收到客户端请求时将对应的bean实例化。
BeanFactory还能在实例化对象的时生成协作类之间的关系。此举将bean自身与bean客户端的配置中解放出来。BeanFactory还包含了bean生命周期的控制，调用客户端的初始化方法（initialization methods）和销毁方法（destruction methods）。
从表面上看，application context如同bean factory一样具有bean定义、bean关联关系的设置，根据请求分发bean的功能。但application context在此基础上还提供了其他的功能。
提供了支持国际化的文本消息
统一的资源文件读取方式
已在监听器中注册的bean的事件
以下是三种较常见的 ApplicationContext 实现方式：

- ClassPathXmlApplicationContext：从classpath的XML配置文件中读取上下文，并生成上下文定义。应用程序上下文从程序环境变量中取得。
- FileSystemXmlApplicationContext ：由文件系统中的XML配置文件读取上下文。
- XmlWebApplicationContext：由Web应用的XML文件读取上下文。

## Spring有几种配置方式？
将Spring配置到应用开发中有以下三种方式：

- 基于XML的配置
- 基于注解的配置
- 基于Java的配置

## 如何用基于XML配置的方式配置Spring？
在Spring框架中，依赖和服务需要在专门的配置文件来实现，我常用的XML格式的配置文件。这些配置文件的格式通常用<beans>开头，然后一系列的bean定义和专门的应用配置选项组成。
SpringXML配置的主要目的时候是使所有的Spring组件都可以用xml文件的形式来进行配置。这意味着不会出现其他的Spring配置类型（比如声明的方式或基于Java Class的配置方式）
Spring的XML配置方式是使用被Spring命名空间的所支持的一系列的XML标签来实现的。Spring有以下主要的命名空间：context、beans、jdbc、tx、aop、mvc和aso。

## 如何用基于Java配置的方式配置Spring？
Spring对Java配置的支持是由@Configuration注解和@Bean注解来实现的。由@Bean注解的方法将会实例化、配置和初始化一个新对象，这个对象将由Spring的IoC容器来管理。@Bean声明所起到的作用与<bean/> 元素类似。被@Configuration所注解的类则表示这个类的主要目的是作为bean定义的资源。被@Configuration声明的类可以通过在同一个类的内部调用@bean方法来设置嵌入bean的依赖关系。
## 怎样用注解的方式配置Spring？
Spring在2.5版本以后开始支持用注解的方式来配置依赖注入。可以用注解的方式来替代XML方式的bean描述，可以将bean描述转移到组件类的内部，只需要在相关类上、方法上或者字段声明上使用注解即可。注解注入将会被容器在XML注入之前被处理，所以后者会覆盖掉前者对于同一个属性的处理结果。
注解装配在Spring中是默认关闭的。所以需要在Spring文件中配置一下才能使用基于注解的装配模式。

下面是几种比较重要的注解类型：

- @Required：该注解应用于设值方法。
- @Autowired：该注解应用于有值设值方法、非设值方法、构造方法和变量。
- @Qualifier：该注解和@Autowired注解搭配使用，用于消除特定bean自动装配的歧义。
- JSR-250 Annotations：Spring支持基于JSR-250 注解的以下注解，@Resource、@PostConstruct 和 @PreDestroy。

## 请解释Spring Bean的生命周期？
Spring Bean的生命周期简单易懂。在一个bean实例被初始化时，需要执行一系列的初始化操作以达到可用的状态。同样的，当一个bean不在被调用时需要进行相关的析构操作，并从bean容器中移除。
Spring bean factory 负责管理在spring容器中被创建的bean的生命周期。Bean的生命周期由两组回调（call back）方法组成。
初始化之后调用的回调方法。
销毁之前调用的回调方法。
Spring框架提供了以下四种方式来管理bean的生命周期事件：
InitializingBean和DisposableBean回调接口
针对特殊行为的其他Aware接口
Bean配置文件中的Custom init()方法和destroy()方法
@PostConstruct和@PreDestroy注解方式

## Spring Bean的作用域之间有什么区别？
Spring容器中的bean可以分为5个范围。所有范围的名称都是自说明的，但是为了避免混淆，还是让我们来解释一下：

- singleton：这种bean范围是默认的，这种范围确保不管接受到多少个请求，每个容器中只有一个bean的实例，单例的模式由bean factory自身来维护。
- prototype：原形范围与单例范围相反，为每一个bean请求提供一个实例。
- request：在请求bean范围内会每一个来自客户端的网络请求创建一个实例，在请求完成以后，bean会失效并被垃圾回收器回收。
- Session：与请求范围类似，确保每个session中有一个bean的实例，在session过期后，bean会随之失效。
- global-session：global-session和Portlet应用相关。当你的应用部署在Portlet容器中工作时，它包含很多portlet。如果你想要声明让所有的portlet共用全局的存储变量的话，那么这全局变量需要存储在global-session中。
全局作用域与Servlet中的session作用域效果相同。

## 什么是Spring inner beans？
在Spring框架中，无论何时bean被使用时，当仅被调用了一个属性。一个明智的做法是将这个bean声明为内部bean。内部bean可以用setter注入“属性”和构造方法注入“构造参数”的方式来实现。
比如，在我们的应用程序中，一个Customer类引用了一个Person类，我们的要做的是创建一个Person的实例，然后在Customer内部使用。

## Spring框架中的单例Beans是线程安全的么？
Spring框架并没有对单例bean进行任何多线程的封装处理。关于单例bean的线程安全和并发问题需要开发者自行去搞定。但实际上，大部分的Spring bean并没有可变的状态(比如Serview类和DAO类)，所以在某种程度上说Spring的单例bean是线程安全的。如果你的bean有多种状态的话（比如 View Model 对象），就需要自行保证线程安全。
最浅显的解决办法就是将多态bean的作用域由“singleton”变更为“prototype”。

## 请举例说明如何在Spring中注入一个Java Collection？
Spring提供了以下四种集合类的配置元素：
<list> :   该标签用来装配可重复的list值。
<set> :    该标签用来装配没有重复的set值。
<map>:   该标签可用来注入键和值可以为任何类型的键值对。
<props> : 该标签支持注入键和值都是字符串类型的键值对。

## 请解释Spring Bean的自动装配？
在Spring框架中，在配置文件中设定bean的依赖关系是一个很好的机制，Spring容器还可以自动装配合作关系bean之间的关联关系。这意味着Spring可以通过向Bean Factory中注入的方式自动搞定bean之间的依赖关系。自动装配可以设置在每个bean上，也可以设定在特定的bean上。
除了bean配置文件中提供的自动装配模式，还可以使用@Autowired注解来自动装配指定的bean。在使用@Autowired注解之前需要在按照如下的配置方式在Spring配置文件进行配置才可以使用。
也可以通过在配置文件中配置AutowiredAnnotationBeanPostProcessor 达到相同的效果。

## 请解释自动装配模式的区别？
在Spring框架中共有5种自动装配，让我们逐一分析。

- no：这是Spring框架的默认设置，在该设置下自动装配是关闭的，开发者需要自行在bean定义中用标签明确的设置依赖关系。
- byName：该选项可以根据bean名称设置依赖关系。当向一个bean中自动装配一个属性时，容器将根据bean的名称自动在在配置文件中查询一个匹配的bean。如果找到的话，就装配这个属性，如果没找到的话就报错。
- byType：该选项可以根据bean类型设置依赖关系。当向一个bean中自动装配一个属性时，容器将根据bean的类型自动在在配置文件中查询一个匹配的bean。如果找到的话，就装配这个属性，如果没找到的话就报错。
- constructor：造器的自动装配和byType模式类似，但是仅仅适用于与有构造器相同参数的bean，如果在容器中没有找到与构造器参数类型一致的bean，那么将会抛出异常。
- autodetect：该模式自动探测使用构造器自动装配或者byType自动装配。首先，首先会尝试找合适的带参数的构造器，如果找到的话就是用构造器自动装配，如果在bean内部没有找到相应的构造器或者是无参构造器，容器就会自动选择byTpe的自动装配方式。

## 如何开启基于注解的自动装配？
要使用 @Autowired，需要注册 AutowiredAnnotationBeanPostProcessor，可以有以下两种方式来实现：

- 引入配置文件中的<bean>下引入 <context:annotation-config>
- 在bean配置文件中直接引入AutowiredAnnotationBeanPostProcessor

## 请举例解释@Required注解？
在产品级别的应用中，IoC容器可能声明了数十万了bean，bean与bean之间有着复杂的依赖关系。设值注解方法的短板之一就是验证所有的属性是否被注解是一项十分困难的操作。可以通过在<bean>中设置“dependency-check”来解决这个问题。
在应用程序的生命周期中，你可能不大愿意花时间在验证所有bean的属性是否按照上下文文件正确配置。或者你宁可验证某个bean的特定属性是否被正确的设置。即使是用“dependency-check”属性也不能很好的解决这个问题，在这种情况下，你需要使用@Required 注解。
RequiredAnnotationBeanPostProcessor是Spring中的后置处理用来验证被@Required 注解的bean属性是否被正确的设置了。在使用RequiredAnnotationBeanPostProcesso来验证bean属性之前，首先要在IoC容器中对其进行注册：
<bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor" />
但是如果没有属性被用 @Required 注解过的话，后置处理器会抛出一个BeanInitializationException 异常。

## 请举例解释@Autowired注解？
@Autowired注解对自动装配何时何处被实现提供了更多细粒度的控制。@Autowired注解可以像@Required注解、构造器一样被用于在bean的设值方法上自动装配bean的属性，一个参数或者带有任意名称或带有多个参数的方法。
比如，可以在设值方法上使用@Autowired注解来替代配置文件中的 <property>元素。当Spring容器在setter方法上找到@Autowired注解时，会尝试用byType 自动装配。
当然我们也可以在构造方法上使用@Autowired 注解。带有@Autowired 注解的构造方法意味着在创建一个bean时将会被自动装配，即便在配置文件中使用<constructor-arg> 元素。

## 请举例说明@Qualifier注解？
@Qualifier注解意味着可以在被标注bean的字段上可以自动装配。Qualifier注解可以用来取消Spring不能取消的bean应用。

## 构造方法注入和设值注入有什么区别？
请注意以下明显的区别：

- 在设值注入方法支持大部分的依赖注入，如果我们仅需要注入int、string和long型的变量，我们不要用设值的方法注入。对于基本类型，如果我们没有注入的话，可以为基本类型设置默认值。在构造方法注入不支持大部分的依赖注入，因为在调用构造方法中必须传入正确的构造参数，否则的话为报错。
- 设值注入不会重写构造方法的值。如果我们对同一个变量同时使用了构造方法注入又使用了设置方法注入的话，那么构造方法将不能覆盖由设值方法注入的值。很明显，因为构造方法尽在对象被创建时调用。
- 在使用设值注入时有可能还不能保证某种依赖是否已经被注入，也就是说这时对象的依赖关系有可能是不完整的。而在另一种情况下，构造器注入则不允许生成依赖关系不完整的对象。
- 在设值注入时如果对象A和对象B互相依赖，在创建对象A时Spring会抛出sObjectCurrentlyInCreationException异常，因为在B对象被创建之前A对象是不能被创建的，反之亦然。所以Spring用设值注入的方法解决了循环依赖的问题，因对象的设值方法是在对象被创建之前被调用的。

## Spring框架中有哪些不同类型的事件？
Spring的ApplicationContext 提供了支持事件和代码中监听器的功能。
我们可以创建bean用来监听在ApplicationContext 中发布的事件。ApplicationEvent类和在ApplicationContext接口中处理的事件，如果一个bean实现了ApplicationListener接口，当一个ApplicationEvent 被发布以后，bean会自动被通知。
Spring 提供了以下5中标准的事件：

- 上下文更新事件（ContextRefreshedEvent）：该事件会在ApplicationContext被初始化或者更新时发布。也可以在调用ConfigurableApplicationContext 接口中的refresh()方法时被触发。
- 上下文开始事件（ContextStartedEvent）：当容器调用ConfigurableApplicationContext的Start()方法开始/重新开始容器时触发该事件。
- 上下文停止事件（ContextStoppedEvent）：当容器调用ConfigurableApplicationContext的Stop()方法停止容器时触发该事件。
- 上下文关闭事件（ContextClosedEvent）：当ApplicationContext被关闭时触发该事件。容器被关闭时，其管理的所有单例Bean都被销毁。
- 请求处理事件（RequestHandledEvent）：在Web应用中，当一个http请求（request）结束触发该事件。
除了上面介绍的事件以外，还可以通过扩展ApplicationEvent 类来开发自定义的事件。

## FileSystemResource和ClassPathResource有何区别？
在FileSystemResource 中需要给出spring-config.xml文件在你项目中的相对路径或者绝对路径。在ClassPathResource中spring会在ClassPath中自动搜寻配置文件，所以要把ClassPathResource 文件放在ClassPath下。
如果将spring-config.xml保存在了src文件夹下的话，只需给出配置文件的名称即可，因为src文件夹是默认。
简而言之，ClassPathResource在环境变量中读取配置文件，FileSystemResource在配置文件中读取配置文件。

## Spring 框架中都用到了哪些设计模式？
Spring框架中使用到了大量的设计模式，下面列举了比较有代表性的：

- 代理模式—在AOP和remoting中被用的比较多。
- 单例模式—在spring配置文件中定义的bean默认为单例模式。
- 模板方法—用来解决代码重复的问题。比如. RestTemplate, JmsTemplate, JpaTemplate。
- 前端控制器—Spring提供了DispatcherServlet来对请求进行分发。
- 视图帮助(View Helper )—Spring提供了一系列的JSP标签，高效宏来辅助将分散的代码整合在视图里。
- 依赖注入—贯穿于BeanFactory / ApplicationContext接口的核心理念。
- 工厂模式—BeanFactory用来创建对象的实例。

## Spring IoC
### 什么是Ioc/DI？
IoC 容器：最主要是完成了完成对象的创建和依赖的管理注入等等。
先从我们自己设计这样一个视角来考虑：
所谓控制反转，就是把原先我们代码里面需要实现的对象创建、依赖的代码，反转给容器来帮忙实现。那么必然的我们需要创建一个容器，同时需要一种描述来让容器知道需要创建的对象与对象的关系。这个描述最具体表现就是我们可配置的文件。
对象和对象关系怎么表示？
可以用 xml ， properties 文件等语义化配置文件表示。
描述对象关系的文件存放在哪里？
可能是 classpath ， filesystem ，或者是 URL 网络资源， servletContext 等。
回到正题，有了配置文件，还需要对配置文件解析。
不同的配置文件对对象的描述不一样，如标准的，自定义声明式的，如何统一？ 在内部需要有一个统一的关于对象的定义，所有外部的描述都必须转化成统一的描述定义。
如何对不同的配置文件进行解析？需要对不同的配置文件语法，采用不同的解析器
 
### Spring IOC体系结构？
(1) BeanFactory
    Spring Bean的创建是典型的工厂模式，这一系列的Bean工厂，也即IOC容器为开发者管理对象间的依赖关系提供了很多便利和基础服务，在Spring中有许多的IOC容器的实现供用户选择和使用，其相互关系如下：

 
其中BeanFactory作为最顶层的一个接口类，它定义了IOC容器的基本功能规范，BeanFactory 有三个子类：ListableBeanFactory、HierarchicalBeanFactory 和AutowireCapableBeanFactory。但是从上图中我们可以发现最终的默认实现类是 DefaultListableBeanFactory，他实现了所有的接口。那为何要定义这么多层次的接口呢？查阅这些接口的源码和说明发现，每个接口都有他使用的场合，它主要是为了区分在 Spring 内部在操作过程中对象的传递和转化过程中，对对象的数据访问所做的限制。例如 ListableBeanFactory 接口表示这些 Bean 是可列表的，而 HierarchicalBeanFactory 表示的是这些 Bean 是有继承关系的，也就是每个Bean 有可能有父 Bean。AutowireCapableBeanFactory 接口定义 Bean 的自动装配规则。这四个接口共同定义了 Bean 的集合、Bean 之间的关系、以及 Bean 行为.
在BeanFactory里只对IOC容器的基本行为作了定义，根本不关心你的bean是如何定义怎样加载的。正如我们只关心工厂里得到什么的产品对象，至于工厂是怎么生产这些对象的，这个基本的接口不关心。
 
而要知道工厂是如何产生对象的，我们需要看具体的IOC容器实现，spring提供了许多IOC容器的实现。比如XmlBeanFactory，ClasspathXmlApplicationContext等。其中XmlBeanFactory就是针对最基本的ioc容器的实现，这个IOC容器可以读取XML文件定义的BeanDefinition（XML文件中对bean的描述）,如果说XmlBeanFactory是容器中的屌丝，ApplicationContext应该算容器中的高帅富.
 
ApplicationContext是Spring提供的一个高级的IoC容器，它除了能够提供IoC容器的基本功能外，还为用户提供了以下的附加服务。
 
从ApplicationContext接口的实现，我们看出其特点：
 
 - 支持信息源，可以实现国际化。（实现MessageSource接口）
 - 访问资源。(实现ResourcePatternResolver接口，这个后面要讲)
 - 支持应用事件。(实现ApplicationEventPublisher接口) 
 
(2) BeanDefinition
 
SpringIOC容器管理了我们定义的各种Bean对象及其相互的关系，Bean对象在Spring实现中是以BeanDefinition来描述。

 Bean 的解析过程非常复杂，功能被分的很细，因为这里需要被扩展的地方很多，必须保证有足够的灵活性，以应对可能的变化。Bean 的解析主要就是对 Spring 配置文件的解析。这个解析过程主要通过下图中的类完成：

### IoC容器的初始化？
IoC容器的初始化包括BeanDefinition的Resource定位、载入和注册这三个基本的过程。我们以ApplicationContext为例讲解，ApplicationContext系列容器也许是我们最熟悉的，因为web项目中使用的XmlWebApplicationContext就属于这个继承体系，还有ClasspathXmlApplicationContext等。

ApplicationContext允许上下文嵌套，通过保持父上下文可以维持一个上下文体系。对于bean的查找可以在这个上下文体系中发生，首先检查当前上下文，其次是父上下文，逐级向上，这样为不同的Spring应用提供了一个共享的bean定义环境。
 
### IOC容器的依赖注入
1、依赖注入发生的时间
当Spring IoC容器完成了Bean定义资源的定位、载入和解析注册以后，IoC容器中已经管理类Bean定义的相关数据，但是此时IoC容器还没有对所管理的Bean进行依赖注入，依赖注入在以下两种情况发生：

- 用户第一次通过getBean方法向IoC容索要Bean时，IoC容器触发依赖注入。
- 当用户在Bean定义资源中为<Bean>元素配置了lazy-init属性，即让容器在解析注册Bean定义时进行预实例化，触发依赖注入。
BeanFactory接口定义了Spring IoC容器的基本功能规范，是Spring IoC容器所应遵守的最底层和最基本的编程规范。BeanFactory接口中定义了几个getBean方法，就是用户向IoC容器索取管理的Bean的方法，我们通过分析其子类的具体实现，理解Spring IoC容器在用户索取Bean时如何完成依赖注入。

 
 
通过对上面注入依赖代码的分析，我们已经明白了Spring IoC容器是如何将属性的值注入到Bean实例对象中去的：

- 对于集合类型的属性，将其属性值解析为目标类型的集合后直接赋值给属性。
- 对于非集合类型的属性，大量使用了JDK的反射和内省机制，通过属性的getter方法(reader method)获取指定属性注入以前的值，同时调用属性的setter方法(writer method)为属性设置注入后的值。看到这里相信很多人都明白了Spring的setter注入原理。

至此Spring IoC容器对Bean定义资源文件的定位，载入、解析和依赖注入已经全部分析完毕，现在Spring IoC容器中管理了一系列靠依赖关系联系起来的Bean，程序不需要应用自己手动创建所需的对象，Spring IoC容器会在我们使用的时候自动为我们创建，并且为我们注入好相关的依赖，这就是Spring核心功能的控制反转和依赖注入的相关功能。
### IoC容器的高级特性
1、介绍
      通过前面4篇文章对Spring IoC容器的源码分析，我们已经基本上了解了Spring IoC容器对Bean定义资源的定位、读入和解析过程，同时也清楚了当用户通过getBean方法向IoC容器获取被管理的Bean时，IoC容器对Bean进行的初始化和依赖注入过程，这些是Spring IoC容器的基本功能特性。Spring IoC容器还有一些高级特性，如使用lazy-init属性对Bean预初始化、FactoryBean产生或者修饰Bean对象的生成、IoC容器初始化Bean过程中使用BeanPostProcessor后置处理器对Bean声明周期事件管理和IoC容器的autowiring自动装配功能等。
2、Spring IoC容器的lazy-init属性实现预实例化：
      通过前面我们对IoC容器的实现和工作原理分析，我们知道IoC容器的初始化过程就是对Bean定义资源的定位、载入和注册，此时容器对Bean的依赖注入并没有发生，依赖注入主要是在应用程序第一次向容器索取Bean时，通过getBean方法的调用完成。
当Bean定义资源的<Bean>元素中配置了lazy-init属性时，容器将会在初始化的时候对所配置的Bean进行预实例化，Bean的依赖注入在容器初始化的时候就已经完成。这样，当应用程序第一次向容器索取被管理的Bean时，就不用再初始化和对Bean进行依赖注入了，直接从容器中获取已经完成依赖注入的现成Bean，可以提高应用第一次向容器获取Bean的性能。
 
 
通过对autowiring的源码分析，我们可以看出，autowiring的实现过程：
 
 - 对Bean的属性迭代调用getBean方法，完成依赖Bean的初始化和依赖注入。
 - 将依赖Bean的属性引用设置到被依赖的Bean属性上。
 - 将依赖Bean的名称和被依赖Bean的名称存储在IoC容器的集合中。
 
Spring IoC容器的autowiring属性自动依赖注入是一个很方便的特性，可以简化开发时的配置，但是凡是都有两面性，自动属性依赖注入也有不足，首先，Bean的依赖关系在配置文件中无法很清楚地看出来，对于维护造成一定困难。其次，由于自动依赖注入是Spring容器自动执行的，容器是不会智能判断的，如果配置不当，将会带来无法预料的后果，所以自动依赖注入特性在使用时还是综合考虑。

## Spring Bean 生命周期
### Spring 中bean 的生命周期短暂吗?
在spring中，从BeanFactory或ApplicationContext取得的实例为Singleton，也就是预设为每一个Bean的别名只能维持一个实例，而不是每次都产生一个新的对象使用Singleton模式产生单一实例，对单线程的程序说并不会有什么问题，但对于多线程的程序，就必须注意安全(Thread-safe)的议题，防止多个线程同时存取共享资源所引发的数据不同步问题。
然而在spring中 可以设定每次从BeanFactory或ApplicationContext指定别名并取得Bean时都产生一个新的实例：例如：
 
在spring中，singleton属性默认是true，只有设定为false，则每次指定别名取得的Bean时都会产生一个新的实例
一个Bean从创建到销毁，如果是用BeanFactory来生成,管理Bean的话，会经历几个执行阶段(如图1.1)：
 
 
- Bean的建立：
容器寻找Bean的定义信息并将其实例化。
- 属性注入：
使用依赖注入，Spring按照Bean定义信息配置Bean所有属性
- BeanNameAware的setBeanName()：
如果Bean类有实现org.springframework.beans.BeanNameAware接口，工厂调用Bean的setBeanName()方法传递Bean的ID。
- BeanFactoryAware的setBeanFactory()：
如果Bean类有实现org.springframework.beans.factory.BeanFactoryAware接口，工厂调用setBeanFactory()方法传入工厂自身。
- BeanPostProcessors的ProcessBeforeInitialization()
如果有org.springframework.beans.factory.config.BeanPostProcessors和Bean关联，那么其postProcessBeforeInitialization()方法将被将被调用。
- initializingBean的afterPropertiesSet()：
如果Bean类已实现org.springframework.beans.factory.InitializingBean接口，则执行他的afterProPertiesSet()方法
- Bean定义文件中定义init-method：
如果有以上设置的话，则执行到这个阶段，就会执行initBean()方法
- BeanPostProcessors的ProcessaAfterInitialization()
如果有任何的BeanPostProcessors实例与Bean实例关联，则执行BeanPostProcessors实例的ProcessaAfterInitialization()方法
此时，Bean已经可以被应用系统使用，并且将保留在BeanFactory中知道它不在被使用。有两种方法可以将其从BeanFactory中删除掉。
 

 
1：DisposableBean的destroy()
在容器关闭时，如果Bean类有实现org.springframework.beans.factory.DisposableBean接口，则执行他的destroy()方法
2：Bean定义文件中定义destroy-method
在容器关闭时，可以在Bean定义文件中使用"destroy-method"属性设定方法名称，例如：
 
如果有以上设定的话，则进行至这个阶段时，就会执行destroy()方法，如果是使用ApplicationContext来生成并管理Bean的话则稍有不同，使用ApplicationContext来生成及管理Bean实例的话，在执行BeanFactoryAware的setBeanFactory()阶段后，若Bean类上有实现org.springframework.context.ApplicationContextAware接口，则执行其setApplicationContext()方法，接着才执行BeanPostProcessors的ProcessBeforeInitialization()及之后的流程。
 

 
 
找工作的时候有些人会被问道Spring中Bean的生命周期，其实也就是考察一下对Spring是否熟悉，工作中很少用到其中的内容，那我们简单看一下。
在说明前可以思考一下Servlet的生命周期：实例化，初始init，接收请求service，销毁destroy；
Spring上下文中的Bean也类似，如下

- 实例化一个Bean－－也就是我们常说的new；
- 按照Spring上下文对实例化的Bean进行配置－－也就是IOC注入；
- 如果这个Bean已经实现了BeanNameAware接口，会调用它实现的setBeanName(String)方法，此处传递的就是Spring配置文件中Bean的id值
- 如果这个Bean已经实现了BeanFactoryAware接口，会调用它实现的setBeanFactory(setBeanFactory(BeanFactory)传递的是Spring工厂自身（可以用这个方式来获取其它Bean，只需在Spring配置文件中配置一个普通的Bean就可以）；
- 如果这个Bean已经实现了ApplicationContextAware接口，会调用setApplicationContext(ApplicationContext)方法，传入Spring上下文（同样这个方式也可以实现步骤4的内容，但比4更好，因为ApplicationContext是BeanFactory的子接口，有更多的实现方法）；
- 如果这个Bean关联了BeanPostProcessor接口，将会调用postProcessBeforeInitialization(Object obj, String s)方法，BeanPostProcessor经常被用作是Bean内容的更改，并且由于这个是在Bean初始化结束时调用那个的方法，也可以被应用于内存或缓存技术；
- 如果Bean在Spring配置文件中配置了init-method属性会自动调用其配置的初始化方法。
- 如果这个Bean关联了BeanPostProcessor接口，将会调用postProcessAfterInitialization(Object obj, String s)方法、；
注：以上工作完成以后就可以应用这个Bean了，那这个Bean是一个Singleton的，所以一般情况下我们调用同一个id的Bean会是在内容地址相同的实例，当然在Spring配置文件中也可以配置非Singleton，这里我们不做赘述。
- 当Bean不再需要时，会经过清理阶段，如果Bean实现了DisposableBean这个接口，会调用那个其实现的destroy()方法；
- 最后，如果这个Bean的Spring配置中配置了destroy-method属性，会自动调用其配置的销毁方法。
 
以上10步骤可以作为面试或者笔试的模板，另外我们这里描述的是应用Spring上下文Bean的生命周期，如果应用Spring的工厂也就是BeanFactory的话去掉第5步就Ok了。

# 操作系统
## 死锁
死锁：指多个进程因竞争共享资源而造成的一种僵局，若无外力作用，这些进程都将永远不能再 向前推进。
安全状态与不安全状态：安全状态指系统能按某种进程顺序来为每个进程分配其所需资源，直 至最大需求，使每个进程都可顺利完成。若系统不存在这样一个序列， 则称系统处于不安全状态。
 
产生死锁的原因：

- 竞争系统资源 
- 进程的推进顺序不当

产生死锁的必要条件：

- 互斥条件：进程要求对所分配的资源进行排它性控制，即在一段时间内某资源仅为一进程所占用。
- 请求和保持条件：当进程因请求资源而阻塞时，对已获得的资源保持不放。
- 不剥夺条件：进程已获得的资源在未使用完之前，不能剥夺，只能在使用完时由自己释放。
- 环路等待条件：在发生死锁时，必然存在一个进程--资源的环形链。

解决死锁的基本方法：

- 预防死锁：
- 资源一次性分配：（破坏请求和保持条件）
- 可剥夺资源：即当某进程新的资源未满足时，释放已占有的资源（破坏不可剥夺条件）
- 资源有序分配法：系统给每类资源赋予一个编号，每一个进程按编号递增的顺序请求资源，释放则相反（破坏环路等待条件）
 
避免死锁:

预防死锁的几种策略，会严重地损害系统性能。因此在避免死锁时，要施加较弱的限制，从而获得 较满意的系统性能。由于在避免死锁的策略中，允许进程动态地申请资源。因而，系统在进行资源分配之前预先计算资源分配的安全性。若此次分配不会导致系统进入不安全状态，则将资源分配给进程；否则，进程等待。其中最具有代表性的避免死锁算法是银行家算法。
 
检测死锁
首先为每个进程和每个资源指定一个唯一的号码,然后建立资源分配表和进程等待表 
 
解除死锁:
当发现有进程死锁后，便应立即把它从死锁状态中解脱出来，常采用的方法有：

- 剥夺资源：从其它进程剥夺足够数量的资源给死锁进程，以解除死锁状态；
- 撤消进程：可以直接撤消死锁进程或撤消代价最小的进程，直至有足够的资源可用，死锁状态.消除为止；所谓代价是指优先级、运行代价、进程的重要性和价值等。

## 进程（process）和线程（thread）
最近，我读到一篇材料，发现有一个很好的类比，可以把它们解释地清晰易懂。

- 计算机的核心是CPU，它承担了所有的计算任务。它就像一座工厂，时刻在运行。
- 假定工厂的电力有限，一次只能供给一个车间使用。也就是说，一个车间开工的时候，其他车间都必须停工。背后的含义就是，单个CPU一次只能运行一个任务。
- 进程就好比工厂的车间，它代表CPU所能处理的单个任务。任一时刻，CPU总是运行一个进程，其他进程处于非运行状态。
- 一个车间里，可以有很多工人。他们协同完成一个任务。
- 线程就好比车间里的工人。一个进程可以包括多个线程。
- 车间的空间是工人们共享的，比如许多房间是每个工人都可以进出的。这象征一个进程的内存空间是共享的，每个线程都可以使用这些共享内存。
- 可是，每间房间的大小不同，有些房间最多只能容纳一个人，比如厕所。里面有人的时候，其他人就不能进去了。这代表一个线程使用某些共享内存时，其他线程必须等它结束，才能使用这一块内存。
- 一个防止他人进入的简单方法，就是门口加一把锁。先到的人锁上门，后到的人看到上锁，就在门口排队，等锁打开再进去。这就叫"互斥锁"（Mutual exclusion，缩写 Mutex），防止多个线程同时读写某一块内存区域。
- 还有些房间，可以同时容纳n个人，比如厨房。也就是说，如果人数大于n，多出来的人只能在外面等着。这好比某些内存区域，只能供给固定数目的线程使用。
- 这时的解决方法，就是在门口挂n把钥匙。进去的人就取一把钥匙，出来时再把钥匙挂回原处。后到的人发现钥匙架空了，就知道必须在门口排队等着了。这种做法叫做"信号量"（Semaphore），用来保证多个线程不会互相冲突。
不难看出，mutex是semaphore的一种特殊情况（n=1时）。也就是说，完全可以用后者替代前者。但是，因为mutex较为简单，且效率高，所以在必须保证资源独占的情况下，还是采用这种设计。
- 操作系统的设计，因此可以归结为三点：
（1）以多进程形式，允许多个任务同时运行；
（2）以多线程形式，允许单个任务分成不同的部分运行；
（3）提供协调机制，一方面防止进程之间和线程之间产生冲突，另一方面允许进程之间和线程之间共享资源。

## 请分别简单说一说进程和线程以及它们的区别。
- 进程是具有一定功能的程序关于某个数据集合上的一次运行活动，进程是系统进行资源调度和分配的一个独立单位。
- 线程是进程的实体，是CPU调度和分派的基本单位，它是比进程更小的能独立运行的基本单位。
- 一个进程可以有多个线程，多个线程也可以并发执行 

## 线程同步的方式有哪些？
- 互斥量：采用互斥对象机制，只有拥有互斥对象的线程才有访问公共资源的权限。因为互斥对象只有一个，所以可以保证公共资源不会被多个线程同时访问。
- 信号量：它允许同一时刻多个线程访问同一资源，但是需要控制同一时刻访问此资源的最大线程数量。
- 事件（信号）：通过通知操作的方式来保持多线程同步，还可以方便的实现多线程优先级的比较操作。
## 进程的通信方式有哪些？
主要分为：管道、系统IPC（包括消息队列、信号量、共享存储）、SOCKET
管道主要分为：普通管道PIPE 、流管道（s_pipe）、命名管道（name_pipe）
- 管道是一种半双工的通信方式，数据只能单项流动，并且只能在具有亲缘关系的进程间流动，进程的亲缘关系通常是父子进程
- 命名管道也是半双工的通信方式，它允许无亲缘关系的进程间进行通信
- 信号量是一个计数器，用来控制多个进程对资源的访问，它通常作为一种锁机制。
- 消息队列是消息的链表，存放在内核中并由消息队列标识符标识。
- 信号是一种比较复杂的通信方式，用于通知接收进程某个事件已经发生。
- 共享内存就是映射一段能被其它进程访问的内存，这段共享内存由一个进程创建，但是多个进程可以访问。
 
## 什么是缓冲区溢出？有什么危害？其原因是什么？
缓冲区溢出是指当计算机向缓冲区填充数据时超出了缓冲区本身的容量，溢出的数据覆盖在合法数据上。 
危害有以下两点：

- 程序崩溃，导致拒绝额服务
- 跳转并且执行一段恶意代码
造成缓冲区溢出的主要原因是程序中没有仔细检查用户输入。 

## 什么是死锁？死锁产生的条件？
在两个或者多个并发进程中，如果每个进程持有某种资源而又等待其它进程释放它或它们现在保持着的资源，在未改变这种状态之前都不能向前推进，称这一组进程产生了死锁。通俗的讲就是两个或多个进程无限期的阻塞、相互等待的一种状态。
死锁产生的四个条件（有一个条件不成立，则不会产生死锁）

- 互斥条件：一个资源一次只能被一个进程使用
- 请求与保持条件：一个进程因请求资源而阻塞时，对已获得资源保持不放
- 不剥夺条件：进程获得的资源，在未完全使用完之前，不能强行剥夺
- 循环等待条件：若干进程之间形成一种头尾相接的环形等待资源关系 

## 进程有哪几种状态？
- 就绪状态：进程已获得除处理机以外的所需资源，等待分配处理机资源
- 运行状态：占用处理机资源运行，处于此状态的进程数小于等于CPU数
- 阻塞状态： 进程等待某种条件，在条件满足之前无法执行 

## 操作系统中进程调度策略有哪几种？
FCFS(先来先服务)，优先级，时间片轮转，多级反馈
 
## 说一说进程同步有哪几种机制。
原子操作、信号量机制、自旋锁管程、会合、分布式系统
## 说一说死锁的处理基本策略和常用方法。
解决死锁的基本方法如下： 
预防死锁、避免死锁、检测死锁、解除死锁 
解决四多的常用策略如下： 
鸵鸟策略、预防策略、避免策略、检测与解除死锁 
如果你对死锁的处理策略不是太熟悉，推荐阅读：产生死锁的原因和必要条件+解决死锁的基本方法 
##同步和异步,阻塞和非阻塞
### 同步： 
所谓同步，就是在发出一个功能调用时，在没有得到结果之前，该调用就不返回。也就是必须一件一件事做,等前一件做完了才能做下一件事。 
例如普通B/S模式（同步）：提交请求->等待服务器处理->处理完毕返回 这个期间客户端浏览器不能干任何事 
### 异步： 
异步的概念和同步相对。当一个异步过程调用发出后，调用者不能立刻得到结果。实际处理这个调用的部件在完成后，通过状态、通知和回调来通知调用者。 
例如 ajax请求（异步）: 请求通过事件触发->服务器处理（这是浏览器仍然可以作其他事情）->处理完毕 
### 阻塞 
阻塞调用是指调用结果返回之前，当前线程会被挂起（线程进入非可执行状态，在这个状态下，cpu不会给线程分配时间片，即线程暂停运行）。函数只有在得到结果之后才会返回。　 
### 非阻塞 
非阻塞和阻塞的概念相对应，指在不能立刻得到结果之前，该函数不会阻塞当前线程，而会立刻返回。
## 同步和互斥
互斥：是指某一资源同时只允许一个访问者对其进行访问，具有唯一性和排它性。但互斥无法限制访问者对资源的访问顺序，即访问是无序的。 
同步：是指在互斥的基础上（大多数情况），通过其它机制实现访问者对资源的有序访问。在大多数情况下，同步已经实现了互斥，特别是所有写入资源的情况必定是互斥的。少数情况是指可以允许多个访问者同时访问资源，如“第一类读写者模型”。
## 线程与进程
进程和线程的主要差别在于它们是不同的操作系统资源管理方式。进程有独立的地址空间，一个进程崩溃后，在保护模式下不会对其它进程产生影响，而线程只是一个进程中的不同执行路径。线程有自己的堆栈和局部变量，但线程之间没有单独的地址空间，一个线程死掉就等于整个进程死掉，所以多进程的程序要比多线程的程序健壮，但在进程切换时，耗费资源较大，效率要差一些。但对于一些要求同时进行并且又要共享某些变量的并发操作，只能用线程，不能用进程。
进程是具有一定独立功能的程序关于某个数据集合上的一次运行活动,进程是系统进行资源分配和调度的一个独立单位.
线程是进程的一个实体,是CPU调度和分派的基本单位,它是比进程更小的能独立运行的基本单位.线程自己基本上不拥有系统资源,只拥有一点在运行中必不可少的资源(如程序计数器,一组寄存器和栈),但是它可与同属一个进程的其他的线程共享进程所拥有的全部资源。
一个程序至少有一个进程,一个进程至少有一个线程。一个线程可以创建和撤销另一个线程;同一个进程中的多个线程之间可以并发执行。
进程在执行过程中拥有独立的内存单元，而多个线程共享内存，可以极大地提高程序的运行效率。

## 僵尸进程和孤儿进程
孤儿进程：一个父进程退出，而它的一个或多个子进程还在运行，那么那些子进程将成为孤儿进程。孤儿进程将被init进程(进程号为1)所收养，并由init进程对它们完成状态收集工作。
僵尸进程：一个进程使用fork创建子进程，如果子进程退出，而父进程并没有调用wait或waitpid获取子进程的状态信息，那么子进程的进程描述符仍然保存在系统中。这种进程称之为僵死进程。

### 僵尸进程解决办法
- 通过信号机制 
　子进程退出时向父进程发送SIGCHILD信号，父进程处理SIGCHILD信号。在信号处理函数中调用wait进行处理僵尸进程。 
- fork 两次，将子进程变为孤儿进程

## 进程间的通信方式
### 进程间通讯的方式：
- 管道：管道中还有命名管道和非命名管道之分，非命名管道只能用于父子进程通讯，命名管道可用于非父子进程，命名管道就是FIFO，管道是先 进先出的通讯方式。FIFO是一种先进先出的队列。它类似于一个管道，只允许数据的单向流动。每个FIFO都有一个名字，允许不相关的进程访问同一个 FIFO，因此也成为命名管。
- 消息队列：是用于 两个进程之间的通讯，首先在一个进程中创建一个消息队列，然后再往消息队列中写数据，而另一个进程则从那个消息队列 中取数据。需要注意的是，消息队列是用创建文件的方式建立的，如果一个进程向某个消息队列中写入了数据之后，另一个进程并没有取出数据，即使向消息队列中 写数据的进程已经结束，保存在消息队列中的数据并没有消失，也就是说下次再从这个消息队列读数据的时候，就是上次的数据。
- 信号量， 不能传递复杂消息，只能用来同步
- 共享内存，只要首先创建一个共享内存区，其它进程按照一定的步骤就能访问到这个共享内存区中的数据，当然可读可写；
### 几种方式的比较：
- 管道：速度慢，容量有限
- 消息队列：容量受到系统限制，且要注意第一次读的时候，要考虑上一次没有读完数据的问题。
- 信号量：不能传递复杂消息，只能用来同步
- 共享内存区：能够很容易控制容量，速度快，但要保持同步，比如一个进程在写的时候，另一个进程要注意读写的问题，相当于线程中的线程安全，当然，共享内存区同样可以用作线程间通讯，不过没这个必要，线程间本来就已经共享了一块内存的。
##（线程/进程）同步和通信的总结
线程同步的方式：临界区、互斥量、信号量、事件 
进程同步的方式：临界区、互斥量、信号量、事件、管程 
进程间通信方式主要包括信号量、FIFO、管道、消息队列、共享内存。 
进程互斥、同步与通信的关系：进程竞争资源时要实施互斥，互斥是一种特殊的同步，实质上需要解决好进程同步问题，进程同步是一种进程通信，由此看来，进程互斥、同步都可以看做进程的通信； 
信号量是进程同步与互斥的常用方法，也可以作为低级的进程通信方法，用于传递控制信号； 
管道与管程是不同的，管程是进程同步的方式，而管道则是进程通信的方式；
线程同步指多个线程同时访问某资源时，采用一系列的机制以保证同时最多只能一个线程访问该资源。线程同步是多线程中必须考虑和解决的问题，因为很可能发生多个线程同时访问（主要是写操作）同一资源，如果不进行线程同步，很可能会引起数据混乱，造成线程死锁等问题；
临界区：通过对多线程的串行化来访问公共资源或者一段代码，速度快，适合控制数据访问
互斥量：采用互斥对象机制，只有拥有互斥对象的线程才有访问公共资源的权限，因为互斥对象只有一个，所以可以保证公共资源不会同时被多个线程访问
信号量：它允许多个线程同一时刻访问同一资源，但是需要限制同一时刻访问此资源的最大线程数目。信号量对象对线程的同步方式与前面几种方法不同，信号允许多个线程同时使用共享资源，这与操作系统中PV操作相似。
事件（信号）：通过通知操作的方式来保持多线程的同步，还可以方便的实现多线程的优先级比较的操作
## 并发和并行
并发：一个处理器能同时处理多任务；并发性是指能处理多个同时性活动的能力，并发时间不一定同时刻发生； 
并行：多个处理器或多核处理器同时处理多个不同的任务；指同时发生的两个并发事件。 
并发不一定并行，并行一定并发。

# 计算机网络
## HTTP 报文包含内容
主要包含四部分：

- request line
- header line
- blank line
- request body

## OSI参考模型及各层作用。
开放式系统互联通信参考模型（英语：Open System Interconnection Reference Model，缩写为 OSI），简称为OSI模型（OSI model），一种概念模型，由国际标准化组织（ISO）提出，一个试图使各种计算机在世界范围内互连为网络的标准框架。定义于ISO/IEC 7498-1。
OSI是一个定义良好的协议规范集，并有许多可选部分完成类似的任务。它定义了开放系统的层次结构、层次之间的相互关系以及各层所包括的可能的任务，作为一个框架来协调和组织各层所提供的服务。
OSI参考模型并没有提供一个可以实现的方法，而是描述了一些概念，用来协调进程间通信标准的制定。即OSI参考模型并不是一个标准，而是一个在制定标准时所使用的概念性框架。
开放式系统互联模型的作用是为了解决异种网络互联时引起的兼容性问题，其最主要的功能是帮助不同的主机实现数据传输。最大的优点是将服务、协议、接口这三个概念明确的分开来。
### 第7层 应用层(Application Layer)
提供为应用软件而设的界面，以设置与另一应用软件之间的通信。例如: HTTP，HTTPS，FTP，TELNET，SSH，SMTP，POP3等。
### 第6层 表示层(Presentation Layer)
把数据转换为能与接收者的系统格式兼容并适合传输的格式。
### 第5层 会话层(Session Layer)
负责在数据传输中设置和维护电脑网络中两台电脑之间的通信连接。
### 第4层 传输层(Transport Layer)
把传输表头(TH)加至数据以形成数据包。传输表头包含了所使用的协议等发送信息。例如:传输控制协议义(TCP) 等。
### 第3层 网络层(Network Layer)
决定数据的路径选择和转寄，将网络表头(NH)加至数据包，以形成分组。网络表头包含了网络数据。例如:互联网协议(IP) 等。
### 第2层 数据链路层(Data Link Layer)
负责网络寻址、错误侦测和改错。当表头和表尾被加至数据包时，会形成了帧。数据链表头(DLH)是包含了物理地址和错误侦测及改错的方法。数据链表尾(DLT)是一串指示数据包末端的字符串。例如以太网、无线局域网(Wi-Fi)和通用分组无线服务(GPRS)等。
### 第1层 物理层(Physical Layer)
在局部局域网上传送帧，它负责管理电脑通信设备和网络媒体之间的互通。包括了针脚、电压、线缆规范、集线器、中继器、网卡、主机适配器等。

## 运行在TCP协议上的协议：
- HTTP（Hypertext Transfer Protocol，超文本传输协议），主要用于普通浏览。
- HTTPS（Hypertext Transfer Protocol over Secure Socket Layer, or HTTP over SSL，安全超文本传输协议）,HTTP协议的安全版本。
- FTP（File Transfer Protocol，文件传输协议），由名知义，用于文件传输。
- POP3（Post Office Protocol, version 3，邮局协议），收邮件用。
- SMTP（Simple Mail Transfer Protocol，简单邮件传输协议），用来发送电子邮件。
- TELNET（Teletype over the Network，网络电传），通过一个终端（terminal）登陆到网络。
- SSH（Secure Shell，用于替代安全性差的TELNET），用于加密安全登陆用。
## 运行在UDP协议上的协议：
- BOOTP（Boot Protocol，启动协议），应用于无盘设备。
- NTP（Network Time Protocol，网络时间协议），用于网络同步。
- DHCP（Dynamic Host Configuration Protocol，动态主机配置协议），动态配置IP地址。
- DNS（Domain Name Service，域名服务），用于完成地址查找，邮件转发等工作（运行在TCP和UDP协议上）。
- ECHO（Echo Protocol，回绕协议），用于查错及测量应答时间（运行在TCP和UDP协议上）。
- SNMP（Simple Network Management Protocol，简单网络管理协议），用于网络信息的收集和网络管理。
- ARP（Address Resolution Protocol，地址解析协议），用于动态解析以太网硬件的地址。

## TCP与UDP的区别
TCP（IP协议6）是一个“可靠的”、面向连结的传输机制，它提供一种可靠的字节流保证数据完整、无损并且按顺序到达。TCP尽量连续不断地测试网络的负载并且控制发送数据的速度以避免网络过载。另外，TCP试图将数据按照规定的顺序发送。这是它与UDP不同之处，这在实时数据流或者路由高网络层丢失率应用的时候可能成为一个缺陷。
 
UDP（IP协议17）是一个无连结的数据报协议。它是一个“尽力传递”（best effort）或者说“不可靠”协议——不是因为它特别不可靠，而是因为它不检查数据包是否已经到达目的地，并且不保证它们按顺序到达。如果一个应用程序需要这些特性，那它必须自行检测和判断，或者使用TCP协议。 UDP的典型性应用是如流媒体（音频和视频等）这样按时到达比可靠性更重要的应用，或者如DNS查找这样的简单查询／响应应用，如果创建可靠的连结所作的额外工作将是不成比例地大。 DCCP目前正由IEFT开发。它提供TCP流动控制语义，但对于用户来说保留UDP的数据报服务模型。 TCP和UDP都用来支持一些高层的应用。任何给定网络地址的应用通过它们的TCP或者UDP端口号区分。根据惯例使一些大众所知的端口与特定的应用相联系。 RTP是为如音频和视频流这样的实时数据设计的数据报协议。RTP是使用UDP包格式作为基础的会话层，然而据说它位于因特网协议栈的传输层。

较新的SCTP也是一个“可靠的”、面向连结的传输机制。它是面向纪录而不是面向字节的，它在一个单独的连结上提供通过多路复用提供的多个子流。它也提供多路自寻址支持，其中连结终端能够被多个IP地址表示（代表多个实体接口），这样的话即使其中一个连接失败了也不中断。它最初是为电话应用开发的（在IP上传输SS7），但是也可以用于其他的应用。


## TCP的可靠性如何保证
在TCP的连接中，数据流必须以正确的顺序送达对方。TCP的可靠性是通过顺序编号和确认（ACK）来实现的。TCP在开始传送一个段时，为准备重传而首先将该段插入到发送队列之中，同时启动时钟。其后，如果收到了接受端对该段的ACK信息，就将该段从队列中删去。如果在时钟规定的时间内，ACK未返回，那么就从发送队列中再次送出这个段。TCP在协议中就对数据可靠传输做了保障，握手与断开都需要通讯双方确认，数据传输也需要双方确认成功，在协议中还规定了：分包、重组、重传等规则；而UDP主要是面向不可靠连接的，不能保证数据正确到达目的地。


## TCP协议中的三次握手和四次分手
### 三次握手：
第一次握手：建立连接。客户端发送连接请求报文段，将SYN位置为1，Sequence Number为x；然后，客户端进入SYN_SEND状态，等待服务器的确认；
第二次握手：服务器收到SYN报文段。服务器收到客户端的SYN报文段，需要对这个SYN报文段进行确认，设置Acknowledgment Number为x+1(Sequence Number+1)；同时，自己自己还要发送SYN请求信息，将SYN位置为1，Sequence Number为y；服务器端将上述所有信息放到一个报文段（即SYN+ACK报文段）中，一并发送给客户端，此时服务器进入SYN_RECD状态；
第三次握手：客户端收到服务器的SYN+ACK报文段。然后将Acknowledgment Number设置为y+1，向服务器发送ACK报文段，这个报文段发送完毕以后，客户端和服务器端都进入ESTABLISHED状态，完成TCP三次握手。
### 四次分手：
第一次分手：主机1（可以是客户端，也可以是服务器端），设置Sequence Number和Acknowledgment Number，向主机2发送一个FIN报文段；此时，主机1进入FIN_WAIT_1状态；这表示主机1没有数据要发送给主机2了；
第二次分手：主机2收到了主机1发送的FIN报文段，向主机1回一个ACK报文段，Acknowledgment Number为Sequence Number加1；主机1进入FIN_WAIT_2状态；主机2告诉主机1，我“同意”你的关闭请求；
第三次分手：主机2向主机1发送FIN报文段，请求关闭连接，同时主机2进入LAST_ACK状态；
第四次分手：主机1收到主机2发送的FIN报文段，向主机2发送ACK报文段，然后主机1进入TIME_WAIT状态；主机2收到主机1的ACK报文段以后，就关闭连接；此时，主机1等待2MSL后依然没有收到回复，则证明Server端已正常关闭，那好，主机1也可以关闭连接了。

### 为什么要三次握手
既然总结了TCP的三次握手，那为什么非要三次呢？怎么觉得两次就可以完成了。那TCP为什么非要进行三次连接呢？在谢希仁的《计算机网络》中是这样说的：
为了防止已失效的连接请求报文段突然又传送到了服务端，因而产生错误，导致服务器端的一直等待而浪费资源。
在书中同时举了一个例子，如下：
“已失效的连接请求报文段”的产生在这样一种情况下：client发出的第一个连接请求报文段并没有丢失，而是在某个网络结点长时间的滞留了，以致延误到连接释放以后的某个时间才到达server。本来这是一个早已失效的报文段。但server收到此失效的连接请求报文段后，就误认为是client再次发出的一个新的连接请求。于是就向client发出确认报文段，同意建立连接。假设不采用“三次握手”，那么只要server发出确认，新的连接就建立了。由于现在client并没有发出建立连接的请求，因此不会理睬server的确认，也不会向server发送数据。但server却以为新的运输连接已经建立，并一直等待client发来数据。这样，server的很多资源就白白浪费掉了。采用“三次握手”的办法可以防止上述现象发生。例如刚才那种情况，client不会向server的确认发出确认。server由于收不到确认，就知道client并没有要求建立连接。”


### 为什么要四次分手
那四次分手又是为何呢？TCP协议是一种面向连接的、可靠的、基于字节流的运输层通信协议。TCP是全双工模式，这就意味着，当主机1发出FIN报文段时，只是表示主机1已经没有数据要发送了，主机1告诉主机2，它的数据已经全部发送完毕了；但是，这个时候主机1还是可以接受来自主机2的数据；当主机2返回ACK报文段时，表示它已经知道主机1没有数据发送了，但是主机2还是可以发送数据到主机1的；当主机2也发送了FIN报文段时，这个时候就表示主机2也没有数据要发送了，就会告诉主机1，我也没有数据要发送了，之后彼此就会愉快的中断这次TCP连接。如果要正确的理解四次分手的原理，就需要了解四次分手过程中的状态变化。
FIN_WAIT_1: 这个状态要好好解释一下，其实FIN_WAIT_1和FIN_WAIT_2状态的真正含义都是表示等待对方的FIN报文。而这两种状态的区别是：FIN_WAIT_1状态实际上是当SOCKET在ESTABLISHED状态时，它想主动关闭连接，向对方发送了FIN报文，此时该SOCKET即进入到FIN_WAIT_1状态。而当对方回应ACK报文后，则进入到FIN_WAIT_2状态，当然在实际的正常情况下，无论对方何种情况下，都应该马上回应ACK报文，所以FIN_WAIT_1状态一般是比较难见到的，而FIN_WAIT_2状态还有时常常可以用netstat看到。（主动方）
FIN_WAIT_2：上面已经详细解释了这种状态，实际上FIN_WAIT_2状态下的SOCKET，表示半连接，也即有一方要求close连接，但另外还告诉对方，我暂时还有点数据需要传送给你(ACK信息)，稍后再关闭连接。（主动方）
CLOSE_WAIT：这种状态的含义其实是表示在等待关闭。怎么理解呢？当对方close一个SOCKET后发送FIN报文给自己，你系统毫无疑问地会回应一个ACK报文给对方，此时则进入到CLOSE_WAIT状态。接下来呢，实际上你真正需要考虑的事情是察看你是否还有数据发送给对方，如果没有的话，那么你也就可以close这个SOCKET，发送FIN报文给对方，也即关闭连接。所以你在CLOSE_WAIT状态下，需要完成的事情是等待你去关闭连接。（被动方）
LAST_ACK: 这个状态还是比较容易好理解的，它是被动关闭一方在发送FIN报文后，最后等待对方的ACK报文。当收到ACK报文后，也即可以进入到CLOSED可用状态了。（被动方）
TIME_WAIT: 表示收到了对方的FIN报文，并发送出了ACK报文，就等2MSL后即可回到CLOSED可用状态了。如果FIN_WAIT_1状态下，收到了对方同时带FIN标志和ACK标志的报文时，可以直接进入到TIME_WAIT状态，而无须经过FIN_WAIT_2状态。（主动方）
CLOSED: 表示连接中断。

## HTTP协议包括哪些请求
HTTP/1.1协议中共定义了八种方法（也叫“动作”）来以不同方式操作指定的资源：

- OPTIONS：这个方法可使服务器传回该资源所支持的所有HTTP请求方法。用'*'来代替资源名称，向Web服务器发送OPTIONS请求，可以测试服务器功能是否正常运作。
- HEAD：与GET方法一样，都是向服务器发出指定资源的请求。只不过服务器将不传回资源的本文部分。它的好处在于，使用这个方法可以在不必传输全部内容的情况下，就可以获取其中“关于该资源的信息”（元信息或称元数据）。
- GET：向指定的资源发出“显示”请求。使用GET方法应该只用在读取数据，而不应当被用于产生“副作用”的操作中，例如在Web Application中。其中一个原因是GET可能会被网络蜘蛛等随意访问。
- POST：向指定资源提交数据，请求服务器进行处理（例如提交表单或者上传文件）。数据被包含在请求本文中。这个请求可能会创建新的资源或修改现有资源，或二者皆有。
- PUT：向指定资源位置上传其最新内容。
- DELETE：请求服务器删除Request-URI所标识的资源。
- TRACE：回显服务器收到的请求，主要用于测试或诊断。
- CONNECT：HTTP/1.1协议中预留给能够将连接改为管道方式的代理服务器。通常用于SSL加密服务器的链接（经由非加密的HTTP代理服务器）。

方法名称是区分大小写的。当某个请求所针对的资源不支持对应的请求方法的时候，服务器应当返回状态码405（Method Not Allowed），当服务器不认识或者不支持对应的请求方法的时候，应当返回状态码501（Not Implemented）。
HTTP服务器至少应该实现GET和HEAD方法，其他方法都是可选的。当然，所有的方法支持的实现都应当匹配下述的方法各自的语义定义。此外，除了上述方法，特定的HTTP服务器还能够扩展自定义的方法。例如：
PATCH（由 RFC 5789 指定的方法）:用于将局部修改应用到资源。

## HTTP中，POST与GET的区别

两种 HTTP 请求方法：GET 和 POST
在客户机和服务器之间进行请求-响应时，两种最常被用到的方法是：GET 和 POST。
GET - 从指定的资源请求数据。
POST - 向指定的资源提交要被处理的数据
### GET 方法
根据HTTP规范，GET用于信息获取，而且应该是安全的和幂等的。

- 所谓安全的意味着该操作用于获取信息而非修改信息。换句话说，GET请求一般不应产生副作用。就是说，它仅仅是获取资源信息，就像数据库查询一样，不会修改，增加数据，不会影响资源的状态。
- 幂等的意味着对同一URL的多个请求应该返回同样的结果。
请注意，查询字符串（名称/值对）是在 GET 请求的 URL 中发送的：
/test/demo_form.asp?name1=value1&name2=value2

有关 GET 请求的其他一些注释：
GET 请求可被缓存
GET 请求保留在浏览器历史记录中
GET 请求可被收藏为书签
GET 请求不应在处理敏感数据时使用
GET 请求有长度限制
GET 请求只应当用于取回数据

### POST 方法
请注意，查询字符串（名称/值对）是在 POST 请求的 HTTP 消息主体中发送的：
POST /test/demo_form.asp HTTP/1.1
Host: w3schools.com
name1=value1&name2=value2
有关 POST 请求的其他一些注释：
POST 请求不会被缓存
POST 请求不会保留在浏览器历史记录中
POST 不能被收藏为书签
POST 请求对数据长度没有要求

## TCP/UDP区别以及TCP如何保证传输可靠性
TCP（Transmission Control Protocol，传输控制协议）是基于连接的协议，也就是说，在正式收发数据前，必须和对方建立可靠的连接。一个TCP连接必须要经过三次“对话”才能建立起来，其中的过程非常复杂，我们这里只做简单、形象的介绍，你只要做到能够理解这个过程即可。我们来看看这三次对话的简单过程：主机A向主机B发出连接请求数据包：“我想给你发数据，可以吗？”，这是第一次对话；主机B向主机A发送同意连接和要求同步（同步就是两台主机一个在发送，一个在接收，协调工作）的数据包：“可以，你什么时候发？”，这是第二次对话；主机A再发出一个数据包确认主机B的要求同步：“我现在就发，你接着吧！”，这是第三次对话。三次“对话”的目的是使数据包的发送和接收同步，经过三次“对话”之后，主机A才向主机B正式发送数据。    UDP（User Data Protocol，用户数据报协议）是与TCP相对应的协议。它是面向非连接的协议，它不与对方建立连接，而是直接就把数据包发送过去！    UDP适用于一次只传送少量数据、对可靠性要求不高的应用环境。大家可以看到，发送的数据包数量是4包，收到的也是4包（因为对方主机收到后会发回一个确认收到的数据包）。这充分说明了UDP协议是面向非连接的协议，没有建立连接的过程。正因为UDP协议没有连接的过程，所以它的通信效果高；但也正因为如此，它的可靠性不如TCP协议高。QQ就使用UDP发消息，因此有时会出现收不到消息的情况。

TCP的可靠性如何保证：
在TCP的连接中，数据流必须以正确的顺序送达对方。TCP的可靠性是通过顺序编号和确认（ACK）来实现的。TCP在开始传送一个段时，为准备重传而首先将该段插入到发送队列之中，同时启动时钟。其后，如果收到了接受端对该段的ACK信息，就将该段从队列中删去。如果在时钟规定的时间内，ACK未返回，那么就从发送队列中再次送出这个段。TCP在协议中就对数据可靠传输做了保障，握手与断开都需要通讯双方确认，数据传输也需要双方确认成功，在协议中还规定了：分包、重组、重传等规则；而UDP主要是面向不可靠连接的，不能保证数据正确到达目的地。     



## TCP/IP五层模型的协议
应用层  传输层：四层交换机、也有工作在四层的路由器
网络层：路由器、三层交换机
数据链路层：网桥（现已很少使用）、以太网交换机（二层交换机）、网卡（其实网卡是一半工作在物理层、一半工作在数据链路层）
物理层：中继器、集线器、还有我们通常说的双绞线也工作在物理层


## TCP/IP中，每一层对应的协议
网络层：IP协议、ICMP协议、ARP协议、RARP协议。
传输层：UDP协议、TCP协议。
应用层：FTP（文件传送协议）、Telenet（远程登录协议）、DNS（域名解析协议）、SMTP（邮件传送协议），POP3协议（邮局协议），HTTP协议。

注意：

在OSI模型中ARP协议属于链路层；而在TCP/IP模型中，ARP协议属于网络层。 



## 在浏览器中输入网址后执行的全部过程
- 查找域名对应的IP地址。这一步会依次查找浏览器缓存，系统缓存，路由器缓存，ISPNDS缓存，根域名服务器。
- 向IP对应的服务器发送请求。
- 服务器响应请求，发回网页内容。
- 浏览器解析网页内容。
由于网页可能有重定向，或者嵌入了图片，AJAX，其它子网页等等，这4个步骤可能反复进行多次才能将最终页面展示给用户。


# 拓展知识
## 负载均衡算法 
那第一个问题：what's load-balance?

假设我有两个模块（或者两个系统）：module-A和module-B，A依赖B提供服务。当用户请求过来的时候，A就会去请求B，让B根据请求进行某些处理（比如：根据单词id查对应的单词），完成后把结果返回给A，A再对这个结果进行处理。然而，为了保证服务稳定，有可能B服务有很多台机器，A遇到这个时候就犯难了：我该去找B的哪台机器取数据呢？
 
最常见的一个case就是nginx：比如我们的web逻辑服务器是jetty或者tomcat，一般会有多台，nginx就需要配置这多台机器：
upstream simplemain.com {
     server  192.168.1.100:8080;
     server  192.168.1.101:8080;
}
 
那这些机器是怎么样选择的呢？实际就是负载均衡算法。
 
老王对负载均衡的理解，他应该包含两个层面：
1、负载：就是后端系统的承载能力。比如同等条件下，一个1核cpu-1G内存的机器的承载能力一般会比8核cpu-8G内存的机器要差；相同配置下，一个cpu利用率为80%的机器比30%的承载能力一般要差等等。
2、均衡：保证后端请求的平衡。比如：在同等情况下，分配到多台机器的请求要相当；有些情况下，同一用户尽可能分配到同一台机器等等。
 
所以，负载均衡的算法实际上就是解决跨系统调用的时候，在考虑后端机器承载情况的前提下，保证请求分配的平衡和合理。
 
那第二个问题随之而来：why？
### 为什么要有负载均衡呢？
1、很明显，如果我们不去考虑后端的承载情况，有可能直接就把某台机器压垮了（比如cpu利用率已经80%了，再给大量的请求直接就干死了），更严重的会直接造成雪崩（一台压死了，对应的请求又压倒其他某台机器上，又干死一台……），从而致使服务瘫痪。
2、如果我们均衡算法选的不好，就会导致后端资源浪费。比如：如果选择一致Hash算法，可以很好利用cache的容量。而如果用随机，有可能就会让cache效果大打折扣（每台机器上都要缓存几乎相同的内容）。
 
所以，用负载均衡应该是一个比较好的选择。
 
那就解决第三个问题吧：how？
按照之前的思路，我们还是分成两个部分来讲：负载& 均衡。
 
### 先来看负载算法：
既然要解决后端系统的承载能力，那我们就有很多方式，常见的有以下几种：
A、简单粗暴有效的：手工配置！
大家是不是觉得这个听起来很山寨呢？其实不是。这种方式对于中小系统来讲是最有效最稳定的。因为后端机器的性能配置、上面部署了哪些服务、还能有多大的承载能力等等，我们是最清楚的。那我们在配置的时候，就可以明确的告诉调用者，你只能分配多大的压力到某台服务器上，多了不行！
 
比如，我们经常看到nginx的配置：
upstream simplemain.com {
     server  192.168.1.100:8080 weight=30;
     server  192.168.1.101:8080 weight=70;
}
就是说，虽然有两台后端的服务器，但是他们承载能力是不一样的，有一个能力更强，我们就给他70%的压力；有一个更弱，我们就给他30%的压力。这样，nginx就会把更多的压力分配给第二台。
 
这种方式配置简单，而且很稳定，基本不会产生分配的抖动。不过，带来的问题就是分配很固定，不能动态调整。如果你的后端服务器有一段时间出现性能抖动（比如有其他服务扰动了机器的稳定运行，造成cpu利用率一段时间升高），前端调用者就很难根据实际的情况重新分配请求压力。所以，引入了第二种方法。
 
B、动态调整。
这种方案会根据机器当前运行的状态和历史平均值进行对比，发现如果当前状态比历史的要糟糕，那么就动态减少请求的数量。如果比历史的要好，那么就可以继续增加请求的压力，直到达到一个平衡。
 
具体怎么做呢？
首先，刚开始接入的时候，我们可以计算所有机器对于请求的响应时间，算一个平均值。对于响应较快的机器，我们可以多分配一些请求。如果请求多了导致响应减慢，这个时候就会逐步和其他机器持平，说明这台机器达到了相应的平衡。
 
接着，当接入达到平衡以后，就可以统计这台机器平均的响应时间。如果某一段响应请求变慢了（同时比其他机器都要慢），就可以减少对他请求的分配，将压力转移一部分到其他机器，直到所有机器达到一个整体的平衡。
 
这种方案是不是看起来很高级呢？他的好处在于可以动态的来平衡后面服务器的处理能力。不过，任何事物都有两面性。这种方案如果遇到极端情况，可能会造成系统雪崩！当某台机器出现短暂网络抖动的时候，他的响应就可能变慢，这个时候，前端服务就会将他的请求分配给其他的机器。如果分配的很多，就有可能造成某些机器响应也变慢。然后又将这些机器的请求分配给另外的……如此这般，那些勤勤恳恳的机器终将被这些请求压死。
 
所以，更好的方案，将两者结合。一方面静态配置好承载负荷的一个范围，超过最大的就扔掉；另一方面动态的监控后端机器的响应情况，做小范围的请求调整。
 
### 均衡算法
均衡算法主要解决将请求如何发送给后端服务。经常会用到以下四种算法：随机（random）、轮训（round-robin）、一致哈希（consistent-hash）和主备（master-slave）。
 
比如：我们配置nginx的时候，经常会用到这样的配置：
upstream simplemain.com {
     ip_hash;
     server  192.168.1.100:8080;
     server  192.168.1.101:8080;
}
 
这个配置就是按ip做hash算法，然后分配给对应的机器。
 
接下来我们详细的看看这几个算法是如何来工作的。
 
A、随机算法。
顾名思义，就是在选取后端服务器的时候，采用随机的一个方法。在具体讲这个算法之前，我们先来看看一个例子，我们写如下C语言的代码:
```java
#include <stdlib.h>
#include<stdio.h>
 
int main()
{
        srand(1234);
        printf("%d\n", rand());
       return0;
}
 ```
我们用srand函数给随机算法播了一个1234的种子，然后再去随机数，接着我们编译和链接gcc rand.c -o rand
 
按理想中说，我们每次运行rand这个程序，都应该得到不一样的结果，对吧。可是……

可以看到，我们每次运行的结果都是一样的！！出了什么问题呢？
 
我们说的随机，在计算机算法中通常采用的是一种伪随机的算法。我们会先给算法放一个种子，然后根据一定的算法将种子拿来运算，最后得到一个所谓的随机值。我们将上面的算法做一个小小的改动，将1234改为time(NULL)，效果就不一样了：
```java
#include <stdlib.h>
#include <stdio.h>
#include<time.h>
 
int main()
{
        srand((int)time(NULL));
        printf("%d\n", rand());
       return 0;
}
 ```
time这个函数会获取当前秒数，然后将这个值作为种子放入到伪随机函数，从而计算出的伪随机值会因为秒数不一样而不同。
 
具体来看一下java源代码里如何来实现的。我们常用的java随机类是java.util.Random这个类。他提供了两个构造函数：
```java
public Random() {
    this(seedUniquifier() ^ System.nanoTime());
}
 
public Random(long seed) {
    if (getClass() == Random.class)
       this.seed =new AtomicLong(initialScramble(seed));
    else {
       //subclass might have overriden setSeed
       this.seed =new AtomicLong();
        setSeed(seed);
    }
}
 ```
我们可以看到，这个类也是需要一个种子。然后我们获取随机值的时候，会调用next函数：
```java
protectedintnext(int bits) {
    long oldseed, nextseed;
    AtomicLong seed =this.seed;
    do {
        oldseed = seed.get();
        nextseed = (oldseed *multiplier +addend) &mask;
    } while (!seed.compareAndSet(oldseed, nextseed));
    return (int)(nextseed>>> (48 - bits));
}
```
这个函数会利用种子进行一个运算，然后得到随机值。所以，我们看起来随机的一个算法，实际上跟时间是相关的，跟算法的运算是相关的。并不是真正的随机。
 
好了，话归正题，我们用随机算法怎么样做请求均衡呢？比如，还是我们之前那个nginx配置：
upstream simplemain.com {
     server  192.168.1.100:8080 weight=30;
     server  192.168.1.101:8080 weight=70;
}
我们有两台机器，分别需要承载30%和70%的压力，那么我们算法就可以这样来写（伪代码）：
bool res = abs(rand()) % 100 < 30
这句话是什么意思呢？
1、我们先产生一个伪随机数：rand()
2、将这个伪随机数的转化为非负数: abs(rand())
3、将这个数取模100，将值转化到[0,100)的半开半闭区间：abs(rand()) % 100
4、看这个数是否落入了前30个数的区间[0,30)：abs(rand()) % 100 < 30
如果随机是均匀的话，他们落到[0,100)这个区间里一定是均匀的，所以只要在[0,30)这个区间里，我们就分给第一台机器，否则就分给第二台机器。
 
其实这里讲述的只是一种方法，还有很多其他的方法，大家都可以去想想。
 
随机算法是我们最最最最最最常用的算法，绝大多数情况都使用他。首先，从概率上讲，它能保证我们的请求基本是分散的，从而达到我们想要的均衡效果；其次，他又是无状态的，不需要维持上一次的选择状态，也不需要均衡因子等等。总体上，方便实惠又好用，我们一直用他！
 
B、轮训算法。
轮训算法就像是挨个数数一样（123-123-123……），一个个的轮着来。
upstream simplemain.com {
     server  192.168.1.100:8080 weight=30;
     server  192.168.1.101:8080 weight=70;
}
还是这个配置，我们就可以这样来做（为了方便，我们把第一台机器叫做A，第二台叫做B）：
1、我们先给两台机器做个排序的数组：array = [ABBABBABBB]
2、我们用一个计数指针来标明现在数组的位置：idx = 3
3、当一个请求来的时候，我们就把指针对应的机器选取出来，并且指针加一，挪到下一个位置。
这样，十个请求，我们就可以保证有3个一定是A，7个一定是B。
 
轮训算法在实际中也有使用，但是因为要维护idx指针，所以是有状态的。我们经常会用随机算法取代。
 
C、一致哈希算法。
这个算法是大家讨论最对，研究最多，神秘感最强的一个算法。老王当年刚了解这个算法的时候，也是花了很多心思去研究他。在百度上搜：“一致hash”，大概有321万篇相关文章。
 
大家到网上搜这个算法，一般都会讲将[0,232)所有的整数投射到一个圆上，然后再将你的机器的唯一编码（比如：IP）通过hash运算得到的整数也投射到这个圆上（Node-A、Node-B）。如果一个请求来了，就将这个请求的唯一编码（比如：用户id）通过hash算法运算得到的整数也投射到这个圆上（request-1、request-2），通过顺时针方向，找到第一个对应的机器。如下图：

当时老王看了这些文章也觉得很有道理，但是过了一段时间就忘了……自己琢磨了一段时间，不断的问自己，为什么要这样做呢？
 
过了很久，老王有了一些体会。实际上，一致Hash要解决的是两个问题：
1、散列的不变性：就是同一个请求（比如：同一个用户id）尽量的落入到一台机器，不要因为时间等其他原因，落入到不同的机器上了；
2、异常以后的分散性：当某些机器坏掉（或者增加机器），原来落到同一台机器的请求（比如：用户id为1，101，201），尽量分散到其他机器，不要都落入其他某一台机器。这样对于系统的冲击和影响最小。
 
有了以上两个原则，这个代码写起来就很好写了。比如我们可以这样做(假定请求的用户id=100）：
1、我们将这个id和所有的服务的IP和端口拼接成一个字符串：
str1 = "192.168.1.100:8080-100"
str2 = "192.168.1.101:8080-100"
 
2、对这些字符串做hash，然后得到对应的一些整数：
iv1 = hash(str1)
iv2 = hash(str2)
 
3、对这些整数做从大到小的排序，选出第一个。
 
好，现在来看看我们的这个算法是否符合之前说的两个原则。
1、散列的不变性：很明显，这个算法是可重入的，只要输入一样，结果肯定一样；
2、异常以后的分散性：当某台机器坏掉以后，原本排到第一的这些机器就被第二位的取代掉了。只要我们的hash算法是分散的，那么得到排到第二位的机器就是分散的。
 
所以，这种算法其实也能达到同样的目的。当然，可以写出同样效果的算法很多很多，大家也可以自己琢磨琢磨。最根本的，就是要满足以上说的原则。
 
一致Hash算法用的最多的场景，就是分配cache服务。将某一个用户的数据缓存在固定的某台服务器上，那么我们基本上就不用多台机器都缓存同样的数据，这样对我们提高缓存利用率有极大的帮助。
 
不过硬币都是有两面的，一致Hash也不例外。当某台机器出问题以后，这台机器上的cache失效，原先压倒这台机器上的请求，就会压到其他机器上。由于其他机器原先没有这些请求的缓存，就有可能直接将请求压到数据库上，造成数据库瞬间压力增大。如果压力很大的话，有可能直接把数据库压垮。
 
所以，在考虑用一致Hash算法的时候，一定要估计一下如果有机器宕掉后，后端系统是否能承受对应的压力。如果不能，则建议浪费一点内存利用率，使用随机算法。
 
D、主备算法。
这个算法核心的思想是将请求尽量的放到某个固定机器的服务上（注意这里是尽量），而其他机器的服务则用来做备份，如果出现问题就切换到另外的某台机器的服务上。
 
这个算法用的相对不是很多，只是在一些特殊情况下会使用这个算法。比如，我有多台Message Queue的服务，为了保证提交数据的时序性，我就想把所有的请求都尽量放到某台固定的服务上，当这台服务出现问题，再用其他的服务。
 
那怎么做呢？最简单的做法，我们就对每台机器的IP：Port做一个hash，然后按从大到小的顺序排序，第一个就是我们想要的结果。如果第一个出现问题，那我们再取第二个：head(sort(hash("IP:Port1"), hash("IP:Port2"), ……))
 
当然，还有其他做法。比如：老王做的Naming Service就用一个集中式的锁服务来判定当前的主服务器，并对他进行锁定。
 
好了，关于负载均衡相关的算法就大体上说这么多。其实还有一个相关话题没有说，就是健康检查。他的作用就是对所有的服务进行存活和健康检测，看是否需要提供给负载均衡做选择。如果一台机器的服务出现了问题，健康检查就会将这台机器从服务列表中去掉，让负载均衡算法看不到这台机器的存在。这个是给负载均衡做保障的，但是可以不划在他的体系内。不过也有看法是可以将这个也算在负载均衡算法中。因为这个算法的实现其实也比较复杂，老王这次就不讲这个算法了，可以放到接下来的文章中来分析。
 
 平衡算法设计的好坏直接决定了集群在负载均衡上的表现，设计不好的算法，会导致集群的负载失衡。一般的平衡算法主要任务是决定如何选择下一个集群节点，然后将新的服务请求转发给它。有些简单平衡方法可以独立使用，有些必须和其它简单或高级方法组合使用。而一个好的负载均衡算法也并不是万能的，它一般只在某些特殊的应用环境下才能发挥最大效用。因此在考察负载均衡算法的同时，也要注意算法本身的适用面，并在采取集群部署的时候根据集群自身的特点进行综合考虑，把不同的算法和技术结合起来使用。
### 轮转法：
轮转算法是所有调度算法中最简单也最容易实现的一种方法。在一个任务队列里，队列的每个成员（节点）都具有相同的地位，轮转法简单的在这组成员中顺序轮转选择。在负载平衡环境中，均衡器将新的请求轮流发给节点队列中的下一节点，如此连续、周而复始，每个集群的节点都在相等的地位下被轮流选择。这个算法在DNS域名轮询中被广泛使用。
轮转法的活动是可预知的，每个节点被选择的机会是1/N，因此很容易计算出节点的负载分布。轮转法典型的适用于集群中所有节点的处理能力和性能均相同的情况，在实际应用中，一般将它与其他简单方法联合使用时比较有效。
### 散列法
散列法也叫哈希法（HASH），通过单射不可逆的HASH函数，按照某种规则将网络请求发往集群节点。哈希法在其他几类平衡算法不是很有效时会显示出特别的威力。例如，在前面提到的UDP会话的情况下，由于轮转法和其他几类基于连接信息的算法，无法识别出会话的起止标记，会引起应用混乱。
而采取基于数据包源地址的哈希映射可以在一定程度上解决这个问题：将具有相同源地址的数据包发给同一服务器节点，这使得基于高层会话的事务可以以适当的方式运行。相对称的是，基于目的地址的哈希调度算法可以用在Web Cache集群中，指向同一个目标站点的访问请求都被负载平衡器发送到同一个Cache服务节点上，以避免页面缺失而带来的更新Cache问题。
### 最少连接法
在最少连接法中，平衡器纪录目前所有活跃连接，把下一个新的请求发给当前含有最少连接数的节点。这种算法针对TCP连接进行，但由于不同应用对系统资源的消耗可能差异很大，而连接数无法反映出真实的应用负载，因此在使用重型Web服务器作为集群节点服务时（例如Apache服务器），该算法在平衡负载的效果上要打个折扣。为了减少这个不利的影响，可以对每个节点设置最大的连接数上限（通过阈值设定体现）。
### 最低缺失法
在最低缺失法中，平衡器长期纪录到各节点的请求情况，把下个请求发给历史上处理请求最少的节点。与最少连接法不同的是，最低缺失记录过去的连接数而不是当前的连接数。
### 最快响应法
平衡器记录自身到每一个集群节点的网络响应时间，并将下一个到达的连接请求分配给响应时间最短的节点，这种方法要求使用ICMP包或基于UDP包的专用技术来主动探测各节点。
在大多数基于LAN的集群中，最快响应算法工作的并不是很好，因为LAN中的ICMP包基本上都在10ms内完成回应，体现不出节点之间的差异；如果在 WAN上进行平衡的话，响应时间对于用户就近选择服务器而言还是具有现实意义的；而且集群的拓扑越分散这种方法越能体现出效果来。这种方法是高级平衡基于拓扑结构重定向用到的主要方法。
### 加权法
加权方法只能与其他方法合用，是它们的一个很好的补充。加权算法根据节点的优先级或当前的负载状况（即权值）来构成负载平衡的多优先级队列，队列中的每个等待处理的连接都具有相同处理等级，这样在同一个队列里可以按照前面的轮转法或者最少连接法进行均衡，而队列之间按照优先级的先后顺序进行均衡处理。在这里权值是基于各节点能力的一个估计值。



