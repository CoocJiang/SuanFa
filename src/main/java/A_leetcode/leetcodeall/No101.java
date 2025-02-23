package A_leetcode.leetcodeall;

public class No101 {
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

        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.right = new TreeNode(2);
        r.left.left = new TreeNode(3);


    }
       


}
