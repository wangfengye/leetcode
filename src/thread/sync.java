package thread;

/**
 * @author maple on 2020/1/8 19:46.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class sync {
    /**
     * hotspot实现
     * <p>
     * 对象在内存中的存储布局
     * markword.
     * hashcode
     * 分代年龄(经历过几次GC,默认15/CMS=6时进入老年区)
     * <p>
     * 偏向锁: 一个线程拿到锁.
     * 轻量级锁:竞争线程数<=进程的1/2,且咨询10次内(消耗cpu)
     * 重量级锁:涉及内核/用户态切换.生成moitor.对象.
     *
     */
    //Inter lock comxchg.
    //MESI Cache 一致性协议(cpu中缓存的协议)
    //dcl 和volatile
    static int count;
    static Object o = new Object();

    public static void test() {
        synchronized (o) {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        }
    }

    //-XX:-UseBiasedLocking
    //-XX:+PreBlockSpin=指定自旋上限默认10,1.7后取消改配置,系统会自动调增自旋次数.
    public static void main(String[] args) {
        Thread[] threads = new Thread[10000];
        long start=System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    test();
                }
            });
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /**
         * 结果及其不明显
         * 普通      1578643114804
         *           1578643126590
         *           1578646299048
         * 关闭偏向: 1578643154572
         *           1578643167517
         */


        System.out.println("耗时: "+start);
    }
}
