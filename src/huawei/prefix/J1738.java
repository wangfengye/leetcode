package huawei.prefix;

import java.util.PriorityQueue;

/**
 * 解题方案: 推导前缀和方案,看了解答,都是基于此实现
 * 找第k个值: 最优方案用int[1000]存结果集,下标表示异或结果,没搞懂怎么知道异或结果<1000的 >优先级队列 > java.sort
 */
public class J1738 {
    public static void main(String[] args){
        System.out.println(kthLargestValue(new int[][]{{10,9,5},{2,0,4},{1,0,9},{3,4,8}},10));//1
        System.out.println(kthLargestValue(new int[][]{{5,2},{1,6}},1));
        System.out.println(kthLargestValue(new int[][]{{5,2},{1,6}},3));
        System.out.println(kthLargestValue(new int[][]{{5,2},{1,6}},4));
    }
    public static int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> data =new PriorityQueue<>(k);
        int[][] preSum = new int[matrix.length][matrix[0].length];
        preSum[0][0]=matrix[0][0];
        offer(data,preSum[0][0],k);
        for (int i = 1; i < matrix[0].length; i++) {
            preSum[0][i]=preSum[0][i-1]^matrix[0][i];
            offer(data,preSum[0][i],k);
        }
        for (int i = 1; i < matrix.length; i++) {
            preSum[i][0]=preSum[i-1][0]^matrix[i][0];
            offer(data,preSum[i][0],k);
            for (int j = 1; j < matrix[i].length; j++) {
                // 前缀和获取方式, 二维数组中 左侧前缀和和上方前缀和重叠部分再参与一次异或
                preSum[i][j]=preSum[i-1][j]^preSum[i][j-1]^preSum[i-1][j-1]^matrix[i][j];
                offer(data,preSum[i][j],k);
            }
        }
        return data.peek();
    }
    private static void offer(PriorityQueue<Integer> queue,int x,int k){
        if(queue.size()<k){
            queue.offer(x);
        }else {
            if(queue.peek()<x){
                queue.poll();
                queue.offer(x);
            }
        }
    }
}
