package QueueAndStack;

/**
 * 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面
 */
public class FindTargetSumWays {
    int res;
    int zero;

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        zero = 1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) zero = zero << 1;
            sum += nums[j];
        }
        if (sum < S || (sum + S) % 2 == 1) return 0;
        res = 0;

        add(nums, S, 0);
        return res * zero;
    }

    private void add(int[] nums, int s, int i) {

        while (i < nums.length && nums[i] == 0) {
            i = i + 1;
        }
        if (i >= nums.length) {
            if (s == 0) res++;
            return;
        }
        add(nums, s + nums[i], i + 1);
        add(nums, s - nums[i], i + 1);
    }

    /**
     * 方案2
     * 转化为动态规划
     *  原问题:分为集合A,B, A作为正数,B为负数
     *  Sum(A)-Sum(B) = S
     *  Sum(A)-Sum(B)+Sum(A)+Sum(B) = S+Sum(A)+Sum(B)
     *  2Sum(A) = S+Sum(A)+Sum(B) (S和数组和必为偶数)
     *  Sum(A) = (S+Sum(A)+Sum(B))/2 = target
     *  问题转化成了动态规划,即求有数组多少种方式组合成 target;
     * 转化诶nums 子集中求sum(p)的方案个数
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum < S || (sum + S) % 2 == 1) return 0;
        int target = (S+sum)/2;
        int[] counter = new int[target+ 1];
        counter[0] =1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                counter[j] += counter[j - nums[i]];
            }
        }
        return counter[target];
    }
    public static void main (String[] args){
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1,1,1,1,1},3));
        System.out.println(new FindTargetSumWays().findTargetSumWays2(new int[]{1,1,1,1,1},3));
    }
}

