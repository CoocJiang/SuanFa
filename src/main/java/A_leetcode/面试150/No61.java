package A_leetcode.面试150;

import java.util.*;

public class No61 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null||k==0){
            return head;
        }

        ListNode result = new ListNode(-100);
        result.next = head;

        ListNode cur  =head;

        HashMap<Integer,ListNode> map = new HashMap<>();

        int length = 1;
        while (cur.next!=null){
           map.put(length,cur);
           cur=cur.next;
           length++;
        }


        while (k>(length)){
            k = k % (length);
        }

        if(length==k||length==0){
            return head;
        }

        //经过循环之后，此时cur来到末尾,将尾节点指向头节点
        cur.next=result.next;

        cur=map.get(length-k);

        result.next=cur.next;

        cur.next=null;
        return result.next;
    }


    public static void main(String[] args) {
        // 逐个创建节点并手动连接

        ListNode node1 = new ListNode();
        node1.val = 1;

        // 设置头节点
        ListNode head = node1;
        rotateRight(head,99);

    }
}
