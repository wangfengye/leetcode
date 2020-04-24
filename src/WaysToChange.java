import java.io.FileOutputStream;

/**
 * 面试题 08.11. 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 本质背包问题
 */
public class WaysToChange implements AutoCloseable{
    private static final int MOD= 1000000007;
    private static final int[] COINS= new int[]{1,5,10,25};
    public static int waysToChange(int n) {
        int[] f=new int[n+1];
        f[0]=1;
        for (int c = 0; c < 4; c++) {
            int coin=COINS[c];
            for (int i = coin; i <=n; i++) {
                f[i]=(f[i]+(i>=coin?f[i-coin]:0))%MOD;
            }
        }
        return f[n];
    }

    /**
     * r= 25分的数量
     * a= 十分的数量
     * b= 5分的数量
     * 25a+10b+5c+d=n;的非负整数解,
     * 设 5m+k=n; d-k=5e
     * 25a+10b+5c+d-k=5m;
     * 5a+2b+c+e=m
     * 当a = 0时，相当于求方程m = 2b + c + e的非负整数解的数量。
     * 若b = i，则解数为(m - 2i + 1)，因此，此时总的解数是对(m - 2i + 1)从i = 0到[m/2]求和。
     * （[x]是取下整函数），该和为([m/2] + 1)([(m+1)/2] + 1)；
     * 当a > 0时，有a' = a - 1 >= 0，从而解的数量等于m - 5 = 5a' + 2b + c + e解的数量，即F(m - 5)；。
     * @param n
     * @return
     */
    public static int waysToChange2(int n) {
        int ans=0;
        for (int i = 0; i*25 <=n; i++) {
            int r=n-i*25;
            int a=r/10;
            int b=r%10/5;
            ans=(ans+(a+1)*(a+b+1)%MOD)%MOD;
        }
        return ans;
    }
    public static void main(String[] args){
       /* System.out.println(waysToChange2(5));
        System.out.println(waysToChange2(10));

        try(WaysToChange b=new WaysToChange();WaysToChange c=new WaysToChange()){

        }catch (Exception e){
            e.printStackTrace();
        }*/
        long a=1;
        Long b=1L;
        Long c=1L;
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b==c);
    }

    @Override
    public void close() throws Exception {
        System.out.println("closed");


    }
}
