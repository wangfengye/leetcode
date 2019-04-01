package competition.week130;

/**
 * @author maple on 2019/4/1 9:49.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1031. 飞地的数量  显示英文描述
 * 用户通过次数 136
 * 用户尝试次数 177
 * 通过次数 138
 * 提交次数 317
 * 题目难度 Medium
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 * <p>
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 * <p>
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量
 */
public class NumEnclaves {
    public static int numEnclaves(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                tmp=0;
                if (!canOut(A, i, j)){
                    res+=tmp;
                }
            }
        }
        return res;
    }
    static int tmp;
    private static boolean canOut(int[][] A, int x, int y) {//找寻该点相连陆地(遍历过的陆地置0),判断是否有点到达边界,没有将所有点记为不可达边界点
        if (A[x][y] == 0) return false;
        if (x == 0 || x == A.length - 1 || y == 0 || y == A[x].length - 1) return true;
        A[x][y]=0;tmp++;
        return canOut(A, x - 1, y) |canOut(A, x + 1, y) | canOut(A, x, y - 1) |canOut(A, x, y + 1);

    }

    public static void main(String[] args) {
        System.out.println(numEnclaves(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}));
    }
}
