package A_leetcode.leetcodeall;

public class No510 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };



    public static Node inorderSuccessor(Node node) {
        Node cur = node;
        if (node.right!=null){
            return getmin(node.right);
        }else{
            if (node.parent!=null){
                if (node.parent.left==cur) {
                    return node.parent;
                } else if (node.parent.right == node) {
                    while (node.parent != null) {
                        node = node.parent;
                        if (node.val < cur.val) {
                            if (node.right != null) {
                                Node re = getmin(node.right);
                                if (re.val > cur.val) {
                                    return re;
                                }
                            }
                        } else {
                            return node;
                        }
                    }
                }
            }
            return null;
        }
    }
    private static Node getmin(Node node) {
        while (node.left!=null){
            node = node.left;
        }
        return node;
    }
}
