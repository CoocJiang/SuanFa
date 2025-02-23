package A_leetcode.leetcodeall;

import java.util.List;

public class No86 {

     static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode partition(ListNode head, int x) {
        ListNode xiao = new ListNode();
        ListNode da = new ListNode();
        ListNode p =xiao;
        ListNode q = da;
        while (head!=null){
            if (head.val<x){
                p.next = head;
                p = p.next;
            }else{
                q.next = head;
                q = q.next;
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        p.next = da.next;
        return xiao.next;
    }
}
