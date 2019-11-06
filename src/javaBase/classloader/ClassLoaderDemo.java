package javaBase.classloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author maple on 2019/10/21 15:51.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class ClassLoaderDemo {
    private static ClassLoader classLoader = new ClassLoader() {


        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            Class cls = Class.forName(name);
            try {
                Field f = cls.getDeclaredField("data");
                Constructor<?> cons = cls.getConstructor();
                Object acObject = cons.newInstance();
                f.set(acObject, 1002);
                System.out.println("costom load");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return cls;
        }
    };
    // 自定义ClassLoader先加载类.
    public static void main(String[] args) {
        System.out.println("SYS: " + ClassLoaderDemo.class.getClassLoader().hashCode());
        System.out.println("COUSTOM: " + classLoader.hashCode());

        Class<?> ac = null;
        try {
            ac = classLoader.loadClass("javaBase.classloader.A");
            Field f = ac.getDeclaredField("data");
            Constructor<?> cons = ac.getConstructor();
            Object acObject = cons.newInstance();
            long data = (long) f.get(acObject);
            System.out.println("COUSTOM-A: " + data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("SYS-A: " + A.data);

    }
}
