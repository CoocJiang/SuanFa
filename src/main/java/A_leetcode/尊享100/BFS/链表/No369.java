package A_leetcode.尊享100.BFS.链表;

import java.util.Deque;
import java.util.LinkedList;

public class No369 {


      static public class ListNode {     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public static void main(String[] args) {
        plusOne(new ListNode(9));
    }

    public static ListNode plusOne(ListNode head) {
        ListNode cur = head;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        boolean flag = true;
        while (flag){
            if (!stack.isEmpty()){
                cur = stack.poll();
            }else {
                ListNode p = cur;
                cur = new ListNode(1);
                cur.next = p;
                return cur;
            }
            if (++cur.val<10){
                flag = false;
            }else {
                cur.val = cur.val-10;
            }
        }
        return head;
    }
}
