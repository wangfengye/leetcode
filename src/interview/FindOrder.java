package interview;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author maple on 2019/3/11 13:52.
 * @version v1.0
 * @see 1040441325@qq.com
 * 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * <p>
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 */
public class FindOrder {
    boolean[] visited;
    boolean[] loopVisited;
    ArrayList<Integer>[] od;
    Stack<Integer> stack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        loopVisited = new boolean[numCourses];
        od = new ArrayList[numCourses];// 领接表
        stack = new Stack<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (od[prerequisites[i][1]] == null) od[prerequisites[i][1]] = new ArrayList<>();
            od[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] res = new int[numCourses];
        boolean hasLoop = false;
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i)) hasLoop = true;
            }
        }
        if (hasLoop) return new int[0];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;
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
        stack.push(v);
        return false;
    }
}
