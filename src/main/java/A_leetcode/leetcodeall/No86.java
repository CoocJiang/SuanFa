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

    public static void main(String[] args) {

    }

    public static ListNode partition2(ListNode head, int x) {
        ListNode gt = new ListNode();
        ListNode lt = new ListNode();
        ListNode p = gt;
        ListNode q = lt;
        while (head!=null){
            if (head.val<x){
                lt.next = head;
                lt = lt.next;
            }else {
                gt.next = head;
                gt = gt.next;
            }
            head = head.next;
        }
        gt.next = null;
        lt.next = p.next;
        return q.next;
    }
}
