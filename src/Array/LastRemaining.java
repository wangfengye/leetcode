package Array;

/**
 * 面试题62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 */
public class LastRemaining {
    /**
     * 递归算法优化
     */
    public int lastRemaining(int n, int m) {
        int x=0;
        for (int i = 2; i<=n ; i++) {
            x=(m+x)%i;
        }
        return x;
    }

    /**
     * 递归求被删除的数字
     * n-1 最后剩下的数x,
     * n 第一次删除的数 (m%n),之后开始 n-1的删除
     * 即剩余数为 m%n后的第x个数, 结果 m%n+x%n;
     */
    private int f(int n,int m){
        if(n==1)return 0;
        int x=f(n-1,m);
        return (m+x)%n;
    }

}
