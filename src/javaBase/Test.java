package javaBase;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    /**
     * 线程关闭三种方式
     * stop();强制关闭,简单粗暴,很少用,函数被标记过期;创建子线程的线程就会抛出ThreadDeatherror的错误，并且会释放子线程所持有的所有锁,
     * 由此可知,stop首先释放锁,可能导致数据一致性问题.释放后存在for循环等仍不能结束的,会直接关闭,后面的代码无法执行.
     * runnable执行结束;
     * interrupt()函数.本质还是给线程发一个中断标记,线程需要自己判断这个标记让内部runnable运行的结尾.同时如果线程阻塞,会抛出异常,
     * 解决,自定义的标识当阻塞时无法主动检查标记的问题.
     * Android Looper
     * 使用了MessageQueue 一个native层实现的队列,当需要退出时调用队列的quit函数,清空队列,禁止插入任务.mPtr是Queue在native层的地址.native
     * 层queue置空,mPtr此时为0.next函数判断mPtr==0.会返回一个null, Looper检测到next值为空,推出循环,线程自动关闭,刚方案实现线程中基于所有的阻塞都是
     * MessageQueue来完成的,如果后续操作加入其他阻塞,会导致其无法关闭.
     * 线程池:
     * stop标记为True(该标记还做了自旋锁).遍历等待中所有线程执行interrupt,运行中的线程检测到stop标记,执行interrupt.
     * 关闭是否安全在于对Shutdown调用时,队列剩余任务的处理方式(清空任务/等待剩余任务完成)
     */
    public static void main(String[] args) {
        LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
        queue.offer(1);
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {//检查关闭标记.
                        int i = queue.take();
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
        //worker.interrupt();
        worker.stop();
        //new ThreadPoolExecutor().shutdown();
    }
}
