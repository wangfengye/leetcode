package teambition;

/**
 * @author maple on 2019/2/28 12:05.
 * @version v1.0
 * @see 1040441325@qq.com
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0)return false;
        int i =0;
        int j = matrix[0].length-1;

        while (i<matrix.length&&j>=0){
            if (matrix[i][j]==target)return true;
            if (matrix[i][j]>target)j--;
            else if (matrix[i][j]<target)i++;
        }
        return false;
    }
}
