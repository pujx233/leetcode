package 链表;

import java.util.LinkedList;

/* 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
*
* 其实递归就是程序内部维护了一个栈。这个题就是每次都把最小值压入栈，最后出栈的时候，将所有数连
* 在一起就可以了。说白了，就是用一个栈维护了顺序。最后的连接，当然是小的连小的，所以l1 小，就连
* 到 l1,l2 小就连到 l2，最后先返回的，就是最小的头结点。
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

    /*方法一*/

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


    /*方法二*/

    public class Solution_2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 使用带头结点的链表解决问题
            // 待输出链表的头部

            /*其实没必要这么麻烦，应当先判断l1,l2两个链表头部的最小值，作为新链表的头部，然后循环迭代输出即可
            * */
            ListNode head = new ListNode();
            ListNode last = head;

            while(l1!=null && l2!=null){
                if(l1.val>l2.val){
                    last.next = l2;
                    l2 = l2.next;
                }
                else{
                    last.next = l1;
                    l1 = l1.next;
                }
                last = last.next;
            }

            if(l1 != null) last.next = l1;
            if(l2 != null) last.next = l2;

            return head.next;
        }

    }

}
