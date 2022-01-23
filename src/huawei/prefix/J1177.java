package huawei.prefix;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路:
 * 需要统计连续的字子串字母数量.
 * 0. 字串可重排序,推到判断字串中,不成对的字母的数量即可判断
 * 1. 前缀和存储,每个字母的数量 用int[26] 存储
 * 2. 考虑只要知道是奇数还是偶数 压缩存储单元, 使用int二进制下每一位表示奇偶性
 * 3. 快速计算int二进制的树里, 取余>位移>&运算符
 *
 */
public class J1177 {
    public static void main(String[] args){
        canMakePaliQueries("abcda",new int[][]{{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}}).forEach(aBoolean -> System.out.print(aBoolean+", "));
        System.out.println();
        canMakePaliQueries("rkzavgdmdgt",new int[][]{{5,8,0},{7,9,1},{3,6,4},{5,5,1},{8,10,0},{3,9,5},{0,10,10},{6,8,3}}).forEach(aBoolean -> System.out.print(aBoolean+", "));
    }
    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[] preSum = new int[s.length() + 1];
        // 使用int存储26个小写字母的个数情况(奇/偶)
        for (int i = 0; i < s.length(); i++) {
            preSum[i + 1] = preSum[i] ^ (1 << (s.charAt(i) - 'a'));
        }
        List<Boolean> bols = new ArrayList<>();
        for (int[] query : queries) {
            // 取出存在字母奇偶数量的数字
            int tmp = preSum[query[1] + 1] ^ preSum[query[0]];
            // 回文检测推断: 奇数长度:可不重复次数 <=2*k+1,可不重复次数 <=2*k
            // bols.add(getOnes(tmp) <= 2 * query[2] + (query[1] - query[0] + 1) % 2);
            // 优化
            bols.add(getOnes(tmp)>>1<=query[2]);
        }
        return bols;
    }

    /**
     * @param tmp 入参
     * @return 二进制形式下1的数量
     */
    private static int getOnes(int tmp) {
        int ones = 0;
/*        while (tmp > 0) {
            // tmp&-tmp可以取到tmp二进制形式下最后一个1.
            // 内存中数字以补码形式存储,负数补码,反码+1, 负数原码&反码=0 ,+1变成补码,最后一个0变为1, 与原码这一位一致.
            tmp -=(tmp&(tmp-1));
            ones++;
        }*/
        while(tmp!=0){
            tmp&=(tmp-1);
            ones++;
        }
        return ones;
    }
}
