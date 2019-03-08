package interview;

import java.util.*;

/**
 * @author maple on 2019/3/8 10:38.
 * @version v1.0
 * @see 1040441325@qq.com
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同
 */
public class LadderLength {// 不记录之前转换过的 单词, 可能出现循环转换

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Queue<String> tmp = new LinkedList<>();
        tmp.add(beginWord);
        int wordSize = wordList.size() - 1;
        int len = 1;
        while (tmp.size() > 0 && len <= wordSize) {
            int queueLen = tmp.size();
            for (int i = 0; i < queueLen; i++) {
                String base = tmp.poll();
                for (int j = wordList.size() - 1; j >= 0; j--) {
                    String word = wordList.get(j);
                    if (isAdjacent(word, base)) {
                        if (word.equals(endWord)) return len + 1;
                        else if (!tmp.contains(word)) {
                            tmp.offer(word);
                            wordList.remove(word);
                        }
                    }
                }

            }
            len++;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        return bfs(beginSet, endSet, dict, 0);
    }

    /**
     * 首尾一起开始广度优先遍历, 那边入口少,遍历哪边;
     */
    private int bfs(Set<String> beginSet, Set<String> endSet, Set<String> dict, int step) {
        if (beginSet.isEmpty() || endSet.isEmpty()) return 0;
        step++;
        dict.removeAll(beginSet);
        Set<String> nextSet = new HashSet<>();
        for (String str : beginSet) {
            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char old = chs[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chs[i] = c;
                    String next = new String(chs);
                    if (!dict.contains(next)) continue;
                    if (endSet.contains(next)) return step + 1;
                    nextSet.add(next);
                }
                chs[i] = old;
            }
        }
        return nextSet.size() > endSet.size() ? bfs(endSet, nextSet, dict, step) : bfs(nextSet, endSet, dict, step);
    }

    private boolean isAdjacent(String a, String b) {
        int diffLen = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffLen++;
                if (diffLen >= 2) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        new LadderLength().ladderLength("a", "b", list);
    }

}
