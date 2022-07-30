package ����;

import java.util.HashSet;
import java.util.Set;

/**
 * ����һ�������ж��������Ƿ��л���
 * �����������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ��� Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���ע�⣺pos ����Ϊ�������д��ݣ�������Ϊ�˱�ʶ�����ʵ�������
 * ��������д��ڻ����򷵻� true �� ���򣬷��� false ��
 * **/

public class linklistCycle {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    /**
     * ����һ����ϣ��
     * if (!seen.add(head)) �ж��Ƿ��ڴ��ڹ�ϣ����
     * **/
    public class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> seen = new HashSet<ListNode>();
            while(head!=null){
                if (!seen.add(head)) {
                    return true;
                }
                head = head.next;
            }
            return false;
        }
    }


    /**
     * ������������ָ��
     * */

    public class Solution_2 {
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null){
                return false;
            }

            ListNode slow = head;
            ListNode fast = head.next;

            while(slow!=fast){
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }

            return true;
        }
    }
}
