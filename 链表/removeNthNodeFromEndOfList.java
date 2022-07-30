package ����;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ����һ������ɾ������ĵ����� n ����㣬���ҷ��������ͷ��㡣
 * */

public class removeNthNodeFromEndOfList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // ֱ�ӱ������

    class Solution_1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0,head);
            ListNode cur = dummy;
            int length = getLength(head);

            for(int i = 1;i < length-n+1;i++){
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return dummy.next;
        }

        public int getLength(ListNode head){
            int len = 0;
            while (head!=null){
                len+=1;
                head = head.next;
            }
            return len;
        }
    }

    // �����ǵ�����n��,������ջ�ķ�ʽ���

    class Solution_2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0,head);
            ListNode cur = dummy;

            Deque<ListNode> stack = new LinkedList<ListNode>();
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            for (int i = 0; i < n; ++i) {
                stack.pop();
            }

            ListNode prev = stack.peek();
            prev.next = prev.next.next;

            return dummy.next;
        }

    }

    // ˫ָ��

    class Solution_3{
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0,head);
            ListNode cur = dummy;

            ListNode first = head;
            ListNode second = dummy;
            for (int i = 0; i < n; ++i) {
                first = first.next;
            }
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummy.next;
        }
    }
}
