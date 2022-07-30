package ����;

import java.util.LinkedList;

/* ��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵ�
*
* ��ʵ�ݹ���ǳ����ڲ�ά����һ��ջ����������ÿ�ζ�����Сֵѹ��ջ������ջ��ʱ�򣬽���������
* ��һ��Ϳ����ˡ�˵���ˣ�������һ��ջά����˳���������ӣ���Ȼ��С����С�ģ�����l1 С������
* �� l1,l2 С������ l2������ȷ��صģ�������С��ͷ��㡣
*
* */


public class mergeTwoSortedLists {

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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null){
                return l2;
            }
            if(l2 == null){
                return l1;
            }

            if(l1.val<l2.val){
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            }else {
                l2.next = mergeTwoLists(l1,l2.next);

                return l2;
            }
        }

    }


    /*������*/

    class Solution_2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            // �ϲ��� l1 �� l2 ���ֻ��һ����δ���ϲ��꣬����ֱ�ӽ�����ĩβָ��δ�ϲ����������
            prev.next = l1 == null ? l2 : l1;

            return prehead.next;
        }
    }
}
