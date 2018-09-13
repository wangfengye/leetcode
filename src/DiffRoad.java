/**
 * 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 */
public class DiffRoad {


    /**
     * 排列组合, 求较短方向的步子在整条路径的去重排列组合
     * C(   Min(m,n)-1 ,  m+n-2 )
     */
    public static int uniquePaths(int m, int n) {
        int len = m+n-2;
        int less = m>n?n-1:m-1;
        long funs = 1;
        for (int i = 0; i < less; i++) {
            funs*=len-i;
        }
        for (int i = 2; i <= less; i++){
            funs/= i;
        }
      return (int) funs;
    }
    public static void main(String[] args){
        System.out.println(uniquePaths(3,2));
        System.out.println(uniquePaths(7,3));
        System.out.println(uniquePaths(10,10));
    }
}
