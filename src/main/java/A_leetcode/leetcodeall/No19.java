package A_leetcode.leetcodeall;

import java.util.List;

public class No19 {

   static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        removeNthFromEnd1(node,2);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakehead = new ListNode();
        fakehead.next = head;
        ListNode p1 = fakehead;
        for(int i = 0;i<=n;i++){
            p1 = p1.next;
        }
        ListNode p2 = fakehead;
        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return fakehead.next;
    }


    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode result = new ListNode(0, head);
        ListNode fast = result;
        ListNode slow = result;
        while (n>0){
            fast = fast.next;
            n--;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return result.next;
    }
}
