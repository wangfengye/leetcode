package Array;

import java.util.Arrays;

/**
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        int cowLen = matrix.length;
        if (cowLen == 0) return new int[0];
        int rowLen = matrix[0].length;
        int[] res = new int[cowLen * rowLen];
        int l=0,r=rowLen-1,t=0,b=cowLen-1;
        int x=0;
        int y=0;
        int xS=1;
        int yS=0;
        for (int i = 0; i < res.length; i++) {
            res[i] =matrix[y][x];

            if(xS==1&&x==r){
                xS=0;
                yS=1;
                t++;
            }else if(xS==-1&&x==l){
                xS=0;
                yS=-1;
                b--;
            }else if(yS==1&&y==b){
                xS=-1;
                yS=0;
                r--;
            }else if(yS==-1&&y==t){
                xS=1;
                yS=0;
                l++;
            }
            x+=xS;
            y+=yS;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.print(Arrays.toString(SpiralOrder.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
    }
}
