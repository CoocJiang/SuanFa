package A_leetcode.pdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No143 {

    public static void main(String[] args) {
//        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        reorderList(head);
    }
      static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void reorderList(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        ListNode last;
        while (cur!=null&&cur!=stack.peek()){
            if (cur.next==stack.peek()){
                stack.pop().next=null;
                return;
            }
            ListNode cur1 =  cur.next;
            last = stack.pop();
            cur.next = last;
            last.next = cur1;
            cur = cur1;
        }
        cur.next = null;
    }
}
