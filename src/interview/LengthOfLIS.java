package interview;

import sun.rmi.runtime.Log;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @author maple on 2019/3/13 10:30.
 * @version v1.0
 * @see 1040441325@qq.com
 * 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class LengthOfLIS {
    /**
     * @param nums 源
     * @return 最长上升子序列长度
     * dp[i] 记录以 nums[i]结尾的最长子序列长度,默认值为1;
     * dp[i] = max(dp[i], nums[i]>nums[j]?dp[j]+1) (0<=j<i;)
     * 最终 结果为 dp的最大值
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return dp[dp.length - 1];
    }

    // 贪心 + 二分, 利用贪心的思想，对于一个上升子序列，显然当前最后一个元素越小，越有利于添加新的元素，这样LIS长度自然更长
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int pos = 0;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[pos]) dp[++pos] = nums[i];
            else {
                for (int j = 0; j <= pos; j++) {
                    if (dp[j] >= nums[i]) {
                        dp[j] = nums[i];
                        break;
                    }
                }
            }
        }
        return pos + 1;
    }

    public static void main(String[] args)throws InterruptedException {
        ExecutorService executor = new ThreadPoolExecutor(1,1,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                print("=====11======");
            }
        });
        TimeUnit.SECONDS.sleep(5);
        executor.execute(new Run1());
    }
    static class Run1 implements Runnable{

        @Override
        public void run() {
            int count =0;
            while (true){
                count++;
                print("=====22====== "+ count);
                if (count==10){
                        System.out.println(1/0);
                }
                if (count==20){
                    print("Count: "+count);
                    break;
                }
            }
        }
    }
    private static void print(String s){
        System.out.println(Thread.currentThread().getName() + s);
    }
}
