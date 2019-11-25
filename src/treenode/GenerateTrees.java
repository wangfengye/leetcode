package treenode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author maple on 2019/11/25 11:04.
 * @version v1.0
 * @see 1040441325@qq.com
 * 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return generate(1, n);
    }

    private LinkedList<TreeNode> generate(int start, int end) {
        LinkedList<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        // 选根
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> leftTrees = generate(start, i - 1);
            LinkedList<TreeNode> rightTrees = generate(i+1, end);
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = l;
                    currentTree.right = r;
                    allTrees.add(currentTree);
                }
            }
        }
        return allTrees;
    }
}
