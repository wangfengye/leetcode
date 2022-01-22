package huawei.prefix;

import java.util.Arrays;

/**
 * 题目特征: 连续组合
 * 该题目的体现:区间
 */
public class J1893 {
    public static void main(String[] args){
        System.out.println(isCovered(new int[][]{{1,2},{3,4},{5,6}},2,5));
    }
    // 前缀和法
    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int[] range :
                ranges) {
            diff[range[0]]++;//区间起点+1,是的起点开始的前缀和>0
            diff[range[1]+1]--;// 区间终点后一位-1,保证超出区间后的前缀后=0;
        }
        //前缀和, 前缀和>0表示当前位置在区间内
        int[] preSum = new int[52];
        //只计算到需要的right,后面的前缀和,不在计算
        for (int i = 1; i <= right; i++) {
            preSum[i]=preSum[i-1]+diff[i];
        }
        for (int i = left; i <=right ; i++) {
            if(preSum[i]<=0){
                return false;
            }
        }
        return true;
    }
    // 区间+-法
    public boolean isCovered2(int[][] ranges, int left, int right) {
        Arrays.sort(ranges,(v1, v2)->(v1[0]-v2[0]));
        for(int[] r:ranges){
            if(r[1]<left)continue;
            if(r[0]<=left){
                if(r[1]>=right)return true;
                else left=r[1]+1;
            }
        }
        return false;
    }
}
