/**
 * 螺旋矩阵
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵
 */
public class GenerateMatrix {
    /**
     * 时间复杂度O(n^2)
     *
     * @param n 矩阵长度
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 1;
        int xMax = n - 1;//极限值
        int yMax = n - 1;//极限值
        int x = 0;
        int y = 0;
        int xStep = 1;//步长
        int yStep = 0;
        while (i <= n * n) {
            matrix[y][x] = i;
            i++;
            x += xStep;
            y += yStep;
            if (x == xMax) {
                // x轴走完拐弯,计算下次x轴遍历重点
                if (xStep == 1) xMax = n - 1 - xMax;
                else xMax = n - 1 - xMax - 1;
                //拐弯后y轴步长
                yStep = xStep;
                xStep = 0;
            }
            if (y == yMax) {
                if (yStep == 1) yMax = n - 1 - (yMax - 1);
                else yMax = n - 1 - yMax;
                xStep = -yStep;
                yStep = 0;

            }
        }
        return matrix;
    }

    /**
     * @param n
     * @return
     */
    public int[][] generateMatrix1(int n){
        int[][] a = new int[n][n];
        int m=1;
        int i,j;
        // 向右
        for(i =0;i<n/2;i++){
            for(j=0;j<n-i;j++){
                if(a[i][j] ==0)
                    a[i][j] = m++;
            }
            //向下
            for(j=i+1;j<n-i;j++){
                if(a[j][n-1-i] ==0)
                    a[j][n-1-i] = m++;
            }
            //向左
            for(j=n-i-1;j>i;j--){
                if(a[n-i-1][j] ==0)
                    a[n-i-1][j] = m++;
            }
            //向上
            for(j=n-i-1;j>i;j--){
                if(a[j][i] ==0)
                    a[j][i] = m++;
            }
        }
        if(n%2==1)
            a[n/2][n/2]=m;

        return a;
    }
    public static void main(String[] args) {
        new GenerateMatrix().generateMatrix(3);
    }
}
