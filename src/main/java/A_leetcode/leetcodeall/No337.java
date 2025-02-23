package A_leetcode.leetcodeall;

import java.util.*;

public class No337 {

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

    static HashMap<TreeNode,Integer> map = new HashMap<>();
    public static int rob(TreeNode root) {
        map = new HashMap<>();
     return process1(root);
    }


    public static int process1(TreeNode root){
    if (map.containsKey(root)){
        return map.get(root);
    }
      int p1 = root.val;
      int p2 = 0;
      //当前有两个选择，打劫当前这家或者不打劫
        if (root.left!=null){
            //打劫的最大值放在p1
            if (root.left.right!=null){
                p1+=process1(root.left.right);
            }
            if (root.left.left!=null){
                p1+=process1(root.left.left);
            }
            //不打劫的最大值放在p2
            p2 += process1(root.left);
        }
        if (root.right!=null){
            if (root.right.right!=null){
                p1+=process1(root.right.right);
            }
            if (root.right.left!=null){
                p1+=process1(root.right.left);
            }
           p2 += process1(root.right);
        }
        int p3 = Math.max(p1,p2);
        map.put(root,p3);
        return p3;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.right=new TreeNode(3);
        root.left.left=new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root));
    }
}
