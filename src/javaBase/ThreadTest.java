package javaBase;

import java.util.concurrent.*;

/**
 * @author maple on 2019/3/27 10:14.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class ThreadTest {
    public static void main(String[] args) {
        //testPool();
        //testSchedule();
        testThreadLocal();
    }
    static class Local{
        int index;
        String name;

        public Local(int index, String name) {
            this.index = index;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Local{" +
                    "index=" + index +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    /**
     * 测试ThreadLocal变量
     */
    private static void testThreadLocal(){
        ThreadLocal<Local> local = new ThreadLocal<Local>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                local.set(new Local(1,Thread.currentThread().getName()));
                System.out.println(local.get().toString());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                local.set(new Local(1,Thread.currentThread().getName()));
                System.out.println(local.get().toString());
            }
        }).start();
        System.out.println(local.get().toString());
    }

    /**
     * 错误demo,测试定时任务的,结果使用默认变量及线程共享变量,导师制错我
     */
    private static void testScheduled(){
        final int[] i = {0};
        ScheduledExecutorService s = Executors.newScheduledThreadPool(10);
        s.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start   : " + i[0]+ "--- " + System.currentTimeMillis() / 1000);
                s.schedule(this,2,TimeUnit.SECONDS);
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + " finished: " + i[0] + "--- " + System.currentTimeMillis() / 1000);
                    i[0]++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },  2, TimeUnit.SECONDS);
    }
    private static void testScheduled2(){
        final int[] i = {0};
        ScheduledExecutorService s = Executors.newScheduledThreadPool(10);
        s.schedule(new Runnable() {
            @Override
            public void run() {
                int tmp =i[0];
                i[0]++;
                System.out.println(Thread.currentThread().getName() + " start   : " + tmp + "--- " + System.currentTimeMillis() / 1000);
                s.schedule(this,2,TimeUnit.SECONDS);
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + " finished: " + tmp + "--- " + System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },  2, TimeUnit.SECONDS);
    }
    /**
     * 测试线程池 scheduleAtFixedRate()延时实效
     * 实际延时时间取决于两者: 上次任务执行的时间:lastActionTime,设置的延时时间 delayTime;
     * 任务开始间隔时间 = Max(lastActionTime,delayTime);
     */
    private static void testSchedule() {
        final int[] i = {0};
        ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
        s.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": " + i[0]++ + "--- " + System.currentTimeMillis() / 1000);
                try {
                    Thread.sleep(i[0] * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);
    }

    /**
     * 线程池各参数使用测试,及任务执行顺序
     * 一个task,如果核心线程未满,新建核心线程执行,已满提交至workQueue,等待核心线程取任务,workQueue已满,新建临时线程执行任务
     */
    private static void testPool() {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);

        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(Thread.currentThread().getName() + " 任务满了");
                r.run();
            }
        };
        ThreadPoolExecutor pool2 = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, workQueue, handler);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, workQueue, handler);
        for (int i = 0; i < 16; i++) {
            int finalI = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " === " + finalI);
                }
            });
        }

        while (true) {
        }
    }
}
