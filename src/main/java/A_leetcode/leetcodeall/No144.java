package A_leetcode.leetcodeall;

import java.util.ArrayList;
import java.util.List;

public class No144 {


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
    static List<Integer> ans ;
    public static List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Traversal(root);
        return ans;
    }
    public static void Traversal(TreeNode root) {
        ans.add(root.val);
        if(root.left!=null){
            Traversal(root.left);
        }
        if(root.right!=null){
            Traversal(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        preorderTraversal(root);
    }
}
