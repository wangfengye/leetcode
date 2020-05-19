package thread;

import java.util.LinkedList;

/**
 * 测试对象 wait的使用
 */
public class ObjectLock {
    private static final Object lock = new Object();
    interface Callback{
        void onCallback(String s);
    }
    private static LinkedList<Callback> callbacks=new LinkedList<>();
    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    Callback callback=new Callback() {
                        @Override
                        public void onCallback(String s) {
                            System.out.println(s);
                        }
                    };
                    callbacks.add(callback);
                    callbacks.add(new Callback() {
                        @Override
                        public void onCallback(String s) {
                            System.out.println(s+"2");
                        }
                    });
                    System.out.println("a start");
                    try {
                        lock.wait(1000 * 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(callbacks.size() > 0&&callbacks.getFirst().equals(callback)){
                        callback.onCallback("a call");
                        callbacks.removeFirst();
                    }
                    System.out.println("a finish");
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("b start");
                    lock.notifyAll();
                    long start=System.currentTimeMillis();
                    for(;;){
                        if(System.currentTimeMillis()-start>1000)break;
                    }
                    callbacks.removeFirst().onCallback("b callback");
                    System.out.println("b finish");
                }
                System.out.println("b outside finish");
            }
        });
        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
    }
}
