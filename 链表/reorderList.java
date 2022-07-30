package ����;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�������� L ��ͷ�ڵ� head �������� L ��ʾΪ��
 *
 *  L0 �� L1 �� �� �� Ln-1 �� Ln
 * �뽫���������к��Ϊ��
 *
 * L0 �� Ln �� L1 �� Ln-1 �� L2 �� Ln-2 �� ��
 *
 * ����ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 * */

public class reorderList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Ϊ�˷������ʹ�����Ա�
     * */

    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            List<ListNode> list = new ArrayList<ListNode>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }

            int i = 0,j = list.size()-1;
            while(i<j){
                list.get(i).next = list.get(j);
                i++;
                if(i==j){
                    break;
                }
                list.get(j).next = list.get(i);
                j--;
            }

            list.get(i).next = null;

        }
    }

    /**
     * Ѱ�������е� + �������� + �ϲ�����
     * */
    class Solution_1 {
        public void reorderList(ListNode head) {
            if (head == null || head.next ==null){
                return;
            }

            ListNode mid = middleNode(head);
            ListNode l1 = head,l2 = mid.next;
            mid.next = null;
            l2 = reverseList(l2);
            mergeList(l1,l2);
        }

        public ListNode middleNode(ListNode head){
            ListNode slow = head,fast = head;
            while(fast.next!=null && fast.next.next!=null){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        public ListNode reverseList(ListNode head){

            ListNode prev = null,cur = head;

            while(cur!=null){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            return prev;
        }

        public void mergeList(ListNode l1,ListNode l2){
            ListNode l1_tmp;
            ListNode l2_tmp;
            while (l1 != null && l2 != null) {
                l1_tmp = l1.next;
                l2_tmp = l2.next;

                l1.next = l2;
                l1 = l1_tmp;

                l2.next = l1;
                l2 = l2_tmp;
            }
        }
    }

}
