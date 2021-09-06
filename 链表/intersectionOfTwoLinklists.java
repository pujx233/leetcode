package 链表;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点
 * 如果两个链表没有交点，返回 null
 *
 * 图示两个链表在节点 c1 开始相交：
 * */

class intersectionOfTwoLinklists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> visited = new HashSet<ListNode>();
            ListNode temp = headA;
            while (temp != null) {
                visited.add(temp);
                temp = temp.next;
            }
            temp = headB;
            while (temp != null) {
                if (visited.contains(temp)) {
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }
    }

    /**
     * 快慢指针
     * */

    public class Solution_2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
    }

}
