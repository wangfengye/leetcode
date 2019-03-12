package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author maple on 2019/3/12 14:05.
 * @version v1.0
 * @see 1040441325@qq.com
 * 至少有K个重复字符的最长子串
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aaabb", k = 3
 * <p>
 * 输出:
 * 3
 * <p>
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 */
public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n < k) return 0;
        int[] count = new int[26];// 字符计数
        boolean[] valid = new boolean[26];//数量 > k的字符
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++)
            count[ch[i] - 'a']++;
        boolean fullValid = true;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k)
                fullValid = false;
            else
                valid[i] = true;
        }
        if (fullValid)
            return n;
        int max = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (!valid[ch[i] - 'a']) {
                max = Math.max(max, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
        }
        max = Math.max(max, longestSubstring(s.substring(start, n), k));
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstring().longestSubstring("bbaaacbd", 3));
    }
}
