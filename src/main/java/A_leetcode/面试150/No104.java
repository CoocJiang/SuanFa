package A_leetcode.面试150;

public class No104 {
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
    public static int maxDepth(TreeNode root) {
        return process(root);
    }


    public static int process(TreeNode root){
          if (root==null){
              return 0;
          }
          int l = 0;
          int r = 0;
          l = 1 + process(root.left);
          r = 1 + process(root.right);
          return Math.max(l,r);
    }

}
