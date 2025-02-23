package A_leetcode.面试150;

import A_leetcode.笔试.保融;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No98 {



     public static class TreeNode {
      int val;
      TreeNode left;TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }



//     static  boolean flag;
//     static Long pre;
//    public static boolean isValidBST(TreeNode root) {
//        flag = true;
//         pre = Long.MIN_VALUE;
//        process(root);
//        return flag;
//    }
//
//    public static void process(TreeNode root){
//        if (root.left!=null){
//            process(root.left);
//        }
//        if (pre!=Long.MIN_VALUE){
//            if (root.val<=pre){
//                flag=false;
//                return;
//            }
//        }
//        pre = Long.valueOf(root.val);
//        if (root.right!=null){
//            process(root.right);
//        }
//    }
    public static boolean isValidBST(TreeNode root) {
        return dfs(root,null,null);
    }

    public static boolean dfs(TreeNode root, TreeNode min, TreeNode max) {
         if (root==null){
             return true;
         }else {
             if (min!=null&&root.val<=min.val) return false;
             if (max!=null&&root.val>=max.val) return false;
             return dfs(root.left, max, root)&&dfs(root.right,root,min);
         }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        System.out.println(isValidBST(root));
    }
}
