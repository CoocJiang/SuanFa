package A_leetcode.leetcodeall;

public class No1373 {

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);

        root.left.left.left = null;
        root.left.left.right = null;
        root.left.right.left = null;
        root.left.right.right = null;

        root.right.left.left = null;
        root.right.left.right = null;
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        root.right.right.left.left = null;
        root.right.right.left.right = null;
        root.right.right.right.left = null;
        root.right.right.right.right = null;

        System.out.println(maxSumBST(root));
    }
    public static class result{
        boolean is;
        int allsum;
        int max;
        int min;

        public result(boolean is, int allsum, int max, int min) {
            this.is = is;
            this.allsum = allsum;
            this.max = max;
            this.min = min;
        }
    }

    static int Max = Integer.MIN_VALUE;
    public static int maxSumBST(TreeNode root) {
        Max = 0;
        process(root);
        return Max;
    }

    private static result process(TreeNode root) {
        if (root == null) {
            return new result(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {
            result l = process(root.left);
            result r = process(root.right);
            if (l.is&&r.is&&l.max<root.val&&r.min>root.val){
                //此时是一颗bst树
                int newvalue = root.val+l.allsum+r.allsum;
                Max = Math.max(newvalue,Max);
                return new result(true,newvalue,Math.max(r.max,root.val),Math.min(l.min,root.val));
            }else {
                return l.is ? r.is ? new result(false,0,0,0):r:l;
            }
        }
    }
}
