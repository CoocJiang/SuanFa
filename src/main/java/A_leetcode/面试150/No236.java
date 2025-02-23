package A_leetcode.面试150;

import A_leetcode.leetcodeall.No102;

import java.util.*;

public class No236 {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   static TreeNode [] result = new TreeNode[100000];

    static  int right;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            right = 0;
          List<TreeNode> list = new ArrayList<>();
          getlist(root,p,list);

          getlist1(root,q,list,result);
          return result[0];
    }

    public static boolean getlist(TreeNode root,TreeNode node,List<TreeNode> list){
         if (root==null){
             return false;
         }else {
             if (root==node){
                 list.add(root);
                 return true;
             }else {
                 if (getlist(root.right,node,list)){
                     list.add(root);
                     return true;
                 }
                 if (getlist(root.left,node,list)){
                     list.add(root);
                     return true;
                 }
                 return false;
             }
         }
    }
    public static boolean  getlist1(TreeNode root, TreeNode node, List<TreeNode> list, TreeNode[] result){
          if (root==null){
              return false;
          }else {
              if (root==node){
                  if (list.contains(root)){
                      result[right++]=root;
                  }
                  return true;
              }
              if (getlist1(root.right,node,list,result)){
                 if (list.contains(root)){
                     result[right++]=root;
                 }
                 return true;
              }
              if (getlist1(root.left,node,list,result)){
                  if (list.contains(root)){
                      result[right++]=root;
                  }
                  return true;
              }
              return false;
          }
    }

    //从根节点开始，假设如果其中一个目标是root直接返回root
    //不是就向下遍历，当left或者right为null就说明有一边没找到，就说明他们存在在与root的某一边
    //把这一边当作root继续遍历

    public static TreeNode process(TreeNode root,TreeNode p,TreeNode q){
        if (root==null||root== p||root==q){
            return root;
        }

        TreeNode right = process(root.right,p,q);
        TreeNode left = process(root.left,p,q);

        if (right==null){
            return left;
        }
        if (left==null){
            return right;
        }
        return root;
    }
}
