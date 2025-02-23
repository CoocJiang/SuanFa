package A_leetcode.尊享100.BFS.链表;

import java.util.LinkedList;
import java.util.List;

public class No206 {
    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public static void main(String[] args) {
        ListNode r  = new ListNode(1);
        r.next = new ListNode(2);
        r.next.next = new ListNode(3);
        reverseList(r);
    }
    public static ListNode reverseList(ListNode head) {
        if (head==null){
            return head;
        }else {
            ListNode pre =head;
            ListNode cur = head.next;
            head.next = null;
            while (cur!=null){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
