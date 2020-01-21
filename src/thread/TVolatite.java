package thread;

/**
 * @author maple on 2020/1/10 15:24.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class TVolatite {
    static int a=0;
    static int b=0;
    static int x=0;
    static int y=0;
    public static void main(String[] args) {
        long time =System.currentTimeMillis();
        for(;;){
            if (test()){
                System.out.println("测试异常出现的时间:"+(System.currentTimeMillis()-time));
                return;
            }
        }
    }
    static boolean test(){
        a=0;
        b=0;
        x=0;
        y=0;
        Thread aT=new Thread(new Runnable() {
            @Override
            public void run() {
                shortwait(80000);
                a=1;
                x=b;
            }
        });
        Thread bT=new Thread(new Runnable() {
            @Override
            public void run() {
                b=1;
                y=a;
            }
        });
        aT.start();
        bT.start();
        try {
            aT.join();
            bT.join();
        }catch (Exception e){

        }
        //经过上述操作,不论线程先后顺序,x,y中至少一个值为1,
        //如果存在指令重排序情况,y,x的赋值都在 a,b赋值的前面执行,则出现x=y=0
        System.out.printf(" %d, %d\n",x,y);
        if(x==0&&y==0){
            return true;
        }
        return false;
    }

    private static void shortwait(int i) {
        for (int j = 0; j < i; j++) {

        }
    }
}
