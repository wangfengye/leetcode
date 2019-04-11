package sort;

import java.util.Arrays;

/**
 * @author maple on 2019/4/11 11:41.
 * @version v1.0
 * @see 1040441325@qq.com
 * 归并排序
 */
public class MergeSort {

    private static void sort(int[] nums, int s, int e) {
        int mid = (e + s) / 2;
        if (s < e) {
            sort(nums, s, mid);
            sort(nums, mid + 1, e);
            merge(nums, s, mid, e);
        }
    }

    private static void merge(int[] nums, int s, int mid, int e) {
        int temp[] = new int[e - s + 1];
        int i = s;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= e) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++]=nums[j++];
            }
        }
        while (i<=mid)temp[k++]=nums[i++];
        while (j<=e)temp[k++]=nums[j++];
        for (int l = 0; l <temp.length; l++) {
            nums[l+s]=temp[l];
        }
    }
    public static void main(String[] args){
        int[] data = new int[]{3,5,2,15,26,21,19,58};
        sort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));
    }
}
