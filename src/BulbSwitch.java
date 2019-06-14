/**
 * @author maple on 2019/6/14 9:09.
 * @version v1.0
 * @see 1040441325@qq.com
 * 319. 灯泡开关
 * 初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 1
 * 解释:
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 * <p>
 * 你应该返回 1，因为只有一个灯泡还亮着。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulb-switcher
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BulbSwitch {
    public int bulbSwitch(int n) {
        boolean ds[] = new boolean[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j < n; j += i) {
                ds[j] = !ds[j];
            }
        }
        int count = 0;
        for (boolean d :
                ds) {
            if (d) count++;
        }
        return count;
    }

    public int bulbSwitch2(int n) {
        int i;
        for (i = 1; i <= n; i++) {
            if (i * i > n) break;
        }
        return i - 1;
        // return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print(i + "----" + new BulbSwitch().bulbSwitch(i) + ", ");
        }
        System.out.println("\nplan2");
        for (int i = 0; i < 100; i++) {
            System.out.print(i + "----" + new BulbSwitch().bulbSwitch2(i) + ", ");
        }
    }
}
