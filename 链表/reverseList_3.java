package ����;

import java.util.List;

/**
 * ����һ������ÿ k ���ڵ�һ����з�ת�����㷵�ط�ת�������
 *
 * k ��һ��������������ֵС�ڻ��������ĳ��ȡ�
 *
 * ����ڵ��������� k ������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 *
 * ���ף�
 *
 * ��������һ��ֻʹ�ó�������ռ���㷨�������������
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʽ��нڵ㽻����
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

            // m Ϊ��Ҫ��ת�Ĵ���
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
