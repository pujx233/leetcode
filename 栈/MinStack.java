package ջ;

import java.util.*;

/**
 * ���һ��֧�� push ��pop ��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
 *
 * push(x) ���� ��Ԫ�� x ����ջ�С�
 * pop() ���� ɾ��ջ����Ԫ�ء�
 * top() ���� ��ȡջ��Ԫ�ء�
 * getMin() ���� ����ջ�е���СԪ�ء�
 * */

public class MinStack {

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        xStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        int param_3 = obj.top();
        int param_4 = obj.getMin();

        System.out.println(param_3);
        System.out.println(param_4);
    }
}

