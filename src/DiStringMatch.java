/**
 * @author maple on 2019/5/29 14:49.
 * @version v1.0
 * @see 1040441325@qq.com
 * <p>
 * 942. 增减字符串匹配
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * <p>
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * <p>
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 * <p>
 * 输出："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 * <p>
 * 输出："DDI"
 * 输出：[3,2,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 1000
 * S 只包含字符 "I" 或 "D"
 */
public class DiStringMatch {
    public static int[] diStringMatch(String S) {
        int l = 0;
        int r = S.length();
        int[] res = new int[r + 1];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                res[i] = l++;
            } else {
                res[i] = r--;
            }
        }
        res[S.length()] = (l + r) / 2;
        return res;
    }

    public static void main(String[] args) {
        diStringMatch("IDID");
        diStringMatch("III");
        diStringMatch("DDI");
    }
}
