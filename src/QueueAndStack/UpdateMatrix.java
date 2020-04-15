package QueueAndStack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

/**
 * 01 矩阵
 * <p>
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1
 */
public class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) res[i][j] = 0;
                else res[i][j] = getMinDis(matrix, i, j, row, col);
            }
        }
        return res;
    }

    private int getMinDis(int[][] matrix, int i, int j, int row, int col) {
        LinkedList<Pos> queue = new LinkedList<>();
        Set<Pos> poses = new HashSet<>();
        Pos pos = new Pos(i, j, 0);
        queue.offer(pos);
        poses.add(pos);

        while (queue.size() > 0) {
            Pos p = queue.pop();
            if (matrix[p.x][p.y] == 0) return p.deep;
            Pos p1 = new Pos(p.x - 1, p.y, p.deep + 1);
            if (p1.x >= 0 && !poses.contains(p1)) {
                queue.offer(p1);
                poses.add(p1);
            }
            Pos p2 = new Pos(p.x + 1, p.y, p.deep + 1);
            if (p2.x < row && !poses.contains(p2)) {
                queue.offer(p2);
                poses.add(p2);
            }
            Pos p3 = new Pos(p.x, p.y - 1, p.deep + 1);
            if (p3.y >= 0 && !poses.contains(p3)) {
                queue.offer(p3);
                poses.add(p3);
            }
            Pos p4 = new Pos(p.x, p.y + 1, p.deep + 1);
            if (p4.y < col && !poses.contains(p4)) {
                queue.push(p4);
                poses.add(p4);
            }
        }
        return -1;
    }

    class Pos {
        int x;
        int y;
        int deep;

        public Pos(int x, int y, int deep) {
            this.x = x;
            this.y = y;
            this.deep = deep;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x &&
                    y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();

        //new UpdateMatrix().updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
    }

    /**
     * 层层遍历,
     * 1. 将四周为 1的+1;
     * 2. 将四周为2的再+1;
     * @param matrix
     * @return
     */
    public static  int[][] updateMatrix1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean isChange = true;
        int k =1;
        while (isChange) {
            isChange = false;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] >= k
                            && (i == 0 || matrix[i - 1][j] >= k)
                            && (j == 0 || matrix[i][j - 1] >= k)
                            && (i == row - 1 || matrix[i + 1][j] >= k)
                            && (j == col - 1 || matrix[i][j + 1] >= k)) {
                        //本身为1,四周也为1的情况
                        // 自身+1,改变isChange状态,需要进行下一轮遍历
                        matrix[i][j]++;
                        isChange = true;
                    }
                }
            }
            k++;
        }
        return matrix;
    }

}
