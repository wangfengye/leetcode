package interview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author maple on 2019/3/11 9:29.
 * @version v1.0
 * @see 1040441325@qq.com
 * 课程表
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * <p>
 * 示例 1:
 */
public class CanFinish {
    boolean[] visited;
    boolean[] loopVisited;
    ArrayList<Integer>[] od;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        loopVisited = new boolean[numCourses];
        od = new ArrayList[numCourses];// 领接表
        for (int i = 0; i < prerequisites.length; i++) {
            if (od[prerequisites[i][1]] == null) od[prerequisites[i][1]] = new ArrayList<>();
            od[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i)) return false;
        }
        return true;
    }

    //环路检测
    private boolean dfs(int v) {
        visited[v] = true;//标记访问过的节点
        if (od[v] != null) {
            for (Integer i : od[v]) {
                if (!loopVisited[i] && visited[i]) return true;
                if (!visited[i]) {
                    boolean loopCheck = dfs(i);
                    if (loopCheck) return true;
                }
            }
        }
        loopVisited[v] = true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanFinish().canFinish(2, new int[][]{{1, 0}}));
    }
}
