package A_leetcode.面试150;

import java.util.HashMap;

public class No138 {

   static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        // 创建节点
        Node node1 = new Node(-1);

        // 连接节点
        node1.next = null;

        // 设置随机指针
        node1.random = node1;  // 第一个节点的随机指针指向自身// 第二个节点的随机指针指向第一个节点
        copyRandomList(node1);
    }
    public static Node copyRandomList(Node head) {
       if (head==null){
           return null;
       }
        HashMap<Node,Node> nodeHashMap = new HashMap<>();
        Node result = new Node(head.val);
        nodeHashMap.put(head,result);
        if (head.random!=null){
            if (nodeHashMap.containsKey(head.random)){
                result.random = nodeHashMap.get(head.random);
            }else {
                result.random = new Node(head.random.val);
                nodeHashMap.put(head.random,result.random);
            }
        }
        Node cur1 = result;
        Node cur  = head.next;
        while (cur!=null){
            if (nodeHashMap.containsKey(cur)){
                cur1.next = nodeHashMap.get(cur);
            }else {
                cur1.next=new Node(cur.val);
                nodeHashMap.put(cur,cur1.next);
            }
            cur1=cur1.next;
            if (cur.random!=null){
                if (nodeHashMap.containsKey(cur.random)){
                    cur1.random = nodeHashMap.get(cur.random);
                }else {
                    cur1.random = new Node(cur.random.val);
                    nodeHashMap.put(cur.random,cur1.random);
                }
            }
            cur=cur.next;
        }
        return result;
    }
}
