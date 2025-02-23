package A_leetcode.面试150;

public class No100 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        return process(p,q);
    }

    public static boolean process(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }else if(p==null&&q!=null){
            return false;
        }else if(p!=null&&q==null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }

        boolean p1 = process(p.left,q.left);
        boolean p2 =process(p.right,q.right);

        if (p1==false||p2==false){
            return false;
        }else {
            return true;
        }
    }
}
