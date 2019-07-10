package treenode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/7/10 9:19.
 * @version v1.0
 * @see 1040441325@qq.com
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        dfs(root, new StringBuilder(), res);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder tmp, ArrayList<String> res) {
        if (root == null) return;
        int len = tmp.length();
        tmp.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(tmp.toString());
            tmp.setLength(len);
            return;
        }
        tmp.append("->");
        if (root.left != null) {
            dfs(root.left, tmp, res);
        }
        if (root.right != null) {
            dfs(root.right, tmp, res);
        }
        tmp.setLength(len);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(37);
        TreeNode a = new TreeNode(-34);
        TreeNode b= new TreeNode(-48);
        TreeNode a1= new TreeNode(-100);
        a.left =a1;
        root.left=a;root.right=b;

        new BinaryTreePaths().binaryTreePaths(root);
    }
}
