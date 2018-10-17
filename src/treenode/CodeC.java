package treenode;

/**
 * 二叉树的序列化与反序列化
 */
public class CodeC {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preOrder(root, builder);
        return builder.toString();
    }

    private void preOrder(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#!");
            return;
        }
        builder.append(root.val).append("!");
        preOrder(root.left, builder);
        preOrder(root.right, builder);
    }

    int i;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] chars = data.split("!");
        TreeNode root = new TreeNode(0);
        if (chars.length == 0) return null;
        i = -1;
        buildLeft(root, chars);
        return root.left;

    }

    private void buildLeft(TreeNode root, String[] chars) {
        i++;
        if (i >= chars.length || chars[i].equals("#")) return;
        int val =Integer.parseInt(chars[i]);
        root.left = new TreeNode(val);
        buildLeft(root.left, chars);
        buildRight(root.left, chars);
    }

    private void buildRight(TreeNode root, String[] chars) {
        i++;
        if (i >= chars.length || chars[i].equals("#")) return;
        int val =Integer.parseInt(chars[i]);
        root.right = new TreeNode(val);
        buildLeft(root.right, chars);
        buildRight(root.right, chars);
    }
    public static void  main(String[] args){
        new CodeC().deserialize("1!#!2!3!");
    }
}
