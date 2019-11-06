package javaBase;

import java.lang.reflect.Field;

/**
 * @author maple on 2019/10/18 16:39.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class Pri {
    public static class  A{
        A a;
    }
    public static void main(String[] args){
        A a = new A();
        Class<?> c= a.getClass();
        Field[] field= c.getDeclaredFields();
        for (Field f:field){
            System.out.println(f.getType().isPrimitive());
        }
    }
}
