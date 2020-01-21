package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author maple on 2020/1/8 17:29.
 * @version v1.0
 * @see 1040441325@qq.com
 * 线程启动
 * 轻量级进程,并发运行,共享内存
 * 常用方法.sleep,wait ,joint iter
 */
public class ThreadStart {
    static class ARunable implements Runnable{

        @Override
        public void run() {

        }
    }
    public static void main(String[] args){
        //.start()调用,new Thread中出入,匿名实例,直接实例,lamda表达式
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        new Thread(new ARunable()).start();
        new Thread(()->{}).start();
        //传入future,实现一个有返回值的runnable
        Thread thread=new Thread(new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName()+" finish");
                return null;
            }
        }));
        thread.start();
        //线程池,提交任务. exectute submit
        ExecutorService service=Executors.newCachedThreadPool();
        service.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        System.out.println(Thread.currentThread().getName()+" finishMain");
    }
}
