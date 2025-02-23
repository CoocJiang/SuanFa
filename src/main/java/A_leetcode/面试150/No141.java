package A_leetcode.面试150;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class No141 {

    class ListNode {
            int val;
            ListNode next;
             ListNode(int x) {
             val = x;
            next = null;
        }
  }
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode cur =head;
        while (!set.contains(cur)){
            set.add(cur);
            if (cur.next==null){
                return false;
            }else {
                cur = cur.next;
            }
        }
        return true;
    }
    ///
    public boolean hasCycle2(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode kuai;
        ListNode man = head;
       do{
           if (man.next!=null){
               man=man.next;
               if (man.next!=null){
                   kuai=man.next;
               }else {
                   return false;
               }
           }else {
               return false;
           }
       }while (kuai!=man);
        return true;
    }
}
