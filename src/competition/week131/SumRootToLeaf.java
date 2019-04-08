package competition.week131;

/**
 * @author maple on 2019/4/7 15:47.
 * @version v1.0
 * @see 1040441325@qq.com
 * 5017. 从根到叶的二进制数之和  显示英文描述
 * 用户通过次数 267
 * 用户尝试次数 386
 * 通过次数 269
 * 提交次数 1279
 * 题目难度 Easy
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * <p>
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 以 10^9 + 7 为模，返回这些数字之和。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 */
public class SumRootToLeaf {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        if (root == null) return 0;
        computeSum(root, 0);
        return sum;
    }

    static int sum;
    private static final int mod = 1000000007;

    private void computeSum(TreeNode root, int pre) {
        pre *= 2;
        if (root.val == 1) pre++;
        pre %= mod;
        if (root.left == null && root.right == null) {
            sum = (sum + pre) % mod;
        } else if (root.left == null) {
            computeSum(root.right, pre);
        } else if (root.right == null) {
            computeSum(root.left, pre);
        } else {
            computeSum(root.left, pre);
            computeSum(root.right, pre);
        }


    }

    public static void main(String[] args) {
        int h = 1 << 1;
        int none = 0;
        none |= h;

        System.out.println(none);
    }
}
