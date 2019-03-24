package competition.week129;

/**
 * @author maple on 2019/3/24 14:14.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1021. 最佳观光组合  显示英文描述
 * 用户通过次数 91
 * 用户尝试次数 246
 * 通过次数 92
 * 提交次数 619
 * 题目难度 Medium
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 */
public class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int maxScore = 0;
        int lastIndex = 0;
        while (lastIndex < A.length-1) {
            int index = getMaxJ(lastIndex, A);
            int i = getMaxI(lastIndex, index, A);

            int tmp = A[index] + A[i] - (index - i);
            if (tmp > maxScore) maxScore = tmp;
            lastIndex = index;
        }

        return maxScore;
    }
    //相同大小取前面一个
    private int getMaxI(int i, int j, int[] A) {
        int maxI = Integer.MIN_VALUE;
        for (int k = i; k < j; k++) {
            int tmp = A[k] + k;
            if (tmp > maxI) {
                maxI = tmp;
                i = k;
            }
        }
        return i;
    }
    //相同大小,取最后一个
    private int getMaxJ(int j, int[] A) {
        int maxJ = Integer.MIN_VALUE;
        for (int k = j + 1; k < A.length; k++) {
            int tmp = A[k] - k;
            if (tmp >= maxJ) {
                maxJ = tmp;
                j = k;
            }
        }
        return j;
    }
    public static void  main(String[] args){
        //System.out.println(new MaxScoreSightseeingPair().maxScoreSightseeingPair(new int[]{1,2,2}));
        System.out.println(new MaxScoreSightseeingPair().maxScoreSightseeingPair(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }
}
