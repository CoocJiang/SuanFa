package A_leetcode.尊享100.BFS.链表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class No708 {

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two  = new Node(3);
        Node th  = new Node(5);
        one.next = two;
        two.next = th;
        th.next = one;
        insert(one,0);
    }

    public static Node insert(Node head, int insertVal) {
        if (head==null){
            Node ans =  new Node(insertVal);
            ans.next = ans;
            return ans;
        }else {
            Node pre = head;
            Node end = pre.next;
            Node max = head;
            boolean flag = true;
            while (!(insertVal<=end.val&&insertVal>=pre.val)){
                if (pre.val > end.val){
                    max = pre;
                }
                if (end==head){
                    flag = false;
                    break;
                }
              pre = end;
              end = end.next;
            }
            if (flag){
                pre.next = new Node(insertVal);
                pre.next.next = end;
            }else {
                Node p = max.next;
                max.next = new Node(insertVal);
                max.next.next = p;
            }
            return head;
        }
    }
}
