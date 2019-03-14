package interview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author maple on 2019/3/14 10:02.
 * @version v1.0
 * @see 1040441325@qq.com
 *   零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];// 记录和为 i时最少硬币数
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        Arrays.sort(coins);
        for (int i = 0; i <=amount; i++) {
            for (int j = 0; j < coins.length&&coins[j]<=i; j++) {
                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        if (dp[amount]==amount+1)return -1;
        return dp[amount];
    }
    public static void main(String[] args){
        new CoinChange().coinChange(new int[]{474,83,404,3},264);
    }
}
