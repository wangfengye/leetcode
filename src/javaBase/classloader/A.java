package javaBase.classloader;

/**
 * @author maple on 2019/10/21 15:52.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class A {
    public static long data= A.class.getClassLoader().hashCode();
}
