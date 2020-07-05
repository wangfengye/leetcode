package string;

import java.util.Arrays;

/**
 * todo,复习
 * kmp算法
 */
public class KMP {
    public static int kmp(String s, String p) {
        //构造kmp next .记录p中的重复前缀
        int[] next = new int[p.length()];
        next[0] = 0;
        //ABABABD
        for (int i = 1, j = 0; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));
        for (int i = 0, j = 0; i < s.length(); i++) {
            //需要处理str1.charAt(i) != str2.charAt(j)
            //kmp核心算法,回溯到对应位置.
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }

            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == p.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int baoli(String s, String p) {
        for (int i = 0; i < s.length() - p.length(); i++) {
            boolean is = true;
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i + j) != p.charAt(j)) {
                    is = false;
                    break;
                }
            }
            if (is) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(kmp("BBC ABCDAB ABCDABCDABDE", "ABABABD"));
        System.out.println(baoli("BBC ABCDAB ABCDABCDABDE", "ABABABD"));
    }
}
