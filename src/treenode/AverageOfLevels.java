package treenode;

import ListNode.ListNode;
import wbCompany.Tree;

import java.util.*;

/**
 * @author maple on 2020/1/13 9:57.
 * @version v1.0
 * @see 1040441325@qq.com
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 */
public class AverageOfLevels {
    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        List<Double> list=new ArrayList<>();
        int size=0;
        while ((size=queue.size())>0){

            double res=0d;
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                res+=node.val;
                if (node.left!=null)queue.offer(node.left);
                if (node.right!=null)queue.offer(node.right);
            }
            list.add(res/size);
        }
        return list;
    }
    public static void main(String[] args){
        TreeNode root =TreeNode.create(new int[]{1,2,3,4,5,6,7});
        root.show();
        List<Double> res=averageOfLevels(root);
        Double[] arr=new Double[res.size()];
        res.toArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
