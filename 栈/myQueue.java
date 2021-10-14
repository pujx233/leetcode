package ջ;

import java.util.Deque;
import java.util.LinkedList;

/**
 * �����ʹ������ջʵ�������ȳ����С�����Ӧ��֧��һ�����֧�ֵ����в�����push��pop��peek��empty����
 *
 * ˼·
 * ��һ��ջ��������ջ,����ѹ��push���������;��һ��ջ�������ջ������pop��peek������
 * ÿ��pop��peekʱ�������ջΪ��������ջ��ȫ���������ε�����ѹ�����ջ��
 * �������ջ��ջ����ջ�׵�˳����Ƕ��дӶ�������β��˳��
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



