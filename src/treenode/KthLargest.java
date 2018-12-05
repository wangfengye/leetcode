package treenode;

import java.util.PriorityQueue;

/**
 * @author maple on 2018/12/4 16:56.
 * @version v1.0
 * @see 1040441325@qq.com
 * Kth Largest Element in a Stream
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用
 * KthLargest.add，返回当前数据流中第K大的元素
 */
public class KthLargest {
    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) queue.poll();
        }
    }


    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) queue.poll();
        return queue.peek()==null?-1:queue.peek();
    }
}
