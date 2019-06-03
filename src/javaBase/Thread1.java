package javaBase;

import org.bouncycastle.math.Primes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author maple on 2019/5/17 11:58.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class Thread1 {
    private static int count;
    static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    private static volatile Thread1 mTh;

    private static Thread1 getInstance() {
        if (mTh == null) {
            mTh = new Thread1();
            show("init once");
        }
        return mTh;
    }

    public static void main(String[] args) {
        Runnable mInit = new Runnable() {
            @Override
            public void run() {
                show("start");
                getInstance();
            }
        };
        Thread a = new Thread(mInit);
        Thread b = new Thread(mInit);
        Thread c = new Thread(mInit);
        Thread d = new Thread(mInit);

        a.start();
        b.start();
        c.start();
        d.start();
        while (a.isAlive() || b.isAlive() || c.isAlive() || d.isAlive()) {

        }
    }

    static int a = 1;

    public static void due2() {
        a = 1;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a = a - 1;
                show(String.valueOf(a));
            }
        }).start();
        while (a > 0) {
            //System.out.println("s");
        }
        show("finish\n");
    }


    /**
     * 原始错误模型
     * handler 线程 接收task 处理 `count--`操作;
     * a,b线程,向handler 发送task,
     * main 线程 count=2,启动a,b线程,while自旋锁自己,等待两次任务执行,
     * 循环第二次任务卡死
     */
    private static void dueMain() {
        Thread handler = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        int i = queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                    show("due");
                }
            }
        }, "handler");
        handler.start();
    }

    private static void due() {
        System.out.println("\n*********************************");
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    //模拟网络延时
                }
                queue.offer(1);
                show("send");
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    //模拟网络延时
                }
                queue.offer(1);
                show("send");
            }
        }, "b");

        new Thread(new Runnable() {
            @Override
            public void run() {
                show("start");
                count = 2;
                a.start();
                b.start();
                while (count > 0) {
                    show(String.valueOf(count));
                    //waitting
                }
                show("finished");
                due();
            }
        }, "main").start();
    }

    private static void show(String s) {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        String time = format.format(new Date());
        System.out.println(Thread.currentThread().getName() + " " + time+'\'' +System.currentTimeMillis()%1000+ ": " + s);
    }
}
