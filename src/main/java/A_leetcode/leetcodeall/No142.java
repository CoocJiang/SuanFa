package A_leetcode.leetcodeall;

public class No142 {
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=slow){
            fast = fast.next;
            if(fast==null){
                return null;
            }else{
                fast = fast.next;
            }
            slow = slow.next;
        }
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
