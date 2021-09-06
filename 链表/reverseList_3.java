package 链表;

import java.util.List;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * */

public class reverseList_3 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            int len = 0;
            ListNode cnt = head;
            while(cnt != null){
                len += 1;
                cnt = cnt.next;
            }

            // m 为需要反转的次数
            int m = len/k;

            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode g = dummy;
            ListNode p = dummy.next;
            for(int j = 0;j<m;j++) {
                for (int i = 0; i < k-1; i++) {
                    ListNode removed = p.next;
                    p.next = p.next.next;
                    removed.next = g.next;
                    g.next = removed;
                    if(i==k-2){
                        ListNode temp = p;
                        p = p.next;
                        g = temp;
                    }
                }


            }
            return dummy.next;
        }
    }

    public static void main(String []args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        Solution solution = new Solution();
        solution.reverseKGroup(a,2);
    }

}
