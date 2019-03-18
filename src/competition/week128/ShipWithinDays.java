package competition.week128;

/**
 * @author maple on 2019/3/18 10:47.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1014. 在 D 天内送达包裹的能力  显示英文描述
 * 用户通过次数 197
 * 用户尝试次数 272
 * 通过次数 203
 * 提交次数 538
 * 题目难度 Medium
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * [1,2,3,4,5,6,7,8,9,10]
 * 5
 */
public class ShipWithinDays {
    public static int shipWithinDays(int[] weights, int D) {
        int l = 0;// weights中最大值
        int r = 0;// weights 和;
        int mid = 0;
        int n = weights.length;
        for (int i = 0; i < n; i++) {
            l = Math.max(l, weights[i]);
            r += weights[i];
        }
        l--;//防止出现  l =14 r=15 mid =21; 一直死循环
        while (l + 1 < r) {//一直取两者中间数,看符不符合D天
            mid = l + r >> 1;
            int j = 0;
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (j + weights[i] > mid) {
                    j = 0;
                    k++;

                }
                j += weights[i];

            }
            j = 0;
            k++;
            if (k <= D) r = mid;
            else l = mid;
        }
        return r;
    }
    public static void main(String[] args){
        shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5);
    }
}
