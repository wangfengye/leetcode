package bytedance;

import findtable.MaxPoints;

/**
 * @author maple on 2019/2/18 15:52.
 * @version v1.0
 * @see 1040441325@qq.com
 * 岛屿的最大面积
 * 定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int area = getArea(i, j, grid);
                maxArea = maxArea > area ? maxArea : area;
            }
        }
        return maxArea;
    }

    private int getArea(int x, int y, int[][] grid) {
        int area = 0;
        if (grid[x][y] == 1) {
            area += 1;
            grid[x][y] = 0;
            if (x + 1 < grid.length) {
                area += getArea(x + 1, y, grid);
            }
            if (y + 1 < grid[0].length) {
                area += getArea(x, y + 1, grid);
            }
            if (x - 1 >= 0) {
                area += getArea(x - 1, y, grid);
            }
            if (y - 1 >= 0) {
                area += getArea(x, y - 1, grid);
            }
        }
        return area;

    }

    private int depthSearch(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            int num = 1 + depthSearch(grid, i + 1, j)
                    + depthSearch(grid, i - 1, j)
                    + depthSearch(grid, i, j + 1)
                    + depthSearch(grid, i, j - 1);
            return num;
        }
        return 0;
    }
    public static void main(String[] args) {
        new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}});
        int[] a = new int[]{1,2,3,4};
        System.out.println(a[0]);
        get(a);
        System.out.println(a[0]);

    }
    private static void get(int[] as){
        as[0]=12;
    }
}

