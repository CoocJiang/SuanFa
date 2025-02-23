package A_leetcode.尊享100.BFS.二叉树;


public class No1120 {
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
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(6);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(7);

        root.right.left.left = new TreeNode(0);
        root.right.left.right = new TreeNode(4);
        root.right.right.right = new TreeNode(10);

        root.right.left.right.left = new TreeNode(11);
        root.right.right.right.right = new TreeNode(9);

        root.right.left.right.left.right = new TreeNode(1);
        root.right.right.right.right.right.right = new TreeNode(8);


        System.out.println(maximumAverageSubtree(root));
        // Optional: Add any logic to print or traverse the tree
    }


    public static class result{
        int num;

        public result(int num, double val) {
            this.num = num;
            this.val = val;
        }

        double val;
    }

    static double max = 0;
    public static double maximumAverageSubtree(TreeNode root) {
        max = 0;
        process(root);
        return max;
    }

    private static result process(TreeNode root) {
        result r = null;
        result l = null;
        if (root.left!=null){
           l =  process(root.left);
        }
        if (root.right!=null){
            r =  process(root.right);
        }
        if (r == null && l==null){
            max = Math.max(max,root.val);
            return new result(1,root.val);
        }else if (r==null){
            double newval = (l.val* l.num+root.val)/(l.num+1);
            max = Math.max(newval,max);
            return new result(l.num+1,newval);
        }else if (l==null) {
            double newval = (r.val*r.num+root.val)/(r.num+1);
            max = Math.max(newval,max);
            return new result(r.num+1,newval);
        }else {
            double newval = (l.val*l.num+root.val+r.val*r.num)/(l.num+1+r.num);
            max = Math.max(newval,max);
            return new result(r.num+1+l.num,newval);
        }
    }
}
