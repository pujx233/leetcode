package ����;

/**����һ�����������е�����,������������ͷ�ڵ� head ,
 * ����ɾ�����������д��������ظ�����Ľڵ�,ֻ����ԭʼ������û���ظ����ֵ�����
 * ����ͬ�����������еĽ������
 */

/*
* 1.����ñ�����ǧ������Ž�ʡ�������������ױ��߼�����
* 2.head �п�����Ҫ�Ķ�ʱ,������һ�� ��head,���ص�ʱ��ֱ��ȡ��head.next,�����Ͳ���ҪΪ�޸�head����һ����߼���
*  */


public class removeDuplicatesFromSortedList_ii {

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

    /*����ͷ�ڵ���ܱ仯������Ҫ����һ����head*/

    public class Solution_1 {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null){
                return null;
            }
            int temp;   // ��¼�ظ��Ľڵ�ֵ
            ListNode dummy = new ListNode(0,head);
            ListNode cur = dummy;
            while (cur.next!=null && cur.next.next!=null){
                if(cur.next.val == cur.next.next.val){
                    temp = cur.next.val;

                    // ע�Ⲣ��ִ�д����Ⱥ�˳�������

                    while (cur.next!=null && cur.next.val==temp){
                        cur.next = cur.next.next;
                    }
                }else {
                    cur = cur.next;
                }
            }

            return dummy.next;
        }
    }

    /*������:�ݹ�*/

    public class Solution_2 {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            if(head.next!=null && head.val!=head.next.val){
                head.next = deleteDuplicates(head.next);
                return head;
            }else {
                while(head.next!=null && head.val == head.next.val){
                    head = head.next;
                }
                return deleteDuplicates(head.next);
            }

        }
    }
}
