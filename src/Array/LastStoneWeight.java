package Array;

/**
 * @author maple on 2019/6/9 16:12.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1046. 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        int x = 0, y = 0;
        int xId = 0, yId = 0;
        while (true) {
            x = 0;
            y = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] > x) {
                    x=stones[i];
                    xId = i;
                }
            }
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] > y && i != xId) {
                    y = stones[i];
                    yId = i;
                }
            }
            if (y == 0) return x;
            stones[xId] = x - y;
            stones[yId] = 0;
        }
    }
}
