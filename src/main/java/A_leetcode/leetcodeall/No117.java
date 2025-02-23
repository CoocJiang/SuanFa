package A_leetcode.leetcodeall;

public class No117 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, null, node7, null);
        Node root = new Node(1, node2, node3, null);
        connect(root);
    }
    static  Node [] nods = new Node[6001];
    public static Node connect(Node root) {
        int l = 0;
        int r = 0;
        if (root==null){
            return root;
        }
        nods[r++] = root;
        int size = 0;
        while (l<r){
            size = r-l-1;
            Node cur = nods[l++];
            if (cur.left!=null){
                nods[r++] = cur.left;
            }
            if (cur.right!=null){
                nods[r++] = cur.right;
            }
            while (size>0){
                cur.next = nods[l++];
                cur = cur.next;
                if (cur.left!=null){
                    nods[r++] = cur.left;
                }
                if (cur.right!=null){
                    nods[r++] = cur.right;
                }
                size--;
            }
            cur.next=null;
        }
        return root;
    }


}
