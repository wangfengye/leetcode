package javaBase;

import java.util.concurrent.LinkedBlockingDeque;


public class Test {
    /**
     * 线程关闭三种方式(除stop外,其他方式无法管不局部代码死循环问题)
     * stop();强制关闭,简单粗暴,很少用,函数被标记过期;创建子线程的线程就会抛出ThreadDeatherror的错误，并且会释放子线程所持有的所有锁,
     * 由此可知,stop首先释放锁,可能导致数据一致性问题.释放后存在for循环等仍不能结束的,会直接关闭,后面的代码无法执行.
     * runnable执行结束;
     * interrupt()函数.本质还是给线程发一个中断标记,线程需要自己判断这个标记让内部runnable运行的结尾.同时如果线程阻塞,会抛出异常,
     * 解决,自定义的标识当阻塞时无法主动检查标记的问题.比自定义的优势时,当线程阻塞时,会主动唤醒线程
     * Android Looper
     * 使用了MessageQueue 一个native层实现的队列,当需要退出时调用队列的quit函数,清空队列,禁止插入任务.mPtr是Queue在native层的地址.native
     * 层queue置空,mPtr此时为0.next函数判断mPtr==0.会返回一个null, Looper检测到next值为空,推出循环,线程自动关闭,刚方案实现线程中基于所有的阻塞都是
     * MessageQueue来完成的,如果后续操作加入其他阻塞,会导致其无法关闭.
     * 线程池:
     * stop标记为True(该标记还做了自旋锁).遍历等待中所有线程执行interrupt,运行中的线程检测到stop标记,执行interrupt.
     * 关闭是否安全在于对Shutdown调用时,队列剩余任务的处理方式(清空任务/等待剩余任务完成)
     */
    static volatile boolean running;

    public static void main(String[] args) {
        testCustom();
        testStop();
        testInterrupt();
        //new ThreadPoolExecutor().shutdown();
    }

    private static void testInterrupt() {
        LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
        queue.offer(1);
        running = true;
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {//检查关闭标记.
                        int i = queue.take();
                        System.out.println("" + running);
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("worker closed");
            }
        }, "worker");
        worker.start();

        try {
            queue.put(2);

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            queue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }

    private static void testStop() {
        LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
        queue.offer(1);
        running = true;
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (running) {//检查关闭标记.
                        int i = queue.take();
                        System.out.println("" + running);
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("worker closed");
            }
        }, "worker");
        worker.start();

        try {
            queue.put(2);

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            queue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       worker.stop();

    }

    private static void testCustom() {
        LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
        queue.offer(1);
        running = true;
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (running) {//检查关闭标记.
                        int i = queue.take();
                        System.out.println("" + running);
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("worker closed");
            }
        }, "worker");
        worker.start();

        try {
            queue.put(2);

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // interrupt直接拉起线程退出循环
        // worker.interrupt();
        running = false;
        try {
            //自定义标志,只有在修改标记后,无法唤醒线程,只有
            //再次循环时检测到标记,推出循环
            queue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //worker.stop();
        //new ThreadPoolExecutor().shutdown();
    }
}
