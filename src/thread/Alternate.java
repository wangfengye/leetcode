package thread;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author maple on 2020/1/7 16:22.
 * @version v1.0
 * @see 1040441325@qq.com
 * 交替打印 ABC,123
 */
public class Alternate {
    static Thread a = null;
    static Thread b = null;
    static int[] arr1 = new int[]{1, 2, 3};
    static char[] arr2 = new char[]{'A', 'B', 'C'};

    public static void main(String[] args) {
        //waitNotify();
        //condition();
        transfer();
        //ThreadLocal泄漏问题:长期存活的线程中,ThreadLocalMap中只有key是软引用,value强引用不会自动释放
        //因此必须手动remove value, 实际使用中,泄漏量少,除非是一直活着的线程长期运行后发现一些异常大的线程.

    }

    public static void locksupport() {
        // LockSupport;
        //允许先唤醒,后锁
        //换种理解方式,队列, park()是索要门票,没门票等待直到unpark给门票,如果先给门票,park直接通过
        a = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    System.out.println(arr1[i]);
                    LockSupport.unpark(b);
                    LockSupport.park();

                }
            }
        });
        b = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    LockSupport.park();
                    System.out.println(arr2[i]);
                    LockSupport.unpark(a);
                }
            }
        });
        a.start();
        b.start();
    }

    public static void waitNotify() {
        Object o = new Object();
        a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    for (int i : arr1) {
                        System.out.println(i);
                        o.notify();

                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    o.notify();
                }
            }
        });
        b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (char i : arr2) {
                        System.out.println(i);
                        o.notify();

                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    o.notify();
                }
            }
        });
        b.start();
        a.start();

    }

    //condition :条件队列
    public static void condition() {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i : arr1) {
                        System.out.println(i);
                        condition2.signal();
                        condition1.await();
                    }
                    //结束循环,释放对方锁.
                    condition2.signal();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }

            }
        });
        b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    condition2.await();
                    for (char i : arr2) {
                        System.out.println(i);
                        condition1.signal();
                        condition2.await();
                    }
                    condition1.signal();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        });
        b.start();
        a.start();
    }

    static TransferQueue<Character> queue = new LinkedTransferQueue<>();

    public static void transfer() {
        a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i : arr1) {

                        //插入一条记录,阻塞直到数据被取走
                        queue.transfer((char) (i + '0'));
                        //阻塞取一条记录.
                        System.out.println(queue.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

            }
        });
        b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (char i : arr2) {
                        System.out.println(queue.take());
                        queue.transfer(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        });
        a.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
    }
}
