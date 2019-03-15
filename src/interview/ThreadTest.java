package interview;

import java.util.concurrent.Semaphore;

/**
 * @author maple on 2019/3/14 16:09.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class ThreadTest {
    /**
     * 通过N个线程顺序循环打印从0至100，如给定N=3则输出:
     * thread0: 0
     * thread1: 1
     * thread2: 2
     * thread0: 3
     * thread1: 4
     * .....
     */
    static int result = 0;

    private static void threadPrint(int n) throws InterruptedException {
        Thread[] threads = new Thread[n];
        //Semaphore 信号量,用于控制特定资源的线程熟练,协调各个线程
        //每个现成配一个许可数为1的Semaphore,获取当前线程许可执行过一个线程释放下一个线程的许可
        final Semaphore[] syncs = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            syncs[i] = new Semaphore(1);
            if (i != 0) syncs[i].acquire();
        }
        for (int i = 0; i < n; i++) {
            final Semaphore cur = syncs[i];
            final Semaphore next = i == n - 1 ? syncs[0] : syncs[i + 1];
            threads[i] = new Thread(() -> {
                while (true) {
                    try {
                        cur.acquire();
                        print(String.valueOf(result++));
                        if (result > 100) System.exit(0);
                        next.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
    }

    private static void print(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }

    public static void main(String[] args) throws InterruptedException {
        threadPrint(101);
    }
}
