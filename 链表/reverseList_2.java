package 链表;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
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
     * 1、我们定义两个指针，分别称之为 g(guard 守卫) 和 p(point)。
     * 我们首先根据方法的参数 m 确定 g 和 p 的位置。将 g 移动到第一个要反转的节点的前面，将 p 移动到第一个要反转的节点的位置上。我们以 m=2，n=4为例。
     * 2、将 p 后面的元素删除，然后添加到 g 的后面。也即头插法。
     * 3、根据 m 和 n 重复步骤（2）
     * 4、返回 dummyHead.next
     * */

    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode g = dummyHead;
            ListNode p = dummyHead.next;

            // 将指针移到相应的位置
            for(int step = 0; step < m - 1; step++) {
                g = g.next; p = p.next;
            }

            // 头插法插入节点
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
     * 递归
     * 反转前N个链表
     * */

    class Solution_2 {
        public ListNode reverseBetween(ListNode head, int m, int n) {

            if (m == 1) {
                return reverseN(head, n);
            }
            // 前进到反转的起点触发 base case
            head.next = reverseBetween(head.next, m - 1, n - 1);
            return head;
        }

        ListNode successor = null; // 后驱节点

        // 反转以 head 为起点的 n 个节点，返回新的头结点
        ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                // 记录第 n + 1 个节点
                successor = head.next;
                return head;
            }
            // 以 head.next 为起点，需要反转前 n - 1 个节点
            ListNode last = reverseN(head.next, n - 1);

            head.next.next = head;
            // 让反转之后的 head 节点和后面的节点连起来
            head.next = successor;
            return last;
        }
    }
}
