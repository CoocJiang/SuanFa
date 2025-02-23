package A_leetcode.leetcodeall;

import java.util.*;

public class LCR_077 {
    public static class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(1);
        sortList(root);
        System.out.println(root);
    }


    public static ListNode sortList1(ListNode head) {
        if (head==null){
            return head;
        }
        List<Integer> nums  = new ArrayList<>();
        ListNode cur = head;
        while (cur!=null){
            nums.add(cur.val);
            cur=cur.next;
        }
        cur = head;
        Collections.sort(nums);
        int i=0;
        while (cur!=null){
            cur.val=nums.get(i);
            cur=cur.next;
            i++;
        }
        return head;
    }


    public static ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
               return o1.val- o2.val;
            }
        });
        ListNode cur = head;
        while (cur!=null){
            heap.add(cur);
            cur = cur.next;
        }

        ListNode anshead = heap.poll();
        cur = anshead;
        while (!heap.isEmpty()){
           cur.next = heap.poll();
           cur = cur.next;
        }
        cur.next=null;
        return anshead;
    }
}
