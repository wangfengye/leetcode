package Array;

/**
 * @author maple on 2019/7/5 9:53.
 * @version v1.0
 * @see 1040441325@qq.com
 * 980. 不同路径 III
 * 在二维网格 grid 上，有 4 种类型的方格：
 * <p>
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * 输出：2
 * 解释：我们有以下两条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * 示例 2：
 * <p>
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * 输出：4
 * 解释：我们有以下四条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * 示例 3：
 * <p>
 * 输入：[[0,1],[2,0]]
 * 输出：0
 * 解释：
 * 没有一条路能完全穿过每一个空的方格一次。
 * 请注意，起始和结束方格可以位于网格中的任意位置。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length * grid[0].length <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePathsIII {
    int[][] mat;
    final int startFlag = 1;
    final int endFlag = 2;
    final int wayFlag = 0;
    final int stopFlag = -1;
    int waynum = 1;
    int runnum = 0;

    public int uniquePathsIII(int[][] grid) {
        mat = new int[grid.length+2][grid[0].length+2];
        int start_i = 0;
        int start_j = 0;
        int end_i = 0;
        int end_j =0;
        for(int i=0;i<mat.length;i++){//生成 外围填充-1 的数组
            for(int j=0;j<mat[0].length;j++){
                if(i==0 || j==0 || i==mat.length-1 || j==mat[0].length-1){
                    mat[i][j] = stopFlag;
                    continue;
                }

                mat[i][j] = grid[i-1][j-1];
                if(wayFlag == mat[i][j]){
                    waynum++;
                }else if(startFlag == mat[i][j]){
                    start_i = i;
                    start_j = j;
                }else if(endFlag == mat[i][j]){
                    end_i = i;
                    end_j = j;
                }
            }
        }
        return check(start_i, start_j);
    }

    public int check(int i,int j){
        if(runnum != 0){
            if(startFlag == mat[i][j] || stopFlag==mat[i][j]){
                return 0;
            }else if(endFlag == mat[i][j] && runnum!=waynum){
                return 0;
            }else if(endFlag == mat[i][j] && runnum==waynum){
                return 1;
            }
        }


        mat[i][j] = stopFlag;
        runnum++;
        int count = check(i-1,j) + check(i+1,j) + check(i,j-1) + check(i,j+1);
        runnum--;
        mat[i][j] = wayFlag;
        return count;
    }

    public static void main(String[] args) {
       System.out.println(new UniquePathsIII().uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
    }
}
