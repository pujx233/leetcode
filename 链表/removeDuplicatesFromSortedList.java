package ����;

/**
 * ����һ�����������е�����������������ͷ�ڵ� head ������ɾ�������ظ���Ԫ�أ�ʹÿ��Ԫ��ֻ����һ�� ��
 * ����ͬ�����������еĽ������
 * */

public class removeDuplicatesFromSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*����һ*/

    public class Solution_1 {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null){
                return null;
            }
            ListNode cur = head;
            while (cur.next!=null){
                if(cur.next.val == cur.val){
                    cur.next = cur.next.next;
                }else {
                    cur = cur.next;
                }
            }

            return head;
        }

    }




}
