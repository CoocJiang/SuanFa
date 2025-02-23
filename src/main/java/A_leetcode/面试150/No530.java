package A_leetcode.面试150;

public class No530 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static Integer min = Integer.MAX_VALUE;
    static Integer pre = -1;
    public static int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = -1;
        process(root);
        return min;
    }

    public static void process(TreeNode root){
        if (root.left!=null){
            process(root.left);
        }
        if (pre>=0){
            min = Math.min(min,Math.abs(root.val-pre));
        }
        pre = root.val;
        if (root.right!=null){
            process(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(236);
        root.left= new TreeNode(104);
        root.right = new TreeNode(701);
        root.left.right= new TreeNode(227);
//        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(911);
        System.out.println(getMinimumDifference(root));
    }
}
