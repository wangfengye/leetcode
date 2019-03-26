package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple on 2019/3/25 16:59.
 * @version v1.0
 * @see 1040441325@qq.com
 * 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
public class CountSmaller {
    public List<Integer> countSmaller1(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        LinkedList<Integer> result = new LinkedList<>();//头部插入使用链表效率高
        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0;
            int right = temp.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (temp.get(mid) >= nums[i])
                    right = mid;
                else
                    left = mid + 1;

            }
            result.addFirst(left);
            temp.add(left, nums[i]);
        }
        return result;
    }

    public List<Integer> countSmaller2(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();
        if (nums.length == 0) return result;
        Node root = new Node(nums[nums.length - 1]);
        result.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            result.addFirst(root.insert(nums[i]));
        }
        return result;
    }

    static class Node {
        Node left;
        Node right;
        int val;
        int valCount;//相同值数量
        int nodeCount;// 原数组左侧的节点数

        public Node(int val) {
            this.val = val;
            this.valCount = 1;
            this.nodeCount = 1;
        }
        // 插入并返回右侧小于当前元素的个数
        public int insert(int val) {
            nodeCount++;
            if (this.val == val) {
                valCount++;
                return this.left != null ? this.left.nodeCount : 0;
            } else if (val < this.val) {
                if (this.left == null) {
                    this.left = new Node(val);
                    return 0;
                } else {
                    return this.left.insert(val);
                }
            } else {
                int leftCount = this.left != null ? this.left.nodeCount : 0;
                if (this.right == null) {
                    this.right = new Node(val);
                    return leftCount + this.valCount;
                } else {
                    return leftCount + this.valCount + this.right.insert(val);
                }
            }
        }
    }
}
