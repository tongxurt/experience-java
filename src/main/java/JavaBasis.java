import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by tongxu01 on 2017/7/24.
 * <p>
 * 各种面试小细节
 */
public class JavaBasis {

    public static void main(String[] args) throws CloneNotSupportedException {

        short sh = 1;
//        s1 = s1 + 1; // wrong
        sh += 1; // right
        System.out.println(sh);


        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);// false 两个引用没有引用同一对象
        System.out.println(a.equals(b));// true
        System.out.println(a == c);// true


        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2); // true
        System.out.println(f3 == f4); // false
//        简单的说，如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，
//          所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。


        int aa[] = {1, 3, 4};
        System.out.println(aa.length); // not aa.length() or aa,size()


//        new String()和new String(“”)都是声明一个新的空字符串，是空串不是null；
        String s4 = new String();
        String s5 = new String("");
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s4 == null); // false
        System.out.println(s4 == ""); // false
        System.out.println(s4.isEmpty()); // true (value.length = 0)
        System.out.println(s4 == s5); // false
        System.out.println(s4.equals(s5)); // true
        // Integer 和 String 只要值相同 equals 方法就返回true  其他对象不是这样


        String s6 = "kvill";
        String s7 = "kvill";
        String s8 = "kv" + "ill";
        String s9 = new String("kvill");
        String s10 = "kv" + new String("ill");
        System.out.println(s6 == s7); // true
        System.out.println(s6 == s8); // true
        System.out.println(s6 == s9); // false
        System.out.println(s6 == s9.intern()); // true  把常量池中“kvill”的引用赋给s9
        System.out.println(s9 == s10); // false
        System.out.println(s9.equals(s10)); // true
        System.out.println(s6 == s6.intern()); // true
//    常量池(constant pool)指的是在编译期被确定，并被保存在已编译的.class文件中的一些数据。
//    它包括了关于类、方法、接口等中的常量，也包括字符串常量。
//    首先，我们要知结果为道Java会确保一个字符串常量只有一个拷贝。
//    因为例子中的s6和s7中的”kvill”都是字符串常量，它们在编译期就被确定了，所以s6==s7为true；
//    而”kv”和”ill”也都是字符串常量，当一个字符串由多个字符串常量连接而成时，它自己肯定也是字符串常量，
//    所以s8也同样在编译期就被解析为一个字符串常量，所以s8也是常量池中”kvill”的一个引用。
//
//    所以我们得出s6==s7==s8;
//
//    用new String() 创建的字符串不是常量，不能在编译期就确定，所以new String() 创建的字符串不放入常量池中，
//    它们有自己的地址空间。

        int aaa = Integer.parseInt("10");
        int bbb = Integer.valueOf("10");
        JavaBasis tes = null;
        String ccc = String.valueOf(tes);
        System.out.println(ccc);


//      以下内容对照wiki:  http://www.cnblogs.com/cccw/p/5837448.html
        List list = new ArrayList();
        list.add(new String("aa")); // 进去add方法看看怎么实现的 ,尤其是扩容策略 各种'System.arraycopy'
        list.add(new String("bb"));
        list.add(new String("cc"));
        list.add(new String("dd"));
        System.out.println(list.indexOf("bb"));
        System.out.println(list.subList(list.indexOf("bb") + 1, list.size()));

        String af = "fdsdfasdcodefsdafasd";
        System.out.println(af.indexOf("code", 12));

//        list.add(10,new Object());// 报错
        list.remove(2); // 进去看实现

        List list1 = new LinkedList();
        List list2 = new ArrayList();
        list1.add(new Object());

        Map map = new HashMap();
        map.put("a", new Object());
// HashMap的底层数组长度总是2的n次方，在构造函数中存在：capacity <<= 1;这样做总是能够保证HashMap的底层数组长度为2的n次方。
// 当length为2的n次方时，h&(length - 1)就相当于对length取模，而且速度比直接取模快得多，这是HashMap在速度上的一个优化
// 当length = 16时，length – 1 = 15 即1111，那么进行低位&运算时，值总是与原来hash值相同，而进行高位运算时，
// 其值等于其低位值。所以说当length = 2^n时，不同的hash值发生碰撞的概率比较小，这样就会使得数据在table数组中分布较均匀，查询速度也较快。
        map.size();

        Set set = new HashSet(); // 内部实现是HashMap
        set.add(new Object());

        Hashtable hashtable = new Hashtable();

        ConcurrentMap hashMap = new ConcurrentHashMap();

//        volatile ConcurrentHashMap.HashEntry<K, V>[] table;


        hashMap.put('a', new Object());

//    Segment{
//        transient volatile int count;
//        transient int modCount;
//        transient int threshold;
//        transient volatile HashEntry<K, V>[] table;
//        final float loadFactor;
//    }

//1. static final class HashEntry<K,V> {
//2.     final K key;
//3.     final int hash;
//4.     volatile V value;
//5.     volatile HashEntry<K,V> next;
//6. }
//        对于put操作，可以一律添加到Hash链的头部
//        对于remove操作，可能需要从中间删除一个节点，这就需要将要删除节点的前面所有节点整个复制一遍，最后一个节点指向要删除结点的下一个结点
//        读操作能够看到最新的值，将value设置成 volatile ，这避免了加锁。

//        hash值的 高4位 决定分配在哪个段中
//final final final final final

        CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList();

        String[] arr = new String[10];
        System.out.println(arr[0]);
        System.out.println(arr.length);

        Object o1 = new Object();
        Object o2 = new Object();

        System.out.println(o1.equals(o2));

        User user1 = new User();
        user1.setAge(1);

        User user2 = new User();
        user2.setAge(1);

        User user3 = user1;
        User user4 = (User) user1.clone();

        System.out.println(user1.equals(user2)); // false
        System.out.println(user3.equals(user1)); // true
        System.out.println(user4.equals(user1)); // false
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);

// “==”比较的是值【变量(栈)内存中存放的对象的(堆)内存地址】
// equal用于比较两个对象的值是否相同【不是比地址】
//
//【特别注意】Object类中的equals方法和“==”是一样的，没有区别，而String类，Integer类等等一些类，是重写了equals方法，
// 才使得equals和“==不同”，所以，当自己创建类时，自动继承了Object的equals方法，要想实现不同的等于比较，必须重写equals方法。
//        int add = 4.4; // 随便一个小数默认为double
        double add = 4.4;
    }

}
