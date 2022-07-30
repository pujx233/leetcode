package ����;

/**
 * ���㵥�����ͷָ�� head ���������� left �� right ������ left <= right
 * ���㷴ת��λ�� left ��λ�� right ������ڵ㣬���� ��ת�������
 * */

public class reverseList_2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    /**
     * 1�����Ƕ�������ָ�룬�ֱ��֮Ϊ g(guard ����) �� p(point)��
     * �������ȸ��ݷ����Ĳ��� m ȷ�� g �� p ��λ�á��� g �ƶ�����һ��Ҫ��ת�Ľڵ��ǰ�棬�� p �ƶ�����һ��Ҫ��ת�Ľڵ��λ���ϡ������� m=2��n=4Ϊ����
     * 2���� p �����Ԫ��ɾ����Ȼ����ӵ� g �ĺ��档Ҳ��ͷ�巨��
     * 3������ m �� n �ظ����裨2��
     * 4������ dummyHead.next
     * */

    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode g = dummyHead;
            ListNode p = dummyHead.next;

            // ��ָ���Ƶ���Ӧ��λ��
            for(int step = 0; step < m - 1; step++) {
                g = g.next; p = p.next;
            }

            // ͷ�巨����ڵ�
            for (int i = 0; i < n - m; i++) {
                ListNode removed = p.next;
                p.next = p.next.next;

                removed.next = g.next;
                g.next = removed;
            }

            return dummyHead.next;
        }
    }

    /**
     * �ݹ�
     * ��תǰN������
     * */

    class Solution_2 {
        public ListNode reverseBetween(ListNode head, int m, int n) {

            if (m == 1) {
                return reverseN(head, n);
            }
            // ǰ������ת����㴥�� base case
            head.next = reverseBetween(head.next, m - 1, n - 1);
            return head;
        }

        ListNode successor = null; // �����ڵ�

        // ��ת�� head Ϊ���� n ���ڵ㣬�����µ�ͷ���
        ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                // ��¼�� n + 1 ���ڵ�
                successor = head.next;
                return head;
            }
            // �� head.next Ϊ��㣬��Ҫ��תǰ n - 1 ���ڵ�
            ListNode last = reverseN(head.next, n - 1);

            head.next.next = head;
            // �÷�ת֮��� head �ڵ�ͺ���Ľڵ�������
            head.next = successor;
            return last;
        }
    }
}
