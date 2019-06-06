import org.bouncycastle.util.Arrays;

/**
 * @author maple on 2019/6/6 9:15.
 * @version v1.0
 * @see 1040441325@qq.com
 * 762. 二进制表示中质数个计算置位
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 * <p>
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 * <p>
 * 示例 1:
 * <p>
 * 输入: L = 6, R = 10
 * 输出: 4
 * 解释:
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 示例 2:
 * <p>
 * 输入: L = 10, R = 15
 * 输出: 5
 * 解释:
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 */
public class CountPrimeSetBits {
    public static int[] ZHI = {2, 3, 5, 7, 11, 13, 17, 19,23};

    public int countPrimeSetBits(int L, int R) {
        int sum = 0;
        for (; L <= R; L++) {

            int counter = Integer.bitCount(L);//1的数量;
            if (contains(counter)) sum++;
        }
        return sum;
    }

    public int countPrimeSetBits2(int L, int R) {
        int primeBit = 0x50451456;//该数的二进制长31, 保证右移质数-1位时末尾值为1,

        int ans = 0;
        for (; L <= R; L++) {
            ans += (primeBit >> Integer.bitCount(L) - 1) & 1;
        }

        return ans;
    }

    public boolean contains(int c) {
        for (int t : ZHI) {
            if (t == c) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString((int) Math.pow(10, 6)).length());
        System.out.println(Integer.toBinaryString(0x50451456)+"---len "+Integer.toBinaryString(0x50451456).length());

        for (int t : ZHI) {
            System.out.println("source : "+t);
            System.out.println("me     : "+Integer.toBinaryString(t));
            System.out.println("fast   : "+Integer.toBinaryString(0x50451456>>(t -1)));
        }

        System.out.println(new CountPrimeSetBits().countPrimeSetBits(10, 15));
    }
}
