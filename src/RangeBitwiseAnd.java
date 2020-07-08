/**
 * 201. 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1:
 *
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 */
public class RangeBitwiseAnd {
    /**
     * 归纳出结论 ,m,n 二进制下的公共前缀
     */
    public static int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // find the common 1-bits
        while (m < n) {//向右移知道m==n;
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    /**
     * Brian Kernighan 算法 清除末尾的0.
     */
    public static int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            // turn off rightmost 1-bit
            n = n & (n - 1);
        }
        return m & n;


    }
    public static void main(String[] args){
        System.out.println(rangeBitwiseAnd(5,7));
        System.out.println(rangeBitwiseAnd(0,1));
    }
}
