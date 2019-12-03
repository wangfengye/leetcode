package Array;

import java.util.Arrays;

/**
 * @author maple on 2019/12/3 9:30.
 * @version v1.0
 * @see 1040441325@qq.com
 * 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 * <p>
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 * <p>
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 * <p>
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 */
public class HasGroupsSizeX {
    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1}));
        System.out.println(hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3}));
        System.out.println(hasGroupsSizeX(new int[]{1}));
        System.out.println(hasGroupsSizeX(new int[]{1,1}));
        System.out.println(hasGroupsSizeX(new int[]{1,1,2,2,2,2}));
    }

    /**
     * 思路:计算数值数量,求最大公约数.
     * @param deck
     * @return
     */
    public static boolean hasGroupsSizeX(int[] deck) {
        int res = -1;
        Arrays.sort(deck);
        int last = 0;
        for (int i = 1; i <= deck.length; i++) {
            if (i== deck.length||deck[i] != deck[last]) {
                int tmp = i-last ;
                if (tmp == 1) return false;
                if (res == -1) {
                    res = i-last;
                } else {
                    if (tmp != res) {
                        res = maxCommonDivisor(tmp, res);
                    }

                }
                last = i;
            }
        }

        return res >= 2;
    }

    public static int maxCommonDivisor(int m, int n) {
        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        if (m % n == 0) {// 若余数为0,返回最大公约数
            return n;
        } else { // 否则,进行递归,把n赋给m,把余数赋给n
            return maxCommonDivisor(n, m % n);
        }
    }
}
