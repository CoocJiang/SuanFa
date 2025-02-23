package A_leetcode.面试150;

import java.util.ArrayList;
import java.util.List;

public class No117 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public static Node connect(Node root) {
        List<Node> list = new ArrayList<>();
        list.add(root);
        process(list);
        return root;
    }

    public static void  process(List<Node> list) {
        //传来n层的节点集合，我们把n+1层的节点串联好
        if (list.size()==0){
            return;
        }
        List<Node> child = new ArrayList<>();
        Node cur = null;
        for (Node node:list){
           if (node.left!=null){
               if (cur==null){
                   cur = node.left;
                   child.add(cur);
               }else {
                   cur.next = node.left;
                   cur = cur.next;
                   child.add(cur);
               }
           } if (node.right!=null) {
               if (cur==null){
                   cur = node.right;
                   child.add(cur);
               }else {
                   cur.next = node.right;
                   cur = cur.next;
                   child.add(cur);
               }
           }
        }
        if (cur!=null){
            cur.next=null;
        }
        process(child);
    }

    public static void main(String[] args) {
        Node root4 = new Node(4,null,null,null);
        Node root5 = new Node(5,null,null,null);
        Node root2 = new Node(2,root4,root5,null);
        Node root7 = new Node(7,null,null,null);
        Node root3 = new Node(3,null,root7,null);
        Node ropt = new Node(1,root2,root3,null);
        connect(root2);
    }
}
