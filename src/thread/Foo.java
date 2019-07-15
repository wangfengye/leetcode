package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author maple on 2019/7/15 14:11.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1114. 按序打印
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Foo {

    private volatile boolean lock1;
    private volatile boolean lock2;
    public Foo() {
        lock1=true;lock2=true;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        lock1=false;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (lock1){

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        lock2=false;

    }

    public void third(Runnable printThird) throws InterruptedException {
        while (lock2){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread fir = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(() -> System.out.println("fir"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread sec = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(() -> System.out.println("sec"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thr = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(() -> System.out.println("thr"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        thr.start();
        sec.start();
        fir.start();
    }
}
