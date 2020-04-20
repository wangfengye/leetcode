package treenode;

import wbCompany.Tree;

/**
 * 5. 二叉树任务调度
 * 通过的用户数97
 * 尝试过的用户数248
 * 用户总通过次数102
 * 用户总提交次数408
 * 题目难度Hard
 * 任务调度优化是计算机性能优化的关键任务之一。在任务众多时，不同的调度策略可能会得到不同的总体执行时间，因此寻求一个最优的调度方案是非常有必要的。
 * <p>
 * 通常任务之间是存在依赖关系的，即对于某个任务，你需要先完成他的前导任务（如果非空），才能开始执行该任务。我们保证任务的依赖关系是一棵二叉树，其中 root 为根任务，root.left 和 root.right 为他的两个前导任务（可能为空），root.val 为其自身的执行时间。
 * <p>
 * 在一个 CPU 核执行某个任务时，我们可以在任何时刻暂停当前任务的执行，并保留当前执行进度。在下次继续执行该任务时，会从之前停留的进度开始继续执行。暂停的时间可以不是整数。
 * <p>
 * 现在，系统有两个 CPU 核，即我们可以同时执行两个任务，但是同一个任务不能同时在两个核上执行。给定这颗任务树，请求出所有任务执行完毕的最小时间。
 * <p>
 * 示例 1：
 * <p>
 * image.png
 * <p>
 * 输入：root = [47, 74, 31]
 * <p>
 * 输出：121
 * <p>
 * 解释：根节点的左右节点可以并行执行31分钟，剩下的43+47分钟只能串行执行，因此总体执行时间是121分钟。
 * <p>
 * 示例 2：
 * <p>
 * image.png
 * <p>
 * 输入：root = [15, 21, null, 24, null, 27, 26]
 * <p>
 * 输出：87
 * <p>
 * 示例 3：
 * <p>
 * image.png
 * <p>
 * 输入：root = [1,3,2,null,null,4,4]
 * <p>
 * 输出：7.5
 * <p>
 * 限制：
 * <p>
 * 1 <= 节点数量 <= 1000
 * 1 <= 单节点执行时间 <= 1000
 * todo
 */
public class MinimalExecTime {
    public static void main(String[] args) {
        TreeNode.create(47, 74, 31).show();
        System.out.println(new MinimalExecTime().minimalExecTime(
                TreeNode.create(47, 74, 31)
        ));

        TreeNode.create(15, 21, -1, 24, -1,-1,-1, 27, 26).show();
        System.out.println(new MinimalExecTime().minimalExecTime(
                TreeNode.create(15, 21, -1, 24, -1,-1,-1, 27, 26)
        ));
        TreeNode.create(1, 3, 2, -1, -1, 4, 4).show();
        System.out.println(new MinimalExecTime().minimalExecTime(
                TreeNode.create(1, 3, 2, -1, -1, 4, 4)
        ));
        MinimalExecTime time=new MinimalExecTime();

    }

    public double minimalExecTime(TreeNode root) {
        int[] ans = dfs(root);
        int need = ans[0] + ans[1];
        return need / 2.0;
    }

    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int[] ans = new int[2];
        //确保左侧时间小于
        if(l[0] > r[0]){
            int[] tmp = l;
            l = r;
            r = tmp;
        }

        ans[1] += l[0];
        r[0] -= l[0];
        int merge = Math.min(l[1] * 2, r[0]);
        l[1] -= merge / 2;
        r[0] -= merge;
        ans[1] += merge;
        ans[1] += r[1] + l[1];
        ans[0] += r[0];
        ans[0] += 2 * root.val;
        //ans[0]=r[0]+2*val-merge-l[0];
        //ans[1]=l[0]+merge+r[1]+l[1]-merge/2;
        return ans;
    }
}
