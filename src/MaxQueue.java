import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 */
public class MaxQueue {
    private Queue<Integer> data;
    private LinkedList<Integer> maxs;//维护一个递减队列.
    public MaxQueue() {
        data=new LinkedList<>();
        maxs=new LinkedList<>();
    }

    public int max_value() {
        return maxs.size()==0?-1:maxs.getFirst();
    }

    public void push_back(int value) {
        data.offer(value);

        for (int i = maxs.size()-1; i >=0 ; i--) {
            if(maxs.get(i)<value)maxs.remove(i);
            else break;
        }
        maxs.offer(value);

    }

    public int pop_front() {
        if (data.size()<=0)return -1;
        int tmp =data.poll();
        if (tmp==maxs.getFirst()){
            maxs.pollFirst();
        }
        return tmp;
    }
    public static void main(String[] args){
        MaxQueue queue=new MaxQueue();
        queue.push_back(15);
        System.out.println(queue.max_value());
        queue.push_back(9);
        System.out.println(queue.max_value());
        System.out.println(String.format("%4d",1));
    }
}
