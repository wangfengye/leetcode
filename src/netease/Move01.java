package netease;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author maple on 2019/6/21 16:00.
 * @version v1.0
 * @see 1040441325@qq.com
 * 随机01,将0移动到左侧
 */
public class Move01 {
    public static void move01(int[] nums){
        int l =0;
        int r =nums.length-1;
        while (l<r){
            if (nums[l]==0)l++;
            else{
                while (nums[r]==1&&r>l){
                    r--;
                }
                if (r<=l)return;
                nums[l]=0;
                nums[r]=1;
                l++;r--;
            }
        }
    }
    public static void main(String[] args){
        testMove(new int[]{1,0,1});
        testMove(new int[]{1,0});
        testMove(new int[]{1,0,1,1,1,1,1,1,1,1,1});
        testMove(new int[]{1,0,1,1,1,1,1,1,1,0,1});
    }
    private static void testMove(int[] nums){
        move01(nums);
        System.out.println(Arrays.toString(nums));
    }
}
