package 链表;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
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
     * 递归
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
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素
     * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点
     * 不要忘记在最后返回新的头引用
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