package QueueAndStack;

import java.util.LinkedList;

/**
 * 用队列实现栈
 */
public class MyStack {
    LinkedList<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int i = queue.getFirst();
        queue.remove((Integer)i);
        return i;
    }

    /** Get the top element. */
    public int top() {
        return  queue.getFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
