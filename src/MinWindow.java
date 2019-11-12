import java.util.HashMap;

/**
 * @author maple on 2019/11/12 9:33.
 * @version v1.0
 * @see 1040441325@qq.com
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinWindow {
    public static String minWindow(String s, String t) {
        if (s.length()<t.length())return "";
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        HashMap<Character,Integer> map=new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int tmpLen = 0;
        int superChar = 0;
        int startIndex = 0;
        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                int tmpC=map.getOrDefault(c,0)-1;
                map.put(c,tmpC);
                if (tmpC < 0) {
                    superChar++;
                } else {
                    tmpLen++;
                    if (tmpLen == t.length()) {//完成一次
                        for (; left < right; left++) {
                            char lc = s.charAt(left);
                            if (map.containsKey(lc)) {
                                int tmpLc=map.getOrDefault(lc,0)+1;
                                map.put(lc,tmpLc);
                                if (tmpLc> 0) {
                                    tmpLen--;
                                    break;
                                } else {
                                    superChar--;
                                }
                            }
                        }
                        if (right - left < minLen) {
                            minLen = right - left;
                            startIndex = left;
                        }
                        left++;
                    }
                }
            }

        }
        if (minLen==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(startIndex, startIndex + minLen + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }
}
