package A_leetcode.面试150;

import java.util.*;

public class No19 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
  }



      public static ListNode removeNthFromEnd(ListNode head, int n) {
            if (head==null){
                  return head;
            }
            Deque<ListNode> stack = new LinkedList<ListNode>();
            ListNode cur = head;
            while (cur!=null){
                  stack.push(cur);
                  cur=cur.next;
            }
            if (stack.size()==n){
                  ListNode result = head.next;
                  head.next=null;
                  return result;
            }else {
                  ListNode you=null ;
                  for (int i =1;i<n;i++){
                        you = stack.pop();
                  }
                  ListNode goal = stack.pop();
                  ListNode zuo = stack.pop();
                  goal.next=null;
                  zuo.next = you;
                  return head;
            }
      }



}
