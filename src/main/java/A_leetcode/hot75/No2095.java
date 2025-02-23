package A_leetcode.hot75;

import A_leetcode.面试150.No19;

import java.util.List;

public class No2095 {
 public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode deleteMiddle(ListNode head) {
        ListNode pre = null;
        ListNode next = head;
        ListNode nenext = head.next;
        while (nenext!=null){
            pre = next;
            next = next.next;
            nenext = nenext.next;
            if (nenext!=null){
                nenext = nenext.next;
            }else {
                break;
            }
        }
        if (pre==null){
            return pre;
        }
        pre.next = next.next;
        next.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next=new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);
        oddEvenList(h);
    }
    public static ListNode oddEvenList(ListNode head) {
        ListNode ou = new ListNode();
        ListNode ji = new ListNode();
        ListNode jiHead = ji;
        ListNode ouHead = ou;
        int cnts = 0;
        while (head!=null){
            if (++cnts%2==1){
                ji.next = head;
                ji = ji.next;
            }else {
                ou.next = head;
                ou = ou.next;
            }
            head = head.next;
        }
        ji.next = ouHead.next;
        ou.next = null;
        return jiHead.next;
    }
}
