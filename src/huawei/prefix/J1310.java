package huawei.prefix;

import java.util.Arrays;

public class J1310 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(xorQueries(new int[]{1,3,4,8},new int[][]{{0,1},{1,2},{0,3},{3,3}})));
    }
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] preSum = new int[arr.length+1];
        // 前缀累积异或
        for (int i = 0; i < arr.length; i++) {
            preSum[i+1]=preSum[i]^arr[i];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] tmp = queries[i];
            // 异或特性  a^b^a==a
            // 起点-终点的累计异或 = 0-终点的累计异或 ^ 0-起点前一位的累计异或
            res[i]=preSum[tmp[1]+1]^preSum[tmp[0]];
        }
        return res;
    }
}
