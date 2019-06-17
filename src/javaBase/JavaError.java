package javaBase;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author maple on 2019/6/17 15:50.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class JavaError {
    private static void testFloat1(){//note: 浮点数运算带来的精度丧失
        Float a = 1.0f-0.9f;
        Float b = 0.9f-0.8f;
        if (a == b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    private static void testFloat2(){
        Float a = Float.valueOf(1.0f - 0.9f);
        Float b = Float.valueOf(0.9f - 0.8f);
        if (a.equals(b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    private static void testSwitch(){// switch值不能为空
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }

    private static void testBigDecimal(){
        BigDecimal a = new BigDecimal(0.1);//传入的浮点值本身存在精度损失
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");// 字符串,通过取字符,放大倍数的操作,中间过程未使用浮点数,无精度损失
        System.out.println(b);
    }
    private final static Lock lock = new ReentrantLock();//默认非公平锁

    public static void testLock() {
        try {
            int a=1/0;
            lock.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//加锁,解锁操作必须一一对应
        }
    }
    public static void main(String[] args){
        testFloat1();
        testFloat2();
        // testSwitch();
        testBigDecimal();
        testLock();
    }
}
