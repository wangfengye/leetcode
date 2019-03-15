package interview;

/**
 * @author maple on 2019/3/15 9:41.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class KthSmallest {
    /**
     *
     * @param matrix
     * @param g
     * @param n
     * @param k
     * @return 比g元素不足k个
     */
    public static boolean guess(int[][] matrix, int g, int n, int k){
        int sum = 0;
        for(int i = 0; i < n; i++){
            int L = 0;
            int R = n - 1;
            int ans = 0;
            while (L <= R){
                int mid = L + (R - L)/2;
                //若某一行值小于g，则应该是最后一个元素的下标 + 1.
                if(matrix[i][mid] < g){
                    ans = mid + 1;
                    L = mid + 1;
                }else {
                    R = mid - 1;
                }
            }
            sum += ans;
        }
        return k > sum;
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int L = matrix[0][0];
        int R = matrix[n - 1][n - 1];
        int ans = 0;
        while (L <= R){
            int mid = L + (R - L )/2;
            if(guess(matrix, mid, n, k)){
                ans = mid;
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        return  ans;
    }
public static void main(String[] args){
        kthSmallest(new int[][]{{1,5,9},{10,11,11},{11,14,15}},8);
}
}
