package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private int x;
    ReentrantLock lock;
    Condition condition;
    public ZeroEvenOdd(int n) {
        this.n = n;
        lock=new ReentrantLock();
        condition=lock.newCondition();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        printNumber.accept(0);
        lock.unlock();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        printNumber.accept(++x);
        lock.unlock();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        printNumber.accept(++x);
        lock.unlock();
    }
    public static void main(String[] args){
        short FRAME_HEAD = (short) 0xa506;
        System.out.println(Byte.toUnsignedInt((byte) (FRAME_HEAD>>8))+ "-- " + (FRAME_HEAD&0xff)); ;

    }
}
