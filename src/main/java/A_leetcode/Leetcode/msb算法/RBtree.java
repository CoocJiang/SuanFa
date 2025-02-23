package A_leetcode.Leetcode.msb算法;

public class RBtree {
    public static final boolean BLACK = true;
    public static final boolean red = false;

    public RNode root;

    public RBtree(RNode root) {
        this.root = root;
    }

    public RNode getRoot() {
        return root;
    }

    public void setRoot(RNode root) {
        this.root = root;
    }

    static class RNode<K extends Comparable,V>{
        private RNode parent;
        private RNode left;
        private RNode right;
        private boolean clolor;

        private K key;
        private V value;


        public RNode(RNode left, RNode right, boolean clolor, K key, V value) {
            this.left = left;
            this.right = right;
            this.clolor = clolor;
            this.key = key;
            this.value = value;
        }

        public RNode() {

        }

        public RNode(RNode parent, RNode left, RNode right, boolean clolor, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.clolor = clolor;
            this.key = key;
            this.value = value;
        }
    }

    public RBtree() {
    }

    //左旋操作
    public void leftRotate(RNode p){
        if (p != null){
            if (p.right!=null){
                p.right.parent=p.parent;
                if (p.parent==null){
                    this.root=p.right;
                }
                p.right=p.right.left;
                if (p.right.left!=null){
                    p.right.left.parent=p;
                }
                if (p.parent.left==p){
                    p.parent.left=p.right;
                }else {
                    p.parent.right=p.right;
                }
                p.right.left=p;
                p.parent=p.right;
            }
        }
    }
    //右边旋转操作
    public void rightRotate(RNode p){
        if (p!=null){
            if (p.left!=null){
                p.left.parent=p.parent;
                if (p.parent==null){
                    this.root=p.left;
                }
                p.left = p.left.right;
                if (p.left.right!=null){
                    p.left.right.parent=p;
                }
                if (p.parent.left==p){
                    p.parent.left=p.left;
                }else {
                    p.parent.right=p.left;
                }
                p.parent=p.left;
                p.left.right=p;
            }
        }
    }
    //新增节点
    public void put(){

    }


}
