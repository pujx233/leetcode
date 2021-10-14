package 栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 思路
 * 将一个栈当作输入栈,用于压入push传入的数据;另一个栈当作输出栈，用于pop和peek操作。
 * 每次pop或peek时，若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈，
 * 这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
 *
 * */

public class myQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    /**
     * Initialize your data structure here.
     */


    public myQueue() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            inOut();
        }
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            inOut();
        }
        return outStack.peek();

    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void inOut(){
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }

    public static void main(String []args) {
        myQueue obj = new myQueue();
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
}



