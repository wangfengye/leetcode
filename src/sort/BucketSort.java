package sort;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author maple on 2019/4/16 17:04.
 * @version v1.0
 * @see 1040441325@qq.com
 * 桶排序
 *
 */
public class BucketSort {
    public static void sort(int[] nums){
        if (nums.length<=1)return;
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<min) min=nums[i];
            if (nums[i]>max) max=nums[i];
        }
        int bucketSize = (max-min)/10+1;
        int[][] tmp = new int[bucketSize][nums.length+1];//第一位表示数组使用长度
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i]-min)/10;
            int usedLen = tmp[index][0];
            usedLen++;
            tmp[index][0]=usedLen;
            tmp[index][usedLen] =nums[i];
        }
        for (int i = 0; i < bucketSize; i++) {
            QuickSort.sort(tmp[i],1,tmp[i][0]);
        }
        int index =0;
        int[] t = tmp[index];
        int used =0;
        for (int i = 0; i < nums.length; i++) {
            while (t[0]<=used){
                used =0;
                index++;
                t = tmp[index];
            }
            used++;
            nums[i] =t[used];
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{50, 2, 12, 5, 38, 2, 3, 4, 44, 15, 19, 48, 27, 47};
        //sort(nums);
        //System.out.println(Arrays.toString(nums));
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.sin(Math.PI/10*i));
        }
    }


}
