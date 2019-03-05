package interview;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/3/5 13:52.
 * @version v1.0
 * @see 1040441325@qq.com
 * 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Trie {
    /**
     * Initialize your data structure here.
     */
    Node mNode;

    public Trie() {
        mNode = new Node(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node tmp = mNode;
        for (int i = 0; i < word.length(); i++) {
            tmp = tmp.addChild(word.charAt(i));
        }
        tmp.addChild('.');
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node tmp = mNode;
        for (int i = 0; i < word.length(); i++) {
            tmp = tmp.findChild(word.charAt(i));
            if (tmp == null) return false;
        }
        if (tmp.findChild('.') == null) return false;
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node tmp = mNode;
        for (int i = 0; i < prefix.length(); i++) {
            tmp = tmp.findChild(prefix.charAt(i));
            if (tmp == null) return false;
        }
        return true;
    }

    class Node {
        char val;
        List<Node> children;

        public Node(char val) {
            this.val = val;
        }

        public Node addChild(char c) {
            Node addedTmp;
            if (children == null) {
                children = new ArrayList<>();
                addedTmp = new Node(c);
                children.add(addedTmp);
                return addedTmp;
            }
            for (Node child : children) {
                if (child.val == c) return child;
            }
            addedTmp = new Node(c);
            children.add(addedTmp);
            return addedTmp;
        }

        public Node findChild(char c) {
            if (children == null) return null;
            for (Node child : children) {
                if (child.val == c) return child;
            }
            return null;
        }

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
    }
}
