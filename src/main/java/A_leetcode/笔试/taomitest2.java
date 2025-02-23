package A_leetcode.笔试;

public class taomitest2 {



 public static class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }

    public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        // write code here
        int sum = 0;
        int a1 = 0;
        int a2 = 0;
        int ans = 0;
        ListNode resulthead = null;
        int mod = 0;
        if (l1 != null || l2 != null) {
            if (l1 == null) {
                a1 = 0;
            } else {
                a1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) {
                a2 = 0;
            } else {
                a2 = l2.val;
                l2 = l2.next;
            }
            sum = a1 + a2;
            mod = sum / 10;
            ans = sum % 10;
            resulthead = new ListNode(ans);
        }
        ListNode cur = resulthead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                a1 = 0;
            } else {
                a1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) {
                a2 = 0;
            } else {
                a2 = l2.val;
                l2 = l2.next;
            }
            sum = a1 + a2+mod;
            ans = sum % 10;
            cur.next = new ListNode(ans);
            cur = cur.next;
            mod = sum / 10;
        }
        if (mod!=0){
            cur.next = new ListNode(mod);
        }
        return resulthead;
    }
}
