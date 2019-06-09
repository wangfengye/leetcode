package javaBase;

import org.omg.CORBA.MARSHAL;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author maple on 2019/5/22 16:44.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class HashMapTest {
    public static void main(String[] args) {
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
     /*   ArrayList<Integer> data = new ArrayList<>();
        data.add(2);
        for (int i = 3; i < 100000000; i++) {
            for (int j = 0; j < data.size(); j++) {
                if (i % data.get(j) == 0) {
                    break;
                } else if (data.get(j) * data.get(j) > i) {
                    data.add(i);
                    break;
                }
            }
        }
          System.out.println(Arrays.toString(data.toArray()));*/
        testConcurrentHashMap();
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


}

