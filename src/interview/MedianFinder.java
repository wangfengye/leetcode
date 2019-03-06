package interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author maple on 2019/3/6 11:19.
 * @version v1.0
 * @see 1040441325@qq.com
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class MedianFinder {
    // 最小堆（右）
    private PriorityQueue<Integer> rHeap = new PriorityQueue<>();
    // 最大堆（左）
    private PriorityQueue<Integer> lHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {


    }

    public void addNum(int num) {
        if (rHeap.size() == lHeap.size()) rHeap.offer(num);
        else lHeap.offer(num);
        if (rHeap.size() > 0 && lHeap.size() > 0 && rHeap.peek() < lHeap.peek()) {
            int l = lHeap.poll();
            int r = rHeap.poll();
            lHeap.offer(r);
            rHeap.offer(l);
        }
    }

    public double findMedian() {
        if (rHeap.size()==0&&lHeap.size()==0)return 0;
        if (rHeap.size() == lHeap.size()) {
            double res = rHeap.peek()+lHeap.peek();
            return res/2;
        } else {
            return rHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
     //   finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }

}
