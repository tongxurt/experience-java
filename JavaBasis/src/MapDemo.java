import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        TreeMap treeMap = new TreeMap();

        hashMap.put("fsdf", new User(1));
        hashMap.put("rwerwq", new User(2));
        hashMap.put("rwerqwerwer", new User(3));
        hashMap.put("rewqrwe", new User(4));

        System.out.println(hashMap);// 会发现是无序的(跟插入顺序没关系)

        linkedHashMap.put("fsdf", new User(1));
        linkedHashMap.put("rwerwq", new User(2));
        linkedHashMap.put("rwerqwerwer", new User(3));
        linkedHashMap.put("rewqrwe", new User(4));

        System.out.println(linkedHashMap);// 会发现是有序的(跟插入顺序有关系)

        treeMap.put("d", new User(1));
        treeMap.put("b", new User(2));
        treeMap.put("c", new User(3));
        treeMap.put("a", new User(4));

        System.out.println(treeMap);// 会发现是有序的(字典顺序有关,注意不是插入顺序)
//
//        1.HashMap里面存入的键值对在取出的时候是随机的,也是我们最常用的一个Map.它根据键的HashCode值存储数据,
//         根据键可以直接获取它的值，具有很快的访问速度。在Map 中插入、删除和定位元素，HashMap 是最好的选择。
//        2.TreeMap取出来的是排序后的键值对。但如果您要按自然顺序或自定义顺序遍历键，那么TreeMap会更好。
//        3. LinkedHashMap 是HashMap的一个子类，如果需要输出的顺序和输入的相同,那么用LinkedHashMap可以实现.

//        TreeMap: http://blog.csdn.net/chenssy/article/details/26668941
//        HashMap: http://www.cnblogs.com/chenssy/p/3521565.html
//        LinkedHashMap: http://blog.csdn.net/u012889434/article/details/48055679

    }

}
