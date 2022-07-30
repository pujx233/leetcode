package ����;

import java.util.HashSet;
import java.util.Set;

/**
 * ���������������ͷ�ڵ� headA �� headB �������ҳ������������������ཻ����ʼ�ڵ�
 * �����������û�н��㣬���� null
 *
 * ͼʾ���������ڽڵ� c1 ��ʼ�ཻ��
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
     * ����ָ��
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
