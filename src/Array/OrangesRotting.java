package Array;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author maple on 2019/6/20 9:12.
 * @version v1.0
 * @see 1040441325@qq.com
 * 994. 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 * <p>
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 */
public class OrangesRotting {
    // 1,2方式 存在永不扩散点,会陷入死循环
    public static int orangesRotting1(int[][] grid) {
        int minute = 0;
        for (; ; ) {
            boolean hasNew = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j] == 1) {
                        hasNew = true;
                        if (i > 0 && grid[i - 1][j] >= 2 && grid[i - 1][j] < minute + 3
                                || i < grid.length - 1 && grid[i + 1][j] >= 2 && grid[i + 1][j] < minute + 3
                                || j > 0 && grid[i][j - 1] >= 2 && grid[i][j - 1] < minute + 3
                                || j < grid[i].length - 1 && grid[i][j + 1] >= 2 && grid[i][j + 1] < minute + 3) {
                            grid[i][j] = minute + 3;
                        }
                    }
                }
            }
            if (!hasNew) return minute;
            minute++;
        }
    }

    public static int orangesRotting2(int[][] grid) {
        int len = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) len++;
            }
        }
        int minute = 0;
        while (len > 0) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] >= 2 && grid[i][j] < minute + 3) {
                        if (i > 0 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = minute + 3;
                            len--;
                        }
                        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = minute + 3;
                            len--;
                        }
                        if (j > 0 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = minute + 3;
                            len--;
                        }
                        if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = minute + 3;
                            len--;
                        }
                    }
                }
            }
            minute++;
        }
        return minute;
    }

    public static int orangesRotting3(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        int minute = 0;
        int len = 0;
        while ((len = queue.size()) > 0) {
            for (int k = 0; k < len; k++) {
                int[] data = queue.poll();
                int i = data[0];
                int j = data[1];
                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    queue.offer(new int[]{i - 1, j});
                }
                if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = minute + 3;
                    queue.offer(new int[]{i + 1, j});
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = minute + 3;
                    queue.offer(new int[]{i, j - 1});
                }
                if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = minute + 3;
                    queue.offer(new int[]{i, j + 1});
                }
            }
            minute++;
        }
        for (int i = 0; i < grid.length; i++) {//存在永远扩散不到的点
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)return -1;
            }
        }
        if(minute>0)minute--;
        return minute;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting1(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(orangesRotting2(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(orangesRotting3(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(orangesRotting3(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
    }
}
