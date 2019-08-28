package javaBase;

import sun.rmi.runtime.Log;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/8/26 17:06.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class fanxing1 {
    public static void main(String[] args){
        System.out.println();
        try {
            // 泛型擦除,为Object
           System.out.println( B.class.getDeclaredField("t").getType().toString());
           B b = new B<String>(){};
           Type t = b.getClass().getGenericSuperclass();
            System.out.println(t.toString());
           if (t instanceof ParameterizedType){
              Type type=  ((ParameterizedType) t).getActualTypeArguments()[0];
              System.out.println(type.toString());
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static class A<T>{
        ArrayList<ArrayList<Integer>> data;
    }
    static class B<T>{
        T t;
    }
}
