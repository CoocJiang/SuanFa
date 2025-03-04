package A_leetcode.leetcodeall;

public class No876 {




  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode middleNode(ListNode head) {
        ListNode fast  = head;
        ListNode slow  = head;
        while(fast!=null){
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        middleNode(head);
    }
}
