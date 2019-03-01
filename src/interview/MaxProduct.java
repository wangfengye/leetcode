package interview;

import bytedance.MaxEnvelopes;

/**
 * @author maple on 2019/3/1 15:57.
 * @version v1.0
 * @see 1040441325@qq.com
 * 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数)
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
  /*      int[] plusMax = new int[nums.length];
        int[] minusMin = new int[nums.length];
        plusMax[0] = nums[0];
        minusMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            plusMax[i] =Math.max(Math.max(plusMax[i-1]*nums[i],minusMin[i-1]*nums[i]),nums[i]);
            minusMin[i] =Math.min(Math.min(plusMax[i-1]*nums[i],minusMin[i-1]*nums[i]),nums[i]);
            max = Math.max(Math.max(plusMax[i],minusMin[i]),max);
        }
        return max;*/
        int max = 0;
        int res = 0;
        int first = -1;//负数数量
        int last = -1;//最后一个负数位置
        int num = 0;// 乘数为负数时,记录当前值;
        int zero = -1;//起点-1
        for (int i = 0; i < nums.length + 1; i++) {
            if (i == nums.length || nums[i] == 0) {
                if (i - zero == 2) res = nums[i - 1];
                else if (first != -1 && first % 2 == 1) {//res为负数
                    int temp = 1;
                    for (int j = last; j <= i - 1; j++) {
                        temp = temp * nums[j];//最后一个负数后面的乘积
                    }
                    num = num > temp ? num : temp;
                    res = res / num;
                }
                max = res > max ? res : max;
                first = -1;
                last = -1;
                num = 0;
                res = 0;
                zero = i;
                continue;
            }
            if (nums[i] != 0) {
                if (res == 0) res = nums[i];
                else res = nums[i] * res;
            }
            if (nums[i] < 0) {
                if (first == -1) {
                    num = res;
                    first = 1;
                } else {
                    first++;
                }
                last = i;
            }
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(new MaxProduct().maxProduct(new int[]{1,-1,-1,23,-2,1,}));
    }
}
