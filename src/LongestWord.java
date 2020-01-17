import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 720. 词典中最长的单词
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * <p>
 * 若无答案，则返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * words = ["w","wo","wor","worl", "world"]
 * 输出: "world"
 * 解释:
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * 示例 2:
 * <p>
 * 输入:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出: "apple"
 * 解释:
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
 */
public class LongestWord {
    //前缀树
    public String longestWord(String[] words) {
        Node root = new Node('0', 0);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Node node = root;
            for (int j = 0; j < word.length(); j++) {
                node = node.addChild(word.charAt(j), j == word.length() - 1 ? i : -1);
            }
        }
        max = -1;
        resId = -1;
        wordsC = words;
        dfs(root);
        return words[resId];
    }

    int max;
    int resId;
    String[] wordsC;

    private void dfs(Node root) {
        if (root.index == -1) return;
        boolean islastWord=true;//最长单次才进行判断
        if (root.children != null) {

            for (Map.Entry<Character, Node> entry : root.children.entrySet()) {
                Node n=entry.getValue();
                if(n.index!=-1){
                    islastWord=false;
                    dfs(n);
                }
            }
        }
        if(!islastWord)return;
        if (wordsC[root.index].length() > max) {
            resId = root.index;
            max = wordsC[root.index].length();
        } else if (wordsC[root.index].length() == max) {
            String last = wordsC[resId];
            String cur = wordsC[root.index];
            for (int i = 0; i < last.length(); i++) {
                if (last.charAt(i) > cur.charAt(i)) {
                    resId = root.index;
                    break;
                } else if (last.charAt(i) < cur.charAt(i)) {
                    break;
                }
            }
        }


    }

    static class Node {
        char val;
        HashMap<Character, Node> children;
        int index;//记录在数组中的id;

        Node(char val, int index) {
            this.val = val;
            this.index = index;
        }

        Node addChild(char c, int index) {
            if (children == null) {
                children = new HashMap<>();
            }
            if (children.containsKey(c)) {
                Node node = children.get(c);
                if (index >= 0) node.index = index;
                return node;
            } else {
                Node node = new Node(c, index);
                children.put(c, node);
                return node;
            }

        }
    }

    public static void main(String[] args) {
        // System.out.println(new LongestWord().longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        // System.out.println(new LongestWord().longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(new LongestWord().longestWord(new String[]{"ogz", "eyj", "e", "ey", "hmn", "v", "hm", "ogznkb", "ogzn", "hmnm", "eyjuo", "vuq", "ogznk", "og", "eyjuoi", "d"}));
    }
}
