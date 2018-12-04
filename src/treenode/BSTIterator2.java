package treenode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author maple on 2018/12/3 9:19.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class BSTIterator2 {
    /**
     * 中序遍历即为正确排序
     */
    ArrayList<Integer> list = new ArrayList<>();
    private List<Integer> in(TreeNode root){
        if (root.left!=null){
            in(root.left);
        }
        list.add(root.val);
        if (root.right!=null){
            in(root.right);
        }
        return list;
    }
    public BSTIterator2(TreeNode root) {
        in(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !list.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
       int val = list.get(0);
       list.remove(0);
       return val;
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r1l= new TreeNode(3);
        treeNode.right =r1;
        r1.left = r1l;
        Random a = new Random(3);
        System.out.println(a.nextInt());
        System.out.println(a.nextInt());
        System.out.println(a.nextInt());
        System.out.println("-----------------------------------");
        a= new Random(3);
        System.out.println(a.nextInt());
        System.out.println(a.nextInt());
        System.out.println(a.nextInt());
    }
}
