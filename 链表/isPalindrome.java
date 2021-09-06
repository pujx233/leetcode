package 链表;

/**
 * 给你一个单链表的头节点 head,请你判断该链表是否为回文链表
 * 如果是返回 true;否则返回 false
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
     * 链表也存在后序遍历,考虑用递归法解决
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
     * 快慢指针
     * */

    class Solution_2 {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            // 找到前半部分链表的尾节点并反转后半部分链表
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);

            // 判断是否回文
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

            // 还原链表并返回结果
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
