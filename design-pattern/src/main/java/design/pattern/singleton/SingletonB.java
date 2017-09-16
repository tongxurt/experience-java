package design.pattern.singleton;

/**
 * 懒汉式，线程安全(去掉synchronized关键字变为线程不安全)
 * <p>
 * 是否 Lazy 初始化：是
 * <p>
 * 是否多线程安全：是
 * <p>
 * 实现难度：易
 * <p>
 * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
 */
public class SingletonB {
    private static SingletonB instance;

    private SingletonB() {
    }

    public static synchronized SingletonB getInstance() {
        if (instance == null) {
            instance = new SingletonB();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}