public class ClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException {


        try {
            System.out.println(ClassLoader.getSystemClassLoader());
            System.out.println(ClassLoader.getSystemClassLoader().getParent());
            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //查看当前系统类路径中包含的路径条目
        System.out.println(System.getProperty("java.class.path"));
        //调用加载当前类的类加载器（这里即为系统类加载器）加载TestBean
        Class typeLoaded = Class.forName("User");

        System.out.println(typeLoaded.getClassLoader());
    }
}