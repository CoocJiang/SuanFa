package A_leetcode.面试150;

public class No2 {

    static   public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

       addTwoNumbers(l1,l2);
    }

    // 辅助方法：打印链表
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = l1;
        ListNode cur2 = l2;
        int sum;
        boolean flag = false;
        if (cur2.val+ cur.val>=10) {
            flag=true;
            sum = cur.val+cur2.val-10;
        }else {
            sum = cur.val+cur2.val;
        }
        ListNode ans = new ListNode(sum);
        ListNode result = ans;
        cur2=cur2.next;
        cur=cur.next;
        while (cur2!=null||cur!=null||flag){
            if (flag==true){
                sum = 1;
            }else {
                sum = 0;
            }
            if (cur2!=null){
                sum+=cur2.val;
                cur2=cur2.next;
            }
            if (cur!=null){
                sum+=cur.val;
                cur=cur.next;
            }
            if (sum>=10){
                flag=true;
                sum = sum-10;
            }else {
                flag = false;
            }
            ans.next = new ListNode(sum);
            ans = ans.next;
        }
        return result;
    }
}
