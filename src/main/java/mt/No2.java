package mt;

import java.util.ArrayList;
import java.util.List;

public class No2 {
   static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
       ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        // 创建链表 l1
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // 创建链表 l2
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers(l1,l2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> values = new ArrayList<>();
        int next = 0;
        while (l1!=null||l2!=null||next>0){
            int value = next;
            if (l2!=null&&l1==null){
                value += l2.val;
                l2 = l2.next;
            }else if (l1!=null&&l2==null){
                value += l1.val;
                l1 = l1.next;
            }else if(l1!=null&&l2!=null){
                value += l1.val+l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (value>=10){
                value = value%10;
                next = 1;
            }else {
                next = 0;
            }
            values.add(new ListNode(value));
        }
        ListNode head;
        ListNode node = values.get(0);
        head = node;
        for (int i =1;i<values.size();i++){
            node.next = values.get(i);
            node = node.next;
        }
        return head;
    }
}
