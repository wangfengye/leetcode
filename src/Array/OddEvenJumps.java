package Array;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author maple on 2019/6/15 14:39.
 * @version v1.0
 * @see 1040441325@qq.com
 * 975. 奇偶跳
 * 给定一个整数数组 A，你可以从某一起始索引出发，跳跃一定次数。在你跳跃的过程中，第 1、3、5... 次跳跃称为奇数跳跃，而第 2、4、6... 次跳跃称为偶数跳跃。
 * <p>
 * 你可以按以下方式从索引 i 向后跳转到索引 j（其中 i < j）：
 * <p>
 * 在进行奇数跳跃时（如，第 1，3，5... 次跳跃），你将会跳到索引 j，使得 A[i] <= A[j]，A[j] 是可能的最小值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
 * 在进行偶数跳跃时（如，第 2，4，6... 次跳跃），你将会跳到索引 j，使得 A[i] >= A[j]，A[j] 是可能的最大值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
 * （对于某些索引 i，可能无法进行合乎要求的跳跃。）
 * 如果从某一索引开始跳跃一定次数（可能是 0 次或多次），就可以到达数组的末尾（索引 A.length - 1），那么该索引就会被认为是好的起始索引。
 * <p>
 * 返回好的起始索引的数量。
 * 示例 1：
 * <p>
 * 输入：[10,13,12,14,15]
 * 输出：2
 * 解释：
 * 从起始索引 i = 0 出发，我们可以跳到 i = 2，（因为 A[2] 是 A[1]，A[2]，A[3]，A[4] 中大于或等于 A[0] 的最小值），然后我们就无法继续跳下去了。
 * 从起始索引 i = 1 和 i = 2 出发，我们可以跳到 i = 3，然后我们就无法继续跳下去了。
 * 从起始索引 i = 3 出发，我们可以跳到 i = 4，到达数组末尾。
 * 从起始索引 i = 4 出发，我们已经到达数组末尾。
 * 总之，我们可以从 2 个不同的起始索引（i = 3, i = 4）出发，通过一定数量的跳跃到达数组末尾。
 * 示例 2：
 * <p>
 * 输入：[2,3,1,1,4]
 * 输出：3
 * 解释：
 * 从起始索引 i=0 出发，我们依次可以跳到 i = 1，i = 2，i = 3：
 * <p>
 * 在我们的第一次跳跃（奇数）中，我们先跳到 i = 1，因为 A[1] 是（A[1]，A[2]，A[3]，A[4]）中大于或等于 A[0] 的最小值。
 * <p>
 * 在我们的第二次跳跃（偶数）中，我们从 i = 1 跳到 i = 2，因为 A[2] 是（A[2]，A[3]，A[4]）中小于或等于 A[1] 的最大值。A[3] 也是最大的值，但 2 是一个较小的索引，所以我们只能跳到 i = 2，而不能跳到 i = 3。
 * <p>
 * 在我们的第三次跳跃（奇数）中，我们从 i = 2 跳到 i = 3，因为 A[3] 是（A[3]，A[4]）中大于或等于 A[2] 的最小值。
 * <p>
 * 我们不能从 i = 3 跳到 i = 4，所以起始索引 i = 0 不是好的起始索引。
 * <p>
 * 类似地，我们可以推断：
 * 从起始索引 i = 1 出发， 我们跳到 i = 4，这样我们就到达数组末尾。
 * 从起始索引 i = 2 出发， 我们跳到 i = 3，然后我们就不能再跳了。
 * 从起始索引 i = 3 出发， 我们跳到 i = 4，这样我们就到达数组末尾。
 * 从起始索引 i = 4 出发，我们已经到达数组末尾。
 * 总之，我们可以从 3 个不同的起始索引（i = 1, i = 3, i = 4）出发，通过一定数量的跳跃到达数组末尾。
 * 示例 3：
 * <p>
 * 输入：[5,1,3,4,2]
 * 输出：3
 * 解释：
 * 我们可以从起始索引 1，2，4 出发到达数组末尾。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 0 <= A[i] < 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OddEvenJumps {
    public int oddEvenJumps(int[] A) {
        int[] dpOdd = new int[A.length];// 0未走过,1可达中点,2尝试中,-1不可达
        int[] dpEven = new int[A.length];
        dpEven[A.length - 1] = 1;
        dpOdd[A.length - 1] = 1;
        for (int i = 0; i < A.length; i++) {
            if(dpOdd[i]==0)
            dpOdd(dpOdd, dpEven, A, i);
        }
        int sum =0;
        for (int i = 0; i < dpOdd.length; i++) {
            if (dpOdd[i]==1)sum++;
        }
        return sum;
    }

    private void dpOdd(int[] dpOdd, int[] dpEven, int[] A, int i) {
        if (dpOdd[i] == 0) {
            dpOdd[i] = 2;//找点
            int largerId = -1;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] >= A[i]) {
                    if (largerId == -1 || A[j] < A[largerId]) largerId = j;
                }
            }
            if (largerId != -1) dpEven(dpOdd, dpEven, A, largerId);
            else {
                fill(dpOdd, -1);
                fill(dpEven, -1);
            }
        } else if (dpOdd[i] == 1) {
            fill(dpOdd, 1);
            fill(dpEven, 1);
        } else if (dpOdd[i] == -1 || dpOdd[i] == 2) {
            fill(dpOdd, -1);
            fill(dpEven, -1);
        }

    }

    private void fill(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) arr[i] = val;
        }
    }

    private void dpEven(int[] dpOdd, int[] dpEven, int[] A, int i) {
        if (dpEven[i] == 0) {
            dpEven[i] = 2;//找点
            int largerId = -1;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] <= A[i]) {
                    if (largerId == -1 || A[j] > A[largerId]) largerId = j;
                }
            }
            if (largerId != -1) dpOdd(dpOdd, dpEven, A, largerId);
            else {
                fill(dpOdd, -1);
                fill(dpEven, -1);
            }
        } else if (dpEven[i] == 1) {
            fill(dpOdd, 1);
            fill(dpEven, 1);
        } else if (dpEven[i] == -1 || dpEven[i] == 2) {
            fill(dpOdd, -1);
            fill(dpEven, -1);
        }

    }
    public int oddEvenJumps2(int[] A) {
        int N = A.length;
        if (N <= 1) return N;
        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];
        odd[N-1] = even[N-1] = true;

        TreeMap<Integer, Integer> vals = new TreeMap();
        vals.put(A[N-1], N-1);
        for (int i = N-2; i >= 0; --i) {//倒序查,相同数据点左侧点可跳到右侧点,奇偶相反.
            int v = A[i];
            if (vals.containsKey(v)) {
                odd[i] = even[vals.get(v)];
                even[i] = odd[vals.get(v)];
            } else {
                Integer lower = vals.lowerKey(v);
                Integer higher = vals.higherKey(v);

                if (lower != null)
                    even[i] = odd[vals.get(lower)];
                if (higher != null) {
                    odd[i] = even[vals.get(higher)];
                }
            }
            vals.put(v, i);
        }

        int ans = 0;
        for (boolean b: odd)
            if (b) ans++;
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new OddEvenJumps().oddEvenJumps(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new OddEvenJumps().oddEvenJumps(new int[]{5, 1, 3, 4, 2}));
        System.out.println(new OddEvenJumps().oddEvenJumps(new int[]{1, 2, 3, 2, 1, 4, 4, 5}));
        System.out.println(new OddEvenJumps().oddEvenJumps(new int[]{10, 13, 12, 14, 15}));
    }
}
