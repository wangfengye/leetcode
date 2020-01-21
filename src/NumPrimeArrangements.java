/**
 * 1175. 质数排列
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 *
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 *
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 * 示例 2：
 *
 * 输入：n = 100
 * 输出：682289015
 *思路 相当于将质数和合数分开排列,排列数相乘
 */
public class NumPrimeArrangements {
    private static int mod=1000000000+7;
    public static int numPrimeArrangements(int n) {
        //计算质数性能开销大,用空间换时间(100内的质数)
        int primes[] = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
        int i;
        for (i = 0; i < primes.length; i++) {
            if(primes[i]>n)break;
        }
        long tmp1=1;//质数排列数量 n=质数数量 C(n * n-1 * ... * 2)
        int t=i;
        while (t>1){
            tmp1*=t--;
            tmp1%=mod;
        }
        long tmp2=1;//C(2*3*...非质数数量)
        for (int j = 2; j <= n - i; j++) {
            tmp2*=j;
            tmp2%=mod ;
        }
        int res=(int)((tmp1*tmp2)%mod);
        return res;
    }
    public static void main(String[] args){
        System.out.println(numPrimeArrangements(5));
        System.out.println(numPrimeArrangements(100));


    }
}
