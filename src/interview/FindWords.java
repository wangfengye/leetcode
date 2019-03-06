package interview;


import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/3/5 16:47.
 * @version v1.0
 * @see 1040441325@qq.com
 * 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 提示:
 * <p>
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 */
public class FindWords {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = new TrieNode(' ');
        for (String word : words) {
            trie.insert(word);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search(i, j, board, trie, res);
            }
        }
        return res;
    }

    private void search(int x, int y, char[][] board, TrieNode node, List<String> ans) {
        if (node.res != null && node.res.length() > 0) {
            if (!ans.contains(node.res))
            ans.add(node.res);
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) return;
        char tmp = board[x][y];
        node = node.findChild(tmp);
        if (node == null) return;
        board[x][y] = '0';
        search(x - 1, y, board, node, ans);
        search(x + 1, y, board, node, ans);
        search(x, y - 1, board, node, ans);
        search(x, y + 1, board, node, ans);
        board[x][y] = tmp;
    }

    class TrieNode {
        char val;
        List<TrieNode> children;
        String res;

        public void insert(String word) {
            TrieNode tmp = this;
            for (int i = 0; i < word.length(); i++) {
                tmp = tmp.addChild(word.charAt(i));
            }
            tmp.res = word;
        }


        public TrieNode(char val) {
            this.val = val;
        }

        public TrieNode addChild(char c) {
            TrieNode addedTmp;
            if (children == null) {
                children = new ArrayList<>();
                addedTmp = new TrieNode(c);
                children.add(addedTmp);
                return addedTmp;
            }
            for (TrieNode child : children) {
                if (child.val == c) return child;
            }
            addedTmp = new TrieNode(c);
            children.add(addedTmp);
            return addedTmp;
        }

        public TrieNode findChild(char c) {
            if (children == null) return null;
            for (TrieNode child : children) {
                if (child.val == c) return child;
            }
            return null;
        }
    }
}
