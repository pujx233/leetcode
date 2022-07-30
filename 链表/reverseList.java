package ����;

/**
 * ���㵥�����ͷ�ڵ� head �����㷴ת���������ط�ת�������
 * */


public class reverseList{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * �ݹ�
     **/

    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode last  = reverseList(head.next);
            head.next.next = head;
            head.next = null;

            return last;
        }
    }

    /**
     * �ڱ����б�ʱ������ǰ�ڵ�� next ָ���Ϊָ��ǰһ��Ԫ��
     * ���ڽڵ�û����������һ���ڵ㣬��˱������ȴ洢��ǰһ��Ԫ�ء��ڸ�������֮ǰ������Ҫ��һ��ָ�����洢��һ���ڵ�
     * ��Ҫ��������󷵻��µ�ͷ����
     * */

    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode prev = null,curr = head;
            while(curr!=null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

            }

            return prev ;
        }
    }

}