package leetcode.初级算法.设计问题;

import java.util.Stack;

/**
 * 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */

public class D02最小栈 {

    private Stack<Integer> m;
    private Stack<Integer> s;

    /** initialize your data structure here. */
    public D02最小栈() {
        m = new Stack();
        s = new Stack();

    }

    public void push(int x) {
        s.push(x);
        if (m.isEmpty() || x <= m.peek())
            m.push(x);
    }

    public void pop() {
        int tmp = s.pop();
        if (tmp == m.peek())
            m.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return m.peek();
    }

}
