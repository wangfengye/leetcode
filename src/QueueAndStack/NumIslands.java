package QueueAndStack;

public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid.length==0||grid[0].length==0)return 0;
        int landCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]=='1'){
                    def(grid,i,j);
                    landCount++;
                }
            }
        }
        return landCount;
    }

    /**
     * ↑↓←→四个方向搜索,直至没有相连的1,同时将当前位置置0
     * @param grid
     * @param row
     * @param col
     */
    private void def(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') return;
        grid[row][col] ='0';
        def(grid,row-1,col);
        def(grid,row+1,col);
        def(grid,row,col-1);
        def(grid,row,col+1);
    }
}
