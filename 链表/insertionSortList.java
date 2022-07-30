package Á´±í;

public class insertionSortList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {

        public ListNode insertionSortList(ListNode head) {

            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;

            ListNode pre = null;
            ListNode p = head;
            while (p != null && p.next != null) {

                if (p.val <= p.next.val) {

                    p = p.next;
                    continue;
                }
                pre = dummyHead;

                ListNode q = p.next;
                while (pre.next.val < q.val) {

                    pre = pre.next;
                }

                p.next = q.next;
                q.next = pre.next;
                pre.next = q;
            }
            return dummyHead.next;
        }
    }
}
