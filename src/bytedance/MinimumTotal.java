package bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author maple on 2019/2/21 12:06.
 * @version v1.0
 * @see 1040441325@qq.com
 * <p>
 * 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() <= 0) return 0;
        int len = triangle.size();
        int[][] res = new int[len][len];
        res[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    res[i][j] = res[i - 1][j] + list.get(j);
                } else if (j == i) {
                    res[i][j] = res[i - 1][j - 1] + list.get(j);
                } else {
                    res[i][j] = Math.min(res[i - 1][j - 1], res[i - 1][j]) + list.get(j);
                }
            }
        }
        int min = res[len - 1][0];
        for (int i = 1; i < res.length; i++) {
            if (res[len - 1][i] < min) min = res[len - 1][i];
        }
        return min;
    }

    /**
     * 递归
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int h = triangle.size();
        int[][] memo = new int[h][h];
        if (h == 1) {
            return triangle.get(0).get(0);
        }
        return getMin(1, 0, memo, triangle);
    }

    private int getMin(int n, int i, int[][] memo, List<List<Integer>> tr) {
        if (n == tr.size()) {
            memo[n - 1][i] = tr.get(n - 1).get(i);
            return memo[n - 1][i];
        }
        if (memo[n][i] != 0 && memo[n][i + 1] != 0) {
            memo[n - 1][i] = Math.min(memo[n][i], memo[n][i + 1]) + tr.get(n - 1).get(i);
        }
        if (memo[n][i] != 0 && memo[n][i + 1] == 0) {
            memo[n - 1][i] = Math.min(memo[n][i], getMin(n + 1, i + 1, memo, tr)) + tr.get(n - 1).get(i);
        }
        if (memo[n][i] == 0 && memo[n][i + 1] != 0) {
            memo[n - 1][i] = Math.min(getMin(n + 1, i, memo, tr), memo[n][i + 1]) + tr.get(n - 1).get(i);
        }
        if (memo[n][i] == 0 && memo[n][i + 1] == 0) {
            memo[n - 1][i] = Math.min(getMin(n + 1, i, memo, tr), getMin(n + 1, i + 1, memo, tr)) + tr.get(n - 1).get(i);
        }
        return memo[n - 1][i];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(2);
        triangle.add(a);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        triangle.add(b);
        List<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(5);
        c.add(7);
        triangle.add(c);
        List<Integer> d = new ArrayList<>();
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);
        triangle.add(d);
        System.out.println(new MinimumTotal().minimumTotal(triangle));
    }
}
