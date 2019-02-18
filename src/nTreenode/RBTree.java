package nTreenode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.concurrent.Future;

/**
 * @author maple on 2019/1/15 16:54.
 * @version v1.0
 * @see 1040441325@qq.com
 * 红黑二叉树
 * 用途: 保证搜索二叉树平衡,确保最劣查找速度> O(log n);
 * 劣势: 插入,删除较为复杂
 * 特性: 1. 每个节点是红色或黑色
 * 2. 根节点是黑色
 * 3. 每个叶子节点是黑色(PS: 这里的叶子节点指的是空的叶子节点)
 * 4. 若一个节点是红色,则他的子节点必为黑色
 * 5. 从一个节点到该节点的所有子孙节点的所有路径上包含相同数目的黑节点
 * <p>
 * 插入操作(思路:红色节点移动到根节点,根节点设为黑色,自叶子向根逐步处理)
 * 1. 当前节点的父节点是红色,叔叔节点也是红色,
 * operation: 1. 父节点设为黑色,2.叔叔节点设为黑色. 3. 祖父节点为红色. 4.以祖父节点为当前节点继续操作
 * <p>
 * 2. 当前节点父节点为红色, 叔叔节点为黑色,当前节点为父节点的右孩子
 * operation: 1. 以父节点为支点进行左旋, 2.以父节点为当前节点
 * <p>
 * 3. 当前节点的父节点是红色, 叔叔节点为黑色,当前节点为其父节点的做孩子
 * operation: 1. 父节点染黑. 2. 祖父节点染红. 3. 以祖父节点为支点进行右旋.3.以叔叔节点为当前节点
 * <p>
 * 删除
 * 1. 叶子节点,直接删除
 * 2.有一个孩子, 用孩子节点替代该节点
 * 3.两个孩子,
 */
public class RBTree {
    class A implements c {

        @Override
        public void show() {

        }

    }


    class B extends A implements c {
        @Override
        public void show() {
            super.show();
        }

    }

    interface c {
        void show();
    }

    public static void main(String[] args) {
     /*   for (int i = 0; i < 1000; i++) {
            finishedA = false;
            finishedB = false;
            System.out.println("start");
            Thread a = new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    show("A");
                }
            });
            Thread b = new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    show("B");
                }
            });
            a.start();
            b.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        redPackage(20, 8);
    }

    private static void redPackage(int money, int count) {
        money = money * 100;
        for (int i = 0; i < count-1; i++) {
            int randomPackage = (int) (Math.random() * (money * 2 / (count-i) - 1) + 1);
            System.out.println("第" + (i+1) + "人: " + randomPackage / 100 + "." + randomPackage % 100 + " 元");
            money -= randomPackage;
        }
        System.out.println("第" + count + "人: " + money / 100 + "." + money % 100 + " 元");
    }

    static boolean finishedA = false;
    static boolean finishedB = false;

    public static void show(String thread) {
        if (thread.equals("A")) {
            finishedA = true;
        } else if (thread.equals("B")) {
            finishedB = true;
        }
        if (finishedA && finishedB)
            System.out.println("两者完成");
    }

}
