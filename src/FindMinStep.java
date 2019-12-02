import java.util.HashMap;

/**
 * @author maple on 2019/12/2 9:26.
 * @version v1.0
 * @see 1040441325@qq.com
 * 488. 祖玛游戏
 * 回忆一下祖玛游戏。现在桌上有一串球，颜色有红色(R)，黄色(Y)，蓝色(B)，绿色(G)，还有白色(W)。 现在你手里也有几个球。
 * <p>
 * 每一次，你可以从手里的球选一个，然后把这个球插入到一串球中的某个位置上（包括最左端，最右端）。接着，如果有出现三个或者三个以上颜色相同的球相连的话，就把它们移除掉。重复这一步骤直到桌上所有的球都被移除。
 * <p>
 * 找到插入并可以移除掉桌上所有球所需的最少的球数。如果不能移除桌上所有的球，输出 -1 。
 * <p>
 * 示例:
 * 输入: "WRRBBW", "RB"
 * 输出: -1
 * 解释: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW （翻译者标注：手上球已经用完，桌上还剩两个球无法消除，返回-1）
 * <p>
 * 输入: "WWRRBBWW", "WRBRW"
 * 输出: 2
 * 解释: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
 * <p>
 * 输入:"G", "GGGGG"
 * 输出: 2
 * 解释: G -> G[G] -> GG[G] -> empty
 * <p>
 * 输入: "RBYYBBRRB", "YRBGB"
 * 输出: 3
 * 解释: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
 *
 */
public class FindMinStep {
    /**
     * 思路DFS,通过每个步骤检查是当前分支步骤是否超过已遍历的最短步骤来裁剪无用分支.
     * @param board
     * @param hand
     * @return
     */
    public static int findMinStep(String board, String hand) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : hand.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        minBall = Integer.MAX_VALUE;
        backtrace(board, map, 0, hand.length());
        return minBall == Integer.MAX_VALUE ? -1 : minBall;
    }

    private static int minBall;

    private static void backtrace(String board, HashMap<Character, Integer> map, int ball, int remain) {
        if (board == null || board.length() <= 0) {
            minBall = Math.min(minBall, ball);
            return;
        }
        if (ball >= minBall || remain == 0 || minBall == 0) return;
        StringBuilder s;
        int left = -1;
        for (int i = 0; i < board.length(); i++) {
            if (i == board.length() - 1 || board.charAt(i) != board.charAt(i + 1)) {
                int lack = 3 - (i - left);
                int handC = map.getOrDefault(board.charAt(i), 0);
                if (handC >= lack) {
                    map.put(board.charAt(i), handC - lack);
                    s = new StringBuilder(board);
                    for (int j = 0; j < lack; j++) {
                        s.insert(i+1, board.charAt(i));
                    }
                    boom(s, i);
                    backtrace(s.toString(), map, ball + lack, remain - lack);
                    map.put(board.charAt(i), map.getOrDefault(board.charAt(i), 0) + lack);
                }
                left = i;
            }
        }
    }

    private static StringBuilder boom(StringBuilder s, int i) {
        if (s.length() == 0) return s;
        int left = i;
        int right = i;
        while (left > 0 && s.charAt(left - 1) == s.charAt(left)) left--;
        while (right < s.length() - 1 && s.charAt(right + 1) == s.charAt(right)) right++;
        if (right - left + 1 >= 3) {
            s.delete(left, right+1);
            return boom(s, Math.max(left - 1, 0));
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(findMinStep("WRRBBW", "RB"));
        System.out.println(findMinStep("WWRRBBWW", "WRBRW"));
        System.out.println(findMinStep("G", "GGGGG"));
        System.out.println(findMinStep("RBYYBBRRB", "YRBGB"));
    }
}
