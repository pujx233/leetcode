package 链表;

/**存在一个按升序排列的链表,给你这个链表的头节点 head ,
 * 请你删除链表中所有存在数字重复情况的节点,只保留原始链表中没有重复出现的数字
 * 返回同样按升序排列的结果链表
 */

/*
* 1.舍得用变量，千万别想着节省变量，否则容易被逻辑绕晕
* 2.head 有可能需要改动时,先增加一个 假head,返回的时候直接取假head.next,这样就不需要为修改head增加一大堆逻辑了
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

    /*由于头节点可能变化，所以要设置一个假head*/

    public class Solution_1 {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null){
                return null;
            }
            int temp;   // 记录重复的节点值
            ListNode dummy = new ListNode(0,head);
            ListNode cur = dummy;
            while (cur.next!=null && cur.next.next!=null){
                if(cur.next.val == cur.next.next.val){
                    temp = cur.next.val;

                    // 注意并列执行存在先后顺序的问题

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

    /*方法二:递归*/

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
