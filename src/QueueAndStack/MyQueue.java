package QueueAndStack;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (empty()){
            stack.push(x);return;
        }
        int[] temp = new int[stack.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=stack.pop();
        }
        stack.push(x);
        for (int i = temp.length-1; i >=0; i--) {
            stack.push(temp[i]);
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (empty()) return -1;
        return stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (empty()) return -1;
        return stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.size() == 0;
    }

}