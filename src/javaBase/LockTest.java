package javaBase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author maple on 2019/6/6 16:56.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class LockTest {
    public static void main(String[] args) {
        LockTest t = new LockTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.read();
                t.write();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.read();
                t.write();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.read();
                t.read();
                t.read();
            }
        }).start();
    }

    private ReentrantReadWriteLock mLock = new ReentrantReadWriteLock();

    private void read() {
        mLock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "read_start" + System.currentTimeMillis());
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() - time < 1000) {
        }
        mLock.readLock().unlock();
        System.out.println(Thread.currentThread().getName() + "read_end" + System.currentTimeMillis());

    }

    private void write() {
        mLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "write_start" + System.currentTimeMillis());
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() - time < 1000) {
        }
        mLock.writeLock().unlock();
        System.out.println(Thread.currentThread().getName() + "write_end" + System.currentTimeMillis());
    }

}
