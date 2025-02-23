package A_leetcode.tencent;

import java.util.List;
import java.util.PriorityQueue;

public class No148 {

     static public class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);

        sortList(node);
    }
    public static ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(((o1, o2) -> o1.val-o2.val));

        while (head!=null){
            heap.add(head);
            head=head.next;
        }

        head = heap.poll();
        ListNode cur = head;
        while (!heap.isEmpty()){
            cur.next = heap.poll();
            cur = cur.next;
        }
        cur=null;
        return head;
    }
}
