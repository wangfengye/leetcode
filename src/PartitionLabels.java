import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author maple on 2019/6/9 17:01.
 * @version v1.0
 * @see 1040441325@qq.com
 * <p>
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> data = new ArrayList<>();
        int[] last = new int[26];//存字符最后位置
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        int left = -1;
        int right = 0;
        for (int i = 0; i < S.length(); i++) {
            int max = last[S.charAt(i) - 'a'];
            if (max > right) right = max;
            if (i == right) {
                data.add(right - left);
                left = right;
            }
        }
        return data;
    }
}
