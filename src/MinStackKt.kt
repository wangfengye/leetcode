import java.util.*

/**
 * 155. 最小栈
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。


示例:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 *
 */
class MinStackKt {
    /** initialize your data structure here. */
    private val stack = Stack<Int>();
    private val minStack = Stack<Int>();

    fun push(x: Int) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x)
        }
    }

    fun pop() {
        if (stack.isEmpty()) return
        val tmp = stack.pop();
        if (minStack.peek() == tmp) {
            minStack.pop()
        }
    }

    fun top(): Int {
        return stack.peek();
    }

    fun getMin(): Int {
        if (minStack.isEmpty()) return 0
        return minStack.peek();
    }

    companion object {
        @JvmStatic
        public fun main(args: Array<String>) {
            val a = MinStackKt();
            a.push(-2);
            a.push(0);
            a.push(-3);
            println(a.getMin())
            a.pop();
            println(a.top());
            println(a.getMin())
        }
    }
}