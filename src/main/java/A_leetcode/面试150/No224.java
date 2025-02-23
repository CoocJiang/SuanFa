package A_leetcode.面试150;

public class No224 {
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


    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        process(root);
        return root;
    }

    public static void process(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        TreeNode temp = treeNode.left;
        treeNode.left =  treeNode.right;
        treeNode.right = temp ;
        process(treeNode.left);
        process(treeNode.right);
    }

}
