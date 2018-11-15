package hash;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Queue<Character> set = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                max = Math.max(max, set.size());
                while (set.poll() != c) {
                    System.out.println(set.size());
                }
            }
            set.add(c);
        }
        max = Math.max(max, set.size());
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        boolean[] base = new boolean[128];//基础字符数量
        int i = 0, j = 0;
        int max = 0;
        while (j < s.length()) {
            if (base[s.charAt(j)]) {
                base[s.charAt(i)] = false;
                i++;
            } else {
                base[s.charAt(j)] = true;
                max = Math.max(max, j - i + 1);
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new LengthOfLongestSubstring().lengthOfLongestSubstring2("ynyo");


    }
}
