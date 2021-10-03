package 链表;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * */

public class mergeKSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int l, int r) {
            if (l == r) {
                return lists[l];
            }
            if (l > r) {
                return null;
            }
            int mid = (l + r) >> 1;
            return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
        }

        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null) {
                return a != null ? a : b;
            }
            ListNode head = new ListNode(0);
            ListNode tail = head, aPtr = a, bPtr = b;
            while (aPtr != null && bPtr != null) {
                if (aPtr.val < bPtr.val) {
                    tail.next = aPtr;
                    aPtr = aPtr.next;
                } else {
                    tail.next = bPtr;
                    bPtr = bPtr.next;
                }
                tail = tail.next;
            }
            tail.next = (aPtr != null ? aPtr : bPtr);
            return head.next;
        }
    }


    class Solution_1 {
        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
            for (ListNode node: lists) {
                if (node != null) {
                    pq.offer(node);
                }
            }


            // 注意链表地址变化
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            while (!pq.isEmpty()) {
                ListNode minNode = pq.poll();
                tail.next = minNode;
                tail = minNode;
                if (minNode.next != null) {
                    pq.offer(minNode.next);
                }
            }
          
            return dummyHead.next;
        }
    }
}
