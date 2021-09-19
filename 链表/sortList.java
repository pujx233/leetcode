package 链表;

/**
 * 给你链表的头结点 head ，请将其按升序排列并返回排序后的链表
 * */

public class sortList {

    public static class ListNode {
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

    /**
     * 自顶向下归并排序
     * */

    class Solution {
        public ListNode sortList(ListNode head) {
            return sortList(head,null);
        }

        public ListNode sortList(ListNode head,ListNode tail){
            if(head == null){
                return null;
            }

            if (head.next == tail) {
                head.next = null;
                return head;
            }
            ListNode slow = head, fast = head;

            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }

            ListNode mid = slow;
            ListNode list1 = sortList(head,mid);

            // 为什么是mid不少mid.next
            ListNode list2 = sortList(mid,tail);
            ListNode sorted = mergeSort(list1,list2);

            return sorted;

        }


        public ListNode mergeSort(ListNode head1,ListNode head2){
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead,temp1 = head1,temp2 = head2;

            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            } else if (temp2 != null) {
                temp.next = temp2;
            }
            return dummyHead.next;
        }

    }

    /**
     * 自底向上归并排序
     * */

    public static class Solution_2 {
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            int length = 0;
            ListNode node = head;
            while (node != null) {
                length++;
                node = node.next;
            }
            ListNode dummyHead = new ListNode(0, head);
            for (int subLength = 1; subLength < length; subLength <<= 1) {
                ListNode prev = dummyHead, curr = dummyHead.next;
                while (curr != null) {
                    ListNode head1 = curr;
                    for (int i = 1; i < subLength && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode next = null;
                    if (curr != null) {
                        next = curr.next;
                        curr.next = null;
                    }
                    ListNode merged = merge(head1, head2);
                    prev.next = merged;
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    curr = next;
                }
            }
            return dummyHead.next;
        }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            } else if (temp2 != null) {
                temp.next = temp2;
            }
            return dummyHead.next;
        }
    }


    /**
     * 易超时的快速排序
     * */

    public static class Solution_3 {
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            int l = head.val, r = head.val;
            double pivot;
            ListNode p = head, q = null,h1 = null, h2 = null;
            while (p != null) {//求最大值和最小值
                l = Math.min(p.val, l);
                r = Math.max(p.val, r);
                p = p.next;
            }
            if (l == r) return head;//如果最大值等于最小值，说明链表值都是相等的
            pivot = (l + r) / 2.0;//取pivot为（最大值+最小值）/2
            p = head;
            while (p != null) {
                q = p.next;//暂存p.next
                if(p.val <= pivot) {//h1代表小于mid的部分

                    // 还有这种连接链表的操作？
                    p.next = h1;
                    h1 = p;
                }else {
                    p.next = h2;
                    h2 = p;
                }
                p = q;//移动
            }
            h1 = sortList(h1);//对h1部分排序
            h2 = sortList(h2);//对h2部分排序
            p = h1;
            while (p.next!=null)//把两段接上
                p = p.next;
            p.next = h2;
            return h1;
        }
    }

    public static void main(String[] args){

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        Solution_2 solution = new Solution_2();
        solution.sortList(head);
    }
}
