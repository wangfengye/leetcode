import java.util.Arrays;

/**
 *
 */
public class SumWithThreeNumber {
    public static int threeSumCloset(int[] nums,int target){
        int res = Integer.MIN_VALUE;
        int cha = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int start =i+1;
            int end = nums.length-1;
            while (start<end){
                int sum =nums[i]+nums[start]+nums[end];
                if (sum-target>0){
                    if (sum-target<cha){
                        cha  =sum-target;
                        res =sum;
                    }
                    end--;
                }else if(sum-target<0) {
                    if (target-sum<cha){
                        cha  =target-sum;
                        res =sum;
                    }
                    start++;
                }else {
                    return target;
                }
            }
        }
        return res;
    }
    public static void  main(String[] args){
       System.out.println( threeSumCloset(new int[]{-1,2,1,-4},1));
    }
}
