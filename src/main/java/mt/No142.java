package mt;

import java.util.HashSet;
import java.util.Set;

public class No142 {



  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
         next = null;
      }
 }
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head!=null){
            if (!set.contains(head)){
                set.add(head);
            }else {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
