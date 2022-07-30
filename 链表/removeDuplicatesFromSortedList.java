package 链表;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素只出现一次 。
 * 返回同样按升序排列的结果链表
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

    /*方法一*/

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
