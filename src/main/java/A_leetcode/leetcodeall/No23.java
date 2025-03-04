package A_leetcode.leetcodeall;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class No23 {
    public static void main(String[] args) {
        // 创建链表1: 1 -> 4 -> 5
        ListNode list1 = new ListNode(5);
        list1 = new ListNode(4, list1);
        list1 = new ListNode(1, list1);

        // 创建链表2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(4);
        list2 = new ListNode(3, list2);
        list2 = new ListNode(1, list2);

        // 创建链表3: 2 -> 6
        ListNode list3 = new ListNode(6);
        list3 = new ListNode(2, list3);


        ListNode [] listNodes = {list1,list2,list3};

        System.out.println(mergeKLists1(listNodes));
    }

     static   public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode mergeKLists(ListNode[] lists) {
         if (lists.length==0){
             return null;
         }
         //建立小根堆
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);

        for (ListNode node:lists){
            if (node==null){
                continue;
            }
            minHeap.add(node);
        }
        ListNode head = minHeap.poll();
        if (head==null){
            return null;
        }
        //使用cur节点来代替头节点从堆里面遍历
        ListNode cur = head;
        if (head.next!=null){
            minHeap.add(head.next);
        }
        while (!minHeap.isEmpty()){
           cur.next = minHeap.poll();
           cur = cur.next;
           if (cur.next!=null){
               minHeap.add(cur.next);
           }
        }
         return head;
    }

    public static ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);
        for (ListNode node:lists){
            while (node!=null){
                minHeap.add(node);
                node = node.next;
            }
        }
        ListNode result = new ListNode();
        ListNode head = result;
        while (!minHeap.isEmpty()){
            result.next = minHeap.poll();
            result=result.next;
        }
        result.next = null;
        return head.next;
    }


}
