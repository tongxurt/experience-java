package design.pattern.singleton;

public class Demo {
    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingletonA objectA = SingletonA.getInstance();
        SingletonB objectB = SingletonB.getInstance();
        SingletonB objectC = SingletonB.getInstance();
        SingletonB objectD = SingletonB.getInstance();

        //显示消息
        objectA.showMessage();
        objectB.showMessage();
        objectC.showMessage();
        objectD.showMessage();

        // 一般不采有懒汉式方式
    }
}
