package search;

import java.util.Arrays;

/**
 * @author maple on 2018/11/28 9:26.
 * @version v1.0
 * @see 1040441325@qq.com
 * 找出第 k 小的距离对
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值
 */
public class SmallestDistancePair {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];

        int[] dis = new int[max-min+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                dis[Math.abs(nums[i]-nums[j])]++;
            }
        }
        int i =-1;
        while (k>0){
            i++;
            k=k-dis[i];
        }

        while (i<max){
            if (dis[i]>0)return i;
        }
        return -1;
    }

    /**
     * 二分法,根据差值来二分,预估一个差值取其1/2作为初始值,计算符合的数量是否大于k;进行迭代
     */
    public static int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length-1] - nums[0];
        while (lo < hi) {
            int mi = lo + (hi-lo) / 2;
            int count = getCount(nums,mi);
            if (count >= k)
                hi = mi;
            else
                lo = mi + 1;
        }
        return lo;
    }
    //获取差值小于mi的数量
    private static int getCount(int[] nums,int mi){
        int count = 0, left = 0;
        for (int right = 0; right < nums.length; ++right) {
            while (nums[right] - nums[left] > mi)
                left++;
            count += right - left;
        }
        return count;
    }
        public static void main(String[] args){
        System.out.println(smallestDistancePair2(new int[]{1,3,1},1));
    }
}
