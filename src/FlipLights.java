/**
 * @author maple on 2019/6/14 9:25.
 * @version v1.0
 * @see 1040441325@qq.com
 * 672. 灯泡开关 Ⅱ
 * 假设这 n 只灯泡被编号为 [1, 2, 3 ..., n]，这 4 个按钮的功能如下：
 * <p>
 * 将所有灯泡的状态反转（即开变为关，关变为开）
 * 将编号为偶数的灯泡的状态反转
 * 将编号为奇数的灯泡的状态反转
 * 将编号为 3k+1 的灯泡的状态反转（k = 0, 1, 2, ...)
 * 示例 1:
 * <p>
 * 输入: n = 1, m = 1.
 * 输出: 2
 * 说明: 状态为: [开], [关]
 * 示例 2:
 * <p>
 * 输入: n = 2, m = 1.
 * 输出: 3
 * 说明: 状态为: [开, 关], [关, 开], [关, 关]
 * 示例 3:
 * <p>
 * 输入: n = 3, m = 1.
 * 输出: 4
 * 说明: 状态为: [关, 开, 关], [开, 关, 开], [关, 关, 关], [关, 开, 开].
 * 注意： n 和 m 都属于 [0, 1000].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulb-switcher-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FlipLights {
    public int flipLights(int n, int m) {
        // 重复操作被抵消,及m最大是4;
        //不同操作数对应的变化情况, 1个重复操作+0个重复操作,
        //m==0  1;
        //m==1  4;
        //m==2  1+6
        //m==3  4+4
        // 考虑 n<3时, 操作4和其他操作的冲突
        // n==1时,所有操作相同,会出现 开,关两种情况
        //n==2时, 操作4 =操作2  m==1 -> res=3 m==2 -> res =4
        if (m == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return (m > 1 ? 1 : 0) + (m > 0 ? 1 : 0) * 2 + 1;
        if (m == 1) return 4;
        if (m == 2) return 7;
        return 8;
    }
}
