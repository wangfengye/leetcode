package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author maple on 2019/3/4 9:14.
 * @version v1.0
 * @see 1040441325@qq.com
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案
 */
public class Partition {
    ArrayList<List<String>> res;

    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] partitions = new boolean[len][len];//partition[i][j]记录 i-j的字符串是否是回文字符串
        //判断公式  partitions[i][j] = partitions[i+1][j-1]&&(s[i]==s[j])
        for (int i = 0; i < len; i++) {
            partitions[i][i] = true;
            partitions[i][0] = s.charAt(i) == s.charAt(0);
        }
        for (int i = 0; i < len - 1; i++) {
            partitions[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int i = 2; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                partitions[j][i + j] = partitions[j + 1][i + j - 1] && s.charAt(j) == s.charAt(i + j);
            }
        }
        res = new ArrayList<>();
        help(s, 0, new ArrayList<>(), partitions);
        return res;
    }

    /**
     *  递归分组 每次从当前位置,向后取所有可能位置;
     *
     * @param s
     * @param start
     * @param starts
     * @param partitions
     */
    private void help(String s, int start, ArrayList<Integer> starts, boolean[][] partitions) {
        if (start == s.length()) {
            // 组织字符串
            computeStr(s, starts);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!partitions[start][i]) continue;
            starts.add(i);
            help(s, i + 1, starts, partitions);
            starts.remove(starts.size() - 1);
        }
    }

    private void computeStr(String s, ArrayList<Integer> splits) {
        ArrayList<String> temp = new ArrayList();
        int start = 0;
        for (int i : splits) {
            temp.add(s.substring(start, i + 1));
            start = i + 1;
        }
        res.add(temp);
    }

    public static void main(String[] args) {
        new Partition().partition("bb");
    }
}
