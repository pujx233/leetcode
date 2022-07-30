package ����;

/**
 * ����һ���������ͷ�ڵ� head,�����жϸ������Ƿ�Ϊ��������
 * ����Ƿ��� true;���򷵻� false
 * */


public class isPalindrome {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * ����Ҳ���ں������,�����õݹ鷨���
     * private void printListNode(ListNode head) {
     *     if (head == null)
     *         return;
     *     printListNode(head.next);
     *     System.out.println(head.val);
     * }
     * */

    class Solution_1 {
        ListNode res;

        public boolean isPalindrome(ListNode head) {
            res = head;
            return reverse(head);
        }

        public boolean reverse(ListNode temp){
            if(temp==null){
                return true;
            }
            boolean judge = reverse(temp.next);
            if(judge && temp.val == res.val){
                res = res.next;
                return true;
            }
            else {
                return false;
            }

        }
    }

    /**
     * ����ָ��
     * */

    class Solution_2 {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            // �ҵ�ǰ�벿�������β�ڵ㲢��ת��벿������
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);

            // �ж��Ƿ����
            ListNode p1 = head;
            ListNode p2 = secondHalfStart;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) {
                    result = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            // ��ԭ�������ؽ��
            firstHalfEnd.next = reverseList(secondHalfStart);
            return result;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        private ListNode endOfFirstHalf(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
