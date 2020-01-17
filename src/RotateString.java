/**
 * 796. 旋转字符串
 * 给定两个字符串, A 和 B。
 * <p>
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 * <p>
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        if(A.length()==0)return true;
        int index = -1;
        for (; ; ) {
            index = A.indexOf(B.charAt(0), index + 1);
            if (index == -1) return false;
            boolean check = true;//通过检测
            for (int i = 0; i < B.length(); i++) {
                if (A.charAt((index + i) % A.length()) != B.charAt(i)) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }
    }
}
