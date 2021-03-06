/**
 * @author maple on 2019/7/10 14:56.
 * @version v1.0
 * @see 1040441325@qq.com
 * 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        boolean[] hasUse = new boolean[magazine.length()];
        for (char c : ransomNote.toCharArray()) {
            int tmp = -1;
            while (true) {
                tmp = magazine.indexOf(c, tmp + 1);
                if (tmp == -1) return false;
                if (!hasUse[tmp]) {
                    hasUse[tmp] = true;
                    break;
                }
            }

        }
        return true;
    }
}
