package javaBase;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author maple on 2019/3/29 13:37.
 * @version v1.0
 * @see 1040441325@qq.com
 * AbstractQueuedSynchronizer;
 */
public class Mutex implements Lock {
    private final Sync sync = new Sync();
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override//支持中断式的获取lock
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);// 获取前,检测线程状态
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
    static class Sync extends AbstractQueuedSynchronizer{
        // 线程是否锁住
        @Override
        protected boolean isHeldExclusively(){
            return getState() ==1;
        }

        @Override// 获取锁
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override//释放锁
        protected boolean tryRelease(int arg) {
            if (getState()==0)throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }
    }
    public static void main(String[] args){
        Mutex mutex = new Mutex();
        /*Runnable run = new Runnable() {
            @Override
            public void run() {
                mutex.lock();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+System.currentTimeMillis());
                mutex.unlock();
            }
        };
        Thread a = new Thread(run);
        Thread b = new Thread(run);
        a.start();b.start();*/
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2,false);
        queue.add(1);
        queue.add(2);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (;;){
                    int a = 0;
                    try {
                        a = queue.poll(1000, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+": "+a);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(runnable).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(runnable).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(runnable).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final int[] i = {3};
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.add(i[0]++);}
            }
        }).start();
    }
}
