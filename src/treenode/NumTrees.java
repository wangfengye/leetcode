package treenode;

/**
 * @author maple on 2019/11/19 17:24.
 * @version v1.0
 * @see 1040441325@qq.com
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class NumTrees {
    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                /**
                 * 公式推导,
                 * 以i为根的排列方式等于 左子树排列方式 * 右子树排列方式.
                 * G[i]记录以i根的排列方式.
                 */
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
        show(5);
    }

    private static void show(int n) {
        if (n == 0) return;
        for (int i = 0; i < n; i++) {
            show(n - 1);
        }
        System.out.println("*");
        for (int i = 0; i < n; i++) {
            System.out.println(".");
        }
        System.out.print("\n");
    }
}
