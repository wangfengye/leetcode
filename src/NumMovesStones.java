import java.util.Arrays;

/**
 * @author maple on 2019/6/14 8:57.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1033. 移动石子直到连续
 * 三枚石子放置在数轴上，位置分别为 a，b，c。
 * <p>
 * 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 * <p>
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * <p>
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 2, c = 5
 * 输出：[1, 2]
 * 解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
 * 示例 2：
 * <p>
 * 输入：a = 4, b = 3, c = 2
 * 输出：[0, 0]
 * 解释：我们无法进行任何移动。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= a <= 100
 * 1 <= b <= 100
 * 1 <= c <= 100
 * a != b, b != c, c != a
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/moving-stones-until-consecutive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumMovesStones {
    public int[] numMovesStones(int a, int b, int c) {
        int[] xs = {a,b,c};
        Arrays.sort(xs);
        a=xs[0];
        b=xs[1];
        c=xs[2];
        int max = c - a - 2;
        if (max<=0)return new int[]{0,0};
        int min = 2;
        if (b - a == 1 && c - b == 1) min = 0;
        else if (b - a <= 2 || c - b <= 2) min = 1;
        return new int[]{min, max};
    }
}
