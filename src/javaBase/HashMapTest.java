package javaBase;

import org.omg.CORBA.MARSHAL;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author maple on 2019/5/22 16:44.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap(64);
        map.put(1, 1);
        map.put((int) Math.pow(2, 16), 2);
        map.put((int) Math.pow(2, 17) + 3, 3);
        map.put((int) Math.pow(2, 18) + 5, 4);
        map.put((int) Math.pow(2, 19) + 9, 5);
        map.put((int) Math.pow(2, 20) + 17, 6);
        map.put((int) Math.pow(2, 21) + 33, 7);
        map.put((int) Math.pow(2, 22) + 65, 8);
        map.put((int) Math.pow(2, 23) + 129, 9);
        map.put((int) Math.pow(2, 24) + 128 + 129, 10);
        map.remove(1);
        map.remove((int) Math.pow(2, 16));
        map.remove((int) Math.pow(2, 17) + 3);
        map.remove((int) Math.pow(2, 18) + 5);
        map.remove((int) Math.pow(2, 19) + 9);
        map.remove((int) Math.pow(2, 20) + 17);
        map.remove((int) Math.pow(2, 21) + 33);
        map.clear();
        A a = new A();
        new Thread(a::showA).start();
        new Thread(a::showB).start();

    }


}

class A {
    public synchronized void showA() {
        System.out.println(Thread.currentThread().getName() + "A");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void showB() {
        System.out.println(Thread.currentThread().getName() + "B");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
