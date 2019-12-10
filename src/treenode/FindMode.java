package treenode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author maple on 2019/12/10 9:28.
 * @version v1.0
 * @see 1040441325@qq.com
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class FindMode {
    /**
     *  基本思路:map存键值,遍历树
     *  进阶:搜索树,先序遍历是有序的,按先序遍历记录有新的最大值,抛弃前面的数据,提高效率
     *  这种方式不好记录数量只有一个的数,当这种方式遍历后,无最大值,说明所有数只有一个,在遍历一遍全部存入.
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map=new HashMap<>();
        dfs(root,map);
        int max= 0;
        for (Integer count:map.values()) {
            if (count>max)max=count;
        }
        ArrayList<Integer> res =new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()==max){
                res.add(entry.getKey());
            }
        }
        int[] resA= new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resA[i]=res.get(i);
        }
        return resA;
    }

    private void dfs(TreeNode root, HashMap<Integer, Integer> map) {
        if (root!=null){
            map.put(root.val,map.getOrDefault(root.val,0)+1);
            dfs(root.left,map);
            dfs(root.right,map);
        }

    }
}
