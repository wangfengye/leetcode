package bytedance;

/**
 * @author maple on 2019/2/19 9:52.
 * @version v1.0
 * @see 1040441325@qq.com
 * 朋友圈
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数
 */
public class FindCircleNum {
    public int findCircleNum(int[][] M) {
        boolean visited[] = new boolean[M.length];
        int circleNum = 0;
        int index = 0;
        while ((index = getFirstFalse(visited)) != -1) {
            circleNum++;
            setFriends(M, index, visited);
        }
        return circleNum;
    }

    private int getFirstFalse(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return i;
        }
        return -1;
    }

    private void setFriends(int[][] M, int row, boolean[] visited) {
        visited[row] = true;
        for (int i = 0; i < M.length; i++) {
            if (M[row][i] == 1 && !visited[i]) {
                visited[i] = true;
                setFriends(M, i, visited);
            }
        }
    }
}
