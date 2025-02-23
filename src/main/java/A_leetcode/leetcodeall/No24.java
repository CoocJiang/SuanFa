package A_leetcode.leetcodeall;

public class No24 {
 public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newhead = head.next;
        ListNode cur = head; ListNode sed = cur.next;
        cur.next = sed.next;
        sed.next = cur;
        while (cur.next!=null){
           ListNode f1 = cur.next;
           ListNode f2 = f1.next;
           if (f2==null){
               return newhead;
           }
           cur.next = f2;
           f1.next = f2.next;
           f2.next = f1;
           cur = f1;
        }
        return newhead;
    }

    public static void main(String[] args) {
        ListNode node =  new ListNode(1);
        ListNode node2 =  new ListNode(2);
        ListNode node3 =  new ListNode(3);
        ListNode node4 =  new ListNode(4);
        ListNode node5 = new ListNode(5) ;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        swapPairs(node);
    }
}
