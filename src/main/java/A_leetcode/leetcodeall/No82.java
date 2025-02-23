package A_leetcode.leetcodeall;

public class No82 {

     static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(4);
        ListNode node6 = new ListNode(3, node7);
        ListNode node5 = new ListNode(2, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);
        deleteDuplicates(node1);
        while (node1.next!=null){
            System.out.println(node1.val);
            node1=node1.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(-1,head);
        ListNode cur;
        if(head.next!=null){
           cur = result;
           while (cur.next!=null&&cur.next.next!=null){
               int val = cur.val;
               if (val==cur.next.val){
                   while (cur.next != null && cur.next.val == val) {
                       cur.next = cur.next.next;
                   }
               }else {
                   cur = cur.next;
               }
           }
           return result.next;
        }else{
            return head;
        }
    }
}
