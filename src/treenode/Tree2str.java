package treenode;

/**
 * @author maple on 2020/1/10 10:59.
 * @version v1.0
 * @see 1040441325@qq.com
 * 606. 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * <p>
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 */
public class Tree2str {
    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }

    public static void main(String[] args) {
        System.out.println(new Tree2str().tree2str(TreeNode.create(new int[]{1,2,3,4})));

    }
}
