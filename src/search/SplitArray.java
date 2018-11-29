package search;

/**
 * @author maple on 2018/11/29 8:38.
 * @version v1.0
 * @see 1040441325@qq.com
 * 分割数组的最大值
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的
 * 最大值最小
 */
public class SplitArray {
    // 存在结果超出int最大值得问题
    public long splitArray(int[] nums, int m) {
        long sum = 0;
        long max = 0;
        for (int num : nums) {
            if (num>max)max =num;
            sum+=num;
        }
        if (m==1)return  sum;
        long left = max;
        long right = sum;
        long res = sum;
        while (left<right){
            long mid = left+(right-left)/2;
            int v = check(mid,nums,m-1);
            if (v==-1)left=mid+1;
            else {
                right =v;
                if (v<res){
                    res =v;
                }
            }
        }
        return res;
    }

    private int check(long mid, int[] nums,int m) {
        int sumMax =0;
        int sum=0;
        int i =0;
        int count =m;
        while (i<nums.length&&count>-1){
            sum+=nums[i];
            if (sum>mid){
                sum-=nums[i];
                if (sum>sumMax)sumMax=sum;
                sum=0;count--;}
            else i++;
        }
        if (count<0)return -1;
        if (sum>sumMax){
            sumMax =sum;
        }
        return sumMax;
    }
    public static void main(String[] args){
        new SplitArray().splitArray(new int[]{7,2,5,10,8},2);
    }
}
