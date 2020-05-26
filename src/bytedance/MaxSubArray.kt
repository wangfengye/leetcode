package bytedance

/**
 * 最大连续子串
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
class MaxSubArray {
    public fun maxSubArray(nums: Array<Int>): Int {

        val dp = Array<Int>(nums.size) { 0 };
        dp[0]=nums[0]
        for (i in 1 until nums.size) {
            dp[i] = if (dp[i - 1] > 0) dp[i - 1] + nums[i] else nums[i]
        }
        var max= Int.MIN_VALUE;
        for(dpi in dp){
            if(dpi>max)max=dpi;
        }
        return max;
    }
    companion object{
        @JvmStatic
        public fun main(args:Array<String>){
            println(MaxSubArray().maxSubArray(arrayOf(-2,1,-3,4,-1,2,1,-5,4)))
        }
    }
}