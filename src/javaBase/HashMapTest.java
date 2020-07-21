package javaBase;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author maple on 2019/5/22 16:44.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class HashMapTest {
    /**
     * jdk8新特性，@Contended注解避免false sharing(伪缓存)
     * Restricted on user classpath
     * Unlock: -XX:-RestrictContended
     */
    public static void main(String[] args) {
        //testHashMap();
         testConcurrentHashMap();
        // testUnsafe();

    }


    private static void testUnsafe() {
        Unsafe unsafe = null;
        /**
         *
         * getUnsafe()不可用,Unsafe类平台相关,版本变更大,不建议开发使用
         * getUnsafe调用时检测调用类的类加载器,类加载器不为空时,报错
         * Bootstrap class loader:加载核心库,由于使用原生代码编写,通过getClassLoader()获取时为空.
         * system class loader:加载项目代码, getClassLoader().toString() = sun.misc.Launcher$AppClassLoader@18b4aac2
         * extensions class loader: 加载扩展库 getClassLoader().toString() = sun.misc.Launcher$ExtClassLoader@190d11
         */
        // unsafe=Unsafe.getUnsafe();
        try {
            Class<?> clazz = Unsafe.class;
            Field f;
            f = clazz.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer[] a = new Integer[]{1, 2, 4, 5};
        //参数: 数组对象
        int ashift = 31 - Integer.numberOfLeadingZeros(unsafe.arrayIndexScale(Integer[].class));
        int abase = unsafe.arrayBaseOffset(Integer[].class);
        //参数说明: (被读数组,被读元素的内存位置)
        int b = (int) unsafe.getObjectVolatile(a, ((long) 1 << ashift) + abase);
        System.out.println(b);
    }


    private static void testConcurrentHashMap() {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 1);
        //  map.put(null, 10086);//不允许空键
        map.put((int) Math.pow(2, 16), 2);
        map.put((int) Math.pow(2, 17) + 3, 3);
        map.put((int) Math.pow(2, 18) + 5, 4);
        map.put((int) Math.pow(2, 19) + 9, 5);
        map.put((int) Math.pow(2, 20) + 17, 6);
        map.put((int) Math.pow(2, 21) + 33, 7);
        map.put((int) Math.pow(2, 22) + 65, 8);
        map.put((int) Math.pow(2, 23) + 129, 9);
        map.put((int) Math.pow(2, 24) + 128 + 129, 10);
        System.out.println(map.containsKey(1));
        map.remove(1);
        map.remove((int) Math.pow(2, 16));
        map.remove((int) Math.pow(2, 17) + 3);
        map.remove((int) Math.pow(2, 18) + 5);
        map.remove((int) Math.pow(2, 19) + 9);
        map.remove((int) Math.pow(2, 20) + 17);
        map.remove((int) Math.pow(2, 21) + 33);
        map.clear();
    }

    private static void testHashMap() {
        HashMap<Integer, Integer> map = new HashMap(64);
        map.put(1, 1);
        map.put(null, 10086);
        map.put((int) Math.pow(2, 16), 2);
        map.put((int) Math.pow(2, 17) + 3, 3);
        map.put((int) Math.pow(2, 18) + 5, 4);
        map.put((int) Math.pow(2, 19) + 9, 5);
        map.put((int) Math.pow(2, 20) + 17, 6);
        map.put((int) Math.pow(2, 21) + 33, 7);
        map.put((int) Math.pow(2, 22) + 65, 8);
        map.put((int) Math.pow(2, 23) + 129, 9);
        map.put((int) Math.pow(2, 24) + 128 + 129, 10);
        System.out.println(map.containsKey(1));
        map.remove(1);
        map.remove((int) Math.pow(2, 16));
        map.remove((int) Math.pow(2, 17) + 3);
        map.remove((int) Math.pow(2, 18) + 5);
        map.remove((int) Math.pow(2, 19) + 9);
        map.remove((int) Math.pow(2, 20) + 17);
        map.remove((int) Math.pow(2, 21) + 33);

        map.clear();
    }

}

