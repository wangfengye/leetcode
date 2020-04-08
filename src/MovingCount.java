/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 */
public class MovingCount {
    public static int movingCount(int m, int n, int k) {
        res=0;
        tmp=new int[m][n];
        bfs(0,0,k);
        return res;
    }
    private static int res;
    private static int[][] tmp;
    public static void bfs(int i,int j,int k){
        //已遍历过的点.
        if(i<0||i>=tmp.length||j<0||j>=tmp[i].length||tmp[i][j]==1)return;
        //不符合条件
        if(!check(i,j,k))return;
        res++;
        tmp[i][j]=1;
        bfs(i-1,j,k);
        bfs(i+1,j,k);
        bfs(i,j-1,k);
        bfs(i,j+1,k);

    }
    private static boolean check(int i,int j,int k){
        int tmp=0;
        while (i>0){
            tmp+=i%10;
            i/=10;
        }
        while (j>0){
            tmp+=j%10;
            j/=10;
        }
        return tmp<=k;
    }
    public static void main(String[] args){
        System.out.println(movingCount(2,3,1));
        System.out.println(movingCount(3,1,0));
        System.out.println(movingCount(16,8,4));
    }
}
