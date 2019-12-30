/**
 * @author maple on 2019/12/5 14:26.
 * @version v1.0
 * @see 1040441325@qq.com
 * 174. 地下城游戏
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 *
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 *
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 *
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 *
 *  
 *
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 *
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * todo 不会
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 */
import ListNode.ListNode;
import treenode.TreeNode;

import java.util.*;


    public class CalculateMinimumHP {

        //后序遍历的非递归实现
        public ArrayList<Integer> postOrder(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p =root;
            TreeNode pre= root;
            while(p!=null||!stack.isEmpty()){
                while(p!=null){
                    stack.push(p);
                    p= p.left;
                }
                if(!stack.isEmpty()){
                    TreeNode treeroot = stack.peek().right;
                    if(treeroot==null||treeroot==pre){
                        p= stack.pop();
                        if(p.left==null&&p.right==null)
                            list.add(p.val);
                        pre=p;
                        p=null;
                    }
                    else{
                        p=treeroot;
                    }
                }
            }


            return list;
        }



        public static void main(String[] args) {
            TreeNode a = new TreeNode(0);
            TreeNode b = new TreeNode(1);
            TreeNode c = new TreeNode(2);
            TreeNode d = new TreeNode(3);
            TreeNode e = new TreeNode(4);
            TreeNode f = new TreeNode(5);
            TreeNode g = new TreeNode(6);
            a.left=b;
            a.right=c;
            b.left=d;
            b.right=e;
            c.left=f;
            c.right=g;
            CalculateMinimumHP t = new CalculateMinimumHP();
            ArrayList<Integer> list = new ArrayList<>();
            list = t.postOrder(a);
            a.show();
            for(Integer item:list)
                System.out.println(item);
        }
    }