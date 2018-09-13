/**
 * 除自身以外数组的乘积
 *
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
 */
public class ProductExceptSelf {
    /**
     * 时间复杂度 O(n)
     * 空间复杂度O(n)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] before = new int[nums.length];//记录i之前数的乘积
        int[] after = new int[nums.length];//记录i之后数的乘积
        int[] res = new int[nums.length];
        before[0] =1;
        for (int i = 1; i < nums.length; i++) {
            before[i]=nums[i-1]*before[i-1];
        }
        after[nums.length-1]=1;
        for (int i = nums.length-2; i >=0 ; i--) {
            after[i]= nums[i+1]*after[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = before[i]*after[i];
        }
        return res;
    }

    /**
     * 优化,降低了空间复杂度
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {

        int[] res = new int[nums.length];
        res[0] =1;
        for (int i = 1; i < nums.length; i++) {
            res[i]=nums[i-1]*res[i-1];//记录之前数的乘积
        }
        int afterSum=1;
        for (int i = nums.length-2; i >=0 ; i--) {
            afterSum*=nums[i+1];
            res[i]= afterSum*res[i];
        }
        return res;
    }
}
