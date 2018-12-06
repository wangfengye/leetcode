package nTreenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author maple on 2018/12/6 9:23.
 * @version v1.0
 * @see 1040441325@qq.com
 * N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        if (root==null)return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int len;
        while (queue.size()>0){
            len = queue.size();
            ArrayList<Integer> levelRes = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                levelRes.add(node.val);
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            list.add(levelRes);
        }
        return list;
    }

    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        bfs(root,0,res);
        return res;
    }
    public void bfs(Node root,int level, List<List<Integer>> res) {
        if(root==null) {
            return ;
        }
        if(level==res.size())res.add(new ArrayList<>());
        res.get(level).add(root.val);
        for(Node node:root.children) {
            bfs(node,level+1,res);
        }
    }
}
