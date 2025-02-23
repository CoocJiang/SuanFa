package tencentTest1;

import java.util.*;

public class test2 {

    static public class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }

    public static void main(String[] args) {
        ListNode a =new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(3);
        a.next.next.next.next = new ListNode(4);
        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        b.next.next = new ListNode(1);
        b.next.next.next = new ListNode(2);
        b.next.next.next.next = new ListNode(3);
        b.next.next.next.next.next = a.next.next.next;
        mergeList(a,b);
        System.out.println(a.next);
    }
    public static ListNode mergeList (ListNode a, ListNode b) {
        // write code here

        ListNode first = null;
        ListNode second = null;

        ListNode p = a;
        ListNode q = b;
        int sizea = 0;
        while (p.val==q.val){
            first = p;
            p = p.next;
            q = q.next;
            sizea++;
        }
        Stack<ListNode> stacka = new Stack<>();
        Stack<ListNode> stackb =  new Stack<>();
        while (p!=null||q!=null){
            if (p!=null){
                stacka.push(p);
                p = p.next;
            }
            if (q!=null){
                stackb.push(q);
                q = q.next;
            }
        }
        while (!stackb.isEmpty()&& !stacka.isEmpty()){
            if (stackb.peek().val==stacka.peek().val){
                second = stacka.pop();
                stackb.pop();
            }else {
                break;
            }
        }
        first.next = second;
        return a;
    }
}
//        int cha = 0;
//        p = a;
//        q = b;
//        if (sizeb>sizea){
//            cha = sizeb-sizea;
//            for (int i = 0;i<cha;i++){
//                q = q.next;
//            }
//            while (q!=p){
//                q = q.next;
//                p = p.next;
//            }
//            second = q;
//        }else {
//            cha = sizea-sizeb;
//            for (int i = 0;i<cha;i++){
//                p = p.next;
//            }
//            while (q!=p){
//                q = q.next;
//                p = p.next;
//            }
//            second = q;
//        }