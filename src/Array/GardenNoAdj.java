package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 1042. 不邻接植花
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 * <p>
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 * <p>
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 * <p>
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * <p>
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 示例 2：
 * <p>
 * 输入：N = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 * <p>
 * 输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 */
public class GardenNoAdj {
    public int[] gardenNoAdj(int N, int[][] paths) {
        boolean[][] linjie = new boolean[N][N];
        for (int i = 0; i < paths.length; i++) {
            linjie[paths[i][0] - 1][paths[i][1] - 1] = true;
            linjie[paths[i][1] - 1][paths[i][0] - 1] = true;
        }
        int[] res = new int[N];
        boolean[] used=new boolean[5];
        for (int i = 0; i < N; i++) {
            Arrays.fill(used,false);
            for (int j = 0; j < i; j++) {
                //邻接关系,将邻接填入的数据标记为已用
                if(linjie[i][j])used[res[j]]=true;
            }
            for(int j=1;j<5;j++){
                if(!used[j]){
                    res[i]=j;
                    break;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
     //   new GardenNoAdj().gardenNoAdj(5, new int[][]{{4, 1}, {4, 2}, {4, 3}, {2, 5}, {1, 2}, {1, 5}});
        new GardenNoAdj().gardenNoAdj(8, new int[][]{
                {7,4},{3,7},{1,5},{5,4},{7,1},{3,1},{4,3},{6,5}});
    }
}
